package com.islamzada.abbtask.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.islamzada.abbtask.MainActivity
import com.islamzada.abbtask.R
import com.islamzada.abbtask.databinding.FragmentSignInBinding
import com.islamzada.abbtask.util.go
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.goToSignUpFragment.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toSignUp)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignIn.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
