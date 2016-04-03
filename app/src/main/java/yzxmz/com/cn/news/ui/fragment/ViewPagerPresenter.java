package yzxmz.com.cn.news.ui.fragment;

import android.content.Context;

import java.util.List;

import rx.Observer;
import yzxmz.com.cn.news.model.bean.NewsData;
import yzxmz.com.cn.news.model.network.ApiManage;

/**
 * Created by dengh on 2016/4/3.
 */
public class ViewPagerPresenter {
    private ViewPagerView mViewPagerView;

    public ViewPagerPresenter(ViewPagerView viewPagerView) {
        mViewPagerView = viewPagerView;
    }

    public void getContentNews(Context context,String channelId,int page) {
        ApiManage.getNewsDataByChannel(context, channelId, page).subscribe(new Observer<List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> list) {
                mViewPagerView.showListItem(list);
            }
        });
    }
}
