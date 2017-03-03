package com.liuguangqiang.cookie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Eric on 2017/3/2.
 */
public class Cookie extends LinearLayout {

    private static final String TAG = "cookie";

    private boolean hasMeasured = false;
    private Animation slideInAnimation;
    private Animation slideOutAnimation;

    private LinearLayout layoutCookie;
    private TextView tvTitle;
    private TextView tvMessage;
    private ImageView ivIcon;
    private TextView btnAction;
    private long duration = 1000;
    private int overshootMargin = 0;
    private int layoutGravity = Gravity.BOTTOM;

    public Cookie(@NonNull final Context context) {
        this(context, null);
    }

    public Cookie(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Cookie(@NonNull final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        overshootMargin = getContext().getResources().getDimensionPixelSize(R.dimen.overshoot_margin);
        inflate(getContext(), R.layout.layout_cookie, this);

        setHapticFeedbackEnabled(true);
        createInAnim();
        createOutAnim();

        layoutCookie = (LinearLayout) findViewById(R.id.cookie);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        ivIcon = (ImageView) findViewById(R.id.iv_icon);
        btnAction = (TextView) findViewById(R.id.btn_action);
    }

    public void setParams(final CookieBar.Params params) {
        if (params != null) {
            duration = params.duration;
            layoutGravity = params.layoutGravity;

            if (!TextUtils.isEmpty(params.title)) {
                tvTitle.setVisibility(VISIBLE);
                tvTitle.setText(params.title);
            }

            if (!TextUtils.isEmpty(params.message)) {
                tvMessage.setVisibility(VISIBLE);
                tvMessage.setText(params.message);
            }

            if (!TextUtils.isEmpty(params.action) && params.onActionClickListener != null) {
                btnAction.setVisibility(VISIBLE);
                btnAction.setText(params.action);
                btnAction.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        params.onActionClickListener.onClick();
                        dismiss();
                    }
                });
            }

            if (params.iconResId != 0) {
                ivIcon.setVisibility(VISIBLE);
                ivIcon.setBackgroundResource(params.iconResId);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (layoutGravity == Gravity.TOP) {
            super.onLayout(changed, l, 0, r, layoutCookie.getMeasuredHeight());
        } else {
            super.onLayout(changed, l, t, r, b);
        }
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!hasMeasured) {
            hasMeasured = true;
            final ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
            params.topMargin = overshootMargin;
            requestLayout();
        }
    }

    private void createInAnim() {
        slideInAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.alerter_slide_in_from_top);
        slideInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismiss();
                    }
                }, duration);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        setAnimation(slideInAnimation);
    }

    private void createOutAnim() {
        slideOutAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.alerter_slide_out_to_top);
        slideOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void dismiss() {
        slideOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(final Animation animation) {
            }

            @Override
            public void onAnimationEnd(final Animation animation) {
                Log.i(TAG, "remove the cookie from its parent");
                destroy();
            }

            @Override
            public void onAnimationRepeat(final Animation animation) {
            }
        });
        startAnimation(slideOutAnimation);
    }

    private void destroy() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewParent parent = getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(Cookie.this);
                }
            }
        }, 200);
    }

}
