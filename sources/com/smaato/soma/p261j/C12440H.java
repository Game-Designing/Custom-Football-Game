package com.smaato.soma.p261j;

import android.content.Intent;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.j.H */
/* compiled from: Video */
class C12440H extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12446N f38841a;

    C12440H(C12446N this$0) {
        this.f38841a = this$0;
    }

    public Void process() throws Exception {
        if (this.f38841a.f38849a == null) {
            C12146d.m39965a(new C12147e("VIDEO", "Video must be loaded before showing it.", 1, C12143a.ERROR));
            return null;
        }
        this.f38841a.f38855g.mo39486f();
        Intent intent = new Intent(this.f38841a.f38852d, C12485t.class);
        intent.addFlags(268435456);
        long vastViewCacheId = System.currentTimeMillis();
        intent.putExtra("vastViewCacheId", vastViewCacheId);
        C12437E.m40896a(Long.valueOf(vastViewCacheId), this.f38841a.f38849a);
        this.f38841a.f38852d.startActivity(intent);
        return null;
    }
}
