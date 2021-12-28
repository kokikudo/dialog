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


        binding.button.setOnClickListener {

            // 入力した値をフラグメントに渡す
            MyAlertDialogFragment().apply {

                // argumentsプロパティにBundleをセット
                // Bundleクラスはアプリの状態をキーと値で保存できるオブジェクト
                // argumentsプロパティはアプリのライフサイクルやシステムの都合によるデータ削除が
                // 発生しても自動で再生成されるため状態の保持に向いている
                arguments = Bundle().apply {
                    putString("inputText", binding.editText.text.toString())
                }
            }.show(supportFragmentManager, "dialog_basic")
        }
    }
}