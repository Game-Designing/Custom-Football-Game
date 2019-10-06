package com.facebook.login;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.internal.C6694S.C6696b;
import java.util.Date;

/* renamed from: com.facebook.login.h */
/* compiled from: DeviceAuthDialog */
class C6763h implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f12424a;

    /* renamed from: b */
    final /* synthetic */ C6696b f12425b;

    /* renamed from: c */
    final /* synthetic */ String f12426c;

    /* renamed from: d */
    final /* synthetic */ Date f12427d;

    /* renamed from: e */
    final /* synthetic */ Date f12428e;

    /* renamed from: f */
    final /* synthetic */ DeviceAuthDialog f12429f;

    C6763h(DeviceAuthDialog this$0, String str, C6696b bVar, String str2, Date date, Date date2) {
        this.f12429f = this$0;
        this.f12424a = str;
        this.f12425b = bVar;
        this.f12426c = str2;
        this.f12427d = date;
        this.f12428e = date2;
    }

    public void onClick(DialogInterface alertDialog, int which) {
        this.f12429f.m13635a(this.f12424a, this.f12425b, this.f12426c, this.f12427d, this.f12428e);
    }
}
