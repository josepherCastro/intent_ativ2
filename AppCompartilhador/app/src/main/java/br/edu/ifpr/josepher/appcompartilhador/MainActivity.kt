package br.edu.ifpr.josepher.appcompartilhador

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btImagem.setOnClickListener {
            val intent = Intent(ACTION_GET_CONTENT)
            intent.type="image/*"
            startActivityForResult(Intent.createChooser(intent, "Selecione a imagem"), 13)
        }
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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 13 && resultCode == Activity.RESULT_OK) {
            val uri = data?.data

            val shareIntent = Intent(Intent.ACTION_SEND)
            with(shareIntent){
                putExtra(Intent.EXTRA_STREAM,uri)
                type = "image/"
                startActivity(Intent.createChooser(shareIntent, "Olha vc aki!"))
            }
        }
    }
}