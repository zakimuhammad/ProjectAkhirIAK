package com.example.zaki.quizislami;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<Soal> soalList;
    int index = 0;
    int skor = 0;

    TextView soalKe;
    TextView soalIslami;
    ImageView gambarSoal;
    Button btnSoalA;
    Button btnSoalB;
    Button btnSoalC;
    Button btnSoalD;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soalList = new ArrayList<>();

        soalKe = (TextView) findViewById(R.id.soalKe);
        gambarSoal = (ImageView) findViewById(R.id.gambarSoal);
        soalIslami = (TextView) findViewById(R.id.soalIslami);
        btnSoalA = (Button) findViewById(R.id.btnSoalA);
        btnSoalB = (Button) findViewById(R.id.btnSoalB);
        btnSoalC = (Button) findViewById(R.id.btnSoalC);
        btnSoalD = (Button) findViewById(R.id.btnSoalD);

        buatSoal();
        updateView();
    }

    public void buatSoal(){
        soalList.add(new Soal("Apakah Nama Gambar Seni Diatas?","Kaligrafi","Sketsa","Abstrak","Lukisan","Kaligrafi",R.drawable.bismillah));
        soalList.add(new Soal("Dimanakah Letak Masjid Al Aqsa?","Baghdad","Jeddah","Jerussalem","Istanbul","Jerussalem",R.drawable.alaqsa));
        soalList.add(new Soal("Apakah Nama Bangunan Tersebut?","Ka'bah","Vihara","Candi","Prasasti","Ka'bah",R.drawable.kabah));
        soalList.add(new Soal("Berapakah Pahala Yang Dilipat gandakan Jika Sholat Di Masjid Nabawi?","100","1000","100000","1100","1000",R.drawable.nabawi));
        soalList.add(new Soal("Untuk Siapakah Kitab Suci Tersebut Diturunkan","Isa","Musa","Daud","Muhammad","Muhammad",R.drawable.quran));
    }

    public void gambarNext(){
        if (index<soalList.size()-1){
            index++;
            updateView();
        }else{
            Intent i = new Intent(this, PenilaianActivity.class);
            i.putExtra("skor",skor);
            startActivity(i);
            finish();
        }
    }

    public void updateView(){
        gambarSoal.setImageResource(soalList.get(index).getGambar());
        soalIslami.setText(soalList.get(index).getSoal());
        btnSoalA.setText(soalList.get(index).getJwbA());
        btnSoalB.setText(soalList.get(index).getJwbB());
        btnSoalC.setText(soalList.get(index).getJwbC());
        btnSoalD.setText(soalList.get(index).getJwbD());
        soalKe.setText("Soal Ke-"+(index+1));
    }

    public void checkJawaban(View view){
        Button clickedButton = (Button) view;
        String jawaban = clickedButton.getText().toString();
        String benar = soalList.get(index).getJwbBenar();
        if (jawaban.equals(benar)){
            //BENER
            tambahScore();
        }
        gambarNext();
    }

    public void tambahScore(){
        skor += 20;
    }

}
