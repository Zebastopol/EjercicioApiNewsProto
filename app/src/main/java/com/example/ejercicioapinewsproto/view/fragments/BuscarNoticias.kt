package com.example.ejercicioapinewsproto.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioapinewsproto.R
import com.example.ejercicioapinewsproto.databinding.FragmentBuscarNoticiasBinding
import com.example.ejercicioapinewsproto.databinding.FragmentPortalnoticiasBinding
import com.example.ejercicioapinewsproto.repository.recycler.NoticiasAdaptador
import com.example.ejercicioapinewsproto.viewmodel.ViewModel
import com.example.ejercicioapinewsproto.viewmodel.ViewModelBuscarNoticia
import com.google.android.material.chip.Chip


class BuscarNoticias : Fragment() {

    private lateinit var binding: FragmentBuscarNoticiasBinding
    private lateinit var buscarNoticiaViewModel: ViewModelBuscarNoticia
    /*private lateinit var myRecyclerView: RecyclerView
    private lateinit var adaptador: NoticiasAdaptador*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuscarNoticiasBinding.inflate(layoutInflater)
        buscarNoticiaViewModel = ViewModelProvider(this).get(ViewModelBuscarNoticia::class.java)
        observar()


        binding.btnBuscarNoticia.setOnClickListener{
            var k = binding.txtKeyword
            if(k != null){

                binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
                    val chip = binding.chipGroup.findViewById<Chip>(checkedId)
                    binding.chipGroup.removeView(chip)
                }
            }

        }
        return binding.root

    }

    private fun observar() {

    }


}