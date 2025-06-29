# 🕷️ Spidershop

Spidershop is an online store for tarantulas, featuring a Java Spring Boot backend and Angular frontend.  
The application is secured with JWT authentication and includes product filtering, validation, and comprehensive exception handling.

---

## Features

- User registration and login with JWT  
- Product management (Create, Read, Update, Delete)  
- Product filtering and sorting  
- Admin panel for managing the store  
- Data validation and global exception handling  
- API documentation with Swagger  

---

## Technology Stack

- **Backend:** Java 17, Spring Boot, Spring Security, JWT, Hibernate  
- **Frontend:** Angular, TypeScript  
- **Database:** PostgreSQL  
- **Build Tools:** Maven, Angular CLI  
- **API Docs:** Swagger  

---

## 📝 To-Do List for User Authentication & Security

- Implement User Repository and Service — handle user data and business logic.  
- Configure Spring Security — secure endpoints and manage authorization.  
- Create JWT Utility Class — generate and verify JWT tokens.  
- Add JWT Filter — extract token from requests and set security context.  
- Develop Login and Registration Endpoints — allow users to authenticate and receive tokens.  
- Test Security and Authorization — ensure tokens work correctly and protect endpoints.

## 🚀 Future Development To-Do

- Write unit and integration tests for backend and frontend  
- Dockerize backend and frontend for easier deployment  
- Setup CI/CD pipelines for automated builds and tests  
- Implement advanced product search and filtering (by multiple criteria)  
- Add user roles and permissions (e.g., admin, regular user)  
- Improve frontend UI/UX with responsive design and animations  
- Add user reviews and ratings for products  
- Integrate payment gateway for order processing  
- Implement order management and tracking system  
- Add email notifications (registration, password reset, order updates)  
- Optimize performance and scalability (caching, DB indexing)  
