package com.otuesta.myfamily.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.otuesta.myfamily.R
import com.otuesta.myfamily.model.Family
import com.otuesta.myfamily.view.adapter.FamilyAdapter
import com.otuesta.myfamily.view.adapter.FamilyListener
import com.otuesta.myfamily.viewModel.FamilyViewModel

class FamilyFragment : Fragment(), FamilyListener {

    private lateinit var familyAdapter: FamilyAdapter
    private lateinit var viewModel: FamilyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_family, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FamilyViewModel::class.java)
        viewModel.refresh()

        familyAdapter = FamilyAdapter(this)

        val rvFamily: RecyclerView = view.findViewById(R.id.rvFamily)
        rvFamily.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = familyAdapter
        }
        observeViewModel(view)

        }

    fun observeViewModel(view: View) {
        viewModel.listFamily.observe(viewLifecycleOwner, Observer<List<Family>> { family ->
            familyAdapter.updateData(family)
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            val rvBase = view.findViewById<RelativeLayout>(R.id.rlBaseSchedule)
            if (it != null) rvBase.visibility = View.INVISIBLE
        })
    }

    override fun onFamilyClicked(family: Family, position: Int) {
        val bundle = bundleOf("family" to family)
        findNavController().navigate(R.id.familyDetailFragment, bundle)
    }

}
