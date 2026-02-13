# User Management CRUD Application

A simple Java application demonstrating CRUD operations with MySQL using the DAO pattern.

## Prerequisites

1.  **Java Development Kit (JDK)** (version 8 or higher).
2.  **MySQL Server** installed and running.
3.  **MySQL Connector/J** (JDBC Driver).

## Setup Instructions

### 1. Database Setup
Run the `database.sql` script in your MySQL client to create the database and table.
```sql
source database.sql
```
Or copy-paste the content into your MySQL workbench/client.

### 2. Configure Database Credentials
Open `UserDAO.java` and update the database credentials to match your local MySQL setup:
```java
private static final String URL = "jdbc:mysql://localhost:3306/user_management?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";     // Change to your MySQL username
private static final String PASSWORD = "password"; // Change to your MySQL password
```

### 3. Build and Run

#### Option A: Using Command Line (No IDE)

1.  **Download MySQL Connector/J**: 
    - Download the JAR file from [MySQL Official Site](https://dev.mysql.com/downloads/connector/j/) or Maven Central.
    - Place the `mysql-connector-j-x.x.x.jar` file in the project folder (e.g., `c:\Antigravity\JavaDatabaseProject`).

2.  **Compile**:
    Open a terminal/command prompt in the project root (`c:\Antigravity\JavaDatabaseProject`) and run:
    
    *Windows*:
    ```bash
    javac -cp ".;mysql-connector-j-8.x.x.jar" com\example\usermanagement\*.java
    ```
    
    *Linux/Mac*:
    ```bash
    javac -cp ".:mysql-connector-j-8.x.x.jar" com/example/usermanagement/*.java
    ```

3.  **Run**:
    From the same project root directory:
    
    *Windows*:
    ```bash
    java -cp ".;mysql-connector-j-8.x.x.jar" com.example.usermanagement.Main
    ```

    *Linux/Mac*:
    ```bash
    java -cp ".:mysql-connector-j-8.x.x.jar" com.example.usermanagement.Main
    ```

#### Option B: Using an IDE (VS Code, IntelliJ, Eclipse)
1.  Open the folder `c:\Antigravity\JavaDatabaseProject` as a project.
2.  Ensure your IDE recognizes the `com` folder as a source root (or part of the source path).
3.  Add the MySQL Connector/J JAR to the project's **Libraries** or **Dependencies**.
4.  Run `Main.java` (right-click -> Run).

### Option C: Running as a Backend API (REST)

This option turns the application into a server that listens for HTTP requests.

1.  **Download Gson**: 
    - Download `gson-2.10.1.jar` from [Maven Central](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar).
    - Place it in the project folder alongside the MySQL driver.

2.  **Compile**:
    ```bash
    javac -cp ".;mysql-connector-j-8.x.x.jar;gson-2.10.1.jar" com\example\usermanagement\*.java
    ```

3.  **Run**:
    ```bash
    java -cp ".;mysql-connector-j-8.x.x.jar;gson-2.10.1.jar" com.example.usermanagement.UserServer
    ```

4.  **Test**:
    Open your browser and visit `http://localhost:8080/users`.

## Project Structure
- `database.sql`: SQL script for DB setup.
- `User.java`: The model class.
- `UserDAO.java`: CRUD logic.
- `Main.java`: Console test code.
- `UserServer.java`: REST API server.
