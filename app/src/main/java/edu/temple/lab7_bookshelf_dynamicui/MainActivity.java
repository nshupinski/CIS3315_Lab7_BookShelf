package edu.temple.lab7_bookshelf_dynamicui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    BookDetailsFragment detailsFragment;
    BookListFragment listFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] authors = res.getStringArray(R.array.authors);
        ArrayList<HashMap> books = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
        for(int i = 0; i < titles.length; i++) {
            HashMap newBook = new HashMap();
            newBook.put("title", titles[i]);
            newBook.put("author", authors[i]);
            books.add(newBook);

            Book newBookObj = new Book();
            newBookObj.title = titles[i];
            newBookObj.author = authors[i];
            bookList.add(newBookObj);
        }


        BookListFragment listFragment = new BookListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("BookObjects", bookList);
        //bundle.putSerializable("hashedBooks", books);
        listFragment.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.mainContainer, listFragment).addToBackStack(null).commit();


//        listFragment.setOnBookSelectedListener(new OnBookelectedListener() {
//            @Override
//            public void onselected(int index) {
//
//            }
//        }
    }
}
