package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items = arrayOf("チャーハン", "ラーメン", "たこ焼き", "焼きそば", "キャベツ") // ダイアログに表示したい項目のリスト
        val selectedItems = booleanArrayOf(true, true, true, false, false, false) // 各項目の選択状況
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle(R.string.favarite_food_title)
                setIcon(R.drawable.wings)

                    //各項目の選択状況が変更される
                setMultiChoiceItems(items, selectedItems) { dialog, which, isChecked ->
                    selectedItems[which] = isChecked
                }

                    //トースト
                    //trueの項目だけを入れたリストを作る
                setPositiveButton("OK") { dialog, which ->
                    val favaliteFood = mutableListOf<String>()
                        // forEachIndexed: リストの各要素とIndexを同時に取得してくる
                    selectedItems.forEachIndexed { index, e ->
                        if (e) favaliteFood.add(items[index])
                    }

                    val msg: String = if (favaliteFood.isNotEmpty()) {
                        "好きな食べ物は${favaliteFood.joinToString()}です"
                    } else {
                        "好きな食べ物はありません。"
                    }

                    Toast.makeText(
                        activity, msg,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}