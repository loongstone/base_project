package com.loongstone.commonlibrary.rx;

import org.greenrobot.eventbus.Subscribe;
import org.reactivestreams.Subscription;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


/**
 * 用于管理单个presenter的 RxJava 相关代码的生命周期处理
 *
 * @author loongstone
 * @date 2017/12/1 15:05
 */
public class RxManager {
    /**
     * 管理Observables 和 Subscribers订阅
     */
    private CompositeDisposable mCompositeSubscription = new CompositeDisposable();

    /**
     * 单纯的Observables 和 Subscribers管理
     *
     * @param m
     */
    public void add(Disposable m) {
        //订阅管理
        mCompositeSubscription.add(m);
    }

    /**
     * 单个presenter生命周期结束，取消订阅
     */
    public void clear() {
        // 取消所有订阅
        mCompositeSubscription.clear();
    }
}
