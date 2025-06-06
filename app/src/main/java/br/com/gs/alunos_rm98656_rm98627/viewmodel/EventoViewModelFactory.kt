package br.com.gs.alunos_rm98656_rm98627.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EventoViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EventoViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}