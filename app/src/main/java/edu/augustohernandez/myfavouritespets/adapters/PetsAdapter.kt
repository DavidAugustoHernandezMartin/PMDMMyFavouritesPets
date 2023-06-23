package edu.augustohernandez.myfavouritespets.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.augustohernandez.myfavouritespets.R
import edu.augustohernandez.myfavouritespets.model.Pet
import edu.augustohernandez.myfavouritespets.model.PetsList

class PetsAdapter : RecyclerView.Adapter<PetsAdapter.PetsViewHolder>(){
    private val petsList = PetsList.petsList
    class PetsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val petImage = view.findViewById<ImageView>(R.id.pet_image)
        val petName = view.findViewById<TextView>(R.id.pet_name)
        val petScientificName = view.findViewById<TextView>(R.id.pet_scientific_name)
        val checkBox = view.findViewById<CheckBox>(R.id.favorite_checkbox)
        val editButton = view.findViewById<Button>(R.id.edit_button)
        val deleteButton = view.findViewById<Button>(R.id.delete_button)
        val mapsButton = view.findViewById<ImageButton>(R.id.maps_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_item, parent, false)
        return PetsViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return petsList.size
    }

    override fun onBindViewHolder(holder: PetsViewHolder, position: Int) {
        val pet:Pet = petsList[position]
    }
}