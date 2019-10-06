package com.mopub.common.privacy;

import com.mopub.common.CloseableLayout.OnCloseListener;

/* renamed from: com.mopub.common.privacy.f */
/* compiled from: ConsentDialogLayout */
class C11265f implements OnCloseListener {

    /* renamed from: a */
    final /* synthetic */ C11267h f34534a;

    C11265f(C11267h this$0) {
        this.f34534a = this$0;
    }

    public void onClose() {
        if (this.f34534a.f34539r != null) {
            this.f34534a.f34539r.onCloseClick();
        }
    }
}
