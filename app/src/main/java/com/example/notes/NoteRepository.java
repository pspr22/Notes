package com.example.notes;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> notes;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public NoteRepository(Application application){

        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);

        noteDao = noteDatabase.noteDao();

        notes = noteDao.getAllNotes();


    }

    public void insert(Note note){

        //new InsertNoteAsyncTask(noteDao).execute(note);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insert(note);
            }
        });

    }

    public void Update(Note note){

        //new UpdateNoteAsyncTask(noteDao).execute(note);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.Update(note);
            }
        });

    }

    public void delete(Note note){

        //new DeleteNoteAssyncTassk(noteDao).execute(note);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.delete(note);
            }
        });

    }

    public LiveData<List<Note>> getAllNotes(){

        return notes;
    }

/*
    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{


        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.insert(notes[0]);

            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void>{


        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.Update(notes[0]);

            return null;
        }
    }

    private static class DeleteNoteAssyncTassk extends AsyncTask<Note,Void,Void>{

        private NoteDao noteDao;

        private DeleteNoteAssyncTassk(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.delete(notes[0]);
            return null;
        }
    }
*/

}
