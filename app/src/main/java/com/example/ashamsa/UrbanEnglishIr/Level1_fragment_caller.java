package com.example.ashamsa.UrbanEnglishIr;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by AShamsa on 10/20/2017.
 */

public class Level1_fragment_caller extends SingleFragmentActivity {
    @Override
    protected Fragment CreateFragment() {
        return new Level1();
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent4Level1 = new Intent(packageContext, Level1_fragment_caller.class);

        return intent4Level1;
    }
}
