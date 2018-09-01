package br.com.bicmsystems.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import br.com.bicmsystems.primeiroprojeto.extensions.format
import br.com.bicmsystems.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resultado)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)

        calculaIMC(peso.toDouble(), altura.toDouble())
    }

    private fun calculaIMC(peso: Double, altura: Double) {

        var imc = if (altura > 100) {
            peso / (altura / 100.0 * altura / 100.0)
        } else {
            peso / (altura * altura)
        }

        //defineDescricaoPorWhen(imc)
        definePorIf(imc)

        tvIMC.text = imc.format(1)
    }

    private fun defineDescricaoPorWhen(imc: Double) {
        /*
        when (imc) {
            in 0..16 -> {
                setImage(R.drawable.magreza)
                setIMCDescricao(R.string.magreza_grave)
            }
            in 16.1..16.9 -> {
                setImage(R.drawable.magreza)
                setIMCDescricao(R.string.magreza_leve)
            }
            in 17..18.4 -> {
                setImage(R.drawable.abaixo)
                setIMCDescricao(R.string.abaixo_peso)
            }
            in 18.5..24.9 -> {
                setImage(R.drawable.ideal)
                setIMCDescricao(R.string.peso_ideal)
            }
            in 25..29.9 -> {
                setImage(R.drawable.sobre)
                setIMCDescricao(R.string.sobrepeso)
            }
            in 30..34.9 -> {
                setImage(R.drawable.obesidade)
                setIMCDescricao(R.string.obesidade_1)
            }
            in 35..39.9 -> {
                setImage(R.drawable.obesidade)
                setIMCDescricao(R.string.obesidade_2)
            }
            else -> {
                setImage(R.drawable.obesidade)
                setIMCDescricao(R.string.obesidade_3)
            }
        }
        */
    }

    private fun definePorIf(imc: Double) {
        if (imc > 0 && imc < 16) {
            setImage(R.drawable.magreza)
            setIMCDescricao(R.string.magreza_grave)
        } else if(imc >= 16 && imc < 17) {
            setImage(R.drawable.magreza)
            setIMCDescricao(R.string.magreza_leve)
        } else if (imc >= 17 && imc < 18.5) {
            setImage(R.drawable.abaixo)
            setIMCDescricao(R.string.abaixo_peso)
        } else if (imc >= 18.5 && imc < 25) {
            setImage(R.drawable.ideal)
            setIMCDescricao(R.string.peso_ideal)
        } else if (imc >= 25 && imc < 30) {
            setImage(R.drawable.sobre)
            setIMCDescricao(R.string.sobrepeso)
        } else if (imc >= 30 && imc < 35) {
            setImage(R.drawable.obesidade)
            setIMCDescricao(R.string.obesidade_1)
        } else if (imc >= 35 && imc < 40) {
            setImage(R.drawable.obesidade)
            setIMCDescricao(R.string.obesidade_2)
        } else  {
            setImage(R.drawable.obesidade)
            setIMCDescricao(R.string.obesidade_3)
        }
    }

    private fun setIMCDescricao(resourceString: Int) {
        tvIMCDescricao.text =  getString(resourceString)
    }

    private fun setImage(resourceId: Int) {
        ivCorpo.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
