package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwl.zza.zzb;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzard
public final class zzwj {

    /* renamed from: a */
    private final zzwo f29563a;

    /* renamed from: b */
    private final zzxn f29564b;

    /* renamed from: c */
    private final boolean f29565c;

    /* renamed from: a */
    public static zzwj m31331a() {
        return new zzwj();
    }

    public zzwj(zzwo zzwo) {
        this.f29563a = zzwo;
        this.f29565c = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f23990Pd)).booleanValue();
        this.f29564b = new zzxn();
        m31332b();
    }

    private zzwj() {
        this.f29565c = false;
        this.f29563a = new zzwo();
        this.f29564b = new zzxn();
        m31332b();
    }

    /* renamed from: a */
    public final synchronized void mo32330a(zzb zzb) {
        if (this.f29565c) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23996Qd)).booleanValue()) {
                m31334c(zzb);
            } else {
                m31333b(zzb);
            }
        }
    }

    /* renamed from: b */
    private final synchronized void m31333b(zzb zzb) {
        this.f29564b.f29691h = m31335c();
        this.f29563a.mo32331a(zzdrw.m30019a((zzdrw) this.f29564b)).mo32334b(zzb.mo30728d()).mo32333a();
        String str = "Logging Event with event code : ";
        String valueOf = String.valueOf(Integer.toString(zzb.mo30728d(), 10));
        zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: c */
    private final synchronized void m31334c(zzb zzb) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(m31336d(zzb).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        zzawz.m26003f("Could not close Clearcut output stream.");
                    }
                } catch (IOException e2) {
                    zzawz.m26003f("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        zzawz.m26003f("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException e4) {
                zzawz.m26003f("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    zzawz.m26003f("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    /* renamed from: d */
    private final synchronized String m31336d(zzb zzb) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.f29564b.f29687d, Long.valueOf(zzk.zzln().mo27934a()), Integer.valueOf(zzb.mo30728d()), Base64.encodeToString(zzdrw.m30019a((zzdrw) this.f29564b), 3)});
    }

    /* renamed from: a */
    public final synchronized void mo32329a(zzwk zzwk) {
        if (this.f29565c) {
            try {
                zzwk.mo28018a(this.f29564b);
            } catch (NullPointerException e) {
                zzk.zzlk().mo30168a((Throwable) e, "AdMobClearcutLogger.modify");
            }
        }
    }

    /* renamed from: b */
    private final synchronized void m31332b() {
        this.f29564b.f29695l = new zzxj();
        this.f29564b.f29695l.f29665f = new zzxk();
        this.f29564b.f29692i = new zzxl();
    }

    /* renamed from: c */
    private static long[] m31335c() {
        int i;
        List b = zzacu.m24784b();
        ArrayList arrayList = new ArrayList();
        Iterator it = b.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] split = ((String) it.next()).split(",");
            int length = split.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(split[i]));
                } catch (NumberFormatException e) {
                    zzawz.m26003f("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        int size = arrayList.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }
}
