package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {


    EditText etTitle;
    EditText etDescription;
    Button save,cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Note");
        setContentView(R.layout.activity_note);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etTitle = findViewById(R.id.etTitle);
        etDescription  = findViewById(R.id.etDescription);
        save = findViewById(R.id.btnsave);
        cancel = findViewById(R.id.btncancel);
        
        
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(NoteActivity.this, "Nothing Saved", Toast.LENGTH_SHORT).show();
                finish();
                
            }
        });
        
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveNote();
            }
        });

    }

    public void saveNote(){

        String noteTitle = etTitle.getText().toString();
        String noteDescription = etDescription.getText().toString();

        Intent i = new Intent();
        i.putExtra("noteTitle",noteTitle);
        i.putExtra("noteDescription",noteDescription);
        setResult(RESULT_OK,i);
        finish();


    }


}



















