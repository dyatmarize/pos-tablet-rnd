package com.dyatmarize.postabletrnd.view.main.pos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dyatmarize.postabletrnd.R
import com.dyatmarize.postabletrnd.databinding.FragmentPosBinding
import com.dyatmarize.postabletrnd.view.base.BaseFragment
import com.dyatmarize.postabletrnd.util.AndroidUtil.Companion.blockingClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PosFragment : BaseFragment(), View.OnClickListener {

    private var binding: FragmentPosBinding? = null

    private val viewModel: PosViewModel by lazy { ViewModelProvider(this).get(PosViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPosBinding.inflate(layoutInflater, container, false)
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun initializeBinding() {
        binding?.button1?.blockingClickListener { v -> onClick(v) }
        binding?.button2?.blockingClickListener { v -> onClick(v) }

    }

    override fun initializeViewModel() {
        // Do nothing
    }

    override fun initializeComponent() {
        // Do nothing
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        navController = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
                Toast.makeText(requireContext(), "Button 1 clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.button2 -> {
                Toast.makeText(requireContext(), "Button 2 clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeIncrementDecrementButton() {

    }
}