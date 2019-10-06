package p005cm.aptoide.p006pt.preferences;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14978f;

/* renamed from: cm.aptoide.pt.preferences.Preferences */
public class Preferences {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final SharedPreferences preferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9119566693245969192L, "cm/aptoide/pt/preferences/Preferences", 29);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ SharedPreferences access$000(Preferences x0) {
        boolean[] $jacocoInit = $jacocoInit();
        SharedPreferences sharedPreferences = x0.preferences;
        $jacocoInit[28] = true;
        return sharedPreferences;
    }

    public Preferences(SharedPreferences preferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.preferences = preferences2;
        $jacocoInit[0] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2300a(String key, boolean value) {
        boolean[] $jacocoInit = $jacocoInit();
        Editor edit = this.preferences.edit();
        $jacocoInit[25] = true;
        Editor putBoolean = edit.putBoolean(key, value);
        $jacocoInit[26] = true;
        putBoolean.commit();
        $jacocoInit[27] = true;
    }

    public C0117M save(String key, boolean value) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4275h(this, key, value));
        $jacocoInit[1] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo2294a(String key, boolean defaultValue, Void changed) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.preferences.getBoolean(key, defaultValue));
        $jacocoInit[24] = true;
        return valueOf;
    }

    public C0120S<Boolean> getBoolean(String key, boolean defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S j = change(key).mo3669j(new C4277j(this, key, defaultValue));
        SharedPreferences sharedPreferences = this.preferences;
        $jacocoInit[2] = true;
        C0120S<Boolean> e = j.mo3656e(Boolean.valueOf(sharedPreferences.getBoolean(key, defaultValue)));
        $jacocoInit[3] = true;
        return e;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2299a(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        Editor edit = this.preferences.edit();
        $jacocoInit[21] = true;
        Editor putString = edit.putString(key, value);
        $jacocoInit[22] = true;
        putString.commit();
        $jacocoInit[23] = true;
    }

    public C0117M save(String key, String value) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4278k(this, key, value));
        $jacocoInit[4] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ String mo2296a(String key, String defaultValue, Void changed) {
        boolean[] $jacocoInit = $jacocoInit();
        String string = this.preferences.getString(key, defaultValue);
        $jacocoInit[20] = true;
        return string;
    }

    public C0120S<String> getString(String key, String defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S j = change(key).mo3669j(new C4274g(this, key, defaultValue));
        SharedPreferences sharedPreferences = this.preferences;
        $jacocoInit[5] = true;
        C0120S<String> e = j.mo3656e(sharedPreferences.getString(key, defaultValue));
        $jacocoInit[6] = true;
        return e;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2298a(String key, int value) {
        boolean[] $jacocoInit = $jacocoInit();
        Editor edit = this.preferences.edit();
        $jacocoInit[17] = true;
        Editor putInt = edit.putInt(key, value);
        $jacocoInit[18] = true;
        putInt.commit();
        $jacocoInit[19] = true;
    }

    public C0117M save(String key, int value) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4276i(this, key, value));
        $jacocoInit[7] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ Integer mo2295a(String key, int defaultValue, Void changed) {
        boolean[] $jacocoInit = $jacocoInit();
        Integer valueOf = Integer.valueOf(this.preferences.getInt(key, defaultValue));
        $jacocoInit[16] = true;
        return valueOf;
    }

    public C0120S<Integer> getInt(String key, int defaultValue) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S j = change(key).mo3669j(new C4273f(this, key, defaultValue));
        SharedPreferences sharedPreferences = this.preferences;
        $jacocoInit[8] = true;
        C0120S<Integer> e = j.mo3656e(Integer.valueOf(sharedPreferences.getInt(key, defaultValue)));
        $jacocoInit[9] = true;
        return e;
    }

    private C0120S<Void> change(final String key) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C0120S.m634a((C0122a<T>) new C0122a<Void>(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ Preferences this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(8616758999760319741L, "cm/aptoide/pt/preferences/Preferences$1", 6);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public /* bridge */ /* synthetic */ void call(Object obj) {
                boolean[] $jacocoInit = $jacocoInit();
                call((C14980ia) obj);
                $jacocoInit[4] = true;
            }

            public void call(final C14980ia<? super Void> subscriber) {
                boolean[] $jacocoInit = $jacocoInit();
                OnSharedPreferenceChangeListener listener = new OnSharedPreferenceChangeListener(this) {
                    private static transient /* synthetic */ boolean[] $jacocoData;
                    final /* synthetic */ C00611 this$1;

                    private static /* synthetic */ boolean[] $jacocoInit() {
                        boolean[] zArr = $jacocoData;
                        if (zArr != null) {
                            return zArr;
                        }
                        boolean[] probes = Offline.getProbes(2882058805824181643L, "cm/aptoide/pt/preferences/Preferences$1$1", 6);
                        $jacocoData = probes;
                        return probes;
                    }

                    {
                        boolean[] $jacocoInit = $jacocoInit();
                        this.this$1 = this$1;
                        $jacocoInit[0] = true;
                    }

                    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String changedKey) {
                        boolean[] $jacocoInit = $jacocoInit();
                        if (subscriber.isUnsubscribed()) {
                            $jacocoInit[1] = true;
                        } else if (!changedKey.equals(key)) {
                            $jacocoInit[2] = true;
                        } else {
                            $jacocoInit[3] = true;
                            subscriber.onNext(null);
                            $jacocoInit[4] = true;
                        }
                        $jacocoInit[5] = true;
                    }
                };
                $jacocoInit[1] = true;
                subscriber.add(C14978f.m46781a(new C4271d(this, listener)));
                $jacocoInit[2] = true;
                Preferences.access$000(this.this$0).registerOnSharedPreferenceChangeListener(listener);
                $jacocoInit[3] = true;
            }

            /* renamed from: a */
            public /* synthetic */ void mo2309a(OnSharedPreferenceChangeListener listener) {
                boolean[] $jacocoInit = $jacocoInit();
                Preferences.access$000(this.this$0).unregisterOnSharedPreferenceChangeListener(listener);
                $jacocoInit[5] = true;
            }
        });
        $jacocoInit[10] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2297a(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Editor edit = this.preferences.edit();
        $jacocoInit[13] = true;
        Editor remove = edit.remove(key);
        $jacocoInit[14] = true;
        remove.commit();
        $jacocoInit[15] = true;
    }

    public C0117M remove(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C4272e(this, key));
        $jacocoInit[11] = true;
        return c;
    }

    public Single<Boolean> contains(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> a = Single.m734a(Boolean.valueOf(this.preferences.contains(key)));
        $jacocoInit[12] = true;
        return a;
    }
}
