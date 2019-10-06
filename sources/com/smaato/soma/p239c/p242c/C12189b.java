package com.smaato.soma.p239c.p242c;

import android.os.Handler;
import android.os.Looper;
import com.smaato.soma.C12064Na;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.smaato.soma.c.c.b */
/* compiled from: AdDispatcher */
public class C12189b {

    /* renamed from: a */
    private final Handler f38215a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final List<C12367f> f38216b = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    public void mo39473a(C12367f listener) {
        this.f38216b.add(listener);
    }

    /* renamed from: a */
    public void mo39471a() {
        this.f38216b.clear();
    }

    /* renamed from: a */
    public void mo39472a(C12322e sender, C12064Na banner) {
        this.f38215a.post(new C12188a(this, sender, banner));
    }
}
