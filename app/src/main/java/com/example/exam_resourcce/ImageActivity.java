package com.example.exam_resourcce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    private ImageView   img;
    private Resources   appRes;
    private int         imgResIds[] = {R.drawable.images, R.drawable.images2, R.drawable.images3};
    private int         idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 설정
        setContentView(R.layout.image_layout);

        // res폴더의 XML 자원 접근 객체
        appRes = this.getResources();

        // 화면에 존재하는 UI 요소 객체 가져오기
        img = findViewById(R.id.andIMG);
    }

    public void clickFunc(View v) {
        // 클릭할 때마다 ImageView Image 변경
        img.setImageDrawable(appRes.getDrawable(imgResIds[idx]));

        if(idx == (imgResIds.length-1))
            idx=0;
        else
            idx++;
    }
}