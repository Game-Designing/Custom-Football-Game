package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.sb */
final class C9703sb implements Callable<zzase> {

    /* renamed from: a */
    private final /* synthetic */ Context f22947a;

    /* renamed from: b */
    private final /* synthetic */ zzasg f22948b;

    C9703sb(zzasg zzasg, Context context) {
        this.f22948b = zzasg;
        this.f22947a = context;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzase zzase;
        C9724tb tbVar = (C9724tb) this.f22948b.f24796a.get(this.f22947a);
        if (tbVar != null) {
            if (!(tbVar.f23006a + ((Long) zzyt.m31536e().mo29599a(zzacu.f24006Sb)).longValue() < zzk.zzln().mo27935b())) {
                zzase = new zzasf(this.f22947a, tbVar.f23007b).mo30044a();
                this.f22948b.f24796a.put(this.f22947a, new C9724tb(this.f22948b, zzase));
                return zzase;
            }
        }
        zzase = new zzasf(this.f22947a).mo30044a();
        this.f22948b.f24796a.put(this.f22947a, new C9724tb(this.f22948b, zzase));
        return zzase;
    }
}
