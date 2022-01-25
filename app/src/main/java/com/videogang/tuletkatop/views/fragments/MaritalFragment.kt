package com.videogang.tuletkatop.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.videogang.tuletkatop.databinding.FragmentMaritalBinding
import com.videogang.tuletkatop.viewmodels.FormViewModel


class MaritalFragment : Fragment() {
    private lateinit var binding: FragmentMaritalBinding
    private lateinit var vm: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMaritalBinding.inflate(layoutInflater)
        vm = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        binding.buttonDivorced.setOnClickListener{
            vm.nextForm()
        }
        binding.buttonNoMarried.setOnClickListener{
            vm.nextForm()
        }
        binding.buttonWidower.setOnClickListener{
            vm.nextForm()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}