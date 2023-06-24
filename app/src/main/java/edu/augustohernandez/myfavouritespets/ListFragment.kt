package edu.augustohernandez.myfavouritespets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import edu.augustohernandez.myfavouritespets.adapters.PetsAdapter
import edu.augustohernandez.myfavouritespets.databinding.FragmentListBinding
import edu.augustohernandez.myfavouritespets.model.Pet
import edu.augustohernandez.myfavouritespets.model.PetViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewModel:PetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.setGlobalAdapters(listOf(
            Pet(0,"bongo","canninus canus","pelo corto","hogar","nisdfnoweign",5,"Perro muy activo y entretenido","Alicante, España",true),
            Pet(1,"Kitty","gatus felinus","pelo largo","hogar","nisdfnoweign",5,"Gata amigable pero territorial","Barcelona, España",true),
            Pet(2,"Tigra","gatus felinus","pelo largo","hogar","nisdfnoweign",5,"Gata pasiva y tranquila","Madrid, España",false)
        ))
        val fragmentBinding = FragmentListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerview.adapter = PetsAdapter(viewModel.pets.value!!)
    }
}
