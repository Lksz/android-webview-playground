package com.example.app_trs_webview_poc

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setupForm()
    }

    fun getUserName (): Editable {
        return findViewById<EditText>(R.id.username).text
    }

    private fun setupForm () {
        findViewById<Button>(R.id.my_first_button).setOnClickListener {
            val username = this.getUserName()

            if (username.isEmpty()) {
                this.showMissingUsernameAlert();
            } else {
                this.loadExternalPage();
            }
        }
    }

    private fun loadExternalPage () {
        WebPlatform(this).load()
    }

    private fun showMissingUsernameAlert () {
        AlertDialog
            .Builder(this)
            .setTitle("Validation error!")
            .setMessage("You must provide username")
            .setNegativeButton(android.R.string.ok, null)
            .show()
    }
}

