package com.example.hoangyen.hellolotus;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by HoangYen on 1/4/2016.
 */
public class FragmentBottom extends Fragment {
    LayoutInflater inflater1;
    ViewGroup container1;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bottom,container,false);
        ImageButton home = (ImageButton) view.findViewById(R.id.iconHome);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().overridePendingTransition(R.animator.bottom_to_top, R.animator.bottom_to_top);
                startActivity(intent);
            }
        });
        ImageButton search = (ImageButton) view.findViewById(R.id.iconSearch);
        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), search_activity.class);
                getActivity().overridePendingTransition(R.animator.bottom_to_top, R.animator.bottom_to_top);
                startActivity(intent);

            }
        });
        ImageButton menu = (ImageButton) view.findViewById(R.id.iconMenu);
        menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), menu_activity.class);
                getActivity().overridePendingTransition(R.animator.bottom_to_top, R.animator.bottom_to_top);
                startActivity(intent);
            }
        });
        ImageButton account = (ImageButton) view.findViewById(R.id.iconAccount);
        account.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), account_activity.class);
                getActivity().overridePendingTransition(R.animator.bottom_to_top, R.animator.bottom_to_top);
                startActivity(intent);
            }
        });
        return view;
    }
}
