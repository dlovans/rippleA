package dev.dlovan.ripplea

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Singleton

@HiltAndroidApp
class RippleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

@Singleton
class FirebaseManager @Inject constructor() {
    val auth: FirebaseAuth = Firebase.auth
    val db: FirebaseFirestore = Firebase.firestore
}

