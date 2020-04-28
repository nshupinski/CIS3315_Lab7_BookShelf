package edu.temple.lab7_bookshelf_dynamicui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//  *********************************
    TextView txtBookName;
    TextView txtAuthor;
    ImageView image;
    String title;
    String author;
    String imageLink;
    ImageButton btnPlay;
    int bookIndex;

    private PlayInterface play;
//  *********************************

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PlayInterface) {
            play = (PlayInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CallBackInterface");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        play = null;
    }

    public BookDetailsFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookDetailsFragment newInstance(String param1, String param2) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book_details, container, false);

        txtBookName = v.findViewById(R.id.txtBookName);
        txtAuthor = v.findViewById(R.id.txtAuthor);
        image = v.findViewById(R.id.imageViewCover);
        btnPlay = v.findViewById(R.id.btnPlay);

        updatePage();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.playButtonClicked(bookIndex);
            }
        });

        return v;
    }

    public void onBookSelected(Book book, int index) {
        title = book.title;
        author = book.author;
        imageLink = book.coverURL;
        bookIndex = index;
        //updatePage();
    }

    public void updatePage() {
        txtBookName.setText(title);
        txtAuthor.setText(author);
        Picasso.get().load(imageLink).into(image);
    }
}
