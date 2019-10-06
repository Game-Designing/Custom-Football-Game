package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzard
public final class zzaii implements zzm {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile zzahz f24363a;

    /* renamed from: b */
    private final Context f24364b;

    public zzaii(Context context) {
        this.f24364b = context;
    }

    /* renamed from: a */
    public final zzp mo29752a(zzr<?> zzr) throws zzaf {
        String str = "ms";
        String str2 = "Http assets remote cache took ";
        zzaia a = zzaia.m25074a(zzr);
        long a2 = zzk.zzln().mo27934a();
        try {
            zzbbr zzbbr = new zzbbr();
            this.f24363a = new zzahz(this.f24364b, zzk.zzlu().mo30298b(), new C9141T(this, zzbbr), new C9162U(this, zzbbr));
            this.f24363a.checkAvailabilityAndConnect();
            zzbbh a3 = zzbar.m26378a(zzbar.m26379a((zzbbh<A>) zzbbr, (zzbal<? super A, ? extends B>) new C9054P<Object,Object>(this, a), (Executor) zzaxg.f24958a), (long) ((Integer) zzyt.m31536e().mo29599a(zzacu.f23906Bd)).intValue(), TimeUnit.MILLISECONDS, zzaxg.f24960c);
            a3.mo28811a(new C9116S(this), zzaxg.f24958a);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) a3.get();
            long a4 = zzk.zzln().mo27934a() - a2;
            StringBuilder sb = new StringBuilder(52);
            sb.append(str2);
            sb.append(a4);
            sb.append(str);
            zzawz.m26003f(sb.toString());
            zzaic zzaic = (zzaic) new zzaru(parcelFileDescriptor).mo30027a(zzaic.CREATOR);
            if (zzaic == null) {
                return null;
            }
            if (zzaic.f24355a) {
                throw new zzaf(zzaic.f24356b);
            } else if (zzaic.f24359e.length != zzaic.f24360f.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                int i = 0;
                while (true) {
                    String[] strArr = zzaic.f24359e;
                    if (i < strArr.length) {
                        hashMap.put(strArr[i], zzaic.f24360f[i]);
                        i++;
                    } else {
                        zzp zzp = new zzp(zzaic.f24357c, zzaic.f24358d, (Map<String, String>) hashMap, zzaic.f24361g, zzaic.f24362h);
                        return zzp;
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            long a5 = zzk.zzln().mo27934a() - a2;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append(str2);
            sb2.append(a5);
            sb2.append(str);
            zzawz.m26003f(sb2.toString());
            return null;
        } catch (Throwable th) {
            long a6 = zzk.zzln().mo27934a() - a2;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append(str2);
            sb3.append(a6);
            sb3.append(str);
            zzawz.m26003f(sb3.toString());
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m25079a() {
        if (this.f24363a != null) {
            this.f24363a.disconnect();
            Binder.flushPendingCommands();
        }
    }
}
