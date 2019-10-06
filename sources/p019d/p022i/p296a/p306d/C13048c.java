package p019d.p022i.p296a.p306d;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.d.c */
/* compiled from: RadioGroupCheckedChangeOnSubscribe */
final class C13048c implements C0122a<Integer> {

    /* renamed from: a */
    final RadioGroup f40031a;

    public C13048c(RadioGroup view) {
        this.f40031a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Integer> subscriber) {
        C14521b.verifyMainThread();
        OnCheckedChangeListener listener = new C13046a(this, subscriber);
        subscriber.add(new C13047b(this));
        this.f40031a.setOnCheckedChangeListener(listener);
        subscriber.onNext(Integer.valueOf(this.f40031a.getCheckedRadioButtonId()));
    }
}
