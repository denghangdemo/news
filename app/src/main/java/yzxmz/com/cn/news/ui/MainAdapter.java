package yzxmz.com.cn.news.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import yzxmz.com.cn.news.model.bean.NewsChannel;

/**
 * Created by dengh on 2016/3/22.
 */
public class MainAdapter extends FragmentStatePagerAdapter {

    private List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> mData;

    public void setData(List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> data) {
        mData = data;
    }

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String name = mData.get(position).getName();
        return name.substring(name.length(), name.length() - 2);
    }


}
