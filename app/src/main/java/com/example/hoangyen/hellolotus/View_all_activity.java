package com.example.hoangyen.hellolotus;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HoangYen on 12/29/2015.
 */
public class View_all_activity extends MainActivity {
    GridView grd ;
    Button btnShowMore;
    TextView txtNotify;
    ItemData itemsBirthday[] = { new ItemData("Vibrant birthday","$123",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$98.21",R.drawable.birthday_image3),
            new ItemData("Vibrant birthday","$11.66",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$27.42",R.drawable.birthday_image2),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.birthday_image3),
            new ItemData("Vibrant birthday","$11.66",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$27.42",R.drawable.birthday_image1),
            new ItemData("Pink Pop birthday","$23.01",R.drawable.birthday_image1),
            new ItemData("Rouse Boutique","$23.45",R.drawable.birthday_image2),
            new ItemData("Rouse Boutique","$23.45",R.drawable.birthday_image2),
            new ItemData("Rouse Boutique","$23.45",R.drawable.birthday_image2),
    };
    ItemData temp[];
    int length_of_data = 0;
    int length = itemsBirthday.length;
    int height = 620;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_activity);
        overridePendingTransition(R.animator.pull_in_right, R.animator.push_out_left);
        ImageView img = (ImageView) findViewById(R.id.imgBack);
        img.setRotation(90);
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

        if( length >= 6)
        {
            length_of_data = 6;
        }
        else
        {
            length_of_data = length;
        }
        grd=(GridView) findViewById(R.id.grd_view);
        grd.setAdapter(new AdapterGridview(this, itemsBirthday,length_of_data));
        txtNotify = (TextView) findViewById(R.id.txtNotify);
        btnShowMore = (Button) findViewById(R.id.btnShowMore);
        btnShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( length >= 6)
                {
                    grd.setAdapter(null);
                    int lengh1 = length - length_of_data;
                    if( lengh1 >= 6)
                    {
                        length_of_data+= 6;
                        grd.setAdapter(new AdapterGridview(View_all_activity.this, itemsBirthday,length_of_data));
                        grd.setMinimumHeight(height + 620);
                    }
                    else
                    {
                        length_of_data+=lengh1;
                        grd.setAdapter(new AdapterGridview(View_all_activity.this, itemsBirthday,length_of_data));
                        //Log.d("lelef", String.valueOf(length_of_data));
                        grd.setMinimumHeight(height + 100);
                    }
                }
                else
                {
                    txtNotify.setVisibility(View.VISIBLE);
                    btnShowMore.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.pull_in_left, R.animator.push_out_right);
    }
}
