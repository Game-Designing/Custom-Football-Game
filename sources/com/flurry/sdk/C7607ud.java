package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.ud */
public class C7607ud {

    /* renamed from: a */
    private Map<String, Object> f15107a = new HashMap();

    /* renamed from: b */
    private Map<String, List<C7608a>> f15108b = new HashMap();

    /* renamed from: com.flurry.sdk.ud$a */
    public interface C7608a {
        /* renamed from: a */
        void mo23820a(String str, Object obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo24025a(java.lang.String r3, java.lang.Object r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f15107a     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0054 }
            if (r4 == r0) goto L_0x001d
            if (r4 == 0) goto L_0x001b
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r0 = 0
            goto L_0x001e
        L_0x001d:
            r0 = 1
        L_0x001e:
            if (r0 != 0) goto L_0x0052
            if (r4 != 0) goto L_0x0028
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f15107a     // Catch:{ all -> 0x0054 }
            r0.remove(r3)     // Catch:{ all -> 0x0054 }
            goto L_0x002d
        L_0x0028:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f15107a     // Catch:{ all -> 0x0054 }
            r0.put(r3, r4)     // Catch:{ all -> 0x0054 }
        L_0x002d:
            java.util.Map<java.lang.String, java.util.List<com.flurry.sdk.ud$a>> r0 = r2.f15108b     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0052
            java.util.Map<java.lang.String, java.util.List<com.flurry.sdk.ud$a>> r0 = r2.f15108b     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0054 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0054 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0054 }
        L_0x0042:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0054 }
            com.flurry.sdk.ud$a r1 = (com.flurry.sdk.C7607ud.C7608a) r1     // Catch:{ all -> 0x0054 }
            r1.mo23820a(r3, r4)     // Catch:{ all -> 0x0054 }
            goto L_0x0042
        L_0x0052:
            monitor-exit(r2)
            return
        L_0x0054:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x0058
        L_0x0057:
            throw r3
        L_0x0058:
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7607ud.mo24025a(java.lang.String, java.lang.Object):void");
    }

    /* renamed from: a */
    public final synchronized Object mo24023a(String str) {
        return this.f15107a.get(str);
    }

    /* renamed from: a */
    public final synchronized void mo24024a(String str, C7608a aVar) {
        if (!TextUtils.isEmpty(str)) {
            List list = (List) this.f15108b.get(str);
            if (list == null) {
                list = new LinkedList();
            }
            list.add(aVar);
            this.f15108b.put(str, list);
        }
    }

    /* renamed from: b */
    public final synchronized boolean mo24026b(String str, C7608a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (aVar == null) {
            return false;
        }
        List list = (List) this.f15108b.get(str);
        if (list == null) {
            return false;
        }
        return list.remove(aVar);
    }
}
