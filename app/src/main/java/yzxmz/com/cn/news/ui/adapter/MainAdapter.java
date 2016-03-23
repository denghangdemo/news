package yzxmz.com.cn.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import yzxmz.com.cn.news.model.bean.NewsChannel;
import yzxmz.com.cn.news.ui.fragment.ViewPageMainFragment;

/**
 * @author denghang
 * @version V1.0
 * @Package yzxmz.com.cn.news.ui.adapter
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/3/23 09
 */
public class MainAdapter extends FragmentStatePagerAdapter {

    private List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> mData;

    public MainAdapter(FragmentManager fm,List<NewsChannel.ShowapiResBodyEntity.ChannelListEntity> list) {
        super(fm);
        mData = list;
    }


    @Override
    public Fragment getItem(int position) {
        return new ViewPageMainFragment();
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String name = mData.get(position).getName();
        return name.substring(0, name.length() - 2);
    }

}
