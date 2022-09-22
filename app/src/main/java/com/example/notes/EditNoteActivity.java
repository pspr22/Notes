package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditNoteActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etDescription;
    Button save,cancel;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        getSupportActionBar().setTitle("Edit Note");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etTitle = findViewById(R.id.etTitleu);
        etDescription  = findViewById(R.id.etDescriptionu);
        save = findViewById(R.id.btnsaveu);
        cancel = findViewById(R.id.btncancelu);

        getData();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(EditNoteActivity.this, "Nothing Changed", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UpdateNote();
            }
        });

    }

    private void UpdateNote(){


        String titleLast = etTitle.getText().toString();
        String descriptionLast = etDescription.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("titleLast",titleLast);
        intent.putExtra("descriptionLast",descriptionLast);

        if(noteId != -1){

            intent.putExtra("noteId",noteId);
            setResult(RESULT_OK,intent);
            finish();
        }

    }

    public void getData(){

        Intent i = getIntent();
        String noteTitle = i.getStringExtra("title");
        String noteDescription = i.getStringExtra("description");
        noteId = i.getIntExtra("id",-1);

        etTitle.setText(noteTitle);
        etDescription.setText(noteDescription);



    }

}












