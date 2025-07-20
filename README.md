# 👨‍💼 SmartEnrollmentSystem

SmartEnrollmentSystem is a role-based web application developed using Spring Boot and Thymeleaf. It enables Admins to manage Employee data and Employees to log in and view their dashboard. The project follows an MVC architecture with layered design (Controller → Service → Repository).

---

## 🚀 Features

### 🔐 Authentication & Roles
- Admin and Employee roles
- Login & logout with session management
- Registration by Admin (creates Employee users)

### 👩‍💼 Admin Functionalities
- Admin Dashboard
- Create, View, Update, Delete (CRUD) Employees
- Search Employees by name
- Employee list in DataTable (Bootstrap + jQuery)

### 👨‍💻 Employee Functionalities
- Employee Login
- Personalized dashboard with welcome message
- Update their profile

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Frontend:** Thymeleaf, HTML, CSS, Bootstrap, jQuery
- **Database:** MySQL
- **Tools:** Spring Data JPA, Maven, Git

---

## 📂 Project Structure

SmartEnrollmentSystem/
├── src/main/java
│ ├── controller
│ ├── model
│ ├── repository
│ ├── service
│ └── serviceImpl
├── src/main/resources
│ ├── templates
│ │ ├── dashboard.html
│ │ ├── login.html
│ │ ├── register.html
│ │ ├── employee-edit.html
│ │ └── welcome.html
│ └── application.properties
└── pom.xml

👨‍🎓 Author
Chandrashekar GJ
Java Full Stack Developer

