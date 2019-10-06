package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.ads.bn */
/* compiled from: RenderTimeoutHandler */
final class C10462bn extends Handler {

    /* renamed from: a */
    private WeakReference<C10545i> f31825a;

    C10462bn(C10545i iVar) {
        this.f31825a = new WeakReference<>(iVar);
    }

    public final void handleMessage(Message message) {
        C10545i iVar = (C10545i) this.f31825a.get();
        if (iVar != null && message.what == 0) {
            try {
                if (iVar instanceof C10365ac) {
                    C10365ac acVar = (C10365ac) iVar;
                    if (acVar.f32185u != null) {
                        acVar.f32185u.stopLoading();
                        iVar.mo34279D();
                        return;
                    }
                }
                RenderView renderView = (RenderView) iVar.mo34302j();
                if (renderView == null) {
                    iVar.mo34279D();
                    return;
                }
                renderView.stopLoading();
                iVar.mo34279D();
            } catch (Exception e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
            } catch (Throwable th) {
                iVar.mo34279D();
                throw th;
            }
        }
    }
}
