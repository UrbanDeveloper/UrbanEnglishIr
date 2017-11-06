package com.example.ashamsa.UrbanEnglishIr;

import java.util.Date;
import java.util.UUID;

/**
 * Created by AShamsa on 10/20/2017.
 */
abstract class SinglePost {
    public UUID m_Id;
    public CatagoriesEnum m_catagoriesEnum ;



    public String m_Title="";
    public String m_description="";
    public Date m_date;

    public int m_ImgResId = 0;
    public int m_AudResId = 0;
    public int m_LikeNUM = 0;
    public int m_ViewNum = 0;



    public boolean m_isFavorite = false;



    public SinglePost(CatagoriesEnum catagory, String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
        m_Id = UUID.randomUUID();
        m_Title = title;
        m_date = date;
        m_LikeNUM = likeNUM;
        m_ViewNum = viewNum;
        m_ImgResId = imgResId;
        m_AudResId = audResId;
        m_catagoriesEnum = catagory;

    }

    public SinglePost() {
        m_Id = UUID.randomUUID();
        m_date = new Date();
    }


    public CatagoriesEnum getCatagoriesEnum() {
        return m_catagoriesEnum;
    }

    public void setCatagoriesEnum(CatagoriesEnum catagoriesEnum) {
        m_catagoriesEnum = catagoriesEnum;
    }

    public UUID getId() {
        return m_Id;
    }

    public String getTitle() {
        return m_Title;
    }

    public void setTitle(String title) {
        m_Title = title;
    }

    public Date getDate() {
        return m_date;
    }

    public void setDate(Date date) {
        m_date = date;
    }

    public Integer getLikeNUM() {
        return m_LikeNUM;
    }

    public void setLikeNUM(Integer likeNUM) {
        m_LikeNUM = likeNUM;
    }

    public Integer getViewNum() {
        return m_ViewNum;
    }

    public void setViewNum(Integer viewNum) {
        m_ViewNum = viewNum;
    }

    public String getDescription() {
        return m_description;
    }

    public void setDescription(String description) {
        m_description = description;
    }

    public int getImgResId() {
        return m_ImgResId;
    }

    public void setImgResId(int imgResId) {
        m_ImgResId = imgResId;
    }

    public int getAudResId() {
        return m_AudResId;
    }

    public void setAudResId(int audResId) {
        m_AudResId = audResId;
    }

    public boolean isFavorite() {
        return m_isFavorite;
    }

    public void setFavorite(boolean favorite) {
        m_isFavorite = favorite;
    }
}

public class Data {

    public static class Applied extends SinglePost {
        public Applied(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.Applied,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public Applied() {
            super();
        }
    }

    public static class Social extends SinglePost {
        public Social(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.Social,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public Social() {
            super();
        }
    }

    public static class Media extends SinglePost {
        public Media(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.Media,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public Media() {
            super();
        }
    }

    public static class UserFeed extends SinglePost {
        private boolean m_postConfirmed=false;
        public boolean isPostConfirmed() {
            return m_postConfirmed;
        }

        public void setPostConfirmed(boolean postConfirmed) {
            m_postConfirmed = postConfirmed;
        }


        //public uuid owner;
        public UserFeed(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.UserFeeds,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public UserFeed() {
            super();
            m_catagoriesEnum = CatagoriesEnum.UserFeeds;
        }
    }

    public static class Pkg1 extends SinglePost {
        public Pkg1(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.Package1,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public Pkg1() {
            super();
        }
    }

    public static class Pkg2 extends SinglePost {
        public Pkg2(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.Package2,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public Pkg2() {
            super();
        }
    }
    public static class Pkg3 extends SinglePost {
        public Pkg3(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.Package3,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public Pkg3() {
            super();
        }
    }
    public static class Favorite extends SinglePost {
        public Favorite(String title, Date date, int imgResId, int audResId, int likeNUM, int viewNum) {
            super(CatagoriesEnum.Favorites,title, date, imgResId, audResId, likeNUM, viewNum);
        }

        public Favorite() {
            super();
        }
    }




}

