package com.src.novel.todokeru.custom;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.src.novel.todokeru.PicassoTransform;
import com.src.novel.todokeru.R;
import com.src.novel.todokeru.databinding.SearchPopupWindowBinding;
import com.src.novel.todokeru.model.Datum;
import com.src.novel.todokeru.model.User;

/**
 * 物件詳細お気に入りPopupWindow
 *
 * @author pdc-k-kamiya on 2015/09/18.
 */
public class SearchPopupWindow extends BasePopupWindow {

    SearchPopupWindowBinding mBinding;
    private User mUser;

    public SearchPopupWindow(final Context context, View popupFocusView, User user) {
        super(context, popupFocusView);
        mBinding = DataBindingUtil.inflate(mInflater, R.layout.search_popup_window, null, false);
        setContentView(mBinding.getRoot());
        mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        ImageView[] images = {
                mBinding.image1,
                mBinding.image2,
                mBinding.image3,
                mBinding.image4,
                mBinding.image5,
                mBinding.image6,
        };
        int i = 0;
        for (Datum datum : user.getData()) {
            images[i].setTag(datum);
            Picasso.with(context).load(datum.getUserImage())
                    .transform(new PicassoTransform()).into(images[i]);

            images[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Datum clickObject = (Datum)v.getTag();
                    mBinding.select.setVisibility(View.VISIBLE);
                    Picasso.with(context).load(clickObject.getUserImage())
                            .transform(new PicassoTransform()).into(mBinding.image);
                    mBinding.profile.setTag(clickObject);
                    mBinding.message.setTag(clickObject);
                }
            });
            i++;
        }
    }

    public void setProfile(View.OnClickListener profile) {
        mBinding.profile.setOnClickListener(profile);

    }

    public void setMessage(View.OnClickListener message) {
        mBinding.message.setOnClickListener(message);
    }

    @Override
    public PopupFocusType getPopupFocusType() {
        return PopupFocusType.BOTTOM;
    }

    @Override
    public int getPopupWindowWidth() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    @Override
    public int getPopupWindowHeight() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    @Override
    public void show() {
//        super.show();
        showAsDropDown(mPopupFocusView);
    }
}
