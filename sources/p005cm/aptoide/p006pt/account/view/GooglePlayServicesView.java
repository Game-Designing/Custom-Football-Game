package p005cm.aptoide.p006pt.account.view;

import com.google.android.gms.common.ConnectionResult;
import p005cm.aptoide.p006pt.presenter.View;

/* renamed from: cm.aptoide.pt.account.view.GooglePlayServicesView */
public interface GooglePlayServicesView extends View {
    void showConnectionError(ConnectionResult connectionResult);
}
