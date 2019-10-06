package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.android.gms.common.api.internal.i */
final class C8669i extends C8676p {

    /* renamed from: b */
    private final Map<Client, C8668h> f19757b;

    /* renamed from: c */
    final /* synthetic */ zaak f19758c;

    public C8669i(zaak zaak, Map<Client, C8668h> map) {
        this.f19758c = zaak;
        super(zaak, null);
        this.f19757b = map;
    }

    /* renamed from: a */
    public final void mo27572a() {
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.f19758c.f19794d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Client client : this.f19757b.keySet()) {
            if (!client.requiresGooglePlayServices() || ((C8668h) this.f19757b.get(client)).f19756c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = -1;
        int i2 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                i = googleApiAvailabilityCache.mo27800a(this.f19758c.f19793c, (Client) obj);
                if (i != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                i = googleApiAvailabilityCache.mo27800a(this.f19758c.f19793c, (Client) obj2);
                if (i == 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            this.f19758c.f19791a.mo27606a((C8683w) new C8670j(this, this.f19758c, new ConnectionResult(i, null)));
            return;
        }
        if (this.f19758c.f19803m && this.f19758c.f19801k != null) {
            this.f19758c.f19801k.connect();
        }
        for (Client client2 : this.f19757b.keySet()) {
            ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) this.f19757b.get(client2);
            if (!client2.requiresGooglePlayServices() || googleApiAvailabilityCache.mo27800a(this.f19758c.f19793c, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                this.f19758c.f19791a.mo27606a((C8683w) new C8671k(this, this.f19758c, connectionProgressReportCallbacks));
            }
        }
    }
}
