package com.example.dz_ls_task1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    companion object {
        val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
        private var mReply: EditText? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mReply = editText_second
        val intent = getIntent()
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView = text_message
        textView.setText(message)
    }

    fun returnReply(view: View) {
        val reply = mReply!!.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}
