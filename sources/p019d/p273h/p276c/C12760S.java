package p019d.p273h.p276c;

import android.text.TextUtils;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.List;
import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.S */
/* compiled from: ProgIsManager */
class C12760S implements C12901g {

    /* renamed from: a */
    final /* synthetic */ C12761T f39195a;

    C12760S(C12761T this$0) {
        this.f39195a = this$0;
    }

    /* renamed from: a */
    public void mo41262a(boolean isSuccess, List<C12905h> newWaterfall, String auctionId, int errorCode, String errorMessage, long elapsedTime) {
        int i = errorCode;
        String str = errorMessage;
        String str2 = VastIconXmlManager.DURATION;
        if (isSuccess) {
            this.f39195a.f39202g = auctionId;
            this.f39195a.m41305a(2301, new Object[][]{new Object[]{str2, Long.valueOf(elapsedTime)}});
            this.f39195a.m41314a(newWaterfall);
            this.f39195a.m41315b();
            return;
        }
        List<C12905h> list = newWaterfall;
        String str3 = auctionId;
        String str4 = "errorCode";
        if (TextUtils.isEmpty(errorMessage)) {
            this.f39195a.m41305a(2300, new Object[][]{new Object[]{str4, Integer.valueOf(errorCode)}, new Object[]{str2, Long.valueOf(elapsedTime)}});
            C12937p.m42122a().mo41746a(new C12799b(i, "Auction failed"));
            this.f39195a.m41305a(2110, new Object[][]{new Object[]{str4, Integer.valueOf(errorCode)}});
        } else {
            String errorReason = str.substring(0, Math.min(errorMessage.length(), 39));
            String str5 = "reason";
            this.f39195a.m41305a(2300, new Object[][]{new Object[]{str4, Integer.valueOf(errorCode)}, new Object[]{str5, errorReason}, new Object[]{str2, Long.valueOf(elapsedTime)}});
            C12937p.m42122a().mo41746a(new C12799b(i, str));
            this.f39195a.m41305a(2110, new Object[][]{new Object[]{str4, Integer.valueOf(errorCode)}, new Object[]{str5, errorReason}});
        }
        this.f39195a.m41307a(C12762a.STATE_READY_TO_LOAD);
    }
}
