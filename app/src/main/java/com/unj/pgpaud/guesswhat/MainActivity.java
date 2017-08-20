package com.unj.pgpaud.guesswhat;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SharedPreference sharedPreference;
    private static ArrayList<Integer> kodeAcak = new ArrayList<Integer>();

    public MainActivity(){
    }

    public static ArrayList<Integer> getKodeAcak() {
        return kodeAcak;
    }

    public void setKodeWarna(ArrayList<Integer> kodeAcak) {
        this.kodeAcak = kodeAcak;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMulai = (Button)findViewById(R.id.btnPlay);
        Button btnInfo = (Button)findViewById(R.id.btnInfo);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(intent);
            }
        });

        Random randomGenerator = new Random();
        int random;
        while (kodeAcak.size() < 10) {
            random = randomGenerator.nextInt(10);
            if (!kodeAcak.contains(random)) {
                kodeAcak.add(random);
            }
        }

        final int x = kodeAcak.get(0);

        sharedPreference = new SharedPreference();

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreference.setPreferences(getApplicationContext(), "level", 0);
                sharedPreference.setPreferences(getApplicationContext(), "lives", 3);
                if(x==0){
                    Intent intent = new Intent(getApplicationContext(), WarnaMerahActivity.class);
                    startActivity(intent);
                }else if(x==1){
                    Intent intent = new Intent(getApplicationContext(), WarnaBiruActivity.class);
                    startActivity(intent);
                }else if(x==2){
                    Intent intent = new Intent(getApplicationContext(), WarnaCokelatActivity.class);
                    startActivity(intent);
                }else if(x==3){
                    Intent intent = new Intent(getApplicationContext(), WarnaHijauActivity.class);
                    startActivity(intent);
                }else if(x==4){
                    Intent intent = new Intent(getApplicationContext(), WarnaHitamActivity.class);
                    startActivity(intent);
                }else if(x==5){
                    Intent intent = new Intent(getApplicationContext(), WarnaKuningActivity.class);
                    startActivity(intent);
                }else if(x==6){
                    Intent intent = new Intent(getApplicationContext(), WarnaUnguActivity.class);
                    startActivity(intent);
                }else if(x==7){
                    Intent intent = new Intent(getApplicationContext(), WarnaOranyeActivity.class);
                    startActivity(intent);
                }else if(x==8){
                    Intent intent = new Intent(getApplicationContext(), WarnaAbuAbuActivity.class);
                    startActivity(intent);
                }else if(x==9){
                    Intent intent = new Intent(getApplicationContext(), WarnaPingActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
