package com.videogang.tuletkatop.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.loadAny

import coil.transform.*
import com.videogang.tuletkatop.databinding.ActivityProfileBinding
import com.videogang.tuletkatop.model.Profile

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.getParcelable<Profile>(PROFILE)?.let {
            setData(it)
        }
    }

    private fun setData(profile: Profile) {
        binding.apply {
            imageView.loadAny(profile.photo)
            city.text = profile.city
            name.text = profile.name
        }
    }

    companion object {
        const val PROFILE = "profile"
    }
}