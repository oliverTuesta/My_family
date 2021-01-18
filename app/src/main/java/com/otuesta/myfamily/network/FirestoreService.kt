package com.otuesta.myfamily.network

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.GeoPoint
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
                val list = arrayListOf<Family>()
                result.forEach {
                    val family = Family(it.get("name").toString())
                    family.setBirthday(it.get("birthday") as Timestamp)
                    family.setLocation(it.get("location") as GeoPoint)
                    family.setPhone(it.get("phone").toString())
                    family.setPhoto(it.get("photo").toString())
                    list.add(family)
                }
                callback.onSucces(list)
            }.addOnFailureListener { exception ->
                callback.onFail(exception)
            }
    }


}