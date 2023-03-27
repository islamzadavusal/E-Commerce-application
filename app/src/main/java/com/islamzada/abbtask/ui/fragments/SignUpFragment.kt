package com.islamzada.abbtask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.islamzada.abbtask.R
import com.islamzada.abbtask.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.goToSigninFragment.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toSignIn)
        }

        binding.btnSignUp.setOnClickListener {
            Snackbar.make(it, "A new account has been created.", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root

    }
}