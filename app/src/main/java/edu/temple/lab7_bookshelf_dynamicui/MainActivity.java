package edu.temple.lab7_bookshelf_dynamicui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] authors = res.getStringArray(R.array.authors);
        ArrayList books = new ArrayList<>();
        for(int i = 0; i < titles.length; i++) {
            HashMap newBook = new HashMap();
            newBook.put("title", titles[i]);
            newBook.put("author", authors[i]);
            books.add(newBook);
        }
    }
}
