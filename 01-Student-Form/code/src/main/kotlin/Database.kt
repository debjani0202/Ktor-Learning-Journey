package com.example


import java.sql.Connection
import java.sql.DriverManager

object Database {

    private const val URL = "jdbc:mysql://localhost:3307/mydb"
    private const val USER = "root"
    private const val PASSWORD = "root123"

    fun getConnection(): Connection   //Connection =returns a database connection.
    {

        //Take the connection MySQL gave me
        //and send it back to whoever called this function.
        return DriverManager.getConnection(
            URL,
            USER,
            PASSWORD
        )
    }
}

//step 1 :Kotlin goes to DriverManager
// step2 : it uses URL [ "jdbc:mysql://localhost:3307/mydb"],it knows databse and port (3307)
//step 3 : it uses password and  user
//step 4 : Is database running?,Is username correct,Is password correct?
// if yes then "Connection created successfully"
