package com.videogang.tuletkatop.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.videogang.tuletkatop.databinding.FragmentBoardGameBinding
import com.videogang.tuletkatop.viewmodels.FormViewModel

class BoardGameFragment : Fragment() {
    private lateinit var binding: FragmentBoardGameBinding
    private lateinit var vm: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBoardGameBinding.inflate(layoutInflater)
        vm = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        binding.buttonNo.setOnClickListener {
            vm.nextForm()
        }
        binding.buttonYes.setOnClickListener {
            vm.nextForm()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}