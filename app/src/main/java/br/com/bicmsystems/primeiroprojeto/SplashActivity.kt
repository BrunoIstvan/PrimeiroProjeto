package br.com.bicmsystems.primeiroprojeto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        carregar()

    }

    /**
     * Método que será executado logo que a tela é criada
     */
    private fun carregar() {

        Handler().postDelayed({
            chamarProximaTela()
        }, 2000L)

    }

    /**
     * Método que chama a tela de Formulario
     */
    private fun chamarProximaTela() {

        // criando uma intent pra abrir a tela FormularioActivity
        val intent = Intent(this, FormularioActivity::class.java)
        startActivity(intent)
        finish()

    }


}
