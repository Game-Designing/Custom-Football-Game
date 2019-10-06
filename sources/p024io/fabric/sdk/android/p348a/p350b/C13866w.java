package p024io.fabric.sdk.android.p348a.p350b;

import android.content.Context;
import java.lang.reflect.Method;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: io.fabric.sdk.android.a.b.w */
/* compiled from: FirebaseAppImpl */
final class C13866w implements C13865v {

    /* renamed from: a */
    private final Method f42066a;

    /* renamed from: b */
    private final Object f42067b;

    /* renamed from: a */
    public static C13865v m44081a(Context context) {
        String str = "Fabric";
        try {
            Class firebaseAppClass = context.getClassLoader().loadClass("com.google.firebase.FirebaseApp");
            return new C13866w(firebaseAppClass, firebaseAppClass.getDeclaredMethod("getInstance", new Class[0]).invoke(firebaseAppClass, new Object[0]));
        } catch (ClassNotFoundException e) {
            C13920f.m44245e().mo43326c(str, "Could not find class: com.google.firebase.FirebaseApp");
            return null;
        } catch (NoSuchMethodException e2) {
            C13929o e3 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find method: ");
            sb.append(e2.getMessage());
            e3.mo43326c(str, sb.toString());
            return null;
        } catch (Exception e4) {
            C13920f.m44245e().mo43327c(str, "Unexpected error loading FirebaseApp instance.", e4);
            return null;
        }
    }

    private C13866w(Class firebaseAppClass, Object instance) throws NoSuchMethodException {
        this.f42067b = instance;
        this.f42066a = firebaseAppClass.getDeclaredMethod("isDataCollectionDefaultEnabled", new Class[0]);
    }

    /* renamed from: a */
    public boolean mo43252a() {
        try {
            return ((Boolean) this.f42066a.invoke(this.f42067b, new Object[0])).booleanValue();
        } catch (Exception e) {
            C13920f.m44245e().mo43327c("Fabric", "Cannot check isDataCollectionDefaultEnabled on FirebaseApp.", e);
            return false;
        }
    }
}
