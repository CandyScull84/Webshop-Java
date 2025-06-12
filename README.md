# Enkel Webshop Backend – Java + Spring Boot

## Projektbeskrivning

Detta projekt är en enkel backend för en webshop byggd i Java med Spring Boot. API:et hanterar produktdata och beställningar (orders), lagrar all data i minnet och erbjuder en grund för framtida utveckling (t.ex. frontend, databas, autentisering).

## Mål

- REST API för webshop
- Produkthantering (lista, visa produkt)
- Orderhantering
- Objektorienterad programmering (OOP)
- In-memory lagring med Java Collections
- Felhantering och validering
- Enhetstester med JUnit

## Kom igång

### 1. Klona projektet:

```bash
git clone https://github.com/CandyScull84/Webshop-Java.git
cd Webshop-Java
````

### 2. Starta applikationen:

```bash
./mvnw spring-boot:run
```

### 3. Applikationen körs på:

```
http://localhost:8080
```

## API-endpoints

### Produkter

* `GET /api/products` – Lista alla produkter
* `GET /api/products/{id}` – Visa en produkt med ID

### Ordrar

* `POST /api/orders` – Skapa en order

**Exempel (för Postman):**

```json
{
  "customerInfo": {
    "name": "Anna Andersson",
    "address": "Testgatan 1",
    "email": "anna@example.com"
  },
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 2, "quantity": 1 }
  ]
}
```

**Svar:**

```json
{
  "orderId": "abc123-xyz",
  "message": "Order skapad!"
}
```

## Felhantering

Om en produkt inte hittas, returneras ett fel:

```json
{
  "error": "Produkt med ID 55 hittades inte."
}
```

## Testning

### Så här testar du:

```bash
./mvnw test
```

Eller i IntelliJ:

* Högerklicka på `ProductServiceTest.java`
* Välj **Run 'ProductServiceTest'**

## Projektstruktur

```
com.example.webshop
├── controller       # REST API
├── service          # Affärslogik
├── repository       # Lagring (List & Map)
├── model            # Datamodeller
└── exception        # Felhantering
```

## Teknik

* Java 17
* Spring Boot 3.5
* Maven
* Spring Web
* JSON (Jackson)
* JUnit 5

## Funktionalitet

* Lista produkter
* Visa produkt
* Skapa order
* Validering och felhantering
* Enhetstest
* README

## Framtida utveckling

* Frontend med React
* Databas (H2, PostgreSQL)
* Inloggning för kunder
* DTO-klasser för tydligare datamodeller

## Inlämning

Projektet finns på GitHub:
[https://github.com/CandyScull84/Webshop-Java](https://github.com/CandyScull84/Webshop-Java)

Denna README innehåller:

* Instruktioner
* API-beskrivning
* Testexempel (Postman, terminal)

```
