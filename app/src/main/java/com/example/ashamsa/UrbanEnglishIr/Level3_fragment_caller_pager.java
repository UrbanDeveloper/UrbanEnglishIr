package com.example.ashamsa.UrbanEnglishIr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ashamsa.recyclerviewtemplate.R;

import java.util.List;
import java.util.UUID;

/**
 * Created by ashamsa on 10/23/2017.
 */

public class Level3_fragment_caller_pager extends AppCompatActivity {
    private static final String EXTRA_SINGLEPOST_ID = "com.example.ashamsa.recyclerviewtemplate";
    private ViewPager m_viewPager;
    private List<SinglePost> m_singlePosts;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_3_pager_host_xml);
        UUID singlepostid = (UUID) getIntent().getSerializableExtra(EXTRA_SINGLEPOST_ID);
        m_viewPager = (ViewPager) findViewById(R.id.level3_pager_host);
        m_singlePosts = DataLab.get(this).getSinglePosts(singlepostid);
        FragmentManager fragmentManager = getSupportFragmentManager();
        m_viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            //// TODO: 10/31/2017 : this calls the fragment with one befor and after so the view count get troublesome
            // the following helps but if we finger scroll it fails for new views, since it is not dispa
            // this is because, this will be run for few items around the selected
            boolean runonce = true;

            @Override
            public Fragment getItem(int position) {
                SinglePost singlePost = m_singlePosts.get(position);
                if (runonce) {
                    runonce = false;
                    int ViewNum = singlePost.getViewNum();
                    singlePost.setViewNum(ViewNum + 1);
                }

                return Level3.newInstance(singlePost.getId());

            }

            @Override
            public int getCount() {
                return m_singlePosts.size();
            }


        });


        for (int i = 0; i < m_singlePosts.size(); i++) {
            if (m_singlePosts.get(i).getId().equals(singlepostid)) {
                m_viewPager.setCurrentItem((i));
                break;
            }
        }
    }

    public static Intent newIntent(Context packageContext, UUID singlepostID) {
        Intent intent = new Intent(packageContext, Level3_fragment_caller_pager.class);
        intent.putExtra(EXTRA_SINGLEPOST_ID, singlepostID);
        return intent;
    }


}
