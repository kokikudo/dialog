package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = activity?.let {

            // ダイアログレイアウトファイルをViewに変換
            val layout = LayoutInflater.from(it).inflate(R.layout.dialog_body, null)

            // ダイアログのBody部分であるTextViewに保存した文字列を代入
            val textMsg = layout.findViewById<TextView>(R.id.textView)
            textMsg.text = arguments?.getString("inputText")

            // ダイアログ実装
            AlertDialog.Builder(it).apply {
                setTitle(R.string.d_title)
                setView(layout)
                setIcon(R.drawable.wings)
                setNegativeButton("いいえ") { _, _ ->
                    Toast.makeText(activity, "キャンセルしました。", Toast.LENGTH_SHORT).show()
                }
                setPositiveButton("はい") { _, _ ->
                    Toast.makeText(
                        activity,
                        getString(R.string.greet, textMsg.text),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.create() // 生成するcreateメソッドを忘れない
        }

        return dialog ?: throw IllegalStateException("Activity is null")
    }
}