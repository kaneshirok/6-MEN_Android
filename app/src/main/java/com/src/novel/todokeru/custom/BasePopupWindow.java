package com.src.novel.todokeru.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 */
public abstract class BasePopupWindow extends PopupWindow {

    private static final int SPACE = 80;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected View mPopupFocusView;
    public BasePopupWindow(Context context, View popupFocusView) {
        super(context);

        // Viewの設定
        mContext = context;
        mPopupFocusView = popupFocusView;
        mInflater = LayoutInflater.from(mContext);

        // サイズ設定
        setDispDpHeight(getPopupWindowHeight());
        setDispDpWidth(getPopupWindowWidth());

        // 背景色設定
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Popup外タップで閉じる
        setOutsideTouchable(true);
    }

    /**
     * 横幅指定用のAbstractメソッド
     *
     * @return int Width
     */
    public abstract int getPopupWindowWidth();

    /**
     * 縦幅指定用のAbstractメソッド
     *
     * @return int height
     */
    public abstract int getPopupWindowHeight();

    /**
     * ポップアップの
     *
     * @return PopupFocusType
     */
    public abstract PopupFocusType getPopupFocusType();

    /**
     * 横幅指定
     * DP計算にする
     *
     * @param width int
     */
    public void setDispDpWidth(int width) {
        if (width != ViewGroup.LayoutParams.MATCH_PARENT &&
                width != ViewGroup.LayoutParams.WRAP_CONTENT) {
            setWidth(getDp(width));
        }
        setWidth(width);
    }

    /**
     * 縦幅指定
     * DP計算にする
     *
     * @param height int
     */
    public void setDispDpHeight(int height) {
        if (height != ViewGroup.LayoutParams.MATCH_PARENT &&
                height != ViewGroup.LayoutParams.WRAP_CONTENT) {
            setHeight(getDp(height));
        }
        setHeight(height);
    }

    /**
     * 横幅指定
     * DP計算にする
     *
     * @param width int
     */
    public void setDispPxWidth(int width) {
        if (width != ViewGroup.LayoutParams.MATCH_PARENT &&
                width != ViewGroup.LayoutParams.WRAP_CONTENT) {
            setWidth(width);
        }
        setWidth(width);
    }

    /**
     * 縦幅指定
     * DP計算にする
     *
     * @param height int
     */
    public void setDispPxHeight(int height) {
        if (height != ViewGroup.LayoutParams.MATCH_PARENT &&
                height != ViewGroup.LayoutParams.WRAP_CONTENT) {
            setHeight(height);
        }
        setHeight(height);
    }

    /**
     * PxからDPへ返却する
     *
     * @param px int
     * @return int dp
     */
    private int getDp(int px) {
        float density = mContext.getResources().getDisplayMetrics().density;
        // POPUP_WINDOW_SIZE を dp に変換する
        int dp = (int) (density * px);
        return dp;
    }

    /**
     * PopupWindow を表示するメソッド
     */
    public void show() {
        // フォーカス設定
        setFocusable(true);

        int offsetX = 0;
        int offsetY = 0;

        PopupFocusType focusType = getPopupFocusType();
        if (focusType == PopupFocusType.TOP) {
            offsetX = (int) mPopupFocusView.getX() - mPopupFocusView.getPaddingLeft();
            offsetY = (int) mPopupFocusView.getY() - (mPopupFocusView.getHeight() * 3);
        } else if (focusType == PopupFocusType.BOTTOM) {
            offsetX = (int) mPopupFocusView.getX() - mPopupFocusView.getPaddingLeft();
            offsetY = (int) mPopupFocusView.getY() - mPopupFocusView.getPaddingBottom();
        }

        showAsDropDown(mPopupFocusView, offsetX, offsetY);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        setFocusable(false);
    }

    /**
     * PopupWindowのフォーカスをどこに当てるかのタイプしてい
     * TOP -> フォーカスビューの上に出る
     * BOTTOM -> フォーカスビューの下に出る
     */
    protected enum PopupFocusType {
        TOP, BOTTOM
    }
}
