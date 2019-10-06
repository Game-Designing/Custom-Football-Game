package com.inmobi.ads.p212c;

import com.inmobi.ads.C10455bi;
import com.inmobi.ads.C10456bj;
import com.inmobi.ads.C10545i;
import com.inmobi.ads.C10545i.C10575b;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.inmobi.ads.c.b */
/* compiled from: InterstitialPreLoader */
public class C10500b extends C10491a {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f32000d = C10500b.class.getSimpleName();

    /* renamed from: e */
    private static volatile C10500b f32001e;

    /* renamed from: f */
    private static final Object f32002f = new Object();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static List<C10502a> f32003g = new LinkedList();

    /* renamed from: com.inmobi.ads.c.b$a */
    /* compiled from: InterstitialPreLoader */
    static class C10502a extends C10575b {

        /* renamed from: a */
        private C10455bi f32006a;

        C10502a(C10455bi biVar) {
            this.f32006a = biVar;
        }

        /* renamed from: a */
        public final void mo33782a(boolean z) {
            C10500b.f32000d;
        }

        /* renamed from: a */
        public final void mo33747a() {
            C10500b.f32000d;
            C10500b.f32003g.remove(this);
        }

        /* renamed from: a */
        public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            C10500b.f32000d;
            new StringBuilder("onAdLoadFailed called. Status:").append(inMobiAdRequestStatus.getMessage());
            C10545i iVar = (C10545i) C10491a.f31975a.remove(this.f32006a);
            if (inMobiAdRequestStatus.getStatusCode() == StatusCode.NO_FILL) {
                iVar.mo34296d("PreLoadServerNoFill");
            }
            C10500b.f32003g.remove(this);
        }

        /* renamed from: i */
        public final boolean mo34222i() {
            return false;
        }
    }

    /* renamed from: d */
    public static C10500b m34347d() {
        C10500b bVar = f32001e;
        if (bVar == null) {
            synchronized (f32002f) {
                bVar = f32001e;
                if (bVar == null) {
                    bVar = new C10500b();
                    f32001e = bVar;
                }
            }
        }
        return bVar;
    }

    private C10500b() {
        super("int");
    }

    /* renamed from: a */
    public static void m34345a(C10545i iVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", iVar.mo33976b());
        hashMap.put("plId", Long.valueOf(iVar.f32168d));
        hashMap.put("clientRequestId", iVar.f32176l);
    }

    /* renamed from: a */
    public static void m34346a(String str, C10545i iVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", str);
        hashMap.put("type", iVar.mo33976b());
        hashMap.put("plId", Long.valueOf(iVar.f32168d));
        hashMap.put("clientRequestId", iVar.f32176l);
    }

    /* renamed from: a */
    static /* synthetic */ void m34344a(C10500b bVar) {
        if (C10491a.f31976b.mo34205c(bVar.f31984c).f31940a && C10491a.f31975a.size() >= C10491a.f31976b.mo34205c(bVar.f31984c).f31942c) {
            C10456bj.m34231a();
            ArrayList arrayList = (ArrayList) C10456bj.m34232a(bVar.f31984c);
            Iterator it = C10491a.f31975a.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (!arrayList.contains(entry.getKey())) {
                    ((C10545i) entry.getValue()).mo33995v();
                    it.remove();
                    StringBuilder sb = new StringBuilder("Removing extra ad unit from ad unit cache. Pid:");
                    sb.append(((C10455bi) entry.getKey()).f31801a);
                    sb.append(" tp:");
                    sb.append(((C10455bi) entry.getKey()).f31802b);
                }
            }
        }
    }
}
