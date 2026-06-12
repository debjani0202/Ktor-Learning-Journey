# 02 - Women Help Center

## Project Overview

A backend web application built using Ktor and MySQL that allows users to:

* Register an account
* Login using email and password
* Lodge complaints
* Store complaint data in MySQL

This project helped me understand how a complete request travels from an HTML form to a Ktor server and finally into a database.

---

## Features

### User Registration

Route:

```text
GET  /sign-up
POST /sign-up
```

User provides:

* Name
* Email
* Password

Data is inserted into the `user` table.

Concepts learned:

* HTML Forms
* POST Request
* Form Data Handling
* INSERT Query
* JDBC Connection

---

### User Login

Route:

```text
GET  /log-in
POST /log-in
```

User enters:

* Email
* Password

Application checks whether the user exists in the database.

Concepts learned:

* Authentication Basics
* SELECT Query
* ResultSet
* Credential Verification

Flow:

```text
User
 ↓
Login Form
 ↓
Ktor Server
 ↓
MySQL
 ↓
Login Success / Failure
```

---

### Complaint Registration

Route:

```text
GET  /lodge-complain
POST /lodge-complain
```

User submits:

* Name
* Phone
* Address
* Title
* Complaint

Data is stored inside the complaint table.

Concepts learned:

* Large Form Handling
* Data Validation
* Database Storage
* PreparedStatement

---

## Validation Implemented

### Name Validation

```text
Name cannot be empty
```

### Phone Validation

```text
Must contain exactly 10 digits
```

Implementation:

```kotlin
phone.matches(Regex("\\d{10}"))
```

### Address Validation

```text
Cannot be empty
Maximum 20 characters
```

### Complaint Title Validation

```text
Cannot be empty
Maximum 20 characters
```

### Complaint Validation

```text
Complaint details required
```

---

## Database Design

### user

| Column   |
| -------- |
| id       |
| name     |
| email    |
| password |

### complaint

| Column    |
| --------- |
| id        |
| name      |
| phone     |
| address   |
| title     |
| complaint |

---

## Technical Concepts Learned

### Routing

Maps URL to Kotlin code.

Example:

```kotlin
get("/sign-up")
post("/sign-up")
```

---

### receiveParameters()

Used to read form data sent by browser.

Example:

```kotlin
val params = call.receiveParameters()
```

---

### PreparedStatement

Used to safely execute SQL queries.

Benefits:

* Prevents SQL Injection
* Separates SQL from user input

Example:

```kotlin
statement.setString(1, user.name)
```

---

### executeUpdate()

Used when modifying database data.

Examples:

```text
INSERT
UPDATE
DELETE
```

Returns number of affected rows.

---

### executeQuery()

Used when retrieving data.

Examples:

```text
SELECT
```

Returns ResultSet.

---

### ResultSet

Stores rows returned from database.

Example:

```kotlin
if(result.next())
```

Used to check whether matching data exists.

---

## Problems I Faced

### Problem 1

Understanding GET vs POST.

### Solution

Built registration and login forms and observed how browser sends data.

---

### Problem 2

Understanding receiveParameters().

### Solution

Learned that it collects all submitted form fields into a parameter object.

---

### Problem 3

Understanding login verification.

### Solution

Used SELECT query and ResultSet to verify user existence.

---

## What I Would Improve Next

* View Complaints
* Update Complaint
* Delete Complaint
* Password Hashing
* Session Management
* Role-Based Access
* Complaint Status Tracking

---

## Key Takeaway

This project taught me the complete backend flow:

```text
HTML Form
    ↓
POST Request
    ↓
Ktor Route
    ↓
Validation
    ↓
MySQL Query
    ↓
Database
    ↓
Response
```

This was my first project that combined registration, login, validation, database operations, and complaint management in a single application.
