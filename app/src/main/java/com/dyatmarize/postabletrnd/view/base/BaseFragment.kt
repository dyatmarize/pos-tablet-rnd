package com.dyatmarize.postabletrnd.view.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dyatmarize.postabletrnd.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    protected val TAG: String = javaClass.name

    protected var navController: NavController? = null

    /**
     * Binding all function of button goes here in seconds
     */
    abstract fun initializeBinding()

    /**
     * Last, observing view model value in here
     */
    abstract fun initializeViewModel()

    /**
     * Initialize component first, such as set navController and so on
     */
    abstract fun initializeComponent()

    private fun initializeNavController() {
        try {
            navController =
                Navigation.findNavController(requireActivity(), R.id.nav_host_single_activity)
        } catch (e: Exception) {
            e.printStackTrace()
            Timber.e(e)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeNavController()
        initializeComponent()
        initializeBinding()
        initializeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        navController = null
    }
}