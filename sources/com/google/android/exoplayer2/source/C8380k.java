package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C8098D;
import com.google.android.exoplayer2.C8320g;
import com.google.android.exoplayer2.source.C8395r.C8396a;
import com.google.android.exoplayer2.source.C8395r.C8397b;
import com.google.android.exoplayer2.source.C8398s.C8399a;
import com.google.android.exoplayer2.upstream.C8502v;
import com.google.android.exoplayer2.util.C8514e;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.exoplayer2.source.k */
/* compiled from: BaseMediaSource */
public abstract class C8380k implements C8395r {

    /* renamed from: a */
    private final ArrayList<C8397b> f18201a = new ArrayList<>(1);

    /* renamed from: b */
    private final C8399a f18202b = new C8399a();

    /* renamed from: c */
    private C8320g f18203c;

    /* renamed from: d */
    private C8098D f18204d;

    /* renamed from: e */
    private Object f18205e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25678a(C8320g gVar, boolean z, C8502v vVar);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo25680b();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo25676a(C8098D timeline, Object manifest) {
        this.f18204d = timeline;
        this.f18205e = manifest;
        Iterator it = this.f18201a.iterator();
        while (it.hasNext()) {
            ((C8397b) it.next()).mo25489a(this, timeline, manifest);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C8399a mo25675a(C8396a mediaPeriodId) {
        return this.f18202b.mo25735a(0, mediaPeriodId, 0);
    }

    /* renamed from: a */
    public final void mo25677a(C8320g player, boolean isTopLevelSource, C8397b listener, C8502v mediaTransferListener) {
        C8320g gVar = this.f18203c;
        C8514e.m20488a(gVar == null || gVar == player);
        this.f18201a.add(listener);
        if (this.f18203c == null) {
            this.f18203c = player;
            mo25678a(player, isTopLevelSource, mediaTransferListener);
            return;
        }
        C8098D d = this.f18204d;
        if (d != null) {
            listener.mo25489a(this, d, this.f18205e);
        }
    }

    /* renamed from: a */
    public final void mo25679a(C8397b listener) {
        this.f18201a.remove(listener);
        if (this.f18201a.isEmpty()) {
            this.f18203c = null;
            this.f18204d = null;
            this.f18205e = null;
            mo25680b();
        }
    }
}
