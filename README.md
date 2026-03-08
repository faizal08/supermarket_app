<div align="center">

# 🍎 NESTO SUPERMARKET MANAGEMENT SYSTEM 
### Efficient Inventory & Retail Solution

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Shared-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Thymeleaf](https://img.shields.io/badge/View_Engine-Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)](https://www.thymeleaf.org/)

*A Streamlined CRUD Application for Modern Retail Management*
</div>

---

## 📖 Project Overview
The *Neesto Supermarket App* is a robust management tool designed to handle daily retail operations. Built with *Spring Boot* and *PostgreSQL*, it provides a seamless interface for managing product inventories, adding customers, and generating invoices for sale.

---

## 📸 App Preview

![Supermarket App Screenshot](supermarket_screenshot.png)

---

## ✨ Key Features

* *Inventory Control:* Full CRUD (Create, Read, Update, Delete) operations for all supermarket items.
* *Customer Control:* Full CRUD (Create, Read, Update, Delete) operations for all customers.
* *Invoice Generation:* Generate invoice for sales.

### 🛡️ Core Reliability
* *Data Validation:* Ensures no empty or invalid entries enter the database.
* *Spring Data JPA:* Optimized database queries and automated table creation.

---

## 💻 Tech Stack

| Layer | Technology |
| :--- | :--- |
| *Backend* | Java 21, Spring Boot, Spring Data JPA |
| *Frontend* | Thymeleaf, Bootstrap 5, HTML5 |
| *Database* | PostgreSQL |
| *Build Tool* | Maven |

---

## 🚦 Getting Started

### Prerequisites
* *JDK 21* or higher
* *Maven 3.x*
* *PostgreSQL* (Running on port 5432)

### Installation & Setup

To set up Nesto_supermarket_app locally, follow these steps:

1. Clone the repository:
bash
   git clone https://github.com/faizal08/Nesto_supermarket_app.git
  


2. Navigate to the project directory:
bash
cd Nesto_supermarket_app

`
3. Install the required dependencies:
 bash
 ./mvnw install


4. Configure your application.properties file with your database credentials:
bash

spring.datasource.url=jdbc:postgresql://localhost:5432/nesto_db
spring.datasource.username=your_username
spring.datasource.password=your_password

5. Run the application:
bash
./mvnw spring-boot:run


## Usage

1. Open your web browser and navigate to [http://localhost:8080](http://localhost:8080)
2. Create an account or log in to access the store.
3. Add products, customers,create sales and generate invoice for sale.

## Contact

For any inquiries or feedback, feel free to reach out:

- *Email:* [reachfaizal08@gmail.com](reachfaizal08@gmail.com)
- *GitHub:* [faizal08](https://github.com/faizal08)
