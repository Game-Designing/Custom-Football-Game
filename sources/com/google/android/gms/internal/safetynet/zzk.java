package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import com.google.android.gms.safetynet.SafetyNetApi.zzb;
import com.google.android.gms.safetynet.zzd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zzk implements SafetyNetApi {

    /* renamed from: a */
    private static final String f30443a = zzk.class.getSimpleName();

    /* renamed from: com.google.android.gms.internal.safetynet.zzk$a */
    static abstract class C10026a extends C10023b<zzb> {

        /* renamed from: s */
        protected final zzg f30444s = new C10025d(this);

        public C10026a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public /* synthetic */ Result mo27233a(Status status) {
            return new C10027b(status, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.safetynet.zzk$b */
    static class C10027b implements zzb {

        /* renamed from: a */
        private final Status f30445a;

        /* renamed from: b */
        private final zzd f30446b;

        public C10027b(Status status, zzd zzd) {
            this.f30445a = status;
            this.f30446b = zzd;
        }

        /* renamed from: b */
        public final List<HarmfulAppsData> mo32985b() {
            zzd zzd = this.f30446b;
            return zzd == null ? Collections.emptyList() : Arrays.asList(zzd.f30574b);
        }

        public final Status getStatus() {
            return this.f30445a;
        }
    }

    public static class zzi implements SafeBrowsingResult {

        /* renamed from: a */
        private Status f30447a;

        public final Status getStatus() {
            return this.f30447a;
        }
    }

    /* renamed from: a */
    public PendingResult<zzb> mo32984a(GoogleApiClient googleApiClient) {
        return googleApiClient.mo27377a(new C10024c(this, googleApiClient));
    }
}
