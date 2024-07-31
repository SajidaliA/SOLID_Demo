package com.example.solid_demo

import com.google.firebase.auth.FirebaseAuth
// 5th Principle Dependency inversion is following here
// Because we are not depend on only firebase authentication.
// We can replace the it with our own API authentication.
interface Authenticator {
    suspend fun signInWithEmailAndPassword(email: String, password: String)
}

class FirebaseAuthenticator: Authenticator{
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
    }
}

class CustomAuthenticator : Authenticator{
    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        // Custom authenticator can be use here
    }

}