package yzxmz.com.cn.news.model.network;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.bean.NewsData;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.network
 * @Description: 使用okhttp的拦截器添加header头
 * @date 2016/3/16 14
 */
public interface ApiService {

    /**
     * @des 获取频道
     * @return
     */
    @GET("channel_news")
    Observable<NewsChannel> getNewsChannel();

    /**
     * @des 获取具体频道的新闻条目
     * @param channelId  频道 ID
     * @param page 页面 1
     * @return
     */
    @GET("search_news")
    Observable<NewsData> getNewsData(@Query("channelId") String channelId ,@Query("page") String page);

}
