package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzyt;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@VisibleForTesting
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(Opcodes.IF_ICMPNE, 600, "160x600_as");
    public static final AdSize zzaao = new AdSize(50, 50, "50x50_mb");

    /* renamed from: a */
    private final int f19017a;

    /* renamed from: b */
    private final int f19018b;

    /* renamed from: c */
    private final String f19019c;

    public AdSize(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("x");
        sb.append(valueOf2);
        sb.append("_as");
        this(i, i2, sb.toString());
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.f19017a = i;
            this.f19018b = i2;
            this.f19019c = str;
        } else {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        if (this.f19017a == adSize.f19017a && this.f19018b == adSize.f19018b && this.f19019c.equals(adSize.f19019c)) {
            return true;
        }
        return false;
    }

    public final int getHeight() {
        return this.f19018b;
    }

    public final int getHeightInPixels(Context context) {
        int i = this.f19018b;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzyd.m31512b(context.getResources().getDisplayMetrics());
        }
        zzyt.m31532a();
        return zzazt.m26302a(context, this.f19018b);
    }

    public final int getWidth() {
        return this.f19017a;
    }

    public final int getWidthInPixels(Context context) {
        int i = this.f19017a;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -1) {
            return zzyd.m31509a(context.getResources().getDisplayMetrics());
        }
        zzyt.m31532a();
        return zzazt.m26302a(context, this.f19017a);
    }

    public final int hashCode() {
        return this.f19019c.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.f19018b == -2;
    }

    public final boolean isFullWidth() {
        return this.f19017a == -1;
    }

    public final boolean isFluid() {
        return this.f19017a == -3 && this.f19018b == -4;
    }

    public final String toString() {
        return this.f19019c;
    }
}
