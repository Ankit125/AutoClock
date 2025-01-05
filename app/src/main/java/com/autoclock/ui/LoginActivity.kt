package com.autoclock.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.autoclock.R
import com.autoclock.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val etUserName = findViewById<TextInputEditText>(R.id.mUserName)
        val etPassword = findViewById<TextInputEditText>(R.id.mPassword)
        val btnLogin = findViewById<Button>(R.id.mLogin)

        btnLogin.setOnClickListener {
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()
            if(userName.isNotEmpty() && password.isNotEmpty()){
                if(userName == "admin" && password == "admin"){
                    Toast.makeText(applicationContext, getString(R.string.LoginSuccessful), Toast.LENGTH_SHORT).show()
                    //startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                } else {
                    Toast.makeText(applicationContext, getString(R.string.PleaseEnterValidCredentials), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, getString(R.string.PleaseEnterValidCredentials), Toast.LENGTH_SHORT).show()
            }
        }
    }
}