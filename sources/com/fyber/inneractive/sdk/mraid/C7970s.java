package com.fyber.inneractive.sdk.mraid;

/* renamed from: com.fyber.inneractive.sdk.mraid.s */
public abstract class C7970s {
    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo24817a();

    public String toString() {
        String a = mo24817a();
        String str = "";
        return a != null ? a.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", str) : str;
    }
}
