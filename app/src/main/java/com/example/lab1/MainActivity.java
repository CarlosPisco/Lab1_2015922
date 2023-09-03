package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import com.example.lab1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);


        binding.button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("start",true);
            startActivity(intent);
        });


        //registerForContextMenu((TextView) findViewById(R.id.textView2));

        textView = findViewById(R.id.textView2);
        registerForContextMenu(textView);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_colors, menu);
    }




    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menu_red) {
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            return true;
        } else if (item.getItemId() == R.id.menu_blue) {
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
            return true;
        } else if (item.getItemId() == R.id.menu_green) {
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
            return true;
        }else{
            return super.onContextItemSelected(item);
        }



    }


}