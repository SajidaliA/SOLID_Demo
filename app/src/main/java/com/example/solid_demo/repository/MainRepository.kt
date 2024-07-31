package com.example.solid_demo.repository

import com.example.solid_demo.Authenticator
import com.example.solid_demo.FileLogger

class MainRepository (
    private val auth: Authenticator,
    private val fileLogger: FileLogger
) {
    suspend fun loginUser(email: String, password: String){
        try {
            auth.signInWithEmailAndPassword(email, password)
        }catch (e: Exception){
            fileLogger.logError(e.message.toString())
        }
    }
}