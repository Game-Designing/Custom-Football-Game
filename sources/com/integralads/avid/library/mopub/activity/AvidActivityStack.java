package com.integralads.avid.library.mopub.activity;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.integralads.avid.library.mopub.weakreference.AvidActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvidActivityStack {
    private static AvidActivityStack avidActivityStackInstance = new AvidActivityStack();
    private final ArrayList<AvidActivity> activities = new ArrayList<>();

    public static AvidActivityStack getInstance() {
        return avidActivityStackInstance;
    }

    public void addActivity(Activity activity) {
        if (find(activity) == null) {
            this.activities.add(new AvidActivity(activity));
        }
    }

    public List<View> getRootViews() {
        ArrayList<View> views = new ArrayList<>();
        View rootView = null;
        Iterator<AvidActivity> it = this.activities.iterator();
        while (it.hasNext()) {
            AvidActivity avidActivity = (AvidActivity) it.next();
            if (isFinished(avidActivity)) {
                it.remove();
            } else {
                View view = getRootView(avidActivity);
                if (view != null) {
                    rootView = view;
                }
            }
        }
        if (rootView != null) {
            views.add(rootView);
        }
        return views;
    }

    public void cleanup() {
        this.activities.clear();
    }

    /* access modifiers changed from: 0000 */
    public AvidActivity find(Activity activity) {
        Iterator it = this.activities.iterator();
        while (it.hasNext()) {
            AvidActivity avidActivity = (AvidActivity) it.next();
            if (avidActivity.contains(activity)) {
                return avidActivity;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public List<AvidActivity> getActivities() {
        return this.activities;
    }

    /* access modifiers changed from: 0000 */
    public boolean isFinished(AvidActivity avidActivity) {
        Activity activity = (Activity) avidActivity.get();
        if (activity == null) {
            return true;
        }
        if (VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        return activity.isFinishing();
    }

    private View getRootView(AvidActivity avidActivity) {
        Activity activity = (Activity) avidActivity.get();
        View view = null;
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window == null || !activity.hasWindowFocus()) {
            return null;
        }
        View rootView = window.getDecorView();
        if (rootView != null && rootView.isShown()) {
            view = rootView;
        }
        return view;
    }

    static void setAvidActivityStackInstance(AvidActivityStack instance) {
        avidActivityStackInstance = instance;
    }
}
