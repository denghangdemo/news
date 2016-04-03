package yzxmz.com.cn.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.ui.activity.MainPresenter;
import yzxmz.com.cn.news.ui.activity.MainView;
import yzxmz.com.cn.news.ui.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.toolbar_main)
    Toolbar mToolbar;
    @Bind(R.id.tabLayout_main)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager_main)
    ViewPager mViewPager;
    private MainAdapter mAdapter;
    private MainPresenter mPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.getTabHostData(getApplicationContext());
    }

    private void initView() {
        mToolbar.setTitle("");
        mToolbar.setLogo(R.mipmap.icon_lanmu_search);
        setSupportActionBar(mToolbar);
    }

    @Override
    public void showTabHost(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list) {
        mAdapter = new MainAdapter(getSupportFragmentManager(), list);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
