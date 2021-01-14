package com.otuesta.myfamily.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.otuesta.myfamily.model.Family

const val FAMILY_COLLECTION_NAME: String = "persons"

class FirestoreService {

    val firebaseFirestor = FirebaseFirestore.getInstance()

    //datos offline
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestor.firestoreSettings = settings
    }

    fun getFamily(callback: Callback<List<Family>>) {
        firebaseFirestor.collection(FAMILY_COLLECTION_NAME)
            .orderBy("name")
            .get().addOnSuccessListener { result ->
                result.forEach {
                    var family = it.toObject(Family::class.java)
                    println(family.name)
                }
                val list = result.toObjects(Family::class.java)
                callback.onSucces(list)
            }.addOnFailureListener { exception ->
                callback.onFail(exception)
            }
    }


}