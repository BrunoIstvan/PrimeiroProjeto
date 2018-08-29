package br.com.bicmsystems.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.Button
import android.widget.TextView

class FormularioActivity : AppCompatActivity(), View.OnClickListener {

    var edt_peso: TextInputLayout? = null
    var edt_altura: TextInputLayout? = null
    var tv_resultado: TextView? = null
    var btn_calcular: Button? = null
    var btn_limpar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        edt_peso = findViewById(R.id.edt_peso)
        edt_altura = findViewById(R.id.edt_altura)
        tv_resultado = findViewById(R.id.tv_resultado)
        btn_calcular = findViewById(R.id.btn_calcular)
        btn_calcular?.setOnClickListener(this)
        btn_limpar = findViewById(R.id.btn_limpar)
        btn_limpar?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v) {
            btn_calcular -> {
                val peso: Double = edt_peso?.editText?.text.toString().toDouble()
                val altura: Double = edt_altura?.editText?.text.toString().toDouble()
                var imc: Double = 0.0
                if (altura > 100) {
                    imc = peso / (altura / 100 * altura / 100)
                } else {
                    imc = peso / (altura * altura)
                }
                tv_resultado?.setText(imc.toString())
            }
            btn_limpar -> {
                edt_peso?.editText?.setText("")
                edt_altura?.editText?.setText("")
                tv_resultado?.setText(resources.getString(R.string.label_resultado))
            }
        }

    }


}

