package com.example.shakhbulatov.app001;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    TextView tv;

    String pattern = "#.#########";
    String err = "";

    Add add = new Add();
    Sub sub = new Sub();
    Divide divide = new Divide();
    Mult mult = new Mult();

    String operand1 = "";
    String operand2 = "";
    Operation oper;

    abstract class Operation {
        abstract String GetTxt();
        abstract void Exec ();
    };

    class Add extends Operation {
        @Override
        void Exec () {
            operand1 = new DecimalFormat(pattern).format(Double.parseDouble(operand1) + Double.parseDouble(operand2));
            operand2 = "";
        }
        @Override
        String GetTxt() {
            return "+";
        }
    };

    class Sub extends Operation {
        @Override
        void Exec () {
            operand1 = new DecimalFormat(pattern).format(Double.parseDouble(operand1) - Double.parseDouble(operand2));
            operand2 = "";
        }
        @Override
        String GetTxt() {
            return "-";
        }
    };

    class Divide extends Operation {
        @Override
        void Exec () {
            if (Double.parseDouble(operand2) != 0) {
                operand1 = new DecimalFormat(pattern).format(Double.parseDouble(operand1) / Double.parseDouble(operand2));
            }
            else {
                operand1 = "";
                err = "Error: Divide by zero!";
            };
            operand2 = "";
        }
        @Override
        String GetTxt() {
            return "/";
        }
    };

    class Mult extends Operation {
        @Override
        void Exec () {
            operand1 = new DecimalFormat(pattern).format(Double.parseDouble(operand1) * Double.parseDouble(operand2));
            operand2 = "";
        }
        @Override
        String GetTxt() {
            return "*";
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);

        ((Button)findViewById(R.id.btnC)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operand1 = "";
                operand2 = "";
                oper = null;
                Display();
            }
        });

        ((Button)findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExecOper(add);
            }
        });
        ((Button)findViewById(R.id.btnSub)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExecOper(sub);
            }
        });
        ((Button)findViewById(R.id.btnDiv)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExecOper(divide);
            }
        });
        ((Button)findViewById(R.id.btnMult)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExecOper(mult);
            }
        });
        ((Button)findViewById(R.id.btnCalc)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ExecOper(null);
            }
        });


    }
    void ExecOper(Operation op)
    {
        if (oper != null && operand2 != "")
            oper.Exec();
        if (operand1 == "")
          oper = null;
        else
          oper = op;
        Display();
    }

    void Display()
    {
        String s;
        if (err != "") {
            s = err;
            err = "";
        }
        else {
            s = operand1;
            if (oper != null)
                s = s + oper.GetTxt() + operand2;
        }
        tv.setText(s);
    }

    public void onDigitButtonClick(View view)
    {
        if (oper == null)
            operand1 = operand1 + ((Button) view).getText().toString();
        else
            operand2 = operand2 + ((Button) view).getText().toString();
        Display();
    }
}

