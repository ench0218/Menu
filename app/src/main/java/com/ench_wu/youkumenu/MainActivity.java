package com.ench_wu.youkumenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout level2, level1;
    private ImageButton ivHome;
    private boolean isShowLevel2 = true;
    private ImageButton ivMeun;
    private RelativeLayout level3;
    private boolean isShowLevel3 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initListener();
    }

    private void initListener() {
        ivHome.setOnClickListener(this);
        ivMeun.setOnClickListener(this);
    }

    public void initUI() {
        level1 = (RelativeLayout) findViewById(R.id.level1);
        ivHome = (ImageButton) findViewById(R.id.iv_home);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        ivMeun = (ImageButton) findViewById(R.id.iv_meun);
        level3 = (RelativeLayout) findViewById(R.id.level3);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_home:
                //判断当前是否有动画在执行,如有的话直接跳出
                if (Anim.animationCount !=0){
                    return;
                }
                long startOffset = 0;
                if (isShowLevel3) {
                    //需要隐藏level3
                    Anim.closeAnim(level3, startOffset);
                    startOffset += 100;
                }
                if (isShowLevel2) {
                    //需要隐藏level2
                    Anim.closeAnim(level2, startOffset);
                    isShowLevel2 = false;
                } else {
                    //需要显示level2 & level3
                    Anim.openAnim(level2, startOffset);
                    startOffset += 100;
                    Anim.openAnim(level3, startOffset);
                    isShowLevel2 = true;
                    isShowLevel3 = true;
                }
                break;
            case R.id.iv_meun:
                if (Anim.animationCount !=0){
                    return;
                }

                if (isShowLevel3) {
                    //需要隐藏level2
                    Anim.closeAnim(level3, 0);
                    isShowLevel3 = false;
                } else {
                    //需要显示level2
                    Anim.openAnim(level3, 0);
                    isShowLevel3 = true;
                }
                break;
        }
    }
}
