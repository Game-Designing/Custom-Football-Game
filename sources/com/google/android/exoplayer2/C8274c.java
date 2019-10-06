package com.google.android.exoplayer2;

import com.google.android.exoplayer2.drm.C8278c;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p182a.C8107e;
import com.google.android.exoplayer2.source.C8408v;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8528p;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.c */
/* compiled from: BaseRenderer */
public abstract class C8274c implements C8572y, C8573z {

    /* renamed from: a */
    private final int f17522a;

    /* renamed from: b */
    private C8095A f17523b;

    /* renamed from: c */
    private int f17524c;

    /* renamed from: d */
    private int f17525d;

    /* renamed from: e */
    private C8408v f17526e;

    /* renamed from: f */
    private Format[] f17527f;

    /* renamed from: g */
    private long f17528g;

    /* renamed from: h */
    private boolean f17529h = true;

    /* renamed from: i */
    private boolean f17530i;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25152a(long j, boolean z) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25157a(boolean z) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public abstract void mo25167r();

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public abstract void mo25168s() throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public abstract void mo25169t() throws ExoPlaybackException;

    public C8274c(int trackType) {
        this.f17522a = trackType;
    }

    /* renamed from: d */
    public final int mo25372d() {
        return this.f17522a;
    }

    /* renamed from: j */
    public final C8573z mo25378j() {
        return this;
    }

    public final void setIndex(int index) {
        this.f17524c = index;
    }

    /* renamed from: l */
    public C8528p mo25166l() {
        return null;
    }

    public final int getState() {
        return this.f17525d;
    }

    /* renamed from: a */
    public final void mo25368a(C8095A configuration, Format[] formats, C8408v stream, long positionUs, boolean joining, long offsetUs) throws ExoPlaybackException {
        C8514e.m20490b(this.f17525d == 0);
        this.f17523b = configuration;
        this.f17525d = 1;
        mo25157a(joining);
        mo25369a(formats, stream, offsetUs);
        mo25152a(positionUs, joining);
    }

    public final void start() throws ExoPlaybackException {
        boolean z = true;
        if (this.f17525d != 1) {
            z = false;
        }
        C8514e.m20490b(z);
        this.f17525d = 2;
        mo25168s();
    }

    /* renamed from: a */
    public final void mo25369a(Format[] formats, C8408v stream, long offsetUs) throws ExoPlaybackException {
        C8514e.m20490b(!this.f17530i);
        this.f17526e = stream;
        this.f17529h = false;
        this.f17527f = formats;
        this.f17528g = offsetUs;
        mo25158a(formats, offsetUs);
    }

    /* renamed from: k */
    public final C8408v mo25379k() {
        return this.f17526e;
    }

    /* renamed from: f */
    public final boolean mo25373f() {
        return this.f17529h;
    }

    /* renamed from: g */
    public final void mo25374g() {
        this.f17530i = true;
    }

    /* renamed from: i */
    public final boolean mo25377i() {
        return this.f17530i;
    }

    /* renamed from: h */
    public final void mo25376h() throws IOException {
        this.f17526e.mo25697a();
    }

    /* renamed from: a */
    public final void mo25367a(long positionUs) throws ExoPlaybackException {
        this.f17530i = false;
        this.f17529h = false;
        mo25152a(positionUs, false);
    }

    public final void stop() throws ExoPlaybackException {
        C8514e.m20490b(this.f17525d == 2);
        this.f17525d = 1;
        mo25169t();
    }

    /* renamed from: c */
    public final void mo25371c() {
        boolean z = true;
        if (this.f17525d != 1) {
            z = false;
        }
        C8514e.m20490b(z);
        this.f17525d = 0;
        this.f17526e = null;
        this.f17527f = null;
        this.f17530i = false;
        mo25167r();
    }

    /* renamed from: a */
    public void mo25151a(int what, Object object) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25158a(Format[] formats, long offsetUs) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final Format[] mo25382p() {
        return this.f17527f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final C8095A mo25380n() {
        return this.f17523b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final int mo25381o() {
        return this.f17524c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo25366a(C8362o formatHolder, C8107e buffer, boolean formatRequired) {
        int result = this.f17526e.mo25696a(formatHolder, buffer, formatRequired);
        int i = -4;
        if (result == -4) {
            if (buffer.mo25025c()) {
                this.f17529h = true;
                if (!this.f17530i) {
                    i = -3;
                }
                return i;
            }
            buffer.f16556d += this.f17528g;
        } else if (result == -5) {
            Format format = formatHolder.f18117a;
            long j = format.f16511k;
            if (j != Long.MAX_VALUE) {
                formatHolder.f18117a = format.mo25010a(j + this.f17528g);
            }
        }
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo25370b(long positionUs) {
        return this.f17526e.mo25695a(positionUs - this.f17528g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public final boolean mo25383q() {
        return this.f17529h ? this.f17530i : this.f17526e.isReady();
    }

    /* renamed from: a */
    protected static boolean m19204a(C8278c<?> drmSessionManager, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (drmSessionManager == null) {
            return false;
        }
        return drmSessionManager.mo25408a(drmInitData);
    }
}
