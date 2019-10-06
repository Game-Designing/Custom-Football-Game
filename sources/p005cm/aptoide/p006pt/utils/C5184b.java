package p005cm.aptoide.p006pt.utils;

import java.util.Comparator;
import p005cm.aptoide.p006pt.permissions.ApkPermission;

/* renamed from: cm.aptoide.pt.utils.b */
/* compiled from: lambda */
public final /* synthetic */ class C5184b implements Comparator {

    /* renamed from: a */
    public static final /* synthetic */ C5184b f8945a = new C5184b();

    private /* synthetic */ C5184b() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((ApkPermission) obj).getName().compareTo(((ApkPermission) obj2).getName());
    }
}
