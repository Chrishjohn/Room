package com.svdroid.mymems.creadentials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.svdroid.mymems.HomeActivity
import com.svdroid.mymems.R
import com.svdroid.mymems.databinding.ActivityLoginBinding
import com.svdroid.mymems.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        window.statusBarColor= ContextCompat.getColor(this, R.color.white)
        initCallBack()
    }

    private fun initCallBack() {
        binding.btnSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        binding.apply {
            when (v) {
                btnSignUp -> {
                    goToNextActivity()
                }
            }
        }
    }


    private fun goToNextActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }


}