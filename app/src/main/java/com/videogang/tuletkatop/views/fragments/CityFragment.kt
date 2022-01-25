package com.videogang.tuletkatop.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.videogang.tuletkatop.R
import com.videogang.tuletkatop.databinding.FragmentCityBinding
import com.videogang.tuletkatop.viewmodels.FormViewModel

class CityFragment : Fragment() {
    private lateinit var binding: FragmentCityBinding
    private lateinit var vm: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCityBinding.inflate(layoutInflater)
        vm = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        binding.buttonCity.setOnClickListener {
            if (binding.editTextCity.text.toString().isEmpty()) {
                Toast.makeText(
                    requireActivity(),
                    resources.getText(R.string.empty_city),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                vm.setCity(binding.editTextCity.text.toString())
            }
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