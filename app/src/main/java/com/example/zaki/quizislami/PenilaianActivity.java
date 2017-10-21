package com.example.zaki.quizislami;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PenilaianActivity extends AppCompatActivity {

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penilaian);

        int score = getIntent().getIntExtra("skor",0);

        TextView nilai = (TextView) findViewById(R.id.nilai);
        nilai.setText(""+score);
        TextView textKomen = (TextView) findViewById(R.id.textKomen);
        if(score <=50){
            textKomen.setText("Pengetahuan Keislaman Kamu Kurang, Belajar Lagi Yaa");
        } else if(score > 50 && score <= 70){
            textKomen.setText("Selamat, Pengetahuan Keislaman Kamu Sudah Cukup");
        } else{
            textKomen.setText("Wow, Pengetuan Keislaman Kamu Sudah Mumpuni");
        }
    }

    public void kembali(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
