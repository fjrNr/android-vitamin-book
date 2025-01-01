package com.example.vitaminbook.activity

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.vitaminbook.dataClass.DailyIntake
import com.example.vitaminbook.DataRepo
import com.example.vitaminbook.R
import com.example.vitaminbook.dataClass.Vitamin
import com.example.vitaminbook.adapter.ListDailyIntakeAdapter

class DetailActivity : AppCompatActivity() {
    private lateinit var imgPhotoCard: ImageView
    private lateinit var imgThumbnail: ImageView
    private lateinit var tvSynonymDesc: TextView
    private lateinit var tvUsageDesc: TextView
    private lateinit var tvDeficiencyDesc: TextView
    private lateinit var tvFoodDesc: TextView
    private lateinit var rvDailyIntake: RecyclerView
    private lateinit var btnReference: Button
    private val dailyIntakeList = ArrayList<DailyIntake>()
    private var dataVitamin: Vitamin? = null

    companion object {
        const val EXTRA_VITAMIN = "extra_vitamin"
        const val EXTRA_INDEX = "extra_index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imgPhotoCard = findViewById(R.id.img_photo_card)
        imgThumbnail = findViewById(R.id.img_thumbnail)
        tvSynonymDesc = findViewById(R.id.tv_synonym_desc)
        tvUsageDesc = findViewById(R.id.tv_usage_desc)
        tvDeficiencyDesc = findViewById(R.id.tv_deficiency_desc)
        tvFoodDesc = findViewById(R.id.tv_food_source_desc)
        rvDailyIntake = findViewById(R.id.rv_daily_intake)
        btnReference = findViewById(R.id.btn_reference)
        btnReference.setOnClickListener({
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("${dataVitamin?.referenceUrl}"))
            startActivity(browserIntent)
        })

        dataVitamin = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_VITAMIN, Vitamin::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_VITAMIN)
        }

        val dataIndex = intent.getIntExtra("vitamin_index", 0)

        title = dataVitamin?.name
        Glide.with(imgPhotoCard.context)
            .load(dataVitamin?.photoCardUrl)
            .placeholder(R.drawable.ic_launcher_vitamin_book_foreground)
            .into(imgPhotoCard)
        Glide.with(imgThumbnail.context)
            .load(dataVitamin?.thumbnailUrl)
            .transform(CircleCrop())
            .placeholder(R.drawable.ic_launcher_vitamin_book_foreground)
            .into(imgThumbnail)
        tvSynonymDesc.text = dataVitamin?.synonym
        tvUsageDesc.text = dataVitamin?.usageDescription
        tvDeficiencyDesc.text = dataVitamin?.deficiencyDescription
        tvFoodDesc.text = dataVitamin?.foodsDescription

        dailyIntakeList.addAll(DataRepo.getDailyIntakeList(dataIndex))
        showDailyIntakeRecyclerList(dataVitamin?.unit.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_share) {
            val intent = Intent()
            val strContent = "${dataVitamin?.name}\n\n${dataVitamin?.usageDescription}\n\n${resources.getText(R.string.daily_intake)}\n${resources.getText(R.string.health_law)} :\n${resources.getText(R.string.health_law_url)}\n\nInfo selengkapnya :\n${dataVitamin?.referenceUrl}"

            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, strContent)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Bagikan ke:"))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDailyIntakeRecyclerList(unit: String) {
        rvDailyIntake.layoutManager = LinearLayoutManager(this)
        val listDailyIntakeAdapter = ListDailyIntakeAdapter(dailyIntakeList, unit)
        rvDailyIntake.adapter = listDailyIntakeAdapter
    }
}