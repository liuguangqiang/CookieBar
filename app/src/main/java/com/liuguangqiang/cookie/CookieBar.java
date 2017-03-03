package com.liuguangqiang.cookie;

import android.app.Activity;
import android.view.ViewGroup;

/**
 * Created by Eric on 2017/3/2.
 */
public class CookieBar {

    private static final String TAG = "cookie";

    private Cookie cookieView;
    private Activity context;

    private CookieBar() {
    }

    private CookieBar(Activity context, Params params) {
        this.context = context;
        cookieView = new Cookie(context);
        cookieView.setParams(params);
    }

    public void show() {
        if (cookieView != null) {
            final ViewGroup decorView = (ViewGroup) context.getWindow().getDecorView();
            if (cookieView.getParent() == null) {
                decorView.addView(cookieView);
            }
        }
    }

    public static class Builder {

        private Params params = new Params();

        public Activity context;

        public Builder(Activity activity) {
            this.context = activity;
        }

        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            params.message = message;
            return this;
        }

        public Builder setDuration(long duration) {
            params.duration = duration;
            return this;
        }

        public Builder setAction(String action, OnActionClickListener onActionClickListener) {
            params.action = action;
            params.onActionClickListener = onActionClickListener;
            return this;
        }

        public Builder setLayoutGravity(int layoutGravity) {
            params.layoutGravity = layoutGravity;
            return this;
        }

        public CookieBar create() {
            CookieBar cookie = new CookieBar(context, params);
            return cookie;
        }

        public CookieBar show() {
            final CookieBar cookie = create();
            cookie.show();
            return cookie;
        }

    }

    public static class Params {

        public String title;

        public String message;

        public String action;

        public OnActionClickListener onActionClickListener;

        public int iconResId;

        public long duration = 1200;

        public int layoutGravity;

    }

}
