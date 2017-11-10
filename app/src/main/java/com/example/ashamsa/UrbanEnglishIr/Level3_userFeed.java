package com.example.ashamsa.UrbanEnglishIr;

import android.app.FragmentBreadCrumbs;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toast;


import com.example.ashamsa.recyclerviewtemplate.R;

import java.util.UUID;

/**
 * Created by AShamsa on 10/30/2017.
 */

public class Level3_userFeed extends Fragment implements FragmentManager.OnBackStackChangedListener {
    //int usercatposition = 3;
    // TODO: 10/31/2017 back icon should be created
    SinglePost tempPost = new Data.UserFeed();
    private static final String ARG_SINGLEPOST_ID = "singlepost_id ";
    FragmentManager m_fragmentManager;
    Fragment thisFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.level3_userinput_xml, container, false);
        EditText edittext_title = v.findViewById(R.id.EditText_level3_User_Input_Title);
        EditText edittext_description = v.findViewById(R.id.EditText_level3_User_Input_Description);
        FloatingActionButton fab = v.findViewById(R.id.fab);




// TODO: 10/31/2017 should validate enteries, if not valid, the created object should be deleted 
        // TODO: 10/31/2017 should be a check icon to post the new entery+ a toast 
        //should give the user an option to edit the entery or remove it altogether
        edittext_title.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tempPost.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edittext_description.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tempPost.setDescription(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataLab.get(getActivity()).addnewUserFeed((Data.UserFeed) tempPost);
                int messageResId = 0;
                messageResId = R.string.newpostconfirm_toast;
                Toast.makeText(getActivity(), messageResId, Toast.LENGTH_SHORT).show();
                Intent intent = Level2_fragment_caller.newIntent(getActivity(), 3);


                startActivity(intent);
            }
        });

        return v;
    }



    public static Level3_userFeed newInstance(UUID singlepostId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SINGLEPOST_ID, singlepostId);
        Level3_userFeed fragment = new Level3_userFeed();

        fragment.setArguments(args);


        return fragment;
    }


    @Override
    public void onBackStackChanged() {

        int fmcount = m_fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < fmcount; i++) {
            Log.d("stacknumber", m_fragmentManager.getBackStackEntryAt(i).toString());

        }
    }
}



