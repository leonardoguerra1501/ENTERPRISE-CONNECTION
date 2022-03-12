package br.com.fiap.enterprisecnx01

import android.content.Intent
import android.net.Credentials
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.enterprisecnx01.databinding.ActivityMainBinding
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider



class MainActivity : AppCompatActivity() {

    private lateinit var account: Auth0
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val goToHome = findViewById<Button>(R.id.btnLoginNtv)

        goToHome.setOnClickListener {
            val i = Intent(this, PageHome::class.java)
            startActivity(i)
        }


        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            loginWithBrowser()
        }

        account = Auth0(
            "9onIOkDNkm0y7WZAhpRKijZTlk0amZUw",
            "dev-txyag4u2.us.auth0.com"
        )



    }


    private fun loginWithBrowser() {
        // Setup the WebAuthProvider, using the custom scheme and scope.

        WebAuthProvider.login(account)
            .withScheme("demo")
            .withScope("openid profile email")
            .start(this, object : Callback<Credentials, AuthenticationException>{
                override fun onFailure(exception: AuthenticationException) {
                    // Something went wrong!
                }

                // Called when authentication completed successfully
                override fun onSuccess(credentials: com.auth0.android.result.Credentials) {
                    // Get the access token from the credentials object.
                    // This can be used to call APIs
                    val accessToken = credentials.accessToken
                }
            })
    }


    fun onClickCadastro(view: View) {
        val i = Intent(this, PgCadastro::class.java)
        startActivity(i)
    }
}


