package edu.temple.lab7_bookshelf_dynamicui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CallBackInterface {

    BookListFragment listFragment = new BookListFragment();
    BookDetailsFragment detailsFragment = new BookDetailsFragment();
    RequestQueue requestQueue;
    EditText editSearch;
    ArrayList<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);
        editSearch = findViewById(R.id.editTextSearch);

        // Set orientation on startup
        FragmentManager fm = getSupportFragmentManager();
        int orientation = getResources().getConfiguration().orientation;

        // Small Landscape
        if ((orientation == Configuration.ORIENTATION_LANDSCAPE) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {

            fm.beginTransaction().add(R.id.landContainerList, listFragment).addToBackStack(null).commit();
            fm.beginTransaction().add(R.id.landContainerDetails, detailsFragment).addToBackStack(null).commit();

        }
        // Small Portrait
        else if ((orientation == Configuration.ORIENTATION_PORTRAIT) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)){

            fm.beginTransaction().add(R.id.mainContainer, listFragment).addToBackStack(null).commit();

        }
        // Large Portrait
        else if ((orientation == Configuration.ORIENTATION_PORTRAIT) && ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {

            fm.beginTransaction().add(R.id.portContainerList_Large, listFragment).addToBackStack(null).commit();
            fm.beginTransaction().add(R.id.portContainerDetails_Large, detailsFragment).addToBackStack(null).commit();

        }
        // Large Landscape
        else {
            fm.beginTransaction().add(R.id.landContainerList_Large, listFragment).addToBackStack(null).commit();
            fm.beginTransaction().add(R.id.landContainerDetails_Large, detailsFragment).addToBackStack(null).commit();
        }

        // Click even to search for books
        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://kamorris.com/lab/abp/booksearch.php?search=" + editSearch.getText();
                JsonArrayRequest jsonRequest = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                try {

                                    bookList = new ArrayList<>();
                                    for(int i = 0; i < response.length(); i++) {
                                        Book newBookObj = new Book();
                                        newBookObj.title = response.getJSONObject(i).getString("title");
                                        newBookObj.author = response.getJSONObject(i).getString("author");
                                        newBookObj.coverURL = response.getJSONObject(i).getString("cover_url");
                                        bookList.add(newBookObj);
                                    }

                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("BookObjects", bookList);
                                    listFragment.setArguments(bundle);
                                    listFragment.refresh();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });
                requestQueue.add(jsonRequest);
            }
        });
    }

    @Override
    public void onBookSelected(int index) {
        Book book = bookList.get(index);
        detailsFragment.onBookSelected(book);
        int orientation = getResources().getConfiguration().orientation;
        // Landscape small
        if((orientation == Configuration.ORIENTATION_LANDSCAPE) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            detailsFragment.onBookSelected(book);
        }
        // Portrait small
        else if ((orientation == Configuration.ORIENTATION_PORTRAIT) && !((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainContainer, detailsFragment).addToBackStack(null).commit();
        }
        // Landscape Large
        else if ((orientation == Configuration.ORIENTATION_LANDSCAPE) && ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            BookDetailsFragment frag = new BookDetailsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.landContainerDetails_Large, frag).addToBackStack(null).commit();
        }
        // Portrait Large
        else {
            BookDetailsFragment frag = new BookDetailsFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.portContainerDetails_Large, frag).addToBackStack(null).commit();
        }
    }
}

