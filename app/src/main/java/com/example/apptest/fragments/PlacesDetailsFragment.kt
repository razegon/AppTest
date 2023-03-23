package com.example.apptest.fragments

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.apptest.FragmentViewModel
import com.example.apptest.MainActivity
import com.example.apptest.databinding.FragmentPlacesDetailsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Float.max
import java.lang.Float.min

class PlacesDetailsFragment : Fragment() {
    private val fragmentViewModel: FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentPlacesDetailsBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPlacesDetailsBinding.bind(view)

        fragmentViewModel.currentPlace.observe(this.viewLifecycleOwner) { it ->
            binding.titleDetail.text = getString(it.titleResourceId)
           // binding.transTitleDetail.text = getString(it.transTitleResourceId)
            binding.placesDescription.text = getString(it.placesDescription1)
            binding.placesImageDetail.load(it.imageResourceId)

            val stringHistory = getString(it.placesDescription2)
            binding.btnHistory.setOnClickListener {
                val styledText: Spanned = Html.fromHtml(stringHistory, FROM_HTML_MODE_LEGACY)
                binding.placesDescription.text = styledText
            }

            val stringCuriosities = getString(it.placesDescription3)
            binding.btnCuriosities.setOnClickListener {
                binding.placesDescription.text = stringCuriosities
            }
        }
    }

}
