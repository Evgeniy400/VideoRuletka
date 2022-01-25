package com.videogang.tuletkatop.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.videogang.tuletkatop.db.ProfileBase
import com.videogang.tuletkatop.model.Profile

class FeedViewModel: ViewModel() {
    private var peoples_ = MutableLiveData(ProfileBase.getProfileBase().ankets)
    var peoples: LiveData<List<Profile>> = peoples_
}