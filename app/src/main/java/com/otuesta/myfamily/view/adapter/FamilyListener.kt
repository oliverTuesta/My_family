package com.otuesta.myfamily.view.adapter

import com.otuesta.myfamily.model.Person

interface FamilyListener {

    fun onPersonClicked(person: Person, position: Int)

}