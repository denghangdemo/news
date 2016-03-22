package yzxmz.com.cn.news.model.network;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import rx.Observer;
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

    public static void getNewsChannel(Context context) {
        NetworkClient.createApi(context).
                getNewsChannel().
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
                           /* for (int i = 0; i < list.size(); i++) {
                                NewsChannel.ShowapiResBodyEntity.ChannelListEntity entity = list.get(i);
                                Log.d("denghang", i + ": entity" + entity.toString());
                            }*/
                            EventBus.getDefault().post(list);
                        }
                    }
                });
    }

    public static void getNewsDataByChannel(Context context, String channelId, String page) {
        NetworkClient.createApi(context).
                getNewsData(channelId, page).
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
                                /*for (int i = 0; i < contentlist.size(); i++) {
                                    NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity contentlistEntity = contentlist.get(i);
                                    String title = contentlistEntity.getTitle();
                                    Log.d("denghang", title);
                                }*/
                                EventBus.getDefault().post(contentlist);
                            }
                        }
                    }
                });
    }
}
