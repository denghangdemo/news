package yzxmz.com.cn.news.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author denghang
 * @version V1.0
 * @Package com.smarthome.shlauncher.base
 * @Description: (用一句话描述该文件做什么)
 * @date 2015/12/18 18
 */
public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    private T mData;

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public void setDataAndRefreshHolderView(T data) {
        mData = data;
        refreshHolderView(data);
    }

    protected abstract void refreshHolderView(T data);
}
