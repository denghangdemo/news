package yzxmz.com.cn.news;

import android.app.Application;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/25 09
 */
public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
       /* RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);*/
    }
}
