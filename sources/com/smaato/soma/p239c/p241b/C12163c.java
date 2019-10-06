package com.smaato.soma.p239c.p241b;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p239c.p254k.C12301p;
import com.smaato.soma.p255d.C12316i;

/* renamed from: com.smaato.soma.c.b.c */
/* compiled from: MraidBridge */
class C12163c extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ C12316i f38138a;

    /* renamed from: b */
    final /* synthetic */ String f38139b;

    /* renamed from: c */
    final /* synthetic */ String f38140c;

    /* renamed from: d */
    final /* synthetic */ C12173m f38141d;

    C12163c(C12173m this$0, C12316i iVar, String str, String str2) {
        this.f38141d = this$0;
        this.f38138a = iVar;
        this.f38139b = str;
        this.f38140c = str2;
    }

    public Boolean process() throws Exception {
        ((C12301p) this.f38141d.f38166a.mo39361l()).mo39720a(this.f38138a, this.f38139b);
        C12173m mVar = this.f38141d;
        StringBuilder sb = new StringBuilder();
        sb.append("User click was not detected before executing ");
        sb.append(this.f38140c);
        mVar.m40006a(sb.toString(), this.f38140c);
        return Boolean.valueOf(true);
    }
}
