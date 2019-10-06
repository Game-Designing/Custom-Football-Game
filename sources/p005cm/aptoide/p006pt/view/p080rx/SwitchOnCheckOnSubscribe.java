package p005cm.aptoide.p006pt.view.p080rx;

import android.support.p001v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: cm.aptoide.pt.view.rx.SwitchOnCheckOnSubscribe */
class SwitchOnCheckOnSubscribe implements C0122a<Boolean> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final SwitchCompat switchCompat;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9041058776572929173L, "cm/aptoide/pt/view/rx/SwitchOnCheckOnSubscribe", 7);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ SwitchCompat access$000(SwitchOnCheckOnSubscribe x0) {
        boolean[] $jacocoInit = $jacocoInit();
        SwitchCompat switchCompat2 = x0.switchCompat;
        $jacocoInit[6] = true;
        return switchCompat2;
    }

    public /* bridge */ /* synthetic */ void call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        call((C14980ia) obj);
        $jacocoInit[5] = true;
    }

    public SwitchOnCheckOnSubscribe(SwitchCompat switchCompat2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.switchCompat = switchCompat2;
        $jacocoInit[0] = true;
    }

    public void call(final C14980ia<? super Boolean> subscriber) {
        boolean[] $jacocoInit = $jacocoInit();
        C14521b.verifyMainThread();
        $jacocoInit[1] = true;
        OnCheckedChangeListener listener = new OnCheckedChangeListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SwitchOnCheckOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-9142146570204694635L, "cm/aptoide/pt/view/rx/SwitchOnCheckOnSubscribe$1", 5);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean[] $jacocoInit = $jacocoInit();
                if (subscriber.isUnsubscribed()) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    subscriber.onNext(Boolean.valueOf(isChecked));
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
            }
        };
        $jacocoInit[2] = true;
        subscriber.add(new C14521b(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SwitchOnCheckOnSubscribe this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(4750795335690040151L, "cm/aptoide/pt/view/rx/SwitchOnCheckOnSubscribe$2", 2);
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
                SwitchOnCheckOnSubscribe.access$000(this.this$0).setOnCheckedChangeListener(null);
                $jacocoInit[1] = true;
            }
        });
        $jacocoInit[3] = true;
        this.switchCompat.setOnCheckedChangeListener(listener);
        $jacocoInit[4] = true;
    }
}
