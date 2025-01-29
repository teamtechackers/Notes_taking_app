package com.example.notes_taking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddItem extends AppCompatActivity {
    EditText edt_titel, edt_about, edt_date;
   // public static final int a = 1;
    String a= String.valueOf(1);
    AppCompatButton save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        edt_titel = findViewById(R.id.edttitel);
        edt_about = findViewById(R.id.edt_about);
        edt_date = findViewById(R.id.edt_date);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titel = edt_titel.getText().toString();
                String about = edt_about.getText().toString();
                String date = edt_date.getText().toString();

                Intent intent = new Intent(AddItem.this, MainActivity.class);

                if (!titel.isEmpty() && !about.isEmpty() && !date.isEmpty()) {
                    intent.putExtra("titel", titel);
                    intent.putExtra("about", about);
                    intent.putExtra("date", date);
                    intent.putExtra("a",a);
                    startActivity(intent);
                } else {
                    Toast.makeText(AddItem.this, "Pleas Fill All Fileds", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}