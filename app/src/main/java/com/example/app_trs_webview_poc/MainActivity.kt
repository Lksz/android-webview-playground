package com.example.app_trs_webview_poc

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setupForm()
    }

    private fun setupForm () {
        findViewById<Button>(R.id.my_first_button).setOnClickListener {
            val username = this.getUserName()

            if (username.isEmpty()) {
                this.showMissingUsernameAlert();
            } else {
                this.goToPage();
            }
        }
    }

    private fun getUserName (): String {
        return findViewById<EditText>(R.id.username).text.toString()
    }

    private fun goToPage () {}

    private fun showMissingUsernameAlert () {
        AlertDialog
            .Builder(this)
            .setTitle("Validation error!")
            .setMessage("You must provide username")
            .setNegativeButton(android.R.string.ok, null)
            .show()
    }
}

