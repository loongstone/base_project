package com.loongstone.commonlibrary.base.mvp;

import android.content.Context;

import com.loongstone.commonlibrary.rx.RxManager;

/**
 * 基类presenter
 *
 * @author loongstone
 * @date 2017/12/3 14:34
 */
public abstract class BasePresenter<T, E> {
    public RxManager mRxManage = new RxManager();
    public Context mContext;
    public E mModel;
    public T mView;

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart() {
    }

    public void onDestroy() {
        mRxManage.clear();
    }
}
