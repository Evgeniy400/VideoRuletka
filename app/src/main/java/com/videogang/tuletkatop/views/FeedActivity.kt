package com.videogang.tuletkatop.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.videogang.tuletkatop.adapter.FeedPagerAdapter
import com.videogang.tuletkatop.databinding.ActivityFeedBinding
import com.videogang.tuletkatop.views.ProfileActivity
import com.videogang.tuletkatop.viewmodels.FeedViewModel
import com.videogang.tuletkatop.viewmodels.FormViewModel

class FeedActivity : FragmentActivity() {
    private lateinit var binding: ActivityFeedBinding
    private lateinit var vm: FeedViewModel
    private lateinit var vmProfile: FormViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this).get(FeedViewModel::class.java)
        vmProfile = ViewModelProvider(this).get(FormViewModel::class.java)

        binding.imageButtonProfile.setOnClickListener{
            startActivity(Intent(this, ProfileActivity::class.java).apply {
                putExtra(ProfileActivity.PROFILE, vmProfile.profile.value)
            })
        }


        vm.peoples.observe(this){
            binding.viewPager.adapter = FeedPagerAdapter(this, it)
        }

    }
}