package android.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.*;
import java.util.ArrayList;


public class calculator extends AppCompatActivity {
    calculate c;
    ArrayList<String> list;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonadd, buttonsub, buttonmultiply, buttondivision, buttonequalto, buttonC, buttonsquareroot, buttonpower, buttondot,buttonsign,buttonback;
    TextView result;
    String temp="";
    Character lastch=' ';
    boolean sqoperator = true,backoperator=false,back=true;
    int i = 0;
    String text="",remind="";
    HorizontalScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        c = new calculate();
        list = new ArrayList<String>();
        scroll=(HorizontalScrollView) findViewById(R.id.scroll);
        scroll.fullScroll(View.FOCUS_RIGHT);
        buttonback=(Button) findViewById(R.id.buttonback);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonadd = (Button) findViewById(R.id.buttonadd);
        buttonmultiply = (Button) findViewById(R.id.buttonmultiply);
        buttondivision = (Button) findViewById(R.id.buttondivision);
        buttonsub = (Button) findViewById(R.id.buttonsub);
        buttonequalto = (Button) findViewById(R.id.button1equalto);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonsquareroot = (Button) findViewById(R.id.buttonsquareroot);
        buttonpower = (Button) findViewById(R.id.buttonpower);
        buttondot = (Button) findViewById(R.id.buttondot);
        buttonsign=(Button) findViewById(R.id.buttonsign);
        result = (TextView) findViewById(R.id.result);

        buttonback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if((!list.isEmpty() || temp!="")&&back){
                    text=String.valueOf(result.getText());
                    lastch=text.charAt(text.length()-1);
                    if(Character.isDigit(lastch)||lastch==')'||lastch=='.'){
                        if(temp.charAt(0)=='-'){
                            result.setText(text.replaceAll(".(-).*$",""));
                            temp="";
                        }
                        else{
                            result.setText(text.replaceAll(temp+"$",""));
                            temp="";
                        }

                    }
                    else{
                        if(list.get(list.size()-1)!="√"){
                            sqoperator=false;
                        }
                        else{
                            sqoperator=true;
                        }
                        result.setText(text.replaceAll(".$",""));
                        list.remove(list.size()-1);
                        backoperator=true;
                    }
                    back=false;
                }


            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "0");
                temp = temp + "0";
                sqoperator = false;
                back=true;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
                temp = temp + "1";
                sqoperator = false;
                back=true;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
                temp = temp + "2";
                sqoperator = false;
                back=true;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
                temp = temp + "3";
                back=true;
                sqoperator = false;
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
                temp = temp + "4";
                sqoperator = false;
                back=true;
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
                temp = temp + "5";
                sqoperator = false;
                back=true;
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
                temp = temp + "6";
                sqoperator = false;
                back=true;
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
                temp = temp + "7";
                sqoperator = false;
                back=true;
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
                temp = temp + "8";
                sqoperator = false;
                back=true;
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "9");
                temp = temp + "9";
                sqoperator = false;
                back=true;
            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!temp.isEmpty()&&temp!="-"){
                    result.setText(result.getText() + ".");
                    temp = temp + ".";
                    sqoperator = false;
                    back=true;
                }
            }
        });
        buttonsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temp.isEmpty()&&temp!="-"){
                    result.setText(result.getText() + "(-)");
                    temp ="-";
                    sqoperator = false;
                    back=true;
                }
                else{
                    calltoast();
                }
            }
        });


        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!temp.isEmpty()||backoperator)&&temp!="-"){
                    result.setText(result.getText() + "+");
                    if(backoperator) {
                        list.remove(list.size() - 1);
                        temp = temp + remind;
                    }
                        list.add(temp);
                    remind=temp;
                    list.add("+");
                    temp = "";
                    sqoperator = true;
                    backoperator=false;
                    back=true;

                }
                else {
                    calltoast();
                }

            }
        });
        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!temp.isEmpty()||backoperator)&&temp!="-") {
                    result.setText(result.getText() + "-");
                    if(backoperator) {
                        list.remove(list.size() - 1);
                        temp = temp + remind;
                    }
                    list.add(temp);
                    remind=temp;
                    list.add("-");
                    temp = "";
                    sqoperator = true;
                    backoperator=false;
                    back=true;
                }
            }
        });
        buttonmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!temp.isEmpty()||backoperator)&&temp!="-") {
                    result.setText(result.getText() + "×");
                    if(backoperator) {
                        list.remove(list.size() - 1);
                        temp = temp + remind;
                    }
                    list.add(temp);
                    remind=temp;
                    list.add("×");
                    temp = "";
                    sqoperator = true;
                    backoperator=false;
                    back=true;

                }
                else {
                    calltoast();
                }

            }
        });
        buttondivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!temp.isEmpty()||backoperator)&&temp!="-") {
                    result.setText(result.getText() + "÷");
                    if(backoperator) {
                        list.remove(list.size() - 1);
                        temp = temp + remind;
                    }
                    list.add(temp);
                    list.add("÷");
                    temp = "";
                    sqoperator = true;
                    backoperator=false;
                    back=true;

                }
                else {
                    calltoast();
                }

            }
        });
        buttonsquareroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (temp.isEmpty() && sqoperator && temp!="-"){
                        result.setText(result.getText() + "√");
                        list.add("√");
                        temp = "";
                        sqoperator = false;
                    backoperator=false;
                    back=true;
                }
                else{
                    calltoast();
                }

            }
        });
        buttonpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!temp.isEmpty()||backoperator)&&temp!="-") {
                    result.setText(result.getText() + "^");
                    if(backoperator) {
                        list.remove(list.size() - 1);
                        temp = temp + remind;
                    }
                    list.add(temp);
                    remind=temp;
                    list.add("^");
                    temp = "";
                    sqoperator = true;
                    backoperator=false;
                    back=true;

                }
                else {
                    calltoast();
                }

            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                temp = "";
                list.clear();
                sqoperator = true;
                backoperator=false;
                back=true;
            }
        });
        buttonequalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!temp.isEmpty()||backoperator)&&temp!="-") {
                    if(backoperator) {
                        list.remove(list.size() - 1);
                        temp = temp + remind;
                    }
                    list.add(temp);
                    result.setText(c.finalanswer(list));
                    temp = c.finalanswer(list);
                    list.clear();
                    sqoperator = false;
                    backoperator=false;
                    back=true;
                }
                else {
                    calltoast();
                }

            }
        });
        }
    private void calltoast(){
         Toast.makeText(getApplicationContext(),"Enter a digit",Toast.LENGTH_SHORT).show();

    }
}