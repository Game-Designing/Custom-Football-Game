package p005cm.aptoide.p006pt.account.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.permission.PermissionServiceFragment;

/* renamed from: cm.aptoide.pt.account.view.GooglePlayServicesFragment */
public abstract class GooglePlayServicesFragment extends PermissionServiceFragment implements GooglePlayServicesView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int RESOLVE_CONNECTION_ERROR_REQUEST_CODE = 1;
    private GoogleApiAvailability apiAvailability;
    private Dialog errorDialog;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3939129353100278137L, "cm/aptoide/pt/account/view/GooglePlayServicesFragment", 21);
        $jacocoData = probes;
        return probes;
    }

    public GooglePlayServicesFragment() {
        $jacocoInit()[0] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[1] = true;
        this.apiAvailability = GoogleApiAvailability.getInstance();
        $jacocoInit[2] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        Dialog dialog = this.errorDialog;
        if (dialog == null) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            dialog.dismiss();
            this.errorDialog = null;
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
    }

    public void showConnectionError(ConnectionResult connectionResult) {
        boolean[] $jacocoInit = $jacocoInit();
        if (connectionResult.mo27279e()) {
            $jacocoInit[7] = true;
            showResolution(connectionResult);
            $jacocoInit[8] = true;
        } else {
            showConnectionErrorMessage(connectionResult.mo27275a());
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
    }

    private void showResolution(ConnectionResult result) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            result.mo27276a(getActivity(), 1);
            $jacocoInit[11] = true;
        } catch (SendIntentException e) {
            $jacocoInit[12] = true;
            CrashReport instance = CrashReport.getInstance();
            $jacocoInit[13] = true;
            instance.log(e);
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
    }

    private void showConnectionErrorMessage(int errorCode) {
        boolean[] $jacocoInit = $jacocoInit();
        Dialog dialog = this.errorDialog;
        if (dialog == null) {
            $jacocoInit[16] = true;
        } else if (!dialog.isShowing()) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            return;
        }
        this.errorDialog = this.apiAvailability.mo27295a((Activity) getActivity(), errorCode, 1);
        $jacocoInit[19] = true;
        this.errorDialog.show();
        $jacocoInit[20] = true;
    }
}
