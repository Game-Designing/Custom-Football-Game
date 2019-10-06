package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p183b.C8262i;
import com.google.android.exoplayer2.p183b.C8272q;
import com.google.android.exoplayer2.p183b.p188e.C8215G.C8219d;
import com.google.android.exoplayer2.util.C8506D;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.e.C */
/* compiled from: SpliceInfoSectionReader */
public final class C8208C implements C8253z {

    /* renamed from: a */
    private C8506D f17157a;

    /* renamed from: b */
    private C8272q f17158b;

    /* renamed from: c */
    private boolean f17159c;

    /* renamed from: a */
    public void mo25290a(C8506D timestampAdjuster, C8262i extractorOutput, C8219d idGenerator) {
        this.f17157a = timestampAdjuster;
        idGenerator.mo25298a();
        this.f17158b = extractorOutput.mo25351a(idGenerator.mo25300c(), 4);
        this.f17158b.mo25340a(Format.m18253a(idGenerator.mo25299b(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    /* renamed from: a */
    public void mo25291a(C8535t sectionData) {
        if (!this.f17159c) {
            if (this.f17157a.mo26053c() != -9223372036854775807L) {
                this.f17158b.mo25340a(Format.m18245a(null, "application/x-scte35", this.f17157a.mo26053c()));
                this.f17159c = true;
            } else {
                return;
            }
        }
        int sampleSize = sectionData.mo26104a();
        this.f17158b.mo25341a(sectionData, sampleSize);
        this.f17158b.mo25339a(this.f17157a.mo26051b(), 1, sampleSize, 0, null);
    }
}
