package com.otuesta.myfamily.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint
import java.io.Serializable
import java.util.*

class Family(private val name: String) : Serializable {

    private lateinit var birthday: Date
    private lateinit var phone: String
    private lateinit var photo: String
    private lateinit var location: GeoPoint

    fun setBirthday(birthday: Timestamp) {
        this.birthday = birthday.toDate()
    }

    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun setPhoto(photo: String) {
        this.photo = photo
    }

    fun setLocation(location: GeoPoint) {
        this.location = location
    }

    fun getName(): String {
        return name
    }

    fun getBirthday(): Date {
        return birthday
    }

    fun getPhone(): String {
        return phone
    }

    fun getPhoto(): String {
        return photo
    }

    fun getLocation(): GeoPoint {
        return location
    }


}