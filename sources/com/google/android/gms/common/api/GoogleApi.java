package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class GoogleApi<O extends ApiOptions> {

    /* renamed from: a */
    private final Context f19555a;

    /* renamed from: b */
    private final Api<O> f19556b;

    /* renamed from: c */
    private final O f19557c;

    /* renamed from: d */
    private final zai<O> f19558d;

    /* renamed from: e */
    private final Looper f19559e;

    /* renamed from: f */
    private final int f19560f;

    /* renamed from: g */
    private final GoogleApiClient f19561g;

    /* renamed from: h */
    private final StatusExceptionMapper f19562h;

    /* renamed from: i */
    protected final GoogleApiManager f19563i;

    @KeepForSdk
    public static class Settings {
        @KeepForSdk

        /* renamed from: a */
        public static final Settings f19564a = new Builder().mo27370a();

        /* renamed from: b */
        public final StatusExceptionMapper f19565b;

        /* renamed from: c */
        public final Looper f19566c;

        @KeepForSdk
        public static class Builder {

            /* renamed from: a */
            private StatusExceptionMapper f19567a;

            /* renamed from: b */
            private Looper f19568b;

            @KeepForSdk
            /* renamed from: a */
            public Builder mo27369a(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.m21858a(statusExceptionMapper, (Object) "StatusExceptionMapper must not be null.");
                this.f19567a = statusExceptionMapper;
                return this;
            }

            @KeepForSdk
            /* renamed from: a */
            public Settings mo27370a() {
                if (this.f19567a == null) {
                    this.f19567a = new ApiExceptionMapper();
                }
                if (this.f19568b == null) {
                    this.f19568b = Looper.getMainLooper();
                }
                return new Settings(this.f19567a, this.f19568b);
            }
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.f19565b = statusExceptionMapper;
            this.f19566c = looper;
        }
    }

    @KeepForSdk
    protected GoogleApi(Context context, Api<O> api, Looper looper) {
        Preconditions.m21858a(context, (Object) "Null context is not permitted.");
        Preconditions.m21858a(api, (Object) "Api must not be null.");
        Preconditions.m21858a(looper, (Object) "Looper must not be null.");
        this.f19555a = context.getApplicationContext();
        this.f19556b = api;
        this.f19557c = null;
        this.f19559e = looper;
        this.f19558d = zai.m21615a(api);
        this.f19561g = new zabp(this);
        this.f19563i = GoogleApiManager.m21233a(this.f19555a);
        this.f19560f = this.f19563i.mo27477d();
        this.f19562h = new ApiExceptionMapper();
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        Preconditions.m21858a(context, (Object) "Null context is not permitted.");
        Preconditions.m21858a(api, (Object) "Api must not be null.");
        Preconditions.m21858a(settings, (Object) "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f19555a = context.getApplicationContext();
        this.f19556b = api;
        this.f19557c = o;
        this.f19559e = settings.f19566c;
        this.f19558d = zai.m21616a(this.f19556b, this.f19557c);
        this.f19561g = new zabp(this);
        this.f19563i = GoogleApiManager.m21233a(this.f19555a);
        this.f19560f = this.f19563i.mo27477d();
        this.f19562h = settings.f19565b;
        this.f19563i.mo27471a(this);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Builder().mo27369a(statusExceptionMapper).mo27370a());
    }

    /* renamed from: a */
    private final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T m21127a(int i, T t) {
        t.mo27458f();
        this.f19563i.mo27472a(this, i, t);
        return t;
    }

    /* renamed from: a */
    private final <TResult, A extends AnyClient> Task<TResult> m21128a(int i, TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f19563i.mo27473a(this, i, taskApiCall, taskCompletionSource, this.f19562h);
        return taskCompletionSource.mo33180a();
    }

    @KeepForSdk
    /* renamed from: a */
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27359a(T t) {
        m21127a(0, t);
        return t;
    }

    @KeepForSdk
    /* renamed from: a */
    public <TResult, A extends AnyClient> Task<TResult> mo27361a(TaskApiCall<A, TResult> taskApiCall) {
        return m21128a(0, taskApiCall);
    }

    @KeepForSdk
    /* renamed from: b */
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27362b(T t) {
        m21127a(1, t);
        return t;
    }

    /* renamed from: a */
    public Client mo27357a(Looper looper, zaa<O> zaa) {
        return this.f19556b.mo27327d().mo27090a(this.f19555a, looper, mo27363b().mo27774a(), this.f19557c, zaa, zaa);
    }

    /* renamed from: c */
    public final Api<O> mo27364c() {
        return this.f19556b;
    }

    /* renamed from: g */
    public final zai<O> mo27368g() {
        return this.f19558d;
    }

    /* renamed from: e */
    public final int mo27366e() {
        return this.f19560f;
    }

    @KeepForSdk
    /* renamed from: a */
    public GoogleApiClient mo27358a() {
        return this.f19561g;
    }

    @KeepForSdk
    /* renamed from: f */
    public Looper mo27367f() {
        return this.f19559e;
    }

    @KeepForSdk
    /* renamed from: d */
    public Context mo27365d() {
        return this.f19555a;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.internal.ClientSettings.Builder mo27363b() {
        /*
            r3 = this;
            com.google.android.gms.common.internal.ClientSettings$Builder r0 = new com.google.android.gms.common.internal.ClientSettings$Builder
            r0.<init>()
            O r1 = r3.f19557c
            boolean r2 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
            if (r2 == 0) goto L_0x0019
            com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.mo27329a()
            if (r1 == 0) goto L_0x0019
            android.accounts.Account r1 = r1.mo27171a()
            goto L_0x0027
        L_0x0019:
            O r1 = r3.f19557c
            boolean r2 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions
            if (r2 == 0) goto L_0x0026
            com.google.android.gms.common.api.Api$ApiOptions$HasAccountOptions r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) r1
            android.accounts.Account r1 = r1.getAccount()
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            com.google.android.gms.common.internal.ClientSettings$Builder r0 = r0.mo27771a(r1)
            O r1 = r3.f19557c
            boolean r2 = r1 instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
            if (r2 == 0) goto L_0x003f
            com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions r1 = (com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) r1
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r1.mo27329a()
            if (r1 == 0) goto L_0x003f
            java.util.Set r1 = r1.mo27181j()
            goto L_0x0043
        L_0x003f:
            java.util.Set r1 = java.util.Collections.emptySet()
        L_0x0043:
            com.google.android.gms.common.internal.ClientSettings$Builder r0 = r0.mo27773a(r1)
            android.content.Context r1 = r3.f19555a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            com.google.android.gms.common.internal.ClientSettings$Builder r0 = r0.mo27772a(r1)
            android.content.Context r1 = r3.f19555a
            java.lang.String r1 = r1.getPackageName()
            com.google.android.gms.common.internal.ClientSettings$Builder r0 = r0.mo27775b(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.mo27363b():com.google.android.gms.common.internal.ClientSettings$Builder");
    }

    /* renamed from: a */
    public zace mo27360a(Context context, Handler handler) {
        return new zace(context, handler, mo27363b().mo27774a());
    }
}
