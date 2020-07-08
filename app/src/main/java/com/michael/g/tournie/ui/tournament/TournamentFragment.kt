package com.michael.g.tournie.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.michael.g.tournie.R
import kotlinx.android.synthetic.main.fragment_tournament.*

class TournamentFragment : Fragment() {

    private lateinit var tournamentViewModel: TournamentViewModel
    private lateinit var animation: Animation

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tournamentViewModel =
                ViewModelProviders.of(this).get(TournamentViewModel::class.java)
        animation = AnimationUtils.loadAnimation(context, R.anim.zoom_out)
        val root = inflater.inflate(R.layout.fragment_tournament, container, false)
        val createTournamentBtn = root.findViewById<ImageButton>(R.id.createTournamentBtn)
        createTournamentBtn.setOnClickListener{
            createTournamentBtn.startAnimation(animation)
        }
        return root
    }
}
