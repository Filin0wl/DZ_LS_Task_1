package com.example.dz_ls_task1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    companion object {
        private val LOG_TAG = MainActivity.javaClass.simpleName
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        private var mMessageEditText: EditText? = null
        const val TEXT_REQUEST = 1
        private var mReplyHeadTextView: TextView? = null
        private var mReplyTextView: TextView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = editText_main as EditText
        mReplyHeadTextView = text_header_reply
        mReplyTextView = text_message_reply


    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView!!.visibility = View.VISIBLE
                mReplyTextView!!.text = reply
                mReplyTextView!!.visibility = View.VISIBLE
            }
        }
    }
}
