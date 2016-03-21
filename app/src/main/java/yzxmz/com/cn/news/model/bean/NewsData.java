package yzxmz.com.cn.news.model.bean;

import java.util.List;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.model.bean
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/21 15
 */
public class NewsData {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : */

    private int showapi_res_code;
    private String showapi_res_error;
    /**
     * pagebean :
     */

    private ShowapiResBodyEntity showapi_res_body;

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public void setShowapi_res_body(ShowapiResBodyEntity showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public ShowapiResBodyEntity getShowapi_res_body() {
        return showapi_res_body;
    }

    public static class ShowapiResBodyEntity {
        /**
         * allNum : 3467
         * allPages : 174
         * contentlist :
         */

        private PagebeanEntity pagebean;
        private int ret_code;

        public void setPagebean(PagebeanEntity pagebean) {
            this.pagebean = pagebean;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanEntity getPagebean() {
            return pagebean;
        }

        public int getRet_code() {
            return ret_code;
        }

        public static class PagebeanEntity {
            private int allNum;
            private int allPages;
            private int currentPage;
            private int maxResult;
            /**
             * channelId : 5572a109b3cdc86cf39001db
             * channelName : 国内最新
             * desc : 为什么过去在任的美国总统都没有忙里抽闲去一趟古巴，古巴88年等一回，为什么等来的是奥巴马。
             * imageurls : [{"height":666,"url":"http://inews.gtimg.com/newsapp_ls/0/215926260/0","width":1280},{"height":993,"url":"http://inews.gtimg.com/newsapp_ls/0/215930945/0","width":962},{"height":645,"url":"http://inews.gtimg.com/newsapp_ls/0/215931284/0","width":962},{"height":643,"url":"http://inews.gtimg.com/newsapp_ls/0/215931497/0","width":962},{"height":643,"url":"http://inews.gtimg.com/newsapp_ls/0/215931734/0","width":962},{"height":643,"url":"http://inews.gtimg.com/newsapp_ls/0/215932037/0","width":962},{"height":643,"url":"http://inews.gtimg.com/newsapp_ls/0/215932203/0","width":962},{"height":643,"url":"http://inews.gtimg.com/newsapp_ls/0/215932468/0","width":962},{"height":643,"url":"http://inews.gtimg.com/newsapp_ls/0/215932758/0","width":962},{"height":249,"url":"http://inews.gtimg.com/newsapp_ls/0/215871165/0","width":375},{"height":249,"url":"http://inews.gtimg.com/newsapp_ls/0/215872060/0","width":375},{"height":256,"url":"http://inews.gtimg.com/newsapp_ls/0/215872278/0","width":375}]
             * link : http://view.inews.qq.com/a/NEW2016032103563508
             * long_desc : 今年2月，美国总统奥巴马宣布将在下一次国际旅行中访问古巴。为什么过去在任的美国总统都没有忙里抽闲去一趟古巴，古巴88年等一回，为什么等来的是奥巴马？同年，有新的民意调查显示，大多数生活在迈阿密的古巴裔美国人，希望美国结束对古巴的制裁，奥巴马总统已决定将针对古巴的贸易禁运再延长一年。
             * nid : 5466200314939410860
             * pubDate : 2016-03-21 15:00:00
             * sentiment_display : 0
             * sentiment_tag : {"count":"15930","dim":"0","id":"3497","isbooked":0,"ishot":"0","name":"古巴","type":"senti"}
             * source : 腾讯国际新闻
             * tags : {"own":[{"name":"内容质量差","type":1},{"name":"内容缺失","type":2}],"tag":["古巴","奥巴马"]}
             * title : 奥巴马访古巴就是互动再互动
             */

            private List<ContentlistEntity> contentlist;

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public void setContentlist(List<ContentlistEntity> contentlist) {
                this.contentlist = contentlist;
            }

            public int getAllNum() {
                return allNum;
            }

            public int getAllPages() {
                return allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public List<ContentlistEntity> getContentlist() {
                return contentlist;
            }

            public static class ContentlistEntity {
                private String channelId;
                private String channelName;
                private String desc;
                private String link;
                private String long_desc;
                private String nid;
                private String pubDate;
                private int sentiment_display;
                /**
                 * count : 15930
                 * dim : 0
                 * id : 3497
                 * isbooked : 0
                 * ishot : 0
                 * name : 古巴
                 * type : senti
                 */

                private SentimentTagEntity sentiment_tag;
                private String source;
                private TagsEntity tags;
                private String title;
                /**
                 * height : 666
                 * url : http://inews.gtimg.com/newsapp_ls/0/215926260/0
                 * width : 1280
                 */

                private List<ImageurlsEntity> imageurls;

                public void setChannelId(String channelId) {
                    this.channelId = channelId;
                }

                public void setChannelName(String channelName) {
                    this.channelName = channelName;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public void setLong_desc(String long_desc) {
                    this.long_desc = long_desc;
                }

                public void setNid(String nid) {
                    this.nid = nid;
                }

                public void setPubDate(String pubDate) {
                    this.pubDate = pubDate;
                }

                public void setSentiment_display(int sentiment_display) {
                    this.sentiment_display = sentiment_display;
                }

                public void setSentiment_tag(SentimentTagEntity sentiment_tag) {
                    this.sentiment_tag = sentiment_tag;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public void setTags(TagsEntity tags) {
                    this.tags = tags;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public void setImageurls(List<ImageurlsEntity> imageurls) {
                    this.imageurls = imageurls;
                }

                public String getChannelId() {
                    return channelId;
                }

                public String getChannelName() {
                    return channelName;
                }

                public String getDesc() {
                    return desc;
                }

                public String getLink() {
                    return link;
                }

                public String getLong_desc() {
                    return long_desc;
                }

                public String getNid() {
                    return nid;
                }

                public String getPubDate() {
                    return pubDate;
                }

                public int getSentiment_display() {
                    return sentiment_display;
                }

                public SentimentTagEntity getSentiment_tag() {
                    return sentiment_tag;
                }

                public String getSource() {
                    return source;
                }

                public TagsEntity getTags() {
                    return tags;
                }

                public String getTitle() {
                    return title;
                }

                public List<ImageurlsEntity> getImageurls() {
                    return imageurls;
                }

                public static class SentimentTagEntity {
                    private String count;
                    private String dim;
                    private String id;
                    private int isbooked;
                    private String ishot;
                    private String name;
                    private String type;

                    public void setCount(String count) {
                        this.count = count;
                    }

                    public void setDim(String dim) {
                        this.dim = dim;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public void setIsbooked(int isbooked) {
                        this.isbooked = isbooked;
                    }

                    public void setIshot(String ishot) {
                        this.ishot = ishot;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getCount() {
                        return count;
                    }

                    public String getDim() {
                        return dim;
                    }

                    public String getId() {
                        return id;
                    }

                    public int getIsbooked() {
                        return isbooked;
                    }

                    public String getIshot() {
                        return ishot;
                    }

                    public String getName() {
                        return name;
                    }

                    public String getType() {
                        return type;
                    }
                }

                public static class TagsEntity {
                    /**
                     * name : 内容质量差
                     * type : 1
                     */

                    private List<OwnEntity> own;
                    private List<String> tag;

                    public void setOwn(List<OwnEntity> own) {
                        this.own = own;
                    }

                    public void setTag(List<String> tag) {
                        this.tag = tag;
                    }

                    public List<OwnEntity> getOwn() {
                        return own;
                    }

                    public List<String> getTag() {
                        return tag;
                    }

                    public static class OwnEntity {
                        private String name;
                        private int type;

                        public void setName(String name) {
                            this.name = name;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }

                        public String getName() {
                            return name;
                        }

                        public int getType() {
                            return type;
                        }
                    }
                }

                public static class ImageurlsEntity {
                    private int height;
                    private String url;
                    private int width;

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public int getWidth() {
                        return width;
                    }
                }
            }
        }
    }
}
