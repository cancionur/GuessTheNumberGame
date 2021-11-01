package com.example.guessthenumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class OyunEkrani extends AppCompatActivity {

    private TextView textViewKalanHak,textViewBilgi;
    private EditText editText;
    private Button button;
    int hak = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_ekrani);

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewBilgi = findViewById(R.id.textViewBilgi);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        Random rnd = new Random();

        int rasgele_sayi = rnd.nextInt(100);
        Log.e("Rasgele Sayi",String.valueOf(rasgele_sayi));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OyunEkrani.this,SonucEkrani.class);


                int tahmin = Integer.parseInt(editText.getText().toString());
                if(tahmin == rasgele_sayi){
                    intent.putExtra("Sonuc",true);
                    intent.putExtra("Sayi",rasgele_sayi);
                    finish();
                    startActivity(intent);
                }
                if(tahmin > rasgele_sayi){
                    textViewBilgi.setText("Tahminini azalt ");
                    hak--;
                    textViewKalanHak.setText("Kalan Hakkın : " + hak);
                }
                if(tahmin < rasgele_sayi){
                    textViewBilgi.setText("Tahminini arttır");
                    hak--;
                    textViewKalanHak.setText("Kalan Hakkın : " + hak);
                }

                if(hak == 0){
                    intent.putExtra("Sonuc",false);
                    intent.putExtra("Sayi",rasgele_sayi);
                    finish();
                    startActivity(intent);
                }

                editText.setText("");


            }});

    }



    public void onBackPressed(){
        super.onBackPressed();

        Intent intent = new Intent(OyunEkrani.this,MainActivity.class);

        startActivity(intent);
    }
}