package com.otuesta.myfamily.view.adapter

import com.otuesta.myfamily.model.Family

interface FamilyListener {

    fun onFamilyClicked(family: Family, position: Int)

}