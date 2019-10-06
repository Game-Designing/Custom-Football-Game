package com.smaato.soma.p239c.p254k;

import android.content.Context;
import android.content.Intent;
import com.smaato.soma.C12398ha;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: com.smaato.soma.c.k.m */
/* compiled from: CustomWebView */
class C12298m extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ String f38472a;

    /* renamed from: b */
    final /* synthetic */ Context f38473b;

    /* renamed from: c */
    final /* synthetic */ C12301p f38474c;

    C12298m(C12301p this$0, String str, Context context) {
        this.f38474c = this$0;
        this.f38472a = str;
        this.f38473b = context;
    }

    public Void process() throws Exception {
        String text;
        Intent i = new Intent("android.intent.action.SEND");
        i.setFlags(268435456);
        i.putExtra("android.intent.extra.EMAIL", new String[]{"adqualitysupport@smaato.com"});
        i.putExtra("android.intent.extra.SUBJECT", "Ad Report");
        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("gmt"));
        String gmtTime = df.format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("Publisher Id : ");
        sb.append(this.f38474c.f38481c.getAdSettings().mo39891g());
        sb.append("\nAdSpace Id : ");
        sb.append(this.f38474c.f38481c.getAdSettings().mo39887c());
        sb.append("\nSession Id : ");
        sb.append(this.f38474c.f38483e.getSessionId());
        sb.append("\nTime : ");
        sb.append(gmtTime);
        sb.append("\n");
        sb.append("I'm reporting this ad for the following reason: @REASON. Thanks for taking care. \nPlease find all info below : \n".replace("@REASON", this.f38472a));
        String text2 = sb.toString();
        if (C12300o.f38478a[this.f38474c.f38483e.mo39284b().ordinal()] != 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text2);
            sb2.append("Text Ad Click Url : ");
            sb2.append(this.f38474c.f38483e.mo39297l());
            text = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(text2);
            sb3.append("Rich Media Tag : ");
            sb3.append(this.f38474c.f38483e.mo39286c());
            text = sb3.toString();
        }
        i.putExtra("android.intent.extra.TEXT", text);
        i.putExtra("android.intent.extra.STREAM", this.f38474c.getScreenShotUri());
        i.setType("plain/text");
        this.f38473b.startActivity(i);
        return null;
    }
}
