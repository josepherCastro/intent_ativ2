package br.edu.ifpr.josepher.appcompartilhador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCompartilhar.setOnClickListener{
            compartilha(campoTexto.text.toString())
        }
    }

    fun compartilha(conteudo: String){
        val compartilhaIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,conteudo)
            type = "text/plain"
        }
        startActivity(compartilhaIntent)
    }

}