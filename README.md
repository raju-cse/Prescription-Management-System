💊 Prescription App  
🏥 CMED Health LTD — Technical Skills Exam  

A simple Spring Boot web application to create, list, edit, and delete medical prescriptions. The app includes 🔐 user authentication (H2 DB for credentials), a REST API, 📊 day-wise report, and optional 📘 Swagger documentation.

---

### ✨ Features
- 👥 User authentication (Spring Security) using H2 (or SQLite) for credentials  
- 📝 Create / Read / Update / Delete prescriptions  
- 📄 Prescription fields:  
  - 📅 Prescription Date (required, valid date)  
  - 🧑‍⚕️ Patient Name (required)  
  - 🔢 Patient Age (required, integer, valid range)  
  - 🚻 Patient Gender (required)  
  - 🧬 Diagnosis (optional)  
  - 💊 Medicines (optional)  
  - 📆 Next visit date (optional)  
- ✅ Default list view shows prescriptions for the current month; user can set a date range.  
- 📈 Day-wise prescription count report  
- 🌐 REST API: `GET /api/v1/prescription` (returns prescriptions in JSON)  
- 🖥️ Frontend consumes the REST API and shows tabular data  
- 💡 Bonus (optional): Swagger, client-side validation, delete confirmation, responsive UI  

---

### 🧰 Tech Stack
- ☕ Java 17+  
- 🚀 Spring Boot 3.x  
- 🧩 Spring MVC, Spring Data JPA  
- 🔒 Spring Security  
- 🗄️ H2 (in-memory) or SQLite  
- 🎨 Thymeleaf (server-side UI) or optionally React for the frontend  
- 🧱 Maven (or Gradle)  
- 📘 Swagger / OpenAPI (optional)  

---

### 👨‍💻 Developer Information
**Name:** Raju Ahmad  
**LinkedIn:** [https://www.linkedin.com/in/raju-ahmad-3ba198247/](https://www.linkedin.com/in/raju-ahmad-3ba198247/)  
**Email:** [razuahmed1066@gmail.com](mailto:razuahmed1066@gmail.com)

---

⭐ *If you found this project useful, don’t forget to star the repo!*
