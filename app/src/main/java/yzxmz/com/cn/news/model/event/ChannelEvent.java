package yzxmz.com.cn.news.model.event;

import java.util.List;

import yzxmz.com.cn.news.model.bean.NewsChannel;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.model.event
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/23 11
 */
public class ChannelEvent {
    public List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list;

    public ChannelEvent(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list) {
        this.list = list;
    }
}
