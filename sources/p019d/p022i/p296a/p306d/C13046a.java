package p019d.p022i.p296a.p306d;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import p026rx.C14980ia;

/* renamed from: d.i.a.d.a */
/* compiled from: RadioGroupCheckedChangeOnSubscribe */
class C13046a implements OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40028a;

    /* renamed from: b */
    final /* synthetic */ C13048c f40029b;

    C13046a(C13048c this$0, C14980ia iaVar) {
        this.f40029b = this$0;
        this.f40028a = iaVar;
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (!this.f40028a.isUnsubscribed()) {
            this.f40028a.onNext(Integer.valueOf(checkedId));
        }
    }
}
