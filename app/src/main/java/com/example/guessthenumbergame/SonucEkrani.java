package com.example.guessthenumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucEkrani extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewSonuc;
    private Button buttonTekrarOyna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_ekrani);

        buttonTekrarOyna = findViewById(R.id.buttonTekrarOyna);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        imageView = findViewById(R.id.imageView);

        Boolean sonuc = getIntent().getBooleanExtra("Sonuc",true);
        int sayi = getIntent().getIntExtra("Sayi",0);

        if(sonuc == true){
            imageView.setImageResource(R.drawable.gulen_surat);
            textViewSonuc.setText("KAZANDINIZ \nSAYI : " + sayi);
        }
        else {
            imageView.setImageResource(R.drawable.uzulen_surat);
            textViewSonuc.setText("KAYBETTİNİZ\nSAYI : " + sayi);
        }

        buttonTekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SonucEkrani.this,OyunEkrani.class);
                finish();
                startActivity(intent);
            }
        });



    }


    public void onBackPressed(){
        super.onBackPressed();

        Intent intent = new Intent(SonucEkrani.this,MainActivity.class);

        startActivity(intent);
    }
}