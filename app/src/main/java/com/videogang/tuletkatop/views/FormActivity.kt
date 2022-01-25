package com.videogang.tuletkatop.views

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.videogang.tuletkatop.databinding.ActivityFormBinding
import com.videogang.tuletkatop.viewmodels.FormViewModel
import com.videogang.tuletkatop.views.fragments.*

class FormActivity : FragmentActivity() {
    private lateinit var binding: ActivityFormBinding
    private lateinit var vm: FormViewModel

    private val formList = listOf(
        PrivacyPolicyFragment::class.java,
        SportsFragment::class.java,
        BoardGameFragment::class.java,
        RunFragment::class.java,
        MaritalFragment::class.java,
        NameFragment::class.java,
        CityFragment::class.java,
        PhotoFragment::class.java
    )
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this).get(FormViewModel::class.java)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, formList[position].newInstance())
            .commit()



        subscribeToVM()
    }

    private fun subscribeToVM() {
        vm.showNextForm.observe(this) {
            position += 1
            if (position >= formList.size) {
                RegisterFinalDialogFragment().show(supportFragmentManager, null)
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainerView.id, formList[position].newInstance())
                    .commit()
            }
        }
    }
}