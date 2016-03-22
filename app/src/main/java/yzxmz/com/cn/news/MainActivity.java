package yzxmz.com.cn.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import yzxmz.com.cn.news.model.event.ChannelEvent;
import yzxmz.com.cn.news.model.network.ApiManage;
import yzxmz.com.cn.news.ui.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_main)
    Toolbar mToolbar;
    @Bind(R.id.tabLayout_main)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager_main)
    ViewPager mViewPager;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
        initData();
        initListener();
    }

    private void initListener() {

    }

    private void initData() {
        ApiManage.getNewsChannel(getApplicationContext());
    }

    private void initView() {
        initToolbar();
<<<<<<< cf9fa59302f7cc39faad096c42ccad293ad15b1c

=======
        mViewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
>>>>>>> 图片
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("");
<<<<<<< cf9fa59302f7cc39faad096c42ccad293ad15b1c
=======
        mToolbar.setLogo(R.mipmap.icon_lanmu_search);
>>>>>>> 图片
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserEvent(ChannelEvent event) {
        if (event != null) {
            event.list.toString();
            mAdapter = new MainAdapter(getSupportFragmentManager(),event.list);
            mViewPager.setAdapter(mAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
