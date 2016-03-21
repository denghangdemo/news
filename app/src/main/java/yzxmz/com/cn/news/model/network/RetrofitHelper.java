package yzxmz.com.cn.news.model.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.network
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/16 14
 */
public class RetrofitHelper {
    private static final String BASEURL = "http://apis.baidu.com/showapi_open_bus/channel_news/";
    private static Retrofit mRetrofit;

    public static Retrofit createInstance(Context context) {
        if (mRetrofit == null) {
            synchronized (RetrofitHelper.class) {
                if (mRetrofit == null) {
                    mRetrofit = new Retrofit.Builder().
                            baseUrl(BASEURL).
                            client(OkHttpHelper.createClient(context)).
                            addConverterFactory(GsonConverterFactory.create()).
                            addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                            build();
                }
            }
        }
        return mRetrofit;
    }
}
