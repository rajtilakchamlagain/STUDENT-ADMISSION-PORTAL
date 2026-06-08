CREATE DATABASE admission_db;

USE admission_db;

CREATE TABLE branches(
    branch_name VARCHAR(100) PRIMARY KEY,
    total_seats INT,
    available_seats INT
);

INSERT INTO branches VALUES
('Computer Science Engineering (CSE)',60,60),
('Mechanical Engineering',60,60),
('Civil Engineering',60,60),
('Electrical Engineering',60,60);

CREATE TABLE students(
    student_id VARCHAR(20) PRIMARY KEY,
    full_name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    college VARCHAR(100),
    branch VARCHAR(100),
    semester VARCHAR(20)
);