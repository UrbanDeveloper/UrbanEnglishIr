package com.example.ashamsa.UrbanEnglishIr;

import android.os.Bundle;
import android.provider.FontsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ashamsa.recyclerviewtemplate.R;

/**
 * Created by AShamsa on 10/20/2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment CreateFragment();

    private FragmentManager F_man;




    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_host);

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_hostID);

        if (fragment == null) {
            fragment = CreateFragment();
            FragmentTransaction trans = fm.beginTransaction();
            trans.add(R.id.fragment_hostID, fragment);
            //trans.addToBackStack("a");
            //int count = fm.getBackStackEntryCount();
            trans.commit();

            //fm.beginTransaction().add(R.id.fragment_hostID, fragment).addToBackStack("a").commit();
        }

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
/*        int count = F_man.getBackStackEntryCount();
        Log.d("test", "testmi");
        for (int i = 0; i < count; i++) {

            Log.d("backnum", F_man.getBackStackEntryAt(i).getName());
        }*/
    }
}
