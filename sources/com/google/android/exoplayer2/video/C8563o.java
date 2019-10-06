package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.C8509F;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.video.o */
/* compiled from: VideoFrameReleaseTimeHelper */
public final class C8563o {

    /* renamed from: a */
    private final WindowManager f18973a;

    /* renamed from: b */
    private final C8565b f18974b;

    /* renamed from: c */
    private final C8564a f18975c;

    /* renamed from: d */
    private long f18976d;

    /* renamed from: e */
    private long f18977e;

    /* renamed from: f */
    private long f18978f;

    /* renamed from: g */
    private long f18979g;

    /* renamed from: h */
    private long f18980h;

    /* renamed from: i */
    private boolean f18981i;

    /* renamed from: j */
    private long f18982j;

    /* renamed from: k */
    private long f18983k;

    /* renamed from: l */
    private long f18984l;

    @TargetApi(17)
    /* renamed from: com.google.android.exoplayer2.video.o$a */
    /* compiled from: VideoFrameReleaseTimeHelper */
    private final class C8564a implements DisplayListener {

        /* renamed from: a */
        private final DisplayManager f18985a;

        public C8564a(DisplayManager displayManager) {
            this.f18985a = displayManager;
        }

        /* renamed from: a */
        public void mo26200a() {
            this.f18985a.registerDisplayListener(this, null);
        }

        /* renamed from: b */
        public void mo26201b() {
            this.f18985a.unregisterDisplayListener(this);
        }

        public void onDisplayAdded(int displayId) {
        }

        public void onDisplayRemoved(int displayId) {
        }

        public void onDisplayChanged(int displayId) {
            if (displayId == 0) {
                C8563o.this.m20724c();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.video.o$b */
    /* compiled from: VideoFrameReleaseTimeHelper */
    private static final class C8565b implements FrameCallback, Callback {

        /* renamed from: a */
        private static final C8565b f18987a = new C8565b();

        /* renamed from: b */
        public volatile long f18988b = -9223372036854775807L;

        /* renamed from: c */
        private final Handler f18989c;

        /* renamed from: d */
        private final HandlerThread f18990d = new HandlerThread("ChoreographerOwner:Handler");

        /* renamed from: e */
        private Choreographer f18991e;

        /* renamed from: f */
        private int f18992f;

        /* renamed from: b */
        public static C8565b m20730b() {
            return f18987a;
        }

        private C8565b() {
            this.f18990d.start();
            this.f18989c = C8509F.m20441a(this.f18990d.getLooper(), (Callback) this);
            this.f18989c.sendEmptyMessage(0);
        }

        /* renamed from: a */
        public void mo26205a() {
            this.f18989c.sendEmptyMessage(1);
        }

        /* renamed from: c */
        public void mo26206c() {
            this.f18989c.sendEmptyMessage(2);
        }

        public void doFrame(long vsyncTimeNs) {
            this.f18988b = vsyncTimeNs;
            this.f18991e.postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                m20732e();
                return true;
            } else if (i == 1) {
                m20731d();
                return true;
            } else if (i != 2) {
                return false;
            } else {
                m20733f();
                return true;
            }
        }

        /* renamed from: e */
        private void m20732e() {
            this.f18991e = Choreographer.getInstance();
        }

        /* renamed from: d */
        private void m20731d() {
            this.f18992f++;
            if (this.f18992f == 1) {
                this.f18991e.postFrameCallback(this);
            }
        }

        /* renamed from: f */
        private void m20733f() {
            this.f18992f--;
            if (this.f18992f == 0) {
                this.f18991e.removeFrameCallback(this);
                this.f18988b = -9223372036854775807L;
            }
        }
    }

    public C8563o(Context context) {
        C8564a aVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.f18973a = (WindowManager) context.getSystemService("window");
        } else {
            this.f18973a = null;
        }
        if (this.f18973a != null) {
            if (C8509F.f18793a >= 17) {
                aVar = m20721a(context);
            }
            this.f18975c = aVar;
            this.f18974b = C8565b.m20730b();
        } else {
            this.f18975c = null;
            this.f18974b = null;
        }
        this.f18976d = -9223372036854775807L;
        this.f18977e = -9223372036854775807L;
    }

    /* renamed from: b */
    public void mo26199b() {
        this.f18981i = false;
        if (this.f18973a != null) {
            this.f18974b.mo26205a();
            C8564a aVar = this.f18975c;
            if (aVar != null) {
                aVar.mo26200a();
            }
            m20724c();
        }
    }

    /* renamed from: a */
    public void mo26198a() {
        if (this.f18973a != null) {
            C8564a aVar = this.f18975c;
            if (aVar != null) {
                aVar.mo26201b();
            }
            this.f18974b.mo26206c();
        }
    }

    /* renamed from: a */
    public long mo26197a(long framePresentationTimeUs, long unadjustedReleaseTimeNs) {
        long adjustedReleaseTimeNs;
        long j = framePresentationTimeUs;
        long j2 = unadjustedReleaseTimeNs;
        long framePresentationTimeNs = 1000 * j;
        long adjustedFrameTimeNs = framePresentationTimeNs;
        long adjustedReleaseTimeNs2 = unadjustedReleaseTimeNs;
        if (this.f18981i) {
            if (j != this.f18978f) {
                this.f18984l++;
                this.f18979g = this.f18980h;
            }
            long j3 = this.f18984l;
            if (j3 >= 6) {
                long candidateAdjustedFrameTimeNs = this.f18979g + ((framePresentationTimeNs - this.f18983k) / j3);
                if (m20723b(candidateAdjustedFrameTimeNs, j2)) {
                    this.f18981i = false;
                } else {
                    long adjustedFrameTimeNs2 = candidateAdjustedFrameTimeNs;
                    long j4 = adjustedReleaseTimeNs2;
                    adjustedReleaseTimeNs2 = (this.f18982j + adjustedFrameTimeNs2) - this.f18983k;
                    adjustedFrameTimeNs = adjustedFrameTimeNs2;
                }
                adjustedReleaseTimeNs = adjustedReleaseTimeNs2;
            } else {
                adjustedReleaseTimeNs = adjustedReleaseTimeNs2;
                if (m20723b(framePresentationTimeNs, j2)) {
                    this.f18981i = false;
                }
            }
        } else {
            adjustedReleaseTimeNs = adjustedReleaseTimeNs2;
        }
        if (!this.f18981i) {
            this.f18983k = framePresentationTimeNs;
            this.f18982j = j2;
            this.f18984l = 0;
            this.f18981i = true;
        }
        this.f18978f = j;
        this.f18980h = adjustedFrameTimeNs;
        C8565b bVar = this.f18974b;
        if (bVar == null || this.f18976d == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        long sampledVsyncTimeNs = bVar.f18988b;
        if (sampledVsyncTimeNs == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        long j5 = sampledVsyncTimeNs;
        return m20720a(adjustedReleaseTimeNs, sampledVsyncTimeNs, this.f18976d) - this.f18977e;
    }

    @TargetApi(17)
    /* renamed from: a */
    private C8564a m20721a(Context context) {
        DisplayManager manager = (DisplayManager) context.getSystemService("display");
        if (manager == null) {
            return null;
        }
        return new C8564a(manager);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20724c() {
        Display defaultDisplay = this.f18973a.getDefaultDisplay();
        if (defaultDisplay != null) {
            double defaultDisplayRefreshRate = (double) defaultDisplay.getRefreshRate();
            Double.isNaN(defaultDisplayRefreshRate);
            this.f18976d = (long) (1.0E9d / defaultDisplayRefreshRate);
            this.f18977e = (this.f18976d * 80) / 100;
        }
    }

    /* renamed from: b */
    private boolean m20723b(long frameTimeNs, long releaseTimeNs) {
        return Math.abs((releaseTimeNs - this.f18982j) - (frameTimeNs - this.f18983k)) > 20000000;
    }

    /* renamed from: a */
    private static long m20720a(long releaseTime, long sampledVsyncTime, long vsyncDuration) {
        long snappedAfterNs;
        long snappedBeforeNs;
        long snappedTimeNs = sampledVsyncTime + (vsyncDuration * ((releaseTime - sampledVsyncTime) / vsyncDuration));
        if (releaseTime <= snappedTimeNs) {
            snappedBeforeNs = snappedTimeNs - vsyncDuration;
            snappedAfterNs = snappedTimeNs;
        } else {
            snappedBeforeNs = snappedTimeNs;
            snappedAfterNs = snappedTimeNs + vsyncDuration;
        }
        return snappedAfterNs - releaseTime < releaseTime - snappedBeforeNs ? snappedAfterNs : snappedBeforeNs;
    }
}
