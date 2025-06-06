package br.com.gs.alunos_rm98656_rm98627

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RmActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rms_layout)

        val backBtn = findViewById<Button>(R.id.voltar)
        backBtn.setOnClickListener {
            finish()
        }
    }

}