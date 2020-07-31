package com.example.notsosimple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * MainActivity
 *
 * @author Tao Yan
 * @version July 2020
 */
public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonRPoint, buttonC, buttonEqual, buttonLPar, buttonRPar;
    TextView edttxt;
    float val_one, val_two;
    boolean add, sub, mul, div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById((R.id.btn0));
        button1 = (Button) findViewById((R.id.btn1));
        button2 = (Button) findViewById((R.id.btn2));
        button3 = (Button) findViewById((R.id.btn3));
        button4 = (Button) findViewById((R.id.btn4));
        button5 = (Button) findViewById((R.id.btn5));
        button6 = (Button) findViewById((R.id.btn6));
        button7 = (Button) findViewById((R.id.btn7));
        button8 = (Button) findViewById((R.id.btn8));
        button9 = (Button) findViewById((R.id.btn9));
        buttonAdd = (Button) findViewById((R.id.btnPlusSign));
        buttonSub = (Button) findViewById((R.id.btnMinusSign));
        buttonMul = (Button) findViewById((R.id.btnMultiplicationSign));
        buttonDivision = (Button) findViewById((R.id.btnDivisionSign));
        buttonC = (Button) findViewById((R.id.btnClear));
        buttonRPoint = (Button) findViewById((R.id.btnRadixPoint));
        buttonEqual = (Button) findViewById((R.id.btnEqualsSign));
        buttonLPar = (Button) findViewById((R.id.btnLeftPar));
        buttonRPar = (Button) findViewById((R.id.btnRightPar));
        edttxt = (TextView) findViewById((R.id.screen));
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "9");
            }
        });
        buttonRPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + ".");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "+");
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "-");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "*");
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "/");
            }
        });
        buttonLPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "(");
            }
        });
        buttonRPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + ")");
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText("");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    edttxt.setText(((new Infix2BigDecimal()).runTape((edttxt.getText()).toString()).toString()));
                } catch (FormalLanguageProcessingMachineException e) {
                    edttxt.setText("Grammar error. Refer to README.md for grammatical rules and acceptable inputs");
                }
            }
        });
    }
}
