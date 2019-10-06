package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.C8320g;
import com.google.android.exoplayer2.p183b.C8205e;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.source.C8395r.C8396a;
import com.google.android.exoplayer2.source.ads.C8370b;
import com.google.android.exoplayer2.upstream.C8481d;
import com.google.android.exoplayer2.upstream.C8487i;
import com.google.android.exoplayer2.upstream.C8487i.C8488a;
import com.google.android.exoplayer2.upstream.C8495o;
import com.google.android.exoplayer2.upstream.C8497q;
import com.google.android.exoplayer2.upstream.C8502v;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;
import p005cm.aptoide.p006pt.file.CacheHelper;

/* renamed from: com.google.android.exoplayer2.source.p */
/* compiled from: ExtractorMediaSource */
public final class C8391p extends C8380k implements C8387c {

    /* renamed from: f */
    private final Uri f18271f;

    /* renamed from: g */
    private final C8488a f18272g;

    /* renamed from: h */
    private final C8263j f18273h;

    /* renamed from: i */
    private final C8497q f18274i;

    /* renamed from: j */
    private final String f18275j;

    /* renamed from: k */
    private final int f18276k;

    /* renamed from: l */
    private final Object f18277l;

    /* renamed from: m */
    private long f18278m;

    /* renamed from: n */
    private boolean f18279n;

    /* renamed from: o */
    private C8502v f18280o;

    /* renamed from: com.google.android.exoplayer2.source.p$a */
    /* compiled from: ExtractorMediaSource */
    public static final class C8392a implements C8370b {

        /* renamed from: a */
        private final C8488a f18281a;

        /* renamed from: b */
        private C8263j f18282b;

        /* renamed from: c */
        private String f18283c;

        /* renamed from: d */
        private Object f18284d;

        /* renamed from: e */
        private C8497q f18285e = new C8495o();

        /* renamed from: f */
        private int f18286f = CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES;

        /* renamed from: g */
        private boolean f18287g;

        public C8392a(C8488a dataSourceFactory) {
            this.f18281a = dataSourceFactory;
        }

        /* renamed from: a */
        public C8392a mo25722a(C8263j extractorsFactory) {
            C8514e.m20490b(!this.f18287g);
            this.f18282b = extractorsFactory;
            return this;
        }

        /* renamed from: a */
        public C8391p mo25723a(Uri uri) {
            this.f18287g = true;
            if (this.f18282b == null) {
                this.f18282b = new C8205e();
            }
            C8391p pVar = new C8391p(uri, this.f18281a, this.f18282b, this.f18285e, this.f18283c, this.f18286f, this.f18284d);
            return pVar;
        }
    }

    private C8391p(Uri uri, C8488a dataSourceFactory, C8263j extractorsFactory, C8497q loadableLoadErrorHandlingPolicy, String customCacheKey, int continueLoadingCheckIntervalBytes, Object tag) {
        this.f18271f = uri;
        this.f18272g = dataSourceFactory;
        this.f18273h = extractorsFactory;
        this.f18274i = loadableLoadErrorHandlingPolicy;
        this.f18275j = customCacheKey;
        this.f18276k = continueLoadingCheckIntervalBytes;
        this.f18278m = -9223372036854775807L;
        this.f18277l = tag;
    }

    /* renamed from: a */
    public void mo25678a(C8320g player, boolean isTopLevelSource, C8502v mediaTransferListener) {
        this.f18280o = mediaTransferListener;
        m19874b(this.f18278m, this.f18279n);
    }

    /* renamed from: a */
    public void mo25720a() throws IOException {
    }

    /* renamed from: a */
    public C8393q mo25719a(C8396a id, C8481d allocator, long startPositionUs) {
        C8487i dataSource = this.f18272g.createDataSource();
        C8502v vVar = this.f18280o;
        if (vVar != null) {
            dataSource.mo25955a(vVar);
        }
        C8384n nVar = new C8384n(this.f18271f, dataSource, this.f18273h.createExtractors(), this.f18274i, mo25675a(id), this, allocator, this.f18275j, this.f18276k);
        return nVar;
    }

    /* renamed from: a */
    public void mo25721a(C8393q mediaPeriod) {
        ((C8384n) mediaPeriod).mo25713j();
    }

    /* renamed from: b */
    public void mo25680b() {
    }

    /* renamed from: a */
    public void mo25718a(long durationUs, boolean isSeekable) {
        long durationUs2 = durationUs == -9223372036854775807L ? this.f18278m : durationUs;
        if (this.f18278m != durationUs2 || this.f18279n != isSeekable) {
            m19874b(durationUs2, isSeekable);
        }
    }

    /* renamed from: b */
    private void m19874b(long durationUs, boolean isSeekable) {
        this.f18278m = durationUs;
        this.f18279n = isSeekable;
        C8411x xVar = new C8411x(this.f18278m, this.f18279n, false, this.f18277l);
        mo25676a(xVar, null);
    }
}
