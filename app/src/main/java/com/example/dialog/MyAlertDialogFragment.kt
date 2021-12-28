package com.example.dialog
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MyAlertDialogFragment : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // ダイアログ生成
        // activity : 呼び出し元のActivity
        // activity?.let{} : nullチェックし、null出なければ処理をする
        val dialog = activity?.let {

            // AlertDialogクラスのBuilderでダイアログ生成
            AlertDialog.Builder(it).apply {
                // applyを使うと、呼び出し元のオブジェクトが自動でthisになり、
                // 呼び出し元のプロパティやメソッドに簡潔にアクセスすることができる

                // タイトルなどの情報をセット
                setTitle(R.string.d_title)
                setMessage(R.string.d_message)
                setIcon(R.drawable.wings)

                // 各ボタン（はい、いいえ、キャンセル）の設定
                setPositiveButton("はい") { dialog, which ->
                    Toast.makeText(activity, "はい", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("いいえ") { dialog, which ->
                    Toast.makeText(activity, "いいえ", Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("キャンセル") { dialog, which ->
                    Toast.makeText(activity, "キャンセル", Toast.LENGTH_SHORT).show()
                }
            }.create() // 生成するcreateメソッドを忘れない
        }

        // nullの場合はエラーをスロー
        return dialog ?: throw IllegalStateException("Activity is null")
    }
}