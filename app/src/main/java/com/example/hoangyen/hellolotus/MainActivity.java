package com.example.hoangyen.hellolotus;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView  view_brithday;
    RecyclerView  view_occasions;
    RecyclerView  view_plant;
    RecyclerView  view_flower;



    ItemData itemsBirthday[] = { new ItemData("Vibrant birthday","$123",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$98.21",R.drawable.birthday_image3),
            new ItemData("Vibrant birthday","$11.66",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$27.42",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.birthday_image3)};

    ItemData itemsOccasions[] = { new ItemData("Vibrant birthday","$123",R.drawable.occasions_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.occasions_image3),
            new ItemData("Pink Pop birthday","$98.21",R.drawable.occasions_image1),
            new ItemData("Vibrant birthday","$11.66",R.drawable.occasions_image3),
            new ItemData("Rouse Boutique","$27.42",R.drawable.occasions_image1),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.occasions_image3)};

    ItemData itemsPlants[] = { new ItemData("Vibrant birthday","$123",R.drawable.plant_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.plants_image2),
            new ItemData("Pink Pop birthday","$98.21",R.drawable.plants_image3),
            new ItemData("Vibrant birthday","$11.66",R.drawable.plant_image1),
            new ItemData("Rouse Boutique","$27.42",R.drawable.plants_image2),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.plants_image3)};

    ItemData itemsFlowers[] = { new ItemData("Vibrant birthday","$123",R.drawable.flower_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.flower_image2),
            new ItemData("Pink Pop birthday","$98.21",R.drawable.flower_image3),
            new ItemData("Vibrant birthday","$11.66",R.drawable.flower_image1),
            new ItemData("Rouse Boutique","$27.42",R.drawable.flower_image2),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.flower_image3)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        overridePendingTransition(R.animator.bottom_to_top, R.animator.bottom_to_top);
        //context=this;
        view_brithday = (RecyclerView) findViewById(R.id.view_birthday);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        view_brithday.setLayoutManager(layoutManager);
        CustomAdapter mAdapter = new CustomAdapter(itemsBirthday);
        view_brithday.setAdapter(mAdapter);
        view_brithday.setItemAnimator(new DefaultItemAnimator());
        ItemClickSupport.addTo(view_brithday).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(MainActivity.this, detail_activity.class);
                overridePendingTransition(R.animator.push_out_left, R.animator.pull_in_right);
                startActivity(i);
            }
        });

        view_occasions = (RecyclerView) findViewById(R.id.view_occasions);
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        view_occasions.setLayoutManager(layoutManager);
        mAdapter = new CustomAdapter(itemsOccasions);
        view_occasions.setAdapter(mAdapter);
        view_occasions.setItemAnimator(new DefaultItemAnimator());

        view_plant = (RecyclerView) findViewById(R.id.view_plant);
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        view_plant.setLayoutManager(layoutManager);
        mAdapter = new CustomAdapter(itemsPlants);
        view_plant.setAdapter(mAdapter);
        view_plant.setItemAnimator(new DefaultItemAnimator());

        view_flower = (RecyclerView) findViewById(R.id.view_flower);
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        view_flower.setLayoutManager(layoutManager);
        mAdapter = new CustomAdapter(itemsFlowers);
        view_flower.setAdapter(mAdapter);
        view_flower.setItemAnimator(new DefaultItemAnimator());

        TextView txtSee = (TextView) findViewById(R.id.txtSeeAll);
//        Button btn = (Button) findViewById(R.id.shop_now);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, menu_activity.class);
//                startActivity(i);
//            }
//        });
        txtSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, View_all_activity.class);
//                overridePendingTransition(R.animator.top_to_bottom, R.animator.top_to_bottom);
                startActivity(i);
            }
        });
    }
}
