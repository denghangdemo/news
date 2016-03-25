package yzxmz.com.cn.news.model.database;

import com.google.gson.Gson;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;
import yzxmz.com.cn.news.model.bean.CacheData;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.bean.NewsChannelData;
import yzxmz.com.cn.news.model.bean.NewsData;

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
                    realm.beginTransaction();
                    NewsChannelData channelData = realm.createObject(NewsChannelData.class);
                    channelData.setChannelId(list.get(i).getChannelId());
                    channelData.setName(list.get(i).getName());
                    channelData.setPosition(i);
                    realm.commitTransaction();
                }
                subscriber.onCompleted();
                realm.close();
            }
        });
    }

    public static Observable<NewsChannelData> findChannelData() {
        return Observable.create(new Observable.OnSubscribe<NewsChannelData>() {
            @Override
            public void call(Subscriber<? super NewsChannelData> subscriber) {
                Realm realm = Realm.getDefaultInstance();
                RealmResults<NewsChannelData> results = realm.where(NewsChannelData.class).findAllSorted("position");
                for (NewsChannelData data : results) {
                    subscriber.onNext(data);
                }
                subscriber.onCompleted();
                realm.close();
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
