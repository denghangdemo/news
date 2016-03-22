package yzxmz.com.cn.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.model.network.ApiManage;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_main)
    Toolbar mToolbar;
    @Bind(R.id.tabLayout_main)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager_main)
    ViewPager mViewPager;
    private List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

        initData();
    }

    private void initData() {
        ApiManage.getNewsChannel(getApplicationContext());
    }

    private void initView() {
        setSupportActionBar(mToolbar);
    }

    @Subscribe
    public void onEventMainThread(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> event) {
        if (event != null) {

        }
    }
}
