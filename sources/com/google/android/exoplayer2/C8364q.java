package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.C8381l;
import com.google.android.exoplayer2.source.C8383m;
import com.google.android.exoplayer2.source.C8393q;
import com.google.android.exoplayer2.source.C8395r;
import com.google.android.exoplayer2.source.C8408v;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8432h;
import com.google.android.exoplayer2.trackselection.C8434i;
import com.google.android.exoplayer2.trackselection.C8435j;
import com.google.android.exoplayer2.trackselection.C8437k;
import com.google.android.exoplayer2.upstream.C8481d;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;

/* renamed from: com.google.android.exoplayer2.q */
/* compiled from: MediaPeriodHolder */
final class C8364q {

    /* renamed from: a */
    public final C8393q f18118a;

    /* renamed from: b */
    public final Object f18119b;

    /* renamed from: c */
    public final C8408v[] f18120c;

    /* renamed from: d */
    public final boolean[] f18121d;

    /* renamed from: e */
    public boolean f18122e;

    /* renamed from: f */
    public boolean f18123f;

    /* renamed from: g */
    public C8365r f18124g;

    /* renamed from: h */
    public C8364q f18125h;

    /* renamed from: i */
    public TrackGroupArray f18126i;

    /* renamed from: j */
    public C8437k f18127j;

    /* renamed from: k */
    private final C8573z[] f18128k;

    /* renamed from: l */
    private final C8435j f18129l;

    /* renamed from: m */
    private final C8395r f18130m;

    /* renamed from: n */
    private long f18131n;

    /* renamed from: o */
    private C8437k f18132o;

    public C8364q(C8573z[] rendererCapabilities, long rendererPositionOffsetUs, C8435j trackSelector, C8481d allocator, C8395r mediaSource, C8365r info) {
        C8573z[] zVarArr = rendererCapabilities;
        C8395r rVar = mediaSource;
        C8365r rVar2 = info;
        this.f18128k = zVarArr;
        this.f18131n = rendererPositionOffsetUs - rVar2.f18134b;
        this.f18129l = trackSelector;
        this.f18130m = rVar;
        Object obj = rVar2.f18133a.f18288a;
        C8514e.m20486a(obj);
        this.f18119b = obj;
        this.f18124g = rVar2;
        this.f18120c = new C8408v[zVarArr.length];
        this.f18121d = new boolean[zVarArr.length];
        C8393q mediaPeriod = rVar.mo25719a(rVar2.f18133a, allocator, rVar2.f18134b);
        long j = rVar2.f18133a.f18292e;
        if (j != Long.MIN_VALUE) {
            C8381l lVar = new C8381l(mediaPeriod, true, 0, j);
            mediaPeriod = lVar;
        }
        this.f18118a = mediaPeriod;
    }

    /* renamed from: d */
    public long mo25620d(long periodTimeUs) {
        return mo25617c() + periodTimeUs;
    }

    /* renamed from: c */
    public long mo25618c(long rendererTimeUs) {
        return rendererTimeUs - mo25617c();
    }

    /* renamed from: c */
    public long mo25617c() {
        return this.f18131n;
    }

    /* renamed from: d */
    public long mo25619d() {
        return this.f18124g.f18134b + this.f18131n;
    }

    /* renamed from: e */
    public boolean mo25621e() {
        return this.f18122e && (!this.f18123f || this.f18118a.mo25693e() == Long.MIN_VALUE);
    }

    /* renamed from: a */
    public long mo25609a() {
        if (!this.f18122e) {
            return this.f18124g.f18134b;
        }
        long bufferedPositionUs = this.f18123f ? this.f18118a.mo25693e() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f18124g.f18136d : bufferedPositionUs;
    }

    /* renamed from: b */
    public long mo25614b() {
        if (!this.f18122e) {
            return 0;
        }
        return this.f18118a.mo25681a();
    }

    /* renamed from: a */
    public void mo25612a(float playbackSpeed) throws ExoPlaybackException {
        this.f18122e = true;
        this.f18126i = this.f18118a.mo25692d();
        mo25616b(playbackSpeed);
        long newStartPositionUs = mo25610a(this.f18124g.f18134b, false);
        long j = this.f18131n;
        C8365r rVar = this.f18124g;
        this.f18131n = j + (rVar.f18134b - newStartPositionUs);
        this.f18124g = rVar.mo25623a(newStartPositionUs);
    }

    /* renamed from: b */
    public void mo25615b(long rendererPositionUs) {
        if (this.f18122e) {
            this.f18118a.mo25691c(mo25618c(rendererPositionUs));
        }
    }

    /* renamed from: a */
    public void mo25613a(long rendererPositionUs) {
        this.f18118a.mo25689b(mo25618c(rendererPositionUs));
    }

    /* renamed from: b */
    public boolean mo25616b(float playbackSpeed) throws ExoPlaybackException {
        C8432h[] a;
        C8437k selectorResult = this.f18129l.mo25846a(this.f18128k, this.f18126i);
        if (selectorResult.mo25862a(this.f18132o)) {
            return false;
        }
        this.f18127j = selectorResult;
        for (C8432h trackSelection : this.f18127j.f18480c.mo25856a()) {
            if (trackSelection != null) {
                trackSelection.mo25828a(playbackSpeed);
            }
        }
        return true;
    }

    /* renamed from: a */
    public long mo25610a(long positionUs, boolean forceRecreateStreams) {
        return mo25611a(positionUs, forceRecreateStreams, new boolean[this.f18128k.length]);
    }

    /* renamed from: a */
    public long mo25611a(long positionUs, boolean forceRecreateStreams, boolean[] streamResetFlags) {
        int i = 0;
        while (true) {
            C8437k kVar = this.f18127j;
            boolean z = false;
            if (i >= kVar.f18478a) {
                break;
            }
            boolean[] zArr = this.f18121d;
            if (!forceRecreateStreams && kVar.mo25863a(this.f18132o, i)) {
                z = true;
            }
            zArr[i] = z;
            i++;
        }
        m19724b(this.f18120c);
        m19725c(this.f18127j);
        C8434i trackSelections = this.f18127j.f18480c;
        long positionUs2 = this.f18118a.mo25684a(trackSelections.mo25856a(), this.f18121d, this.f18120c, streamResetFlags, positionUs);
        m19722a(this.f18120c);
        this.f18123f = false;
        int i2 = 0;
        while (true) {
            C8408v[] vVarArr = this.f18120c;
            if (i2 >= vVarArr.length) {
                return positionUs2;
            }
            if (vVarArr[i2] != null) {
                C8514e.m20490b(this.f18127j.mo25861a(i2));
                if (this.f18128k[i2].mo25372d() != 6) {
                    this.f18123f = true;
                }
            } else {
                C8514e.m20490b(trackSelections.mo25855a(i2) == null);
            }
            i2++;
        }
    }

    /* renamed from: f */
    public void mo25622f() {
        m19725c((C8437k) null);
        try {
            if (this.f18124g.f18133a.f18292e != Long.MIN_VALUE) {
                this.f18130m.mo25721a(((C8381l) this.f18118a).f18206a);
            } else {
                this.f18130m.mo25721a(this.f18118a);
            }
        } catch (RuntimeException e) {
            C8526n.m20530a("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    /* renamed from: c */
    private void m19725c(C8437k trackSelectorResult) {
        C8437k kVar = this.f18132o;
        if (kVar != null) {
            m19721a(kVar);
        }
        this.f18132o = trackSelectorResult;
        C8437k kVar2 = this.f18132o;
        if (kVar2 != null) {
            m19723b(kVar2);
        }
    }

    /* renamed from: b */
    private void m19723b(C8437k trackSelectorResult) {
        for (int i = 0; i < trackSelectorResult.f18478a; i++) {
            boolean rendererEnabled = trackSelectorResult.mo25861a(i);
            C8432h trackSelection = trackSelectorResult.f18480c.mo25855a(i);
            if (rendererEnabled && trackSelection != null) {
                trackSelection.mo25829d();
            }
        }
    }

    /* renamed from: a */
    private void m19721a(C8437k trackSelectorResult) {
        for (int i = 0; i < trackSelectorResult.f18478a; i++) {
            boolean rendererEnabled = trackSelectorResult.mo25861a(i);
            C8432h trackSelection = trackSelectorResult.f18480c.mo25855a(i);
            if (rendererEnabled && trackSelection != null) {
                trackSelection.mo25835c();
            }
        }
    }

    /* renamed from: b */
    private void m19724b(C8408v[] sampleStreams) {
        int i = 0;
        while (true) {
            C8573z[] zVarArr = this.f18128k;
            if (i < zVarArr.length) {
                if (zVarArr[i].mo25372d() == 6) {
                    sampleStreams[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m19722a(C8408v[] sampleStreams) {
        int i = 0;
        while (true) {
            C8573z[] zVarArr = this.f18128k;
            if (i < zVarArr.length) {
                if (zVarArr[i].mo25372d() == 6 && this.f18127j.mo25861a(i)) {
                    sampleStreams[i] = new C8383m();
                }
                i++;
            } else {
                return;
            }
        }
    }
}
