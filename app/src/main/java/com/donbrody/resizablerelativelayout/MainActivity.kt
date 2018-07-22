package com.donbrody.resizablerelativelayout

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.donbrody.resizablerelativelayout.components.example.ResizableForm

/**
 * Created by Don.Brody on 7/22/18.
 */
class MainActivity: AppCompatActivity() {
    private lateinit var resizableForm: ResizableForm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resizableForm = findViewById(R.id.resizableForm)
    }
}