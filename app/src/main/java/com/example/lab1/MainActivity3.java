package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab1.databinding.ActivityMain2Binding;
import com.example.lab1.databinding.ActivityMain3Binding;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> registroRecibido = getIntent().getStringArrayListExtra("registro");

        LinearLayout linearLayout = (LinearLayout) binding.scroll.getChildAt(0);

        for(String elemento : registroRecibido){
            TextView textView = new TextView(this);
            String seteo = "Juego "+(registroRecibido.indexOf(elemento)+1)+ " "+elemento;
            textView.setText(seteo);
            linearLayout.addView(textView);
        }


        binding.button2.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("newgame",true);
            setResult(RESULT_OK,intent);
            finish();
        });


    }



}