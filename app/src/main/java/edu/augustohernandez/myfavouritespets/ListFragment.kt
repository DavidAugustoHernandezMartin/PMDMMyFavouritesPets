package edu.augustohernandez.myfavouritespets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.augustohernandez.myfavouritespets.adapters.PetsAdapter
import edu.augustohernandez.myfavouritespets.databinding.FragmentListBinding
import edu.augustohernandez.myfavouritespets.model.Pet

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerview.adapter = PetsAdapter(mutableListOf(
            Pet(0,"bongo","canninus canus","pelo corto","hogar","nisdfnoweign",5,"Perro muy activo","Venezuela",true),
            Pet(1,"Kitty","gatus felinus","pelo largo","hogar","nisdfnoweign",5,"Gata muy activa","Venezuela",true),
            Pet(2,"Tigra","gatus felinus","pelo largo","hogar","nisdfnoweign",5,"Gata muy activa","Venezuela",true)
        ))
    }
}
