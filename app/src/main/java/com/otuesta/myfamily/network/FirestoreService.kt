package com.otuesta.myfamily.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.otuesta.myfamily.model.Person

const val FAMILY_COLLECTION_NAME: String = "persons"

class FirestoreService {

    val firebaseFirestor = FirebaseFirestore.getInstance()

    //datos offline
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestor.firestoreSettings = settings
    }

    fun getFamily(callback: Callback<List<Person>>) {
        firebaseFirestor.collection(FAMILY_COLLECTION_NAME)
            .orderBy("name")
            .get().addOnSuccessListener { result ->
                val list = result.toObjects(Person::class.java)
                callback.onSucces(list)
            }
    }


}