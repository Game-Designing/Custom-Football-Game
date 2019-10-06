package p005cm.aptoide.p006pt.navigator;

import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.Fragment;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.navigator.FragmentNavigator */
public interface FragmentNavigator {
    public static final String REQUEST_CODE_EXTRA = "cm.aptoide.pt.view.navigator.extra.REQUEST_CODE";

    void cleanBackStack();

    Fragment getFragment();

    Fragment getFragment(String str);

    void navigateForResult(Fragment fragment, int i, boolean z);

    String navigateTo(Fragment fragment, boolean z);

    void navigateToCleaningBackStack(Fragment fragment, boolean z);

    void navigateToDialogForResult(C0478k kVar, int i);

    void navigateToDialogFragment(C0478k kVar);

    void navigateToWithoutBackSave(Fragment fragment, boolean z);

    Fragment peekLast();

    boolean popBackStack();

    void popDialogWithResult(Result result);

    void popWithResult(Result result);

    C0120S<Result> results(int i);
}
