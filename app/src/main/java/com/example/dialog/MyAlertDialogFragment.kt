package com.example.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException
import java.util.*

class MyAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 選択した日付をEditTextに反映させる

        // 今日の日付
        val todayCal = Calendar.getInstance()
        val dialog = activity?.let {

            // DatePickerDialog
            // 第一引数にcontext(今回の場合は表示するActivity)
            // 第二引数に選択した時のイベントリスナー
            // 第三、四、五はそれぞれ年、月、日の初期値を入れる
            DatePickerDialog(
                it,
                { view, year, monthOfYear, dayOfMonth ->
                    // 選択した日付をEditTextに反映
                    val txtDate = it.findViewById<EditText>(R.id.editText)
                    txtDate.setText(
                        getString(
                            R.string.date_text,
                            year, monthOfYear + 1,
                            dayOfMonth
                        )
                    )
                },
                // 初期の日付
                todayCal[Calendar.YEAR],
                todayCal[Calendar.MONTH],
                todayCal[Calendar.DAY_OF_MONTH],
            )
        }

        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}