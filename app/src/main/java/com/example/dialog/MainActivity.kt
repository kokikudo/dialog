package com.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.dialog.databinding.ActivityMainBinding

// 動的なメニューは定義ファイルでつくるデータをonCreateOptionsMenuで書くだけ
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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        // ホームメニュー
        menu.add(0, 0, 0, R.string.home).setIcon(R.drawable.menu1)

        // サブメニュー
        val subMenu1 = menu.addSubMenu(0, 1, 1, R.string.help).setIcon(R.drawable.menu2)
        // helpの傘下メニュー
        subMenu1.add(0, 2, 0, R.string.search).setIcon(R.drawable.menu3)
        subMenu1.add(0, 3, 1, R.string.`in`).setIcon(R.drawable.menu4)
        subMenu1.add(0, 4, 2, R.string.out).setIcon(R.drawable.menu5)
        subMenu1.add(0, 5, 3, R.string.version).setIcon(R.drawable.menu6)

        // サブメニュー
        val subMenu2 = menu.addSubMenu(0, 6, 2, R.string.setting).setIcon(R.drawable.menu7)
        // settingの傘下メニュー
        subMenu2.add(0, 7, 0, R.string.bulb).setIcon(R.drawable.menu8)
        subMenu2.add(0, 8, 1, R.string.speaker).setIcon(R.drawable.menu9)
        subMenu2.add(0, 9, 2, R.string.key).setIcon(R.drawable.menu10)

        // ゴミ箱
        menu.add(0, 10, 3, R.string.garbage).setIcon(R.drawable.menu11)
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