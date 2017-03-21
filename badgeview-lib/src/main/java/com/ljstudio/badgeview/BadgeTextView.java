package com.ljstudio.badgeview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabWidget;

import com.zhy.autolayout.AutoFrameLayout;


public class BadgeTextView extends android.support.v7.widget.AppCompatTextView implements com.ljstudio.badgeview.IBadgeView {

    /**
     * 红点
     */
    private com.ljstudio.badgeview.BadgeViewUtil mBaseBadgeView;

    public BadgeTextView(Context context) {
        this(context, null);
    }

    public BadgeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public BadgeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mBaseBadgeView = new BadgeViewUtil(this, context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBaseBadgeView.onSizeChanged(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBaseBadgeView.draw(canvas);
    }

    @Override
    public BadgeViewUtil setBadgeCount(int count) {
        return mBaseBadgeView.setCount(count);
    }

    @Override
    public BadgeViewUtil setBadgeShown(boolean isShowBadge) {
        return mBaseBadgeView.setShown(isShowBadge);
    }

    @Override
    public BadgeViewUtil setBadgeColor(int color) {
        return mBaseBadgeView.setBackgroundColor(color);
    }

    @Override
    public BadgeViewUtil setmDefaultTopPadding(int mDefaultTopPadding) {
        return mBaseBadgeView.setmDefaultTopPadding(mDefaultTopPadding);
    }

    @Override
    public BadgeViewUtil setmDefaultRightPadding(int mDefaultRightPadding) {
        return mBaseBadgeView.setmDefaultRightPadding(mDefaultRightPadding);
    }

    /*
     * Attach the BadgeView to the TabWidget
     *
     * @param target the TabWidget to attach the BadgeView
     *
     * @param tabIndex index of the tab
     */
    public void setTargetView(TabWidget target, int tabIndex) {
        View tabView = target.getChildTabViewAt(tabIndex);
        setTargetView(tabView);
    }

    /*
     * Attach the BadgeView to the target view
     *
     * @param target the view to attach the BadgeView
     */
    public void setTargetView(View target) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }

        if (target == null) {
            return;
        }

        if (target.getParent() instanceof AutoFrameLayout) {
            ((AutoFrameLayout) target.getParent()).addView(this);

        } else if (target.getParent() instanceof ViewGroup) {
            // use a new FrameLayout container for adding badge view
            ViewGroup parentContainer = (ViewGroup) target.getParent();
            int groupIndex = parentContainer.indexOfChild(target);
            parentContainer.removeView(target);

            AutoFrameLayout badgeContainer = new AutoFrameLayout(getContext());
            ViewGroup.LayoutParams parentLayoutParams = target.getLayoutParams();

            badgeContainer.setLayoutParams(parentLayoutParams);

            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            target.setLayoutParams(params);

            parentContainer.addView(badgeContainer, groupIndex, parentLayoutParams);
            badgeContainer.addView(target);

            badgeContainer.addView(this);
        } else if (target.getParent() == null) {
            Log.e(getClass().getSimpleName(), "ParentView is needed");
        }

    }

}
