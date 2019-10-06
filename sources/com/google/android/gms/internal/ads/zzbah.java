package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzard
public final class zzbah implements zzazw {

    /* renamed from: a */
    private final String f25056a;

    public zzbah() {
        this(null);
    }

    public zzbah(String str) {
        this.f25056a = str;
    }

    /* renamed from: a */
    public final void mo28178a(String str) {
        HttpURLConnection httpURLConnection;
        String str2 = "Error while pinging URL: ";
        String str3 = ". ";
        String str4 = "Pinging URL: ";
        try {
            String valueOf = String.valueOf(str);
            zzbad.m26352a(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzyt.m31532a();
            zzazt.m26310a(true, httpURLConnection, this.f25056a);
            zzazx zzazx = new zzazx();
            zzazx.mo30319a(httpURLConnection, (byte[]) null);
            int responseCode = httpURLConnection.getResponseCode();
            zzazx.mo30318a(httpURLConnection, responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                sb.append("Received non-success response code ");
                sb.append(responseCode);
                sb.append(" from pinging URL: ");
                sb.append(str);
                zzbad.m26359d(sb.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message).length());
            sb2.append("Error while parsing ping URL: ");
            sb2.append(str);
            sb2.append(str3);
            sb2.append(message);
            zzbad.m26359d(sb2.toString());
        } catch (IOException e2) {
            String message2 = e2.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message2).length());
            sb3.append(str2);
            sb3.append(str);
            sb3.append(str3);
            sb3.append(message2);
            zzbad.m26359d(sb3.toString());
        } catch (RuntimeException e3) {
            String message3 = e3.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
            sb4.append(str2);
            sb4.append(str);
            sb4.append(str3);
            sb4.append(message3);
            zzbad.m26359d(sb4.toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
