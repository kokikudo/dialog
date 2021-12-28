package com.example.dialog
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyAlertDialogFragment : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = activity?.let {
            val inputText = arguments?.getString("inputText")
            AlertDialog.Builder(it).apply {
                setTitle(R.string.d_title)
                setMessage("こんにちは、${inputText}さん")
                setIcon(R.drawable.wings)

            }.create() // 生成するcreateメソッドを忘れない
        }

        return dialog ?: throw IllegalStateException("Activity is null")
    }
}