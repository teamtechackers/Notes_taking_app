package com.example.notes_taking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Update_Activity extends AppCompatActivity {
    EditText edt_titel,edt_date,edt_about;
    AppCompatButton update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edt_about = findViewById(R.id.edt_about1);
        edt_titel = findViewById(R.id.edttitel1);
        edt_date = findViewById(R.id.edt_date1);
        update = findViewById(R.id.update);

        int position = getIntent().getIntExtra("position", -1);
        String titel = getIntent().getStringExtra("titel");
        String about = getIntent().getStringExtra("about");
        String date = getIntent().getStringExtra("date");

        edt_titel.setText(titel);
        edt_about.setText(about);
        edt_date.setText(date);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Update_Activity.this, MainActivity.class);
                String update_titel = edt_titel.getText().toString();
                String update_about = edt_about.getText().toString();
                String updat_date = edt_date.getText().toString();

                intent.putExtra("updated_titel",update_titel);
                intent.putExtra("updated_about",update_about);
                intent.putExtra("updated_date",updat_date);
                intent.putExtra("position",position);
                startActivity(intent);


            }
        });


    }
}