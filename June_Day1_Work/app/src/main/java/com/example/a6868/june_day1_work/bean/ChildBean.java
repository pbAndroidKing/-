package com.example.a6868.june_day1_work.bean;

import java.util.List;

public class ChildBean {

    /**
     * date : 20190527
     * stories : [{"images":["https://pic3.zhimg.com/v2-aba63439334648818b93b27a7f890a76.jpg"],"type":0,"id":9711794,"ga_prefix":"052722","title":"小事 · 宫墙柳"},{"images":["https://pic3.zhimg.com/v2-6e755b8523020865d2f51c470d5a799a.jpg"],"type":0,"id":9711722,"ga_prefix":"052720","title":"为什么游戏中精灵宝可梦设定的携带上限为六只？"},{"images":["https://pic3.zhimg.com/v2-7033f21621d4189456fbc08ec3e586de.jpg"],"type":0,"id":9711764,"ga_prefix":"052716","title":"《全面战争：三国》有哪些不符合历史 / 有待商榷之处？"},{"images":["https://pic4.zhimg.com/v2-6bfccb336e7389405146e03382344ac3.jpg"],"type":0,"id":9711680,"ga_prefix":"052709","title":"汽车上有哪些看着不起眼，但是技术含量贼高的零部件？"},{"images":["https://pic1.zhimg.com/v2-0083152e35ed8ca4e9c8c98b0cd12844.jpg"],"type":0,"id":9711402,"ga_prefix":"052708","title":"为什么追我的人都很穷?"},{"images":["https://pic1.zhimg.com/v2-ae83de30d463ae5f89bffaf4ed4b68a0.jpg"],"type":0,"id":9711698,"ga_prefix":"052707","title":"未经别的演员同意，使用别的相声演员的包袱算不算抄袭？"},{"images":["https://pic1.zhimg.com/v2-729350747d91e08c0e5927a8f7b64078.jpg"],"type":0,"id":9711745,"ga_prefix":"052706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-e25ab892d02bec8fea7979df305d4e30.jpg","type":0,"id":9711402,"ga_prefix":"052708","title":"为什么追我的人都很穷?"},{"image":"https://pic2.zhimg.com/v2-0dc73b026624fc19637c5cb25ff679a9.jpg","type":0,"id":9711735,"ga_prefix":"052507","title":"为什么牛奶卖不完，宁可倒掉也不免费送人？"},{"image":"https://pic2.zhimg.com/v2-9e254a8204a384e59b44f81f9f676eed.jpg","type":0,"id":9711684,"ga_prefix":"052620","title":"为什么国内女演员都在极力追求「少女感」，国外女演员却可以淡定面对年龄的增长？"},{"image":"https://pic1.zhimg.com/v2-5ec1763a3ba317b8103b30933fd9acfc.jpg","type":0,"id":9711681,"ga_prefix":"052520","title":"啥是 IMAX？看这一篇就够了"},{"image":"https://pic4.zhimg.com/v2-32d3659e2abc32cfd579486d21761973.jpg","type":0,"id":9711632,"ga_prefix":"052516","title":"为什么地铁不分等级舱，支付更高的票价享受更好的环境？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic3.zhimg.com/v2-aba63439334648818b93b27a7f890a76.jpg"]
         * type : 0
         * id : 9711794
         * ga_prefix : 052722
         * title : 小事 · 宫墙柳
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-e25ab892d02bec8fea7979df305d4e30.jpg
         * type : 0
         * id : 9711402
         * ga_prefix : 052708
         * title : 为什么追我的人都很穷?
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
