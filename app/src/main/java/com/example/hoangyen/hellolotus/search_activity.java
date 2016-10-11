package com.example.hoangyen.hellolotus;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HoangYen on 12/31/2015.
 */
public class search_activity extends ListActivity {
    ListView lv;
    ImageButton search;
    TextView txtSearch;
    public static List<String> history = new LinkedList(Arrays.asList(""));
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        overridePendingTransition(R.animator.bottom_to_top, R.animator.bottom_to_top);
        context = this;
        lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(new AdapterListview(this, history));
        txtSearch = (TextView) findViewById(R.id.txtSearch);
        search = (ImageButton) findViewById(R.id.imgSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txtSearch.getText().toString();
                history.add(text);
                txtSearch.setText("");
                lv.setAdapter(null);
                lv.setAdapter(new AdapterListview(search_activity.this, history));
            }
        });
    }
}
