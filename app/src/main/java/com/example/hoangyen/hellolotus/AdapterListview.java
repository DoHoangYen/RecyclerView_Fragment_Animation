package com.example.hoangyen.hellolotus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HoangYen on 12/31/2015.
 */
public class AdapterListview extends BaseAdapter {
    List<String> history;
    Context context;
    private static LayoutInflater inflater=null;
    public AdapterListview(search_activity mainActivity, List<String> Search) {
        // TODO Auto-generated constructor stub
        history = Search;
        context = mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return history.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_item_search, parent,false);
        holder.tv=(TextView) rowView.findViewById(R.id.txt1);

        holder.tv.setText(history.get(position));
        return rowView;
    }
}
