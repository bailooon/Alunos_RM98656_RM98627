package br.com.gs.alunos_rm98656_rm98627.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.gs.alunos_rm98656_rm98627.model.Evento

@Database(entities = [Evento::class], version = 1)
abstract class EventoDatabase : RoomDatabase() {

    abstract fun eventoDao(): EventoDAO
}