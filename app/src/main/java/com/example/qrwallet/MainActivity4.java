package com.example.qrwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.qrwallet.databinding.ActivityMain4Binding;
import com.example.qrwallet.databinding.ActivityMainBinding;

public class MainActivity4 extends AppCompatActivity {

    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void wifi(View view){
        Intent intent = new Intent(MainActivity4.this,MainActivity2.class);
        startActivity(intent);
    }
    public void url(View view){
        Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
        startActivity(intent);
    }

}