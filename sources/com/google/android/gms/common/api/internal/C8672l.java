package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.Client;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.api.internal.l */
final class C8672l extends C8676p {

    /* renamed from: b */
    private final ArrayList<Client> f19762b;

    /* renamed from: c */
    private final /* synthetic */ zaak f19763c;

    public C8672l(zaak zaak, ArrayList<Client> arrayList) {
        this.f19763c = zaak;
        super(zaak, null);
        this.f19762b = arrayList;
    }

    /* renamed from: a */
    public final void mo27572a() {
        this.f19763c.f19791a.f19852n.f19828q = this.f19763c.m21468g();
        ArrayList<Client> arrayList = this.f19762b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Client) obj).getRemoteService(this.f19763c.f19805o, this.f19763c.f19791a.f19852n.f19828q);
        }
    }
}
