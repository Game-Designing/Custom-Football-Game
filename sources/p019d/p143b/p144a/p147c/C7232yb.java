package p019d.p143b.p144a.p147c;

import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.yb */
abstract class C7232yb extends C7184mb {

    /* renamed from: f */
    private final C7234z f14048f;

    /* renamed from: g */
    private C7254d f14049g;

    /* renamed from: h */
    private final C7068H f14050h;

    /* renamed from: i */
    private final Collection<Character> f14051i;

    /* renamed from: j */
    private final C7174k f14052j;

    C7232yb(String str, C7234z zVar, C7254d dVar, C7142c cVar) {
        super(str, cVar);
        if (zVar != null) {
            this.f14048f = zVar;
            this.f14049g = dVar;
            this.f14050h = cVar.mo23072q();
            this.f14051i = m15626d();
            this.f14052j = new C7174k();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    /* renamed from: a */
    private Uri m15624a(Uri uri, String str) {
        String str2;
        C7262l lVar;
        StringBuilder sb;
        String str3;
        if (uri != null) {
            String uri2 = uri.toString();
            if (C7269s.m15819a(uri2)) {
                C7262l lVar2 = this.f13626c;
                String str4 = this.f13624a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Caching ");
                sb2.append(str);
                sb2.append(" image...");
                lVar2.mo22918c(str4, sb2.toString());
                return mo23387b(uri2);
            }
            lVar = this.f13626c;
            str3 = this.f13624a;
            sb = new StringBuilder();
            sb.append("Failed to cache ");
            sb.append(str);
            str2 = " image";
        } else {
            lVar = this.f13626c;
            str3 = this.f13624a;
            sb = new StringBuilder();
            sb.append("No ");
            sb.append(str);
            str2 = " image to cache";
        }
        sb.append(str2);
        lVar.mo22918c(str3, sb.toString());
        return null;
    }

    /* renamed from: a */
    private String m15625a(String str, String str2) {
        StringBuilder sb;
        String replace = str2.replace("/", "_");
        String G = this.f14048f.mo23401G();
        if (C7269s.m15819a(G)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(G);
            sb2.append(replace);
            replace = sb2.toString();
        }
        File a = this.f14050h.mo22826a(replace, this.f13625b.mo23068m(), true);
        if (a == null) {
            return null;
        }
        String str3 = "file://";
        if (a.exists()) {
            this.f14052j.mo23185b(a.length());
            sb = new StringBuilder();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(str2);
            if (!this.f14050h.mo22831a(a, sb3.toString(), Arrays.asList(new String[]{str}), this.f14052j)) {
                return null;
            }
            sb = new StringBuilder();
        }
        sb.append(str3);
        sb.append(a.getAbsolutePath());
        return sb.toString();
    }

    /* renamed from: d */
    private Collection<Character> m15626d() {
        HashSet hashSet = new HashSet();
        for (char valueOf : ((String) this.f13625b.mo23039a(C7196pb.f13753Sa)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add(Character.valueOf('\"'));
        return hashSet;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Uri mo23383a(String str) {
        return mo23384a(str, this.f14048f.mo23400F(), true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Uri mo23384a(String str, List<String> list, boolean z) {
        C7262l lVar;
        String str2;
        String str3;
        try {
            if (C7269s.m15819a(str)) {
                C7262l lVar2 = this.f13626c;
                String str4 = this.f13624a;
                StringBuilder sb = new StringBuilder();
                sb.append("Caching video ");
                sb.append(str);
                sb.append("...");
                lVar2.mo22918c(str4, sb.toString());
                String a = this.f14050h.mo22827a(this.f13627d, str, this.f14048f.mo23401G(), list, z, this.f14052j);
                if (C7269s.m15819a(a)) {
                    File a2 = this.f13625b.mo23072q().mo22826a(a, this.f13627d, false);
                    if (a2 != null) {
                        Uri fromFile = Uri.fromFile(a2);
                        if (fromFile != null) {
                            C7262l lVar3 = this.f13626c;
                            String str5 = this.f13624a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Finish caching video for ad #");
                            sb2.append(this.f14048f.mo22758b());
                            sb2.append(". Updating ad with cachedVideoFilename = ");
                            sb2.append(a);
                            lVar3.mo22918c(str5, sb2.toString());
                            return fromFile;
                        }
                        lVar = this.f13626c;
                        str2 = this.f13624a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Unable to create URI from cached video file = ");
                        sb3.append(a2);
                        str3 = sb3.toString();
                    } else {
                        C7262l lVar4 = this.f13626c;
                        String str6 = this.f13624a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Unable to cache video = ");
                        sb4.append(str);
                        sb4.append("Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                        lVar4.mo22916b(str6, sb4.toString());
                    }
                } else if (((Boolean) this.f13625b.mo23039a(C7196pb.f13729N)).booleanValue()) {
                    this.f13626c.mo22916b(this.f13624a, "Failed to cache video");
                    C7209sc.m15473a(this.f14049g, this.f14048f.mo22762n(), -202, this.f13625b);
                    this.f14049g = null;
                } else {
                    lVar = this.f13626c;
                    str2 = this.f13624a;
                    str3 = "Failed to cache video, but not failing ad load";
                }
                lVar.mo22916b(str2, str3);
            }
        } catch (Exception e) {
            this.f13626c.mo22917b(this.f13624a, "Encountered exception while attempting to cache video.", e);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo23385a(String str, List<String> list) {
        return mo23392c(str, list, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23386a(C7071Hc hc) {
        C7086Lb.m14821a(this.f14052j, hc, this.f13625b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Uri mo23387b(String str) {
        return mo23388b(str, this.f14048f.mo23400F(), true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Uri mo23388b(String str, List<String> list, boolean z) {
        try {
            String a = this.f14050h.mo22827a(this.f13627d, str, this.f14048f.mo23401G(), list, z, this.f14052j);
            if (C7269s.m15819a(a)) {
                File a2 = this.f13625b.mo23072q().mo22826a(a, this.f13627d, false);
                if (a2 != null) {
                    Uri fromFile = Uri.fromFile(a2);
                    if (fromFile != null) {
                        return fromFile;
                    }
                    this.f13626c.mo22916b(this.f13624a, "Unable to extract Uri from image file");
                } else {
                    C7262l lVar = this.f13626c;
                    String str2 = this.f13624a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to retrieve File from cached image filename = ");
                    sb.append(a);
                    lVar.mo22916b(str2, sb.toString());
                }
            }
        } catch (MalformedURLException e) {
            C7262l lVar2 = this.f13626c;
            String str3 = this.f13624a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to cache image at url = ");
            sb2.append(str);
            lVar2.mo22917b(str3, sb2.toString(), e);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo23389b(String str, List<String> list) {
        if (!C7269s.m15819a(str)) {
            return str;
        }
        if (!((Boolean) this.f13625b.mo23039a(C7196pb.f13724M)).booleanValue()) {
            this.f13626c.mo22918c(this.f13624a, "Resource caching is disabled, skipping cache...");
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        for (String str2 : list) {
            int i = 0;
            int i2 = 0;
            while (i < sb.length()) {
                i = sb.indexOf(str2, i2);
                if (i == -1) {
                    continue;
                    break;
                }
                int length = sb.length();
                int i3 = i;
                while (!this.f14051i.contains(Character.valueOf(sb.charAt(i3))) && i3 < length) {
                    i3++;
                }
                if (i3 <= i || i3 == length) {
                    this.f13626c.mo22916b(this.f13624a, "Unable to cache resource; ad HTML is invalid.");
                    return str;
                }
                String substring = sb.substring(str2.length() + i, i3);
                if (C7269s.m15819a(substring)) {
                    String a = m15625a(str2, substring);
                    if (a != null) {
                        sb.replace(i, i3, a);
                        this.f14052j.mo23186c();
                    } else {
                        this.f14052j.mo23187d();
                    }
                } else {
                    C7262l lVar = this.f13626c;
                    String str3 = this.f13624a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Skip caching of non-resource ");
                    sb2.append(substring);
                    lVar.mo22918c(str3, sb2.toString());
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23390b() {
        this.f13626c.mo22918c(this.f13624a, "Caching mute images...");
        Uri a = m15624a(this.f14048f.mo23431fa(), "mute");
        if (a != null) {
            this.f14048f.mo23424a(a);
        }
        Uri a2 = m15624a(this.f14048f.mo23432ga(), "unmute");
        if (a2 != null) {
            this.f14048f.mo23426b(a2);
        }
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Ad updated with muteImageFilename = ");
        sb.append(this.f14048f.mo23431fa());
        sb.append(", unmuteImageFilename = ");
        sb.append(this.f14048f.mo23432ga());
        lVar.mo22918c(str, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo23391c(String str) {
        if (!C7269s.m15819a(str)) {
            return null;
        }
        AtomicReference atomicReference = new AtomicReference(null);
        this.f13625b.mo23069n().mo23214a(str, new C7236zb(this, atomicReference, str));
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.f14052j.mo23185b((long) str2.length());
        }
        return str2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo23392c(String str, List<String> list, boolean z) {
        if (C7269s.m15819a(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                this.f13626c.mo22918c(this.f13624a, "Nothing to cache, skipping...");
                return null;
            }
            String lastPathSegment = parse.getLastPathSegment();
            if (C7269s.m15819a(this.f14048f.mo23401G())) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f14048f.mo23401G());
                sb.append(lastPathSegment);
                lastPathSegment = sb.toString();
            }
            File a = this.f14050h.mo22826a(lastPathSegment, this.f13627d, true);
            ByteArrayOutputStream a2 = (a == null || !a.exists()) ? null : this.f14050h.mo22824a(a);
            if (a2 == null) {
                a2 = this.f14050h.mo22825a(str, list, z);
                if (a2 != null) {
                    this.f14050h.mo22830a(a2, a);
                    this.f14052j.mo23183a((long) a2.size());
                }
            } else {
                this.f14052j.mo23185b((long) a2.size());
            }
            try {
                return a2.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                this.f13626c.mo22917b(this.f13624a, "UTF-8 encoding not supported.", e);
            } catch (Throwable th) {
                C7262l lVar = this.f13626c;
                String str2 = this.f13624a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("String resource at ");
                sb2.append(str);
                sb2.append(" failed to load.");
                lVar.mo22917b(str2, sb2.toString(), th);
                return null;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo23393c() {
        if (this.f14049g != null) {
            C7262l b = this.f13625b.mo23049b();
            String a = mo23203a();
            StringBuilder sb = new StringBuilder();
            sb.append("Rendered new ad:");
            sb.append(this.f14048f);
            b.mo22918c(a, sb.toString());
            this.f14049g.adReceived(this.f14048f);
            this.f14049g = null;
        }
    }
}
