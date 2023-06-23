package edu.augustohernandez.myfavouritespets.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PetViewModel : ViewModel() {
    private val pets: MutableLiveData<List<Pet>> by lazy {
        MutableLiveData<List<Pet>>().also {
            loadPets()
        }
    }
    val favPets: MutableLiveData<List<Pet>> by lazy {
        MutableLiveData<List<Pet>>().also {
            loadFavPets()
        }
    }

    private fun loadFavPets() {

    }

    private fun loadPets() {
        // Carga tus pets desde la base de datos y asigna la lista a pets.value
    }

    fun doILikeThisPet(){

    }

    fun deletePet(pet: Pet) {
        val list = pets.value?.toMutableList()
        list?.remove(pet)
        pets.value = list
    }



}
