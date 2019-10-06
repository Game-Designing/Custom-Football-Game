package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.safetynet.SafetyNetApi.HarmfulAppsResponse;
import com.google.android.gms.tasks.Task;

public class SafetyNetClient extends GoogleApi<NoOptions> {
    SafetyNetClient(Context context) {
        super(context, SafetyNet.f30569c, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    /* renamed from: h */
    public Task<HarmfulAppsResponse> mo33126h() {
        return PendingResultUtil.m21853a(SafetyNet.f30570d.mo32984a(mo27358a()), new HarmfulAppsResponse());
    }
}
