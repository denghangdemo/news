package yzxmz.com.cn.news;

import android.app.Application;
import android.test.ApplicationTestCase;

import yzxmz.com.cn.news.model.network.ApiManage;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testChannel(){
        ApiManage.getNewsChannel(getContext());
    }

    public void testNewsData(){
        ApiManage.getNewsDataByChannel(getContext(),"5572a108b3cdc86cf39001cd", 1);
    }
}