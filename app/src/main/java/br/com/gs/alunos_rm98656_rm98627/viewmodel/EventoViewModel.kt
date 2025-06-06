package br.com.gs.alunos_rm98656_rm98627.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import br.com.gs.alunos_rm98656_rm98627.data.EventoDAO
import br.com.gs.alunos_rm98656_rm98627.data.EventoDatabase
import br.com.gs.alunos_rm98656_rm98627.model.Evento
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventoViewModel (application: Application) : AndroidViewModel(application)  {

    private val eventoDao: EventoDAO

    val eventoLiveData: LiveData<List<Evento>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            EventoDatabase::class.java,
            "eventos_database"
        ).build()


        eventoDao = database.eventoDao()
        eventoLiveData = eventoDao.getAll()
    }


    fun addEvento(newEvento: Evento) {
        viewModelScope.launch(Dispatchers.IO) {
            eventoDao.insert(newEvento)
        }
    }

    fun removeEvento(evento: Evento) {
        viewModelScope.launch(Dispatchers.IO) {
            eventoDao.delete(evento)
        }
    }
}