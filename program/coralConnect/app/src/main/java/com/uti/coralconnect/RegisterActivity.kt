package com.uti.coralconnect

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uti.coralconnect.database.DatabaseHelper
import com.uti.coralconnect.databinding.ActivityRegister2Binding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegister2Binding
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegister2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseHelper = DatabaseHelper(this)


        binding.butonContinueRegister.setOnClickListener {

            val valueInputUser = binding.username.text.toString()
            val valuePassword = binding.password.text.toString()

            registerMove(valueInputUser,valuePassword)
        }

    }

    private fun registerMove(username: String, password: String){
        val inputData = databaseHelper.insertUser(username,password)

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}