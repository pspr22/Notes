package com.example.notes;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NoteHolder>{

    private List<Note>  notes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_design,parent,false);
        return new NoteHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {

        Note currentNote = notes.get(position);
        int color_code = getRandomColor();
        holder.txtTitle.setText(currentNote.getTitle());
        holder.txtDescription.setText(currentNote.getDescription());


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){

        this.notes = notes;
        notifyDataSetChanged();
    }

    private int getRandomColor(){

        List<Integer> colorCode = new ArrayList<>();

        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);
        colorCode.add(R.color.color6);

        Random random = new Random();

        int random_color = random.nextInt(colorCode.size());
        return random_color;

    }

    public Note getNotes(int position){
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        TextView txtDescription;
        CardView cardView;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txttitle);
            txtDescription = itemView.findViewById(R.id.txtdescription);
            cardView = itemView.findViewById(R.id.cardNote);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(notes.get(position));
                    }

                }
            });
        }
    }

    public interface OnItemClickListener{

        void onItemClick(Note note);

    }

    public void setOnItemClickListener(OnItemClickListener listener){

        this.listener = listener;

    }

}

