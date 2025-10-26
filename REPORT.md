Mini Report - Atelier3

Goal
- Practice JPA and JSF to build a small e-commerce simulation (product catalog, cart, internaute session).

Design (class highlights)
- Product (entity): id, name, description, price, stock
- CartItem (POJO): product + quantity (kept in HTTP session)
- ProductService (EJB): manages product persistence and seeds sample data
- ProductBean (ApplicationScoped): exposes product list to JSF pages
- CartBean (SessionScoped): manages in-memory cart per user session

Technologies used
- JSF 4.1 (Mojarra)
- PrimeFaces 12 (UI components)
- JPA 3 / Hibernate 6 (persistence provider)
- MySQL connector
- CDI / EJB for wiring services

How to run
1. Configure MySQL connection in `persistence.xml` (user/password).
2. Create the DB `atelier3_db`.
3. mvn clean package
4. Deploy WAR to WildFly and open `index.xhtml`.

Next steps / improvements
- Persist Carts and Orders to the database.
- Add authentication (Internaute entity) and checkout flow.
- Add unit/integration tests and a Docker Compose for DB + server.

