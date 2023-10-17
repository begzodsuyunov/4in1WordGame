package com.example.fourpicturesonewords.screen

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fourpicturesonewords.R
import com.example.fourpicturesonewords.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    var binding: FragmentSplashBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        val countDownTimer: CountDownTimer = object : CountDownTimer(2000, 1000) {
            override fun onTick(l: Long) {}
            override fun onFinish() {
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_splashFragment_to_mainFragment)
            }
        }
        countDownTimer.start()
        return binding!!.root
    }
}