package com.example.hoangyen.hellolotus;

/**
 * Created by HoangYen on 12/29/2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterGridview extends BaseAdapter {

    Context context;
    private ItemData[] itemsDatas;
    int length_of_data;

    private static LayoutInflater inflater=null;
    public AdapterGridview(View_all_activity viewActivity, ItemData[] itemsData, int length_data) {
        // TODO Auto-generated constructor stub
        itemsDatas=itemsData;
        context=viewActivity;
        length_of_data = length_data;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return length_of_data;
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
        TextView tvName;
        TextView tvPrice;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.gridview_item, parent,false);
        holder.tvName=(TextView) rowView.findViewById(R.id.txtName);
        holder.tvPrice=(TextView) rowView.findViewById(R.id.txtPrice);
        holder.img=(ImageView) rowView.findViewById(R.id.img);

        holder.tvName.setText(itemsDatas[position].getName());
        holder.tvPrice.setText(itemsDatas[position].getPrice());
        holder.img.setImageResource(itemsDatas[position].getImageUrl());
        return rowView;
    }
}
