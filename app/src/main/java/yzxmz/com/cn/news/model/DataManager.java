package yzxmz.com.cn.news.model;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.bean.NewsData;
import yzxmz.com.cn.news.model.database.DatabaseHelper;
import yzxmz.com.cn.news.model.event.ContentlistEvent;
import yzxmz.com.cn.news.model.network.NetworkClient;

/**
 * Created by dengh on 2016/3/24.
 */
public class DataManager {
    public static void getNewsChannel(Context context) {
        NetworkClient.createApi(context).
                getNewsChannel().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<NewsChannel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(NewsChannel newsChannel) {
                        int resCode = newsChannel.getShowapi_res_code();
                        if (resCode == 0) {
                            List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list = newsChannel.getShowapi_res_body().getChannelList();
                            DatabaseHelper.storeChannelData(list).subscribe(new Observer<Void>() {
                                @Override
                                public void onCompleted() {
                                    Log.d("denghang","onCompleted");
                                }

                                @Override
                                public void onError(Throwable e) {
                                    Log.d("denghang","onError");
                                }

                                @Override
                                public void onNext(Void aVoid) {
                                    Log.d("denghang", "onNext");
                                }
                            });
                            //EventBus.getDefault().post(new ChannelEvent(list));
                        }
                    }
                });
    }

    public static void getNewsDataByChannel(Context context, final String channelId, int page) {
        NetworkClient.createApi(context).
                getNewsData(channelId, page).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<NewsData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsData newsData) {
                        int resCode = newsData.getShowapi_res_code();
                        if (resCode == 0) {
                            int code = newsData.getShowapi_res_body().getRet_code();
                            if (code == 0) {
                                NewsData.ShowapiResBodyEntity.PagebeanEntity entity = newsData.getShowapi_res_body().getPagebean();
                                List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> contentlist = entity.getContentlist();
                                // TODO: 2016/3/24 写数据库
                                //DatabaseHelper.storeNewsData(contentlist,channelId);
                                EventBus.getDefault().post(new ContentlistEvent(contentlist));
                            }
                        }
                    }
                });
    }
}
