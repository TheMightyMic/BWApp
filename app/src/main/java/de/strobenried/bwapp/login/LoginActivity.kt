package de.strobenried.bwapp.login


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import de.strobenried.bwapp.MainActivity
import de.strobenried.bwapp.R


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText

    private lateinit var signupBtn: Button
    private lateinit var loginBtn: Button

    private lateinit var resetPasswordTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEt = findViewById(R.id.email_edt_text)
        passwordEt = findViewById(R.id.pass_edt_text)

        signupBtn = findViewById(R.id.signup_btn)
        loginBtn = findViewById(R.id.login_btn)

        resetPasswordTv = findViewById(R.id.reset_pass_tv)

        auth = FirebaseAuth.getInstance()

        this.loadLoginInformation()

        loginBtn.setOnClickListener {
            val email: String = emailEt.text.toString()
            val password: String = passwordEt.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this@LoginActivity, getString(R.string.login_field_missing), Toast.LENGTH_LONG).show()
            } else{
                loginToDb(email,password)
            }
        }

        signupBtn.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        resetPasswordTv.setOnClickListener{
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
    private fun loginToDb(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
            if(task.isSuccessful) {
                Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_LONG).show()
                saveAuthValues(email,password)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun saveAuthValues(email: String, password: String) {
        val sharedPrefs = getSharedPreferences("Login", Context.MODE_PRIVATE).edit()
        sharedPrefs.putString("Email", email)
        sharedPrefs.putString("Password", password)
        sharedPrefs.apply()
    }

    private fun loadLoginInformation() {
        val sp1 = getSharedPreferences("Login", Context.MODE_PRIVATE)

        val email = sp1.getString("Email", null)
        val password = sp1.getString("Password", null)

        if(email.isNullOrEmpty() || password.isNullOrEmpty()) { return }
        else{
            loginToDb(email,password)
        }
    }
}