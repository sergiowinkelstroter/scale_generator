<h1 align="center">
  Scale Generator API
</h1>

Este projeto é uma implementação de um gerador de escalas de trabalho, onde é possível cadastrar escalas associadas a um título específico, mês, ano e um conjunto de dias da semana. A aplicação utiliza tecnologias como Spring Boot, Spring Data JPA, Lombok e PostGreSQL.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok](https://projectlombok.org/)
- [PostGreSQL](https://www.postgresql.org/)

## Como Executar

- Clonar repositório git
- Construir o projeto:

```
$ ./mvnw clean package
```

- Executar a aplicação:

```
$ java -jar target/gestao_vagas-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Escala

```
$ http POST :8080/scale title="Sonoplastia" names:='["Nome1", "Nome2", "Nome3", "Nome4", "Nome5", "Nome6"]' year=2024 month=1 daysOfWeek:='["sunday", "monday", "friday"]' type="dupla"

{
	"id": "c4bf9490-95bc-4e6c-897f-9c6be790436f",
	"title": "Sonoplastia",
	"scaleNames": [
		{
			"id": "dd9cb276-dde7-4cc7-a798-a43a4ea979d0",
			"data": "2024-01-01",
			"names": [
				"Nome5",
				"Nome2"
			]
		},
		{
			"id": "cd7434be-32f6-4e10-8f54-06b27499d4e1",
			"data": "2024-01-08",
			"names": [
				"Nome6",
				"Nome1"
			]
		},
		{
			"id": "57b4eab1-b4a3-4741-b506-a742210df47d",
			"data": "2024-01-15",
			"names": [
				"Nome3",
				"Nome4"
			]
		},
		{
			"id": "1d6ba510-03b6-4e3a-b198-84cece1df527",
			"data": "2024-01-22",
			"names": [
				"Nome5",
				"Nome2"
			]
		},
		{
			"id": "1f57fcbe-dbf9-4d56-b609-7bc07dcd15b0",
			"data": "2024-01-29",
			"names": [
				"Nome6",
				"Nome1"
			]
		},
		{
			"id": "e605e7e4-2618-451a-94a6-eb7c06dba571",
			"data": "2024-01-05",
			"names": [
				"Nome5",
				"Nome1"
			]
		},
		{
			"id": "4f70968e-81d3-4817-909d-43962b59774a",
			"data": "2024-01-12",
			"names": [
				"Nome3",
				"Nome4"
			]
		},
		{
			"id": "65ef3079-94a6-41af-8fa7-ae19a6f27281",
			"data": "2024-01-19",
			"names": [
				"Nome6",
				"Nome2"
			]
		},
		{
			"id": "4c235305-9e69-45bd-b42b-4d70ce033098",
			"data": "2024-01-26",
			"names": [
				"Nome5",
				"Nome1"
			]
		},
		{
			"id": "ab874997-d44c-4c03-be43-1844a0bfda54",
			"data": "2024-01-07",
			"names": [
				"Nome5",
				"Nome4"
			]
		},
		{
			"id": "5f3efac2-66c2-4018-af5b-f45eee8fec5f",
			"data": "2024-01-14",
			"names": [
				"Nome2",
				"Nome3"
			]
		},
		{
			"id": "0b20022e-bc33-41ed-888d-e6cad9c6d866",
			"data": "2024-01-21",
			"names": [
				"Nome1",
				"Nome6"
			]
		},
		{
			"id": "38ec262e-bf3e-4096-afe3-ed23e5847219",
			"data": "2024-01-28",
			"names": [
				"Nome5",
				"Nome4"
			]
		}
	],
	"month": 1,
	"year": 2024,
	"type": "dupla",
	"createdAt": "2024-01-18T14:53:28.511274"
}
```
