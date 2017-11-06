package com.example.ashamsa.UrbanEnglishIr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashamsa.recyclerviewtemplate.R;

import java.util.List;


/**
 * Created by ashamsa on 10/21/2017.
 */

public class Level2_recycler extends Fragment {
    private static final String ARG_ITEM_SELECTED_POSITION_IN_LEVEL1 = "arg_item_selected_position_in_level1";
    private SinglePostAdapter m_Adapter;
    int PositionfromLevel1 = 0;
    private TextView m_TitleTextView;
    private TextView m_LikeNumtextView;
    private TextView m_ViewNumtextView;
    private ImageView m_imageViewFavorite;
    private RecyclerView m_recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        PositionfromLevel1 = (int) getArguments().getSerializable(ARG_ITEM_SELECTED_POSITION_IN_LEVEL1);
        super.onCreate(savedInstanceState);
        if (PositionfromLevel1 == 3) {
            setHasOptionsMenu(true);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.level2_recycler_host_xml, container, false);

        m_recyclerView = v.findViewById(R.id.level2_recycler);

        m_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        updateRecyclerView();
        return v;
    }


    private void updateRecyclerView() {
        DataLab datalab = DataLab.get(getActivity());
        List<SinglePost> SinglePostlist;

        SinglePostlist = datalab.getSinglePosts(PositionfromLevel1);


        if (m_Adapter == null) {
            m_Adapter = new SinglePostAdapter(SinglePostlist);
            m_recyclerView.setAdapter(m_Adapter);
        } else {
            m_Adapter.notifyDataSetChanged();
        }

    }

    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private SinglePost m_singlepost;


        public ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            m_TitleTextView = itemView.findViewById(R.id.list_item_title_text_view_L2);
            m_LikeNumtextView = itemView.findViewById(R.id.textview_likenum_L2);
            m_ViewNumtextView = itemView.findViewById(R.id.textview_viewnum_L2);
            m_imageViewFavorite = itemView.findViewById(R.id.imageView_favorite_L2);
        }


        @Override
        public void onClick(View v) {
            Intent intent = Level3_fragment_caller_pager.newIntent(getActivity(), m_singlepost.getId());
            startActivity(intent);
        }


        public void bindItem(SinglePost singlepost) {
            m_singlepost = singlepost;
            m_TitleTextView.setText(m_singlepost.getTitle());
            m_LikeNumtextView.setText(m_singlepost.getLikeNUM().toString());
            m_ViewNumtextView.setText(m_singlepost.getViewNum().toString());

            if (m_singlepost.isFavorite()) {
                m_imageViewFavorite.setImageResource(0);
                m_imageViewFavorite.setImageResource(R.drawable.ic_favorite_yes);
            } else {
                m_imageViewFavorite.setImageResource(0);
                m_imageViewFavorite.setImageResource(R.drawable.ic_favorite_no);
            }
        }
    }


    private class SinglePostAdapter extends RecyclerView.Adapter<ItemHolder> {

        private List<SinglePost> m_SinglePosts;


        public SinglePostAdapter(List<SinglePost> singlePosts) {
            m_SinglePosts = singlePosts;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
            View view = layoutinflater.inflate(R.layout.level2_recycler_item_xml, parent, false);
            return new ItemHolder(view);
        }


        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            SinglePost singlepost = m_SinglePosts.get(position);
            holder.bindItem(singlepost);

        }


        @Override
        public int getItemCount() {
            return m_SinglePosts.size();
        }
    }

    public static Level2_recycler newInstance(int position) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ITEM_SELECTED_POSITION_IN_LEVEL1, position);
        Level2_recycler fragment = new Level2_recycler();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_post:
                // TODO: 10/31/2017 :should create valid entery, so simmilar to .addnewUserfeed, there should be a .removeuserfeed in case the enteries are not valid 
                //Data.UserFeed npost = new Data.UserFeed();
                //DataLab.get(getActivity()).addnewUserFeed(npost);
                /*Intent intent = Level3_userFeed_fragment_caller
                        .newIntent(getActivity(), npost.getId());*/
                Intent intent = Level3_userFeed_fragment_caller
                        .newIntent(getActivity());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
        //return super.onOptionsItemSelected(item);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.level2_recycler_host_xml, menu);
    }


    @Override
    public void onResume() {
        super.onResume();
// TODO: 10/31/2017 here we should think of a way to get the list updated after coming from L3
    }
}
