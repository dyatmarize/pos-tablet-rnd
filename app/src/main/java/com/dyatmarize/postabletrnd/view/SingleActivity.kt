package com.dyatmarize.postabletrnd.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dyatmarize.postabletrnd.R
import com.dyatmarize.postabletrnd.databinding.ActivitySingleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleActivity : AppCompatActivity() {

    private var binding: ActivitySingleBinding? = null

    private var navHostFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        binding?.lifecycleOwner = this
        setContentView(binding?.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_single_activity)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.clear()
    }
}