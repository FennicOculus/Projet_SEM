package com.example.projetsem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.projetsem.ui.login.LoginActivity;

public class MainMenuActivity extends AppCompatActivity {
    private Button Facultybtn;
    private Button Discoverybtn;
    private Button Sallesbtn;
    private Button Amphibtn;
    private Button buvettebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Facultybtn = findViewById(R.id.FacultyBtn);
        Facultybtn.setBackgroundColor(Color.TRANSPARENT);
        Discoverybtn = findViewById(R.id.DiscoveryBtn);
        Discoverybtn.setBackgroundColor(Color.TRANSPARENT);
        Sallesbtn = findViewById(R.id.SallesBtn);
        Sallesbtn.setBackgroundColor(Color.TRANSPARENT);
        Amphibtn = findViewById(R.id.AmphiBtn);
        Amphibtn.setBackgroundColor(Color.TRANSPARENT);
        buvettebtn = findViewById(R.id.BuvetteBtn);
        buvettebtn.setBackgroundColor(Color.TRANSPARENT);

        Amphibtn.setOnClickListener(v -> {
            String value = "Amphi";
            startActivity(new Intent(MainMenuActivity.this, ChooseYourPlace.class).putExtra("key", value));
        });

        Sallesbtn.setOnClickListener(v -> {
            String value = "Salles";;
            startActivity(new Intent(MainMenuActivity.this, ChooseYourPlace.class).putExtra("key", value));
        });

        Facultybtn.setOnClickListener(v -> {
            String value = "Faculty";
            startActivity(new Intent(MainMenuActivity.this, ChooseYourPlace.class).putExtra("key", value));
        });

        buvettebtn.setOnClickListener(v -> {
            String value = "Buvettes";
            startActivity(new Intent(MainMenuActivity.this, ChooseYourPlace.class).putExtra("key", value));
        });

        Discoverybtn.setOnClickListener(v -> {
            String value = "Discovery";
            startActivity(new Intent(MainMenuActivity.this, ChooseYourPlace.class).putExtra("key", value));
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}

