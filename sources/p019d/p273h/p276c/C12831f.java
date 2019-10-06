package p019d.p273h.p276c;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p019d.p273h.p274a.C12723a;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.f */
/* compiled from: AuctionHandler */
public class C12831f {

    /* renamed from: a */
    private String f39531a;

    /* renamed from: b */
    private String f39532b;

    /* renamed from: c */
    private String f39533c;

    /* renamed from: d */
    private Context f39534d;

    /* renamed from: e */
    private String f39535e = C12747I.m41186g().mo41239m();

    /* renamed from: d.h.c.f$a */
    /* compiled from: AuctionHandler */
    static class C12832a extends AsyncTask<Object, Void, Boolean> {

        /* renamed from: a */
        private C12901g f39536a;

        /* renamed from: b */
        private int f39537b;

        /* renamed from: c */
        private String f39538c;

        /* renamed from: d */
        private String f39539d;

        /* renamed from: e */
        private List<C12905h> f39540e;

        /* renamed from: f */
        private long f39541f = new Date().getTime();

        C12832a(C12901g callback) {
            this.f39536a = callback;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x01aa, code lost:
            r25 = r2;
            r24 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b4, code lost:
            if (r1.f39540e.size() != 0) goto L_0x01c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01b6, code lost:
            r1.f39537b = 1004;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01bf, code lost:
            return java.lang.Boolean.valueOf(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
            r13.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c9, code lost:
            return java.lang.Boolean.valueOf(true);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.Object... r27) {
            /*
                r26 = this;
                r1 = r26
                java.lang.String r2 = "C38FB23A402222A0C17D34A92F971D1F"
                r3 = 0
                r0 = r27[r3]     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                android.content.Context r0 = (android.content.Context) r0     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r4 = r0
                java.net.URL r0 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r5 = 1
                r6 = r27[r5]     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r6 = r0
                r0 = 2
                r7 = r27[r0]     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r8 = 3
                r8 = r27[r8]     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r9 = "clientParams"
                java.lang.Object r9 = r7.get(r9)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r10 = p019d.p273h.p274a.C12725c.m41105j(r4)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r11 = "UUID"
                r12 = 0
                java.lang.String[] r13 = p019d.p273h.p274a.C12725c.m41090b(r4)     // Catch:{ Exception -> 0x004f }
                int r14 = r13.length     // Catch:{ Exception -> 0x004f }
                if (r14 != r0) goto L_0x004e
                r0 = r13[r5]     // Catch:{ Exception -> 0x004f }
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x004f }
                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x004f }
                r12 = r0
                r0 = r13[r3]     // Catch:{ Exception -> 0x004f }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x004f }
                if (r0 != 0) goto L_0x004e
                r0 = r13[r3]     // Catch:{ Exception -> 0x004f }
                r10 = r0
                java.lang.String r0 = "GAID"
                r11 = r0
            L_0x004e:
                goto L_0x0050
            L_0x004f:
                r0 = move-exception
            L_0x0050:
                java.lang.String r0 = "advId"
                r9.put(r0, r10)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r0 = "advIdType"
                r9.put(r0, r11)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r0 = "isLimitAdTrackingEnabled"
                if (r12 == 0) goto L_0x0061
                java.lang.String r13 = "true"
                goto L_0x0063
            L_0x0061:
                java.lang.String r13 = "false"
            L_0x0063:
                r9.put(r0, r13)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.net.URLConnection r0 = r6.openConnection()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r13 = r0
                java.lang.String r0 = "POST"
                r13.setRequestMethod(r0)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r14 = "application/json; charset=utf-8"
                r13.setRequestProperty(r0, r14)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0 = 15000(0x3a98, float:2.102E-41)
                r13.setConnectTimeout(r0)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r13.setDoInput(r5)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r13.setDoOutput(r5)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.io.OutputStream r0 = r13.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r14 = r0
                java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r15 = "UTF-8"
                r0.<init>(r14, r15)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r15 = r0
                java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0.<init>(r15)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r16 = r0
                java.lang.String r0 = r7.toString()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r17 = p019d.p273h.p276c.p284h.C12915i.m41954b(r2, r0)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0 = r17
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r5.<init>()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r3 = "{\"request\" : \""
                r5.append(r3)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r5.append(r0)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r3 = "\"}"
                r5.append(r3)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r3 = r5.toString()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r5 = r16
                r5.write(r3)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r5.flush()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r5.close()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r14.close()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                int r0 = r13.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r16 = r0
                r0 = 200(0xc8, float:2.8E-43)
                r18 = r3
                r3 = r16
                if (r3 != r0) goto L_0x01df
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r16 = r4
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r19 = r5
                java.io.InputStream r5 = r13.getInputStream()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r4.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0.<init>(r4)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r4 = r0
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r5 = r0
            L_0x00ed:
                java.lang.String r0 = r4.readLine()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r20 = r0
                if (r0 == 0) goto L_0x00ff
                r21 = r4
                r4 = r20
                r5.append(r4)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r4 = r21
                goto L_0x00ed
            L_0x00ff:
                r21 = r4
                r4 = r20
                java.lang.String r0 = r5.toString()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r20 = r0
                boolean r0 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r22 = r4
                r4 = 1002(0x3ea, float:1.404E-42)
                if (r0 == 0) goto L_0x011f
                r1.f39537b = r4     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r0 = "empty response"
                r1.f39538c = r0     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r2 = 0
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                return r0
            L_0x011f:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x01d2 }
                r4 = r20
                r0.<init>(r4)     // Catch:{ Exception -> 0x01cc }
                boolean r20 = r8.booleanValue()     // Catch:{ Exception -> 0x01cc }
                if (r20 == 0) goto L_0x0145
                r20 = r4
                java.lang.String r4 = "response"
                java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x0140 }
                r23 = r0
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0140 }
                java.lang.String r2 = p019d.p273h.p276c.p284h.C12915i.m41952a(r2, r4)     // Catch:{ Exception -> 0x0140 }
                r0.<init>(r2)     // Catch:{ Exception -> 0x0140 }
                goto L_0x0149
            L_0x0140:
                r0 = move-exception
                r24 = r5
                goto L_0x01d5
            L_0x0145:
                r23 = r0
                r20 = r4
            L_0x0149:
                java.lang.String r2 = "auctionId"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x01d2 }
                r1.f39539d = r2     // Catch:{ Exception -> 0x01d2 }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x01d2 }
                r2.<init>()     // Catch:{ Exception -> 0x01d2 }
                r1.f39540e = r2     // Catch:{ Exception -> 0x01d2 }
                java.lang.String r2 = "waterfall"
                org.json.JSONArray r2 = r0.getJSONArray(r2)     // Catch:{ Exception -> 0x01d2 }
                r4 = 0
                r23 = r4
            L_0x0161:
                r23 = r0
                int r0 = r2.length()     // Catch:{ Exception -> 0x01d2 }
                if (r4 >= r0) goto L_0x01aa
                d.h.c.h r0 = new d.h.c.h     // Catch:{ Exception -> 0x01d2 }
                r24 = r5
                org.json.JSONObject r5 = r2.getJSONObject(r4)     // Catch:{ Exception -> 0x01ca }
                r0.<init>(r5)     // Catch:{ Exception -> 0x01ca }
                boolean r5 = r0.mo41676d()     // Catch:{ Exception -> 0x01ca }
                if (r5 != 0) goto L_0x0199
                r5 = 1002(0x3ea, float:1.404E-42)
                r1.f39537b = r5     // Catch:{ Exception -> 0x01ca }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ca }
                r5.<init>()     // Catch:{ Exception -> 0x01ca }
                r25 = r2
                java.lang.String r2 = "waterfall "
                r5.append(r2)     // Catch:{ Exception -> 0x01ca }
                r5.append(r4)     // Catch:{ Exception -> 0x01ca }
                java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x01ca }
                r1.f39538c = r2     // Catch:{ Exception -> 0x01ca }
                r2 = 0
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x01ca }
                return r2
            L_0x0199:
                r25 = r2
                java.util.List<d.h.c.h> r2 = r1.f39540e     // Catch:{ Exception -> 0x01ca }
                r2.add(r0)     // Catch:{ Exception -> 0x01ca }
                int r4 = r4 + 1
                r0 = r23
                r5 = r24
                r2 = r25
                goto L_0x0161
            L_0x01aa:
                r25 = r2
                r24 = r5
                java.util.List<d.h.c.h> r0 = r1.f39540e     // Catch:{ Exception -> 0x01ca }
                int r0 = r0.size()     // Catch:{ Exception -> 0x01ca }
                if (r0 != 0) goto L_0x01c0
                r0 = 1004(0x3ec, float:1.407E-42)
                r1.f39537b = r0     // Catch:{ Exception -> 0x01ca }
                r2 = 0
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x01ca }
                return r0
            L_0x01c0:
                r13.disconnect()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r2 = 1
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                return r0
            L_0x01ca:
                r0 = move-exception
                goto L_0x01d5
            L_0x01cc:
                r0 = move-exception
                r20 = r4
                r24 = r5
                goto L_0x01d5
            L_0x01d2:
                r0 = move-exception
                r24 = r5
            L_0x01d5:
                r2 = 1002(0x3ea, float:1.404E-42)
                r1.f39537b = r2     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r2 = 0
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                return r2
            L_0x01df:
                r16 = r4
                r19 = r5
                r0 = 1001(0x3e9, float:1.403E-42)
                r1.f39537b = r0     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0.<init>()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r0.append(r3)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r2 = ""
                r0.append(r2)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                java.lang.String r0 = r0.toString()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r1.f39538c = r0     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r13.disconnect()     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                r2 = 0
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ SocketTimeoutException -> 0x0214, Exception -> 0x0203 }
                return r0
            L_0x0203:
                r0 = move-exception
                r2 = 1000(0x3e8, float:1.401E-42)
                r1.f39537b = r2
                java.lang.String r2 = r0.getMessage()
                r1.f39538c = r2
                r2 = 0
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                return r2
            L_0x0214:
                r0 = move-exception
                r2 = 1006(0x3ee, float:1.41E-42)
                r1.f39537b = r2
                java.lang.String r2 = "Connection timed out"
                r1.f39538c = r2
                r2 = 0
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12831f.C12832a.doInBackground(java.lang.Object[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean isSuccess) {
            long elapsedTime = new Date().getTime() - this.f39541f;
            if (isSuccess.booleanValue()) {
                this.f39536a.mo41262a(true, this.f39540e, this.f39539d, 0, null, elapsedTime);
            } else {
                this.f39536a.mo41262a(false, null, null, this.f39537b, this.f39538c, elapsedTime);
            }
        }
    }

    /* renamed from: d.h.c.f$b */
    /* compiled from: AuctionHandler */
    static class C12833b extends AsyncTask<String, Void, Boolean> {
        C12833b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(String... objects) {
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) new URL(objects[0]).openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(15000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.connect();
                int httpResponseCode = urlConnection.getResponseCode();
                urlConnection.disconnect();
                return Boolean.valueOf(httpResponseCode == 200);
            } catch (Exception e) {
                return Boolean.valueOf(false);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean result) {
            super.onPostExecute(result);
        }
    }

    public C12831f(Context context, String adUnit, String blob, String url) {
        this.f39534d = context;
        this.f39531a = adUnit;
        this.f39532b = blob;
        this.f39533c = url;
    }

    /* renamed from: a */
    public void mo41577a(Map<String, Object> bidders, List<String> nonBidders, int sessionDepth, C12901g callback) {
        try {
            boolean isEncryptedResponse = C12916j.m41979c() == 1;
            new C12832a(callback).execute(new Object[]{this.f39534d, this.f39533c, m41763a(this.f39534d, bidders, nonBidders, sessionDepth, isEncryptedResponse), Boolean.valueOf(isEncryptedResponse)});
        } catch (Exception e) {
            callback.mo41262a(false, null, null, 1000, e.getMessage(), 0);
        }
    }

    /* renamed from: a */
    public void mo41576a(C12905h responseItem) {
        for (String url : responseItem.mo41675c()) {
            new C12833b().execute(new String[]{url});
        }
    }

    /* renamed from: a */
    private JSONObject m41763a(Context context, Map<String, Object> bidders, List<String> nonBidders, int sessionDepth, boolean isEncryptedResponse) throws JSONException {
        String str;
        JSONObject instances = new JSONObject();
        Iterator it = bidders.keySet().iterator();
        while (true) {
            str = "instanceType";
            if (!it.hasNext()) {
                break;
            }
            String instance = (String) it.next();
            JSONObject bidderObject = new JSONObject();
            bidderObject.put(str, 2);
            bidderObject.put("biddingAdditionalData", new JSONObject((Map) bidders.get(instance)));
            instances.put(instance, bidderObject);
        }
        for (String instance2 : nonBidders) {
            JSONObject nonbBidderObject = new JSONObject();
            nonbBidderObject.put(str, 1);
            instances.put(instance2, nonbBidderObject);
        }
        JSONObject clientParams = new JSONObject();
        clientParams.put("applicationUserId", C12747I.m41186g().mo41234i());
        String gender = C12747I.m41186g().mo41229f();
        if (TextUtils.isEmpty(gender)) {
            gender = "unknown";
        }
        clientParams.put("applicationUserGender", gender);
        Integer age = C12747I.m41186g().mo41217b();
        if (age == null) {
            age = Integer.valueOf(-1);
        }
        clientParams.put("applicationUserAge", age);
        clientParams.put("mobileCarrier", m41762a(context));
        clientParams.put("connectionType", C12916j.m41958a(context));
        clientParams.put("deviceOS", "android");
        clientParams.put("deviceWidth", context.getResources().getConfiguration().screenWidthDp);
        clientParams.put("deviceHeight", context.getResources().getConfiguration().screenHeightDp);
        StringBuilder sb = new StringBuilder();
        sb.append(VERSION.SDK_INT);
        sb.append("(");
        sb.append(VERSION.RELEASE);
        sb.append(")");
        clientParams.put("deviceOSVersion", sb.toString());
        clientParams.put("deviceModel", Build.MODEL);
        clientParams.put("deviceMake", Build.MANUFACTURER);
        clientParams.put("bundleId", context.getPackageName());
        clientParams.put("appVersion", C12723a.m41064a(context, context.getPackageName()));
        clientParams.put("clientTimestamp", new Date().getTime());
        JSONObject ret = new JSONObject();
        ret.put("adUnit", this.f39531a);
        ret.put("auctionData", this.f39532b);
        ret.put("applicationKey", C12747I.m41186g().mo41232h());
        ret.put("SDKVersion", C12916j.m41971b());
        ret.put("clientParams", clientParams);
        ret.put("sessionDepth", sessionDepth);
        ret.put("sessionId", this.f39535e);
        ret.put("doNotEncryptResponse", isEncryptedResponse ? AdultContentAnalytics.UNLOCK : "true");
        ret.put("instances", instances);
        return ret;
    }

    /* renamed from: a */
    private String m41762a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Exception e) {
        }
        return "";
    }
}
