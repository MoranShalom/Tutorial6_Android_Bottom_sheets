package com.example.tutorial6_button_sheets;

//In this tutorial you will learn how to create an android bottom sheet and be able to use it inside your app.

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private NestedScrollView bottomSheet;
    private  BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button= (Button) findViewById(R.id.button);
        bottomSheet=(NestedScrollView) findViewById(R.id.bottom_sheet);
        bottomSheetBehavior= BottomSheetBehavior.from(bottomSheet);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                    button.setText("Collapse Bottom sheet");
                }else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    button.setText("Expand botton sheet");
                }
            }
        });

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                if (i==BottomSheetBehavior.STATE_EXPANDED)
                    button.setText("Collapse Bottom sheet");
                else if (i== BottomSheetBehavior.STATE_COLLAPSED)
                    button.setText("Expand botton sheet");

            }

            @Override
            public void onSlide(@NonNull View view, float v) {
            }
        });

        bottomSheetBehavior.setPeekHeight(0);
    }
}
