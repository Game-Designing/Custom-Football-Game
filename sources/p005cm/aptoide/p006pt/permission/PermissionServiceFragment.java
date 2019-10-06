package p005cm.aptoide.p006pt.permission;

import android.annotation.TargetApi;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.actions.PermissionService;
import p005cm.aptoide.p006pt.view.BackButtonFragment;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.permission.PermissionServiceFragment */
public abstract class PermissionServiceFragment extends BackButtonFragment implements PermissionService {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7080289525900785783L, "cm/aptoide/pt/permission/PermissionServiceFragment", 29);
        $jacocoData = probes;
        return probes;
    }

    public PermissionServiceFragment() {
        $jacocoInit()[0] = true;
    }

    @TargetApi(23)
    public void requestAccessToAccounts(C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ((PermissionService) getActivity()).requestAccessToAccounts(toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
            $jacocoInit[4] = true;
        } catch (ClassCastException e) {
            $jacocoInit[1] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Containing activity of this fragment must implement ");
            $jacocoInit[2] = true;
            sb.append(PermissionService.class.getName());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[3] = true;
            throw illegalStateException;
        }
    }

    @TargetApi(23)
    public void requestAccessToAccounts(boolean forceShowRationale, C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ((PermissionService) getActivity()).requestAccessToAccounts(forceShowRationale, toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
            $jacocoInit[8] = true;
        } catch (ClassCastException e) {
            $jacocoInit[5] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Containing activity of this fragment must implement ");
            $jacocoInit[6] = true;
            sb.append(PermissionService.class.getName());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[7] = true;
            throw illegalStateException;
        }
    }

    @TargetApi(23)
    public void requestDownloadAccess(C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied, boolean shouldValidateMobileData) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ((PermissionService) getActivity()).requestDownloadAccess(toRunWhenAccessIsGranted, toRunWhenAccessIsDenied, shouldValidateMobileData);
            $jacocoInit[12] = true;
        } catch (ClassCastException e) {
            $jacocoInit[9] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Containing activity of this fragment must implement ");
            $jacocoInit[10] = true;
            sb.append(PermissionService.class.getName());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[11] = true;
            throw illegalStateException;
        }
    }

    @TargetApi(23)
    public void requestAccessToCamera(C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ((PermissionService) getActivity()).requestAccessToCamera(toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
            $jacocoInit[16] = true;
        } catch (ClassCastException e) {
            $jacocoInit[13] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Containing activity of this fragment must implement ");
            $jacocoInit[14] = true;
            sb.append(PermissionService.class.getName());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[15] = true;
            throw illegalStateException;
        }
    }

    @TargetApi(23)
    public void requestAccessToExternalFileSystem(C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ((PermissionService) getActivity()).requestAccessToExternalFileSystem(toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
            $jacocoInit[20] = true;
        } catch (ClassCastException e) {
            $jacocoInit[17] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Containing activity of this fragment must implement ");
            $jacocoInit[18] = true;
            sb.append(PermissionService.class.getName());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[19] = true;
            throw illegalStateException;
        }
    }

    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean forceShowRationale, C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ((PermissionService) getActivity()).requestAccessToExternalFileSystem(forceShowRationale, toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
            $jacocoInit[24] = true;
        } catch (ClassCastException e) {
            $jacocoInit[21] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Containing activity of this fragment must implement ");
            $jacocoInit[22] = true;
            sb.append(PermissionService.class.getName());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[23] = true;
            throw illegalStateException;
        }
    }

    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean forceShowRationale, int rationaleMessage, C0128a toRunWhenAccessIsGranted, C0128a toRunWhenAccessIsDenied) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            ((PermissionService) getActivity()).requestAccessToExternalFileSystem(forceShowRationale, rationaleMessage, toRunWhenAccessIsGranted, toRunWhenAccessIsDenied);
            $jacocoInit[28] = true;
        } catch (ClassCastException e) {
            $jacocoInit[25] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("Containing activity of this fragment must implement ");
            $jacocoInit[26] = true;
            sb.append(PermissionService.class.getName());
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[27] = true;
            throw illegalStateException;
        }
    }
}
