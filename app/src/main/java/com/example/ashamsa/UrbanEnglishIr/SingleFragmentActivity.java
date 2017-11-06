package com.example.ashamsa.UrbanEnglishIr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.ashamsa.recyclerviewtemplate.R;

/**
 * Created by AShamsa on 10/20/2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment CreateFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_host);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_hostID);
        if (fragment == null) {
            fragment = CreateFragment();
            fm.beginTransaction().add(R.id.fragment_hostID, fragment).commit();
        }

    }
}
