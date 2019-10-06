package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
public final class zzawm {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f24897a = new Object();

    /* renamed from: b */
    private zztz f24898b;

    /* renamed from: c */
    private final zzaxc f24899c = new zzaxc();

    /* renamed from: d */
    private final zzawu f24900d = new zzawu(zzyt.m31537f(), this.f24899c);

    /* renamed from: e */
    private boolean f24901e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f24902f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public zzbai f24903g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public zzacy f24904h = null;

    /* renamed from: i */
    private Boolean f24905i = null;

    /* renamed from: j */
    private final AtomicInteger f24906j = new AtomicInteger(0);

    /* renamed from: k */
    private final C9227Xb f24907k = new C9227Xb(null);

    /* renamed from: l */
    private final Object f24908l = new Object();

    /* renamed from: m */
    private zzbbh<ArrayList<String>> f24909m;

    /* renamed from: c */
    public final zzacy mo30171c() {
        zzacy zzacy;
        synchronized (this.f24897a) {
            zzacy = this.f24904h;
        }
        return zzacy;
    }

    /* renamed from: a */
    public final void mo30167a(Boolean bool) {
        synchronized (this.f24897a) {
            this.f24905i = bool;
        }
    }

    /* renamed from: d */
    public final Boolean mo30172d() {
        Boolean bool;
        synchronized (this.f24897a) {
            bool = this.f24905i;
        }
        return bool;
    }

    /* renamed from: e */
    public final void mo30173e() {
        this.f24907k.mo28690a();
    }

    @TargetApi(23)
    /* renamed from: a */
    public final void mo30166a(Context context, zzbai zzbai) {
        synchronized (this.f24897a) {
            if (!this.f24901e) {
                this.f24902f = context.getApplicationContext();
                this.f24903g = zzbai;
                zzk.zzlj().mo32286a((zzut) this.f24900d);
                zzacy zzacy = null;
                this.f24899c.mo30227a(this.f24902f, (String) null, true);
                zzaqx.m25685a(this.f24902f, this.f24903g);
                this.f24898b = new zztz(context.getApplicationContext(), this.f24903g);
                zzk.zzlp();
                if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24083ea)).booleanValue()) {
                    zzawz.m26003f("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzacy = new zzacy();
                }
                this.f24904h = zzacy;
                if (this.f24904h != null) {
                    zzbao.m26373a(new C9206Wb(this).mo30195b(), "AppState.registerCsiReporter");
                }
                this.f24901e = true;
                mo30178j();
            }
        }
        zzk.zzlg().mo30237b(context, zzbai.f25057a);
    }

    /* renamed from: b */
    public final Resources mo30169b() {
        if (this.f24903g.f25060d) {
            return this.f24902f.getResources();
        }
        try {
            zzbae.m26363a(this.f24902f).getResources();
            return null;
        } catch (zzbag e) {
            zzbad.m26358c("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo30168a(Throwable th, String str) {
        zzaqx.m25685a(this.f24902f, this.f24903g).mo30006a(th, str);
    }

    /* renamed from: b */
    public final void mo30170b(Throwable th, String str) {
        zzaqx.m25685a(this.f24902f, this.f24903g).mo30007a(th, str, ((Float) zzyt.m31536e().mo29599a(zzacu.f24148p)).floatValue());
    }

    /* renamed from: f */
    public final void mo30174f() {
        this.f24906j.incrementAndGet();
    }

    /* renamed from: g */
    public final void mo30175g() {
        this.f24906j.decrementAndGet();
    }

    /* renamed from: h */
    public final int mo30176h() {
        return this.f24906j.get();
    }

    /* renamed from: i */
    public final zzaxb mo30177i() {
        zzaxc zzaxc;
        synchronized (this.f24897a) {
            zzaxc = this.f24899c;
        }
        return zzaxc;
    }

    /* renamed from: a */
    public final Context mo30165a() {
        return this.f24902f;
    }

    /* renamed from: j */
    public final zzbbh<ArrayList<String>> mo30178j() {
        if (PlatformVersion.m22109c() && this.f24902f != null) {
            if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24139nc)).booleanValue()) {
                synchronized (this.f24908l) {
                    if (this.f24909m != null) {
                        zzbbh<ArrayList<String>> zzbbh = this.f24909m;
                        return zzbbh;
                    }
                    zzbbh<ArrayList<String>> a = zzaxg.m26095a((Callable<T>) new C9185Vb<T>(this));
                    this.f24909m = a;
                    return a;
                }
            }
        }
        return zzbar.m26376a(new ArrayList());
    }

    @TargetApi(16)
    /* renamed from: a */
    private static ArrayList<String> m25961a(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo b = Wrappers.m22139a(context).mo27947b(context.getApplicationInfo().packageName, Opcodes.ACC_SYNTHETIC);
            if (b.requestedPermissions == null || b.requestedPermissionsFlags == null) {
                return arrayList;
            }
            int i = 0;
            while (true) {
                String[] strArr = b.requestedPermissions;
                if (i >= strArr.length) {
                    return arrayList;
                }
                if ((b.requestedPermissionsFlags[i] & 2) != 0) {
                    arrayList.add(strArr[i]);
                }
                i++;
            }
        } catch (NameNotFoundException e) {
            return arrayList;
        }
    }

    /* renamed from: k */
    public final zzawu mo30179k() {
        return this.f24900d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public final /* synthetic */ ArrayList mo30180l() throws Exception {
        return m25961a(zzasq.m25744b(this.f24902f));
    }
}
