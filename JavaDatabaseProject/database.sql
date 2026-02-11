CREATE DATABASE IF NOT EXISTS user_management;

USE user_management;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- Optional: Insert a sample user
INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com');
