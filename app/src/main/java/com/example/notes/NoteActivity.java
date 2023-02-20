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

public class NoteActivity extends AppCompatActivity {


    EditText etTitle;
    EditText etDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Note");
        setContentView(R.layout.activity_note);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etTitle = findViewById(R.id.etTitle);
        etDescription  = findViewById(R.id.etDescription);
        etTitle.setTextIsSelectable(true);
        etDescription.setTextIsSelectable(true);
        


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
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


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



















