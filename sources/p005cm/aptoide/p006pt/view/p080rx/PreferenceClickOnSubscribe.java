package p005cm.aptoide.p006pt.view.p080rx;

import android.support.p001v7.preference.Preference;
import android.support.p001v7.preference.Preference.C0813c;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: cm.aptoide.pt.view.rx.PreferenceClickOnSubscribe */
class PreferenceClickOnSubscribe implements C0122a<Preference> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Preference preference;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7228572957727837702L, "cm/aptoide/pt/view/rx/PreferenceClickOnSubscribe", 7);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ Preference access$000(PreferenceClickOnSubscribe x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Preference preference2 = x0.preference;
        $jacocoInit[6] = true;
        return preference2;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14980ia) obj);
        $jacocoInit[5] = true;
    }

    public PreferenceClickOnSubscribe(Preference preference2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.preference = preference2;
        $jacocoInit[0] = true;
    }

    public void call(final C14980ia<? super Preference> subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        C14521b.verifyMainThread();
        $jacocoInit[1] = true;
        C0813c listener = new C0813c(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ PreferenceClickOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(3546569632779686661L, "cm/aptoide/pt/view/rx/PreferenceClickOnSubscribe$1", 4);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public boolean onPreferenceClick(Preference preference) {
                boolean[] $jacocoInit = $jacocoInit();
                if (!subscriber.isUnsubscribed()) {
                    $jacocoInit[1] = true;
                    subscriber.onNext(preference);
                    $jacocoInit[2] = true;
                    return true;
                }
                $jacocoInit[3] = true;
                return true;
            }
        };
        $jacocoInit[2] = true;
        subscriber.add(new C14521b(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ PreferenceClickOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-5253652867861351967L, "cm/aptoide/pt/view/rx/PreferenceClickOnSubscribe$2", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            /* access modifiers changed from: protected */
            public void onUnsubscribe() {
                boolean[] $jacocoInit = $jacocoInit();
                PreferenceClickOnSubscribe.access$000(this.this$0).mo6348a((C0813c) null);
                $jacocoInit[1] = true;
            }
        });
        $jacocoInit[3] = true;
        this.preference.mo6348a(listener);
        $jacocoInit[4] = true;
    }
}
