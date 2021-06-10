package com.washingtoncodelab.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.washingtoncodelab.splashscreen.databinding.FragmentLoginBinding
import com.washingtoncodelab.splashscreen.databinding.FragmentRegBinding

class RegFragment : Fragment() {
    private lateinit var binding: FragmentRegBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegBinding.inflate(inflater, container, false)
        val view = binding.root

        auth = FirebaseAuth.getInstance()

        binding.signup.setOnClickListener {
            val email = binding.regEmail.text.toString()
            val password =  binding.regPass.text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                task ->
                if (task.isSuccessful){
                    Toast.makeText(requireContext(), "account created", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireContext(), "account no created", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }

}