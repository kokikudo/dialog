package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var selectedItemIndex = 0 // 選択した項目のIndex
        val items = arrayOf("A型", "B型", "O型", "AB型") // ダイアログに表示したい項目のリスト
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle(R.string.blood_type_title)
                setIcon(R.drawable.wings)

                    //選択したらselectedItemIndexをその項目のIndex番号に更新
                setSingleChoiceItems(items, selectedItemIndex) { dialog, which ->
                    selectedItemIndex = which
                }

                    //トースト
                    // 要は選択した項目のIndexを変数で補完し、最後に参照するという古典的なやり方
                setPositiveButton("OK") { dialog, which ->
                    Toast.makeText(
                        activity, "「${items[selectedItemIndex]}」が選択されました。",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}