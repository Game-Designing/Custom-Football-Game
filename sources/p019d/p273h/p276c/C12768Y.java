package p019d.p273h.p276c;

import android.text.TextUtils;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.List;

/* renamed from: d.h.c.Y */
/* compiled from: ProgRvManager */
class C12768Y implements C12901g {

    /* renamed from: a */
    final /* synthetic */ C12769Z f39233a;

    C12768Y(C12769Z this$0) {
        this.f39233a = this$0;
    }

    /* renamed from: a */
    public void mo41262a(boolean isSuccess, List<C12905h> newWaterfall, String auctionId, int errorCode, String errorMessage, long elapsedTime) {
        String str = VastIconXmlManager.DURATION;
        if (isSuccess) {
            this.f39233a.m41374a(1302, new Object[][]{new Object[]{str, Long.valueOf(elapsedTime)}});
            this.f39233a.f39241h = auctionId;
            this.f39233a.m41383a(newWaterfall);
            this.f39233a.m41384b();
            String str2 = errorMessage;
            return;
        }
        List<C12905h> list = newWaterfall;
        String str3 = auctionId;
        String str4 = "errorCode";
        if (TextUtils.isEmpty(errorMessage)) {
            this.f39233a.m41374a(1301, new Object[][]{new Object[]{str4, Integer.valueOf(errorCode)}, new Object[]{str, Long.valueOf(elapsedTime)}});
            String str5 = errorMessage;
        } else {
            String errorReason = errorMessage.substring(0, Math.min(errorMessage.length(), 39));
            this.f39233a.m41374a(1301, new Object[][]{new Object[]{str4, Integer.valueOf(errorCode)}, new Object[]{"reason", errorReason}, new Object[]{str, Long.valueOf(elapsedTime)}});
        }
        this.f39233a.m41387b(false);
        this.f39233a.m41376a(C12770a.RV_STATE_NOT_LOADED);
        this.f39233a.f39248o.mo41765a();
    }
}
