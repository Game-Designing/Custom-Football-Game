package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C8581R;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

@zzard
public final class zzapo extends zzaqb {

    /* renamed from: c */
    private final Map<String, String> f24527c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f24528d;

    /* renamed from: e */
    private String f24529e = m25628d(Repo.COLUMN_DESCRIPTION);

    /* renamed from: f */
    private long f24530f = m25629e("start_ticks");

    /* renamed from: g */
    private long f24531g = m25629e("end_ticks");

    /* renamed from: h */
    private String f24532h = m25628d("summary");

    /* renamed from: i */
    private String f24533i = m25628d("location");

    public zzapo(zzbgz zzbgz, Map<String, String> map) {
        super(zzbgz, "createCalendarEvent");
        this.f24527c = map;
        this.f24528d = zzbgz.mo28780q();
    }

    /* renamed from: d */
    private final String m25628d(String str) {
        return TextUtils.isEmpty((CharSequence) this.f24527c.get(str)) ? "" : (String) this.f24527c.get(str);
    }

    /* renamed from: e */
    private final long m25629e(String str) {
        String str2 = (String) this.f24527c.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* renamed from: b */
    public final void mo29974b() {
        if (this.f24528d == null) {
            mo29991a("Activity context is not available.");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.m26134e(this.f24528d).mo29588d()) {
            mo29991a("This feature is not available on the device.");
            return;
        }
        zzk.zzlg();
        Builder d = zzaxi.m26131d(this.f24528d);
        Resources b = zzk.zzlk().mo30169b();
        d.setTitle(b != null ? b.getString(C8581R.string.f19074s5) : "Create calendar event");
        d.setMessage(b != null ? b.getString(C8581R.string.f19075s6) : "Allow Ad to create a calendar event?");
        d.setPositiveButton(b != null ? b.getString(C8581R.string.f19072s3) : "Accept", new C9464hb(this));
        d.setNegativeButton(b != null ? b.getString(C8581R.string.f19073s4) : "Decline", new C9486ib(this));
        d.create().show();
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(14)
    /* renamed from: a */
    public final Intent mo29973a() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.f24529e);
        data.putExtra("eventLocation", this.f24533i);
        data.putExtra(Repo.COLUMN_DESCRIPTION, this.f24532h);
        long j = this.f24530f;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.f24531g;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }
}
