package com.example.ashamsa.UrbanEnglishIr;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by AShamsa on 10/30/2017.
 */

public class Level3_userFeed_fragment_caller extends SingleFragmentActivity {
    protected Fragment CreateFragment() {
        return new Level3_userFeed();
    }
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, Level3_userFeed_fragment_caller.class);
        return intent;
    }
}
