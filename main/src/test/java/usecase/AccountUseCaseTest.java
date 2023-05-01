package usecase;

import com.pismo.account.entity.AccountEntity;
import com.pismo.account.repository.AccountRepository;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class AccountUseCaseTest {
    @Inject
    private RequestSpecification specification;

    @Inject
    private AccountRepository accountRepository;

    @Test
    public void creatingNewAccount() {
        Map<String, String> payload = Map.of("documentNumber", "34349566899");

        specification
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post("/accounts")
            .then()
            .statusCode(201);


        AccountEntity account = accountRepository.findByDocumentNumber("34349566899");

        Assertions.assertAll(
            () -> Assertions.assertNotNull(account),
            () -> Assertions.assertEquals(account.getBalance().getBalance(), BigDecimal.ZERO.movePointLeft(2))
        );
    }

    @Test
    public void givenAnExistingDocumentNumberShouldBeStatusCodeUnprocessableEntity() {
        Map<String, String> payload = Map.of("documentNumber", "34349566898");

        specification
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post("/accounts")
            .then()
            .statusCode(201);

        specification
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post("/accounts")
            .then()
            .statusCode(422);

        AccountEntity account = accountRepository.findByDocumentNumber("34349566898");

        accountRepository.findAll();

        Assertions.assertAll(
            () -> Assertions.assertNotNull(account),
            () -> Assertions.assertEquals(account.getBalance().getBalance(), BigDecimal.ZERO.movePointLeft(2))
        );
    }

    @Test
    public void givenBlankDocumentNumberShouldBeStatusCodeUnprocessableEntity() {
        Map<String, String> payload = Map.of("documentNumber", "");

        specification
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post("/accounts")
            .then()
            .statusCode(400);
    }

    @Test
    public void givenWrongDocumentNumberShouldBeStatusCodeNotFound() {
        specification
            .when()
            .get("/accounts/4")
            .then()
            .statusCode(404);
    }
}
