package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

@zzard
public final class zzacp {

    /* renamed from: a */
    private final Collection<zzacj<?>> f23885a = new ArrayList();

    /* renamed from: b */
    private final Collection<zzacj<String>> f23886b = new ArrayList();

    /* renamed from: c */
    private final Collection<zzacj<String>> f23887c = new ArrayList();

    /* renamed from: a */
    public final void mo29595a(zzacj zzacj) {
        this.f23885a.add(zzacj);
    }

    /* renamed from: b */
    public final void mo29597b(zzacj<String> zzacj) {
        this.f23886b.add(zzacj);
    }

    /* renamed from: c */
    public final void mo29598c(zzacj<String> zzacj) {
        this.f23887c.add(zzacj);
    }

    /* renamed from: a */
    public final void mo29594a(Editor editor, int i, JSONObject jSONObject) {
        for (zzacj zzacj : this.f23885a) {
            if (zzacj.mo29591b() == 1) {
                zzacj.mo29056a(editor, zzacj.mo29055a(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
            return;
        }
        zzbad.m26355b("Flag Json is null.");
    }

    /* renamed from: a */
    public final List<String> mo29593a() {
        ArrayList arrayList = new ArrayList();
        for (zzacj a : this.f23886b) {
            String str = (String) zzyt.m31536e().mo29599a(a);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public final List<String> mo29596b() {
        List<String> a = mo29593a();
        for (zzacj a2 : this.f23887c) {
            String str = (String) zzyt.m31536e().mo29599a(a2);
            if (str != null) {
                a.add(str);
            }
        }
        return a;
    }
}
