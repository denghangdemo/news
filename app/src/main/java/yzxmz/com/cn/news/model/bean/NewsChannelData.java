package yzxmz.com.cn.news.model.bean;

import io.realm.RealmObject;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.model.bean
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/25 10
 */
public class NewsChannelData extends RealmObject {

    private String channelId; // 频道ID
    private String name; // 频道名称
    private int position; // 位置（频道排序）

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
