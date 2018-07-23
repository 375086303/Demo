package com.example.list_select;

import java.util.List;

public class SheQuData {

    /**
     * result : null
     * total : 2
     * code : 200
     * message :
     * resultList : {"tj":[{"isDefault":1,"gz_count":377,"name":"育华驾校","icon":"http://misc.dyhoa.com/20180629/a8e8bb90-f848-4974-9668-152aa4ebb01e.jpg","description":"石家庄育华驾校，学车无忧的驾校","articleCount":8,"id":8,"isgz":0},{"isDefault":1,"gz_count":17283,"name":"男神女神","icon":"http://misc.dyhoa.com/20170511/6a241ca3-88ca-4ff9-99ad-1be194e87b88.jpg","description":"嘿，帅哥美女们，发张自拍吧！","articleCount":113,"id":2,"isgz":0},{"isDefault":1,"gz_count":14888,"name":"九悦 \u2022 路上","icon":"http://misc.dyhoa.com/20170908/49e5dd80-6ff4-4a9c-b052-22313e1a38e2.jpg","description":"我们的成长离不开你的陪伴","articleCount":70,"id":7,"isgz":0}],"my":[{"isDefault":2,"gz_count":18163,"name":"学车问答","icon":"http://misc.dyhoa.com/20170511/5e96698c-4b16-49a0-a0e5-6041df4e6429.jpg","description":"九悦学车专治各种疑难杂症！","articleCount":202,"id":1,"isgz":0},{"isDefault":2,"gz_count":16652,"name":"许愿墙","icon":"http://misc.dyhoa.com/20170511/2a4d083a-eef1-467f-8b68-5ea33c860b6a.jpg","description":"据说，在这里许愿的99%都实现了。","articleCount":162,"id":3,"isgz":0},{"isDefault":2,"gz_count":16845,"name":"晒驾照","icon":"http://misc.dyhoa.com/20170904/cacbeda7-aad1-4ac5-8a4c-dd670df58254.jpg","description":"晒出风采，晒出自信！","articleCount":34,"id":4,"isgz":0},{"isDefault":2,"gz_count":15952,"name":"学车故事","icon":"http://misc.dyhoa.com/20170904/3335d9c7-36a2-4a9f-bb17-38e3053a924e.png","description":"讲述学车过程中的点点滴滴","articleCount":238,"id":6,"isgz":0}]}
     */

    private Object result;
    private int total;
    private int code;
    private String message;
    private ResultListBean resultList;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultListBean getResultList() {
        return resultList;
    }

    public void setResultList(ResultListBean resultList) {
        this.resultList = resultList;
    }

    public static class ResultListBean {
        private List<TjBean> tj;
        private List<MyBean> my;

        public List<TjBean> getTj() {
            return tj;
        }

        public void setTj(List<TjBean> tj) {
            this.tj = tj;
        }

        public List<MyBean> getMy() {
            return my;
        }

        public void setMy(List<MyBean> my) {
            this.my = my;
        }

        public static class TjBean {
            /**
             * isDefault : 1
             * gz_count : 377
             * name : 育华驾校
             * icon : http://misc.dyhoa.com/20180629/a8e8bb90-f848-4974-9668-152aa4ebb01e.jpg
             * description : 石家庄育华驾校，学车无忧的驾校
             * articleCount : 8
             * id : 8
             * isgz : 0
             */

            private int isDefault;
            private int gz_count;
            private String name;
            private String icon;
            private String description;
            private int articleCount;
            private int id;
            private int isgz;

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
            }

            public int getGz_count() {
                return gz_count;
            }

            public void setGz_count(int gz_count) {
                this.gz_count = gz_count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getArticleCount() {
                return articleCount;
            }

            public void setArticleCount(int articleCount) {
                this.articleCount = articleCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsgz() {
                return isgz;
            }

            public void setIsgz(int isgz) {
                this.isgz = isgz;
            }
        }

        public static class MyBean {
            /**
             * isDefault : 2
             * gz_count : 18163
             * name : 学车问答
             * icon : http://misc.dyhoa.com/20170511/5e96698c-4b16-49a0-a0e5-6041df4e6429.jpg
             * description : 九悦学车专治各种疑难杂症！
             * articleCount : 202
             * id : 1
             * isgz : 0
             */

            private int isDefault;
            private int gz_count;
            private String name;
            private String icon;
            private String description;
            private int articleCount;
            private int id;
            private int isgz;

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
            }

            public int getGz_count() {
                return gz_count;
            }

            public void setGz_count(int gz_count) {
                this.gz_count = gz_count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getArticleCount() {
                return articleCount;
            }

            public void setArticleCount(int articleCount) {
                this.articleCount = articleCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsgz() {
                return isgz;
            }

            public void setIsgz(int isgz) {
                this.isgz = isgz;
            }
        }
    }
}
