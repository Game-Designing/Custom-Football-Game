package p002b.p003c.p053g.p059d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.p000v4.content.p036a.C0500a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p054a.C1213c;
import p002b.p003c.p053g.p054a.C1222j;
import p002b.p003c.p053g.p059d.C1240k.C1241a;
import p002b.p003c.p053g.p061f.C1260i;
import p002b.p003c.p053g.p061f.C1272p;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: b.c.g.d.f */
/* compiled from: FontsContractCompat */
public class C1232f {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C1260i<String, Typeface> f3972a = new C1260i<>(16);

    /* renamed from: b */
    private static final C1240k f3973b = new C1240k("fonts", 10, 10000);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Object f3974c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C1273q<String, ArrayList<C1241a<C1235c>>> f3975d = new C1273q<>();

    /* renamed from: e */
    private static final Comparator<byte[]> f3976e = new C1231e();

    /* renamed from: b.c.g.d.f$a */
    /* compiled from: FontsContractCompat */
    public static class C1233a {

        /* renamed from: a */
        private final int f3977a;

        /* renamed from: b */
        private final C1234b[] f3978b;

        public C1233a(int statusCode, C1234b[] fonts) {
            this.f3977a = statusCode;
            this.f3978b = fonts;
        }

        /* renamed from: b */
        public int mo9001b() {
            return this.f3977a;
        }

        /* renamed from: a */
        public C1234b[] mo9000a() {
            return this.f3978b;
        }
    }

    /* renamed from: b.c.g.d.f$b */
    /* compiled from: FontsContractCompat */
    public static class C1234b {

        /* renamed from: a */
        private final Uri f3979a;

        /* renamed from: b */
        private final int f3980b;

        /* renamed from: c */
        private final int f3981c;

        /* renamed from: d */
        private final boolean f3982d;

        /* renamed from: e */
        private final int f3983e;

        public C1234b(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            C1272p.m5959a(uri);
            this.f3979a = uri;
            this.f3980b = ttcIndex;
            this.f3981c = weight;
            this.f3982d = italic;
            this.f3983e = resultCode;
        }

        /* renamed from: c */
        public Uri mo9004c() {
            return this.f3979a;
        }

        /* renamed from: b */
        public int mo9003b() {
            return this.f3980b;
        }

        /* renamed from: d */
        public int mo9005d() {
            return this.f3981c;
        }

        /* renamed from: e */
        public boolean mo9006e() {
            return this.f3982d;
        }

        /* renamed from: a */
        public int mo9002a() {
            return this.f3983e;
        }
    }

    /* renamed from: b.c.g.d.f$c */
    /* compiled from: FontsContractCompat */
    private static final class C1235c {

        /* renamed from: a */
        final Typeface f3984a;

        /* renamed from: b */
        final int f3985b;

        C1235c(Typeface typeface, int result) {
            this.f3984a = typeface;
            this.f3985b = result;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static C1235c m5845b(Context context, C1227a request, int style) {
        try {
            C1233a result = m5837a(context, (CancellationSignal) null, request);
            int i = -3;
            if (result.mo9001b() == 0) {
                Typeface typeface = C1213c.m5771a(context, null, result.mo9000a(), style);
                if (typeface != null) {
                    i = 0;
                }
                return new C1235c(typeface, i);
            }
            if (result.mo9001b() == 1) {
                i = -2;
            }
            return new C1235c(null, i);
        } catch (NameNotFoundException e) {
            return new C1235c(null, -1);
        }
    }

    /* JADX INFO: used method not loaded: b.c.g.d.k.a(java.util.concurrent.Callable, b.c.g.d.k$a):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        f3973b.mo9012a((java.util.concurrent.Callable) r2, (p002b.p003c.p053g.p059d.C1240k.C1241a) new p002b.p003c.p053g.p059d.C1230d(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        return r3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface m5836a(android.content.Context r8, p002b.p003c.p053g.p059d.C1227a r9, android.support.p000v4.content.p036a.C0507d.C0508a r10, android.os.Handler r11, boolean r12, int r13, int r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r9.mo8989c()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            b.c.g.f.i<java.lang.String, android.graphics.Typeface> r1 = f3972a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r10 == 0) goto L_0x0027
            r10.mo5288a(r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r12 == 0) goto L_0x0043
            r2 = -1
            if (r13 != r2) goto L_0x0043
            b.c.g.d.f$c r2 = m5845b(r8, r9, r14)
            if (r10 == 0) goto L_0x0040
            int r3 = r2.f3985b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f3984a
            r10.mo5289a(r3, r11)
            goto L_0x0040
        L_0x003d:
            r10.mo5287a(r3, r11)
        L_0x0040:
            android.graphics.Typeface r3 = r2.f3984a
            return r3
        L_0x0043:
            b.c.g.d.b r2 = new b.c.g.d.b
            r2.<init>(r8, r9, r14, r0)
            r3 = 0
            if (r12 == 0) goto L_0x0058
            b.c.g.d.k r4 = f3973b     // Catch:{ InterruptedException -> 0x0056 }
            java.lang.Object r4 = r4.mo9011a(r2, r13)     // Catch:{ InterruptedException -> 0x0056 }
            b.c.g.d.f$c r4 = (p002b.p003c.p053g.p059d.C1232f.C1235c) r4     // Catch:{ InterruptedException -> 0x0056 }
            android.graphics.Typeface r3 = r4.f3984a     // Catch:{ InterruptedException -> 0x0056 }
            return r3
        L_0x0056:
            r4 = move-exception
            return r3
        L_0x0058:
            if (r10 != 0) goto L_0x005c
            r4 = r3
            goto L_0x0061
        L_0x005c:
            b.c.g.d.c r4 = new b.c.g.d.c
            r4.<init>(r10, r11)
        L_0x0061:
            java.lang.Object r5 = f3974c
            monitor-enter(r5)
            b.c.g.f.q<java.lang.String, java.util.ArrayList<b.c.g.d.k$a<b.c.g.d.f$c>>> r6 = f3975d     // Catch:{ all -> 0x0096 }
            boolean r6 = r6.containsKey(r0)     // Catch:{ all -> 0x0096 }
            if (r6 == 0) goto L_0x007b
            if (r4 == 0) goto L_0x0079
            b.c.g.f.q<java.lang.String, java.util.ArrayList<b.c.g.d.k$a<b.c.g.d.f$c>>> r6 = f3975d     // Catch:{ all -> 0x0096 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x0096 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x0096 }
            r6.add(r4)     // Catch:{ all -> 0x0096 }
        L_0x0079:
            monitor-exit(r5)     // Catch:{ all -> 0x0096 }
            return r3
        L_0x007b:
            if (r4 == 0) goto L_0x008a
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0096 }
            r6.<init>()     // Catch:{ all -> 0x0096 }
            r6.add(r4)     // Catch:{ all -> 0x0096 }
            b.c.g.f.q<java.lang.String, java.util.ArrayList<b.c.g.d.k$a<b.c.g.d.f$c>>> r7 = f3975d     // Catch:{ all -> 0x0096 }
            r7.put(r0, r6)     // Catch:{ all -> 0x0096 }
        L_0x008a:
            monitor-exit(r5)     // Catch:{ all -> 0x0096 }
            b.c.g.d.k r5 = f3973b
            b.c.g.d.d r6 = new b.c.g.d.d
            r6.<init>(r0)
            r5.mo9012a(r2, r6)
            return r3
        L_0x0096:
            r3 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0096 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p059d.C1232f.m5836a(android.content.Context, b.c.g.d.a, android.support.v4.content.a.d$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public static Map<Uri, ByteBuffer> m5842a(Context context, C1234b[] fonts, CancellationSignal cancellationSignal) {
        HashMap<Uri, ByteBuffer> out = new HashMap<>();
        for (C1234b font : fonts) {
            if (font.mo9002a() == 0) {
                Uri uri = font.mo9004c();
                if (!out.containsKey(uri)) {
                    out.put(uri, C1222j.m5815a(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(out);
    }

    /* renamed from: a */
    public static C1233a m5837a(Context context, CancellationSignal cancellationSignal, C1227a request) throws NameNotFoundException {
        ProviderInfo providerInfo = m5835a(context.getPackageManager(), request, context.getResources());
        if (providerInfo == null) {
            return new C1233a(1, null);
        }
        return new C1233a(0, m5844a(context, request, providerInfo.authority, cancellationSignal));
    }

    /* renamed from: a */
    public static ProviderInfo m5835a(PackageManager packageManager, C1227a request, Resources resources) throws NameNotFoundException {
        String providerAuthority = request.mo8990d();
        ProviderInfo info = packageManager.resolveContentProvider(providerAuthority, 0);
        if (info == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No package found for authority: ");
            sb.append(providerAuthority);
            throw new NameNotFoundException(sb.toString());
        } else if (info.packageName.equals(request.mo8991e())) {
            List<byte[]> signatures = m5841a(packageManager.getPackageInfo(info.packageName, 64).signatures);
            Collections.sort(signatures, f3976e);
            List<List<byte[]>> requestCertificatesList = m5840a(request, resources);
            for (int i = 0; i < requestCertificatesList.size(); i++) {
                List<byte[]> requestSignatures = new ArrayList<>((Collection) requestCertificatesList.get(i));
                Collections.sort(requestSignatures, f3976e);
                if (m5843a(signatures, requestSignatures)) {
                    return info;
                }
            }
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found content provider ");
            sb2.append(providerAuthority);
            sb2.append(", but package was not ");
            sb2.append(request.mo8991e());
            throw new NameNotFoundException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static List<List<byte[]>> m5840a(C1227a request, Resources resources) {
        if (request.mo8987a() != null) {
            return request.mo8987a();
        }
        return C0500a.m2525a(resources, request.mo8988b());
    }

    /* renamed from: a */
    private static boolean m5843a(List<byte[]> signatures, List<byte[]> requestSignatures) {
        if (signatures.size() != requestSignatures.size()) {
            return false;
        }
        for (int i = 0; i < signatures.size(); i++) {
            if (!Arrays.equals((byte[]) signatures.get(i), (byte[]) requestSignatures.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static List<byte[]> m5841a(Signature[] signatures) {
        List<byte[]> shas = new ArrayList<>();
        for (Signature byteArray : signatures) {
            shas.add(byteArray.toByteArray());
        }
        return shas;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0163  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static p002b.p003c.p053g.p059d.C1232f.C1234b[] m5844a(android.content.Context r24, p002b.p003c.p053g.p059d.C1227a r25, java.lang.String r26, android.os.CancellationSignal r27) {
        /*
            r1 = r26
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2 = r0
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r0 = r0.scheme(r3)
            android.net.Uri$Builder r0 = r0.authority(r1)
            android.net.Uri r11 = r0.build()
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            android.net.Uri$Builder r0 = r0.scheme(r3)
            android.net.Uri$Builder r0 = r0.authority(r1)
            java.lang.String r3 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r3)
            android.net.Uri r3 = r0.build()
            r12 = 0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x015e }
            r4 = 16
            java.lang.String r6 = "font_variation_settings"
            r9 = 7
            java.lang.String r13 = "result_code"
            java.lang.String r14 = "font_italic"
            java.lang.String r15 = "font_weight"
            java.lang.String r10 = "font_ttc_index"
            java.lang.String r5 = "file_id"
            java.lang.String r7 = "_id"
            r8 = 0
            if (r0 <= r4) goto L_0x008c
            android.content.ContentResolver r4 = r24.getContentResolver()     // Catch:{ all -> 0x015e }
            java.lang.String[] r0 = new java.lang.String[r9]     // Catch:{ all -> 0x015e }
            r0[r8] = r7     // Catch:{ all -> 0x015e }
            r9 = 1
            r0[r9] = r5     // Catch:{ all -> 0x015e }
            r9 = 2
            r0[r9] = r10     // Catch:{ all -> 0x015e }
            r9 = 3
            r0[r9] = r6     // Catch:{ all -> 0x015e }
            r6 = 4
            r0[r6] = r15     // Catch:{ all -> 0x015e }
            r6 = 5
            r0[r6] = r14     // Catch:{ all -> 0x015e }
            r6 = 6
            r0[r6] = r13     // Catch:{ all -> 0x015e }
            java.lang.String r9 = "query = ?"
            r6 = 1
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ all -> 0x015e }
            java.lang.String r17 = r25.mo8992f()     // Catch:{ all -> 0x015e }
            r16 = 0
            r8[r16] = r17     // Catch:{ all -> 0x015e }
            r17 = 0
            r1 = r5
            r5 = r11
            r18 = 1
            r6 = r0
            r0 = r7
            r7 = r9
            r19 = r2
            r2 = 0
            r9 = 1
            r9 = r17
            r21 = r10
            r10 = r27
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x015c }
            r12 = r4
            r2 = r21
            r10 = 1
            goto L_0x00ca
        L_0x008c:
            r19 = r2
            r1 = r5
            r0 = r7
            r21 = r10
            r2 = 0
            android.content.ContentResolver r4 = r24.getContentResolver()     // Catch:{ all -> 0x015c }
            java.lang.String[] r7 = new java.lang.String[r9]     // Catch:{ all -> 0x015c }
            r7[r2] = r0     // Catch:{ all -> 0x015c }
            r10 = 1
            r7[r10] = r1     // Catch:{ all -> 0x015c }
            r9 = r21
            r5 = 2
            r7[r5] = r9     // Catch:{ all -> 0x015c }
            r5 = 3
            r7[r5] = r6     // Catch:{ all -> 0x015c }
            r5 = 4
            r7[r5] = r15     // Catch:{ all -> 0x015c }
            r5 = 5
            r7[r5] = r14     // Catch:{ all -> 0x015c }
            r5 = 6
            r7[r5] = r13     // Catch:{ all -> 0x015c }
            java.lang.String r8 = "query = ?"
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ all -> 0x015c }
            java.lang.String r5 = r25.mo8992f()     // Catch:{ all -> 0x015c }
            r6[r2] = r5     // Catch:{ all -> 0x015c }
            r16 = 0
            r5 = r11
            r17 = r6
            r6 = r7
            r7 = r8
            r8 = r17
            r2 = r9
            r9 = r16
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x015c }
            r12 = r4
        L_0x00ca:
            if (r12 == 0) goto L_0x014b
            int r4 = r12.getCount()     // Catch:{ all -> 0x015c }
            if (r4 <= 0) goto L_0x014b
            int r4 = r12.getColumnIndex(r13)     // Catch:{ all -> 0x015c }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x015c }
            r5.<init>()     // Catch:{ all -> 0x015c }
            int r0 = r12.getColumnIndex(r0)     // Catch:{ all -> 0x0147 }
            int r1 = r12.getColumnIndex(r1)     // Catch:{ all -> 0x0147 }
            int r2 = r12.getColumnIndex(r2)     // Catch:{ all -> 0x0147 }
            int r6 = r12.getColumnIndex(r15)     // Catch:{ all -> 0x0147 }
            int r7 = r12.getColumnIndex(r14)     // Catch:{ all -> 0x0147 }
        L_0x00ef:
            boolean r8 = r12.moveToNext()     // Catch:{ all -> 0x0147 }
            if (r8 == 0) goto L_0x014d
            r8 = -1
            if (r4 == r8) goto L_0x00ff
            int r9 = r12.getInt(r4)     // Catch:{ all -> 0x0147 }
            r23 = r9
            goto L_0x0101
        L_0x00ff:
            r23 = 0
        L_0x0101:
            if (r2 == r8) goto L_0x010a
            int r9 = r12.getInt(r2)     // Catch:{ all -> 0x0147 }
            r20 = r9
            goto L_0x010c
        L_0x010a:
            r20 = 0
        L_0x010c:
            if (r1 != r8) goto L_0x0117
            long r13 = r12.getLong(r0)     // Catch:{ all -> 0x0147 }
            android.net.Uri r9 = android.content.ContentUris.withAppendedId(r11, r13)     // Catch:{ all -> 0x0147 }
            goto L_0x011f
        L_0x0117:
            long r13 = r12.getLong(r1)     // Catch:{ all -> 0x0147 }
            android.net.Uri r9 = android.content.ContentUris.withAppendedId(r3, r13)     // Catch:{ all -> 0x0147 }
        L_0x011f:
            if (r6 == r8) goto L_0x0128
            int r13 = r12.getInt(r6)     // Catch:{ all -> 0x0147 }
            r21 = r13
            goto L_0x012c
        L_0x0128:
            r13 = 400(0x190, float:5.6E-43)
            r21 = 400(0x190, float:5.6E-43)
        L_0x012c:
            if (r7 == r8) goto L_0x0137
            int r8 = r12.getInt(r7)     // Catch:{ all -> 0x0147 }
            if (r8 != r10) goto L_0x0137
            r22 = 1
            goto L_0x0139
        L_0x0137:
            r22 = 0
        L_0x0139:
            b.c.g.d.f$b r8 = new b.c.g.d.f$b     // Catch:{ all -> 0x0147 }
            r18 = r8
            r19 = r9
            r18.<init>(r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0147 }
            r5.add(r8)     // Catch:{ all -> 0x0147 }
            goto L_0x00ef
        L_0x0147:
            r0 = move-exception
            r19 = r5
            goto L_0x0161
        L_0x014b:
            r5 = r19
        L_0x014d:
            if (r12 == 0) goto L_0x0152
            r12.close()
        L_0x0152:
            r0 = 0
            b.c.g.d.f$b[] r0 = new p002b.p003c.p053g.p059d.C1232f.C1234b[r0]
            java.lang.Object[] r0 = r5.toArray(r0)
            b.c.g.d.f$b[] r0 = (p002b.p003c.p053g.p059d.C1232f.C1234b[]) r0
            return r0
        L_0x015c:
            r0 = move-exception
            goto L_0x0161
        L_0x015e:
            r0 = move-exception
            r19 = r2
        L_0x0161:
            if (r12 == 0) goto L_0x0166
            r12.close()
        L_0x0166:
            goto L_0x0168
        L_0x0167:
            throw r0
        L_0x0168:
            goto L_0x0167
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p059d.C1232f.m5844a(android.content.Context, b.c.g.d.a, java.lang.String, android.os.CancellationSignal):b.c.g.d.f$b[]");
    }
}
