package p024io.realm;

import java.util.concurrent.atomic.AtomicBoolean;
import p024io.realm.internal.Util;

/* renamed from: io.realm.b */
/* compiled from: BaseRealm */
class C14041b implements C13997a {

    /* renamed from: a */
    final /* synthetic */ C14001L f42540a;

    /* renamed from: b */
    final /* synthetic */ AtomicBoolean f42541b;

    C14041b(C14001L l, AtomicBoolean atomicBoolean) {
        this.f42540a = l;
        this.f42541b = atomicBoolean;
    }

    /* renamed from: a */
    public void mo43558a(int count) {
        if (count == 0) {
            this.f42541b.set(Util.m16053a(this.f42540a.mo43567h(), this.f42540a.mo43569i(), this.f42540a.mo43570j()));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file: ");
        sb.append(this.f42540a.mo43567h());
        throw new IllegalStateException(sb.toString());
    }
}
