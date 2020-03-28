package edu.temple.lab7_bookshelf_dynamicui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

public class listViewAdapter extends BaseAdapter {

    String[] titles;
    String[] authors;
    Context context;

    public listViewAdapter(Context context, String[] titles, String[] authors) {
        this.context = context;
        this.titles = titles;
        this.authors = authors;

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    static class ViewHolder{
        TextView Roll_No;
        TextView Stu_Name;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        int viewType = this.getItemViewType(position);
//        //StudentModel item = objects.get(position);
//        //  convertView = null;
//        View rootView = convertView;
//        final ViewHolder viewHolder;
//        if (rootView == null) {
//            viewHolder= new ViewHolder();
//            rootView = inflater.inflate(R.layout.you_list_view_row, parent, false);
//
//            viewHolder.Roll_No = (TextView) rootView .findViewById(R.id.rollnoText);
//            viewHolder.Stu_Name = (TextView)rootView .findViewById(R.id.stunameText);
//
//            rootView.setTag(viewHolder);
//
//        }
//        else {
//            viewHolder= (ViewHolder) rootView.getTag();
//        }
//
//
//
//        viewHolder.Roll_No.setText(item.rollno);
//        viewHolder.Stu_Name.setText(item.name);
//
//        return rootview;
        return null;
    }









//        int viewType = this.getItemViewType(position);
//        StudentModel item = objects.get(position);
//        //  convertView = null;
//        View rootView = convertView;
//        final ViewHolder viewHolder;
//        if (rootView == null) {
//            viewHolder= new ViewHolder();
//            rootView = inflater.inflate(R.layout.you_list_view_row,
//                    parent, false);
//
//            viewHolder.Roll_No = (TextView) rootView .findViewById(R.id.rollnoText);
//            viewHolder.Stu_Name = (TextView)rootView .findViewById(R.id.stunameText);
//
//            rootView.setTag(viewHolder);
//
//        }
//        else {
//            viewHolder= (ViewHolder) rootView.getTag();
//        }
//
//
//
//        viewHolder.Roll_No.setText(item.rollno);
//        viewHolder.Stu_Name.setText(item.name);
//
//        return rootview;

//        TwoLineListItem twoLineListItem;
//
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            twoLineListItem = (TwoLineListItem) inflater.inflate(android.R.layout.simple_list_item_2, null);
//        } else {
//            twoLineListItem = (TwoLineListItem) convertView;
//        }
//
//        TextView text1 = twoLineListItem.getText1();
//        TextView text2 = twoLineListItem.getText2();
//
//        text1.setText(persons.get(position).getName());
//        text2.setText("" + persons.get(position).getAge());
//
//        return twoLineListItem;
        //return null;

}
