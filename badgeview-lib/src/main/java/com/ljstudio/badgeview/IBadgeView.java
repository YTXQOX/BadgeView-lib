package com.ljstudio.badgeview;


public interface IBadgeView {
    /**
     * 设置数值
     *
     * @param count
     * @return
     */
    com.ljstudio.badgeview.BadgeViewUtil setBadgeCount(int count);

    /**
     * 设置是否显示
     *
     * @param isShowBadge
     * @return
     */
    com.ljstudio.badgeview.BadgeViewUtil setBadgeShown(boolean isShowBadge);

    /**
     * 设置小点颜色
     *
     * @param color
     * @return
     */
    com.ljstudio.badgeview.BadgeViewUtil setBadgeColor(int color);

    /**
     * 设置视图上边距
     *
     * @param mDefaultTopPadding
     * @return
     */
    com.ljstudio.badgeview.BadgeViewUtil setmDefaultTopPadding(int mDefaultTopPadding);

    /**
     * 设置视图右边距
     *
     * @param mDefaultRightPadding
     * @return
     */
    com.ljstudio.badgeview.BadgeViewUtil setmDefaultRightPadding(int mDefaultRightPadding);
}
