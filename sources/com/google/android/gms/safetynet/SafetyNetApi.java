package com.google.android.gms.safetynet;

import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import java.util.List;

@KeepForSdkWithMembers
public interface SafetyNetApi {

    public static class AttestationResponse extends Response<zza> {
    }

    public static class HarmfulAppsResponse extends Response<zzb> {
        /* renamed from: c */
        public List<HarmfulAppsData> mo33125c() {
            return ((zzb) mo27407b()).mo32985b();
        }
    }

    public static class RecaptchaTokenResponse extends Response<RecaptchaTokenResult> {
    }

    @Deprecated
    public interface RecaptchaTokenResult extends Result {
    }

    @KeepForSdkWithMembers
    public static class SafeBrowsingResponse extends Response<SafeBrowsingResult> {
    }

    @KeepForSdkWithMembers
    @Deprecated
    public interface SafeBrowsingResult extends Result {
    }

    public static class VerifyAppsUserResponse extends Response<zzc> {
    }

    @Deprecated
    public interface zza extends Result {
    }

    @Deprecated
    public interface zzb extends Result {
        /* renamed from: b */
        List<HarmfulAppsData> mo32985b();
    }

    @Deprecated
    public interface zzc extends Result {
    }

    @Deprecated
    /* renamed from: a */
    PendingResult<zzb> mo32984a(GoogleApiClient googleApiClient);
}
