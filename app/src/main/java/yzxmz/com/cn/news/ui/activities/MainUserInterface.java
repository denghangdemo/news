package yzxmz.com.cn.news.ui.activities;

import android.content.Context;

import java.util.List;

import yzxmz.com.cn.news.model.bean.NewsChannel;

interface MainUserInterface {
    Context getContext();

    void updateChannels(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> channels);
}
