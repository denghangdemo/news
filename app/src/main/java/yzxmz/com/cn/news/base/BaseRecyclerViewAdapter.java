package yzxmz.com.cn.news.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author denghang
 * @version V1.0
 * @Package com.smarthome.shlauncher.base
 * @Description: recyclerview 的基础类
 * @date 2016/1/8 15
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder<T>> {

    private List<T> mData;

    public BaseRecyclerViewAdapter(List<T> data) {
        mData = data;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getSpecificHolder();
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, final int position) {
        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClickListener(v, position);
                }
            });
        }
        holder.setDataAndRefreshHolderView(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    protected abstract BaseRecyclerViewHolder<T> getSpecificHolder();

    public interface ItemClickListener {
        void onItemClickListener(View view, int position);
    }

    private ItemClickListener mItemClickListener;

    public void setOnItemClickListener(ItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setData(List<T> data) {
        mData = data;
    }

}
