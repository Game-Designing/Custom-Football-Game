package p024io.fabric.sdk.android.services.network;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* renamed from: io.fabric.sdk.android.services.network.a */
/* compiled from: CertificateChainCleaner */
final class C13965a {
    /* renamed from: a */
    public static X509Certificate[] m44426a(X509Certificate[] chain, C13975k systemKeyStore) throws CertificateException {
        LinkedList<X509Certificate> cleanChain = new LinkedList<>();
        boolean trustedChain = false;
        if (systemKeyStore.mo43475b(chain[0])) {
            trustedChain = true;
        }
        cleanChain.add(chain[0]);
        int i = 1;
        while (i < chain.length) {
            if (systemKeyStore.mo43475b(chain[i])) {
                trustedChain = true;
            }
            if (!m44425a(chain[i], chain[i - 1])) {
                break;
            }
            cleanChain.add(chain[i]);
            i++;
        }
        X509Certificate trustRoot = systemKeyStore.mo43474a(chain[i - 1]);
        if (trustRoot != null) {
            cleanChain.add(trustRoot);
            trustedChain = true;
        }
        if (trustedChain) {
            return (X509Certificate[]) cleanChain.toArray(new X509Certificate[cleanChain.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    /* renamed from: a */
    private static boolean m44425a(X509Certificate parent, X509Certificate child) {
        if (!parent.getSubjectX500Principal().equals(child.getIssuerX500Principal())) {
            return false;
        }
        try {
            child.verify(parent.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }
}
