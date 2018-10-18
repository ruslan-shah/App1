package com.example.shakhbulatov.app001;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);

        ((Button)findViewById(R.id.btnC)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("");

            }
        });

    }
    public void onDigitButtonClick(View view)
    {
        tv.setText(tv.getText().toString() + ((Button) view).getText().toString());
    }
}

