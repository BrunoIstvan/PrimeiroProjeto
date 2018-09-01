package br.com.bicmsystems.primeiroprojeto.extensions

import android.support.design.widget.TextInputLayout

fun TextInputLayout.clear() = {
    this.editText?.setText("")
}

fun TextInputLayout.value() = this.editText?.text.toString()

fun TextInputLayout.isEmpty() =
        this.editText?.text.toString().isNullOrBlank() ||
        this.editText?.text.toString().isNullOrEmpty()
