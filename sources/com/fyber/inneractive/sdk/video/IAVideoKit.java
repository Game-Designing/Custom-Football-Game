package com.fyber.inneractive.sdk.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.p160b.C7649a.C7650a;
import com.fyber.inneractive.sdk.p160b.C7652b.C7654b;
import com.fyber.inneractive.sdk.p160b.C7655c.C7656a;
import com.fyber.inneractive.sdk.p161c.C7664e;
import com.fyber.inneractive.sdk.p161c.C7678p;
import com.fyber.inneractive.sdk.p163d.C7716a;
import com.fyber.inneractive.sdk.p163d.C7718b;
import com.fyber.inneractive.sdk.p163d.C7719c;
import com.fyber.inneractive.sdk.p166g.p167a.C7767d;
import com.fyber.inneractive.sdk.p166g.p167a.C7790l;
import com.fyber.inneractive.sdk.p173h.C7892b;
import com.fyber.inneractive.sdk.p173h.C7896c;
import com.fyber.inneractive.sdk.p173h.C7897f;
import com.fyber.inneractive.sdk.p174i.C7903b;
import com.fyber.inneractive.sdk.p174i.C7904c;
import com.fyber.inneractive.sdk.p174i.C7905f;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

public class IAVideoKit extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C7790l a = C7790l.m17292a();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            IAlog.m18023d("context is null, would not start the video cache.");
        } else if (!a.mo24413b()) {
            a.f15670a = applicationContext;
            C7767d a2 = C7767d.m17260a();
            if (a2.f15601a.compareAndSet(false, true)) {
                try {
                    if (a2.f15604d == null) {
                        a2.f15602b = new ServerSocket(0, 24, InetAddress.getByName("127.0.0.1"));
                    }
                    a2.f15603c = a2.f15602b.getLocalPort();
                    ProxySelector.setDefault(new ProxySelector(Collections.singletonList(Proxy.NO_PROXY), ProxySelector.getDefault()) {

                        /* renamed from: a */
                        final /* synthetic */ List f15613a;

                        /* renamed from: b */
                        final /* synthetic */ ProxySelector f15614b;

                        {
                            this.f15613a = r2;
                            this.f15614b = r3;
                        }

                        public final List<Proxy> select(URI uri) {
                            if (uri == null || uri.getHost() == null || ((!uri.getHost().equalsIgnoreCase("127.0.0.1") && !uri.getHost().equalsIgnoreCase("localhost")) || uri.getPort() != C7767d.this.f15603c)) {
                                return this.f15614b.select(uri);
                            }
                            return this.f15613a;
                        }

                        public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
                            this.f15614b.connectFailed(uri, socketAddress, iOException);
                        }
                    });
                    a2.f15605e = true;
                } catch (Throwable th) {
                    IAlog.m18019a(String.format("MediaCacheStreamer failed to open a socket on port %d", new Object[]{Integer.valueOf(0)}));
                }
                if (a2.f15605e) {
                    a2.f15604d = new Thread(a2.f15609i, "FYB-MediaCacheStreamer");
                    a2.f15604d.start();
                }
            }
            a.f15672c = new Thread(a.f15674e, "VideoCache");
            a.f15672c.start();
        }
        StringBuilder sb = new StringBuilder("IAVideoKit: onReceive in package: ");
        sb.append(C8005i.m18056e());
        IAlog.m18021b(sb.toString());
        C7653a.f15185a.mo24082a(C7903b.RETURNED_ADTYPE_VAST, new C7654b() {
            /* renamed from: a */
            public final C7904c mo24084a() {
                return new C7905f();
            }

            /* renamed from: b */
            public final /* synthetic */ C7716a mo24085b() {
                return new C7664e("Interstitial");
            }
        });
        C7657b.f15187a.mo24087a((C7656a) new C7656a() {
            /* renamed from: a */
            public final boolean mo24088a(InneractiveAdSpot inneractiveAdSpot) {
                if (!inneractiveAdSpot.isReady() || !(inneractiveAdSpot.getAdContent() instanceof C7678p)) {
                    return false;
                }
                return true;
            }

            /* renamed from: b */
            public final C7719c mo24089b(InneractiveAdSpot inneractiveAdSpot) {
                InneractiveAdRequest adRequest = inneractiveAdSpot.getAdContent().getAdRequest();
                boolean z = adRequest == null || adRequest.getAllowFullscreen();
                if (!inneractiveAdSpot.getAdContent().isFullscreenAd() || !z) {
                    return new C7896c();
                }
                return new C7897f();
            }
        });
        C7651b.f15183a.mo24079a((C7650a) new C7650a() {
            /* renamed from: a */
            public final boolean mo24081a(InneractiveAdSpot inneractiveAdSpot) {
                if (!inneractiveAdSpot.isReady() || !(inneractiveAdSpot.getAdContent() instanceof C7678p)) {
                    return false;
                }
                return true;
            }

            /* renamed from: a */
            public final C7718b mo24080a() {
                return new C7892b();
            }
        });
    }
}
