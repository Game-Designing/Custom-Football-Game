package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzard
public class zzaju<ReferenceT> implements zzajt {

    /* renamed from: a */
    private final Map<String, CopyOnWriteArrayList<zzaho<? super ReferenceT>>> f24376a = new HashMap();

    /* renamed from: b */
    private ReferenceT f24377b;

    /* renamed from: a */
    public final void mo29784a(ReferenceT referencet) {
        this.f24377b = referencet;
    }

    /* renamed from: b */
    public final boolean mo29781b(String str) {
        return str != null && mo29787a(Uri.parse(str));
    }

    /* renamed from: a */
    public final boolean mo29787a(Uri uri) {
        if ("gmsg".equalsIgnoreCase(uri.getScheme())) {
            if ("mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
                mo29788b(uri);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void mo29788b(Uri uri) {
        String path = uri.getPath();
        zzk.zzlg();
        m25127b(path, zzaxi.m26107a(uri));
    }

    /* renamed from: b */
    private final synchronized void m25127b(String str, Map<String, String> map) {
        if (zzbad.m26354a(2)) {
            String str2 = "Received GMSG: ";
            String valueOf = String.valueOf(str);
            zzawz.m26003f(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            for (String str3 : map.keySet()) {
                String str4 = (String) map.get(str3);
                StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 4 + String.valueOf(str4).length());
                sb.append("  ");
                sb.append(str3);
                sb.append(": ");
                sb.append(str4);
                zzawz.m26003f(sb.toString());
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f24376a.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzbbm.f25064a.execute(new C9331ba(this, (zzaho) it.next(), map));
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo29786a(String str, zzaho<? super ReferenceT> zzaho) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f24376a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f24376a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzaho);
    }

    /* renamed from: b */
    public final synchronized void mo29789b(String str, zzaho<? super ReferenceT> zzaho) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f24376a.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(zzaho);
        }
    }

    /* renamed from: a */
    public final synchronized void mo29785a(String str, Predicate<zzaho<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f24376a.get(str);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzaho zzaho = (zzaho) it.next();
                if (predicate.apply(zzaho)) {
                    arrayList.add(zzaho);
                }
            }
            copyOnWriteArrayList.removeAll(arrayList);
        }
    }

    /* renamed from: a */
    public final synchronized void mo29782a() {
        this.f24376a.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo29783a(zzaho zzaho, Map map) {
        zzaho.mo27996a(this.f24377b, map);
    }
}
