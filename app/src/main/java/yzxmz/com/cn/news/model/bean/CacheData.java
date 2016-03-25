package yzxmz.com.cn.news.model.bean;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.model.bean
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/25 09
 */
public class CacheData extends RealmObject {

    @Required
    private String json; // 具体的json数据

    private long time; // 写入时间

    private String channelId; //频道ID

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
