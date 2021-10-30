package com.svdroid.mymems.creadentials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.svdroid.mymems.HomeActivity
import com.svdroid.mymems.R
import com.svdroid.mymems.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        initcallBack()
    }

    private fun initcallBack() {
        binding.txtGo.setOnClickListener(this)
        binding.txtNewAccount.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        binding.apply {
            when (v) {
                txtGo -> {
                    validation()
                }
                txtNewAccount -> {
                    startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
                }
            }
        }

    }

    private fun validation() {
        val email = binding.etEmail.text?.trim().toString()
        val pass = binding.etPass.text?.trim().toString()
        if (email.isNullOrEmpty() || pass.isNullOrEmpty()) {
            //            toast("pls enter your credential")
            binding.etEmail.error = "Enter email address"
            binding.etPass.error = "Enter password"
            return
        }
        if (!isValidString(email)) {
            binding.etEmail.error = "enter email in valid format"
            return
        }

        goToNextActivity()
    }

    private fun goToNextActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    fun isValidString(email: String): Boolean {
        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }


}