package com.otuesta.myfamily.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.otuesta.myfamily.R
import com.otuesta.myfamily.model.Family

class FamilyDetailFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_family_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tbFamilyDetail: Toolbar = view.findViewById(R.id.tbFamilyDetail)
        tbFamilyDetail.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        tbFamilyDetail.setTitleTextColor(Color.WHITE)
        tbFamilyDetail.setNavigationOnClickListener{
            dismiss()
        }

        val family = arguments?.getSerializable("family") as Family

        val ivImageFamily = view.findViewById<ImageView>(R.id.ivFamilyDetailPicture)
        val tvNameFamily = view.findViewById<TextView>(R.id.tvNameFamily)
        val tvBirthdayFamily = view.findViewById<TextView>(R.id.tvBirthday)
        val tvPhone = view.findViewById<TextView>(R.id.tvPhone)

        tvPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:${family.phone}")
            startActivity(intent)
        }

        Glide.with(view.context)
            .load(family.photo)
            .into(ivImageFamily)

        tvNameFamily.text = family.name
        tvBirthdayFamily.text = family.birthday
        tvPhone.text = family.phone
    }

    override fun onStart() {
        super.onStart()
    }

}