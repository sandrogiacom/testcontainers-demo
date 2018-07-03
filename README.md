# TDC SP 2018 - Java Enterprise - Testcontainers

Facilitando os testes de integração com TestContainers

Testcontainers é uma biblioteca Java que suporta testes com JUnit, fornecendo instâncias leves e descartáveis de bancos de dados comuns, navegadores da Web Selenium ou qualquer outra coisa que possa ser executada em um contêiner Docker. Será demonstrado um caso de uso de testes para uma API REST, simulando o funcionamento da aplicação completa em Spring Boot e com suporte a vários bancos de dados.

## Build and run

```sh
mvn clean install
docker build --force-rm -t tdc2018/testcontainers:latest
docker run --name tdc2018-testcontainers -p 8081:8080 tdc2018/testcontainers:latest 
```

http://localhost:8080/api/v1/users

## Integrations Tests

Use -DdbVendor to determine database. Supported databases
mysql, oracle and postgresql

```sh
mvn clean install -Pintegration-test -DdbVendor=mysql
``` 