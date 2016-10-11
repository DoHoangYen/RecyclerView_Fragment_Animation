package com.example.hoangyen.hellolotus;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by HoangYen on 12/31/2015.
 */
public class account_activity extends MainActivity {
    Button sign ;
    View view;
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_activity);

        Fragment FragmentBottom = new FragmentBottom();
        fragmentTransaction.add(R.id.framelayout, FragmentBottom);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        sign = (Button) findViewById(R.id.btnSignIn);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(account_activity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
