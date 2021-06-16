package com.amnLabs.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    private MaterialButton btn0;
    private MaterialButton btn1;
    private MaterialButton btn2;
    private MaterialButton btn3;
    private MaterialButton btn4;
    private MaterialButton btn5;
    private MaterialButton btn6;
    private MaterialButton btn7;
    private MaterialButton btn8;
    private MaterialButton btn9;
    private MaterialButton btnKets;
    private FloatingActionButton btnEquals;
    private MaterialButton btnClear;
    private LinearLayout activityMain;
    private MaterialButton btnMod;
    private MaterialButton btnDivide;
    private MaterialButton btnMul;
    private MaterialButton btnPlus;
    private MaterialButton btnMinus;
    private MaterialButton btnPoint;
    private MaterialButton btnBackSpace;
    private TextView etCurrentText;
    private EditText inputField;
    private MaterialButton btnClose;
    private MaterialButton btnMenu;
    String process;
    boolean checkBracket = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        setListeners();
    }

    private void setListeners() {
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(activityMain,"Wow! menu does not exits, that's great.",Snackbar.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCurrentText.setText("");
                inputField.setText("");
                checkBracket = false;
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "x");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "÷");
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + ".");
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                inputField.setText(process + "%");
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = inputField.getText().toString();
                process = process.replaceAll("x","*");
                process = process.replaceAll("÷","/");
                Context r = Context.enter();
                r.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = r.initStandardObjects();
                    finalResult = r.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult = "Nah";
                    Snackbar.make(activityMain,e.toString(),Snackbar.LENGTH_SHORT).show();
                }
                etCurrentText.setText(finalResult);
            }
        });

        btnKets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBracket){
                    process = inputField.getText().toString();
                    inputField.setText(process + ")");
                    checkBracket = false;
                }else{
                    process = inputField.getText().toString();
                    inputField.setText(process + "(");
                    checkBracket = true;
                }
            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(process.length()>=0){
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    process = inputField.getText().toString();
                                    String l = process.substring(process.length()-1);
                                    process = process.substring(0,process.length()-1);
                                    if(l.contains("(")){
                                        checkBracket = false;
                                    }else{
                                        checkBracket = true;
                                    }
                                    inputField.setText(process);
                                }catch (Exception e){

                                }
                            }
                        });
                    }
            }
        });

    }

    private void findId(){
        btnClose = findViewById(R.id.btnClose);
        btnClear = findViewById(R.id.btnClear);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnEquals = findViewById(R.id.btnEquals);
        btnMenu = findViewById(R.id.btnMenu);
        btnKets = findViewById(R.id.btnKets);
        btnPoint = findViewById(R.id.btnPoint);
        btnMod = findViewById(R.id.btnMod);
        btnDivide = findViewById(R.id.btnDivide);
        btnMul = findViewById(R.id.btnMul);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        activityMain = findViewById(R.id.activityMain);
        etCurrentText = findViewById(R.id.currentText);
        inputField = findViewById(R.id.inputField);
        btnBackSpace = findViewById(R.id.btnBackSpace);
    }
}