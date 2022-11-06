package com.aniltasyurek.saytahminuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button buttonTekrar;

    private boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);

        sonuc = getIntent().getBooleanExtra("sonuc",false);

        if (sonuc){
            textViewSonuc.setText("KAZANDINIZ");
            imageViewSonuc.setImageResource(R.drawable.mutlu_resim);
        }else{
            textViewSonuc.setText("KAYBETTİNİZ");
            imageViewSonuc.setImageResource(R.drawable.mutsuz_resim);
        }

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this,MainActivity.class));
                finish();
            }
        });
    }
}
