package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditNoteActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etDescription;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        getSupportActionBar().setTitle("Edit Note");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etTitle = findViewById(R.id.etTitleu);
        etDescription  = findViewById(R.id.etDescriptionu);
        etTitle.setTextIsSelectable(true);
        etDescription.setTextIsSelectable(true);


        getData();




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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.tick,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.tick:
                UpdateNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
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












