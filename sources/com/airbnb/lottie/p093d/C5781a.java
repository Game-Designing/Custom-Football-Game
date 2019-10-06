package com.airbnb.lottie.p093d;

import p005cm.aptoide.p006pt.utils.MultiDexHelper;

/* renamed from: com.airbnb.lottie.d.a */
/* compiled from: FileExtension */
public enum C5781a {
    Json(".json"),
    Zip(MultiDexHelper.EXTRACTED_SUFFIX);
    

    /* renamed from: d */
    public final String f10072d;

    private C5781a(String extension) {
        this.f10072d = extension;
    }

    /* renamed from: e */
    public String mo18134e() {
        StringBuilder sb = new StringBuilder();
        sb.append(".temp");
        sb.append(this.f10072d);
        return sb.toString();
    }

    public String toString() {
        return this.f10072d;
    }
}
