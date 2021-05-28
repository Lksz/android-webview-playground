package com.example.app_trs_webview_poc

import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class WebPlatform (private val context: MainActivity) {
    private val url = "https://lksz.github.io/webview-poc/"
    private val webView =this.context.findViewById<WebView>(R.id.test_webview)

    fun load () {
        val webInterface = WebAppInterface(this.context)
        this.webView.settings.javaScriptEnabled = true
        this.webView.addJavascriptInterface(webInterface, "androidInterface")
        this.webView.loadUrl(this.url)
    }
}