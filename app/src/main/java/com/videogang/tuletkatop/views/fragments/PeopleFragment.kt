package com.videogang.tuletkatop.views.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.loadAny
import com.videogang.tuletkatop.R
import com.videogang.tuletkatop.databinding.FragmentPeopleBinding
import com.videogang.tuletkatop.model.Profile
import com.videogang.tuletkatop.views.ProfileActivity

class PeopleFragment : Fragment() {
    private lateinit var binding: FragmentPeopleBinding
    private var profile: Profile? = null
    private var isLiked = false
    private var isDisliked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPeopleBinding.inflate(layoutInflater)
        arguments?.let {
            profile = it.getParcelable(PROFILE)
        }

        binding.imageButtonProfile.setOnClickListener {
            startActivity(Intent(requireActivity(), ProfileActivity::class.java).apply {
                putExtra(ProfileActivity.PROFILE, profile)
            })
        }

        binding.imageButtonLike.setOnClickListener {
            if (isLiked) {
                binding.imageButtonLike.setImageResource(R.drawable.like)
            } else {
                isDisliked = false
                binding.imageButtonDislike.setImageResource(R.drawable.dislike)
                binding.imageButtonLike.setImageResource(R.drawable.like_pressed)
            }
            isLiked = !isLiked
        }

        binding.imageButtonDislike.setOnClickListener {
            if (isDisliked) {
                binding.imageButtonDislike.setImageResource(R.drawable.dislike)
            } else {
                isLiked = false
                binding.imageButtonLike.setImageResource(R.drawable.like)
                binding.imageButtonDislike.setImageResource(R.drawable.dislike_pressed)
            }
            isDisliked = !isDisliked
        }

        setData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setData() {
        binding.imageView.loadAny(profile?.photo)
    }

    companion object {
        const val PROFILE = "profile"
    }

}