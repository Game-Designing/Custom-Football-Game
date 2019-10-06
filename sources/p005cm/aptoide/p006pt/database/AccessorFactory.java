package p005cm.aptoide.p006pt.database;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.Accessor;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.database.accessors.DownloadAccessor;
import p005cm.aptoide.p006pt.database.accessors.InstallationAccessor;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p005cm.aptoide.p006pt.database.accessors.NotificationAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.database.realm.Update;
import p024io.realm.C0106Z;

@Deprecated
/* renamed from: cm.aptoide.pt.database.AccessorFactory */
public final class AccessorFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9026688978997740555L, "cm/aptoide/pt/database/AccessorFactory", 14);
        $jacocoData = probes;
        return probes;
    }

    public AccessorFactory() {
        $jacocoInit()[0] = true;
    }

    public static <T extends C0106Z, A extends Accessor> A getAccessorFor(Database database, Class<T> clazz) {
        boolean[] $jacocoInit = $jacocoInit();
        if (clazz.equals(Installed.class)) {
            $jacocoInit[1] = true;
            A installedAccessor = new InstalledAccessor(database, new InstallationAccessor(database));
            $jacocoInit[2] = true;
            return installedAccessor;
        } else if (clazz.equals(Download.class)) {
            $jacocoInit[3] = true;
            A downloadAccessor = new DownloadAccessor(database);
            $jacocoInit[4] = true;
            return downloadAccessor;
        } else if (clazz.equals(Update.class)) {
            $jacocoInit[5] = true;
            A updateAccessor = new UpdateAccessor(database);
            $jacocoInit[6] = true;
            return updateAccessor;
        } else if (clazz.equals(Store.class)) {
            $jacocoInit[7] = true;
            A storeAccessor = new StoreAccessor(database);
            $jacocoInit[8] = true;
            return storeAccessor;
        } else if (clazz.equals(StoredMinimalAd.class)) {
            $jacocoInit[9] = true;
            A storedMinimalAdAccessor = new StoredMinimalAdAccessor(database);
            $jacocoInit[10] = true;
            return storedMinimalAdAccessor;
        } else if (clazz.equals(Notification.class)) {
            $jacocoInit[11] = true;
            A notificationAccessor = new NotificationAccessor(database);
            $jacocoInit[12] = true;
            return notificationAccessor;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Create accessor for class ");
            sb.append(clazz.getName());
            RuntimeException runtimeException = new RuntimeException(sb.toString());
            $jacocoInit[13] = true;
            throw runtimeException;
        }
    }
}
