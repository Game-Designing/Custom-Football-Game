package p024io.realm.internal;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import p024io.realm.C14001L;
import p024io.realm.exceptions.RealmException;

/* renamed from: io.realm.internal.j */
/* compiled from: ObjectServerFacade */
public class C7335j {

    /* renamed from: a */
    private static final C7335j f14314a = new C7335j();

    /* renamed from: b */
    private static C7335j f14315b;

    static {
        String str = "Failed to init SyncObjectServerFacade";
        f14315b = null;
        try {
            f14315b = (C7335j) Class.forName("io.realm.internal.SyncObjectServerFacade").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e2) {
            throw new RealmException(str, e2);
        } catch (IllegalAccessException e3) {
            throw new RealmException(str, e3);
        } catch (NoSuchMethodException e4) {
            throw new RealmException(str, e4);
        } catch (InvocationTargetException e5) {
            throw new RealmException(str, e5.getTargetException());
        }
    }

    /* renamed from: a */
    public void mo23772a(Context context) {
    }

    /* renamed from: e */
    public void mo23777e(C14001L configuration) {
    }

    /* renamed from: d */
    public Object[] mo23776d(C14001L config) {
        return new Object[6];
    }

    /* renamed from: a */
    public static C7335j m16149a(boolean needSyncFacade) {
        if (needSyncFacade) {
            return f14315b;
        }
        return f14314a;
    }

    /* renamed from: a */
    public static C7335j m16148a() {
        C7335j jVar = f14315b;
        if (jVar != null) {
            return jVar;
        }
        return f14314a;
    }

    /* renamed from: f */
    public void mo23778f(C14001L config) {
    }

    /* renamed from: b */
    public String mo23774b(C14001L config) {
        return null;
    }

    /* renamed from: c */
    public String mo23775c(C14001L config) {
        return null;
    }

    /* renamed from: a */
    public void mo23773a(C14001L config) {
    }
}
