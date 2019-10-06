package android.support.p001v7.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: android.support.v7.preference.d */
/* compiled from: DropDownPreference */
class C0820d implements OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ DropDownPreference f2493a;

    C0820d(DropDownPreference this$0) {
        this.f2493a = this$0;
    }

    public void onItemSelected(AdapterView<?> adapterView, View v, int position, long id) {
        if (position >= 0) {
            String value = this.f2493a.mo6317Z()[position].toString();
            if (!value.equals(this.f2493a.mo6319aa()) && this.f2493a.mo6353a((Object) value)) {
                this.f2493a.mo6321e(value);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
