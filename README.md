# StudentCurdApp

## 📌 Description
**StudentCurdApp** is a Java-based web application that performs CRUD (Create, Read, Update, Delete) operations on student records using JDBC. The application follows a layered architecture using the DAO (Data Access Object) design pattern for a clean and modular structure. It includes a simple frontend using HTML and CSS, and is deployed on an Apache Tomcat server using Java Servlets.

---

## ✨ Features
- Add new student records  
- View student details  
- Update existing student information  
- Delete student records  
- JDBC-based database connectivity  
- Implements DAO and service layers  
- HTML/CSS frontend  
- Java Servlet backend  
- Runs on Apache Tomcat  

---

## 🛠️ Technologies Used
- Java (JDK 21)  
- HTML & CSS (Frontend)  
- Java Servlets  
- JDBC (Java Database Connectivity)  
- MySQL Database  
- DAO Design Pattern  
- Apache Tomcat  
- IntelliJ IDEA (IDE)

---

## ⚙️ Installation and Deployment

### ✅ Prerequisites
- Java JDK 21  
- Apache Tomcat  
- MySQL Server  
- IntelliJ IDEA or any Java IDE  
- MySQL Workbench or any SQL client

---

### 📂 Step 1: Setup MySQL Database
```sql
CREATE DATABASE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT(100),
    address VARCHAR(100)
);
