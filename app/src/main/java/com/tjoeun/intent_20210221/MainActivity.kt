package com.tjoeun.intent_20210221

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    닉네임변경 - 1001 이라는것을 아예 변수로 넣어두고 사용하자.
    val REQ_FOR_NICKNAME = 1001

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
            val myIntent = Intent(this, SecondActivity::class.java)

//            인텐트의 부가정보로, 들고갈 데이터들을 붙여주자.
            myIntent.putExtra("message", inputContent)

//            필요시 여러개 데이터를 첨부 가능. (단순 예시)
//            myIntent.putExtra("출생년도", 1988)

            startActivity(myIntent)

        }

        changeNicknameBtn.setOnClickListener {

//            새 닉네임을 얻기 위해 => 액티비티 이동
            val myIntent = Intent(this, EditNicknameActivity::class.java)

//            어떤 데이터를 받으러 가는건지를 숫자로 구별해야함. ex. 닉네임변경 - 1001
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)


        }

        dialBtn.setOnClickListener {
//            입력한 전화번호 저장.
            val phoneNum = phoneNumEdt.text.toString()

//            폰번(010-1111-2222) => 안드로이드의 연결정보 (Uri)로 변환.
            val myUri = Uri.parse("tel:${phoneNum}")

//            Intent를 활용해서 => 안드로이드 전화 화면 띄우자.
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)

        }

        callBtn.setOnClickListener {
            val phoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        requestCode 값 확인 => 닉네임을 가지러 갔다온게 맞는가?
        if (requestCode == REQ_FOR_NICKNAME) {

//            확인 버튼을 누른게 맞는지? 확인.
            if (resultCode == Activity.RESULT_OK) {

//                새 닉네임을 받아서 => 닉네임 텍스트뷰에 반영.
                val newNickName = data?.getStringExtra("nick")

                nicknameTxt.text = newNickName

            }

        }

    }

}