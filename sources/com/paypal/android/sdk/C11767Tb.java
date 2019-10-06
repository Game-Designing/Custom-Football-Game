package com.paypal.android.sdk;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.paypal.android.sdk.Tb */
public final class C11767Tb {

    /* renamed from: a */
    public LinearLayout f37034a = this.f37035b;

    /* renamed from: b */
    private LinearLayout f37035b;

    /* renamed from: c */
    public TextView f37036c;

    public C11767Tb(Context context) {
        this.f37035b = new LinearLayout(context);
        this.f37035b.setOrientation(0);
        this.f37036c = new TextView(context);
        this.f37036c.setText("server");
        this.f37036c.setTextColor(-1);
        this.f37036c.setBackgroundColor(C11711Ca.f36621j);
        this.f37036c.setGravity(17);
        this.f37035b.addView(this.f37036c);
        String str = "8dip";
        C11715Da.m38781a(this.f37036c, str, str, str, str);
        C11715Da.m38777a((View) this.f37036c, -2, -2);
        String str2 = "15dip";
        C11715Da.m38789b(this.f37036c, null, str2, null, str2);
        C11715Da.m38776a((View) this.f37036c, 1, 1.0f);
    }
}
