# Pismo Challenge

# Tecnologias

- Java 17
- Micronaut Framework
- Docker
- Persistência com H2 em memória

- A aplicação é escrita utilizando a arquitetura hexagonal, nesse todas as camadas conhecem a camada do Domain, porém a 
mesma não conhece as outras camadas, e suas comunicações são todas feitas por interfaces. 
  - Primary é onde ficam as requisições feitas para a aplicação, nesse caso é onde fica a cama rest
  - Secondary é onde ficam as requisação feitas pela aplicação, nesse caso é onde fica a camada de persistência
  - Domain é onde ficam todas as regras de negócio
  - Main é onde fica toda a configuração e o main para que a aplicação possa ser executada

# Execução da aplicação

- Dentro da raíz do projeto executar o comando ``docker-compose up``

# Endpoints

## Crição de conta

### Post (http://localhost:8080/accounts)

- Request

```json
{
  "documentNumber": "34349566894"
}
```

- Response

```json
{
  "id": 1,
  "documentNumber": "34349566894",
  "balance": 0
}
```

## Crição de conta

### Get por account id (http://localhost:8080/accounts/{id})
- Response
```json
{
	"id": 1,
	"documentNumber": "34349566894",
	"balance": 0.00
}
```

## Criação de transação
### Post (http://localhost:8080/transactions)

- Request
```json
{
  "accountId": 1,
  "operationTypeId": 1,
  "amount": 22.5,
  "totalInstallment": 2
}
```

- Response
```json
{
	"id": 3,
	"accountId": 1,
	"operationTypeId": 2,
	"amount": -22.5,
	"totalInstallment": null,
	"eventDate": "2023-05-02T19:09:23.341647228"
}
```

- Request para transação de compra parcelada
```json
{
	"id": 3,
	"accountId": 1,
	"operationTypeId": 2,
	"amount": -22.5,
	"totalInstallment": 2,
	"eventDate": "2023-05-02T19:09:23.341647228"
}
```
- Response
  - totalInstallment é a quantidade total de parcelas da compra
```json
{
	"id": 3,
	"accountId": 1,
	"operationTypeId": 2,
	"amount": -22.5,
	"totalInstallment": 2,
	"eventDate": "2023-05-02T19:09:23.341647228"
}
```

## Busca de transações
### Get por transaction id (http://localhost:8080/transactions/{id})
- Response
```json
{
  "id": 3,
  "accountId": 1,
  "operationTypeId": 1,
  "amount": -22.50
}
```

### Get por account id (http://localhost:8080/transactions/account/{id})
- Response
```json
{
  "transactions": [
    {
      "id": 3,
      "accountId": 1,
      "operationTypeId": 4,
      "amount": 22.50
    },
    {
      "id": 4,
      "accountId": 1,
      "operationTypeId": 3,
      "amount": -22.50
    }
  ]
}
```

## Busca de installments
### Get por installment id (http://localhost:8080/installments/{id})
- Response
  - installment é o número da parcela
  - installmentDue é a data de vencimento dessa parcela
```json
{
	"id": 4,
	"amount": 11.25,
	"transactionId": 3,
	"installment": 1,
	"installmentDue": "2023-05-02"
}
```

### Get por transaction id (http://localhost:8080/installments/transaction/{id})

- Response
  - installment é o número da parcela
  - installmentDue é a data de vencimento dessa parcela
```json
{
	"installments": [
		{
			"id": 4,
			"amount": 11.25,
			"transactionId": 3,
			"installment": 1,
			"installmentDue": "2023-05-02"
		},
		{
			"id": 5,
			"amount": 11.25,
			"transactionId": 3,
			"installment": 2,
			"installmentDue": "2023-06-02"
		}
	]
}
```

## Testes
Os testes estão escritos dentro do diretório Main, pois fiz o teste de integração e somente o Main tem acesso a todas
as camadas. Para executar os testes é só executar o comando abaixo 

``/gradlew tests``
