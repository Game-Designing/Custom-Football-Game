package p005cm.aptoide.p006pt.account.view.user;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import java.util.Calendar;

/* renamed from: cm.aptoide.pt.account.view.user.a */
/* compiled from: lambda */
public final /* synthetic */ class C1581a implements OnDateSetListener {

    /* renamed from: a */
    private final /* synthetic */ ManageUserFragment f4522a;

    /* renamed from: b */
    private final /* synthetic */ Calendar f4523b;

    public /* synthetic */ C1581a(ManageUserFragment manageUserFragment, Calendar calendar) {
        this.f4522a = manageUserFragment;
        this.f4523b = calendar;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.f4522a.mo9879a(this.f4523b, datePicker, i, i2, i3);
    }
}
