package p005cm.aptoide.p006pt.navigator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.navigator.ActivityNavigator */
public interface ActivityNavigator {
    Activity getActivity();

    void navigateBack();

    void navigateBackWithResult(int i, Bundle bundle);

    C0120S<Result> navigateForResult(String str, Uri uri, int i);

    void navigateForResult(Intent intent, int i);

    void navigateForResult(Class<? extends Activity> cls, int i, Bundle bundle);

    void navigateForResult(String str, Uri uri, int i, String str2, String str3);

    C0120S<Result> navigateForResultWithOutput(String str, Uri uri, int i);

    void navigateTo(Uri uri);

    void navigateTo(Class<? extends Activity> cls);

    void navigateTo(Class<? extends Activity> cls, Bundle bundle);

    C0120S<Result> results();

    C0120S<Result> results(int i);
}
