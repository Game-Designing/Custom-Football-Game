package com.paypal.android.sdk;

import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.paypal.android.sdk.qa */
public class C11995qa extends C11847ma {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f37665b = C11995qa.class.getSimpleName();

    /* renamed from: c */
    private static final MediaType f37666c = MediaType.parse("charset=utf-8");

    /* renamed from: d */
    private final C11788a f37667d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f37668e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C11707Ba f37669f;

    /* renamed from: g */
    private final OkHttpClient f37670g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final OkHttpClient f37671h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C11706B f37672i;

    /* renamed from: j */
    private final ScheduledExecutorService f37673j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final ConcurrentLinkedQueue f37674k;

    public C11995qa(C11788a aVar, String str, C11706B b, C11707Ba ba, int i, boolean z, List list) {
        this.f37667d = aVar;
        this.f37668e = str;
        this.f37672i = b;
        this.f37669f = ba;
        boolean d = C11757Q.m38956d(str);
        boolean z2 = d && !z;
        boolean z3 = !d;
        Builder a = C11823ga.m39143a(90, z2, z3, b.mo38526b(), this.f37669f.mo38532e());
        a.interceptors().addAll(list);
        a.interceptors().add(new C11851na());
        this.f37670g = a.build();
        Builder a2 = C11823ga.m39143a(90, z2, z3, b.mo38526b(), this.f37669f.mo38532e());
        a2.interceptors().add(new C11851na());
        this.f37671h = a2.build();
        this.f37673j = Executors.newSingleThreadScheduledExecutor();
        this.f37674k = new ConcurrentLinkedQueue();
    }

    /* renamed from: a */
    private static String m39678a(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        String str3 = "/";
        if (!str.endsWith(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str3);
            str = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39680a(C11703Aa aa, String str, OkHttpClient okHttpClient, Callback callback) {
        Request.Builder url;
        Request.Builder headers;
        int i = C12007ta.f37753a[aa.mo38511h().mo38570b().ordinal()];
        if (i == 1) {
            url = new Request.Builder().url(m39678a(str, aa.mo38509f()));
            headers = url.headers(m39686c(aa));
        } else if (i == 2) {
            url = new Request.Builder().url(str).post(RequestBody.create(f37666c, aa.mo38509f()));
            headers = url.headers(m39686c(aa));
        } else if (i == 3) {
            headers = new Request.Builder().url(m39678a(str, aa.mo38509f())).headers(m39686c(aa)).delete();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(aa.mo38511h().mo38570b());
            sb.append(" not supported.");
            throw new RuntimeException(sb.toString());
        }
        okHttpClient.newCall(headers.build()).enqueue(callback);
    }

    /* renamed from: a */
    static /* synthetic */ void m39682a(C11995qa qaVar, C11703Aa aa, Response response, IOException iOException) {
        C11797ca caVar;
        StringBuilder sb = new StringBuilder();
        sb.append(aa.mo38516n());
        sb.append(" failure.");
        String str = "paypal.sdk";
        if (response != null) {
            StringBuilder sb2 = new StringBuilder("request failure with http statusCode:");
            sb2.append(response.code());
            sb2.append(",exception:");
            sb2.append(response.message());
            Log.e(str, sb2.toString());
            C11847ma.m39201a(aa, response.code());
            if (aa.mo38519q()) {
                String str2 = C11793ba.INTERNAL_SERVER_ERROR.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(response.code());
                sb3.append(" http response received.  Response not parsable.");
                aa.mo38501a(str2, sb3.toString(), null);
            }
        } else if (iOException != null) {
            if (iOException instanceof SSLException) {
                if ("Connection closed by peer".equals(iOException.getMessage())) {
                    caVar = new C11797ca(C11793ba.DEVICE_OS_TOO_OLD, (Exception) iOException);
                    aa.mo38497a((C11789aa) caVar);
                }
            }
            caVar = new C11797ca(C11793ba.SERVER_COMMUNICATION_ERROR, (Exception) iOException);
            aa.mo38497a((C11789aa) caVar);
        } else {
            throw new RuntimeException("Both Response or Exception cannot be null");
        }
        StringBuilder sb4 = new StringBuilder("request failed with server response:");
        sb4.append(aa.mo38510g());
        Log.e(str, sb4.toString());
        qaVar.f37669f.mo38529a(aa);
    }

    /* renamed from: c */
    private static Headers m39686c(C11703Aa aa) {
        Headers.Builder builder = new Headers.Builder();
        for (Entry entry : aa.mo38512i().entrySet()) {
            builder.add((String) entry.getKey(), (String) entry.getValue());
        }
        return builder.build();
    }

    /* renamed from: a */
    public final void mo38828a() {
        this.f37670g.dispatcher().cancelAll();
        this.f37671h.dispatcher().cancelAll();
    }

    /* renamed from: a */
    public final boolean mo38829a(C11703Aa aa) {
        if (!this.f37667d.mo38691a()) {
            aa.mo38497a((C11789aa) new C11797ca(C11793ba.SERVER_COMMUNICATION_ERROR.toString()));
            return false;
        }
        C11703Aa.m38683k();
        String a = aa.mo38496a(aa.mo38511h());
        try {
            String str = " request: ";
            String str2 = " endpoint: ";
            if (aa.mo38502a()) {
                StringBuilder sb = new StringBuilder();
                sb.append(aa.mo38516n());
                sb.append(str2);
                sb.append(a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aa.mo38516n());
                sb2.append(str);
                sb2.append(aa.mo38509f());
                this.f37674k.offer(new C11999ra(this, aa, a));
                int nextInt = new Random().nextInt(Opcodes.ARRAYLENGTH) + 10;
                StringBuilder sb3 = new StringBuilder("Delaying tracking execution for ");
                sb3.append(nextInt);
                sb3.append(" seconds");
                this.f37673j.schedule(new C12003sa(this), (long) nextInt, TimeUnit.SECONDS);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(aa.mo38516n());
                sb4.append(str2);
                sb4.append(a);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(aa.mo38516n());
                sb5.append(str);
                sb5.append(aa.mo38509f());
                m39680a(aa, a, this.f37670g, (Callback) new C12011ua(this, aa, 0));
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            Log.e(f37665b, "encoding failure", e);
            aa.mo38497a((C11789aa) new C11797ca(C11793ba.INTERNAL_ERROR, (Exception) e));
            return false;
        } catch (IOException e2) {
            Log.e(f37665b, "communication failure", e2);
            aa.mo38497a((C11789aa) new C11797ca(C11793ba.SERVER_COMMUNICATION_ERROR, (Exception) e2));
            return false;
        }
    }
}
