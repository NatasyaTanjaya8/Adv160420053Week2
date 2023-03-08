package com.natasya.adv160420053week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var number1 = (0..20).random()
        var number2 = (0..20).random()
        var result = number1 + number2
        var score = 0
        txtQuestion.text = "$number1 + $number2"
        if (arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
        btnSubmitAnswer.setOnClickListener {
            var answer = txtAnswer.text.toString().toInt()
            if (answer == result){
                score += 1
                number1 = (0..20).random()
                number2 = (0..20).random()
                result = number1 + number2
                txtQuestion.text = "$number1 + $number2"
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score.toString());
                Navigation.findNavController(it).navigate(action)
            }
        }
        btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}