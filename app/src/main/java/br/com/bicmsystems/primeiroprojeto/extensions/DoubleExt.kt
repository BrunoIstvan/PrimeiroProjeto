package br.com.bicmsystems.primeiroprojeto.extensions

fun Double.format(digitos: Int) = String.format("%.${digitos}f", this)