package p005cm.aptoide.p006pt.actions;

import android.annotation.TargetApi;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.actions.PermissionService */
public interface PermissionService {
    @TargetApi(23)
    void requestAccessToAccounts(C0128a aVar, C0128a aVar2);

    @TargetApi(23)
    void requestAccessToAccounts(boolean z, C0128a aVar, C0128a aVar2);

    @TargetApi(23)
    void requestAccessToCamera(C0128a aVar, C0128a aVar2);

    @TargetApi(23)
    void requestAccessToExternalFileSystem(C0128a aVar, C0128a aVar2);

    @TargetApi(23)
    void requestAccessToExternalFileSystem(boolean z, int i, C0128a aVar, C0128a aVar2);

    @TargetApi(23)
    void requestAccessToExternalFileSystem(boolean z, C0128a aVar, C0128a aVar2);

    @TargetApi(23)
    void requestDownloadAccess(C0128a aVar, C0128a aVar2, boolean z);
}
