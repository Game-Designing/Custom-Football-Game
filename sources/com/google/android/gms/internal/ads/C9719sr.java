package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.ads.sr */
final class C9719sr implements C9656pr {

    /* renamed from: a */
    private final /* synthetic */ zzjg f22970a;

    private C9719sr(zzjg zzjg) {
        this.f22970a = zzjg;
    }

    /* renamed from: a */
    public final int mo29129a(int i) {
        switch (i) {
            case Opcodes.LXOR /*131*/:
            case Opcodes.IF_ICMPEQ /*159*/:
            case Opcodes.ARETURN /*176*/:
            case Opcodes.PUTSTATIC /*179*/:
            case Opcodes.INVOKEDYNAMIC /*186*/:
            case 215:
            case 231:
            case 241:
            case 251:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 20531:
            case 21420:
            case 22186:
            case 22203:
            case 2807729:
                return 2;
            case Opcodes.I2F /*134*/:
            case 17026:
                return 3;
            case Opcodes.IF_ICMPNE /*160*/:
            case Opcodes.FRETURN /*174*/:
            case Opcodes.INVOKESPECIAL /*183*/:
            case Opcodes.NEW /*187*/:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20533:
            case 25152:
            case 28032:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case Opcodes.IF_ICMPLT /*161*/:
            case Opcodes.IF_ICMPGT /*163*/:
            case 18402:
            case 21419:
            case 25506:
                return 4;
            case Opcodes.PUTFIELD /*181*/:
            case 17545:
                return 5;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public final void mo29132a(int i, long j, long j2) throws zzhl {
        this.f22970a.mo31871a(i, j, j2);
    }

    /* renamed from: b */
    public final void mo29134b(int i) throws zzhl {
        this.f22970a.mo31867a(i);
    }

    /* renamed from: b */
    public final void mo29135b(int i, long j) throws zzhl {
        this.f22970a.mo31870a(i, j);
    }

    /* renamed from: a */
    public final void mo29130a(int i, double d) {
        this.f22970a.mo31868a(i, d);
    }

    /* renamed from: a */
    public final void mo29133a(int i, String str) throws zzhl {
        this.f22970a.mo31872a(i, str);
    }

    /* renamed from: a */
    public final void mo29131a(int i, int i2, zzie zzie) throws IOException, InterruptedException {
        this.f22970a.mo31869a(i, i2, zzie);
    }
}
