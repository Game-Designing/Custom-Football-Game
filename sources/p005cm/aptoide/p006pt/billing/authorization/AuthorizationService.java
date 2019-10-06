package p005cm.aptoide.p006pt.billing.authorization;

import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.authorization.AuthorizationService */
public interface AuthorizationService {
    Single<Authorization> getAuthorization(String str, String str2);

    Single<Authorization> updateAuthorization(String str, String str2, String str3);
}
