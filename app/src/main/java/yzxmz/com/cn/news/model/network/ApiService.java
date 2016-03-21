package yzxmz.com.cn.news.model.network;


import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.bean.NewsData;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.network
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/16 14
 */
public interface ApiService {

    @GET("channel_news")
    Observable<NewsChannel> getNewsChannel(@Header("apikey") String apikey);

    @GET("search_news")
    Observable<NewsData> getNewsData(@Header("apikey") String apikey , @Query("channelId") String channelId ,@Query("page") String page);

}
