package com.example.ejercicioapinewsproto.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.ejercicioapinewsproto.databinding.FragmentPortalnoticiasBinding
import com.example.ejercicioapinewsproto.repository.recycler.NoticiasAdaptador
import com.example.ejercicioapinewsproto.viewmodel.ViewModel

class PortalNoticias: Fragment() {

    private lateinit var binding: FragmentPortalnoticiasBinding
    private lateinit var noticiasViewModel: ViewModel
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var adaptador: NoticiasAdaptador


    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPortalnoticiasBinding.inflate(layoutInflater)

        noticiasViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        observar()

        myRecyclerView = binding.myRecycler
        myRecyclerView.layoutManager =
        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.progressBar.visibility = View.VISIBLE
        noticiasViewModel.onBtnBuscarNoticias()



        return binding.root
    }



    private fun observar() {
            noticiasViewModel.noticias.observe(viewLifecycleOwner, Observer{
            binding.progressBar.visibility = View.GONE
            adaptador = NoticiasAdaptador(requireContext().applicationContext, it.data)
            myRecyclerView.adapter = adaptador
        })
    }



}