package com.dyatmarize.postabletrnd.view.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseFragment : Fragment() {

    protected val TAG: String = javaClass.name

    protected var navController: NavController? = null

    private val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this).get(BaseViewModel::class.java)
    }
}