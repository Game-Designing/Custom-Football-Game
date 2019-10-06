package p005cm.aptoide.p006pt.account.view.exception;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.StoreLinks;

/* renamed from: cm.aptoide.pt.account.view.exception.SocialLinkException */
public class SocialLinkException extends Exception {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private List<StoreLinks> storeLinks;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5818512926912074203L, "cm/aptoide/pt/account/view/exception/SocialLinkException", 2);
        $jacocoData = probes;
        return probes;
    }

    public SocialLinkException(List<StoreLinks> storeLinks2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeLinks = storeLinks2;
        $jacocoInit[0] = true;
    }

    public List<StoreLinks> getStoreLinks() {
        boolean[] $jacocoInit = $jacocoInit();
        List<StoreLinks> list = this.storeLinks;
        $jacocoInit[1] = true;
        return list;
    }
}
