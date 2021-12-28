package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items = arrayOf("A型", "B型", "O型", "AB型") // ダイアログに表示したい項目のリスト
        val dialog = activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle(R.string.blood_type_title)
                setIcon(R.drawable.wings)

                // 選択された項目を取得しトースト
                // setItems(リスト, 選択時のイベントリスナー)
                // イベントリスナーが取得するwhichに選択された項目のindex番号が格納されてる
                setItems(items) { dialog, which ->
                    Toast.makeText(
                        activity, "「${items[which]}」が選択されました。",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.create()
        }
        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}