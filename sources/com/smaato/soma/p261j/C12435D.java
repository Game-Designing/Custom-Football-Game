package com.smaato.soma.p261j;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.VideoView;
import com.moat.analytics.mobile.sma.NativeVideoTracker;
import com.smaato.soma.p239c.p242c.C12202o;
import com.smaato.soma.p239c.p243d.C12204a;
import com.smaato.soma.p239c.p253j.C12285d;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.smaato.soma.j.D */
/* compiled from: VASTView */
public class C12435D extends VideoView implements OnPreparedListener, OnCompletionListener, OnErrorListener, OnTouchListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C12285d f38820a;

    /* renamed from: b */
    Handler f38821b = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12436a f38822c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C12202o f38823d = new C12202o();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f38824e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f38825f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f38826g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f38827h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f38828i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f38829j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f38830k = false;

    /* renamed from: l */
    private boolean f38831l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f38832m = false;

    /* renamed from: n */
    private boolean f38833n = false;

    /* renamed from: o */
    private int f38834o = 3;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f38835p = 15;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public NativeVideoTracker f38836q;

    /* renamed from: com.smaato.soma.j.D$a */
    /* compiled from: VASTView */
    protected interface C12436a {
        /* renamed from: b */
        void mo39957b();
    }

    public C12202o getVideoAdDispatcher() {
        return this.f38823d;
    }

    public void setVastAdListener(C12486u vastAdListener) {
        this.f38823d.mo39481a(vastAdListener);
    }

    /* renamed from: k */
    public boolean mo39945k() {
        return this.f38833n;
    }

    /* renamed from: a */
    public void mo39936a(boolean autoCloseDisabled) {
        this.f38833n = autoCloseDisabled;
    }

    public void setAutoCloseDuration(int autoCloseDuration) {
        this.f38834o = autoCloseDuration;
    }

    public int getAutoCloseDuration() {
        return this.f38834o;
    }

    public int getVideoSkipInterval() {
        return this.f38835p;
    }

    /* renamed from: l */
    public boolean mo39946l() {
        return this.f38831l;
    }

    /* access modifiers changed from: protected */
    public void setIsRewardedVideo(boolean rewardedVideo) {
        this.f38831l = rewardedVideo;
    }

    public C12436a getOnVideoFinishedPlaying() {
        return this.f38822c;
    }

    public void setOnVideoFinishedPlaying(C12436a onVideoFinishedPlaying) {
        this.f38822c = onVideoFinishedPlaying;
    }

    public C12435D(Context context, C12285d vastAd, boolean rewardedVideo, C12486u vastAdListener, int autoCloseDuration, boolean disableAutoClose, int videoSkipInterval) {
        super(context);
        C12487v vVar = new C12487v(this, vastAd, autoCloseDuration, rewardedVideo, disableAutoClose, videoSkipInterval, vastAdListener);
        vVar.execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m40884m() {
        setVideoURI(this.f38820a.mo39709i());
        setOnPreparedListener(this);
        setOnCompletionListener(this);
        setOnTouchListener(this);
        setOnErrorListener(this);
        this.f38824e = this.f38820a.mo39699c();
    }

    public void start() {
        super.start();
        new C12488w(this).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m40886n() {
        this.f38821b.postDelayed(new C12489x(this), 1000);
    }

    public void onPrepared(MediaPlayer mp) {
        new C12490y(this, mp).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Map<String, String> m40866b(Collection<C12204a> extensions) {
        for (C12204a extension : extensions) {
            if ("moat".equalsIgnoreCase(extension.mo39510b())) {
                return extension.mo39509a();
            }
        }
        return null;
    }

    public void onCompletion(MediaPlayer mp) {
        new C12491z(this).execute();
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        return ((Boolean) new C12432A(this).execute()).booleanValue();
    }

    public boolean onTouch(View v, MotionEvent event) {
        new C12433B(this).execute();
        return false;
    }

    /* renamed from: j */
    public boolean mo39944j() {
        new C12434C(this).execute();
        return false;
    }

    /* renamed from: i */
    public void mo39943i() {
        try {
            this.f38821b.removeCallbacksAndMessages(null);
            pause();
        } catch (Exception e) {
        }
    }

    public C12285d getVastAd() {
        return this.f38820a;
    }

    public void setVastAd(C12285d mVastAd) {
        this.f38820a = mVastAd;
    }

    /* renamed from: h */
    public void mo39942h() {
        try {
            if (this.f38836q != null) {
                this.f38836q.stopTracking();
            }
            mo39943i();
            this.f38822c = null;
            setVastAdListener(null);
            setVastAd(null);
        } catch (Exception e) {
        }
    }
}
