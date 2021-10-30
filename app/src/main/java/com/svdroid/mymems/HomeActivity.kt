package com.svdroid.mymems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.svdroid.mymems.APIServices.APIInterface
import com.svdroid.mymems.APIServices.ApiUtilities
import com.svdroid.mymems.adapter.MemsAdapter
import com.svdroid.mymems.databinding.ActivityHomeBinding
import com.svdroid.mymems.db.MemsDatabase
import com.svdroid.mymems.repository.MainRepository
import com.svdroid.mymems.viewmodel.MemsViewModel
import com.svdroid.mymems.viewmodel.MemsViewModelFactory
import kotlinx.coroutines.coroutineScope

class HomeActivity : AppCompatActivity() {
    lateinit var memsViewModel: MemsViewModel
    lateinit var binding: ActivityHomeBinding
    var memsAdapter = MemsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        window.statusBarColor= ContextCompat.getColor(this, R.color.light_white)
        val repository = (application as MemsApplication).mainRepository
        memsViewModel =
            ViewModelProvider(this, MemsViewModelFactory(repository))[MemsViewModel::class.java]
        memsViewModel.mems.observe(this, {
            memsAdapter.submitList(it.data.memes)
            binding.rvMems.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(this@HomeActivity,2)
                adapter = memsAdapter
            }

        })

    }
}