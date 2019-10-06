package com.airbnb.lottie.p093d;

import android.content.Context;
import android.support.v4.util.Pair;
import com.airbnb.lottie.C5664C;
import com.airbnb.lottie.C5667F;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.C5841n;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.network.FileExtension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* renamed from: com.airbnb.lottie.d.d */
/* compiled from: NetworkFetcher */
public class C5784d {

    /* renamed from: a */
    private final Context f10076a;

    /* renamed from: b */
    private final String f10077b;

    /* renamed from: c */
    private final C5782b f10078c;

    /* renamed from: a */
    public static C5667F<C5830g> m10408a(Context context, String url) {
        return new C5784d(context, url).m10409b();
    }

    private C5784d(Context context, String url) {
        this.f10076a = context.getApplicationContext();
        this.f10077b = url;
        this.f10078c = new C5782b(this.f10076a, url);
    }

    /* renamed from: b */
    private C5667F<C5830g> m10409b() {
        return new C5667F<>(new C5783c(this));
    }

    /* renamed from: a */
    public C5664C<C5830g> mo18140a() {
        C5830g result = m10410c();
        if (result != null) {
            return new C5664C<>(result);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Animation for ");
        sb.append(this.f10077b);
        sb.append(" not found in cache. Fetching from network.");
        C5718c.m10177b(sb.toString());
        return m10411d();
    }

    /* renamed from: c */
    private C5830g m10410c() {
        LottieResult<LottieComposition> result;
        Pair<FileExtension, InputStream> cacheResult = this.f10078c.mo18136a();
        if (cacheResult == null) {
            return null;
        }
        InputStream inputStream = (InputStream) cacheResult.f4070b;
        if (((C5781a) cacheResult.f4069a) == C5781a.Zip) {
            result = C5841n.m10574a(new ZipInputStream(inputStream), this.f10077b);
        } else {
            result = C5841n.m10572a(inputStream, (String) this.f10077b);
        }
        if (result.mo17867b() != null) {
            return (C5830g) result.mo17867b();
        }
        return null;
    }

    /* renamed from: d */
    private C5664C<C5830g> m10411d() {
        try {
            return m10412e();
        } catch (IOException e) {
            return new C5664C<>((Throwable) e);
        }
    }

    /* renamed from: e */
    private C5664C m10412e() throws IOException {
        LottieResult<LottieComposition> result;
        C5781a extension;
        StringBuilder sb = new StringBuilder();
        sb.append("Fetching ");
        sb.append(this.f10077b);
        C5718c.m10177b(sb.toString());
        HttpURLConnection connection = (HttpURLConnection) new URL(this.f10077b).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        if (connection.getErrorStream() == null && connection.getResponseCode() == 200) {
            String contentType = connection.getContentType();
            char c = 65535;
            int hashCode = contentType.hashCode();
            boolean z = true;
            if (hashCode != -1248325150) {
                if (hashCode == -43840953 && contentType.equals("application/json")) {
                    c = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c = 0;
            }
            if (c != 0) {
                C5718c.m10177b("Received json response.");
                extension = C5781a.Json;
                result = C5841n.m10572a((InputStream) new FileInputStream(new File(this.f10078c.mo18137a(connection.getInputStream(), extension).getAbsolutePath())), this.f10077b);
            } else {
                C5718c.m10177b("Handling zip response.");
                extension = C5781a.Zip;
                result = C5841n.m10574a(new ZipInputStream(new FileInputStream(this.f10078c.mo18137a(connection.getInputStream(), extension))), this.f10077b);
            }
            if (result.mo17867b() != null) {
                this.f10078c.mo18138a(extension);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Completed fetch from network. Success: ");
            if (result.mo17867b() == null) {
                z = false;
            }
            sb2.append(z);
            C5718c.m10177b(sb2.toString());
            return result;
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        StringBuilder error = new StringBuilder();
        while (true) {
            String readLine = r.readLine();
            String line = readLine;
            if (readLine != null) {
                error.append(line);
                error.append(10);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to fetch ");
                sb3.append(this.f10077b);
                sb3.append(". Failed with ");
                sb3.append(connection.getResponseCode());
                sb3.append("\n");
                sb3.append(error);
                return new C5664C((Throwable) new IllegalArgumentException(sb3.toString()));
            }
        }
    }
}
