package com.globits.mita.ui


import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.airbnb.mvrx.viewModel
import com.globits.mita.R

import com.globits.mita.XCareApplication
import com.globits.mita.core.MitaBaseActivity
import com.globits.mita.databinding.ActivityMainBinding
import com.globits.mita.ui.home.HomeViewModel
import com.globits.mita.ui.home.HomeViewState
import javax.inject.Inject


class MainActivity : MitaBaseActivity<ActivityMainBinding>(), HomeViewModel.Factory {
    private lateinit var appBarConfiguration: AppBarConfiguration
    val viewModel: HomeViewModel by viewModel()

    @Inject
    lateinit var viewModelFactory: HomeViewModel.Factory

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as XCareApplication).mitaComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        navController = findNavController(R.id.navigate)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment
            ), null
        )
    }

    fun setupToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setupActionBarWithNavController(navController, appBarConfiguration)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    //    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.navigate)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
    override fun getBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun create(initialState: HomeViewState): HomeViewModel {
        return viewModelFactory.create(initialState)
    }

    fun navigateTo(fragmentId: Int) {
        navController.navigate(fragmentId)
    }



}

