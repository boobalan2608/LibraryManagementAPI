# 📚 Library Management RESTful API

## 📖 Overview
The **Library Management RESTful API** provides an efficient way to manage a library system, allowing users to **create, read, update, and delete** details related to:  
- **Authors** 📖 (Manage authors of books)  
- **Books** 📚 (Manage books with author and genre details)  
- **Loans** 📄 (Track book loans by members)  
- **Members** 👤 (Manage library members)  

This API follows **RESTful principles** and supports **CRUD operations** for all entities.  

---

## 🌐 Base URL
🔗 **Deployed API on Render:**  
[https://librarymanagementapi-wpdl.onrender.com](https://librarymanagementapi-wpdl.onrender.com)

## 🔐 Authentication
- **No authentication required** (Public API).  

---

## 🚀 API Endpoints & Functionality

### 📌 Author Endpoints
📌 **Entity Attributes:** `{ id (int), name (String) }`  
| Method | Endpoint | Description |  
|--------|----------|-------------|  
| `GET`  | `/author` | Retrieve a list of all authors |  
| `POST` | `/author` | Add a new author (Pass JSON object in request body) |  
| `GET`  | `/author/{id}` | Retrieve author details using the author's ID |  
| `PUT`  | `/author` | Update an existing author's details (Pass JSON in request body) |  
| `DELETE` | `/author/{id}` | Remove an author by ID |  

---

### 📌 Book Endpoints
📌 **Entity Attributes:** `{ id (int), title (String), genre (String), author (Author), loans (List<Loan>) }`  
| Method | Endpoint | Description |  
|--------|----------|-------------|  
| `POST` | `/book/{authorid}` | Add a book under a specified author (Provide `authorid` in URL) |  
| `GET`  | `/book` | Retrieve a list of all books |  
| `GET`  | `/book/{id}` | Fetch book details by book ID |  
| `GET`  | `/book/g/{genre}` | Retrieve books based on genre |  
| `PUT`  | `/book` | Update book details (Pass JSON in request body) |  
| `DELETE` | `/book/{id}` | Remove a book using its ID |  

---

### 📌 Loan Endpoints
📌 **Entity Attributes:** `{ id (int), loanDate (LocalDate), returnDate (LocalDate), member (Member), book (Book) }`  
| Method | Endpoint | Description |  
|--------|----------|-------------|  
| `POST` | `/loan/{bookid}/{memberid}` | Issue a book loan to a member (Provide `bookid` and `memberid` in URL) |  
| `GET`  | `/loan` | Retrieve a list of all active loans |  
| `GET`  | `/loan/{id}` | Fetch loan details by loan ID |  
| `PUT`  | `/loan` | Update loan details (Pass JSON in request body) |  
| `DELETE` | `/loan/{id}` | Delete a loan record by ID |  

---

### 📌 Member Endpoints
📌 **Entity Attributes:** `{ id (int), name (String), email (String), phone (long), loans (List<Loan>) }`  
| Method | Endpoint | Description |  
|--------|----------|-------------|  
| `POST` | `/member` | Add a new member (Pass JSON in request body) |  
| `GET`  | `/member` | Retrieve a list of all library members |  
| `GET`  | `/member/{id}` | Fetch member details using the member ID |  
| `PUT`  | `/member` | Update member details (Pass JSON in request body) |  
| `DELETE` | `/member/{id}` | Remove a member by ID |  

---

## ⚙️ Technologies Used
- **Spring Boot** – Backend framework  
- **PostgreSQL** – Relational database  
- **Maven** – Dependency and project management  
- **REST API** – Communication architecture  

---

## 🛠️ Installation & Running Locally

### 1️⃣ Clone the Repository
```sh
git clone <your-repo-url>
cd library-management-api
```

### 2️⃣ Configure Database Connection
Modify `application.properties` to connect to PostgreSQL:  
```properties
spring.datasource.url=jdbc:postgresql://<your-db-host>:5432/<your-db-name>
spring.datasource.username=<your-db-username>
spring.datasource.password=<your-db-password>
```

### 3️⃣ Build & Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

---

## 🚀 Deployment on Render

### 1️⃣ Push Code to GitHub
```sh
git add .
git commit -m "Initial commit"
git push origin main
```

### 2️⃣ Deploy on Render
1. Go to **[Render](https://dashboard.render.com/)** and create a **New Web Service**.  
2. Connect your **GitHub repository**.  
3. Set the **Build Command**:  
   ```sh
   chmod +x mvnw && ./mvnw clean install
   ```  
4. Set the **Start Command**:  
   ```sh
   java -jar target/*.jar
   ```  
5. **Set Environment Variables** in Render:  
   - `DATABASE_URL`: `postgresql://<username>:<password>@<host>:5432/<dbname>`  
   - `SPRING_DATASOURCE_URL`: `jdbc:postgresql://<host>:5432/<dbname>`  

6. Click **Deploy** and wait for the application to go live.  

---

## 📊 Database Setup in Render
After creating a PostgreSQL database on Render:  
1. **Access pgHero**:  
   - Open **Render Dashboard** → **Your Database** → **PgHero Monitoring**.  

2. **Connect PostgreSQL Locally using psql**:  
   ```sh
   psql -h <host> -p 5432 -U <username> -d <dbname>
   ```  
   - Enter the password when prompted (Input remains invisible for security).  

3. **Check Existing Tables in PostgreSQL**:  
   ```sql
   \dt
   ```

4. **Insert Records into Tables**:  
   ```sql
   INSERT INTO author (id, name) VALUES (1, 'John Doe');
   INSERT INTO book (id, title, genre, author_id) VALUES (1, 'Spring Boot Guide', 'Technology', 1);
   INSERT INTO member (id, name, email, phone) VALUES (1, 'Alice', 'alice@email.com', 9876543210);
   INSERT INTO loan (id, loan_date, return_date, member_id, book_id) VALUES (1, '2025-03-05', '2025-03-20', 1, 1);
   ```

---

## 👨‍💻 Contributors
- **BOOBALAN**  

---

## 📜 License
This project is licensed under the **MIT License**.

---

### 🎉 Congratulations! Your Library Management API is successfully deployed and live! 🚀  
