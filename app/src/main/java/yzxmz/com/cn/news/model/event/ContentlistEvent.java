package yzxmz.com.cn.news.model.event;

import java.util.List;

import yzxmz.com.cn.news.model.bean.NewsData;

/**
 * Created by dengh on 2016/3/23.
 */
public class ContentlistEvent {
    public List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> list;

    public ContentlistEvent(List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> contentlist) {
        this.list = contentlist;
    }
}
