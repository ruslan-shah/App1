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


    Add add = new Add();
    Sub sub = new Sub();

    String operand1 = "";
    String operand2 = "";
    Operation oper;

    class Operation {
        void Exec () {
            tv.setText("base");
        };
    };
    class Add extends Operation {
        @Override
        void Exec () {
            super.Exec();
//            tv.setText("Add");
        }
    };

    class Sub extends Operation {
        @Override
        void Exec () {
            super.Exec();
//            tv.setText("Sub");
        }
    };

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
        if (oper == null)
            operand1 = operand1 + ((Button) view).getText().toString();
        else
            operand2 = operand2 + ((Button) view).getText().toString();
        String s = operand1;
//        if (oper != null)
  //          s =

//        ((Button) view).getText().toString()
  //      tv.setText(operand1.toString());
//        if (((Button) view).getText().toString().equals("1")) {
//            oper = add;
//        }
//        if (((Button) view).getText().toString().equals("2")) {
//            oper = sub;
//        }
//        if (((Button) view).getText().toString().equals("3")) {
//            if (oper != null)
//              oper.Exec();
//        }
    }
}

