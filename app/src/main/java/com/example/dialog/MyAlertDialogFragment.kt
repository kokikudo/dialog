package com.example.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException
import java.util.*

class MyAlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 選択した時刻をEditTextに反映させる

        // 今の時刻を用意
        val todayCal = Calendar.getInstance()
        val dialog = activity?.let {

            // TimePickerDialog
            // 第一引数にcontext(今回の場合は表示するActivity)
            // 第二引数に選択した時のイベントリスナー
            // 第三、四それぞれ時間、分の初期値を入れる
            // 第五に24時間表記にするかどうか
            TimePickerDialog(
                it,
                { view, hourOfDate, minute ->
                    // 選択した日付をEditTextに反映
                    val txtDate = it.findViewById<EditText>(R.id.editText)
                    txtDate.setText(
                        getString(
                            R.string.time_text,
                            hourOfDate,
                            minute
                        )
                    )
                },
                // 初期の時刻
                todayCal[Calendar.HOUR_OF_DAY],
                todayCal[Calendar.MINUTE],
                // 24時間表記にするか
                true
            )
        }

        return dialog ?: throw IllegalStateException("Activity is null.")
    }
}