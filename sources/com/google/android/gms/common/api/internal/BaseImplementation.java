package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

@KeepForSdk
public class BaseImplementation {

    @KeepForSdk
    public static abstract class ApiMethodImpl<R extends Result, A extends AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        @KeepForSdk

        /* renamed from: q */
        private final AnyClientKey<A> f19617q;
        @KeepForSdk

        /* renamed from: r */
        private final Api<?> f19618r;

        /* access modifiers changed from: protected */
        @KeepForSdk
        /* renamed from: a */
        public abstract void mo27234a(A a) throws RemoteException;

        @KeepForSdk
        protected ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            Preconditions.m21858a(googleApiClient, (Object) "GoogleApiClient must not be null");
            super(googleApiClient);
            Preconditions.m21858a(api, (Object) "Api must not be null");
            this.f19617q = api.mo27324a();
            this.f19618r = api;
        }

        @KeepForSdk
        /* renamed from: h */
        public final AnyClientKey<A> mo27450h() {
            return this.f19617q;
        }

        @KeepForSdk
        /* renamed from: g */
        public final Api<?> mo27449g() {
            return this.f19618r;
        }

        @KeepForSdk
        /* renamed from: b */
        public final void mo27446b(A a) throws DeadObjectException {
            if (a instanceof SimpleClientAdapter) {
                a = ((SimpleClientAdapter) a).mo27247k();
            }
            try {
                mo27234a(a);
            } catch (DeadObjectException e) {
                m21203a((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                m21203a(e2);
            }
        }

        @KeepForSdk
        /* renamed from: c */
        public final void mo27448c(Status status) {
            Preconditions.m21864a(!status.mo27421e(), (Object) "Failed result must not be success");
            Result a = mo27233a(status);
            mo27451a(a);
            mo27447c((R) a);
        }

        /* access modifiers changed from: protected */
        @KeepForSdk
        /* renamed from: c */
        public void mo27447c(R r) {
        }

        @KeepForSdk
        /* renamed from: a */
        private void m21203a(RemoteException remoteException) {
            mo27448c(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @KeepForSdk
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo27445a(Object obj) {
            super.mo27451a((Result) obj);
        }
    }

    @KeepForSdk
    public interface ResultHolder<R> {
        @KeepForSdk
        /* renamed from: a */
        void mo27445a(R r);
    }
}
