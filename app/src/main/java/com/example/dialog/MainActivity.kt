package com.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.dialog.databinding.ActivityMainBinding

// アクションバーからアイコンをタップしたときに表示するメニューをオプションメニューと呼ぶ
// あらかじめ設定ファイルで用意する静的なやり方と、コードからメニューを生成する動的な方法がある
// 静的なやり方
//　- アイコンを用意
// - 定義ファイル作成
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            MyAlertDialogFragment().apply {
                arguments = Bundle().apply {
                    putString("inputText", binding.editText.text.toString())
                }
            }.show(supportFragmentManager, "dialog_basic")
        }
    }

    // 定義ファイルからオプションメニュー生成
    // メニューが初回表示されるときに実行されるActivityメソッド
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // メニューフレームを初期化しレイアウトをセット
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    // メニューを選択したときに実行されるActivityメソッド
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(
            this, item.title, Toast.LENGTH_SHORT
        ).show()
        return true
    }
    // 引数itemには選択した項目のIDも格納されてる
    // これを使って項目ごとに処理を変えたりできる
    /*
    when (item.itemId) {
        R.id.item1 ->
        R.id.item2 ->
        ...
    }
     */
}