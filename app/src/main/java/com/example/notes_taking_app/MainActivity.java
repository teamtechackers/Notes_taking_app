package com.example.notes_taking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addbtn;
    public static final int c = 1;
    String a = String.valueOf(1);
    RecyclerRowAdapter adapter;
    TextView allnotes;
    static ArrayList<Row_Model> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        addbtn = findViewById(R.id.addbtn);
        allnotes=findViewById(R.id.allnotes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerRowAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, add_item.class);
               startActivity(intent);
            }
        });
        String b = getIntent().getStringExtra("a");
        allnotes.setText(b);
        // ADD FUNCTIONALITY CODE
        //if (b==a) {
            String titel = getIntent().getStringExtra("titel");
            String about = getIntent().getStringExtra("about");
            String date = getIntent().getStringExtra("date");
            Row_Model rowModel1 = new Row_Model(titel, about, date);
            arrayList.add(rowModel1);
            adapter.notifyItemInserted(arrayList.size() - 1);
         // UPDATE FUNCTIONALITY CODE
            String updated_titel = getIntent().getStringExtra("updated_titel");
            String updated_about = getIntent().getStringExtra("updated_about");
            String updated_date = getIntent().getStringExtra("updated_date");
            int position = getIntent().getIntExtra("position",-1);
            if (position != -1 && position < arrayList.size()) {
                Row_Model updated_items = arrayList.get(position);
                updated_items.titel=updated_titel;
                updated_items.about = updated_about;
                updated_items.date = updated_date;
                adapter.notifyItemChanged(position);

            }

    }
    }