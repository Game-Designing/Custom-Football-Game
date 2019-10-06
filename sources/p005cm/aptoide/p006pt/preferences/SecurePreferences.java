package p005cm.aptoide.p006pt.preferences;

import android.content.SharedPreferences;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.preferences.secure.SecureCoderDecoder;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.preferences.SecurePreferences */
public class SecurePreferences extends Preferences {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final SecureCoderDecoder decoder;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7519174804522555660L, "cm/aptoide/pt/preferences/SecurePreferences", 13);
        $jacocoData = probes;
        return probes;
    }

    public SecurePreferences(SharedPreferences preferences, SecureCoderDecoder decoder2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(preferences);
        this.decoder = decoder2;
        $jacocoInit[0] = true;
    }

    public C0117M save(String key, boolean value) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = save(key, String.valueOf(value));
        $jacocoInit[1] = true;
        return save;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m489b(String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(value);
        $jacocoInit[12] = true;
        return valueOf;
    }

    public C0120S<Boolean> getBoolean(String key, boolean defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> j = getString(key, String.valueOf(defaultValue)).mo3669j(C4280m.f7876a);
        $jacocoInit[2] = true;
        return j;
    }

    public C0117M save(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = super.save(this.decoder.encrypt(key), this.decoder.encrypt(value));
        $jacocoInit[3] = true;
        return save;
    }

    public C0120S<String> getString(String key, String defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S string = super.getString(this.decoder.encrypt(key), this.decoder.encrypt(defaultValue));
        C4279l lVar = new C4279l(this);
        $jacocoInit[4] = true;
        C0120S<String> j = string.mo3669j(lVar);
        $jacocoInit[5] = true;
        return j;
    }

    /* renamed from: d */
    public /* synthetic */ String mo2312d(String value) {
        boolean[] $jacocoInit = $jacocoInit();
        String decrypt = this.decoder.decrypt(value);
        $jacocoInit[11] = true;
        return decrypt;
    }

    public C0117M save(String key, int value) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = save(key, String.valueOf(value));
        $jacocoInit[6] = true;
        return save;
    }

    /* renamed from: c */
    static /* synthetic */ Integer m490c(String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(value);
        $jacocoInit[10] = true;
        return valueOf;
    }

    public C0120S<Integer> getInt(String key, int defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Integer> j = getString(key, String.valueOf(defaultValue)).mo3669j(C4281n.f7877a);
        $jacocoInit[7] = true;
        return j;
    }

    public C0117M remove(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M remove = super.remove(this.decoder.encrypt(key));
        $jacocoInit[8] = true;
        return remove;
    }

    public Single<Boolean> contains(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> contains = super.contains(this.decoder.encrypt(key));
        $jacocoInit[9] = true;
        return contains;
    }
}
