package p019d.p273h.p285d.p291e;

import android.app.Activity;
import com.ironsource.sdk.controller.C10877y;
import p019d.p273h.p285d.p287b.C12971c;
import p019d.p273h.p285d.p295h.C13001d;

/* renamed from: d.h.d.e.b */
/* compiled from: BackButtonHandler */
public class C12980b {

    /* renamed from: a */
    public static C12980b f39936a;

    /* renamed from: a */
    public static C12980b m42339a() {
        C12980b bVar = f39936a;
        if (bVar == null) {
            return new C12980b();
        }
        return bVar;
    }

    /* renamed from: a */
    public boolean mo41856a(Activity activity) {
        int i = C12979a.f39935a[C13001d.m42395g().mo41898b().ordinal()];
        if (i == 1 || i == 2 || i != 3) {
            return false;
        }
        try {
            C10877y webViewController = C12971c.m42271a(activity).mo41839b();
            if (webViewController != null) {
                webViewController.mo35491f("back");
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
