package android.support.p001v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: android.support.v7.widget.B */
/* compiled from: AppCompatSpinner */
class C0915B implements OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C0897A f2919a;

    /* renamed from: b */
    final /* synthetic */ C0899b f2920b;

    C0915B(C0899b this$1, C0897A a) {
        this.f2920b = this$1;
        this.f2919a = a;
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        C0897A.this.setSelection(position);
        if (C0897A.this.getOnItemClickListener() != null) {
            C0899b bVar = this.f2920b;
            C0897A.this.performItemClick(v, position, bVar.f2809L.getItemId(position));
        }
        this.f2920b.dismiss();
    }
}
