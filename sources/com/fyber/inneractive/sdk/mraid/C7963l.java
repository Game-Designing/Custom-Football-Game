package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.mraid.C7954e.C7956a;
import com.fyber.inneractive.sdk.p179l.C7930d;
import java.util.Map;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;

/* renamed from: com.fyber.inneractive.sdk.mraid.l */
final class C7963l extends C7950a {
    public C7963l(Map<String, String> map, C7930d dVar) {
        super(map, dVar);
    }

    /* renamed from: a */
    public final void mo24813a() {
        String b = mo24814b(DeepLinksKeys.URI);
        if (b == null || "".equals(b)) {
            this.f16231c.mo24770a(C7956a.PLAY_VIDEO, "Video can't be played with null or empty URL");
        } else {
            this.f16231c.mo24775d(b);
        }
    }

    /* renamed from: b */
    public final boolean mo24815b() {
        return true;
    }
}
