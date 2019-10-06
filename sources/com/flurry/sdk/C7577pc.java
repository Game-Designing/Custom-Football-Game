package com.flurry.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.flurry.sdk.pc */
public class C7577pc extends C7376Ed {

    /* renamed from: e */
    static final String f14996e = C7577pc.class.getSimpleName();

    /* renamed from: A */
    private C7560mc f14997A = new C7560mc(this);

    /* renamed from: B */
    public boolean f14998B;

    /* renamed from: f */
    private final C7426Nb<String, String> f14999f = new C7426Nb<>();

    /* renamed from: g */
    public final C7426Nb<String, String> f15000g = new C7426Nb<>();

    /* renamed from: h */
    private final Object f15001h = new Object();

    /* renamed from: i */
    public String f15002i;

    /* renamed from: j */
    public C7578a f15003j;

    /* renamed from: k */
    public int f15004k = 10000;

    /* renamed from: l */
    public int f15005l = 15000;

    /* renamed from: m */
    private int f15006m;

    /* renamed from: n */
    private int f15007n;

    /* renamed from: o */
    public boolean f15008o = true;

    /* renamed from: p */
    C7579b f15009p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public HttpURLConnection f15010q;

    /* renamed from: r */
    private boolean f15011r;

    /* renamed from: s */
    private boolean f15012s;

    /* renamed from: t */
    public boolean f15013t;

    /* renamed from: u */
    long f15014u = -1;

    /* renamed from: v */
    public long f15015v = -1;

    /* renamed from: w */
    public Exception f15016w;

    /* renamed from: x */
    public int f15017x = -1;

    /* renamed from: y */
    public boolean f15018y;

    /* renamed from: z */
    public int f15019z = 25000;

    /* renamed from: com.flurry.sdk.pc$a */
    public enum C7578a {
        kUnknown,
        kGet,
        kPost,
        kPut,
        kDelete,
        kHead;

        public final String toString() {
            int i = C7572oc.f14979a[ordinal()];
            if (i == 1) {
                return "POST";
            }
            if (i == 2) {
                return "PUT";
            }
            if (i == 3) {
                return "DELETE";
            }
            if (i == 4) {
                return "HEAD";
            }
            if (i != 5) {
                return null;
            }
            return "GET";
        }
    }

    /* renamed from: com.flurry.sdk.pc$b */
    public interface C7579b {
        /* renamed from: a */
        void mo23973a();

        /* renamed from: a */
        void mo23974a(C7577pc pcVar, InputStream inputStream) throws Exception;

        /* renamed from: a */
        void mo23975a(OutputStream outputStream) throws Exception;
    }

    /* renamed from: a */
    public final void mo23988a(String str, String str2) {
        this.f14999f.mo23866a(str, str2);
    }

    /* renamed from: c */
    public final boolean mo23989c() {
        return !mo23990d() && mo23991e();
    }

    /* renamed from: d */
    public final boolean mo23990d() {
        return this.f15016w != null;
    }

    /* renamed from: e */
    public final boolean mo23991e() {
        int i = this.f15017x;
        return i >= 200 && i < 400 && !this.f14998B;
    }

    /* renamed from: a */
    public final List<String> mo23987a(String str) {
        return this.f15000g.mo23863a(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final void mo23992f() {
        if (this.f15009p != null && !mo23994h()) {
            this.f15009p.mo23973a();
        }
    }

    /* renamed from: g */
    public final void mo23993g() {
        String str = f14996e;
        StringBuilder sb = new StringBuilder("Cancelling http request: ");
        sb.append(this.f15002i);
        C7513ec.m16639a(3, str, sb.toString());
        synchronized (this.f15001h) {
            this.f15012s = true;
        }
        m16769i();
    }

    /* renamed from: h */
    public final boolean mo23994h() {
        boolean z;
        synchronized (this.f15001h) {
            z = this.f15012s;
        }
        return z;
    }

    /* renamed from: i */
    private void m16769i() {
        if (!this.f15011r) {
            this.f15011r = true;
            if (this.f15010q != null) {
                new C7566nc(this).start();
            }
        }
    }

    /* renamed from: a */
    public void mo23803a() {
        String str = " for url: ";
        String str2 = "HTTP status: ";
        try {
            if (this.f15002i == null) {
                this.f14997A.mo23978a();
                mo23992f();
            } else if (!C7570ob.m16755a().f14971d) {
                String str3 = f14996e;
                StringBuilder sb = new StringBuilder("Network not available, aborting http request: ");
                sb.append(this.f15002i);
                C7513ec.m16639a(3, str3, sb.toString());
                this.f14997A.mo23978a();
                mo23992f();
            } else {
                if (this.f15003j == null || C7578a.kUnknown.equals(this.f15003j)) {
                    this.f15003j = C7578a.kGet;
                }
                m16770j();
                String str4 = f14996e;
                StringBuilder sb2 = new StringBuilder(str2);
                sb2.append(this.f15017x);
                sb2.append(str);
                sb2.append(this.f15002i);
                C7513ec.m16639a(4, str4, sb2.toString());
                this.f14997A.mo23978a();
                mo23992f();
            }
        } catch (Exception e) {
            String str5 = f14996e;
            StringBuilder sb3 = new StringBuilder(str2);
            sb3.append(this.f15017x);
            sb3.append(str);
            sb3.append(this.f15002i);
            C7513ec.m16639a(4, str5, sb3.toString());
            String str6 = f14996e;
            StringBuilder sb4 = new StringBuilder("Exception during http request: ");
            sb4.append(this.f15002i);
            C7513ec.m16640a(3, str6, sb4.toString(), e);
            if (this.f15010q != null) {
                this.f15007n = this.f15010q.getReadTimeout();
                this.f15006m = this.f15010q.getConnectTimeout();
            }
            this.f15016w = e;
        } catch (Throwable th) {
            this.f14997A.mo23978a();
            mo23992f();
            throw th;
        }
    }

    /* renamed from: j */
    private void m16770j() throws Exception {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        OutputStream outputStream;
        if (!this.f15012s) {
            this.f15002i = C7354Ad.m16258a(this.f15002i);
            this.f15010q = (HttpURLConnection) new URL(this.f15002i).openConnection();
            this.f15010q.setConnectTimeout(this.f15004k);
            this.f15010q.setReadTimeout(this.f15005l);
            this.f15010q.setRequestMethod(this.f15003j.toString());
            this.f15010q.setInstanceFollowRedirects(this.f15008o);
            this.f15010q.setDoOutput(C7578a.kPost.equals(this.f15003j));
            this.f15010q.setDoInput(true);
            for (Entry entry : this.f14999f.mo23867b()) {
                this.f15010q.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (!C7578a.kGet.equals(this.f15003j) && !C7578a.kPost.equals(this.f15003j)) {
                this.f15010q.setRequestProperty("Accept-Encoding", "");
            }
            if (this.f15012s) {
                m16771k();
                return;
            }
            if (C7578a.kPost.equals(this.f15003j)) {
                try {
                    outputStream = this.f15010q.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        bufferedOutputStream = null;
                        th2 = th4;
                    }
                    try {
                        if (this.f15009p != null && !mo23994h()) {
                            this.f15009p.mo23975a(bufferedOutputStream);
                        }
                        C7354Ad.m16261a((Closeable) bufferedOutputStream);
                        C7354Ad.m16261a((Closeable) outputStream);
                    } catch (Throwable th5) {
                        m16771k();
                        throw th5;
                    }
                } catch (Throwable th6) {
                    bufferedOutputStream = null;
                    th2 = th6;
                    outputStream = null;
                    C7354Ad.m16261a((Closeable) bufferedOutputStream);
                    C7354Ad.m16261a((Closeable) outputStream);
                    throw th2;
                }
            }
            if (this.f15013t) {
                this.f15014u = System.currentTimeMillis();
            }
            if (this.f15018y) {
                this.f14997A.mo23979a((long) this.f15019z);
            }
            this.f15017x = this.f15010q.getResponseCode();
            if (this.f15013t && this.f15014u != -1) {
                this.f15015v = System.currentTimeMillis() - this.f15014u;
            }
            this.f14997A.mo23978a();
            for (Entry entry2 : this.f15010q.getHeaderFields().entrySet()) {
                for (String a : (List) entry2.getValue()) {
                    this.f15000g.mo23866a(entry2.getKey(), a);
                }
            }
            if (!C7578a.kGet.equals(this.f15003j) && !C7578a.kPost.equals(this.f15003j)) {
                m16771k();
            } else if (this.f15012s) {
                m16771k();
            } else {
                try {
                    inputStream = this.f15010q.getInputStream();
                    try {
                        bufferedInputStream = new BufferedInputStream(inputStream);
                        try {
                            if (this.f15009p != null && !mo23994h()) {
                                this.f15009p.mo23974a(this, bufferedInputStream);
                            }
                            C7354Ad.m16261a((Closeable) bufferedInputStream);
                            C7354Ad.m16261a((Closeable) inputStream);
                            m16771k();
                        } catch (Throwable th7) {
                            th = th7;
                            C7354Ad.m16261a((Closeable) bufferedInputStream);
                            C7354Ad.m16261a((Closeable) inputStream);
                            throw th;
                        }
                    } catch (Throwable th8) {
                        Throwable th9 = th8;
                        bufferedInputStream = null;
                        th = th9;
                    }
                } catch (Throwable th10) {
                    bufferedInputStream = null;
                    th = th10;
                    inputStream = null;
                    C7354Ad.m16261a((Closeable) bufferedInputStream);
                    C7354Ad.m16261a((Closeable) inputStream);
                    throw th;
                }
            }
        }
    }

    /* renamed from: k */
    private void m16771k() {
        if (!this.f15011r) {
            this.f15011r = true;
            HttpURLConnection httpURLConnection = this.f15010q;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /* renamed from: b */
    public final void mo23813b() {
        mo23993g();
    }
}
