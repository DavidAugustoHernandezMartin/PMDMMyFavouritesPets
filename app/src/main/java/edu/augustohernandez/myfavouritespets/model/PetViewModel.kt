package edu.augustohernandez.myfavouritespets.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PetViewModel : ViewModel() {

    private val _pets: MutableLiveData<MutableList<Pet>> = MutableLiveData(mutableListOf())
    private val _favPets: MutableLiveData<MutableList<Pet>> = MutableLiveData(mutableListOf())

    val pets:LiveData<MutableList<Pet>> get() = _pets
    val favPets:LiveData<MutableList<Pet>> get() = _favPets

    private fun loadFavPets() {
        _pets.value!!.forEach {
            if (it.isFavorite)
                _favPets.value!!.add(it)
        }
    }

    private fun loadPets(p:MutableList<Pet>) {
        _pets.value = p
    }

    fun doILikeThisPet(pet:Pet){

    }

    fun setGlobalAdapters(p:List<Pet>){
        loadPets(p.toMutableList())
        loadFavPets()
    }

    fun deletePet(pet: Pet) {
        val list = _pets.value!!.toMutableList()
        val favs = _favPets.value!!.toMutableList()
        list.remove(pet)
        if (favs.contains(pet))
            favs.remove(pet)
        _pets.value = list
        _favPets.value = favs
    }
}
