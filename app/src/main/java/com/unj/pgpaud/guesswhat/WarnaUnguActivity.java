package com.unj.pgpaud.guesswhat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class WarnaUnguActivity extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
    private TextView textView;
    private ImageView imageView, imageRefresh, imageLives1, imageLives2, imageLives3;
    private String answer = "_ _ _ _";
    private int answerIndex = 0;

    SharedPreference sharedPreference;

    @Override
    protected void onDestroy() {
        sharedPreference.clearPreferences(this, "level");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        sharedPreference.clearPreferences(this, "level");
        super.onStop();
    }


    @Override
    public void onBackPressed() {
    }

    private void showLives(){
        int x = sharedPreference.getPreferences(this, "lives");
        if(x==3){
            imageLives1.setVisibility(View.VISIBLE);
            imageLives2.setVisibility(View.VISIBLE);
            imageLives3.setVisibility(View.VISIBLE);
        } else if (x==2){
            imageLives1.setVisibility(View.VISIBLE);
            imageLives2.setVisibility(View.VISIBLE);
            imageLives3.setVisibility(View.INVISIBLE);
        } else if (x==1){
            imageLives1.setVisibility(View.VISIBLE);
            imageLives2.setVisibility(View.INVISIBLE);
            imageLives3.setVisibility(View.INVISIBLE);
        } else {
            imageLives1.setVisibility(View.INVISIBLE);
            imageLives2.setVisibility(View.INVISIBLE);
            imageLives3.setVisibility(View.INVISIBLE);
        }
    }

    private void refreshPage(){
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        button6.setVisibility(View.VISIBLE);
        button7.setVisibility(View.VISIBLE);
        button8.setVisibility(View.VISIBLE);
        button9.setVisibility(View.VISIBLE);
        button10.setVisibility(View.VISIBLE);
        button11.setVisibility(View.VISIBLE);
        button12.setVisibility(View.VISIBLE);
        answer="_ _ _ _";
        textView.setText(answer);
        answerIndex = 0;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warna);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundColor(Color.parseColor("#7D26CD"));

        imageLives1 = (ImageView)findViewById(R.id.imageLives1);
        imageLives2 = (ImageView) findViewById(R.id.imageLives2);
        imageLives3 = (ImageView) findViewById(R.id.imageLives3);

        textView=(TextView)findViewById(R.id.textView);
        textView.setText(answer);
        sharedPreference = new SharedPreference();
        showLives();
        Button btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSet();
                refreshPage();
                buttonClicked();
            }
        });

        //Toast.makeText(this, "Level "+sharedPreference.getPreferences(this, "level"), Toast.LENGTH_SHORT).show();
        
        final int level = sharedPreference.getPreferences(this, "level");
        buttonSet();
        buttonClicked();

        Button btnJawab = (Button)findViewById(R.id.btnJawab);
        btnJawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText().toString().equals("U N G U")) {
                    MainActivity homeActivity = new MainActivity();
                    //sharedPreference = new SharedPreference();

                    ArrayList<Integer> kodeWarna = homeActivity.getKodeAcak();
                    kodeWarna.remove(0);
                    homeActivity.setKodeWarna(kodeWarna);

                    int x = level +1 ;
                    sharedPreference.setPreferences(WarnaUnguActivity.this, "level", x);
                    if(x <= 9 ){
                        if (kodeWarna.get(0) == 0) {
                            Intent intent = new Intent(getApplicationContext(), WarnaMerahActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 1) {
                            Intent intent = new Intent(getApplicationContext(), WarnaBiruActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 2) {
                            Intent intent = new Intent(getApplicationContext(), WarnaCokelatActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 3) {
                            Intent intent = new Intent(getApplicationContext(), WarnaHijauActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 4) {
                            Intent intent = new Intent(getApplicationContext(), WarnaHitamActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 5) {
                            Intent intent = new Intent(getApplicationContext(), WarnaKuningActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 6) {
                            Intent intent = new Intent(getApplicationContext(), WarnaUnguActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 7) {
                            Intent intent = new Intent(getApplicationContext(), WarnaOranyeActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 8) {
                            Intent intent = new Intent(getApplicationContext(), WarnaAbuAbuActivity.class);
                            startActivity(intent);
                        } else if (kodeWarna.get(0) == 9) {
                            Intent intent = new Intent(getApplicationContext(), WarnaPingActivity.class);
                            startActivity(intent);
                        }
                    } else
                    {
                        Intent intent = new Intent(getApplicationContext(), WinActivity.class);
                        startActivity(intent);
                    }

                } else{
                    int lives = sharedPreference.getPreferences(getApplicationContext(), "lives");
                    int x =  lives - 1;
                    Snackbar.make(view, "Oops, Jawaban Kamu Salah!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    if (lives == 3) {
                        imageLives3.setVisibility(View.INVISIBLE);
                    } else if(lives==2){
                        imageLives2.setVisibility(View.INVISIBLE);
                    } else if(lives==1){
                        imageLives1.setVisibility(View.INVISIBLE);
                    }

                    if(x==0){
                        Intent intent = new Intent(getApplicationContext(), GameOverActivity.class);
                        startActivity(intent);
                        sharedPreference.setPreferences(getApplicationContext(), "lives", x);
                    } else {
                        sharedPreference.setPreferences(getApplicationContext(), "lives", x);
                        refreshPage();
                    }
                }
            }
        });
    }


    private void buttonClicked() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button1.getText().toString().charAt(0);
                updateTextView(x);
                button1.setVisibility(View.INVISIBLE);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button2.getText().toString().charAt(0);
                updateTextView(x);
                button2.setVisibility(View.INVISIBLE);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button3.getText().toString().charAt(0);
                updateTextView(x);
                button3.setVisibility(View.INVISIBLE);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button4.getText().toString().charAt(0);
                updateTextView(x);
                button4.setVisibility(View.INVISIBLE);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button5.getText().toString().charAt(0);
                updateTextView(x);
                button5.setVisibility(View.INVISIBLE);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button6.getText().toString().charAt(0);
                updateTextView(x);
                button6.setVisibility(View.INVISIBLE);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button7.getText().toString().charAt(0);
                updateTextView(x);
                button7.setVisibility(View.INVISIBLE);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button8.getText().toString().charAt(0);
                updateTextView(x);
                button8.setVisibility(View.INVISIBLE);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button9.getText().toString().charAt(0);
                updateTextView(x);
                button9.setVisibility(View.INVISIBLE);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button10.getText().toString().charAt(0);
                updateTextView(x);
                button10.setVisibility(View.INVISIBLE);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button11.getText().toString().charAt(0);
                updateTextView(x);
                button11.setVisibility(View.INVISIBLE);
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char x = button12.getText().toString().charAt(0);
                updateTextView(x);
                button12.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void updateTextView(char x){
        if(answerIndex<answer.length()){
            char[] dummyAnswer = answer.toCharArray();
            dummyAnswer[answerIndex]=x;
            answer = String.valueOf(dummyAnswer);
            textView.setText(answer);
            answerIndex+=2;
        }
    }
    private void buttonSet() {
        String alfabet = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
        String answer = "UNGU";
        char[] c = new char[12];
        int[] n = new int[12];

        for (int i = 0; i < answer.length(); i++) {
            c[i] = answer.charAt(i);
        }
        for (int i = answer.length(); i < 12; i++) {
            n[i] = new Random().nextInt(alfabet.length() - 1);
            c[i] = alfabet.charAt(n[i]);
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 12) {
            int random = randomGenerator.nextInt(12);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        button1.setText(c[numbers.get(0)] + "");
        button2.setText(c[numbers.get(1)] + "");
        button3.setText(c[numbers.get(2)] + "");
        button4.setText(c[numbers.get(3)] + "");
        button5.setText(c[numbers.get(4)] + "");
        button6.setText(c[numbers.get(5)] + "");
        button7.setText(c[numbers.get(6)] + "");
        button8.setText(c[numbers.get(7)] + "");
        button9.setText(c[numbers.get(8)] + "");
        button10.setText(c[numbers.get(9)] + "");
        button11.setText(c[numbers.get(10)] + "");
        button12.setText(c[numbers.get(11)] + "");
    }
}
