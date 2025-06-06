package br.com.gs.alunos_rm98656_rm98627

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.com.gs.alunos_rm98656_rm98627.model.Evento
import br.com.gs.alunos_rm98656_rm98627.viewmodel.EventoAdapter
import br.com.gs.alunos_rm98656_rm98627.viewmodel.EventoViewModel
import br.com.gs.alunos_rm98656_rm98627.viewmodel.EventoViewModelFactory



class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EventoViewModel




    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val botaoIrParaRm = findViewById<Button>(R.id.buttonIrParaRm)

        botaoIrParaRm.setOnClickListener {
            val intent = Intent(this, RmActivity::class.java)
            startActivity(intent)
        }


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Estrela da morte causadora de catástrofes"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val eventoAdapter = EventoAdapter { evento ->
            viewModel.removeEvento(evento)
        }

        recyclerView.adapter = eventoAdapter
        val button = findViewById<Button>(R.id.button)
        val editLocal = findViewById<EditText>(R.id.nomeLocal)
        val editEvento = findViewById<EditText>(R.id.tipoEvento)
        val editImpacto = findViewById<EditText>(R.id.grauImpacto)
        val editData = findViewById<EditText>(R.id.data)
        val editPessoas = findViewById<EditText>(R.id.pessoasAfetadas)



        button.setOnClickListener {
            // Se o campo de texto estiver vazio, exibe um erro e retorna.
            if (editLocal.text.isEmpty()) {
                editLocal.error = "Preencha um valor"
                return@setOnClickListener
            }
            if (editEvento.text.isEmpty()) {
                editEvento.error = "Preencha um valor"
                return@setOnClickListener
            }
            if (editImpacto.text.isEmpty()) {
                editImpacto.error = "Preencha um valor"
                return@setOnClickListener
            }
            if (editData.text.isEmpty()) {
                editData.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (editPessoas.text.isEmpty()) {
                editPessoas.error = "Preencha um valor"
                return@setOnClickListener
            }
            val pessoasAfetadas = editPessoas.text.toString().toInt()
            if(pessoasAfetadas <= 0){
                editPessoas.error = "O valor precisa ser maior do que 0"
                return@setOnClickListener
            }


            val newEvento = Evento(
                local = editLocal.text.toString(),
                tipoEvento =  editEvento.text.toString(),
                impacto = editImpacto.text.toString(),
                data = editData.text.toString(),
                pessoasAfetadas = editPessoas.text.toString().toIntOrNull() ?: 0
            )

            viewModel.addEvento(newEvento)
            editLocal.text.clear()
            editEvento.text.clear()
            editImpacto.text.clear()
            editData.text.clear()
            editPessoas.text.clear()
        }

        val viewModelFactory = EventoViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(EventoViewModel::class.java)

        viewModel.eventoLiveData.observe(this) { eventos ->
            eventoAdapter.updateEventos(eventos)
        }
    }
}