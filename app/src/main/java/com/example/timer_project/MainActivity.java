package com.example.timer_project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnStart;
    ImageButton bynClear;
    TextView plainText1,plainText2,plainText3;
    StringBuffer values = new StringBuffer();
    MediaPlayer mediaPlayer;
    String hour = "00h";
    String min = "00m";
    String sec = "00s";
    int ss_div = 0;
    int ss_rem = 0;
    int mm_div = 0;
    int mm_rem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.uu);

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
        btnStart = findViewById(R.id.btnStart);
        bynClear = findViewById(R.id.btnClear);

        btnStart.setEnabled(false);

        plainText1 = findViewById(R.id.plainText1);
        plainText2 = findViewById(R.id.plainText2);
        plainText3 = findViewById(R.id.plainText3);

        plainText1.setEnabled(false);
        plainText2.setEnabled(false);
        plainText3.setEnabled(false);

        plainText1.setText(hour);
        plainText2.setText(min);
        plainText3.setText(sec);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    values.append('0');
                    btnStart.setEnabled(true);
                }
                show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    values.append('1');
                    btnStart.setEnabled(true);
                }
                show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('2');
                }
                show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('3');
                }
                show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('4');
                }
                show();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('5');
                }
                show();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('6');
                }
                show();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('7');
                }
                show();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('8');
                }
                show();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()<6){
                    btnStart.setEnabled(true);
                    values.append('9');
                }
                show();
            }
        });

        bynClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(values.length()>0){
                    values.deleteCharAt(values.length()-1);
                    if(values.length()>0)show();
                    else{
                        hour = "00h";
                        min = "00m";
                        sec = "00s";
                        plainText1.setText(hour);
                        plainText2.setText(min);
                        plainText3.setText(sec);
                    }
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bynClear.setEnabled(false);
                btnStart.setEnabled(false);
                btn0.setEnabled(false);btn1.setEnabled(false);btn2.setEnabled(false);btn3.setEnabled(false);
                btn4.setEnabled(false);btn5.setEnabled(false);btn6.setEnabled(false);btn7.setEnabled(false);
                btn8.setEnabled(false);btn9.setEnabled(false);

                if(values.length()>0){
                    String value = values.toString();
                    if(value.length()<6){
                        int diff = 6 - value.length();
                        String temp = "";
                        while(diff>0){
                            temp += '0';
                            diff--;
                        }
                        value = temp+value;
                    }
                    int hh = Integer.parseInt(value.substring(0,2));
                    int mm = Integer.parseInt(value.substring(2,4));
                    int ss = Integer.parseInt(value.substring(4,6));

                    if(ss>60){
                        ss_div = ss/60;
                        ss_rem = ss%60;
                        mm += ss_div;
                        ss = ss_rem;
                    }

                    if(mm>60){
                        mm_div = mm/60;
                        mm_rem = mm%60;
                        hh += mm_div;
                        mm = mm_rem;
                    }

                    long total_sec = (hh*3600)+(mm*60)+ss;

                    new CountDownTimer(total_sec*1000,1000){
                        public void onTick(long sec){
                            time(sec/1000);
                        }
                        public void onFinish(){
                            hour = "00h";
                            min = "00m";
                            sec = "00s";
                            values = new StringBuffer();
                            plainText1.setText(hour);
                            plainText2.setText(min);
                            plainText3.setText(sec);
                            Toast.makeText(getApplicationContext(), "TIME OUT", Toast.LENGTH_LONG).show();
                            bynClear.setEnabled(true);
                            btnStart.setEnabled(true);
                            btn0.setEnabled(true);btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);
                            btn4.setEnabled(true);btn5.setEnabled(true);btn6.setEnabled(true);btn7.setEnabled(true);
                            btn8.setEnabled(true);btn9.setEnabled(true);
                            mediaPlayer.start();
                        }
                    }.start();
                }else{
                    hour = "00h";
                    min = "00m";
                    sec = "00s";
                    plainText1.setText(hour);
                    plainText2.setText(min);
                    plainText3.setText(sec);
                    Toast.makeText(getApplicationContext(), "ENTER THE TIME", Toast.LENGTH_LONG).show();
                    bynClear.setEnabled(true);
                    btnStart.setEnabled(true);
                    btn0.setEnabled(true);btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);
                    btn4.setEnabled(true);btn5.setEnabled(true);btn6.setEnabled(true);btn7.setEnabled(true);
                    btn8.setEnabled(true);btn9.setEnabled(true);
                }
            }
        });

    }

    protected void show(){
        String value = values.toString();
        if(value.length()<6){
            int diff = 6 - value.length();
            String temp = "";
            while(diff>0){
                temp += '0';
                diff--;
            }
            value = temp+value;
        }
        String hh = value.substring(0,2)+"h";
        String mm = value.substring(2,4)+"m";
        String ss = value.substring(4,6)+"s";

        plainText1.setText(hh);
        plainText2.setText(mm);
        plainText3.setText(ss);

    }

    protected void time(long s){
        hour = String.format("%02d",s/3600);
        min = String.format("%02d",s/60%60);
        sec = String.format("%02d",s%60);

        plainText1.setText(hour+"h");
        plainText2.setText(min+"m");
        plainText3.setText(sec+"s");

    }
}