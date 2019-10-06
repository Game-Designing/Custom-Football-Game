package com.flurry.sdk;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.flurry.sdk.Rc */
public class C7448Rc {

    /* renamed from: a */
    public static final Integer f14632a = Integer.valueOf(50);

    /* renamed from: b */
    private static final String f14633b = C7448Rc.class.getSimpleName();

    /* renamed from: c */
    String f14634c;

    /* renamed from: d */
    LinkedHashMap<String, List<String>> f14635d;

    public C7448Rc(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("Main");
        this.f14634c = sb.toString();
        m16467b(this.f14634c);
    }

    /* renamed from: b */
    private void m16467b(String str) {
        this.f14635d = new LinkedHashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        if (m16468c(str)) {
            List d = m16469d(str);
            if (d != null && d.size() > 0) {
                arrayList.addAll(d);
                for (String e : arrayList) {
                    m16470e(e);
                }
            }
            m16471f(str);
        } else {
            List<C7463Uc> list = (List) new C7443Qb(C7379Fb.m16300a().f14432d.getFileStreamPath(m16472g(this.f14634c)), str, 1, new C7421Mc(this)).mo23881a();
            if (list == null) {
                C7513ec.m16649c(f14633b, "New main file also not found. returning..");
                return;
            }
            for (C7463Uc uc : list) {
                arrayList.add(uc.f14709a);
            }
        }
        for (String str2 : arrayList) {
            this.f14635d.put(str2, m16473h(str2));
        }
    }

    /* renamed from: c */
    private synchronized boolean m16468c(String str) {
        File fileStreamPath;
        fileStreamPath = C7379Fb.m16300a().f14432d.getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        String str2 = f14633b;
        StringBuilder sb = new StringBuilder("isOldIndexFilePresent: for ");
        sb.append(str);
        sb.append(fileStreamPath.exists());
        C7513ec.m16639a(5, str2, sb.toString());
        return fileStreamPath.exists();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bf, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c1, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c2, code lost:
        r1 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bf A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0073] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.List<java.lang.String> m16469d(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.flurry.sdk.C7354Ad.m16260a()     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = f14633b     // Catch:{ all -> 0x00e4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = "Reading Index File for "
            r1.<init>(r2)     // Catch:{ all -> 0x00e4 }
            r1.append(r9)     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = " file name:"
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            com.flurry.sdk.Fb r2 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ all -> 0x00e4 }
            android.content.Context r2 = r2.f14432d     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = ".FlurrySenderIndex.info."
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x00e4 }
            java.io.File r2 = r2.getFileStreamPath(r3)     // Catch:{ all -> 0x00e4 }
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            r2 = 5
            com.flurry.sdk.C7513ec.m16639a(r2, r0, r1)     // Catch:{ all -> 0x00e4 }
            com.flurry.sdk.Fb r0 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ all -> 0x00e4 }
            android.content.Context r0 = r0.f14432d     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = ".FlurrySenderIndex.info."
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.concat(r3)     // Catch:{ all -> 0x00e4 }
            java.io.File r0 = r0.getFileStreamPath(r1)     // Catch:{ all -> 0x00e4 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x00e4 }
            r3 = 0
            if (r1 == 0) goto L_0x00da
            java.lang.String r1 = f14633b     // Catch:{ all -> 0x00e4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            java.lang.String r5 = "Reading Index File for "
            r4.<init>(r5)     // Catch:{ all -> 0x00e4 }
            r4.append(r9)     // Catch:{ all -> 0x00e4 }
            java.lang.String r9 = " Found file."
            r4.append(r9)     // Catch:{ all -> 0x00e4 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x00e4 }
            com.flurry.sdk.C7513ec.m16639a(r2, r1, r9)     // Catch:{ all -> 0x00e4 }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x00c8 }
            r9.<init>(r0)     // Catch:{ Throwable -> 0x00c8 }
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch:{ Throwable -> 0x00c8 }
            r0.<init>(r9)     // Catch:{ Throwable -> 0x00c8 }
            int r9 = r0.readUnsignedShort()     // Catch:{ Throwable -> 0x00c1, all -> 0x00bf }
            if (r9 != 0) goto L_0x007e
            com.flurry.sdk.C7354Ad.m16261a(r0)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r8)
            return r3
        L_0x007e:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Throwable -> 0x00c1, all -> 0x00bf }
            r1.<init>(r9)     // Catch:{ Throwable -> 0x00c1, all -> 0x00bf }
            r2 = 0
        L_0x0084:
            if (r2 >= r9) goto L_0x00b6
            int r3 = r0.readUnsignedShort()     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            r4 = 4
            java.lang.String r5 = f14633b     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            java.lang.String r7 = "read iter "
            r6.<init>(r7)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            r6.append(r2)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            java.lang.String r7 = " dataLength = "
            r6.append(r7)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            r6.append(r3)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            com.flurry.sdk.C7513ec.m16639a(r4, r5, r6)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            r0.readFully(r3)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            java.lang.String r4 = new java.lang.String     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            r4.<init>(r3)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            r1.add(r4)     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            int r2 = r2 + 1
            goto L_0x0084
        L_0x00b6:
            r0.readUnsignedShort()     // Catch:{ Throwable -> 0x00bd, all -> 0x00bf }
            com.flurry.sdk.C7354Ad.m16261a(r0)     // Catch:{ all -> 0x00e4 }
            goto L_0x00d5
        L_0x00bd:
            r9 = move-exception
            goto L_0x00c3
        L_0x00bf:
            r9 = move-exception
            goto L_0x00d6
        L_0x00c1:
            r9 = move-exception
            r1 = r3
        L_0x00c3:
            r3 = r0
            goto L_0x00ca
        L_0x00c5:
            r9 = move-exception
            r0 = r3
            goto L_0x00d6
        L_0x00c8:
            r9 = move-exception
            r1 = r3
        L_0x00ca:
            r0 = 6
            java.lang.String r2 = f14633b     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "Error when loading persistent file"
            com.flurry.sdk.C7513ec.m16640a(r0, r2, r4, r9)     // Catch:{ all -> 0x00c5 }
            com.flurry.sdk.C7354Ad.m16261a(r3)     // Catch:{ all -> 0x00e4 }
        L_0x00d5:
            goto L_0x00e2
        L_0x00d6:
            com.flurry.sdk.C7354Ad.m16261a(r0)     // Catch:{ all -> 0x00e4 }
            throw r9     // Catch:{ all -> 0x00e4 }
        L_0x00da:
            java.lang.String r9 = f14633b     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = "Agent cache file doesn't exist."
            com.flurry.sdk.C7513ec.m16639a(r2, r9, r0)     // Catch:{ all -> 0x00e4 }
            r1 = r3
        L_0x00e2:
            monitor-exit(r8)
            return r1
        L_0x00e4:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00e8
        L_0x00e7:
            throw r9
        L_0x00e8:
            goto L_0x00e7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7448Rc.m16469d(java.lang.String):java.util.List");
    }

    /* renamed from: e */
    private void m16470e(String str) {
        List<String> d = m16469d(str);
        if (d == null) {
            C7513ec.m16649c(f14633b, "No old file to replace");
            return;
        }
        for (String str2 : d) {
            byte[] i = m16474i(str2);
            if (i == null) {
                C7513ec.m16639a(6, f14633b, "File does not exist");
            } else {
                m16466a(str2, i);
                C7354Ad.m16260a();
                String str3 = f14633b;
                StringBuilder sb = new StringBuilder("Deleting  block File for ");
                sb.append(str2);
                sb.append(" file name:");
                String str4 = ".flurrydatasenderblock.";
                sb.append(C7379Fb.m16300a().f14432d.getFileStreamPath(str4.concat(String.valueOf(str2))));
                C7513ec.m16639a(5, str3, sb.toString());
                File fileStreamPath = C7379Fb.m16300a().f14432d.getFileStreamPath(str4.concat(String.valueOf(str2)));
                if (fileStreamPath.exists()) {
                    boolean delete = fileStreamPath.delete();
                    String str5 = f14633b;
                    StringBuilder sb2 = new StringBuilder("Found file for ");
                    sb2.append(str2);
                    sb2.append(". Deleted - ");
                    sb2.append(delete);
                    C7513ec.m16639a(5, str5, sb2.toString());
                }
            }
        }
        m16465a(str, d, ".YFlurrySenderIndex.info.");
        m16471f(str);
    }

    /* renamed from: f */
    private static void m16471f(String str) {
        C7354Ad.m16260a();
        String str2 = f14633b;
        StringBuilder sb = new StringBuilder("Deleting Index File for ");
        sb.append(str);
        sb.append(" file name:");
        String str3 = ".FlurrySenderIndex.info.";
        sb.append(C7379Fb.m16300a().f14432d.getFileStreamPath(str3.concat(String.valueOf(str))));
        C7513ec.m16639a(5, str2, sb.toString());
        File fileStreamPath = C7379Fb.m16300a().f14432d.getFileStreamPath(str3.concat(String.valueOf(str)));
        if (fileStreamPath.exists()) {
            boolean delete = fileStreamPath.delete();
            String str4 = f14633b;
            StringBuilder sb2 = new StringBuilder("Found file for ");
            sb2.append(str);
            sb2.append(". Deleted - ");
            sb2.append(delete);
            C7513ec.m16639a(5, str4, sb2.toString());
        }
    }

    /* renamed from: g */
    private static String m16472g(String str) {
        return ".YFlurrySenderIndex.info.".concat(String.valueOf(str));
    }

    /* renamed from: h */
    private synchronized List<String> m16473h(String str) {
        ArrayList arrayList;
        C7354Ad.m16260a();
        String str2 = f14633b;
        StringBuilder sb = new StringBuilder("Reading Index File for ");
        sb.append(str);
        sb.append(" file name:");
        sb.append(C7379Fb.m16300a().f14432d.getFileStreamPath(m16472g(str)));
        C7513ec.m16639a(5, str2, sb.toString());
        List<C7463Uc> list = (List) new C7443Qb(C7379Fb.m16300a().f14432d.getFileStreamPath(m16472g(str)), ".YFlurrySenderIndex.info.", 1, new C7427Nc(this)).mo23881a();
        arrayList = new ArrayList();
        for (C7463Uc uc : list) {
            arrayList.add(uc.f14709a);
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m16474i(java.lang.String r7) {
        /*
            com.flurry.sdk.C7354Ad.m16260a()
            java.lang.String r0 = f14633b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Reading block File for "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r2 = " file name:"
            r1.append(r2)
            com.flurry.sdk.Fb r2 = com.flurry.sdk.C7379Fb.m16300a()
            android.content.Context r2 = r2.f14432d
            java.lang.String r3 = java.lang.String.valueOf(r7)
            java.lang.String r4 = ".flurrydatasenderblock."
            java.lang.String r3 = r4.concat(r3)
            java.io.File r2 = r2.getFileStreamPath(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 5
            com.flurry.sdk.C7513ec.m16639a(r2, r0, r1)
            com.flurry.sdk.Fb r0 = com.flurry.sdk.C7379Fb.m16300a()
            android.content.Context r0 = r0.f14432d
            java.lang.String r1 = java.lang.String.valueOf(r7)
            java.lang.String r1 = r4.concat(r1)
            java.io.File r0 = r0.getFileStreamPath(r1)
            boolean r1 = r0.exists()
            r3 = 0
            if (r1 == 0) goto L_0x00a3
            java.lang.String r1 = f14633b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Reading Index File for "
            r4.<init>(r5)
            r4.append(r7)
            java.lang.String r7 = " Found file."
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            com.flurry.sdk.C7513ec.m16639a(r2, r1, r7)
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0090 }
            r7.<init>(r0)     // Catch:{ Throwable -> 0x0090 }
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch:{ Throwable -> 0x0090 }
            r0.<init>(r7)     // Catch:{ Throwable -> 0x0090 }
            int r7 = r0.readUnsignedShort()     // Catch:{ Throwable -> 0x0089, all -> 0x0086 }
            if (r7 != 0) goto L_0x007a
            com.flurry.sdk.C7354Ad.m16261a(r0)
            return r3
        L_0x007a:
            byte[] r3 = new byte[r7]     // Catch:{ Throwable -> 0x0089, all -> 0x0086 }
            r0.readFully(r3)     // Catch:{ Throwable -> 0x0089, all -> 0x0086 }
            r0.readUnsignedShort()     // Catch:{ Throwable -> 0x0089, all -> 0x0086 }
            com.flurry.sdk.C7354Ad.m16261a(r0)
            goto L_0x00ab
        L_0x0086:
            r7 = move-exception
            r3 = r0
            goto L_0x009f
        L_0x0089:
            r7 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x0092
        L_0x008e:
            r7 = move-exception
            goto L_0x009f
        L_0x0090:
            r7 = move-exception
            r0 = r3
        L_0x0092:
            r1 = 6
            java.lang.String r2 = f14633b     // Catch:{ all -> 0x008e }
            java.lang.String r4 = "Error when loading persistent file"
            com.flurry.sdk.C7513ec.m16640a(r1, r2, r4, r7)     // Catch:{ all -> 0x008e }
            com.flurry.sdk.C7354Ad.m16261a(r3)
            r3 = r0
            goto L_0x00ab
        L_0x009f:
            com.flurry.sdk.C7354Ad.m16261a(r3)
            throw r7
        L_0x00a3:
            r7 = 4
            java.lang.String r0 = f14633b
            java.lang.String r1 = "Agent cache file doesn't exist."
            com.flurry.sdk.C7513ec.m16639a(r7, r0, r1)
        L_0x00ab:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7448Rc.m16474i(java.lang.String):byte[]");
    }

    /* renamed from: a */
    private synchronized void m16466a(String str, byte[] bArr) {
        C7354Ad.m16260a();
        String str2 = f14633b;
        StringBuilder sb = new StringBuilder("Saving Block File for ");
        sb.append(str);
        sb.append(" file name:");
        sb.append(C7379Fb.m16300a().f14432d.getFileStreamPath(C7413Lc.m16407a(str)));
        C7513ec.m16639a(5, str2, sb.toString());
        C7413Lc.m16408b(str).mo23882a(new C7413Lc(bArr));
    }

    /* renamed from: a */
    private synchronized void m16465a(String str, List<String> list, String str2) {
        C7354Ad.m16260a();
        String str3 = f14633b;
        StringBuilder sb = new StringBuilder("Saving Index File for ");
        sb.append(str);
        sb.append(" file name:");
        sb.append(C7379Fb.m16300a().f14432d.getFileStreamPath(m16472g(str)));
        C7513ec.m16639a(5, str3, sb.toString());
        C7443Qb qb = new C7443Qb(C7379Fb.m16300a().f14432d.getFileStreamPath(m16472g(str)), str2, 1, new C7432Oc(this));
        ArrayList arrayList = new ArrayList();
        for (String uc : list) {
            arrayList.add(new C7463Uc(uc));
        }
        qb.mo23882a(arrayList);
    }

    /* renamed from: a */
    public final synchronized void mo23887a(C7413Lc lc, String str) {
        boolean z;
        C7513ec.m16639a(4, f14633b, "addBlockInfo".concat(String.valueOf(str)));
        String str2 = lc.f14534a;
        List list = (List) this.f14635d.get(str);
        if (list == null) {
            C7513ec.m16639a(4, f14633b, "New Data Key");
            list = new LinkedList();
            z = true;
        } else {
            z = false;
        }
        list.add(str2);
        if (list.size() > f14632a.intValue()) {
            C7413Lc.m16408b((String) list.get(0)).mo23883b();
            list.remove(0);
        }
        this.f14635d.put(str, list);
        m16465a(str, list, ".YFlurrySenderIndex.info.");
        if (z) {
            m16464a();
        }
    }

    /* renamed from: a */
    private synchronized void m16464a() {
        LinkedList linkedList = new LinkedList(this.f14635d.keySet());
        new C7443Qb(C7379Fb.m16300a().f14432d.getFileStreamPath(m16472g(this.f14634c)), ".YFlurrySenderIndex.info.", 1, new C7438Pc(this)).mo23883b();
        if (!linkedList.isEmpty()) {
            m16465a(this.f14634c, linkedList, this.f14634c);
        }
    }

    /* renamed from: a */
    public final boolean mo23888a(String str, String str2) {
        boolean z;
        List list = (List) this.f14635d.get(str2);
        if (list != null) {
            C7413Lc.m16408b(str).mo23883b();
            z = list.remove(str);
        } else {
            z = false;
        }
        if (list == null || list.isEmpty()) {
            m16475j(str2);
        } else {
            this.f14635d.put(str2, list);
            m16465a(str2, list, ".YFlurrySenderIndex.info.");
        }
        return z;
    }

    /* renamed from: j */
    private synchronized boolean m16475j(String str) {
        boolean b;
        C7354Ad.m16260a();
        C7443Qb qb = new C7443Qb(C7379Fb.m16300a().f14432d.getFileStreamPath(m16472g(str)), ".YFlurrySenderIndex.info.", 1, new C7444Qc(this));
        List<String> a = mo23886a(str);
        if (a != null) {
            String str2 = f14633b;
            StringBuilder sb = new StringBuilder("discardOutdatedBlocksForDataKey: notSentBlocks = ");
            sb.append(a.size());
            C7513ec.m16639a(4, str2, sb.toString());
            for (String str3 : a) {
                C7413Lc.m16408b(str3).mo23883b();
                C7513ec.m16639a(4, f14633b, "discardOutdatedBlocksForDataKey: removed block = ".concat(String.valueOf(str3)));
            }
        }
        this.f14635d.remove(str);
        b = qb.mo23883b();
        m16464a();
        return b;
    }

    /* renamed from: a */
    public final List<String> mo23886a(String str) {
        return (List) this.f14635d.get(str);
    }
}
