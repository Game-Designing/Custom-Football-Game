package p005cm.aptoide.p006pt.preferences;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.preferences.LocalPersistenceAdultContent */
public class LocalPersistenceAdultContent {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ADULT_CONTENT_PIN_PREFERENCES_KEY = "Maturepin";
    private static final String ADULT_CONTENT_PREFERENCES_KEY = "matureChkBox";
    private final Preferences preferences;
    private final SecurePreferences securePreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2167640586805684859L, "cm/aptoide/pt/preferences/LocalPersistenceAdultContent", 24);
        $jacocoData = probes;
        return probes;
    }

    public LocalPersistenceAdultContent(Preferences preferences2, SecurePreferences securePreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.preferences = preferences2;
        this.securePreferences = securePreferences2;
        $jacocoInit[0] = true;
    }

    public C0120S<Boolean> pinRequired() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1);
        C4268a aVar = C4268a.f7848a;
        $jacocoInit[1] = true;
        C0120S<Boolean> j = s.mo3669j(aVar);
        $jacocoInit[2] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8653a(Integer value) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (value.intValue() != -1) {
            $jacocoInit[21] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[22] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[23] = true;
        return valueOf;
    }

    public C0117M requirePin(int pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = this.securePreferences.save(ADULT_CONTENT_PIN_PREFERENCES_KEY, pin);
        $jacocoInit[3] = true;
        return save;
    }

    public C0117M removePin(int pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1);
        $jacocoInit[4] = true;
        C0120S d = s.mo3647d();
        $jacocoInit[5] = true;
        Single n = d.mo3678n();
        C4269b bVar = new C4269b(this, pin);
        $jacocoInit[6] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) bVar);
        $jacocoInit[7] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo15375b(int pin, Integer savedPin) {
        boolean[] $jacocoInit = $jacocoInit();
        if (savedPin.equals(Integer.valueOf(pin))) {
            $jacocoInit[18] = true;
            C0117M remove = this.securePreferences.remove(ADULT_CONTENT_PIN_PREFERENCES_KEY);
            $jacocoInit[19] = true;
            return remove;
        }
        C0117M b = C0117M.m591b((Throwable) new SecurityException("Pin does not match."));
        $jacocoInit[20] = true;
        return b;
    }

    public C0117M enable() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = this.preferences.save(ADULT_CONTENT_PREFERENCES_KEY, true);
        $jacocoInit[8] = true;
        return save;
    }

    public C0117M disable() {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = this.preferences.save(ADULT_CONTENT_PREFERENCES_KEY, false);
        $jacocoInit[9] = true;
        return save;
    }

    public C0120S<Boolean> enabled() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> s = this.preferences.getBoolean(ADULT_CONTENT_PREFERENCES_KEY, false);
        $jacocoInit[10] = true;
        return s;
    }

    public C0117M enable(int pin) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1);
        $jacocoInit[11] = true;
        C0120S d = s.mo3647d();
        $jacocoInit[12] = true;
        Single n = d.mo3678n();
        C4270c cVar = new C4270c(this, pin);
        $jacocoInit[13] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) cVar);
        $jacocoInit[14] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15374a(int pin, Integer savedPin) {
        boolean[] $jacocoInit = $jacocoInit();
        if (savedPin.equals(Integer.valueOf(pin))) {
            $jacocoInit[15] = true;
            C0117M enable = enable();
            $jacocoInit[16] = true;
            return enable;
        }
        C0117M b = C0117M.m591b((Throwable) new SecurityException("Pin does not match."));
        $jacocoInit[17] = true;
        return b;
    }
}
