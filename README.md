# TDC SP 2018 - Java Enterprise - Testcontainers

Facilitando os testes de integração com TestContainers

Testcontainers é uma biblioteca Java que suporta testes com JUnit, fornecendo instâncias leves e descartáveis de bancos de dados comuns, navegadores da Web Selenium ou qualquer outra coisa que possa ser executada em um contêiner Docker. Será demonstrado um caso de uso de testes para uma API REST, simulando o funcionamento da aplicação completa em Spring Boot e com suporte a vários bancos de dados.

## Build and run

### integration-tests project

```
cd integration-tests
mvn clean install
docker-compose up
```

http://localhost:8080/api/v1/users

## Integrations Tests

Use -DdbVendor to determine database. Supported databases
mysql, oracle and postgresql

```sh
mvn verify -Pintegration-test -DdbVendor=mysql
``` 