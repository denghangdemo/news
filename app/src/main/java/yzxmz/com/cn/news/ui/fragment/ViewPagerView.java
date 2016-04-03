package yzxmz.com.cn.news.ui.fragment;

import java.util.List;

import yzxmz.com.cn.news.model.bean.NewsData;

/**
 * Created by dengh on 2016/4/3.
 */
public interface ViewPagerView {
    void showListItem(List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> list);
}
