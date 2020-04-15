package com.example.myapplication.text;

import java.util.List;

public class Data1 {

    /**
     * data : {"imgs":["https://gitee.com/ccyy2019/server/raw/master/img01.png","https://gitee.com/ccyy2019/server/raw/master/img02.png","https://gitee.com/ccyy2019/server/raw/master/img03.png","https://gitee.com/ccyy2019/server/raw/master/img04.png"],"catalog":[{"name":"商铺1","icon":"https://gitee.com/ccyy2019/server/raw/master/img05.jpg"},{"name":"商铺2","icon":"https://gitee.com/ccyy2019/server/raw/master/img06.jpg"},{"name":"商铺3","icon":"https://gitee.com/ccyy2019/server/raw/master/img07.jpg"},{"name":"商铺4","icon":"https://gitee.com/ccyy2019/server/raw/master/img08.jpg"}]}
     * errmsg : ok
     * errno : 10000
     */

    private DataBean data;
    private String errmsg;
    private int errno;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public static class DataBean {
        private List<String> imgs;
        private List<CatalogBean> catalog;

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }

        public List<CatalogBean> getCatalog() {
            return catalog;
        }

        public void setCatalog(List<CatalogBean> catalog) {
            this.catalog = catalog;
        }

        public static class CatalogBean {
            /**
             * name : 商铺1
             * icon : https://gitee.com/ccyy2019/server/raw/master/img05.jpg
             */

            private String name;
            private String icon;

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
        }
    }
}
