package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

public final class zaah implements zabd {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zabe f19789a;

    /* renamed from: b */
    private boolean f19790b = false;

    public zaah(zabe zabe) {
        this.f19789a = zabe;
    }

    /* renamed from: a */
    public final void mo27590a() {
    }

    /* renamed from: b */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27592b(T t) {
        return mo27589a(t);
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* JADX WARNING: type inference failed for: r0v12, types: [com.google.android.gms.common.api.Api$SimpleClient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <A extends com.google.android.gms.common.api.Api.AnyClient, T extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T mo27589a(T r4) {
        /*
            r3 = this;
            com.google.android.gms.common.api.internal.zabe r0 = r3.f19789a     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.internal.zaaw r0 = r0.f19852n     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.internal.zacp r0 = r0.f19836y     // Catch:{ DeadObjectException -> 0x0050 }
            r0.mo27621a(r4)     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.internal.zabe r0 = r3.f19789a     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.internal.zaaw r0 = r0.f19852n     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.Api$AnyClientKey r1 = r4.mo27450h()     // Catch:{ DeadObjectException -> 0x0050 }
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r0 = r0.f19827p     // Catch:{ DeadObjectException -> 0x0050 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.Api$Client r0 = (com.google.android.gms.common.api.Api.Client) r0     // Catch:{ DeadObjectException -> 0x0050 }
            java.lang.String r1 = "Appropriate Api was not requested."
            com.google.android.gms.common.internal.Preconditions.m21858a(r0, r1)     // Catch:{ DeadObjectException -> 0x0050 }
            boolean r1 = r0.isConnected()     // Catch:{ DeadObjectException -> 0x0050 }
            if (r1 != 0) goto L_0x0040
            com.google.android.gms.common.api.internal.zabe r1 = r3.f19789a     // Catch:{ DeadObjectException -> 0x0050 }
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r1 = r1.f19845g     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.Api$AnyClientKey r2 = r4.mo27450h()     // Catch:{ DeadObjectException -> 0x0050 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ DeadObjectException -> 0x0050 }
            if (r1 == 0) goto L_0x0040
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ DeadObjectException -> 0x0050 }
            r1 = 17
            r0.<init>(r1)     // Catch:{ DeadObjectException -> 0x0050 }
            r4.mo27448c(r0)     // Catch:{ DeadObjectException -> 0x0050 }
            goto L_0x005b
        L_0x0040:
            boolean r1 = r0 instanceof com.google.android.gms.common.internal.SimpleClientAdapter     // Catch:{ DeadObjectException -> 0x0050 }
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.common.internal.SimpleClientAdapter r0 = (com.google.android.gms.common.internal.SimpleClientAdapter) r0     // Catch:{ DeadObjectException -> 0x0050 }
            com.google.android.gms.common.api.Api$SimpleClient r0 = r0.mo27247k()     // Catch:{ DeadObjectException -> 0x0050 }
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            r4.mo27446b(r0)     // Catch:{ DeadObjectException -> 0x0050 }
            goto L_0x005b
        L_0x0050:
            r0 = move-exception
            com.google.android.gms.common.api.internal.zabe r0 = r3.f19789a
            com.google.android.gms.common.api.internal.e r1 = new com.google.android.gms.common.api.internal.e
            r1.<init>(r3, r3)
            r0.mo27606a(r1)
        L_0x005b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaah.mo27589a(com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl):com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl");
    }

    public final boolean disconnect() {
        if (this.f19790b) {
            return false;
        }
        if (this.f19789a.f19852n.mo27602m()) {
            this.f19790b = true;
            for (zacm a : this.f19789a.f19852n.f19835x) {
                a.mo27619a();
            }
            return false;
        }
        this.f19789a.mo27605a((ConnectionResult) null);
        return true;
    }

    public final void connect() {
        if (this.f19790b) {
            this.f19790b = false;
            this.f19789a.mo27606a((C8683w) new C8666f(this, this));
        }
    }

    public final void onConnected(Bundle bundle) {
    }

    /* renamed from: a */
    public final void mo27591a(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final void onConnectionSuspended(int i) {
        this.f19789a.mo27605a((ConnectionResult) null);
        this.f19789a.f19853o.mo27561a(i, this.f19790b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo27593b() {
        if (this.f19790b) {
            this.f19790b = false;
            this.f19789a.f19852n.f19836y.mo27620a();
            disconnect();
        }
    }
}
