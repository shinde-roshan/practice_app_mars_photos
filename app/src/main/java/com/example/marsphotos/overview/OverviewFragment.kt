package com.example.marsphotos.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marsphotos.databinding.FragmentOverviewBinding
import com.example.marsphotos.databinding.GridViewItemBinding


class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val binding = FragmentOverviewBinding.inflate(layoutInflater)
        val binding = GridViewItemBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

}