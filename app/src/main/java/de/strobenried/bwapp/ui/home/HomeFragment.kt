package de.strobenried.bwapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import de.strobenried.bwapp.R


class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel

    var database = FirebaseFirestore.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })

        val beerBtn: Button = root.findViewById(R.id.button_beer)
        beerBtn.setOnClickListener(this)

        return root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_beer -> {

            }

            else -> {
            }
        }
    }

}