package br.com.bicmsystems.primeiroprojeto.extensions

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

fun AppCompatActivity.showShortToast(context: Context, text: String): Toast {
    return Toast.makeText(context, text, Toast.LENGTH_SHORT).apply { show() }
}

fun AppCompatActivity.showLongToast(context: Context, text: String): Toast {
    return Toast.makeText(context, text, Toast.LENGTH_LONG).apply {  show() }
}