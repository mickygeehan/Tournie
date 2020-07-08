package com.michael.g.tournie.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.michael.g.tournie.R

class TournamentFragment : Fragment() {

    private lateinit var tournamentViewModel: TournamentViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tournamentViewModel =
                ViewModelProviders.of(this).get(TournamentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tournament, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        tournamentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
