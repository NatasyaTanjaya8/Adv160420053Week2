package com.natasya.adv160420053week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.txtAnswer
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null){
            val playerScore = ResultFragmentArgs.fromBundle(requireArguments()).playerScore
            txtScoreResult.text = "Your score is $playerScore"
        }
        btnBackResult.setOnClickListener {
            val action = ResultFragmentDirections.actionMainResultFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}