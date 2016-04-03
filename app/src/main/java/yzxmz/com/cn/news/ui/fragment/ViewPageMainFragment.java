package yzxmz.com.cn.news.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yzxmz.com.cn.news.R;
import yzxmz.com.cn.news.model.bean.NewsData;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.ui.fragment
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/23 09
 */
public class ViewPageMainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener ,ViewPagerView{

    @Bind(R.id.news_list)
    SuperRecyclerView mRecyclerView;
    private int page = 1;
    private View mRootView;
    private ViewPagerPresenter mPresenter = new ViewPagerPresenter(this);

    public static ViewPageMainFragment newInstance(Bundle args) {
        ViewPageMainFragment viewPageMainFragment = new ViewPageMainFragment();
        viewPageMainFragment.setArguments(args);
        return viewPageMainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = View.inflate(getContext(), R.layout.fragment_main_news, null);
            ButterKnife.bind(this, mRootView);
            initView();
        }
        return mRootView;
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
        initListener();
    }

    private void initListener() {
        mRecyclerView.setRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        // 初始化加载第一页的数据
        initData();
    }

    private void initData() {
        Bundle arguments = getArguments();
        String channelId = arguments.getString("channelId");
        mPresenter.getContentNews(getContext(),channelId,page);
    }

    @Override
    public void showListItem(List<NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> list) {
        for (NewsData.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity data : list) {
            Log.d("denghang",data.getTitle());
        }
    }
}
