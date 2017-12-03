package com.loongstone.commonlibrary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.loongstone.commonlibrary.R;
import com.loongstone.commonlibrary.base.mvp.BaseModel;
import com.loongstone.commonlibrary.base.mvp.BasePresenter;
import com.loongstone.commonlibrary.utils.ClassCastUtil;
import com.loongstone.commonlibrary.utils.ToastUitl;
import com.loongstone.commonlibrary.widget.LoadingDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
//1.mvp模式
//public class SampleFragment extends BaseFragment<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleFragment extends BaseFragment {
//    @Override
//    public int getLayoutResource() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}

/**
 * @author loongstone
 * @date 2017/12/1 14:53
 */
public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {
    protected View rootView;
    public T mPresenter;
    public E mModel;
    private Unbinder unbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutResource(), container, false);
        }
        if (usingEventBus()) {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
        unbind = ButterKnife.bind(this, rootView);
        mPresenter = ClassCastUtil.getT(this, 0);
        mModel = ClassCastUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        initPresenter();
        initView(rootView);
        return rootView;
    }

    /**
     * EventBus
     */

    public boolean usingEventBus() {
        return false;
    }

    /**
     * 获取布局文件
     *
     * @return
     */
    protected abstract int getLayoutResource();

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    public abstract void initPresenter();

    /**
     * 初始化view
     * @param view rootView
     */
    protected abstract void initView(View view);


    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**
     * 开启加载进度条
     */
    public void startProgressDialog() {
        LoadingDialog.showDialogForLoading(getActivity());
    }

    /**
     * 开启加载进度条
     *
     * @param msg
     */
    public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(getActivity(), msg, true);
    }

    /**
     * 停止加载进度条
     */
    public void stopProgressDialog() {
        LoadingDialog.cancelDialogForLoading();
    }


    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text) {
        ToastUitl.showShort(text);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId) {
        ToastUitl.showShort(resId);
    }

    /**
     * 长时间显示Toast提示(来自res)
     **/
    public void showLongToast(int resId) {
        ToastUitl.showLong(resId);
    }

    /**
     * 长时间显示Toast提示(来自String)
     **/
    public void showLongToast(String text) {
        ToastUitl.showLong(text);
    }


    public void showToastWithImg(String text, int res) {
        ToastUitl.showToastWithImg(text, res);
    }

    /**
     * 网络访问错误提醒
     */
    public void showNetErrorTip() {
        ToastUitl.showToastWithImg(getText(R.string.net_error).toString(), R.drawable.ic_wifi_off);
    }

    public void showNetErrorTip(String error) {
        ToastUitl.showToastWithImg(error, R.drawable.ic_wifi_off);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbind != null) {
            unbind.unbind();
        }
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }

        if (usingEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }


}
