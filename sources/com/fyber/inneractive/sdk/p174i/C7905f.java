package com.fyber.inneractive.sdk.p174i;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.C7711i;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.p165f.C7730b;
import com.fyber.inneractive.sdk.p174i.C7899a.C7902c;
import com.fyber.inneractive.sdk.p174i.C7917p.C7918a;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.C8016n;
import com.fyber.inneractive.sdk.util.C8040x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.mopub.mobileads.VastResourceXmlManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.fyber.inneractive.sdk.i.f */
public final class C7905f extends C7904c {

    /* renamed from: c */
    boolean f16021c = true;

    /* renamed from: d */
    C7908j f16022d;

    /* renamed from: e */
    int f16023e;

    /* renamed from: f */
    int f16024f;

    /* renamed from: g */
    int f16025g;

    /* renamed from: h */
    C7711i f16026h;

    /* renamed from: i */
    private boolean f16027i;

    /* renamed from: j */
    private int f16028j = 0;

    /* renamed from: k */
    private int f16029k = 1;

    /* renamed from: l */
    private C7730b f16030l;

    /* renamed from: com.fyber.inneractive.sdk.i.f$a */
    class C7906a implements Comparator<C7899a> {
        C7906a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            C7899a aVar = (C7899a) obj;
            C7899a aVar2 = (C7899a) obj2;
            if (Integer.valueOf(aVar2.f15985f).intValue() > C7905f.this.f16025g && Integer.valueOf(aVar.f15985f).intValue() <= C7905f.this.f16025g) {
                return -1;
            }
            if (Integer.valueOf(aVar.f15985f).intValue() > C7905f.this.f16025g && Integer.valueOf(aVar2.f15985f).intValue() <= C7905f.this.f16025g) {
                return 1;
            }
            int compareTo = aVar2.mo24710a().compareTo(aVar.mo24710a());
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Integer.valueOf(aVar2.f15985f).compareTo(Integer.valueOf(aVar.f15985f));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            int i = aVar.f15983d * aVar.f15984e;
            int i2 = aVar2.f15983d * aVar2.f15984e;
            int t = C8006j.m18081t() * C8006j.m18080s();
            int abs = Math.abs(i - t);
            int abs2 = Math.abs(i2 - t);
            if (abs < abs2) {
                return -1;
            }
            if (abs > abs2) {
                return 1;
            }
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C7907g mo24711a() {
        this.f16016a = new C7908j();
        return this.f16016a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo24716d() {
        return true;
    }

    /* renamed from: a */
    public final void mo24713a(String str, C7711i iVar) throws Exception {
        this.f16022d = (C7908j) this.f16016a;
        this.f16026h = iVar;
        this.f16022d.f16049s = new C7912m();
        this.f16022d.f16049s.f16075l = System.currentTimeMillis();
        if (this.f16021c) {
            if (str == null) {
                str = null;
            } else {
                str = C8040x.f16388c.mo24872a(str);
            }
        }
        int y = IAConfigManager.m17011y();
        this.f16022d.f16049s.mo24726b(null, str);
        try {
            C7917p a = m17825a(str);
            while (a.f16105a) {
                StringBuilder sb = new StringBuilder("Vast response parser: found VAST wrapper #");
                sb.append(this.f16029k);
                IAlog.m18021b(sb.toString());
                this.f16029k++;
                if (this.f16029k > y) {
                    IAlog.m18021b("Vast response parser: too many vast wrappers! stopping");
                    this.f16022d.f16041j = "VastErrorTooManyWrappers";
                    return;
                }
                String str2 = a.f16106b;
                String b = m17828b(a.f16106b);
                this.f16022d.f16049s.mo24726b(str2, b);
                a = m17825a(b);
            }
            if (this.f16022d != null) {
                List<C7899a> list = this.f16022d.f16049s.f16068e;
                if (list != null) {
                    if (list.size() != 0) {
                        this.f16023e = this.f16026h.f15366f.f15369b.intValue();
                        this.f16024f = this.f16026h.f15366f.f15370c.intValue();
                        this.f16025g = this.f16026h.f15366f.f15374g.intValue();
                        m17829b(list);
                        if (this.f16022d.f16049s.f16068e.size() == 0) {
                            this.f16022d.f16041j = "ErrorNoCompatibleMediaFile";
                        }
                        this.f16022d.f16049s.f16070g = m17826a(this.f16022d.f16049s.f16070g);
                    }
                }
                IAlog.m18021b("Vast response parser: did not find any media files after unwrapping all VAST :( Empty VAST detected");
                this.f16022d.f16041j = "ErrorNoMediaFiles";
            }
        } catch (InterruptedException e) {
            throw e;
        } catch (C7918a e2) {
            StringBuilder sb2 = new StringBuilder("Vast Parsing failed with security exception: ");
            sb2.append(e2.getMessage());
            IAlog.m18021b(sb2.toString());
            this.f16022d.f16041j = "VastErrorUnsecure";
        } catch (Exception e3) {
            this.f16022d.f16041j = "VastErrorInvalidFile";
        }
    }

    /* renamed from: a */
    private static List<C7910l> m17826a(List<C7910l> list) {
        ArrayList arrayList = new ArrayList();
        for (C7910l lVar : list) {
            boolean isEmpty = TextUtils.isEmpty(lVar.f16054c);
            String str = VastResourceXmlManager.STATIC_RESOURCE;
            if (!isEmpty && lVar.f16054c.equals(str) && !TextUtils.isEmpty(lVar.f16055d) && (lVar.f16055d.equals("image/jpeg") || lVar.f16055d.equals("image/gif"))) {
                arrayList.add(lVar);
            } else if (!TextUtils.isEmpty(lVar.f16054c) && !lVar.f16054c.equals(str)) {
                arrayList.add(lVar);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private C7917p m17825a(String str) throws Exception {
        try {
            boolean z = true;
            if (!this.f16027i) {
                this.f16027i = true;
            }
            C7912m mVar = this.f16022d.f16049s;
            if (C8016n.m18093a()) {
                z = false;
            }
            return new C7917p(str, mVar, z);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b0 A[LOOP:0: B:0:0x0000->B:22:0x00b0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7 A[EDGE_INSN: B:35:0x00b7->B:23:0x00b7 ?: BREAK  , SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m17828b(java.lang.String r6) throws java.lang.Exception {
        /*
            r5 = this;
        L_0x0000:
            com.fyber.inneractive.sdk.f.b r0 = new com.fyber.inneractive.sdk.f.b
            r0.<init>(r6)
            r5.f16030l = r0
            com.fyber.inneractive.sdk.f.b r6 = r5.f16030l
            int r0 = com.fyber.inneractive.sdk.util.C7986aa.f16295a
            r6.f15437c = r0
            int r0 = com.fyber.inneractive.sdk.util.C7986aa.f16296b
            r1 = 0
            boolean r6 = r6.mo24296a(r0, r1)
            r0 = 1
            if (r6 == 0) goto L_0x00b7
            com.fyber.inneractive.sdk.f.b r6 = r5.f16030l
            r6.mo24297a(r0)
            com.fyber.inneractive.sdk.f.b r6 = r5.f16030l
            if (r6 == 0) goto L_0x00a8
            int r6 = r6.mo24300d()
            r2 = 302(0x12e, float:4.23E-43)
            if (r6 == r2) goto L_0x0031
            r2 = 303(0x12f, float:4.25E-43)
            if (r6 == r2) goto L_0x0031
            r2 = 307(0x133, float:4.3E-43)
            if (r6 != r2) goto L_0x00a8
        L_0x0031:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "vast parser received redirect code "
            r2.<init>(r3)
            java.lang.String r3 = java.lang.Integer.toString(r6)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r2)
            int r2 = r5.f16028j
            r3 = 5
            java.lang.String r4 = "AdServer returned HTTP "
            if (r2 > r3) goto L_0x008d
            int r2 = r2 + 1
            r5.f16028j = r2
            com.fyber.inneractive.sdk.f.b r2 = r5.f16030l
            com.fyber.inneractive.sdk.f.a r3 = com.fyber.inneractive.sdk.p165f.C7729a.LOCATION
            java.lang.String r2 = com.fyber.inneractive.sdk.util.C8017o.C8018a.m18101a(r2, r3)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0072
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r3 = "AdRequest: redirecting target url: "
            r6.<init>(r3)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)
            r6 = r2
            goto L_0x00a9
        L_0x0072:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r6 = java.lang.Integer.toString(r6)
            r1.append(r6)
            java.lang.String r6 = " with empty location header!"
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x008d:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r6 = java.lang.Integer.toString(r6)
            r1.append(r6)
            java.lang.String r6 = " aborting! more than 5 redirects"
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x00a8:
            r6 = r1
        L_0x00a9:
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            if (r2 != 0) goto L_0x00b7
            com.fyber.inneractive.sdk.f.b r0 = r5.f16030l
            r0.mo24301e()
            goto L_0x0000
        L_0x00b7:
            com.fyber.inneractive.sdk.f.b r6 = r5.f16030l
            r2 = 0
            if (r6 != 0) goto L_0x00c4
            java.lang.String r6 = "null connection returned"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)
            goto L_0x00e8
        L_0x00c4:
            int r6 = r6.mo24300d()
            r3 = 200(0xc8, float:2.8E-43)
            if (r6 == r3) goto L_0x00e7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "vast parser received http status code: "
            r0.<init>(r3)
            java.lang.String r6 = java.lang.Integer.toString(r6)
            r0.append(r6)
            java.lang.String r6 = ". Invalid response."
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)
            goto L_0x00e8
        L_0x00e7:
            r2 = 1
        L_0x00e8:
            if (r2 == 0) goto L_0x00f2
            com.fyber.inneractive.sdk.f.b r6 = r5.f16030l
            java.lang.StringBuffer r6 = r6.f15438d
            java.lang.String r1 = r6.toString()
        L_0x00f2:
            com.fyber.inneractive.sdk.f.b r6 = r5.f16030l
            r6.mo24301e()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p174i.C7905f.m17828b(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private void m17829b(List<C7899a> list) {
        Object obj;
        boolean z;
        int size = list.size();
        IAlog.m18021b("Vast Parser: Going over media files for filtering: ");
        int i = size;
        int i2 = 0;
        while (i2 < i) {
            C7899a aVar = (C7899a) list.get(i2);
            StringBuilder sb = new StringBuilder("Vast Parser: Found media file (");
            sb.append(i2);
            sb.append(") - type = ");
            sb.append(aVar.f15982c);
            sb.append(" bitrate = ");
            sb.append(Integer.valueOf(aVar.f15985f));
            IAlog.m18021b(sb.toString());
            C7901b bVar = null;
            if (!aVar.f15981b.equals(C7900a.progressive)) {
                bVar = C7901b.UNSUPPORTED_DELIVERY;
                obj = "progressive";
                z = false;
            } else if (Integer.valueOf(aVar.f15985f).intValue() != 0 && (Integer.valueOf(aVar.f15985f).intValue() < this.f16024f || Integer.valueOf(aVar.f15985f).intValue() > this.f16023e)) {
                bVar = C7901b.BITRATE_NOT_IN_RANGE;
                obj = Integer.valueOf(this.f16023e);
                z = false;
            } else if (!m17827a(aVar)) {
                obj = null;
                bVar = C7901b.UNSUPPORTED_MIME_TYPE;
                z = false;
            } else if (!UnitDisplayType.VERTICAL.equals(this.f16026h.f15366f.f15377j) || aVar.f15983d < aVar.f15984e) {
                String str = aVar.f15988i;
                if (str == null || !str.equalsIgnoreCase("VPAID") || !this.f16026h.f15366f.f15378k.contains(Integer.valueOf(2))) {
                    obj = null;
                    z = true;
                } else {
                    obj = null;
                    bVar = C7901b.FILTERED_BY_APP_OR_UNIT;
                    z = false;
                }
            } else {
                obj = null;
                bVar = C7901b.VERTICAL_VIDEO_EXPECTED;
                z = false;
            }
            if (!z) {
                StringBuilder sb2 = new StringBuilder("Vast Parser: skipping ad: error = ");
                sb2.append(bVar);
                IAlog.m18021b(sb2.toString());
                C7899a aVar2 = (C7899a) list.remove(i2);
                aVar2.f15989j = bVar;
                aVar2.f15990k = obj;
                C7912m mVar = this.f16022d.f16049s;
                if (mVar.f16069f == null) {
                    mVar.f16069f = new ArrayList();
                }
                mVar.f16069f.add(aVar2);
                i2--;
                i--;
            }
            i2++;
        }
        IAlog.m18021b("Vast Parser: printing media files after filtering:");
        m17830c(list);
        Collections.sort(list, new C7906a());
        IAlog.m18021b("Vast Parser: printing media files after final sorting:");
        m17830c(list);
    }

    /* renamed from: a */
    private static boolean m17827a(C7899a aVar) {
        for (C7902c cVar : C7902c.values()) {
            if (cVar.f16007e.equals(aVar.f15982c)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static void m17830c(List<C7899a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C7899a aVar = (C7899a) list.get(i);
            StringBuilder sb = new StringBuilder("Vast Parser: Found media file (");
            sb.append(i);
            sb.append(") - type = ");
            sb.append(aVar.f15982c);
            sb.append(" bitrate = ");
            sb.append(Integer.valueOf(aVar.f15985f));
            IAlog.m18021b(sb.toString());
        }
    }
}
