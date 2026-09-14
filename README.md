# Taj Hotels - Selenium Automation Testing

## 📌 Project Overview

This project is a **Selenium WebDriver automation testing framework** developed using Java to automate and validate key functionalities of the **Taj Hotels website**.

The framework follows the **Page Object Model (POM)** design pattern and uses **TestNG, Maven, PageFactory, Apache POI, and ExtentReports** for maintainable, reusable, and data-driven test automation.

## 🌐 Application Under Test

**Taj Hotels**

https://www.tajhotels.com/en-in

---

## 🛠️ Technologies & Tools

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- PageFactory
- Apache POI
- ExtentReports
- Eclipse IDE
- Google Chrome

---

## 📂 Project Structure

```text
TajHotels
│
├── src/main/java
│
├── src/main/resources
│
├── src/test/java
│   │
│   ├── basepkg
│   │   └── TajBaseClass.java
│   │
│   ├── pagepkg
│   │   ├── BookAStayPage.java
│   │   ├── HomePage.java
│   │   └── LoginPage.java
│   │
│   ├── testpkg
│   │   ├── BookAStayTest.java
│   │   ├── HomePageTest.java
│   │   └── LoginTest.java
│   │
│   └── utilspkg
│       └── Excelutils.java
│
├── src/test/resources
│   └── testdata
│       ├── TajBookAStay.xlsx
│       └── TajLoginData.xlsx
│
├── Reports
│   └── Tajreport.html
│
├── Screenshot
│
├── test-output
│
├── target
│
├── pom.xml
├── Tajtestng.xml
└── README.md
