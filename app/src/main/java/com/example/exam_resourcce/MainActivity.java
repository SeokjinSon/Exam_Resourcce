package com.example.exam_resourcce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

// 화면 터치 시 텍스트 변경 되도록
public class MainActivity extends AppCompatActivity {
    // Member Variable --------------------------------------
    private final String        TAG = "MainActivity"; // 상수는 대문자로
    private LinearLayout        linearLAY;
    private TextView            msgTXT;
    private EditText            inputETXT;

    private Resources           appRes;     // xml res 자원 접근 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 객체 변수 초기화
        linearLAY = findViewById(R.id.linearLAY); // View 객체 획득
        msgTXT = findViewById(R.id.msgTXT);
        inputETXT = findViewById(R.id.msgETXT);

        appRes = this.getResources();
    }

    // Member Method - xml onclick 처리 메서드 ---------------
    public void onClick(View v) { // 매 상황마다 오는 뷰가 다르므로 특정 뷰를 위한 함수 사용 불가
        // 클릭한 UI 요소 객체가 인자 v에 담겨져 옴
        if(v.getId() == R.id.linearLAY) {
            // 전체 화면인 LinearLayout을 클릭했을 경우 처리
            msgTXT.setTextColor(Color.RED);
            msgTXT.setTextSize(30);

            String curText = msgTXT.getText().toString();
            Log.i(TAG, "curText => " + curText);

            // 클릭한 글자를 TextView에 표시
            // msgTXT.setText("Hello World");
        }

        String value = inputETXT.getText().toString();

        // 입력 여부에 따라서 처리
        if(value.length()>0)
            msgTXT.setText(value);
        else
            //msgTXT.setText("Nothing");
            msgTXT.setText(appRes.getString(R.string.nothing));
    }


}