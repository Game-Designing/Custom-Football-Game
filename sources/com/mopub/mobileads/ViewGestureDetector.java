package com.mopub.mobileads;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;

public class ViewGestureDetector extends GestureDetector {

    /* renamed from: a */
    private final View f35119a;

    /* renamed from: b */
    private AdAlertGestureListener f35120b;

    public ViewGestureDetector(Context context, View view, AdReport adReport) {
        this(context, view, new AdAlertGestureListener(view, adReport));
    }

    private ViewGestureDetector(Context context, View view, AdAlertGestureListener adAlertGestureListener) {
        super(context, adAlertGestureListener);
        this.f35120b = adAlertGestureListener;
        this.f35119a = view;
        setIsLongpressEnabled(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean result = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f35120b.mo36847a();
        } else if (action == 2 && !m37691a(motionEvent, this.f35119a)) {
            mo37395a();
        }
        return result;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37395a() {
        this.f35120b.mo36850d();
    }

    /* renamed from: a */
    private boolean m37691a(MotionEvent motionEvent, View view) {
        boolean z = false;
        if (motionEvent == null || view == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (x >= 0.0f && x <= ((float) view.getWidth()) && y >= 0.0f && y <= ((float) view.getHeight())) {
            z = true;
        }
        return z;
    }

    public void onResetUserClick() {
        this.f35120b.mo36849c();
    }

    public boolean isClicked() {
        return this.f35120b.mo36848b();
    }

    @VisibleForTesting
    public void setClicked(boolean clicked) {
        this.f35120b.f34636k = clicked;
    }
}
