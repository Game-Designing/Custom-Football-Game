package p005cm.aptoide.p006pt.billing.authorization;

import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.authorization.AuthorizationPersistence */
public interface AuthorizationPersistence {
    Single<Authorization> createAuthorization(String str, String str2, Status status);

    C0120S<Authorization> getAuthorization(String str, String str2);

    C0117M removeAuthorizations(String str, String str2);

    C0117M saveAuthorization(Authorization authorization);

    Single<Authorization> updateAuthorization(String str, String str2, Status status, String str3);
}
