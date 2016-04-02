package yzxmz.com.cn.news.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yzxmz.com.cn.news.R;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.ui.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity implements MainUserInterface {
    @Bind(R.id.toolbar_main)
    Toolbar mToolbar;
    @Bind(R.id.tabLayout_main)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager_main)
    ViewPager mViewPager;
    private MainAdapter adapter;
    private List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> mList;

    private MainPresenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void updateChannels(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> channels) {
        mList = channels;
        adapter = new MainAdapter(getSupportFragmentManager(), mList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}