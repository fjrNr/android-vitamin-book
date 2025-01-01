package com.example.vitaminbook.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Surface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vitaminbook.DataRepo
import com.example.vitaminbook.R
import com.example.vitaminbook.dataClass.Vitamin
import com.example.vitaminbook.adapter.ListVitaminAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvVitamins: RecyclerView
    private val vitaminList = ArrayList<Vitamin>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvVitamins = findViewById(R.id.rv_vitamins)
        rvVitamins.setHasFixedSize(true)

        vitaminList.addAll(DataRepo.getVitaminList())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_page) {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvVitamins.layoutManager = if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager(this, 2)
        }else{
            LinearLayoutManager(this)
        }
        val listVitaminAdapter = ListVitaminAdapter(vitaminList)
        rvVitamins.adapter = listVitaminAdapter
    }
}