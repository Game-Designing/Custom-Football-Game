package com.inmobi.commons.core.network;

import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.p222e.C10659b;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;

/* renamed from: com.inmobi.commons.core.network.f */
/* compiled from: VastBitRateNetworkConnection */
public final class C10679f extends C10675b {
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ C10677d mo34500a() {
        return super.mo34500a();
    }

    public C10679f(C10676c cVar) {
        super(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C10677d mo34501b() {
        C10677d dVar = new C10677d();
        try {
            int responseCode = this.f32567c.getResponseCode();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f32566b.f32579q);
            sb.append("Response code: ");
            sb.append(responseCode);
            dVar.f32592c = this.f32567c.getContentLength();
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
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e4.getMessage());
                hashMap.put("message", sb2.toString());
                C10659b.m34983a();
                C10659b.m34987a("root", "ExceptionCaught", hashMap);
            } catch (Exception e5) {
                StringBuilder sb3 = new StringBuilder("Error in submitting telemetry event : (");
                sb3.append(e4.getMessage());
                sb3.append(")");
            }
        } catch (Throwable th) {
            this.f32567c.disconnect();
            throw th;
        }
        return dVar;
    }
}
