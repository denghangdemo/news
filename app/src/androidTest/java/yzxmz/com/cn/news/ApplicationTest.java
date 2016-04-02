package yzxmz.com.cn.news;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import rx.Observer;
import yzxmz.com.cn.news.model.DataManager;
import yzxmz.com.cn.news.model.database.DatabaseHelper;
import yzxmz.com.cn.news.model.database.domain.NewsChannelData;
import yzxmz.com.cn.news.model.network.ApiManage;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testChannel(){
        DataManager.getNewsChannel(getContext());
    }

    public void testGetChannel() {
        DatabaseHelper.findChannelData().subscribe(new Observer<NewsChannelData>() {
            @Override
            public void onCompleted() {
                Log.d("denghang", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("denghang", "onError");
            }

            @Override
            public void onNext(NewsChannelData newsChannelData) {
                String name = newsChannelData.getName();
                Log.d("denghang", name);
            }
        });
    }

    public void testNewsData(){
        DataManager.getNewsDataByChannel(getContext(), "5572a108b3cdc86cf39001cd", 1);
    }

    public void testNewChannel() {
        ApiManage.getNewsChannel(getContext());
    }
}