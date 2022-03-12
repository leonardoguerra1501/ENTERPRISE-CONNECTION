package br.com.fiap.enterprisecnx01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PgCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pg_cadastro)
    }

    fun onClickLogIn(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }


}