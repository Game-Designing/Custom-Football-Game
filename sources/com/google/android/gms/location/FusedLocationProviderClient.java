package com.google.android.gms.location;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

public class FusedLocationProviderClient extends GoogleApi<NoOptions> {
    public FusedLocationProviderClient(Context context) {
        super(context, LocationServices.f30505c, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    /* renamed from: h */
    public Task<Location> mo33017h() {
        return mo27361a((TaskApiCall<A, TResult>) new C10033e<A,TResult>(this));
    }
}
