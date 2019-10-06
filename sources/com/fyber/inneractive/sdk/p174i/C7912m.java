package com.fyber.inneractive.sdk.p174i;

import android.util.Pair;
import com.fyber.inneractive.sdk.p174i.C7915o.C7916a;
import com.mopub.mobileads.VastResourceXmlManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.fyber.inneractive.sdk.i.m */
public final class C7912m implements C7914n {

    /* renamed from: a */
    static String f16064a = "VPAID";

    /* renamed from: b */
    public String f16065b;

    /* renamed from: c */
    int f16066c;

    /* renamed from: d */
    String f16067d;

    /* renamed from: e */
    public List<C7899a> f16068e = new ArrayList();

    /* renamed from: f */
    List<C7899a> f16069f;

    /* renamed from: g */
    List<C7910l> f16070g = new ArrayList();

    /* renamed from: h */
    public C7910l f16071h;

    /* renamed from: i */
    int f16072i;

    /* renamed from: j */
    public ArrayList<Pair<String, String>> f16073j = new ArrayList<>();

    /* renamed from: k */
    public boolean f16074k = false;

    /* renamed from: l */
    public long f16075l;

    /* renamed from: m */
    private List<C7915o> f16076m = new ArrayList();

    C7912m() {
    }

    /* renamed from: b */
    public final void mo24726b(String str, String str2) {
        this.f16073j.add(new Pair(str, str2));
    }

    /* renamed from: a */
    public final void mo24721a(String str, String str2) {
        this.f16076m.add(new C7915o(str, str2));
    }

    /* renamed from: a */
    public final int mo24723a() {
        List<C7899a> list = this.f16068e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public final List<String> mo24720a(C7916a aVar) {
        ArrayList arrayList = new ArrayList();
        for (C7915o oVar : this.f16076m) {
            if (oVar.f16079a == aVar) {
                arrayList.add(oVar.f16080b);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final C7899a mo24724a(int i) {
        if (i < 0 || i >= this.f16068e.size()) {
            return null;
        }
        return (C7899a) this.f16068e.get(i);
    }

    /* renamed from: a */
    public final C7910l mo24725a(int i, int i2) {
        List<C7910l> list = this.f16070g;
        if (list == null) {
            return null;
        }
        Collections.sort(list, new Comparator<C7910l>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                C7910l lVar = (C7910l) obj;
                C7910l lVar2 = (C7910l) obj2;
                String str = lVar.f16054c;
                String str2 = VastResourceXmlManager.STATIC_RESOURCE;
                if (str2.equals(str)) {
                    return -1;
                }
                if (str2.equals(lVar2.f16054c)) {
                    return 1;
                }
                String str3 = lVar.f16054c;
                String str4 = VastResourceXmlManager.HTML_RESOURCE;
                if (str4.equals(str3)) {
                    return -1;
                }
                if (str4.equals(lVar2.f16054c)) {
                    return 1;
                }
                return 0;
            }
        });
        for (C7910l lVar : this.f16070g) {
            if (lVar.f16052a >= i && lVar.f16053b >= i2) {
                this.f16071h = lVar;
                return this.f16071h;
            }
        }
        return null;
    }
}
