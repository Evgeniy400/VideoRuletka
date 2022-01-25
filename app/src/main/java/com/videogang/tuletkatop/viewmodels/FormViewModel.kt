package com.videogang.tuletkatop.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.videogang.tuletkatop.db.ProfileBase
import com.videogang.tuletkatop.model.Profile
import com.videogang.tuletkatop.service.SingleLiveEvent

class FormViewModel : ViewModel() {
    private var profile_ = MutableLiveData(ProfileBase.getProfileBase().profile)
    var showNextForm = SingleLiveEvent<Unit>()
    var profile: LiveData<Profile> = profile_

    fun nextForm() {
        showNextForm.call()
    }

    fun setName(name: String) {
        ProfileBase.getProfileBase().profile.name = name
        showNextForm.call()
    }

    fun setCity(city: String) {
        ProfileBase.getProfileBase().profile.city = city
        showNextForm.call()
    }

    fun setPhoto(data: String) {
        ProfileBase.getProfileBase().profile.photo = data
        showNextForm.call()
    }
}