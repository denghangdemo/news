package yzxmz.com.cn.news.model.network;

import android.content.Context;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.model.network
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/16 15
 */
public class NetworkClient {

    public static ApiService createApi(Context context){
        return RetrofitHelper.createInstance(context).create(ApiService.class);
    }
}
