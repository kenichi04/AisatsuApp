package jp.techacademy.kenichi04.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    aisatsu(hour, minute)
                },
                12,0,true)
        timePickerDialog.show()
    }

    private fun aisatsu(hour: Int, minute: Int) {
        Log.d("TIME_LOG", "$hour : $minute")

        if(hour in 2..9) {
            textView.text = "おはよう"

        } else if(hour in 10..17) {
            textView.text = "こんにちは"

        } else if(hour >= 18 || hour < 2) {
            textView.text = "こんばんは"
        }
    }
}