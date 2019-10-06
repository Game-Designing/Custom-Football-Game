package com.fyber.inneractive.sdk.p161c;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.p163d.C7716a.C7717a;
import com.fyber.inneractive.sdk.p164e.C7721a.C7722a;
import com.fyber.inneractive.sdk.p165f.C7737f;
import com.fyber.inneractive.sdk.p165f.C7738g;
import com.fyber.inneractive.sdk.p165f.C7739h.C7740a;
import com.fyber.inneractive.sdk.p165f.C7739h.C7741b;
import com.fyber.inneractive.sdk.p166g.C7746a;
import com.fyber.inneractive.sdk.p166g.C7746a.C7753a;
import com.fyber.inneractive.sdk.p166g.C7746a.C7754b;
import com.fyber.inneractive.sdk.p166g.C7833c;
import com.fyber.inneractive.sdk.p166g.p172f.C7870b;
import com.fyber.inneractive.sdk.p174i.C7899a;
import com.fyber.inneractive.sdk.p174i.C7907g;
import com.fyber.inneractive.sdk.p174i.C7908j;
import com.fyber.inneractive.sdk.p174i.C7912m;
import com.fyber.inneractive.sdk.p179l.C7922a;
import com.fyber.inneractive.sdk.p179l.C7922a.C7925a;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.c.e */
public final class C7664e extends C7661a<C7908j, C7678p> {

    /* renamed from: f */
    C7833c f15199f;

    /* renamed from: g */
    C7870b f15200g;

    /* renamed from: h */
    C7754b f15201h;

    /* renamed from: i */
    C7925a f15202i;

    /* renamed from: j */
    boolean f15203j = true;

    /* renamed from: k */
    String f15204k;

    /* renamed from: com.fyber.inneractive.sdk.c.e$3 */
    static /* synthetic */ class C76673 {

        /* renamed from: a */
        static final /* synthetic */ int[] f15207a = new int[C7753a.values().length];

        static {
            try {
                f15207a[C7753a.ERROR_NO_MEDIA_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15207a[C7753a.ERROR_FAILED_PLAYING_MEDIA_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15207a[C7753a.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15207a[C7753a.ERROR_PRE_BUFFER_TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15207a[C7753a.ERROR_BUFFER_TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public C7664e(String str) {
        this.f15204k = str;
    }

    /* renamed from: b */
    public final void mo24095b() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("start called");
        IAlog.m18021b(sb.toString());
        if (((C7908j) this.f15191b).f16049s.f16074k) {
            C7712j d = mo24097d();
            if (d.mo24208d() != null || VERSION.SDK_INT < 19) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(IAlog.m18018a((Object) this));
                sb2.append("got a vpaid ad for a native unit, or Android SDK < 4.4. Ad type not supported. Failing ad! v = ");
                sb2.append(VERSION.SDK_INT);
                sb2.append("config = ");
                sb2.append(d);
                IAlog.m18021b(sb2.toString());
                C7717a aVar = this.f15193d;
                if (aVar != null) {
                    aVar.mo24103b(InneractiveErrorCode.SERVER_INVALID_RESPONSE);
                }
                return;
            }
            this.f15200g = new C7870b(C8006j.m18075n(), (C7908j) this.f15191b, d);
            if (this.f15202i == null) {
                this.f15202i = new C7925a() {
                    /* renamed from: a */
                    public final void mo24109a(C7922a aVar) {
                        C7717a aVar2 = C7664e.this.f15193d;
                        if (aVar2 != null) {
                            aVar2.mo24104c();
                        }
                    }

                    /* renamed from: a */
                    public final void mo24108a(InneractiveErrorCode inneractiveErrorCode) {
                        C7717a aVar = C7664e.this.f15193d;
                        if (aVar != null) {
                            aVar.mo24103b(inneractiveErrorCode);
                        }
                        if (inneractiveErrorCode == InneractiveErrorCode.NON_SECURE_CONTENT_DETECTED) {
                            C7737f fVar = C7737f.VPAID_ERROR_UNSECURE_CONTENT;
                            C7664e eVar = C7664e.this;
                            new C7740a(fVar, eVar.f15190a, (C7907g) eVar.f15191b).mo24314a();
                        }
                        C7664e.this.f15200g.mo24652b();
                    }
                };
            }
            this.f15200g.mo24737a(IAConfigManager.m16954E(), null, null, null, this.f15202i, 25000);
            this.f15192c = new C7678p(mo24097d(), this.f15200g);
        } else {
            C7712j d2 = mo24097d();
            if (this.f15201h == null) {
                this.f15201h = new C7754b() {
                    /* renamed from: a */
                    public final void mo24110a() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(IAlog.m18018a((Object) C7664e.this));
                        sb.append("got onMediaPlayerLoaded");
                        IAlog.m18021b(sb.toString());
                        C7717a aVar = C7664e.this.f15193d;
                        if (aVar != null) {
                            aVar.mo24104c();
                        }
                        C7664e eVar = C7664e.this;
                        if (eVar.f15203j) {
                            try {
                                C7740a aVar2 = new C7740a(C7738g.VAST_EVENT_READY_ON_CLIENT, eVar.f15190a, (C7907g) eVar.f15191b);
                                C7912m mVar = ((C7908j) C7664e.this.f15191b).f16049s;
                                if (mVar != null) {
                                    C7899a a = mVar.mo24724a(0);
                                    if (a != null) {
                                        aVar2.mo24311a(new C7741b().mo24315a("url", a.f15980a).mo24315a("bitrate", Integer.valueOf(a.f15985f)).mo24315a("mime", TextUtils.isEmpty(a.f15982c) ? "na" : a.f15982c).mo24315a("delivery", a.f15981b).mo24315a("load_time", Long.valueOf(System.currentTimeMillis() - ((C7908j) C7664e.this.f15191b).f16049s.f16075l)).mo24315a("media_file_index", Integer.valueOf(C7664e.this.f15199f.mo24349p())));
                                    }
                                }
                                aVar2.mo24314a();
                            } catch (Exception e) {
                            }
                        }
                    }

                    /* renamed from: b */
                    public final void mo24112b() {
                        C7664e eVar = C7664e.this;
                        InneractiveAdRequest inneractiveAdRequest = eVar.f15190a;
                        if (inneractiveAdRequest != null) {
                            new C7740a(C7738g.VAST_EVENT_PLAYED_FOR_2_SECONDS, inneractiveAdRequest, (C7907g) eVar.f15191b).mo24314a();
                        }
                    }

                    /* renamed from: a */
                    public final void mo24111a(C7753a aVar) {
                        C7737f fVar;
                        int i = C76673.f15207a[aVar.ordinal()];
                        if (i == 1) {
                            fVar = C7737f.VAST_ERROR_NO_MEDIA_FILES;
                        } else if (i == 2) {
                            fVar = C7737f.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
                        } else if (i == 3) {
                            fVar = C7737f.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
                        } else if (i == 4) {
                            fVar = C7737f.VAST_ERROR_PRE_BUFFER_TIMEOUT;
                        } else if (i != 5) {
                            StringBuilder sb = new StringBuilder("IAReportError, Does not know player error ");
                            sb.append(aVar.f15549f);
                            IAlog.m18021b(sb.toString());
                            fVar = C7737f.VAST_UNKNOWN_PLAYER_ERROR;
                        } else {
                            fVar = C7737f.VAST_ERROR_BUFFER_TIMEOUT;
                        }
                        C7664e eVar = C7664e.this;
                        new C7740a(fVar, eVar.f15190a, (C7907g) eVar.f15191b).mo24312a(aVar.f15551h).mo24314a();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(IAlog.m18018a((Object) C7664e.this));
                        sb2.append("got onMediaPlayerLoadError with: ");
                        sb2.append(aVar);
                        IAlog.m18021b(sb2.toString());
                        if (aVar.f15550g) {
                            C7717a aVar2 = C7664e.this.f15193d;
                            if (aVar2 != null) {
                                aVar2.mo24103b(InneractiveErrorCode.SERVER_INVALID_RESPONSE);
                            }
                        }
                    }

                    /* renamed from: c */
                    public final C7722a mo24113c() {
                        Context n = C8006j.m18075n();
                        C7664e eVar = C7664e.this;
                        String str = eVar.f15204k;
                        Response response = eVar.f15191b;
                        if (n == null || response == null) {
                            return null;
                        }
                        C7722a aVar = new C7722a("inneractivenativeapp451574644765");
                        aVar.f15384b.put("level1", response.f16034c);
                        aVar.f15384b.put("level2", response.f16034c);
                        aVar.f15384b.put("level3", response.f16035d);
                        aVar.f15384b.put("level4", str);
                        aVar.f15384b.put("slicer1", C8005i.m18058g());
                        aVar.f15384b.put("slicer2", "Android_7.2.2");
                        return aVar;
                    }
                };
            }
            this.f15199f = new C7833c(C8006j.m18075n(), ((C7908j) this.f15191b).f16049s, d2 == null ? null : d2.mo24209e().f15381c);
            C7833c cVar = this.f15199f;
            UnitDisplayType unitDisplayType = ((C7908j) this.f15191b).f16046o;
            InneractiveAdRequest inneractiveAdRequest = this.f15190a;
            boolean z = inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen();
            Response response = this.f15191b;
            int i = ((C7908j) response).f16036e;
            int i2 = ((C7908j) response).f16037f;
            C7712j d3 = mo24097d();
            cVar.f15782m = unitDisplayType;
            cVar.f15783n = z;
            cVar.f15784o = i;
            cVar.f15785p = i2;
            cVar.f15786q = d3;
            if (d2 != null) {
                this.f15199f.mo24561a(d2);
            }
            this.f15199f.mo24333a(this.f15201h);
            this.f15192c = new C7678p(mo24097d(), (C7746a) this.f15199f);
        }
        ((C7678p) this.f15192c).setResponseData(this.f15191b);
    }

    /* renamed from: a */
    public final void mo24093a() {
        C7833c cVar = this.f15199f;
        if (cVar != null) {
            cVar.mo24334b();
        }
        C7870b bVar = this.f15200g;
        if (bVar != null) {
            bVar.mo24652b();
        }
    }
}
