package yzxmz.com.cn.news.ui.activity;

import java.util.List;

import yzxmz.com.cn.news.model.bean.NewsChannel;

/**
 * Created by dengh on 2016/4/3.
 */
public interface MainView {
    void showTabHost(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list);
}
