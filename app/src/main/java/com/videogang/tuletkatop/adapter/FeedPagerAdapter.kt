package com.videogang.tuletkatop.adapter

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.videogang.tuletkatop.model.Profile
import com.videogang.tuletkatop.views.fragments.*

class FeedPagerAdapter(fa: FragmentActivity, peoples: List<Profile>) : FragmentStateAdapter(fa) {
    var ankets = peoples

    override fun getItemCount() = ankets.size

    override fun createFragment(position: Int) = PeopleFragment().also {
        it.arguments = Bundle().apply {
            putParcelable(PeopleFragment.PROFILE, ankets[position])
        }
    }
}