package yzxmz.com.cn.news.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.SuperRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yzxmz.com.cn.news.R;
import yzxmz.com.cn.news.model.bean.NewsData;
import yzxmz.com.cn.news.model.event.ContentlistEvent;
import yzxmz.com.cn.news.model.network.ApiManage;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.ui.fragment
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/23 09
 */
public class ViewPageMainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.news_list)
    SuperRecyclerView mRecyclerView;
    private int page;
    private List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> mData;
    private View mRootView;

    public static ViewPageMainFragment newInstance(Bundle args) {
        ViewPageMainFragment viewPageMainFragment = new ViewPageMainFragment();
        viewPageMainFragment.setArguments(args);
        return viewPageMainFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = View.inflate(getContext(), R.layout.fragment_main_news, null);
            ButterKnife.bind(this, mRootView);
        }
        EventBus.getDefault().register(this);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

        initListener();
    }

    private void initListener() {
        mRecyclerView.setRefreshListener(this);
    }

    private void initData() {
        Bundle arguments = getArguments();
        String channelId = arguments.getString("channelId");
        ApiManage.getNewsDataByChannel(getContext(), channelId, page);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserEvent(ContentlistEvent contentlist) {
        if (contentlist != null) {
            mData = contentlist.list;
            for (NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity data : mData) {
                Log.d("denghang",data.getTitle());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRefresh() {
        page = 1;
        initData();
    }
}
