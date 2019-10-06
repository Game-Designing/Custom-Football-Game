package com.inmobi.commons.core.network;

import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.C10700d;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.network.b */
/* compiled from: NetworkConnection */
class C10675b {

    /* renamed from: a */
    protected static final String f32565a = C10675b.class.getName();

    /* renamed from: b */
    protected C10676c f32566b;

    /* renamed from: c */
    protected HttpURLConnection f32567c;

    public C10675b(C10676c cVar) {
        this.f32566b = cVar;
    }

    /* renamed from: a */
    public C10677d mo34500a() {
        C10677d dVar;
        this.f32566b.mo34263a();
        if (this.f32566b.f32586x != 1) {
            C10677d dVar2 = new C10677d();
            dVar2.f32591b = new NetworkError(ErrorCode.GDPR_COMPLIANCE_ENFORCED, "Network Request dropped as current request is not GDPR compliant.");
            return dVar2;
        }
        if (C10700d.m35146a()) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f32566b.mo34507e()).openConnection();
                m35041a(httpURLConnection);
                this.f32567c = httpURLConnection;
                if (!this.f32566b.f32582t) {
                    this.f32567c.setInstanceFollowRedirects(false);
                }
                if ("POST".equals(this.f32566b.f32578p)) {
                    String f = this.f32566b.mo34508f();
                    this.f32567c.setRequestProperty("Content-Length", Integer.toString(f.length()));
                    this.f32567c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    BufferedWriter bufferedWriter = null;
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(this.f32567c.getOutputStream()));
                        try {
                            bufferedWriter2.write(f);
                            C10700d.m35144a((Closeable) bufferedWriter2);
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            C10700d.m35144a((Closeable) bufferedWriter);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C10700d.m35144a((Closeable) bufferedWriter);
                        throw th;
                    }
                }
                dVar = mo34501b();
            } catch (IOException e) {
                C10677d dVar3 = new C10677d();
                dVar3.f32591b = new NetworkError(ErrorCode.NETWORK_IO_ERROR, e.getLocalizedMessage());
                dVar = dVar3;
            } catch (Exception e2) {
                C10677d dVar4 = new C10677d();
                dVar4.f32591b = new NetworkError(ErrorCode.UNKNOWN_ERROR, e2.getLocalizedMessage());
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "GenericException");
                    StringBuilder sb = new StringBuilder();
                    sb.append(e2.getMessage());
                    hashMap.put("message", sb.toString());
                    C10659b.m34983a();
                    C10659b.m34987a("root", "ExceptionCaught", hashMap);
                } catch (Exception e3) {
                    StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
                    sb2.append(e2.getMessage());
                    sb2.append(")");
                }
                dVar = dVar4;
            }
        } else {
            dVar = new C10677d();
            dVar.f32591b = new NetworkError(ErrorCode.NETWORK_UNAVAILABLE_ERROR, "Network not reachable currently. Please try again.");
        }
        return dVar;
    }

    /* renamed from: a */
    private void m35041a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setConnectTimeout(this.f32566b.f32580r);
        httpURLConnection.setReadTimeout(this.f32566b.f32581s);
        httpURLConnection.setUseCaches(false);
        Map d = this.f32566b.mo34506d();
        if (d != null) {
            for (String str : d.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) d.get(str));
            }
        }
        String str2 = this.f32566b.f32578p;
        httpURLConnection.setRequestMethod(str2);
        if (!"GET".equals(str2)) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C10677d mo34501b() {
        C10677d dVar = new C10677d();
        try {
            int responseCode = this.f32567c.getResponseCode();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f32566b.f32579q);
            sb.append("Response code: ");
            sb.append(responseCode);
            if (responseCode == 200) {
                m35040a(dVar, false);
            } else {
                ErrorCode fromValue = ErrorCode.fromValue(responseCode);
                if (fromValue == ErrorCode.BAD_REQUEST) {
                    m35040a(dVar, true);
                    dVar.f32591b = new NetworkError(fromValue, m35039a(dVar.mo34511b()));
                } else {
                    if (fromValue == null) {
                        fromValue = ErrorCode.UNKNOWN_ERROR;
                    }
                    StringBuilder sb2 = new StringBuilder("HTTP:");
                    sb2.append(responseCode);
                    dVar.f32591b = new NetworkError(fromValue, sb2.toString());
                    dVar.f32593d = this.f32567c.getHeaderFields();
                }
            }
            this.f32567c.disconnect();
        } catch (SocketTimeoutException e) {
            ErrorCode errorCode = ErrorCode.HTTP_GATEWAY_TIMEOUT;
            dVar.f32591b = new NetworkError(errorCode, errorCode.toString());
        } catch (IOException e2) {
            ErrorCode errorCode2 = ErrorCode.NETWORK_IO_ERROR;
            dVar.f32591b = new NetworkError(errorCode2, errorCode2.toString());
        } catch (OutOfMemoryError e3) {
            ErrorCode errorCode3 = ErrorCode.OUT_OF_MEMORY_ERROR;
            dVar.f32591b = new NetworkError(errorCode3, errorCode3.toString());
        } catch (Exception e4) {
            ErrorCode errorCode4 = ErrorCode.UNKNOWN_ERROR;
            dVar.f32591b = new NetworkError(errorCode4, errorCode4.toString());
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "GenericException");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(e4.getMessage());
                hashMap.put("message", sb3.toString());
                C10659b.m34983a();
                C10659b.m34987a("root", "ExceptionCaught", hashMap);
            } catch (Exception e5) {
                StringBuilder sb4 = new StringBuilder("Error in submitting telemetry event : (");
                sb4.append(e4.getMessage());
                sb4.append(")");
            }
        } catch (Throwable th) {
            this.f32567c.disconnect();
            throw th;
        }
        return dVar;
    }

    /* renamed from: a */
    private void m35040a(C10677d dVar, boolean z) throws IOException {
        if (!(this.f32566b.f32584v != -1) || ((long) this.f32567c.getContentLength()) <= this.f32566b.f32584v) {
            byte[] a = C10700d.m35147a(z ? this.f32567c.getErrorStream() : this.f32567c.getInputStream());
            if (a.length != 0) {
                if (this.f32566b.mo34264b()) {
                    a = this.f32566b.mo34503a(a);
                    if (a == null) {
                        dVar.f32591b = new NetworkError(ErrorCode.INVALID_ENCRYPTED_RESPONSE_RECEIVED, "Unable to decrypt the server response.");
                    }
                }
                if (a != null && this.f32566b.f32585w) {
                    a = C10700d.m35148a(a);
                    if (a == null) {
                        dVar.f32591b = new NetworkError(ErrorCode.GZIP_DECOMPRESSION_FAILED, "Failed to uncompress gzip response");
                    }
                }
                if (a != null) {
                    dVar.mo34512b(a);
                }
            }
            dVar.f32593d = this.f32567c.getHeaderFields();
            return;
        }
        dVar.f32591b = new NetworkError(ErrorCode.RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT, "Response size greater than specified max response size");
    }

    /* renamed from: a */
    private static String m35039a(String str) {
        String str2 = "errorMessage";
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                return jSONObject.getString(str2);
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }
}
