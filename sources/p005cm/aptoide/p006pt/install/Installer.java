package p005cm.aptoide.p006pt.install;

import android.content.Context;
import p005cm.aptoide.p006pt.install.installer.InstallationState;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.install.Installer */
public interface Installer {
    C0117M downgrade(Context context, String str, boolean z, boolean z2);

    C0120S<InstallationState> getState(String str, int i);

    C0117M install(Context context, String str, boolean z, boolean z2);

    C0117M uninstall(Context context, String str, String str2);

    C0117M update(Context context, String str, boolean z, boolean z2);
}
