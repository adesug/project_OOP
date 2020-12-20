package com.example.project_oop


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ActivityPilihan : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_pedagang : Button
    private lateinit var btn_pasar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilihan)

        btn_pedagang = findViewById(R.id.btn_pedagang)
        btn_pedagang.setOnClickListener(this)

        btn_pasar = findViewById(R.id.btn_pasar)
        btn_pasar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_pedagang -> run{
                val intent = Intent(this@ActivityPilihan,MainActivity::class.java)
                startActivity(intent)
            }
        }
        when(v.id){
            R.id.btn_pasar -> run{
                val intent = Intent(this@ActivityPilihan,MainActivityPasar::class.java)
                startActivity(intent)
            }
        }
    }


}