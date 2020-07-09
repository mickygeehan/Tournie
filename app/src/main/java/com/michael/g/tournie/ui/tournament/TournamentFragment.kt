package com.michael.g.tournie.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michael.g.tournie.R
import kotlinx.android.synthetic.main.fragment_tournament.*
import android.widget.ListAdapter as ListAdapter1

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(mNicolasCageMovies)
        }
    }

    private val mNicolasCageMovies = listOf(
        Movie("Tournament 1", 1987),
        Movie("Tournament 2", 1988),
        Movie("Tournament 3", 1997),
        Movie("Tournament 4", 1997),
        Movie("Tournament 5", 2004),
        Movie("Tournament 6", 2006),
        Movie("Tournament 7", 2007),
        Movie("Tournament 8", 2009)
    )

    class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
        private var mTitleView: TextView? = null
        private var mYearView: TextView? = null


        init {
            mTitleView = itemView.findViewById(R.id.list_title)
            mYearView = itemView.findViewById(R.id.list_description)
        }

        fun bind(movie: Movie) {
            mTitleView?.text = movie.title
            mYearView?.text = movie.year.toString()
        }

    }

    class ListAdapter(private val list: List<Movie>)
        : RecyclerView.Adapter<MovieViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return MovieViewHolder(inflater, parent)
        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie: Movie = list[position]
            holder.bind(movie)
        }

        override fun getItemCount(): Int = list.size

    }


    class Movie(title: String, year: Int) {
        val title: String = title
        val year: Int = year
    }
}
