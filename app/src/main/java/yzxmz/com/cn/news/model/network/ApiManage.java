package yzxmz.com.cn.news.model.network;

import android.content.Context;
import android.util.Log;

import java.util.List;

import rx.Observer;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.bean.NewsData;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.model.network
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/16 14
 */
public class ApiManage {

    public static void getNewsChannel(Context context) {
        NetworkClient.createApi(context).
                getNewsChannel("cec4e963be2a3073785eeaa9c3aa237f").
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
                            for (int i = 0; i < list.size(); i++) {
                                NewsChannel.ShowapiResBodyEntity.ChannelListEntity entity = list.get(i);
                                Log.d("denghang", i + ": entity" + entity.toString());
                            }
                        }
                    }
                });
    }

    public static void getNewsDataByChannel(Context context) {
        NetworkClient.createApi(context).getNewsData("cec4e963be2a3073785eeaa9c3aa237f", "5572a108b3cdc86cf39001cd", "1").
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
                                for (int i = 0; i < contentlist.size(); i++) {
                                    NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity contentlistEntity = contentlist.get(i);
                                    String title = contentlistEntity.getTitle();
                                    Log.d("denghang",title);
                                }
                            }
                        }
                    }
                });
    }
}
