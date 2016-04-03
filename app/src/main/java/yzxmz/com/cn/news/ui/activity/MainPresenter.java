package yzxmz.com.cn.news.ui.activity;

import android.content.Context;

import java.util.List;

import rx.Observer;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.network.ApiManage;

/**
 * Created by dengh on 2016/4/3.
 */
public class MainPresenter {
    private MainView mView;

    public MainPresenter(MainView view) {
        mView = view;
    }

    public void getTabHostData(Context context) {
        ApiManage.getNewsChannel(context).
                subscribe(new Observer<List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list) {
                        mView.showTabHost(list);
                    }
                });
    }
}
