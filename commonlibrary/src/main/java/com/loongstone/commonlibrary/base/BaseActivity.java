package com.loongstone.commonlibrary.base;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.loongstone.commonlibrary.BuildConfig;
import com.loongstone.commonlibrary.R;
import com.loongstone.commonlibrary.base.mvp.BaseModel;
import com.loongstone.commonlibrary.base.mvp.BasePresenter;
import com.loongstone.commonlibrary.base.app.AppManager;
import com.loongstone.commonlibrary.utils.ClassCastUtil;
import com.loongstone.commonlibrary.utils.ToastUitl;
import com.loongstone.commonlibrary.widget.LoadingDialog;
import com.loongstone.commonlibrary.widget.StatusBarCompat;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基类
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * 使用例子
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 */

/***************使用例子*********************/

/**
 * //1.mvp模式
 * //public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //        mPresenter.setVM(this, mModel);
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 * //}
 * //2.普通模式
 * //public class SampleActivity extends BaseActivity {
 * //    @Override
 * //    public int getLayoutId() {
 * //        return R.layout.activity_news_channel;
 * //    }
 * //
 * //    @Override
 * //    public void initPresenter() {
 * //    }
 * //
 * //    @Override
 * //    public void initView() {
 * //    }
 */

/**
 * @author loongstone
 * @date 2017/12/1 14:49
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public E mModel;
    public Context mContext;
    private boolean isConfigChange = false;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isConfigChange = false;
        if (usingEventBus()) {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = ClassCastUtil.getT(this, 0);
        mModel = ClassCastUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        this.initPresenter();
        this.initView();
    }

    public boolean usingEventBus() {
        return false;
    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        //设置昼夜主题
        initTheme();
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 默认着色状态栏
        setStatusBarColor();

    }

    /*********************子类实现*****************************/
    /**
     * 获取布局文件
     * @return int 布局
     */
    public abstract int getLayoutId();

    /**
     *
     *简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    public abstract void initPresenter();

    /**
     * 初始化view
     */
    public abstract void initView();

    /**
     * 设置主题
     */
    private void initTheme() {
        //ChangeModeController.setTheme(this, R.style.DayTheme, R.style.NightTheme);
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void setStatusBarColor() {
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.main_status_bar_color));
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void setStatusBarColor(int color) {
        StatusBarCompat.setStatusBarColor(this, color);
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void setTranslanteBar() {
        StatusBarCompat.translucentStatusBar(this);
    }


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
        intent.setClass(this, cls);
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
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 开启浮动加载进度条
     */
    public void startProgressDialog() {
        LoadingDialog.showDialogForLoading(this);
    }

    /**
     * 开启浮动加载进度条
     *
     * @param msg
     */
    public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(this, msg, true);
    }

    /**
     * 停止浮动加载进度条
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

    /**
     * 带图片的toast
     *
     * @param text
     * @param res
     */
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
    protected void onResume() {
        super.onResume();
        //debug版本不统计crash
        if (!BuildConfig.LOG_DEBUG) {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //debug版本不统计crash
        if (!BuildConfig.LOG_DEBUG) {
            //友盟统计
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        if (!isConfigChange) {
            AppManager.getAppManager().finishActivity(this);
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (usingEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }
}
