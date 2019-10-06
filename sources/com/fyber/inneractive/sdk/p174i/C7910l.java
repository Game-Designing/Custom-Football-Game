package com.fyber.inneractive.sdk.p174i;

import com.fyber.inneractive.sdk.p174i.C7915o.C7916a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.fyber.inneractive.sdk.i.l */
public final class C7910l implements C7914n {

    /* renamed from: a */
    int f16052a;

    /* renamed from: b */
    int f16053b;

    /* renamed from: c */
    public String f16054c;

    /* renamed from: d */
    public String f16055d;

    /* renamed from: e */
    public String f16056e;

    /* renamed from: f */
    public String f16057f;

    /* renamed from: g */
    private List<C7915o> f16058g = new ArrayList();

    /* renamed from: com.fyber.inneractive.sdk.i.l$a */
    public enum C7911a {
        ;
        

        /* renamed from: a */
        public static final int f16059a = 0;

        /* renamed from: b */
        public static final int f16060b = 0;

        /* renamed from: c */
        public static final int f16061c = 0;

        /* renamed from: d */
        public static final int f16062d = 0;

        /* renamed from: a */
        public static int[] m17841a() {
            return (int[]) f16063e.clone();
        }

        static {
            f16059a = 1;
            f16060b = 2;
            f16061c = 3;
            f16062d = 4;
            f16063e = new int[]{f16059a, f16060b, f16061c, f16062d};
        }
    }

    /* renamed from: a */
    public final void mo24721a(String str, String str2) {
        this.f16058g.add(new C7915o(str, str2));
    }

    /* renamed from: a */
    public final List<String> mo24720a(C7916a aVar) {
        ArrayList arrayList = new ArrayList();
        for (C7915o oVar : this.f16058g) {
            if (oVar.f16079a == aVar) {
                arrayList.add(oVar.f16080b);
            }
        }
        return arrayList;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Companion: ");
        sb.append(this.f16054c);
        String str = ":";
        sb.append(str);
        sb.append(this.f16055d);
        sb.append(str);
        sb.append(this.f16056e);
        return sb.toString();
    }
}
