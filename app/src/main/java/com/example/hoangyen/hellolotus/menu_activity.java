package com.example.hoangyen.hellolotus;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by HoangYen on 12/30/2015.
 */
public class menu_activity extends FragmentActivity {
    ImageButton img1;
    LinearLayout layout1;
    RecyclerView view_brithday;
    RelativeLayout rela1;
    TextView txt;

    View view;
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    ItemData itemsBirthday[] = {new ItemData("Vibrant birthday", "$123", R.drawable.birthday_image1),
            new ItemData("Rouse Boutique", "$23.45", R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday", "$98.21", R.drawable.birthday_image3),
            new ItemData("Vibrant birthday", "$11.66", R.drawable.birthday_image1),
            new ItemData("Rouse Boutique", "$27.42", R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday", "$23.01", R.drawable.birthday_image3)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        overridePendingTransition(R.animator.bottom_to_top, R.animator.bottom_to_top);

        Fragment FragmentBottom = new FragmentBottom();
        fragmentTransaction.add(R.id.framelayout, FragmentBottom);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        view_brithday = (RecyclerView) findViewById(R.id.view_birthday);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        view_brithday.setLayoutManager(layoutManager);
        CustomAdapter mAdapter = new CustomAdapter(itemsBirthday);
        view_brithday.setAdapter(mAdapter);
        view_brithday.setItemAnimator(new DefaultItemAnimator());
        ItemClickSupport.addTo(view_brithday).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(menu_activity.this, detail_activity.class);
                startActivity(i);
            }
        });

        img1 = (ImageButton) findViewById(R.id.img1);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        rela1 = (RelativeLayout) findViewById(R.id.rela1);
        txt = (TextView) findViewById(R.id.txtProduct);

        rela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout1.getVisibility() == View.GONE)
                {
                    img1.setRotation(180);
                    layout1.setVisibility(View.VISIBLE);

                }
                else
                {
                    img1.setRotation(0);
                    layout1.setVisibility(View.GONE);
                }
            }
        });

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menu_activity.this, search_activity.class);
                startActivity(i);
            }
        });
    }

}
