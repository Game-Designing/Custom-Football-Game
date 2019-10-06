package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6732t;
import com.facebook.internal.C6738z;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    public static final Creator<FacebookRequestError> CREATOR = new C6782m();

    /* renamed from: a */
    static final C6542b f11776a = new C6542b(200, 299, null);

    /* renamed from: b */
    private final C6541a f11777b;

    /* renamed from: c */
    private final int f11778c;

    /* renamed from: d */
    private final int f11779d;

    /* renamed from: e */
    private final int f11780e;

    /* renamed from: f */
    private final String f11781f;

    /* renamed from: g */
    private final String f11782g;

    /* renamed from: h */
    private final String f11783h;

    /* renamed from: i */
    private final String f11784i;

    /* renamed from: j */
    private final String f11785j;

    /* renamed from: k */
    private final JSONObject f11786k;

    /* renamed from: l */
    private final JSONObject f11787l;

    /* renamed from: m */
    private final Object f11788m;

    /* renamed from: n */
    private final HttpURLConnection f11789n;

    /* renamed from: o */
    private final FacebookException f11790o;

    /* renamed from: com.facebook.FacebookRequestError$a */
    public enum C6541a {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    /* renamed from: com.facebook.FacebookRequestError$b */
    private static class C6542b {

        /* renamed from: a */
        private final int f11795a;

        /* renamed from: b */
        private final int f11796b;

        /* synthetic */ C6542b(int x0, int x1, C6782m x2) {
            this(x0, x1);
        }

        private C6542b(int start, int end) {
            this.f11795a = start;
            this.f11796b = end;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo19670a(int value) {
            return this.f11795a <= value && value <= this.f11796b;
        }
    }

    /* synthetic */ FacebookRequestError(Parcel x0, C6782m x1) {
        this(x0);
    }

    private FacebookRequestError(int requestStatusCode, int errorCode, int subErrorCode, String errorType, String errorMessage, String errorUserTitle, String errorUserMessage, boolean errorIsTransient, JSONObject requestResultBody, JSONObject requestResult, Object batchRequestResult, HttpURLConnection connection, FacebookException exception) {
        C6541a aVar;
        int i = errorCode;
        int i2 = subErrorCode;
        String str = errorMessage;
        FacebookException facebookException = exception;
        this.f11778c = requestStatusCode;
        this.f11779d = i;
        this.f11780e = i2;
        this.f11781f = errorType;
        this.f11782g = str;
        this.f11787l = requestResultBody;
        this.f11786k = requestResult;
        this.f11788m = batchRequestResult;
        this.f11789n = connection;
        this.f11783h = errorUserTitle;
        this.f11784i = errorUserMessage;
        boolean isLocalException = false;
        if (facebookException != null) {
            this.f11790o = facebookException;
            isLocalException = true;
        } else {
            this.f11790o = new FacebookServiceException(this, str);
        }
        C6732t errorClassification = m12858a();
        if (isLocalException) {
            aVar = C6541a.OTHER;
            boolean z = errorIsTransient;
        } else {
            aVar = errorClassification.mo19969a(i, i2, errorIsTransient);
        }
        this.f11777b = aVar;
        this.f11785j = errorClassification.mo19970a(this.f11777b);
    }

    FacebookRequestError(HttpURLConnection connection, Exception exception) {
        Exception exc = exception;
        this(-1, -1, -1, null, null, null, null, false, null, null, null, connection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException((Throwable) exc));
    }

    public FacebookRequestError(int errorCode, String errorType, String errorMessage) {
        this(-1, errorCode, -1, errorType, errorMessage, null, null, false, null, null, null, null, null);
    }

    /* renamed from: f */
    public int mo19666f() {
        return this.f11778c;
    }

    /* renamed from: b */
    public int mo19661b() {
        return this.f11779d;
    }

    /* renamed from: g */
    public int mo19667g() {
        return this.f11780e;
    }

    /* renamed from: d */
    public String mo19663d() {
        return this.f11781f;
    }

    /* renamed from: c */
    public String mo19662c() {
        String str = this.f11782g;
        if (str != null) {
            return str;
        }
        return this.f11790o.getLocalizedMessage();
    }

    /* renamed from: e */
    public FacebookException mo19665e() {
        return this.f11790o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{HttpStatus: ");
        sb.append(this.f11778c);
        sb.append(", errorCode: ");
        sb.append(this.f11779d);
        sb.append(", subErrorCode: ");
        sb.append(this.f11780e);
        sb.append(", errorType: ");
        sb.append(this.f11781f);
        sb.append(", errorMessage: ");
        sb.append(mo19662c());
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r1v6, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.facebook.FacebookRequestError m12857a(org.json.JSONObject r28, java.lang.Object r29, java.net.HttpURLConnection r30) {
        /*
            r15 = r28
            java.lang.String r0 = "error_code"
            java.lang.String r1 = "error"
            java.lang.String r2 = "FACEBOOK_NON_JSON_RESULT"
            java.lang.String r3 = "body"
            java.lang.String r4 = "code"
            boolean r5 = r15.has(r4)     // Catch:{ JSONException -> 0x0145 }
            if (r5 == 0) goto L_0x0142
            int r5 = r15.getInt(r4)     // Catch:{ JSONException -> 0x0145 }
            r13 = r5
            java.lang.Object r5 = com.facebook.internal.C6694S.m13400a(r15, r3, r2)     // Catch:{ JSONException -> 0x0145 }
            r12 = r5
            if (r12 == 0) goto L_0x0104
            boolean r5 = r12 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0145 }
            if (r5 == 0) goto L_0x0104
            r5 = r12
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ JSONException -> 0x0145 }
            r11 = r5
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = -1
            r16 = -1
            r17 = 0
            boolean r18 = r11.has(r1)     // Catch:{ JSONException -> 0x0145 }
            java.lang.String r14 = "error_subcode"
            r20 = r5
            if (r18 == 0) goto L_0x0088
            r5 = 0
            java.lang.Object r0 = com.facebook.internal.C6694S.m13400a(r11, r1, r5)     // Catch:{ JSONException -> 0x0083 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r1 = "type"
            java.lang.String r1 = r0.optString(r1, r5)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r5 = "message"
            r20 = r1
            r1 = 0
            java.lang.String r5 = r0.optString(r5, r1)     // Catch:{ JSONException -> 0x0100 }
            r1 = r5
            r5 = -1
            int r4 = r0.optInt(r4, r5)     // Catch:{ JSONException -> 0x0145 }
            int r5 = r0.optInt(r14, r5)     // Catch:{ JSONException -> 0x0145 }
            java.lang.String r6 = "error_user_msg"
            r10 = 0
            java.lang.String r6 = r0.optString(r6, r10)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r7 = "error_user_title"
            java.lang.String r7 = r0.optString(r7, r10)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r8 = "is_transient"
            r10 = 0
            boolean r8 = r0.optBoolean(r8, r10)     // Catch:{ JSONException -> 0x0145 }
            r17 = 1
            r0 = r1
            r21 = r4
            r22 = r5
            r16 = r6
            r18 = r7
            r19 = r8
            r1 = 0
            goto L_0x00cd
        L_0x007e:
            r0 = move-exception
            r24 = r10
            goto L_0x0148
        L_0x0083:
            r0 = move-exception
            r24 = r5
            goto L_0x0148
        L_0x0088:
            boolean r1 = r11.has(r0)     // Catch:{ JSONException -> 0x0145 }
            java.lang.String r4 = "error_msg"
            java.lang.String r5 = "error_reason"
            if (r1 != 0) goto L_0x00ac
            boolean r1 = r11.has(r4)     // Catch:{ JSONException -> 0x0145 }
            if (r1 != 0) goto L_0x00ac
            boolean r1 = r11.has(r5)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x009f
            goto L_0x00ac
        L_0x009f:
            r0 = r6
            r18 = r8
            r19 = r9
            r21 = r10
            r22 = r16
            r1 = 0
            r16 = r7
            goto L_0x00cd
        L_0x00ac:
            r1 = 0
            java.lang.String r5 = r11.optString(r5, r1)     // Catch:{ JSONException -> 0x0100 }
            java.lang.String r4 = r11.optString(r4, r1)     // Catch:{ JSONException -> 0x0100 }
            r6 = -1
            int r0 = r11.optInt(r0, r6)     // Catch:{ JSONException -> 0x0100 }
            int r6 = r11.optInt(r14, r6)     // Catch:{ JSONException -> 0x0100 }
            r17 = 1
            r21 = r0
            r0 = r4
            r20 = r5
            r22 = r6
            r16 = r7
            r18 = r8
            r19 = r9
        L_0x00cd:
            if (r17 == 0) goto L_0x00f6
            com.facebook.FacebookRequestError r23 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x0100 }
            r14 = 0
            r24 = r1
            r1 = r23
            r2 = r13
            r3 = r21
            r4 = r22
            r5 = r20
            r6 = r0
            r7 = r18
            r8 = r16
            r9 = r19
            r10 = r11
            r25 = r11
            r11 = r28
            r26 = r12
            r12 = r29
            r27 = r0
            r0 = r13
            r13 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x0140 }
            return r23
        L_0x00f6:
            r27 = r0
            r24 = r1
            r25 = r11
            r26 = r12
            r0 = r13
            goto L_0x0109
        L_0x0100:
            r0 = move-exception
            r24 = r1
            goto L_0x0148
        L_0x0104:
            r26 = r12
            r0 = r13
            r24 = 0
        L_0x0109:
            com.facebook.FacebookRequestError$b r1 = f11776a     // Catch:{ JSONException -> 0x0140 }
            boolean r1 = r1.mo19670a(r0)     // Catch:{ JSONException -> 0x0140 }
            if (r1 != 0) goto L_0x0144
            com.facebook.FacebookRequestError r16 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x0140 }
            r4 = -1
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r1 = r15.has(r3)     // Catch:{ JSONException -> 0x0140 }
            if (r1 == 0) goto L_0x0128
            java.lang.Object r1 = com.facebook.internal.C6694S.m13400a(r15, r3, r2)     // Catch:{ JSONException -> 0x0140 }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0140 }
            r11 = r1
            goto L_0x012a
        L_0x0128:
            r11 = r24
        L_0x012a:
            r14 = 0
            r1 = r16
            r2 = r0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r28
            r12 = r29
            r13 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x0140 }
            return r16
        L_0x0140:
            r0 = move-exception
            goto L_0x0148
        L_0x0142:
            r24 = 0
        L_0x0144:
            goto L_0x0148
        L_0x0145:
            r0 = move-exception
            r24 = 0
        L_0x0148:
            return r24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.m12857a(org.json.JSONObject, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
    }

    /* renamed from: a */
    static synchronized C6732t m12858a() {
        synchronized (FacebookRequestError.class) {
            C6738z appSettings = C6670D.m13306b(C6787r.m13816f());
            if (appSettings == null) {
                C6732t a = C6732t.m13557a();
                return a;
            }
            C6732t d = appSettings.mo19976d();
            return d;
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.f11778c);
        out.writeInt(this.f11779d);
        out.writeInt(this.f11780e);
        out.writeString(this.f11781f);
        out.writeString(this.f11782g);
        out.writeString(this.f11783h);
        out.writeString(this.f11784i);
    }

    private FacebookRequestError(Parcel in) {
        this(in.readInt(), in.readInt(), in.readInt(), in.readString(), in.readString(), in.readString(), in.readString(), false, null, null, null, null, null);
    }

    public int describeContents() {
        return 0;
    }
}
