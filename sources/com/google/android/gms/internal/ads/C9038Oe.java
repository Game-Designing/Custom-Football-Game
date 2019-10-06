package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* renamed from: com.google.android.gms.internal.ads.Oe */
final class C9038Oe implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f21535a;

    /* renamed from: b */
    private final /* synthetic */ EditText f21536b;

    C9038Oe(JsPromptResult jsPromptResult, EditText editText) {
        this.f21535a = jsPromptResult;
        this.f21536b = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f21535a.confirm(this.f21536b.getText().toString());
    }
}
