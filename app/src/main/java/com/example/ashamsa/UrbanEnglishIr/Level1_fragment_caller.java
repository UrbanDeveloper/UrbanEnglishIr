package com.example.ashamsa.UrbanEnglishIr;

import android.support.v4.app.Fragment;

/**
 * Created by AShamsa on 10/20/2017.
 */

public class Level1_fragment_caller extends SingleFragmentActivity {
    @Override
    protected Fragment CreateFragment() {
        return new Level1();
    }
}
