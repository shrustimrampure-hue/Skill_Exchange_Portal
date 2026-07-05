# Skill Exchange Portal

## 📌 Overview

The Skill Exchange Portal is a web-based application developed using Spring Boot that enables users to share their skills and learn new skills from others. Users can register, log in, add skills, browse available skills, send learning requests, and track the status of their requests.

---

## 🚀 Features

- User Registration & Login
- Secure Session Management
- User Profile
- Add New Skills
- Browse Available Skills
- Search Skills
- Request a Skill
- Approve or Reject Requests
- Duplicate Skill Validation
- Duplicate Request Validation
- Responsive User Interface

---

## 🛠️ Technologies Used

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Frontend
- HTML5
- CSS3
- Thymeleaf
- JavaScript

### Database
- MySQL

### Build Tool
- Maven

### IDE
- IntelliJ IDEA / Eclipse

---

## 📂 Project Structure

```
SkillExchangePortal
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.cse.SkillExchangePortal
│   │   │       ├── controller
│   │   │       ├── entity
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── SkillExchangePortalApplication.java
│   │   │
│   │   ├── resources
│   │   │   ├── static
│   │   │   │   ├── style.css
│   │   │   │   └── script.js
│   │   │   │
│   │   │   ├── templates
│   │   │   │   ├── index.html
│   │   │   │   ├── login.html
│   │   │   │   ├── signup.html
│   │   │   │   ├── dashboard.html
│   │   │   │   ├── addskill.html
│   │   │   │   ├── browseskills.html
│   │   │   │   ├── requests.html
│   │   │   │   └── profile.html
│   │   │   │
│   │   │   └── application.properties
│
├── pom.xml
└── README.md
```

---

## 🗄️ Database Tables

### User
- ID
- Name
- Email
- Password

### Skill
- ID
- Skill Name
- Category
- Level
- Description

### Request
- ID
- Skill Name
- Requester Email
- Status

---

## ▶️ How to Run the Project

1. Clone the repository

```
git clone https://github.com/your-username/SkillExchangePortal.git
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Configure MySQL in `application.properties`.

4. Create the required database.

5. Run

```
SkillExchangePortalApplication.java
```

6. Open your browser and visit

```
http://localhost:8080
```

---

## 📷 Screens

- Home Page
- Login
- Signup
- Dashboard
- Add Skill
- Browse Skills
- Request Management
- User Profile

---

## 🔮 Future Enhancements

- Email Notifications
- Skill Rating & Reviews
- Chat Between Users
- Admin Dashboard
- File Sharing
- User Recommendation System

---

## 👥 Team Members

- Shrusti M
- Preeti
- Rakshitha
- Soumyashree

---

## 📄 License

This project was developed for educational and academic purposes.
