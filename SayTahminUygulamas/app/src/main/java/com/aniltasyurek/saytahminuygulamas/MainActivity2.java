package com.aniltasyurek.saytahminuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private TextView textViewKalanHak,textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;
    private int rasgeleSayi;
    private int sayac = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonTahmin = findViewById(R.id.buttonTahmin);

        Random r = new Random();

        rasgeleSayi = r.nextInt(11);//0-10
        Log.e("Rasgele Sayı ",String.valueOf(rasgeleSayi));

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayac = sayac - 1 ;

                int tahmin = Integer.parseInt(editTextGirdi.getText().toString());

                if (tahmin == rasgeleSayi){
                    Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                    i.putExtra("sonuc",true);
                    startActivity(i);
                    finish();
                    return;
                }

                if(tahmin > rasgeleSayi){
                    textViewYardim.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak :"+sayac);
                }

                if(tahmin < rasgeleSayi){
                    textViewYardim.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak :"+sayac);
                }

                if(sayac == 0){
                    Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                    i.putExtra("sonuc",false);
                    startActivity(i);
                    finish();
                }

                editTextGirdi.setText("");
            }
        });
    }
}
