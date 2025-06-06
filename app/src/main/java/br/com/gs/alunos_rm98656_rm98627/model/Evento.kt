package br.com.gs.alunos_rm98656_rm98627.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Evento(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val local: String,
    val tipoEvento: String,
    val impacto: String,
    val data: String,
    val pessoasAfetadas: Int
)
