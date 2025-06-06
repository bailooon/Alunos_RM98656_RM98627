package br.com.gs.alunos_rm98656_rm98627.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gs.alunos_rm98656_rm98627.R
import br.com.gs.alunos_rm98656_rm98627.model.Evento

class EventoAdapter(private val onEventoRemoved: (Evento) -> Unit):
    RecyclerView.Adapter<EventoAdapter.EventoViewHolder>(){

    private var eventos = listOf<Evento>()

    inner class EventoViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val local = view.findViewById<TextView>(R.id.local)
        val eventoTipo = view.findViewById<TextView>(R.id.eventoTipo)
        val impacto = view.findViewById<TextView>(R.id.impacto)
        val data = view.findViewById<TextView>(R.id.data)
        val afetadas = view.findViewById<TextView>(R.id.afetadas)
        val button = view.findViewById<ImageButton>(R.id.imageButton)


        fun bind(evento: Evento) {

            local.text = evento.local
            eventoTipo.text = evento.tipoEvento
            impacto.text = evento.impacto
            data.text = evento.data
            afetadas.text = evento.pessoasAfetadas.toString()

            button.setOnClickListener {
                onEventoRemoved(evento)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.evento_layout, parent, false)

        return EventoViewHolder(view)
    }

    override fun getItemCount():  Int = eventos.size

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = eventos[position]
        holder.bind(evento)
    }

    fun updateEventos(newEventos: List<Evento>) {
        eventos = newEventos
        notifyDataSetChanged()
    }
}