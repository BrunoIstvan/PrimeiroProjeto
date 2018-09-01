package br.com.bicmsystems.primeiroprojeto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.bicmsystems.primeiroprojeto.extensions.isEmpty
import br.com.bicmsystems.primeiroprojeto.extensions.showShortToast
import br.com.bicmsystems.primeiroprojeto.extensions.value
import br.com.bicmsystems.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_formulario.*


class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        btCalcular.setOnClickListener {
            calculaIMC()
            //chamaTelaResultado()
        }
        btLimpar.setOnClickListener { limpaCampos() }

    }

    fun chamaTelaResultado() {
        val telaResultadoIntent = Intent(this, ResultadoActivity::class.java)
        telaResultadoIntent.putExtra(ConstantesExtra.KEY_PESO, inputPeso.value())
        telaResultadoIntent.putExtra(ConstantesExtra.KEY_ALTURA, inputAltura.value())
        startActivity(telaResultadoIntent)
    }

    fun calculaIMC() {

        val pesoStr = inputPeso?.editText?.text.toString()
        val alturaStr = inputAltura?.editText?.text.toString()
        if(pesoStr.isNullOrEmpty() || pesoStr.isNullOrBlank()) {
            //Toast.makeText(this, "Informe o peso", Toast.LENGTH_SHORT).show()
            showShortToast(this@FormularioActivity, "Informe o peso")
            return
        }
        if(alturaStr.isNullOrEmpty() || alturaStr.isNullOrBlank()) {
            //Toast.makeText(this, "Informe a altura", Toast.LENGTH_SHORT).show()
            showShortToast(this@FormularioActivity, "Informe a altura")
            return
        }
        val peso: Double = pesoStr.toDouble()
        val altura: Double = alturaStr.toDouble()
        var imc: Double = 0.0
        if (altura > 100) {
            imc = peso / (altura / 100 * altura / 100)
        } else {
            imc = peso / (altura * altura)
        }
        tvResultado?.setText(imc.toString())

    }

    fun limpaCampos() {
        inputPeso.editText?.text?.clear()
        inputAltura.editText?.text?.clear()
        inputPeso.editText?.requestFocus()
    }


}

