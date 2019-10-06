package com.mopub.common.privacy;

import com.mopub.common.Preconditions;

/* renamed from: com.mopub.common.privacy.i */
/* compiled from: ConsentDialogResponse */
class C11270i {

    /* renamed from: a */
    private final String f34541a;

    C11270i(String html) {
        Preconditions.checkNotNull(html);
        this.f34541a = html;
    }

    public String getHtml() {
        return this.f34541a;
    }
}
