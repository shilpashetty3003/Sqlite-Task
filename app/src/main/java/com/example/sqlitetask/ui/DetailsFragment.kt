package com.example.sqlitetask.ui

import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlitetask.R
import com.example.sqlitetask.databinding.FragmentDetailsBinding
import com.example.sqlitetask.repository.local.MemberDetailsContract


class DetailsFragment : Fragment() {


    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fbAddData.setOnClickListener {
            replaceFragment(AddFragment())
        }
        fetchMemberDetails()

    }

    private fun replaceFragment(fragment: AddFragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, AddFragment())
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    @SuppressLint("Range")
    private fun fetchMemberDetails() {
        val model = ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)
        model.cursor.observe(viewLifecycleOwner) { cursor ->
            if (cursor != null && cursor.count > 0) {
                binding.recyclerView.apply {
                    this.adapter = MemberAdapter(requireContext(), cursor)
                    this.layoutManager = LinearLayoutManager(requireContext())

                }
            }
        }

    }
}