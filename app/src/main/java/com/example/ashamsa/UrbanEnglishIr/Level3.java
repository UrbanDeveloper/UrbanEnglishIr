package com.example.ashamsa.UrbanEnglishIr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashamsa.recyclerviewtemplate.R;

import java.util.List;
import java.util.UUID;


/**
 * Created by ashamsa on 10/22/2017.
 */

public class Level3 extends Fragment {
    //// TODO: 10/31/2017 back icon should be created
    SinglePost m_singlePost;

    TextView m_textView_Title;
    TextView m_textView_LikeNum;
    TextView m_textView_ViewNum;
    ImageView m_imageView_Likenum;
    ImageView m_imageView_Favorite;
    ImageView m_imageView;
    TextView m_textView_Description;
    private static final String ARG_SINGLEPOST_ID = "singlepost_id ";
    private static final String VIEWNUM_INDEX = "viewnum_index";
    private int m_ViewNumIndex = 0;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.level3_xml, container, false);
        m_imageView = v.findViewById(R.id.imageView_level3);
        m_textView_Title = v.findViewById(R.id.textView_level3_Title);

        m_imageView_Likenum = v.findViewById(R.id.imageView_like_num_L3);
        m_imageView_Favorite = v.findViewById(R.id.imageView_favorite_L3);
        m_textView_LikeNum = v.findViewById(R.id.textview_likenum_L3);
        m_textView_ViewNum = v.findViewById(R.id.textview_viewnum_L3);
        m_textView_Description = v.findViewById(R.id.textView_Description_L3);


        UUID singlepost_ID = (UUID) getArguments().getSerializable(ARG_SINGLEPOST_ID);
        m_singlePost = DataLab.get(getActivity()).getSinglePost(singlepost_ID);


        if (savedInstanceState != null) {
            m_ViewNumIndex = savedInstanceState.getInt(VIEWNUM_INDEX, 0);
        }

        m_textView_Title.setText(m_singlePost.getTitle());
        m_imageView.setImageResource(m_singlePost.m_ImgResId);
        m_textView_LikeNum.setText(m_singlePost.getLikeNUM().toString());
        m_textView_ViewNum.setText(m_singlePost.getViewNum().toString());
        m_textView_Description.setText(m_singlePost.getDescription().toString());
        if (m_singlePost.isFavorite()) {
            m_imageView_Favorite.setImageResource(R.drawable.ic_favorite_yes);
        }else
        {
            m_imageView_Favorite.setImageResource(0);
            m_imageView_Favorite.setImageResource(R.drawable.ic_favorite_no);
        }

        // TODO: 10/31/2017 favorite icon should be handled here too.
        m_imageView_Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAlreadyinFavorite = m_singlePost.isFavorite();


                if (!isAlreadyinFavorite) {
                    DataLab.get(getActivity()).add2Favorite((SinglePost) m_singlePost);
                    m_singlePost.setFavorite(true);
                    v.setBackgroundResource(R.drawable.ic_favorite_yes);
                }else
                {
                    DataLab.get(getActivity()).RemoveFromFavorite((SinglePost) m_singlePost);
                    m_singlePost.setFavorite(false);
                    m_imageView_Favorite.setImageResource(0);
                    v.setBackgroundResource(R.drawable.ic_favorite_no);
                }
            }
        });
        m_imageView_Likenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int LikeNum = m_singlePost.getLikeNUM();
                m_singlePost.setLikeNUM(LikeNum + 1);
                m_textView_LikeNum.setText(m_singlePost.getLikeNUM().toString());
            }
        });
        return v;
    }

    public static Level3 newInstance(UUID singlepostId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SINGLEPOST_ID, singlepostId);
        Level3 fragment = new Level3();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(VIEWNUM_INDEX, m_ViewNumIndex);
    }


}
