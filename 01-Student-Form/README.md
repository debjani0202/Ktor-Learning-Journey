# 01 Student Form

## Goal

Create a student registration form using Ktor and save student details in MySQL.

## Features

* Student registration form
* HTML generated using Ktor HTML DSL
* Accept user input
* Save data into MySQL database
* File upload form
* Display uploaded file name

## Concepts Learned

### Ktor Routing

* GET route displays the form
* POST route receives submitted data

### HTML DSL

* Create HTML pages using Kotlin code
* Create forms, inputs, buttons, and headings

### Form Handling

* Receive form data using:

```kotlin
call.receiveParameters()
```

### Database Connection

* Connect Ktor application to MySQL
* Use JDBC DriverManager
* Execute INSERT queries

### Prepared Statements

* Prevent SQL injection
* Insert values safely using placeholders (?)

### Multipart Form Data

* Receive uploaded files
* Read file name from browser request

## Problems Faced

* Understanding GET vs POST
* Understanding receiveParameters()
* Understanding prepareStatement()
* Understanding multipart file upload

## Solutions

* Studied request-response flow
* Practiced HTML forms
* Added comments to code
* Tested forms using browser

## Output

1. User fills Student Form.
2. Data is sent to /save.
3. Student data is stored in MySQL.
4. Success message is displayed.
5. User can upload a file and see uploaded file details.

## Future Improvements

* Validation
* Store uploaded files on server
* Show all students
* Edit student details
* Delete student details
