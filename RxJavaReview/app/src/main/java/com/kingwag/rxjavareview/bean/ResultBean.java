package com.kingwag.rxjavareview.bean;

import java.util.List;

/**
 * Created by kingwag on 2016/12/13.
 */

public class ResultBean {

    /**
     * status : ok
     * paramz : {"feeds":[{"id":299080,"oid":288342,"category":"article","data":{"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}},{"id":299076,"oid":288340,"category":"article","data":{"subject":"荔枝新闻3.0：不止是阅读","summary":"江苏广电旗下资讯类手机应用\u201c荔枝新闻\u201d于近期推出全新升级换代的3.0版。","cover":"/Attachs/Article/288340/3e8e2c397c70469f8845fad73aa38165_padmini.JPG","pic":"","format":"txt","changed":"2015-09-22 16:01:41"}},{"id":299069,"oid":288333,"category":"article","data":{"subject":"荔枝新闻3.0改版升级通告","summary":"荔枝新闻3.0全新升级，只等你来！荔枝新闻，伴你一起看世界！","cover":"/Attachs/Article/288333/84aefe60759247808d8e804ac79a46d4_padmini.JPG","pic":"","format":"txt","changed":"2015-09-20 15:28:11"}},{"id":299032,"oid":288310,"category":"article","data":{"subject":"迪拜酋长长子突发心脏病去世","summary":"阿联酋迪拜酋长长子突发心脏病去世，年仅34岁。","cover":"/Attachs/Article/288310/622756a75c424a459cfb14506fc55a5f_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 17:45:07"}},{"id":299048,"oid":288321,"category":"article","data":{"subject":"南通一村干部被爆不雅视频","summary":"今天（9月19日），一段\u201c如皋吴窑镇长西村村长不雅视频\u201d在微信朋友圈疯传。","cover":"/Attachs/Article/288321/6ec2109e3cf44fa985929b9b4a6d5669_padmini.JPG","pic":"","format":"original","changed":"2015-09-19 19:27:35"}},{"id":299077,"oid":186,"category":"zhibo","data":{"subject":"回顾：南京牛首山佛顶骨舍利供奉大典","summary":"2015年10月27日，南京举行盛典恭迎佛顶舍利进驻牛首山佛顶宫。","cover":"/Attachs/Zhibo/186/ab8d88f7a13d441bb05e0c93eeb5c603_padmini.JPG","format":"zhibo","changed":"2015-10-27 12:50:37"}},{"id":299045,"oid":288320,"category":"article","data":{"subject":"贵阳一官员开受贿轿车接受调查","summary":"贵阳一官员开着不法商人为其购买的轿车前往接受组织调查。","cover":"/Attachs/Article/288320/3dff218fa4c34451b93fe7fd39163aa0_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 19:00:17"}},{"id":298922,"oid":288230,"category":"article","data":{"subject":"感动网友\"雨伞爸爸\"毕业于南大","summary":"爆红照片并不会改变我们的生活，会尽全力为儿子创造最好的条件，自由闯荡。","cover":"/Attachs/Article/288230/7c16334e2ebf495b8140264423b91b89_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 15:28:58"}},{"id":299066,"oid":288332,"category":"article","data":{"subject":"荔枝派：我才不会轻易的狗带！","summary":"传说，程序猿早已加入丈母娘最爱女婿套餐，并已取代公务猿登上榜首之位。","cover":"/Attachs/Article/288332/e6a3b871a4ab4671abf736cfb73b667a_padmini.JPG","pic":"","format":"original","changed":"2015-09-19 20:11:56"}},{"id":298993,"oid":288284,"category":"article","data":{"subject":"《蒙面歌王》：面具下的公正","summary":"歌手带上面具，影响他社会声誉的其它因素就都一笔勾销了，节目因此变得纯粹","cover":"/Attachs/Article/288284/0e9f8f4d23a345f6a2d7566405d111fd_padmini.JPG","pic":"","format":"original","changed":"2015-09-20 10:34:52"}}],"PageIndex":1,"PageSize":10,"TotalCount":53521,"TotalPage":5353}
     */

    private String status;
    private ParamzBean paramz;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ParamzBean getParamz() {
        return paramz;
    }

    public void setParamz(ParamzBean paramz) {
        this.paramz = paramz;
    }

    public static class ParamzBean {
        /**
         * feeds : [{"id":299080,"oid":288342,"category":"article","data":{"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}},{"id":299076,"oid":288340,"category":"article","data":{"subject":"荔枝新闻3.0：不止是阅读","summary":"江苏广电旗下资讯类手机应用\u201c荔枝新闻\u201d于近期推出全新升级换代的3.0版。","cover":"/Attachs/Article/288340/3e8e2c397c70469f8845fad73aa38165_padmini.JPG","pic":"","format":"txt","changed":"2015-09-22 16:01:41"}},{"id":299069,"oid":288333,"category":"article","data":{"subject":"荔枝新闻3.0改版升级通告","summary":"荔枝新闻3.0全新升级，只等你来！荔枝新闻，伴你一起看世界！","cover":"/Attachs/Article/288333/84aefe60759247808d8e804ac79a46d4_padmini.JPG","pic":"","format":"txt","changed":"2015-09-20 15:28:11"}},{"id":299032,"oid":288310,"category":"article","data":{"subject":"迪拜酋长长子突发心脏病去世","summary":"阿联酋迪拜酋长长子突发心脏病去世，年仅34岁。","cover":"/Attachs/Article/288310/622756a75c424a459cfb14506fc55a5f_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 17:45:07"}},{"id":299048,"oid":288321,"category":"article","data":{"subject":"南通一村干部被爆不雅视频","summary":"今天（9月19日），一段\u201c如皋吴窑镇长西村村长不雅视频\u201d在微信朋友圈疯传。","cover":"/Attachs/Article/288321/6ec2109e3cf44fa985929b9b4a6d5669_padmini.JPG","pic":"","format":"original","changed":"2015-09-19 19:27:35"}},{"id":299077,"oid":186,"category":"zhibo","data":{"subject":"回顾：南京牛首山佛顶骨舍利供奉大典","summary":"2015年10月27日，南京举行盛典恭迎佛顶舍利进驻牛首山佛顶宫。","cover":"/Attachs/Zhibo/186/ab8d88f7a13d441bb05e0c93eeb5c603_padmini.JPG","format":"zhibo","changed":"2015-10-27 12:50:37"}},{"id":299045,"oid":288320,"category":"article","data":{"subject":"贵阳一官员开受贿轿车接受调查","summary":"贵阳一官员开着不法商人为其购买的轿车前往接受组织调查。","cover":"/Attachs/Article/288320/3dff218fa4c34451b93fe7fd39163aa0_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 19:00:17"}},{"id":298922,"oid":288230,"category":"article","data":{"subject":"感动网友\"雨伞爸爸\"毕业于南大","summary":"爆红照片并不会改变我们的生活，会尽全力为儿子创造最好的条件，自由闯荡。","cover":"/Attachs/Article/288230/7c16334e2ebf495b8140264423b91b89_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 15:28:58"}},{"id":299066,"oid":288332,"category":"article","data":{"subject":"荔枝派：我才不会轻易的狗带！","summary":"传说，程序猿早已加入丈母娘最爱女婿套餐，并已取代公务猿登上榜首之位。","cover":"/Attachs/Article/288332/e6a3b871a4ab4671abf736cfb73b667a_padmini.JPG","pic":"","format":"original","changed":"2015-09-19 20:11:56"}},{"id":298993,"oid":288284,"category":"article","data":{"subject":"《蒙面歌王》：面具下的公正","summary":"歌手带上面具，影响他社会声誉的其它因素就都一笔勾销了，节目因此变得纯粹","cover":"/Attachs/Article/288284/0e9f8f4d23a345f6a2d7566405d111fd_padmini.JPG","pic":"","format":"original","changed":"2015-09-20 10:34:52"}}]
         * PageIndex : 1
         * PageSize : 10
         * TotalCount : 53521
         * TotalPage : 5353
         */

        private int PageIndex;
        private int PageSize;
        private int TotalCount;
        private int TotalPage;
        private List<FeedsBean> feeds;

        public int getPageIndex() {
            return PageIndex;
        }

        public void setPageIndex(int PageIndex) {
            this.PageIndex = PageIndex;
        }

        public int getPageSize() {
            return PageSize;
        }

        public void setPageSize(int PageSize) {
            this.PageSize = PageSize;
        }

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public static class FeedsBean {
            /**
             * id : 299080
             * oid : 288342
             * category : article
             * data : {"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}
             */

            private int id;
            private int oid;
            private String category;
            private DataBean data;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * subject : 视频直播：习近平马英九会面
                 * summary : 两岸领导人习近平、马英九在新加坡会面
                 * cover : /Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG
                 * pic :
                 * format : video
                 * changed : 2015-11-07 14:35:22
                 */

                private String subject;
                private String summary;
                private String cover;
                private String pic;
                private String format;
                private String changed;

                public String getSubject() {
                    return subject;
                }

                public void setSubject(String subject) {
                    this.subject = subject;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }

                public String getChanged() {
                    return changed;
                }

                public void setChanged(String changed) {
                    this.changed = changed;
                }
            }
        }
    }
}
