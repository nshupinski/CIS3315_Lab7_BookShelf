package edu.temple.lab7_bookshelf_dynamicui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements CallBackInterface {

    BookListFragment listFragment = new BookListFragment();
    BookDetailsFragment detailsFragment = new BookDetailsFragment();

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

        Bundle bundle = new Bundle();
        bundle.putSerializable("BookObjects", bookList);
        //bundle.putSerializable("hashedBooks", books);
        listFragment.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        int orientation = getResources().getConfiguration().orientation;

        if ((orientation == Configuration.ORIENTATION_LANDSCAPE) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {

            fm.beginTransaction().add(R.id.landContainerList, listFragment).addToBackStack(null).commit();
            fm.beginTransaction().add(R.id.landContainerDetails, detailsFragment).addToBackStack(null).commit();

        }
        else if ((orientation == Configuration.ORIENTATION_PORTRAIT) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)){

            fm.beginTransaction().add(R.id.mainContainer, listFragment).addToBackStack(null).commit();

        }
        else if ((orientation == Configuration.ORIENTATION_PORTRAIT) && ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {

            fm.beginTransaction().add(R.id.portContainerList_Large, listFragment).addToBackStack(null).commit();
            fm.beginTransaction().add(R.id.portContainerDetails_Large, detailsFragment).addToBackStack(null).commit();

        }
        else {
            fm.beginTransaction().add(R.id.landContainerList_Large, listFragment).addToBackStack(null).commit();
            fm.beginTransaction().add(R.id.landContainerDetails_Large, detailsFragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void onBookSelected(int index) {
        Bundle bundle = new Bundle();
        bundle.putInt("Jeffery", index);
        int orientation = getResources().getConfiguration().orientation;
        if((orientation == Configuration.ORIENTATION_LANDSCAPE) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            BookDetailsFragment frag = new BookDetailsFragment();
            frag.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.landContainerDetails, frag).addToBackStack(null).commit();
        }
        else if ((orientation == Configuration.ORIENTATION_PORTRAIT) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            detailsFragment.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainContainer, detailsFragment).addToBackStack(null).commit();
        }
        else if ((orientation == Configuration.ORIENTATION_LANDSCAPE) && ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            BookDetailsFragment frag = new BookDetailsFragment();
            frag.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.landContainerDetails_Large, frag).addToBackStack(null).commit();
        }
        else {
            BookDetailsFragment frag = new BookDetailsFragment();
            frag.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.portContainerDetails_Large, frag).addToBackStack(null).commit();
        }
    }
}

