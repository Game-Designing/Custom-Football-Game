package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.C8509F;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.upstream.f */
/* compiled from: BaseDataSource */
public abstract class C8484f implements C8487i {

    /* renamed from: a */
    private final boolean f18710a;

    /* renamed from: b */
    private final ArrayList<C8502v> f18711b = new ArrayList<>(1);

    /* renamed from: c */
    private int f18712c;

    /* renamed from: d */
    private C8489j f18713d;

    /* renamed from: a */
    public /* synthetic */ Map<String, List<String>> mo25954a() {
        return C8486h.m20331a(this);
    }

    protected C8484f(boolean isNetwork) {
        this.f18710a = isNetwork;
    }

    /* renamed from: a */
    public final void mo25955a(C8502v transferListener) {
        if (!this.f18711b.contains(transferListener)) {
            this.f18711b.add(transferListener);
            this.f18712c++;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo26014b(C8489j dataSpec) {
        for (int i = 0; i < this.f18712c; i++) {
            ((C8502v) this.f18711b.get(i)).mo26028c(this, dataSpec, this.f18710a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo26015c(C8489j dataSpec) {
        this.f18713d = dataSpec;
        for (int i = 0; i < this.f18712c; i++) {
            ((C8502v) this.f18711b.get(i)).mo26027b(this, dataSpec, this.f18710a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo26012a(int bytesTransferred) {
        C8489j jVar = this.f18713d;
        C8509F.m20443a(jVar);
        C8489j dataSpec = jVar;
        for (int i = 0; i < this.f18712c; i++) {
            ((C8502v) this.f18711b.get(i)).mo26026a(this, dataSpec, this.f18710a, bytesTransferred);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo26013b() {
        C8489j jVar = this.f18713d;
        C8509F.m20443a(jVar);
        C8489j dataSpec = jVar;
        for (int i = 0; i < this.f18712c; i++) {
            ((C8502v) this.f18711b.get(i)).mo26025a(this, dataSpec, this.f18710a);
        }
        this.f18713d = null;
    }
}
