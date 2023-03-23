package com.example.apptest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.apptest.FragmentViewModel
import com.example.apptest.PlacesAdapter
import com.example.apptest.databinding.FragmentLayoutBinding

class CitiesFragment : Fragment() {

    private var _binding: FragmentLayoutBinding? = null
    private val binding get() = _binding!!

    private val fragmentViewModel: FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentLayoutBinding.bind(view)
        val slidingPaneLayoutCities = binding.slidingPaneLayout
        slidingPaneLayoutCities.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED_CLOSED

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            FragmentOnBackPressedCallback(slidingPaneLayoutCities)
        )

        val adapter = PlacesAdapter {
            fragmentViewModel.updateCurrentPlace(it)
            binding.slidingPaneLayout.openPane()
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(fragmentViewModel.cityData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
