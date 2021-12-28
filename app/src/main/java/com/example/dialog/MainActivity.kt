package com.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ダイアログ表示処理をClickListenerに登録
        binding.button.setOnClickListener {
            val dialog = MyAlertDialogFragment()
            dialog.show(supportFragmentManager, "dialog_basic")
        }
    }
}