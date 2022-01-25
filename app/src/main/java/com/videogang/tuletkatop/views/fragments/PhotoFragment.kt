package com.videogang.tuletkatop.views.fragments

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.videogang.tuletkatop.R
import com.videogang.tuletkatop.databinding.FragmentPhotoBinding
import com.videogang.tuletkatop.viewmodels.FormViewModel


class PhotoFragment : Fragment() {
    private lateinit var binding: FragmentPhotoBinding
    private lateinit var vm: FormViewModel
    private var image: String? = null
    private val REQUEST_GALLERY = 0

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPhotoBinding.inflate(layoutInflater)
        vm = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        binding.buttonLoad.setOnClickListener {
            getPhoto()
        }

        binding.buttonNext.setOnClickListener {
            if (image == null) {
                Toast.makeText(
                    requireActivity(),
                    resources.getString(R.string.choose_photo),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                vm.setPhoto(image!!)
            }
        }
        binding.imageButtonSkip.setOnClickListener {
            vm.setPhoto(resources.getDrawable(R.drawable.women_placeholder).toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private fun getPhoto() {
        val photoPickerIntent = Intent(Intent.ACTION_PICK).apply { type = "image/*" }
        try {
            startActivityForResult(photoPickerIntent, REQUEST_GALLERY)
        } catch (e: Exception) {
            Toast.makeText(
                requireActivity(),
                resources.getString(R.string.error_photo_upload),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_GALLERY -> {
                if (resultCode == RESULT_OK) {
                    if (data == null) {
                        image = resources.getDrawable(R.drawable.women_placeholder).toString()
                        binding.imageViewPreview.setImageResource(R.drawable.women_placeholder)
                    } else {
                        image = data.data.toString()
                        binding.imageViewPreview.setImageURI(data.data)
                    }
                }
            }
        }
    }
}