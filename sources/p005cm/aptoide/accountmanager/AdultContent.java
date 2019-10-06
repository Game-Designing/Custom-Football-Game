package p005cm.aptoide.accountmanager;

import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.accountmanager.AdultContent */
public interface AdultContent {
    C0117M disable(boolean z);

    C0117M enable(int i);

    C0117M enable(boolean z);

    C0120S<Boolean> enabled();

    C0120S<Boolean> pinRequired();

    C0117M removePin(int i);

    C0117M requirePin(int i);
}
