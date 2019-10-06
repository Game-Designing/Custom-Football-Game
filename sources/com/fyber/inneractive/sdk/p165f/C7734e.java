package com.fyber.inneractive.sdk.p165f;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.p159a.C7639a;
import com.fyber.inneractive.sdk.p174i.C7907g;
import com.fyber.inneractive.sdk.util.C7986aa;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.fyber.inneractive.sdk.f.e */
public final class C7734e extends AsyncTask<String, Void, C7907g> {

    /* renamed from: a */
    private C7736b f15447a;

    /* renamed from: b */
    private C7730b f15448b;

    /* renamed from: c */
    private int f15449c;

    /* renamed from: d */
    private int f15450d;

    /* renamed from: e */
    private Exception f15451e;

    /* renamed from: f */
    private InneractiveErrorCode f15452f;

    /* renamed from: com.fyber.inneractive.sdk.f.e$a */
    static abstract class C7735a {

        /* renamed from: a */
        Map<String, Object> f15453a;

        /* renamed from: b */
        private String f15454b;

        C7735a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f15453a = new HashMap();
                this.f15454b = str;
                return;
            }
            throw new InvalidParameterException();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo24310a(String str, Object obj) {
            if (!TextUtils.isEmpty(str) && obj != null) {
                this.f15453a.put(str, obj);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo24309a() {
            String str = "SDK_EVENT, Event: ";
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : this.f15453a.keySet()) {
                    Object obj = this.f15453a.get(str2);
                    if (obj != null) {
                        jSONObject.put(str2, obj);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                C7742k kVar = new C7742k(false);
                String str3 = this.f15454b;
                if (!TextUtils.isEmpty(str3)) {
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        C7742k.m17166a();
                        try {
                            C7742k.f15501a.submit(new Runnable(str3, jSONObject2) {

                                /* renamed from: a */
                                final /* synthetic */ String f15504a;

                                /* renamed from: b */
                                final /* synthetic */ String f15505b;

                                {
                                    this.f15504a = r2;
                                    this.f15505b = r3;
                                }

                                public final void run() {
                                    C7742k.this.mo24317a(this.f15504a, this.f15505b);
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (C7640a.f15157a.f15150a) {
                    StringBuilder sb = new StringBuilder(str);
                    sb.append(jSONObject2);
                    Log.v("IA_CI_LOG", sb.toString());
                    C7639a a = C7640a.f15157a;
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append(jSONObject2);
                    a.mo24033b(sb2.toString());
                }
            } catch (Exception e2) {
                IAlog.m18021b("CustomEventsDispatcher - Failed converting params map to Json. Request not sent");
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.f.e$b */
    public interface C7736b {
        /* renamed from: a */
        void mo24302a(InneractiveErrorCode inneractiveErrorCode);

        /* renamed from: a */
        void mo24303a(C7907g gVar);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        C7907g gVar = (C7907g) obj;
        if (!isCancelled()) {
            if (gVar != null) {
                C7736b bVar = this.f15447a;
                if (bVar != null) {
                    bVar.mo24303a(gVar);
                }
            } else {
                if (this.f15451e != null) {
                    StringBuilder sb = new StringBuilder("oops...Exception caught while fetching ad: ");
                    sb.append(this.f15451e);
                    IAlog.m18021b(sb.toString());
                    if (this.f15451e instanceof FileNotFoundException) {
                        this.f15452f = InneractiveErrorCode.CONNECTION_ERROR;
                    }
                }
                if (this.f15452f == null) {
                    this.f15452f = InneractiveErrorCode.NO_FILL;
                }
                StringBuilder sb2 = new StringBuilder("fetcher task error code: ");
                sb2.append(this.f15452f);
                IAlog.m18019a(sb2.toString());
                C7736b bVar2 = this.f15447a;
                if (bVar2 != null) {
                    bVar2.mo24302a(this.f15452f);
                }
            }
        }
        m17156a();
    }

    public C7734e(C7736b bVar) {
        this.f15449c = C7986aa.f16296b;
        this.f15450d = C7986aa.f16295a;
        this.f15452f = null;
        this.f15449c = 5000;
        this.f15450d = 5000;
        this.f15447a = bVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0162, code lost:
        if (r6 != null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0164, code lost:
        r6.mo24301e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016f, code lost:
        if (r6 == null) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0172, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.p174i.C7907g doInBackground(java.lang.String... r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            r6 = r6[r0]     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.f.b r2 = new com.fyber.inneractive.sdk.f.b     // Catch:{ Exception -> 0x016a }
            r2.<init>(r6)     // Catch:{ Exception -> 0x016a }
            r5.f15448b = r2     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.f.b r6 = r5.f15448b     // Catch:{ Exception -> 0x016a }
            int r2 = r5.f15450d     // Catch:{ Exception -> 0x016a }
            r6.f15437c = r2     // Catch:{ Exception -> 0x016a }
            java.lang.String r6 = com.fyber.inneractive.sdk.config.IAConfigManager.m16953D()     // Catch:{ Exception -> 0x016a }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x016a }
            if (r2 != 0) goto L_0x003a
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x016a }
            r2.<init>()     // Catch:{ Exception -> 0x016a }
            java.lang.String r3 = "mockadnetworkresponseid"
            r2.put(r3, r6)     // Catch:{ Exception -> 0x016a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
            java.lang.String r4 = "IARemoteAdFetcherTask: Adding mock response header - "
            r3.<init>(r4)     // Catch:{ Exception -> 0x016a }
            r3.append(r6)     // Catch:{ Exception -> 0x016a }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)     // Catch:{ Exception -> 0x016a }
            goto L_0x003b
        L_0x003a:
            r2 = r1
        L_0x003b:
            com.fyber.inneractive.sdk.f.b r6 = r5.f15448b     // Catch:{ Exception -> 0x016a }
            int r3 = r5.f15449c     // Catch:{ Exception -> 0x016a }
            boolean r6 = r6.mo24296a(r3, r2)     // Catch:{ Exception -> 0x016a }
            if (r6 != 0) goto L_0x004b
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.CONNECTION_ERROR     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
            goto L_0x015f
        L_0x004b:
            boolean r6 = r5.isCancelled()     // Catch:{ Exception -> 0x016a }
            if (r6 == 0) goto L_0x0057
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.CANCELLED     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
            goto L_0x015f
        L_0x0057:
            com.fyber.inneractive.sdk.f.b r6 = r5.f15448b     // Catch:{ Exception -> 0x016a }
            r2 = 1
            boolean r6 = r6.mo24297a(r2)     // Catch:{ Exception -> 0x016a }
            if (r6 != 0) goto L_0x0066
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.CONNECTION_ERROR     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
            goto L_0x015f
        L_0x0066:
            com.fyber.inneractive.sdk.f.b r6 = r5.f15448b     // Catch:{ Exception -> 0x016a }
            if (r6 != 0) goto L_0x0074
            java.lang.String r6 = "null response returned"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INVALID_RESPONSE     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
            goto L_0x00e2
        L_0x0074:
            int r3 = r6.mo24300d()     // Catch:{ Exception -> 0x016a }
            r4 = 400(0x190, float:5.6E-43)
            if (r3 < r4) goto L_0x009b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
            java.lang.String r2 = "network error. http status code: "
            r6.<init>(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r2 = java.lang.Integer.toString(r3)     // Catch:{ Exception -> 0x016a }
            r6.append(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r2 = ". Please try again."
            r6.append(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INTERNAL_ERROR     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
            goto L_0x00e2
        L_0x009b:
            r4 = 204(0xcc, float:2.86E-43)
            if (r3 != r4) goto L_0x00be
            java.lang.String r2 = "Received 204 from server. No content"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r2)     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.f.a r2 = com.fyber.inneractive.sdk.p165f.C7729a.ERROR_CODE     // Catch:{ Exception -> 0x016a }
            java.lang.String r6 = com.fyber.inneractive.sdk.util.C8017o.C8018a.m18101a(r6, r2)     // Catch:{ Exception -> 0x016a }
            if (r6 == 0) goto L_0x00b9
            java.lang.String r2 = "Unknown AppID"
            boolean r6 = r2.equals(r6)     // Catch:{ Exception -> 0x016a }
            if (r6 == 0) goto L_0x00b9
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.UNKNOWN_APP_ID     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
            goto L_0x00bd
        L_0x00b9:
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.NO_FILL     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
        L_0x00bd:
            goto L_0x00e2
        L_0x00be:
            r6 = 200(0xc8, float:2.8E-43)
            if (r3 == r6) goto L_0x00e1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
            java.lang.String r2 = "invalid response: http status code: "
            r6.<init>(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r2 = java.lang.Integer.toString(r3)     // Catch:{ Exception -> 0x016a }
            r6.append(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r2 = "."
            r6.append(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.external.InneractiveErrorCode r6 = com.fyber.inneractive.sdk.external.InneractiveErrorCode.SERVER_INTERNAL_ERROR     // Catch:{ Exception -> 0x016a }
            r5.f15452f = r6     // Catch:{ Exception -> 0x016a }
            goto L_0x00e2
        L_0x00e1:
            r0 = 1
        L_0x00e2:
            if (r0 == 0) goto L_0x015e
            com.fyber.inneractive.sdk.f.b r6 = r5.f15448b     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.f.a r0 = com.fyber.inneractive.sdk.p165f.C7729a.RETURNED_AD_TYPE     // Catch:{ Exception -> 0x016a }
            java.lang.String r0 = com.fyber.inneractive.sdk.util.C8017o.C8018a.m18101a(r6, r0)     // Catch:{ Exception -> 0x016a }
            if (r0 == 0) goto L_0x00f4
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x016a }
            goto L_0x00f5
        L_0x00f4:
            r0 = 6
        L_0x00f5:
            com.fyber.inneractive.sdk.i.b r2 = com.fyber.inneractive.sdk.p174i.C7903b.m17817a(r0)     // Catch:{ Exception -> 0x016a }
            if (r2 != 0) goto L_0x00fe
            com.fyber.inneractive.sdk.i.b r2 = com.fyber.inneractive.sdk.p174i.C7903b.RETURNED_ADTYPE_MRAID     // Catch:{ Exception -> 0x016a }
        L_0x00fe:
            com.fyber.inneractive.sdk.b.b r3 = com.fyber.inneractive.sdk.p160b.C7652b.C7653a.f15185a     // Catch:{ Exception -> 0x016a }
            java.util.HashMap<com.fyber.inneractive.sdk.i.b, com.fyber.inneractive.sdk.b.b$b> r3 = r3.f15184a     // Catch:{ Exception -> 0x016a }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.b.b$b r2 = (com.fyber.inneractive.sdk.p160b.C7652b.C7654b) r2     // Catch:{ Exception -> 0x016a }
            if (r2 == 0) goto L_0x0110
            com.fyber.inneractive.sdk.i.c r2 = r2.mo24084a()     // Catch:{ Exception -> 0x016a }
            goto L_0x0111
        L_0x0110:
            r2 = r1
        L_0x0111:
            java.lang.String r3 = "Received ad type "
            if (r2 == 0) goto L_0x0136
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
            r4.<init>(r3)     // Catch:{ Exception -> 0x016a }
            r4.append(r0)     // Catch:{ Exception -> 0x016a }
            java.lang.String r0 = " - Got parser! "
            r4.append(r0)     // Catch:{ Exception -> 0x016a }
            r4.append(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)     // Catch:{ Exception -> 0x016a }
            r2.mo24712a(r6)     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.i.g r1 = r2.mo24714b()     // Catch:{ Exception -> 0x016a }
            goto L_0x015e
        L_0x0136:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
            r6.<init>(r3)     // Catch:{ Exception -> 0x016a }
            r6.append(r0)     // Catch:{ Exception -> 0x016a }
            java.lang.String r2 = " does not have an appropriate parser!"
            r6.append(r2)     // Catch:{ Exception -> 0x016a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x016a }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)     // Catch:{ Exception -> 0x016a }
            java.lang.Exception r6 = new java.lang.Exception     // Catch:{ Exception -> 0x016a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
            java.lang.String r3 = "Could not find parser for ad type "
            r2.<init>(r3)     // Catch:{ Exception -> 0x016a }
            r2.append(r0)     // Catch:{ Exception -> 0x016a }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x016a }
            r6.<init>(r0)     // Catch:{ Exception -> 0x016a }
            throw r6     // Catch:{ Exception -> 0x016a }
        L_0x015e:
        L_0x015f:
            com.fyber.inneractive.sdk.f.b r6 = r5.f15448b
            if (r6 == 0) goto L_0x0172
        L_0x0164:
            r6.mo24301e()
            goto L_0x0172
        L_0x0168:
            r6 = move-exception
            goto L_0x0173
        L_0x016a:
            r6 = move-exception
            r5.f15451e = r6     // Catch:{ all -> 0x0168 }
            com.fyber.inneractive.sdk.f.b r6 = r5.f15448b
            if (r6 == 0) goto L_0x0172
            goto L_0x0164
        L_0x0172:
            return r1
        L_0x0173:
            com.fyber.inneractive.sdk.f.b r0 = r5.f15448b
            if (r0 == 0) goto L_0x017a
            r0.mo24301e()
        L_0x017a:
            goto L_0x017c
        L_0x017b:
            throw r6
        L_0x017c:
            goto L_0x017b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p165f.C7734e.doInBackground(java.lang.String[]):com.fyber.inneractive.sdk.i.g");
    }

    /* access modifiers changed from: protected */
    public final void onCancelled() {
        IAlog.m18021b("IANetworkFetcherTask - onCancelled() called");
        IAlog.m18021b("Ad loading was cancelled.");
        if (this.f15451e != null) {
            StringBuilder sb = new StringBuilder("oops...Exception caught while loading ad: ");
            sb.append(this.f15451e);
            IAlog.m18021b(sb.toString());
        }
        m17156a();
    }

    /* renamed from: a */
    private void m17156a() {
        this.f15451e = null;
        this.f15452f = null;
    }
}
