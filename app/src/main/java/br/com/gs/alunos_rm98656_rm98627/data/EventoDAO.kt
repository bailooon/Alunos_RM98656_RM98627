package br.com.gs.alunos_rm98656_rm98627.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.gs.alunos_rm98656_rm98627.model.Evento


@Dao
interface EventoDAO {

    @Query("SELECT * FROM Evento")
    fun getAll(): LiveData<List<Evento>>

    @Insert
    fun insert(evento: Evento)

    @Delete
    fun delete(evento: Evento)

}