package edu.temple.lab7_bookshelf_dynamicui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;
import java.util.HashMap;

public class listViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Book> bookList;

    public listViewAdapter(Context context, ArrayList<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        if (bookList != null) {
            return bookList.size();
        }
        else {return 0;}
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView titleTextView, authorTextView;
        if (!(convertView instanceof LinearLayout)) {
            /*
            Inflate a predefined layout file that includes 2 text views.
            We could do this in code, but this seems a little easier
             */
            convertView = LayoutInflater.from(context).inflate(R.layout.books_adapter_layout, parent, false);
        }
            titleTextView = convertView.findViewById(R.id.titleTextView);
            authorTextView = convertView.findViewById(R.id.authorTextView);

            titleTextView.setText(bookList.get(position).getName());
            authorTextView.setText(bookList.get(position).getAuthor());

        return convertView;
    }
}
