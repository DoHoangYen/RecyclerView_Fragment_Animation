package com.example.hoangyen.hellolotus;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HoangYen on 12/29/2015.
 */
public class detail_activity extends MainActivity {
    RecyclerView view_brithday;
    RadioGroup radioGroup;
    RadioButton rd1;
    RadioButton rd2;
    RadioButton rd3;

    ItemData itemsBirthday[] = { new ItemData("Vibrant birthday","$123",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$98.21",R.drawable.birthday_image3),
            new ItemData("Vibrant birthday","$11.66",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$27.42",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.birthday_image3)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        //overridePendingTransition(R.animator.top_to_bottom, R.animator.top_to_bottom);
        rd1 = (RadioButton) findViewById(R.id.rdio_large);
        rd2 = (RadioButton) findViewById(R.id.rdio_medium);
        rd3 = (RadioButton) findViewById(R.id.rdio_small);

        ImageView img = (ImageView) findViewById(R.id.imgBack);
        //img.setRotation(90);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        TextView txtBack = (TextView) findViewById(R.id.txtBack);

        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //context=this;
        view_brithday = (RecyclerView) findViewById(R.id.view_item);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        view_brithday.setLayoutManager(layoutManager);
        CustomAdapter mAdapter = new CustomAdapter(itemsBirthday);
        view_brithday.setAdapter(mAdapter);
        view_brithday.setItemAnimator(new DefaultItemAnimator());
    }
    public void onRadioButtonClickedLarge (View view) {

            rd1.setChecked(true);
            rd2.setChecked(false);
            rd3.setChecked(false);
            Toast.makeText(getApplicationContext(), "choice: Large",
                    Toast.LENGTH_SHORT).show();


    }
    public void onRadioButtonClickedMedium (View view) {

            rd2.setChecked(true);
            rd1.setChecked(false);
            rd3.setChecked(false);
            Toast.makeText(getApplicationContext(), "choice: Medium",
                    Toast.LENGTH_SHORT).show();


    }
    public void onRadioButtonClickedSmall (View view) {

            rd3.setChecked(true);
            rd1.setChecked(false);
            rd2.setChecked(false);
            Toast.makeText(getApplicationContext(), "choice: Medium",
                    Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.pull_in_left, R.animator.push_out_right);
    }
}
