package yzxmz.com.cn.news.model.network;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.bean.NewsData;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.model.network
 * @Description: 理论上应该是 不用eventbus 搞转发的，没有好的想法，同学们 开动你的小脑筋吧
 * @date 2016/3/16 14
 */
public class ApiManage {

    public static Observable<List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity>> getNewsChannel(Context context) {
        Observable<List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity>> observable = NetworkClient.createApi(context).
                getNewsChannel().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                map(new Func1<NewsChannel, List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity>>() {
                    @Override
                    public List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> call(NewsChannel newsChannel) {
                        int code = newsChannel.getShowapi_res_code();
                        List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list = new ArrayList<>();
                        if (code == 0) {
                            list = newsChannel.getShowapi_res_body().getChannelList();
                        }
                        return list;
                    }
                });
        return observable;
    }

    public static Observable<List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity>> getNewsDataByChannel(Context context, final String channelId, int page) {
        Observable<List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity>> observable = NetworkClient.createApi(context).
                getNewsData(channelId, page).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                map(new Func1<NewsData, List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity>>() {
                    @Override
                    public List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> call(NewsData newsData) {
                        int resCode = newsData.getShowapi_res_code();
                        List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> contentList = new ArrayList<>();
                        if (resCode == 0) {
                            int code = newsData.getShowapi_res_body().getRet_code();
                            if (code == 0) {
                                NewsData.ShowapiResBodyEntity.PagebeanEntity entity = newsData.getShowapi_res_body().getPagebean();
                                contentList = entity.getContentlist();
                            }
                        }
                        return contentList;
                    }
                });
        return observable;
    }
}
