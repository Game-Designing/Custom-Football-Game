package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.p000v4.app.C0478k;
import android.support.p000v4.app.C0486t;
import com.google.android.gms.common.internal.Preconditions;

public class SupportErrorDialogFragment extends C0478k {

    /* renamed from: a */
    private OnCancelListener f19539a = null;
    private Dialog mDialog = null;

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.mDialog == null) {
            setShowsDialog(false);
        }
        return this.mDialog;
    }

    public void onCancel(DialogInterface dialogInterface) {
        OnCancelListener onCancelListener = this.f19539a;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    /* renamed from: a */
    public static SupportErrorDialogFragment m21106a(Dialog dialog, OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Preconditions.m21858a(dialog, (Object) "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.mDialog = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f19539a = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    public void show(C0486t tVar, String str) {
        super.show(tVar, str);
    }
}
