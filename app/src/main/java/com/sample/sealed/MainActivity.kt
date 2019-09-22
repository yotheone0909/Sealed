package com.sample.sealed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val multipleTypeAdapter by lazy {
        MultipleTypeAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val multipleTypeModal = mutableListOf<MultipleTypeModal>()
        val header = Header("Music Type", 1)
        val body = Body("Rock", "Metal", R.drawable.music_rock, R.drawable.music_metal, 2)
        val body2 = Body("Acoustic", "POP", R.drawable.music_acoustic_guitars, R.drawable.music_pop, 2)
        val body3 = Body("Metal", "Hip Hop", R.drawable.music_metal, R.drawable.music_hip_hop, 2)
        val body4 = Body("POP", "Acoustic", R.drawable.music_pop, R.drawable.music_acoustic_guitars, 2)
        val body5 = Body("Hip Hop", "Rock", R.drawable.music_hip_hop, R.drawable.music_rock, 2)
        val ads = Footer(3)

        multipleTypeModal.add(header)
        multipleTypeModal.add(body)
        multipleTypeModal.add(ads)
        multipleTypeModal.add(body2)
        multipleTypeModal.add(body3)
        multipleTypeModal.add(body4)
        multipleTypeModal.add(ads)
        multipleTypeModal.add(body5)
        multipleTypeModal.add(body)
        multipleTypeModal.add(ads)
        multipleTypeModal.add(body2)
        multipleTypeModal.add(body3)

        multipleTypeAdapter.setData(multipleTypeModal)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = multipleTypeAdapter

    }
}
