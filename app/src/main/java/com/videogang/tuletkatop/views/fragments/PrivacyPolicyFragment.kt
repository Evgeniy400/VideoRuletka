package com.videogang.tuletkatop.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.videogang.tuletkatop.databinding.FragmentPrivacyPolicyBinding
import com.videogang.tuletkatop.viewmodels.FormViewModel

class PrivacyPolicyFragment : Fragment() {
    private lateinit var binding: FragmentPrivacyPolicyBinding
    private lateinit var vm: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPrivacyPolicyBinding.inflate(layoutInflater)
        vm = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        binding.privacyPolicyCheckBox.setOnClickListener {
            binding.privacyPolicyButton.isClickable = binding.privacyPolicyCheckBox.isChecked
        }

        binding.privacyPolicyButton.setOnClickListener {
            vm.nextForm()
        }
        binding.privacyPolicyButton.isClickable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}