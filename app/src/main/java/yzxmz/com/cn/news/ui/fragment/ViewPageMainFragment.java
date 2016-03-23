package yzxmz.com.cn.news.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.SuperRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yzxmz.com.cn.news.R;
import yzxmz.com.cn.news.model.bean.NewsData;
import yzxmz.com.cn.news.model.network.ApiManage;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.ui.fragment
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/23 09
 */
public class ViewPageMainFragment extends Fragment {

    @Bind(R.id.news_list)
    SuperRecyclerView mRecyclerView;
    private String channelId;
    private String page;
    private List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> mData;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = View.inflate(getContext(), R.layout.fragment_main_news,null);
        ButterKnife.bind(this, rootView);
        EventBus.getDefault().register(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //initData();
    }

    private void initData() {
        ApiManage.getNewsDataByChannel(getContext(), channelId, page);
    }

    @Subscribe
    public void onEventMainThread(List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> contentlist) {
        if (contentlist != null) {
            mData = contentlist;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
