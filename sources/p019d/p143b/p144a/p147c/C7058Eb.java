package p019d.p143b.p144a.p147c;

import android.net.Uri;
import android.webkit.URLUtil;
import java.util.List;
import p019d.p143b.p144a.p145a.C6925a;
import p019d.p143b.p144a.p145a.C6930f;
import p019d.p143b.p144a.p145a.C6933i;
import p019d.p143b.p144a.p145a.C6934j;
import p019d.p143b.p144a.p145a.C6942r;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Eb */
class C7058Eb extends C7232yb {

    /* renamed from: k */
    private final C6925a f13194k;

    public C7058Eb(C6925a aVar, C7254d dVar, C7142c cVar) {
        super("TaskCacheVastAd", aVar, dVar, cVar);
        this.f13194k = aVar;
    }

    /* renamed from: e */
    private void m14667e() {
        String str;
        String str2;
        C7262l lVar;
        String b;
        if (this.f13194k.mo22398a(this.f13625b)) {
            C6930f ra = this.f13194k.mo22411ra();
            if (ra != null) {
                C6933i b2 = ra.mo22432b();
                if (b2 != null) {
                    try {
                        Uri b3 = b2.mo22451b();
                        String uri = b3 != null ? b3.toString() : "";
                        String c = b2.mo22452c();
                        if (!URLUtil.isValidUrl(uri)) {
                            if (!C7269s.m15819a(c)) {
                                this.f13626c.mo22913a(this.f13624a, "Companion ad does not have any resources attached. Skipping...");
                                return;
                            }
                        }
                        String str3 = "...";
                        if (b2.mo22448a() == C6934j.STATIC) {
                            C7262l lVar2 = this.f13626c;
                            String str4 = this.f13624a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Caching static companion ad at ");
                            sb.append(uri);
                            sb.append(str3);
                            lVar2.mo22918c(str4, sb.toString());
                            List sa = this.f13194k.mo22412sa();
                            Uri b4 = mo23388b(uri, sa, sa != null && !sa.isEmpty());
                            if (b4 != null) {
                                b2.mo22449a(b4);
                                return;
                            } else {
                                this.f13626c.mo22916b(this.f13624a, "Failed to cache static companion ad");
                                return;
                            }
                        } else if (b2.mo22448a() == C6934j.HTML) {
                            if (C7269s.m15819a(uri)) {
                                C7262l lVar3 = this.f13626c;
                                String str5 = this.f13624a;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Begin caching HTML companion ad. Fetching from ");
                                sb2.append(uri);
                                sb2.append(str3);
                                lVar3.mo22918c(str5, sb2.toString());
                                String c2 = mo23391c(uri);
                                if (C7269s.m15819a(c2)) {
                                    this.f13626c.mo22918c(this.f13624a, "HTML fetched. Caching HTML now...");
                                    b = mo23389b(c2, this.f13194k.mo22412sa());
                                } else {
                                    C7262l lVar4 = this.f13626c;
                                    String str6 = this.f13624a;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Unable to load companion ad resources from ");
                                    sb3.append(uri);
                                    lVar4.mo22916b(str6, sb3.toString());
                                    return;
                                }
                            } else {
                                C7262l lVar5 = this.f13626c;
                                String str7 = this.f13624a;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Caching provided HTML for companion ad. No fetch required. HTML: ");
                                sb4.append(c);
                                lVar5.mo22918c(str7, sb4.toString());
                                b = mo23389b(c, this.f13194k.mo22412sa());
                            }
                            b2.mo22450a(b);
                            return;
                        } else if (b2.mo22448a() == C6934j.IFRAME) {
                            this.f13626c.mo22918c(this.f13624a, "Skip caching of iFrame resource...");
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        this.f13626c.mo22917b(this.f13624a, "Failed to cache companion ad", th);
                        return;
                    }
                } else {
                    this.f13626c.mo22916b(this.f13624a, "Failed to retrieve non-video resources from companion ad. Skipping...");
                    return;
                }
            } else {
                lVar = this.f13626c;
                str2 = this.f13624a;
                str = "No companion ad provided. Skipping...";
            }
        } else {
            lVar = this.f13626c;
            str2 = this.f13624a;
            str = "Companion ad caching disabled. Skipping...";
        }
        lVar.mo22918c(str2, str);
    }

    /* renamed from: f */
    private void m14668f() {
        if (!this.f13194k.mo22400b((C7267q) this.f13625b)) {
            this.f13626c.mo22918c(this.f13624a, "Video caching disabled. Skipping...");
        } else if (this.f13194k.mo22409oa() != null) {
            C6942r qa = this.f13194k.mo22410qa();
            if (qa != null) {
                Uri b = qa.mo22478b();
                if (b != null) {
                    List sa = this.f13194k.mo22412sa();
                    Uri a = mo23384a(b.toString(), sa, sa != null && !sa.isEmpty());
                    if (a != null) {
                        C7262l lVar = this.f13626c;
                        String str = this.f13624a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Video file successfully cached into: ");
                        sb.append(a);
                        lVar.mo22918c(str, sb.toString());
                        qa.mo22477a(a);
                        return;
                    }
                    C7262l lVar2 = this.f13626c;
                    String str2 = this.f13624a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to cache video file: ");
                    sb2.append(qa);
                    lVar2.mo22916b(str2, sb2.toString());
                }
            }
        }
    }

    /* renamed from: g */
    private void m14669g() {
        String str;
        String str2;
        String str3;
        C7262l lVar;
        if (this.f13194k.mo22417va() != null) {
            C7262l lVar2 = this.f13626c;
            String str4 = this.f13624a;
            StringBuilder sb = new StringBuilder();
            sb.append("Begin caching HTML template. Fetching from ");
            sb.append(this.f13194k.mo22417va());
            sb.append("...");
            lVar2.mo22918c(str4, sb.toString());
            str = mo23385a(this.f13194k.mo22417va().toString(), this.f13194k.mo23400F());
        } else {
            str = this.f13194k.mo22415ua();
        }
        if (C7269s.m15819a(str)) {
            C6925a aVar = this.f13194k;
            aVar.mo22401c(mo23389b(str, aVar.mo23400F()));
            lVar = this.f13626c;
            str3 = this.f13624a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Finish caching HTML template ");
            sb2.append(this.f13194k.mo22415ua());
            sb2.append(" for ad #");
            sb2.append(this.f13194k.mo22758b());
            str2 = sb2.toString();
        } else {
            lVar = this.f13626c;
            str3 = this.f13624a;
            str2 = "Unable to load HTML template";
        }
        lVar.mo22918c(str3, str2);
    }

    public void run() {
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Begin caching for VAST ad #");
        sb.append(this.f13194k.mo22758b());
        sb.append("...");
        lVar.mo22918c(str, sb.toString());
        mo23390b();
        m14667e();
        m14668f();
        m14669g();
        mo23393c();
        C7262l lVar2 = this.f13626c;
        String str2 = this.f13624a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Finished caching VAST ad #");
        sb2.append(this.f13194k.mo22758b());
        lVar2.mo22918c(str2, sb2.toString());
        long currentTimeMillis = System.currentTimeMillis() - this.f13194k.mo22404f();
        C7086Lb.m14819a(this.f13194k, this.f13625b);
        C7086Lb.m14818a(currentTimeMillis, (C7071Hc) this.f13194k, this.f13625b);
        mo23386a((C7071Hc) this.f13194k);
    }
}
