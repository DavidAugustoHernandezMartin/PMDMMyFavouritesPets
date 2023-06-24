package edu.augustohernandez.myfavouritespets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import edu.augustohernandez.myfavouritespets.adapters.PetsAdapter
import edu.augustohernandez.myfavouritespets.databinding.FavouritesFragmentBinding
import edu.augustohernandez.myfavouritespets.model.PetViewModel

class FavouritesFragment: Fragment(){
    private lateinit var binding:FavouritesFragmentBinding
    private val viewModel: PetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FavouritesFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.favouritesRecyclerview.adapter = PetsAdapter(viewModel.favPets.value!!)
    }
}