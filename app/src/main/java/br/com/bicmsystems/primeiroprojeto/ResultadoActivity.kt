package br.com.bicmsystems.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.bicmsystems.primeiroprojeto.extensions.showShortToast
import br.com.bicmsystems.primeiroprojeto.utils.ConstantesExtra

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resultado)



        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)

        //Toast.makeText(this, "Estoy aqui", Toast.LENGTH_SHORT).show()
        showShortToast(this, "Estoy aqui")

    }
}
