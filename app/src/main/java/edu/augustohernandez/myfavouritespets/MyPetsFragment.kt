package edu.augustohernandez.myfavouritespets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import edu.augustohernandez.myfavouritespets.databinding.FragmentMypetsBinding

class MyPetsFragment :Fragment(){
    //Se inicia el viewmodel compartido

    // Binding object instance corresponding to the fragment_u8.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: FragmentMypetsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMypetsBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set up the ViewPager2 with the adapter
        val viewPager = view.findViewById<ViewPager2>(R.id.pager)
        viewPager.adapter = ViewPagerAdapter(this)

        // Link the TabLayout with the ViewPager2
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Favourites"
                1 -> tab.text = "Add pet"
            }
        }.attach()
    }

    class ViewPagerAdapter(fragmentActivity: MyPetsFragment) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 2
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> FavouritesFragment()
                1 -> AddPetFragment()
                else -> throw IllegalArgumentException("Invalid view pager position")
            }
        }
    }
}