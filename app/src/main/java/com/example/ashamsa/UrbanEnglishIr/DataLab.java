package com.example.ashamsa.UrbanEnglishIr;

import android.content.Context;
import android.widget.Button;

import com.example.ashamsa.recyclerviewtemplate.R;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;


/**
 * Created by AShamsa on 10/20/2017.
 */

public class DataLab {
    private static DataLab s_dataLab;
    private List<Data.Applied> m_applieds;
    private List<Data.Social> m_socials;
    private List<Data.Media> m_medias;
    private List<Data.UserFeed> m_userFeeds;
    private List<Data.Pkg1> m_pkg1s;
    private List<Data.Pkg2> m_pkg2s;
    private List<Data.Pkg3> m_pkg3s;
    private List<SinglePost> m_favorites;


    public static DataLab get(Context context) {
        if (s_dataLab == null) {
            s_dataLab = new DataLab(context);
        }
        return s_dataLab;
    }

    private DataLab(Context context) {
        fillApplied();
        fillSocial();
        fillMedia();
        fillUserfeed();
        fillPkg1();
        fillPkg2();
        fillPkg3();
        fillFavorite();


    }


    private Void fillSocial() {
        m_socials = new ArrayList<>();
        Data.Social m_socials1 = new Data.Social("socials1", new Date(), R.drawable.a1, 0, 1, 1);
        m_socials.add(m_socials1);
        Data.Social m_socials2 = new Data.Social("socials2", new Date(), R.drawable.a1, 0, 1, 1);
        m_socials.add(m_socials2);
        return null;
    }

    public List<Data.Social> getSocials() {
        return m_socials;
    }

    public Data.Social getSocial(UUID id) {
        for (Data.Social i : m_socials) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    private Void fillMedia() {
        m_medias = new ArrayList<>();
        Data.Media m_media1 = new Data.Media("media1", new Date(), R.drawable.b2, 0, 0, 0);
        m_medias.add(m_media1);
        Data.Media m_media2 = new Data.Media("media2", new Date(), R.drawable.b2, 0, 0, 0);
        m_medias.add(m_media2);
        return null;
    }

    public List<Data.Media> getMedias() {
        return m_medias;
    }

    public Data.Media getMedia(UUID id) {
        for (Data.Media i : m_medias) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    private Void fillApplied() {
        m_applieds = new ArrayList<>();
        Data.Applied m_applied1 = new Data.Applied("applied1", new Date(), R.drawable.c3, 0, 0, 0);
        m_applieds.add(m_applied1);
        Data.Applied m_applied2 = new Data.Applied("applied2", new Date(), R.drawable.c3, 0, 0, 0);
        m_applieds.add(m_applied2);
        return null;
    }

    public List<Data.Applied> getApplieds() {
        return m_applieds;
    }

    public Data.Applied getApplied(UUID id) {
        for (Data.Applied i : m_applieds) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    private Void fillUserfeed() {
        m_userFeeds = new ArrayList<>();
        Data.UserFeed m_userfeeds1 = new Data.UserFeed("userfeeds1", new Date(), 0, 0, 0, 0);
        m_userFeeds.add(m_userfeeds1);
        Data.UserFeed m_userfeeds2 = new Data.UserFeed("userfeeds2", new Date(), 0, 0, 0, 0);
        m_userFeeds.add(m_userfeeds2);
        return null;
    }

    public List<Data.UserFeed> getUserFeeds() {
        return m_userFeeds;
    }

    public Data.UserFeed getUserFeed(UUID id) {
        for (Data.UserFeed i : m_userFeeds) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public void addnewUserFeed(Data.UserFeed userFeed) {
        m_userFeeds.add(userFeed);
    }

    public void RemovenewUserFeed(Data.UserFeed userFeed) {
        m_userFeeds.remove(userFeed);
    }

    private Void fillPkg1() {
        m_pkg1s = new ArrayList<>();
        Data.Pkg1 m_pakag1_1 = new Data.Pkg1("pkg1_1", new Date(), 0, 0, 0, 0);
        m_pkg1s.add(m_pakag1_1);
        Data.Pkg1 m_pakag1_2 = new Data.Pkg1("pkg1_2", new Date(), 0, 0, 0, 0);
        m_pkg1s.add(m_pakag1_2);
        return null;
    }
    public List<Data.Pkg1> getPkg1s() {
        return m_pkg1s;
    }
    public Data.Pkg1 getPkg1(UUID id) {
        for (Data.Pkg1 i : m_pkg1s) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    private Void fillPkg2() {
        m_pkg2s = new ArrayList<>();
        Data.Pkg2 m_pakag2_1 = new Data.Pkg2("pkg2_1", new Date(), 0, 0, 0, 0);
        m_pkg2s.add(m_pakag2_1);
        Data.Pkg2 m_pakag2_2 = new Data.Pkg2("pkg2_2", new Date(), 0, 0, 0, 0);
        m_pkg2s.add(m_pakag2_2);
        return null;
    }
    public List<Data.Pkg2> getPkg2s() {
        return m_pkg2s;
    }
    public Data.Pkg2 getPkg2(UUID id) {
        for (Data.Pkg2 i : m_pkg2s) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    private Void fillPkg3() {
        m_pkg3s = new ArrayList<>();
        Data.Pkg3 m_pakag3_1 = new Data.Pkg3("pkg3_1", new Date(), 0, 0, 0, 0);
        m_pkg3s.add(m_pakag3_1);
        Data.Pkg3 m_pakag3_2 = new Data.Pkg3("pkg3_2", new Date(), 0, 0, 0, 0);
        m_pkg3s.add(m_pakag3_2);
        return null;
    }
    public List<Data.Pkg3> getPkg3s() {
        return m_pkg3s;
    }
    public Data.Pkg3 getPkg3(UUID id) {
        for (Data.Pkg3 i : m_pkg3s) {
            if (i.getId().equals(id)) {
                return i;

            }
        }

        return null;
    }

    public SinglePost getSinglePost(UUID id) {


        for (Data.Applied i : m_applieds) {
            if (i.getId().equals(id)) {
                return i;
            }
        }

        for (Data.Social i : m_socials) {
            if (i.getId().equals(id)) {
                return i;
            }
        }

        for (Data.Media i : m_medias) {
            if (i.getId().equals(id)) {
                return i;
            }
        }

        for (Data.UserFeed i : m_userFeeds) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        for (Data.Pkg1 i : m_pkg1s) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        for (Data.Pkg2 i : m_pkg2s) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
    public List<SinglePost> getSinglePosts(int Catagory) {
        List<SinglePost> m_singleposts = null;

        switch (Catagory) {
            case 0://Social
                m_singleposts = (List<SinglePost>) (List<?>) this.getSocials();
                break;
            case 1://Media
                m_singleposts = (List<SinglePost>) (List<?>) this.getMedias();

                break;
            case 2://Applied
                m_singleposts = (List<SinglePost>) (List<?>) this.getApplieds();

                break;
            case 3://Userfeed
                m_singleposts = (List<SinglePost>) (List<?>) this.getUserFeeds();
                break;
            case 4://Package1
                m_singleposts = (List<SinglePost>) (List<?>) this.getPkg1s();
                break;
            case 5://Package2
                m_singleposts = (List<SinglePost>) (List<?>) this.getPkg2s();
                break;
            case 6://Package3
                m_singleposts = (List<SinglePost>) (List<?>) this.getPkg3s();
                break;
            case 7://Favorites
                m_singleposts = (List<SinglePost>) (List<?>) this.getFavorites();
                break;
            default:
                break;

        }
        return m_singleposts;
    }
    public List<SinglePost> getSinglePosts(UUID id) {
        SinglePost m_singlepost = getSinglePost(id);
        List<SinglePost> m_singleposts = null;
        switch (m_singlepost.getCatagoriesEnum()) {
            case Social:
                m_singleposts = (List<SinglePost>) (List<?>) this.getSocials();
                break;
            case Media:
                m_singleposts = (List<SinglePost>) (List<?>) this.getMedias();
                break;
            case Applied:
                m_singleposts = (List<SinglePost>) (List<?>) this.getApplieds();
                break;
            case UserFeeds:
                m_singleposts = (List<SinglePost>) (List<?>) this.getUserFeeds();
                break;
            case Package1:
                m_singleposts = (List<SinglePost>) (List<?>) this.getPkg1s();
                break;
            case Package2:
                m_singleposts = (List<SinglePost>) (List<?>) this.getPkg2s();
                break;
            case Package3:
                m_singleposts = (List<SinglePost>) (List<?>) this.getPkg3s();
                break;
            case Favorites:
                m_singleposts = (List<SinglePost>) (List<?>) this.getFavorites();
                break;
        }


        return m_singleposts;
    }

    private Void fillFavorite() {
        m_favorites = new ArrayList<>();
        return null;
    }
    public List<SinglePost> getFavorites() {
        return m_favorites;
    }
    public SinglePost getFavorite(UUID id) {
        for (SinglePost i : m_favorites) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
    public void add2Favorite(SinglePost post) {
        if (!post.isFavorite()) {
            m_favorites.add(post);
        }
    }
    public void RemoveFromFavorite(SinglePost post) {
        if (post.isFavorite()) {
            m_favorites.remove(post);
        }
    }


    }
