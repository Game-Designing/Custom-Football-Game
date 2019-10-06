package p019d.p143b.p150d;

import java.util.Map;

/* renamed from: d.b.d.e */
public interface C7255e {
    void userDeclinedToViewAd(C7251a aVar);

    void userOverQuota(C7251a aVar, Map<String, String> map);

    void userRewardRejected(C7251a aVar, Map<String, String> map);

    void userRewardVerified(C7251a aVar, Map<String, String> map);

    void validationRequestFailed(C7251a aVar, int i);
}
