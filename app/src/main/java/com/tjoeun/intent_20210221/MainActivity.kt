package com.tjoeun.intent_20210221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToFirstActivityBtn.setOnClickListener {

//            FirstActivity로 넘어가기.

            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)

        }

        sendContentBtn.setOnClickListener {

//            입력한 문구를 String으로 추출 (저장)
            val inputContent = contentEdt.text.toString()

//            두번째 화면 (SecondActivity) 으로 => inputContent의 값을 들고 => 이동

        }

    }
}