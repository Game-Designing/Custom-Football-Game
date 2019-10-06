package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8434i;
import com.google.android.exoplayer2.upstream.C8481d;
import com.google.android.exoplayer2.upstream.C8490k;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.mopub.volley.DefaultRetryPolicy;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.google.android.exoplayer2.e */
/* compiled from: DefaultLoadControl */
public class C8281e implements C8363p {

    /* renamed from: a */
    private final C8490k f17548a;

    /* renamed from: b */
    private final long f17549b;

    /* renamed from: c */
    private final long f17550c;

    /* renamed from: d */
    private final long f17551d;

    /* renamed from: e */
    private final long f17552e;

    /* renamed from: f */
    private final int f17553f;

    /* renamed from: g */
    private final boolean f17554g;

    /* renamed from: h */
    private final PriorityTaskManager f17555h;

    /* renamed from: i */
    private final long f17556i;

    /* renamed from: j */
    private final boolean f17557j;

    /* renamed from: k */
    private int f17558k;

    /* renamed from: l */
    private boolean f17559l;

    /* renamed from: com.google.android.exoplayer2.e$a */
    /* compiled from: DefaultLoadControl */
    public static final class C8282a {

        /* renamed from: a */
        private C8490k f17560a = null;

        /* renamed from: b */
        private int f17561b = 15000;

        /* renamed from: c */
        private int f17562c = 50000;

        /* renamed from: d */
        private int f17563d = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;

        /* renamed from: e */
        private int f17564e = 5000;

        /* renamed from: f */
        private int f17565f = -1;

        /* renamed from: g */
        private boolean f17566g = true;

        /* renamed from: h */
        private PriorityTaskManager f17567h = null;

        /* renamed from: i */
        private int f17568i = 0;

        /* renamed from: j */
        private boolean f17569j = false;

        /* renamed from: k */
        private boolean f17570k;

        /* renamed from: a */
        public C8282a mo25421a(C8490k allocator) {
            C8514e.m20490b(!this.f17570k);
            this.f17560a = allocator;
            return this;
        }

        /* renamed from: a */
        public C8281e mo25422a() {
            this.f17570k = true;
            if (this.f17560a == null) {
                this.f17560a = new C8490k(true, 65536);
            }
            C8281e eVar = new C8281e(this.f17560a, this.f17561b, this.f17562c, this.f17563d, this.f17564e, this.f17565f, this.f17566g, this.f17567h, this.f17568i, this.f17569j);
            return eVar;
        }
    }

    protected C8281e(C8490k allocator, int minBufferMs, int maxBufferMs, int bufferForPlaybackMs, int bufferForPlaybackAfterRebufferMs, int targetBufferBytes, boolean prioritizeTimeOverSizeThresholds, PriorityTaskManager priorityTaskManager, int backBufferDurationMs, boolean retainBackBufferFromKeyframe) {
        String str = "bufferForPlaybackMs";
        String str2 = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        m19242a(bufferForPlaybackMs, 0, str, str2);
        String str3 = "bufferForPlaybackAfterRebufferMs";
        m19242a(bufferForPlaybackAfterRebufferMs, 0, str3, str2);
        String str4 = "minBufferMs";
        m19242a(minBufferMs, bufferForPlaybackMs, str4, str);
        m19242a(minBufferMs, bufferForPlaybackAfterRebufferMs, str4, str3);
        m19242a(maxBufferMs, minBufferMs, "maxBufferMs", str4);
        m19242a(backBufferDurationMs, 0, "backBufferDurationMs", str2);
        this.f17548a = allocator;
        this.f17549b = C8275d.m19230a((long) minBufferMs);
        this.f17550c = C8275d.m19230a((long) maxBufferMs);
        this.f17551d = C8275d.m19230a((long) bufferForPlaybackMs);
        this.f17552e = C8275d.m19230a((long) bufferForPlaybackAfterRebufferMs);
        this.f17553f = targetBufferBytes;
        this.f17554g = prioritizeTimeOverSizeThresholds;
        this.f17555h = priorityTaskManager;
        this.f17556i = C8275d.m19230a((long) backBufferDurationMs);
        this.f17557j = retainBackBufferFromKeyframe;
    }

    /* renamed from: d */
    public void mo25418d() {
        m19243a(false);
    }

    /* renamed from: a */
    public void mo25413a(C8572y[] renderers, TrackGroupArray trackGroups, C8434i trackSelections) {
        int i = this.f17553f;
        if (i == -1) {
            i = mo25411a(renderers, trackSelections);
        }
        this.f17558k = i;
        this.f17548a.mo26021a(this.f17558k);
    }

    /* renamed from: a */
    public void mo25412a() {
        m19243a(true);
    }

    /* renamed from: f */
    public void mo25420f() {
        m19243a(true);
    }

    /* renamed from: e */
    public C8481d mo25419e() {
        return this.f17548a;
    }

    /* renamed from: c */
    public long mo25417c() {
        return this.f17556i;
    }

    /* renamed from: b */
    public boolean mo25416b() {
        return this.f17557j;
    }

    /* renamed from: a */
    public boolean mo25414a(long bufferedDurationUs, float playbackSpeed) {
        boolean z = true;
        boolean targetBufferSizeReached = this.f17548a.mo26022d() >= this.f17558k;
        boolean wasBuffering = this.f17559l;
        long minBufferUs = this.f17549b;
        if (playbackSpeed > 1.0f) {
            minBufferUs = Math.min(C8509F.m20438a(minBufferUs, playbackSpeed), this.f17550c);
        }
        if (bufferedDurationUs < minBufferUs) {
            if (!this.f17554g && targetBufferSizeReached) {
                z = false;
            }
            this.f17559l = z;
        } else if (bufferedDurationUs >= this.f17550c || targetBufferSizeReached) {
            this.f17559l = false;
        }
        PriorityTaskManager priorityTaskManager = this.f17555h;
        if (priorityTaskManager != null) {
            boolean z2 = this.f17559l;
            if (z2 != wasBuffering) {
                if (z2) {
                    priorityTaskManager.mo26062a(0);
                    throw null;
                }
                priorityTaskManager.mo26063b(0);
                throw null;
            }
        }
        return this.f17559l;
    }

    /* renamed from: a */
    public boolean mo25415a(long bufferedDurationUs, float playbackSpeed, boolean rebuffering) {
        long bufferedDurationUs2 = C8509F.m20466b(bufferedDurationUs, playbackSpeed);
        long minBufferDurationUs = rebuffering ? this.f17552e : this.f17551d;
        return minBufferDurationUs <= 0 || bufferedDurationUs2 >= minBufferDurationUs || (!this.f17554g && this.f17548a.mo26022d() >= this.f17558k);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo25411a(C8572y[] renderers, C8434i trackSelectionArray) {
        int targetBufferSize = 0;
        for (int i = 0; i < renderers.length; i++) {
            if (trackSelectionArray.mo25855a(i) != null) {
                targetBufferSize += C8509F.m20461b(renderers[i].mo25372d());
            }
        }
        return targetBufferSize;
    }

    /* renamed from: a */
    private void m19243a(boolean resetAllocator) {
        this.f17558k = 0;
        PriorityTaskManager priorityTaskManager = this.f17555h;
        if (priorityTaskManager == null || !this.f17559l) {
            this.f17559l = false;
            if (resetAllocator) {
                this.f17548a.mo26023e();
                return;
            }
            return;
        }
        priorityTaskManager.mo26063b(0);
        throw null;
    }

    /* renamed from: a */
    private static void m19242a(int value1, int value2, String name1, String name2) {
        boolean z = value1 >= value2;
        StringBuilder sb = new StringBuilder();
        sb.append(name1);
        sb.append(" cannot be less than ");
        sb.append(name2);
        C8514e.m20489a(z, sb.toString());
    }
}
