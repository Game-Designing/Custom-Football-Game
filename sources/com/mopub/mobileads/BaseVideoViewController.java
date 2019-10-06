package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public abstract class BaseVideoViewController {

    /* renamed from: a */
    private final Context f34701a;

    /* renamed from: b */
    private final RelativeLayout f34702b = new RelativeLayout(this.f34701a);

    /* renamed from: c */
    private final BaseVideoViewControllerListener f34703c;

    /* renamed from: d */
    private Long f34704d;

    public interface BaseVideoViewControllerListener {
        void onFinish();

        void onSetContentView(View view);

        void onSetRequestedOrientation(int i);

        void onStartActivityForResult(Class<? extends Activity> cls, int i, Bundle bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo36925a(Configuration configuration);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo36926a(Bundle bundle);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract VideoView mo36932c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo36933d();

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract void mo36935f();

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract void mo36936g();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract void mo36938h();

    protected BaseVideoViewController(Context context, Long broadcastIdentifier, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        Preconditions.checkNotNull(baseVideoViewControllerListener);
        this.f34701a = context;
        this.f34704d = broadcastIdentifier;
        this.f34703c = baseVideoViewControllerListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo36934e() {
        LayoutParams adViewLayout = new LayoutParams(-1, -2);
        adViewLayout.addRule(13);
        this.f34702b.addView(mo36932c(), 0, adViewLayout);
        this.f34703c.onSetContentView(this.f34702b);
    }

    public boolean backButtonEnabled() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36924a(int requestCode, int resultCode, Intent data) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public BaseVideoViewControllerListener mo36923a() {
        return this.f34703c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Context mo36929b() {
        return this.f34701a;
    }

    public ViewGroup getLayout() {
        return this.f34702b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36930b(boolean shouldFinish) {
        MoPubLog.log(SdkLogEvent.CUSTOM, "Video cannot be played.");
        mo36927a(IntentActions.ACTION_INTERSTITIAL_FAIL);
        if (shouldFinish) {
            this.f34703c.onFinish();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36928a(boolean shouldFinish) {
        if (shouldFinish) {
            this.f34703c.onFinish();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36927a(String action) {
        Long l = this.f34704d;
        if (l != null) {
            BaseBroadcastReceiver.broadcastAction(this.f34701a, l.longValue(), action);
            return;
        }
        MoPubLog.log(SdkLogEvent.CUSTOM, "Tried to broadcast a video event without a broadcast identifier to send to.");
    }
}
