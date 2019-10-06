package p005cm.aptoide.p006pt.view.wizard;

import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.view.wizard.WizardView */
public interface WizardView extends View {
    C0117M createWizardAdapter(boolean z);

    int getCount();

    void handleColorTransitions(int i, float f, int i2);

    void handleSelectedPage(int i);

    void skipWizard();

    C0120S<Void> skipWizardClick();
}
