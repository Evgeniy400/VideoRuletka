package com.videogang.tuletkatop.views

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.videogang.tuletkatop.R
import com.videogang.tuletkatop.databinding.ActivityWebBinding
import kotlinx.android.synthetic.main.activity_web.*

private var myFilePathCallback: ValueCallback<Array<Uri>>? = null

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    private val UPLOAD_PHOTO = 1

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.settings.apply {
            javaScriptEnabled = true
            loadsImagesAutomatically = true
            allowFileAccess = true
        }
        binding.webView.webViewClient = MyWebViewClient()
        binding.webView.webChromeClient = MyWebChromeClient()

        CookieManager.getInstance().apply {
            acceptCookie()
            acceptThirdPartyCookies(binding.webView)
        }

        intent.extras?.getString(URL)?.let {
            Toast.makeText(
                this,
                resources.getString(R.string.open_web) + ' ' + it,
                Toast.LENGTH_SHORT
            ).show()
            binding.webView.loadUrl(it)
        }
    }


    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        }
    }


    private inner class MyWebChromeClient : WebChromeClient() {
        override fun onShowFileChooser(
            webView: WebView?,
            filePathCallback: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
            if (myFilePathCallback != null) {
                myFilePathCallback!!.onReceiveValue(null)
                myFilePathCallback = null
            }
            myFilePathCallback = filePathCallback

            try {
                startActivityForResult(fileChooserParams?.createIntent(), UPLOAD_PHOTO)
            } catch (e: Exception) {
                myFilePathCallback = null
                Toast.makeText(
                    this@WebActivity,
                    resources.getString(R.string.error_photo_upload),
                    Toast.LENGTH_SHORT
                ).show()
            }

            return true
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            UPLOAD_PHOTO -> {
                myFilePathCallback?.onReceiveValue(
                    WebChromeClient.FileChooserParams.parseResult(
                        resultCode,
                        data
                    )
                )
            }
        }
    }

    private inner class MyWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }

        // Для старых устройств
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }


    companion object {
        const val URL = "URL"
    }
}