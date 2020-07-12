package br.edu.ifpr.josepher.appcompartilhador

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_recebidor.*

class Recebidor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebidor)

        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    handleSendText(intent) // Handle text being sent
                } else if (intent.type?.startsWith("image/") == true) {
                    handleSendImage(intent) // Handle single image being sent
                }
            }
            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }
    }

    private fun handleSendImage(intent: Intent?) {
        (intent?.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
            imgRecebe.setImageURI(it)

        }
    }

    private fun handleSendText(intent: Intent?) {
        intent?.getStringExtra(Intent.EXTRA_TEXT)?.let {
            // Update UI to reflect text being shared
            txRecebe.text = it
        }
    }
}