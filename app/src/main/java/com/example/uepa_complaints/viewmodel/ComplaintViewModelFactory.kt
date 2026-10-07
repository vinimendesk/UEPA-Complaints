package com.example.uepa_complaints.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uepa_complaints.data.model.ComplaintRepository

/**
 * Factory responsável por criar o ComplaintViewModel.
 *
 * O ViewModel precisa de um ComplaintRepository no construtor.
 * Como o Android não sabe criar esse Repository sozinho,
 * utilizamos esta Factory para fornecer a dependência.
 */
class ComplaintViewModelFactory(
    private val repository: ComplaintRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(ComplaintViewModel::class.java)) {

            return ComplaintViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "ViewModel desconhecido: ${modelClass.name}"
        )
    }
}