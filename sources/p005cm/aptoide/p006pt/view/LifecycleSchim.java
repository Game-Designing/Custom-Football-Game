package p005cm.aptoide.p006pt.view;

import android.os.Bundle;

/* renamed from: cm.aptoide.pt.view.LifecycleSchim */
public interface LifecycleSchim {
    void onDestroyView();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onViewCreated();

    void onViewStateRestored(Bundle bundle);
}
