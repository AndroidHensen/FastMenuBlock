package com.handsome.menublock;

import android.view.View;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/12/6.
 */

public abstract class FastMenuAdapter {

    public abstract Object getView(int position);

    public abstract int getCount();

    public abstract String getTitle(int position);

    public abstract void onClick(int position);

    public View getHeaderView() {
        return null;
    }
}
