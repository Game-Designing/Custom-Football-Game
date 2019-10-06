package android.support.p001v7.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.Fragment;
import android.support.p001v7.app.C0774m.C0775a;
import android.support.p001v7.preference.DialogPreference.C0801a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: android.support.v7.preference.o */
/* compiled from: PreferenceDialogFragmentCompat */
public abstract class C0831o extends C0478k implements OnClickListener {

    /* renamed from: a */
    private DialogPreference f2506a;

    /* renamed from: b */
    private CharSequence f2507b;

    /* renamed from: c */
    private CharSequence f2508c;

    /* renamed from: d */
    private CharSequence f2509d;

    /* renamed from: e */
    private CharSequence f2510e;

    /* renamed from: f */
    private int f2511f;

    /* renamed from: g */
    private BitmapDrawable f2512g;

    /* renamed from: h */
    private int f2513h;

    /* renamed from: a */
    public abstract void mo6427a(boolean z);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment rawFragment = getTargetFragment();
        if (rawFragment instanceof C0801a) {
            C0801a fragment = (C0801a) rawFragment;
            String key = getArguments().getString(Notification.KEY);
            if (savedInstanceState == null) {
                this.f2506a = (DialogPreference) fragment.findPreference(key);
                this.f2507b = this.f2506a.mo6298U();
                this.f2508c = this.f2506a.mo6300W();
                this.f2509d = this.f2506a.mo6299V();
                this.f2510e = this.f2506a.mo6297T();
                this.f2511f = this.f2506a.mo6296S();
                Drawable icon = this.f2506a.mo6295R();
                if (icon == null || (icon instanceof BitmapDrawable)) {
                    this.f2512g = (BitmapDrawable) icon;
                    return;
                }
                Bitmap bitmap = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                icon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                icon.draw(canvas);
                this.f2512g = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            this.f2507b = savedInstanceState.getCharSequence("PreferenceDialogFragment.title");
            this.f2508c = savedInstanceState.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f2509d = savedInstanceState.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f2510e = savedInstanceState.getCharSequence("PreferenceDialogFragment.message");
            this.f2511f = savedInstanceState.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap2 = (Bitmap) savedInstanceState.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap2 != null) {
                this.f2512g = new BitmapDrawable(getResources(), bitmap2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("PreferenceDialogFragment.title", this.f2507b);
        outState.putCharSequence("PreferenceDialogFragment.positiveText", this.f2508c);
        outState.putCharSequence("PreferenceDialogFragment.negativeText", this.f2509d);
        outState.putCharSequence("PreferenceDialogFragment.message", this.f2510e);
        outState.putInt("PreferenceDialogFragment.layout", this.f2511f);
        BitmapDrawable bitmapDrawable = this.f2512g;
        if (bitmapDrawable != null) {
            outState.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        this.f2513h = -2;
        C0775a aVar = new C0775a(context);
        aVar.mo6236b(this.f2507b);
        aVar.mo6223a((Drawable) this.f2512g);
        aVar.mo6240c(this.f2508c, (OnClickListener) this);
        C0775a builder = aVar.mo6227a(this.f2509d, (OnClickListener) this);
        View contentView = mo6445a(context);
        if (contentView != null) {
            mo6426a(contentView);
            builder.mo6235b(contentView);
        } else {
            builder.mo6226a(this.f2510e);
        }
        mo6432a(builder);
        Dialog dialog = builder.mo6231a();
        if (mo6428c()) {
            m3939a(dialog);
        }
        return dialog;
    }

    /* renamed from: b */
    public DialogPreference mo6446b() {
        if (this.f2506a == null) {
            this.f2506a = (DialogPreference) ((C0801a) getTargetFragment()).findPreference(getArguments().getString(Notification.KEY));
        }
        return this.f2506a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6432a(C0775a builder) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo6428c() {
        return false;
    }

    /* renamed from: a */
    private void m3939a(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo6445a(Context context) {
        int resId = this.f2511f;
        if (resId == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(resId, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6426a(View view) {
        View dialogMessageView = view.findViewById(16908299);
        if (dialogMessageView != null) {
            CharSequence message = this.f2510e;
            int newVisibility = 8;
            if (!TextUtils.isEmpty(message)) {
                if (dialogMessageView instanceof TextView) {
                    ((TextView) dialogMessageView).setText(message);
                }
                newVisibility = 0;
            }
            if (dialogMessageView.getVisibility() != newVisibility) {
                dialogMessageView.setVisibility(newVisibility);
            }
        }
    }

    public void onClick(DialogInterface dialog, int which) {
        this.f2513h = which;
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mo6427a(this.f2513h == -1);
    }
}
