package yzxmz.com.cn.news.model.database;

import com.google.gson.Gson;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.bean.NewsData;
import yzxmz.com.cn.news.model.database.domain.CacheData;
import yzxmz.com.cn.news.model.database.domain.NewsChannelData;

/**
 * Created by dengh on 2016/3/24.
 */
public class DatabaseHelper {

    public static Observable<Void> storeChannelData(final List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                Realm realm = Realm.getDefaultInstance();
                for (int i = 0; i < list.size(); i++) {
                    long time = System.currentTimeMillis();
                    realm.beginTransaction();
                    NewsChannelData channelData = realm.createObject(NewsChannelData.class);
                    channelData.setChannelId(list.get(i).getChannelId());
                    channelData.setName(list.get(i).getName());
                    channelData.setPosition(i);
                    channelData.setTime(time);
                    realm.commitTransaction();
                }
                realm.close();
                subscriber.onCompleted();
            }
        });
    }

    public static Observable<NewsChannelData> findChannelData() {
        return Observable.create(new Observable.OnSubscribe<NewsChannelData>() {
            @Override
            public void call(Subscriber<? super NewsChannelData> subscriber) {
                Realm realm = Realm.getDefaultInstance();
                RealmResults<NewsChannelData> results = realm.where(NewsChannelData.class).findAll();
                for (NewsChannelData data : results) {
                    subscriber.onNext(data);
                }
                realm.close();
                subscriber.onCompleted();
            }
        });
    }

    public static Observable<Void> storeNewsData(final List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> list, final String channelId) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                Realm realm = Realm.getDefaultInstance();
                for (int i = 0; i < list.size(); i++) {
                    realm.beginTransaction();
                    CacheData cacheData = realm.createObject(CacheData.class);
                    cacheData.setChannelId(channelId);
                    cacheData.setTime(System.currentTimeMillis());
                    String json = new Gson().toJson(list);
                    cacheData.setJson(json);
                    realm.commitTransaction();
                }
                realm.close();
            }
        });
    }
}
