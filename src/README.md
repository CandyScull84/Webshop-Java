
# 🛒 Enkel Webshop Backend – Java + Spring Boot

Detta är ett projektarbete där du bygger backend-systemet för en enkel webshop med Java och Spring Boot. Applikationen tillhandahåller ett REST API för att hantera produkter och ordrar, och all data lagras i minnet med hjälp av Java Collections. Systemet är byggt med objektorienterad programmering (OOP) och följer best practice enligt kursens första 10 föreläsningar.

## Mål

- Skapa ett funktionellt REST API för en webshop
- Hantera produktdata (lista produkter, visa enskild produkt)
- Implementera orderhantering (skapa order)
- Modellera data med objektorienterad programmering (OOP)
- Använda Java Collections Framework (List, Map) för att lagra data i minnet
- Implementera felhantering och validering
- Skriva enhetstester med JUnit

## 🚀 Kom igång

### 🔧 Bygga och köra projektet

1. Klona projektet:
```
git clone [https://github.com/CandyScull84/Webshop-Java.git](https://github.com/CandyScull84/Webshop-Java.git)
cd Webshop-Java
```
2. Kör applikationen:
```
./mvnw spring-boot\:run
```
3. Applikationen startar på:
```
[http://localhost:8080](http://localhost:8080)
```

## API-endpoints

### Produkthantering

- `GET /api/products` – Returnerar en lista med alla produkter
- `GET /api/products/{id}` – Returnerar en specifik produkt baserat på ID

### Orderhantering

- `POST /api/orders` – Tar emot orderdata i JSON-format och returnerar orderbekräftelse

**Exempel på POST-body (kan användas i Postman):**

```json
{
"customerInfo": {
 "name": "Anna Andersson",
 "address": "Testgatan 1",
 "email": "anna@example.com"
},
"items": [
 {
   "productId": 1,
   "quantity": 2
 },
 {
   "productId": 2,
   "quantity": 1
 }
]
}
````
**Exempel på svar:**

```json
{
  "orderId": "abc123-xyz",
  "message": "Order skapad!"
}
```

## Felhantering

Fel hanteras med egna undantag och en global `@RestControllerAdvice`. Om en produkt inte hittas returneras ett felmeddelande och HTTP 404:

```json
{
  "error": "Produkt med ID 999 hittades inte."
}
```

## Testning

Projektet innehåller enhetstest för `ProductService` med JUnit 5.

### Så här kör du tester:

```bash
./mvnw test
```

Eller kör i IntelliJ:

* Högerklicka på `ProductServiceTest.java`
* Välj **Run 'ProductServiceTest'**

## Projektstruktur

```
com.example.webshop
├── controller        # REST Controllers
├── exception         # Egna undantag och global felhantering
├── model             # Datamodeller (Product, Order, osv.)
├── repository        # In-memory lagring med List & Map
└──service           # Affärslogik
 ```

## Kurskoppling

Detta projekt bygger på följande kursmoment:

* Föreläsning 1–3: Grundläggande Java och OOP
* Föreläsning 2, 4: Collections och Arrays
* Föreläsning 5: Undantagshantering
* Föreläsning 7–8: Spring Boot & REST
* Föreläsning 8: JSON i Spring
* Föreläsning 10: Enhetstestning med JUnit

## Teknikstack

* Java 17
* Spring Boot 3.5
* Maven
* Spring Web
* JUnit 5
* JSON (via Jackson)
* In-memory storage (Map & List)

## ✅ Funktionalitet – Sammanfattning

* [x] `GET /api/products` – lista produkter
* [x] `GET /api/products/{id}` – visa produkt
* [x] `POST /api/orders` – skapa order
* [x] In-memory-lagring
* [x] Validering och felhantering
* [x] Enhetstest med JUnit
* [x] README med körinstruktioner, Postman-exempel, API-info


## Möjlig framtida utveckling

Just nu innehåller projektet bara backend (alltså bara det som körs i bakgrunden och hanterar data).  
Men systemet är byggt så att man lätt skulle kunna bygga vidare med:

- En webbsida (t.ex. med React) där kunden kan se produkter och beställa
- En riktig databas (t.ex. H2 eller PostgreSQL) för att spara produkter och ordrar permanent
- Inloggning så att kunder kan logga in och se sina tidigare beställningar
- Bättre sätt att skicka och ta emot data i API:et (med något som kallas DTO)


## Inlämning

* Projektet är publicerat på GitHub:
  [https://github.com/CandyScull84/Webshop-Java](https://github.com/CandyScull84/Webshop-Java)

* Denna README innehåller:

    * [x] Instruktioner för att bygga och köra
    * [x] API-dokumentation
    * [x] Testinstruktioner för terminal & Postman


