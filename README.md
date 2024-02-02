## Run docker compose

This command generate a docker container up and running:
```
docker compose up -d
```

With CURL or postman send http GET request with this url:
```
curl --location 'localhost:8080/api/v1/banks/1?type=1'
```

This url you can show de DB to see al database in H2:

```
http://localhost:8080/h2-console/
```
In this database you can enter with these credentials:

```
JDBC URL: jdbc:h2:mem:bank
User Name:	sa
```
