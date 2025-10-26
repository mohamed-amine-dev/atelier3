Atelier3 - Mini e-Commerce (JSF + JPA)

This project is a small demo app built with JSF (PrimeFaces) and JPA (Hibernate) to practice building an e-commerce-like cart and product catalog.

Prerequisites
- Java 17+ (project currently set to compile with Java 23 in pom; adjust if needed)
- Maven
- MySQL server
- WildFly or any Jakarta EE compatible app server (WildFly recommended)

Setup
1. Update database connection in `src/main/resources/META-INF/persistence.xml` (URL, user, password).
2. Create database `atelier3_db` in MySQL:

   CREATE DATABASE atelier3_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

3. Build WAR:

   mvn clean package

4. Deploy the generated `target/atelier3.war` to WildFly (or run via Maven plugin / embedded server).

Notes
- The project will auto-create sample products on first deploy (EJB `ProductService` seeds the data).
- For development you can also run on a servlet container that supports Jakarta EE APIs.

Report
See `REPORT.md` for a short mini-report about the design and steps completed.
