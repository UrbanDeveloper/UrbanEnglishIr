package com.example.ashamsa.UrbanEnglishIr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ashamsa.recyclerviewtemplate.R;

/**
 * Created by AShamsa on 10/20/2017.
 */

public class Level1 extends Fragment {
    // TODO: 10/31/2017 headers should have correct name 
    ImageView m_imageView;
    ListView m_listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.level1_xml, container, false);
        m_imageView =  V.findViewById(R.id.imageView_level1);
        m_listView =  V.findViewById(R.id.listview_level1);
        m_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = Level2_fragment_caller.newIntent(getActivity(), position);
                startActivity(intent);
            }
        });
        return V;
    }
}
