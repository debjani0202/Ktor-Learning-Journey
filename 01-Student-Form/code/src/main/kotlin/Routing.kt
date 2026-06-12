package com.example


import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.html.*
import kotlinx.html.*
import io.ktor.http.content.*


// a file :which URL-> which code runs
//'get' means Ask for Data
//'Post'  means Send Data

fun Application.configureRouting() {

    routing {

        get("/") {

            call.respondHtml {

                head {
                    title("Student Form")
                }

                body {

                    h2 {
                        +"Student Registration"
                    }

                    form(
                        action = "/save",
                        method = FormMethod.post
                    ) {

                        p { +"Name" }
                        textInput(name = "name")

                        p { +"Age" }
                        numberInput(name = "age")

                        p { +"Branch" }
                        textInput(name = "branch")

                        br

                        button(type = ButtonType.submit) {
                            +"Submit"
                        }
                    }
                }
            }
        }

        post("/save") {

            val params = call.receiveParameters() //Take all form data and store it in params
            //like a bag containing all from values


            val name = params["name"] ?: "" //extract values (Take value of name)
            val age = params["age"]?.toIntOrNull() ?: 0  //age should be int
            val branch = params["branch"] ?: ""

            val connection = Database.getConnection()  //Open connection with MySQL


            //I want to insert a row into table

            val sql =
                "INSERT INTO students(name, age, branch) VALUES (?, ?, ?)" //VALUES(?,?,? )->I will provide values later

            val statement = connection.prepareStatement(sql)  //Prepare the query,but don't run it yet


            //fill Values one by one
            statement.setString(1, name)
            statement.setInt(2, age)
            statement.setString(3, branch)

            statement.executeUpdate()  //Send the query to MySQL and exec ute it.


            //Work finished so Disconnect from database
            statement.close()
            connection.close()

            call.respondText("Student Saved Successfully")
        }

        get("/file-upload") {

            call.respondHtml {

                body {

                    h2 {
                        +"File Upload Demo"
                    }

                    form(
                        action = "/upload",  //After clicking Upload send data to /upload
                        method = FormMethod.post,  //Send data to server
                        encType = FormEncType.multipartFormData
                    ) {

                        p {
                            +"Student Name"
                        }

                        textInput(name = "name")

                        p {
                            +"Choose File"
                        }

                        fileInput(name = "file")

                        br
                        br

                        button(type = ButtonType.submit) {
                            +"Upload"
                        }
                    }
                }
            }
        }

        post("/upload") {


            // Store received name and filename
            var studentName = ""
            var fileName = ""

            val multipart = call.receiveMultipart()

            // Check each part sent by the browser

            multipart.forEachPart { part ->

                when (part) {

                    is PartData.FormItem -> {
                        if (part.name == "name") {
                            studentName = part.value
                        }
                    }

                    is PartData.FileItem -> {
                        fileName = part.originalFileName ?: "Unknown"
                    }

                    else -> {}
                }

                part.dispose()
            }

            call.respondText(
                "Name: $studentName\nFile: $fileName"
            )
        }
    }
}