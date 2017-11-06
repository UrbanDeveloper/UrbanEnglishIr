package com.example.ashamsa.UrbanEnglishIr;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by ashamsa on 10/21/2017.
 */

public class Level2_fragment_caller extends SingleFragmentActivity {
    private static final String EXTRA_ITEM_SELECTED_POSITION_IN_LEVEL1 = "com.example.ashamsa.recyclerviewtemplate ";
    @Override
    protected Fragment CreateFragment() {
        int Selected_position_in_level1 = (int) getIntent().getSerializableExtra(EXTRA_ITEM_SELECTED_POSITION_IN_LEVEL1);
        return Level2_recycler.newInstance(Selected_position_in_level1);
    }

    public static Intent newIntent(Context packageContext, int position) {
        Intent intent4Level2_recycler_fragment = new Intent(packageContext, Level2_fragment_caller.class);
        intent4Level2_recycler_fragment.putExtra(EXTRA_ITEM_SELECTED_POSITION_IN_LEVEL1, position);
        return intent4Level2_recycler_fragment;
    }


}
