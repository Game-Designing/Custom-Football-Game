package p005cm.aptoide.p006pt.app.view.donations;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.donations.data.GetWalletAddressResponse;
import p005cm.aptoide.p006pt.app.view.donations.data.GetWalletAddressResponse.Data;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* renamed from: cm.aptoide.pt.app.view.donations.WalletService */
public class WalletService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ServiceV7 service;
    private C0126V viewScheduler;

    /* renamed from: cm.aptoide.pt.app.view.donations.WalletService$ServiceV7 */
    public interface ServiceV7 {
        @GET("bds/apks/package/getOwnerWallet")
        C0120S<GetWalletAddressResponse> getWallet(@Query("package_name") String str);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4416063217801659081L, "cm/aptoide/pt/app/view/donations/WalletService", 7);
        $jacocoData = probes;
        return probes;
    }

    public WalletService(ServiceV7 service2, C0126V viewScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.viewScheduler = viewScheduler2;
        $jacocoInit[0] = true;
    }

    public Single<String> getWalletAddress(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S wallet = this.service.getWallet(packageName);
        C2039b bVar = C2039b.f5082a;
        $jacocoInit[1] = true;
        C0120S j = wallet.mo3669j(bVar);
        $jacocoInit[2] = true;
        Single n = j.mo3678n();
        C0126V v = this.viewScheduler;
        $jacocoInit[3] = true;
        Single<String> b = n.mo3694b(v);
        $jacocoInit[4] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ String m6963a(GetWalletAddressResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = response.getData();
        $jacocoInit[5] = true;
        String address = data.getAddress();
        $jacocoInit[6] = true;
        return address;
    }
}
