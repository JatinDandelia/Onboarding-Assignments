package com.example.urlopener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOpen.setOnClickListener {
            val url = tvURL.text.toString()
//            val openURL = Intent(android.content.Intent.ACTION_VIEW)
//            openURL.data = Uri.parse(url)
//            startActivity(openURL)


//            val myWebView: WebView = findViewById(R.id.WebView)
//            myWebView.loadUrl("https://browserstack.com")

            webView.webViewClient = WebViewClient()
            webView.loadUrl(url)
            webView.settings.javaScriptEnabled = true
            webView.settings.setSupportZoom(true)
        }
    }

    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webView.canGoBack())
            webView.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}