package com.example.a7125;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.SortedList;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText etKey, etValue;
    Button btnAdd, btnClear;
    LinearLayout llList;
    HashMap<String, String> dictionary = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button tapBtn = new Button(MainActivity.this);
        etKey = findViewById(R.id.etKey);
        etValue = findViewById(R.id.etValue);
        Button btnadd = findViewById(R.id.btnAdd);
        Button btnclear = findViewById(R.id.btnClear);
        LinearLayout llList = findViewById(R.id.llList);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dictionary.put(etKey.getText().toString(), etValue.getText().toString());
                Button btn = new Button(MainActivity.this);
                btn.setText(etKey.getText().toString());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, dictionary.get(etKey.getText().toString()), Toast.LENGTH_SHORT).show();
                    }
                });
                llList.addView(btn);
                btnclear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        llList.removeAllViews();
                    }
                });
            }
        });

    }
}