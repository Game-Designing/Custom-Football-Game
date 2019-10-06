package p005cm.aptoide.p006pt.actions;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;

/* renamed from: cm.aptoide.pt.actions.PermissionManager */
public class PermissionManager {
    public C0120S<Void> requestExternalStoragePermission(PermissionService permissionService) {
        return C0120S.m634a((C0122a<T>) new RequestAccessToExternalFileSystemOnSubscribe<T>(permissionService));
    }

    public C0120S<Void> requestDownloadAccess(PermissionService permissionService) {
        return C0120S.m634a((C0122a<T>) new RequestDownloadAccessOnSubscribe<T>(permissionService, false));
    }

    public C0120S<Void> requestDownloadAllowingMobileData(PermissionService permissionService) {
        return C0120S.m634a((C0122a<T>) new RequestDownloadAccessOnSubscribe<T>(permissionService, true));
    }
}
