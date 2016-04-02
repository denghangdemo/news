package yzxmz.com.cn.news.ui.activities;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import yzxmz.com.cn.news.model.event.ChannelEvent;
import yzxmz.com.cn.news.model.network.ApiManage;

class MainPresenter {
    private final MainUserInterface userInterface;

    MainPresenter(MainUserInterface userInterface) {
        this.userInterface = userInterface;
    }

    void onCreate() {
        ApiManage.getNewsChannel(userInterface.getContext());
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChannelsUpdated(ChannelEvent event) {
        userInterface.updateChannels(event.list);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }
}
