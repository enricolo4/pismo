package usecase;

import com.pismo.account.entity.AccountEntity;
import com.pismo.account.repository.AccountRepository;
import com.pismo.balance.entity.BalanceEntity;
import com.pismo.balance.repository.BalanceRepository;
import com.pismo.transaction.entity.TransactionEntity;
import com.pismo.transaction.repository.TransactionRepository;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateTransactionUseCaseTest {
    @Inject
    private RequestSpecification specification;

    @Inject
    private AccountRepository accountRepository;

    @Inject
    private TransactionRepository transactionRepository;

    @Inject
    private BalanceRepository balanceRepository;

    private String documentNumber = "34349566877";
    private AccountEntity accountEntity;

    private Response post(Map<String, ?> payload, String url) {
        return specification
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post(url);

    }

    @BeforeAll
    @Transactional
    void setup() {
        Map<String, String> payload = Map.of("documentNumber", "34349566877");

        post(payload, "/accounts")
            .then()
            .statusCode(201);

        accountEntity = accountRepository.findByDocumentNumber("34349566877");
    }

    @Test
    public void creatingBuyTheCashTransaction() {
        Map<String, ?> transactionPayload = Map.of(
            "accountId", accountEntity.getId(),
            "operationTypeId", 1,
            "amount", BigDecimal.valueOf(22.5)
        );

        post(transactionPayload, "/transactions")
            .then()
            .statusCode(201);

        List<TransactionEntity> transactionEntityList = transactionRepository
            .findByAccountId(accountEntity.getId())
            .stream()
            .filter(transactionEntity -> transactionEntity.getOperationType() == 1L)
            .toList();

        Assertions.assertAll(
            () -> Assertions.assertFalse(transactionEntityList.isEmpty()),
            () -> Assertions.assertEquals(BigDecimal.valueOf(-22.5).setScale(2, RoundingMode.HALF_UP), transactionEntityList.get(0).getAmount())
        );
    }

    @Test
    public void givenCashOutOperationWithZeroBalanceShouldBeUnprocessableEntity() {
        Map<String, ?> transactionPayload = Map.of(
            "accountId", accountEntity.getId(),
            "operationTypeId", 3,
            "amount", BigDecimal.valueOf(22.5)
        );

        post(transactionPayload, "/transactions")
            .then()
            .statusCode(422);
    }

    @Test
    public void creatingPaymentTransaction() {
        Map<String, ?> transactionPayload = Map.of(
            "accountId", accountEntity.getId(),
            "operationTypeId", 4,
            "amount", BigDecimal.valueOf(22.5)
        );

        post(transactionPayload, "/transactions")
            .then()
            .statusCode(201);

        List<TransactionEntity> transactionEntityList = transactionRepository
            .findByAccountId(accountEntity.getId())
            .stream()
            .filter(transactionEntity -> transactionEntity.getOperationType() == 4L)
            .toList();

        AccountEntity updatedAccount = accountRepository.findByDocumentNumber(documentNumber);
        BalanceEntity balanceEntity = updatedAccount.getBalance();

        Assertions.assertAll(
            () -> Assertions.assertFalse(transactionEntityList.isEmpty()),
            () -> Assertions.assertEquals(BigDecimal.valueOf(22.5).setScale(2, RoundingMode.HALF_UP), transactionEntityList.get(0).getAmount()),
            () -> Assertions.assertEquals(BigDecimal.valueOf(22.5).setScale(2, RoundingMode.HALF_UP), balanceEntity.getBalance())
        );
    }

    @Test
    @Transactional
    public void creatingCashOutTransaction() {
        String documentNumber = "34349566876";
        Map<String, String> payload = Map.of("documentNumber", documentNumber);

        post(payload, "/accounts")
            .then()
            .statusCode(201);

        AccountEntity accountEntity = accountRepository.findByDocumentNumber(documentNumber);

        Map<String, ?> transactionPayload = Map.of(
            "accountId", accountEntity.getId(),
            "operationTypeId", 4,
            "amount", BigDecimal.valueOf(22.5)
        );

        post(transactionPayload, "/transactions")
            .then()
            .statusCode(201);

        Map<String, ?> cashOutPayload = Map.of(
            "accountId", accountEntity.getId(),
            "operationTypeId", 3,
            "amount", BigDecimal.valueOf(22.5)
        );

        post(cashOutPayload, "/transactions")
            .then()
            .statusCode(201);

        List<TransactionEntity> transactionEntityList = transactionRepository
            .findByAccountId(accountEntity.getId())
            .stream()
            .filter(transactionEntity -> transactionEntity.getOperationType() == 3L)
            .toList();

        BalanceEntity withoutBalance = accountRepository.findByDocumentNumber(documentNumber).getBalance();

        Assertions.assertAll(
            () -> Assertions.assertFalse(transactionEntityList.isEmpty()),
            () -> Assertions.assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), withoutBalance.getBalance())
        );
    }
}
