package p019d.p273h.p276c.p281e;

import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: d.h.c.e.p */
/* compiled from: ProviderOrder */
public class C12825p {

    /* renamed from: a */
    private ArrayList<String> f39496a = new ArrayList<>();

    /* renamed from: b */
    private String f39497b;

    /* renamed from: c */
    private String f39498c;

    /* renamed from: d */
    private ArrayList<String> f39499d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<String> f39500e = new ArrayList<>();

    /* renamed from: f */
    private String f39501f;

    /* renamed from: g */
    private String f39502g;

    /* renamed from: e */
    public ArrayList<String> mo41528e() {
        return this.f39496a;
    }

    /* renamed from: b */
    public ArrayList<String> mo41522b() {
        return this.f39499d;
    }

    /* renamed from: a */
    public ArrayList<String> mo41520a() {
        return this.f39500e;
    }

    /* renamed from: c */
    public void mo41525c(String rewardedVideoProvider) {
        if (!TextUtils.isEmpty(rewardedVideoProvider)) {
            this.f39496a.add(rewardedVideoProvider);
        }
    }

    /* renamed from: b */
    public void mo41523b(String interstitialProvider) {
        if (!TextUtils.isEmpty(interstitialProvider)) {
            this.f39499d.add(interstitialProvider);
        }
    }

    /* renamed from: a */
    public void mo41521a(String bannerProvider) {
        if (!TextUtils.isEmpty(bannerProvider)) {
            this.f39500e.add(bannerProvider);
        }
    }

    /* renamed from: c */
    public String mo41524c() {
        return this.f39497b;
    }

    /* renamed from: f */
    public void mo41530f(String rvBackFillProvider) {
        this.f39497b = rvBackFillProvider;
    }

    /* renamed from: d */
    public String mo41526d() {
        return this.f39498c;
    }

    /* renamed from: g */
    public void mo41531g(String rvPremiumProvider) {
        this.f39498c = rvPremiumProvider;
    }

    /* renamed from: d */
    public void mo41527d(String isBackFillProvider) {
        this.f39501f = isBackFillProvider;
    }

    /* renamed from: e */
    public void mo41529e(String isPremiumProvider) {
        this.f39502g = isPremiumProvider;
    }
}
