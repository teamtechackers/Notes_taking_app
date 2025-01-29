package com.example.notes_taking_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerRowAdapter extends RecyclerView.Adapter<RecyclerRowAdapter.ViewHolder> {
    Context context;

    public RecyclerRowAdapter(Context context, ArrayList<Row_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Row_Model> arrayList;




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Row_Model dataPosition = arrayList.get(position);
        holder.titel.setText(arrayList.get(position).titel);
        holder.about.setText(arrayList.get(position).about);
        holder.date.setText(arrayList.get(position).date);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(position);
                notifyItemRemoved(position);
            }
        });
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Update_Activity.class);
                intent.putExtra("titel",dataPosition.titel);
                intent.putExtra("about",dataPosition.about);
                intent.putExtra("date",dataPosition.date);
                intent.putExtra("position",position);
                if (context instanceof MainActivity) {
                    ((MainActivity) context).startActivityForResult(intent,1);
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        ImageView delete;
        TextView titel;
        TextView about;
        CardView item;
        TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            delete = itemView.findViewById(R.id.delete);
            about = itemView.findViewById(R.id.about);
            titel = itemView.findViewById(R.id.titl);
            date = itemView.findViewById(R.id.date);
            item = itemView.findViewById(R.id.item);

        }
    }
}
