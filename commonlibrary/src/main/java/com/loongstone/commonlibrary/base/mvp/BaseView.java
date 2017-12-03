package com.loongstone.commonlibrary.base.mvp;

/**
 * View实现 对用户基本提示对的界面,如加载中,错误提示,以便Presenter逻辑调用
 *
 * @author loongstone
 * @date 2017/12/3 14:34
 */
public interface BaseView {
    /**
     * 显示加载界面
     *
     * @param title 标题
     */
    void showLoading(String title);

    /**
     * 停止加载界面
     */
    void stopLoading();

    /**
     * 显示错误提示,提示应当可以自行消失或者用户进行简单关闭使它消失
     *
     * @param msg 错误提示内容
     */
    void showErrorTip(String msg);
}
