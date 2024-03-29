package edu.temple.lab7_bookshelf_dynamicui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookDetailsFragment extends Fragment implements CallBackInterface {
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
//  *********************************

    //private OnFragmentInteractionListener mListener;

    public BookDetailsFragment() {
        // Required empty public constructor
    }

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

        // get resources
        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] authors = res.getStringArray(R.array.authors);

        // retrieve bundle
        int index;
        Bundle bundle = getArguments();
        if(bundle != null) {
            index = bundle.getInt("Jeffery");
            txtBookName.setText(titles[index]);
            txtAuthor.setText(authors[index]);
        }

        return v;
    }


    @Override
    public void onBookSelected(int index) {
        Resources res = getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] authors = res.getStringArray(R.array.authors);
        //Bundle bundle = getArguments();
        //if(bundle != null) {
            //index = bundle.getInt("Jeffery");
            txtBookName.setText(titles[index]);
            txtAuthor.setText(authors[index]);
        //}
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
