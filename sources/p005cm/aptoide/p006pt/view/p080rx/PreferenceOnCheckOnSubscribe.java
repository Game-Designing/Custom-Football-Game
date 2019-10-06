package p005cm.aptoide.p006pt.view.p080rx;

import android.support.p001v7.preference.CheckBoxPreference;
import android.support.p001v7.preference.Preference;
import android.support.p001v7.preference.Preference.C0813c;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: cm.aptoide.pt.view.rx.PreferenceOnCheckOnSubscribe */
class PreferenceOnCheckOnSubscribe implements C0122a<Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final CheckBoxPreference preference;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-164500261386331585L, "cm/aptoide/pt/view/rx/PreferenceOnCheckOnSubscribe", 7);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ CheckBoxPreference access$000(PreferenceOnCheckOnSubscribe x0) {
        boolean[] $jacocoInit = $jacocoInit();
        CheckBoxPreference checkBoxPreference = x0.preference;
        $jacocoInit[6] = true;
        return checkBoxPreference;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14980ia) obj);
        $jacocoInit[5] = true;
    }

    public PreferenceOnCheckOnSubscribe(CheckBoxPreference preference2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.preference = preference2;
        $jacocoInit[0] = true;
    }

    public void call(final C14980ia<? super Boolean> subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        C14521b.verifyMainThread();
        $jacocoInit[1] = true;
        C0813c listener = new C0813c(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ PreferenceOnCheckOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-5961125559688642999L, "cm/aptoide/pt/view/rx/PreferenceOnCheckOnSubscribe$1", 4);
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
                    subscriber.onNext(Boolean.valueOf(((CheckBoxPreference) preference).mo6295R()));
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
            final /* synthetic */ PreferenceOnCheckOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-105369117087135858L, "cm/aptoide/pt/view/rx/PreferenceOnCheckOnSubscribe$2", 2);
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
                PreferenceOnCheckOnSubscribe.access$000(this.this$0).mo6348a((C0813c) null);
                $jacocoInit[1] = true;
            }
        });
        $jacocoInit[3] = true;
        this.preference.mo6348a(listener);
        $jacocoInit[4] = true;
    }
}
