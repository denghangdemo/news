package yzxmz.com.cn.news.model.network;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.network
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/16 14
 */
public class OkHttpHelper {

    private static final long CONNECTTIMEOUT = 5000;  // 连接时间
    private static final long READTIMEOUT = 5000;  // read超时时间
    private static final long WRITETIMEOUT = 5000; // writer超时时间
    private static final int MAXCACHERSIZE = 10 * 1024 * 1024; // 缓存文件的大小
    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient createClient(Context context) {
        if (mOkHttpClient == null) {
            synchronized (OkHttpHelper.class) {
                if (mOkHttpClient == null) {
                    File cache = new File(context.getCacheDir(), "responses");
                    mOkHttpClient = new OkHttpClient()
                            .newBuilder()
                            .connectTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(READTIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITETIMEOUT, TimeUnit.SECONDS)
                            .cache(new Cache(cache, MAXCACHERSIZE))
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request().newBuilder().addHeader("apikey","cec4e963be2a3073785eeaa9c3aa237f").build();
                                    return chain.proceed(request);
                                }
                            })
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

}
