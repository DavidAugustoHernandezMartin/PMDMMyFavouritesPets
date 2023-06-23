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

class PetsAdapter (private val petsList: List<Pet>): RecyclerView.Adapter<PetsAdapter.PetsViewHolder>(){
    class PetsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val petImage = view.findViewById<ImageView>(R.id.pet_image)
        val petName: TextView = view.findViewById(R.id.pet_name)
        val petScientificName: TextView = view.findViewById(R.id.pet_scientific_name)
        val checkBox: CheckBox = view.findViewById(R.id.favorite_checkbox)
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
        holder.checkBox.isChecked = pet.isFavorite
        holder.petName.text = pet.name
        holder.petScientificName.text = pet.scientificName
    }
}