package com.example.app_trs_webview_poc

import android.app.AlertDialog
import android.webkit.JavascriptInterface

class WebAppInterface(private val context: MainActivity) {
    private var a = 0
    private var b = 0
    private var answer = 0;

    @JavascriptInterface
    fun getUsername (): String {
        return this.context.getUserName().toString();
    }

    @JavascriptInterface
    fun setProblemConfig (a: Int, b: Int, answer: Int) {
        this.a = a;
        this.b = b;
        this.answer = answer;
    }

    @JavascriptInterface
    fun checkAnswer () {
        var title = "Your answer is correct!"
        val result = this.a + this.b;
        var message = "${this.a} + ${this.b} equals $result"

        if (result != this.answer) {
            title = "Sorry, that's not correct!"
        }

        AlertDialog
            .Builder(this.context)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton(android.R.string.ok, null)
            .show()
    }
}