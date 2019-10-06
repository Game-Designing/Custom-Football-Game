package p346g.p347a.p356a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p346g.p347a.p356a.p357a.C14100a;
import p346g.p347a.p356a.p357a.C14101b;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.d */
/* compiled from: DNSIncoming */
public final class C14123d extends C14126f {

    /* renamed from: h */
    private static C14236b f42927h = C14246c.m45851a(C14123d.class.getName());

    /* renamed from: i */
    public static boolean f42928i = true;

    /* renamed from: j */
    private static final char[] f42929j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: k */
    private final DatagramPacket f42930k;

    /* renamed from: l */
    private final long f42931l;

    /* renamed from: m */
    private final C14124a f42932m;

    /* renamed from: n */
    private int f42933n;

    /* renamed from: g.a.a.d$a */
    /* compiled from: DNSIncoming */
    public static class C14124a extends ByteArrayInputStream {

        /* renamed from: a */
        private static C14236b f42934a = C14246c.m45851a(C14124a.class.getName());

        /* renamed from: b */
        final Map<Integer, String> f42935b;

        public C14124a(byte[] buffer, int length) {
            this(buffer, 0, length);
        }

        public C14124a(byte[] buffer, int offset, int length) {
            super(buffer, offset, length);
            this.f42935b = new HashMap();
        }

        /* renamed from: c */
        public int mo43926c() {
            return read() & 255;
        }

        /* renamed from: d */
        public int mo43927d() {
            return (mo43926c() << 8) | mo43926c();
        }

        public int readInt() {
            return (mo43927d() << 16) | mo43927d();
        }

        /* renamed from: a */
        public byte[] mo43923a(int len) {
            byte[] bytes = new byte[len];
            read(bytes, 0, len);
            return bytes;
        }

        /* renamed from: b */
        public String mo43925b(int len) {
            StringBuilder buffer = new StringBuilder(len);
            int index = 0;
            while (index < len) {
                int ch = mo43926c();
                switch (ch >> 4) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 12:
                    case 13:
                        ch = ((ch & 31) << 6) | (mo43926c() & 63);
                        index++;
                        break;
                    case 14:
                        ch = ((ch & 15) << 12) | ((mo43926c() & 63) << 6) | (mo43926c() & 63);
                        index = index + 1 + 1;
                        break;
                    default:
                        ch = ((ch & 63) << 4) | (mo43926c() & 15);
                        index++;
                        break;
                }
                buffer.append((char) ch);
                index++;
            }
            return buffer.toString();
        }

        /* renamed from: a */
        public String mo43922a() {
            Map<Integer, StringBuilder> names = new HashMap<>();
            StringBuilder buffer = new StringBuilder();
            boolean finished = false;
            while (true) {
                if (finished) {
                    break;
                }
                int len = mo43926c();
                if (len == 0) {
                    break;
                }
                int i = C14121c.f42922a[C14101b.m45108a(len).ordinal()];
                if (i == 1) {
                    int offset = this.pos - 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append(mo43925b(len));
                    sb.append(".");
                    String label = sb.toString();
                    buffer.append(label);
                    for (StringBuilder previousLabel : names.values()) {
                        previousLabel.append(label);
                    }
                    names.put(Integer.valueOf(offset), new StringBuilder(label));
                } else if (i == 2) {
                    int index = (C14101b.m45109b(len) << 8) | mo43926c();
                    String compressedLabel = (String) this.f42935b.get(Integer.valueOf(index));
                    if (compressedLabel == null) {
                        C14236b bVar = f42934a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("bad domain name: possible circular name detected. Bad offset: 0x");
                        sb2.append(Integer.toHexString(index));
                        sb2.append(" at 0x");
                        sb2.append(Integer.toHexString(this.pos - 2));
                        bVar.mo44343b(sb2.toString());
                        compressedLabel = "";
                    }
                    buffer.append(compressedLabel);
                    for (StringBuilder previousLabel2 : names.values()) {
                        previousLabel2.append(compressedLabel);
                    }
                    finished = true;
                } else if (i != 3) {
                    C14236b bVar2 = f42934a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("unsupported dns label type: '");
                    sb3.append(Integer.toHexString(len & Opcodes.CHECKCAST));
                    sb3.append("'");
                    bVar2.mo44343b(sb3.toString());
                } else {
                    f42934a.mo44340a("Extended label are not currently supported.");
                }
            }
            for (Integer index2 : names.keySet()) {
                this.f42935b.put(index2, ((StringBuilder) names.get(index2)).toString());
            }
            return buffer.toString();
        }

        /* renamed from: b */
        public String mo43924b() {
            return mo43925b(mo43926c());
        }
    }

    public C14123d(DatagramPacket packet) throws IOException {
        super(0, 0, packet.getPort() == C14100a.f42767a);
        this.f42930k = packet;
        InetAddress source = packet.getAddress();
        this.f42932m = new C14124a(packet.getData(), packet.getLength());
        this.f42931l = System.currentTimeMillis();
        this.f42933n = 1460;
        try {
            mo43933b(this.f42932m.mo43927d());
            mo43931a(this.f42932m.mo43927d());
            if (mo43942k() <= 0) {
                int numQuestions = this.f42932m.mo43927d();
                int numAnswers = this.f42932m.mo43927d();
                int numAuthorities = this.f42932m.mo43927d();
                int numAdditionals = this.f42932m.mo43927d();
                String str = " additionals:";
                String str2 = " authorities:";
                String str3 = " answers:";
                if (f42927h.isDebugEnabled()) {
                    C14236b bVar = f42927h;
                    StringBuilder sb = new StringBuilder();
                    sb.append("DNSIncoming() questions:");
                    sb.append(numQuestions);
                    sb.append(str3);
                    sb.append(numAnswers);
                    sb.append(str2);
                    sb.append(numAuthorities);
                    sb.append(str);
                    sb.append(numAdditionals);
                    bVar.mo44340a(sb.toString());
                }
                if ((numQuestions * 5) + ((numAnswers + numAuthorities + numAdditionals) * 11) <= packet.getLength()) {
                    if (numQuestions > 0) {
                        for (int i = 0; i < numQuestions; i++) {
                            this.f42939d.add(m45227w());
                        }
                    }
                    if (numAnswers > 0) {
                        for (int i2 = 0; i2 < numAnswers; i2++) {
                            C14138j rec = m45225a(source);
                            if (rec != null) {
                                this.f42940e.add(rec);
                            }
                        }
                    }
                    if (numAuthorities > 0) {
                        for (int i3 = 0; i3 < numAuthorities; i3++) {
                            C14138j rec2 = m45225a(source);
                            if (rec2 != null) {
                                this.f42941f.add(rec2);
                            }
                        }
                    }
                    if (numAdditionals > 0) {
                        for (int i4 = 0; i4 < numAdditionals; i4++) {
                            C14138j rec3 = m45225a(source);
                            if (rec3 != null) {
                                this.f42942g.add(rec3);
                            }
                        }
                    }
                    if (this.f42932m.available() > 0) {
                        throw new IOException("Received a message with the wrong length.");
                    }
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("questions:");
                sb2.append(numQuestions);
                sb2.append(str3);
                sb2.append(numAnswers);
                sb2.append(str2);
                sb2.append(numAuthorities);
                sb2.append(str);
                sb2.append(numAdditionals);
                throw new IOException(sb2.toString());
            }
            throw new IOException("Received a message with a non standard operation code. Currently unsupported in the specification.");
        } catch (Exception e) {
            C14236b bVar2 = f42927h;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("DNSIncoming() dump ");
            sb3.append(mo43916a(true));
            sb3.append("\n exception ");
            bVar2.mo44344b(sb3.toString(), e);
            IOException ioe = new IOException("DNSIncoming corrupted message");
            ioe.initCause(e);
            throw ioe;
        }
    }

    private C14123d(int flags, int id, boolean multicast, DatagramPacket packet, long receivedTime) {
        super(flags, id, multicast);
        this.f42930k = packet;
        this.f42932m = new C14124a(packet.getData(), packet.getLength());
        this.f42931l = receivedTime;
    }

    public C14123d clone() {
        C14123d in = new C14123d(mo43936e(), mo43937f(), mo43946o(), this.f42930k, this.f42931l);
        in.f42933n = this.f42933n;
        in.f42939d.addAll(this.f42939d);
        in.f42940e.addAll(this.f42940e);
        in.f42941f.addAll(this.f42941f);
        in.f42942g.addAll(this.f42942g);
        return in;
    }

    /* renamed from: w */
    private C14130i m45227w() {
        String domain = this.f42932m.mo43922a();
        C14104e type = C14104e.m45116a(this.f42932m.mo43927d());
        if (type == C14104e.TYPE_IGNORE) {
            C14236b bVar = f42927h;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find record type: ");
            sb.append(mo43916a(true));
            bVar.mo44343b(sb.toString());
        }
        int recordClassIndex = this.f42932m.mo43927d();
        C14103d recordClass = C14103d.m45113a(recordClassIndex);
        return C14130i.m45277a(domain, type, recordClass, recordClass.mo43832b(recordClassIndex));
    }

    /* JADX WARNING: type inference failed for: r0v12, types: [g.a.a.j] */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r2v4, types: [g.a.a.j$c] */
    /* JADX WARNING: type inference failed for: r16v1 */
    /* JADX WARNING: type inference failed for: r2v6, types: [g.a.a.j$d] */
    /* JADX WARNING: type inference failed for: r16v2 */
    /* JADX WARNING: type inference failed for: r2v10, types: [g.a.a.j$e] */
    /* JADX WARNING: type inference failed for: r16v3 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r2v12, types: [g.a.a.j$g] */
    /* JADX WARNING: type inference failed for: r16v4 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r2v17, types: [g.a.a.j$f] */
    /* JADX WARNING: type inference failed for: r16v5 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r2v26, types: [g.a.a.j$b] */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r2v90, types: [g.a.a.j$c] */
    /* JADX WARNING: type inference failed for: r2v91, types: [g.a.a.j$d] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v13
      assigns: [?[OBJECT, ARRAY], g.a.a.j$c, g.a.a.j$d]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], g.a.a.j, g.a.a.j$c, g.a.a.j$d]
      mth insns count: 532
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03e6  */
    /* JADX WARNING: Unknown variable types count: 13 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p346g.p347a.p356a.C14138j m45225a(java.net.InetAddress r43) {
        /*
            r42 = this;
            r1 = r42
            g.a.a.d$a r0 = r1.f42932m
            java.lang.String r11 = r0.mo43922a()
            g.a.a.d$a r0 = r1.f42932m
            int r0 = r0.mo43927d()
            g.a.a.a.e r12 = p346g.p347a.p356a.p357a.C14104e.m45116a(r0)
            g.a.a.a.e r0 = p346g.p347a.p356a.p357a.C14104e.TYPE_IGNORE
            java.lang.String r2 = "\n"
            r3 = 1
            if (r12 != r0) goto L_0x0039
            i.c.b r0 = f42927h
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Could not find record type. domain: "
            r4.append(r5)
            r4.append(r11)
            r4.append(r2)
            java.lang.String r5 = r1.mo43916a(r3)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.mo44343b(r4)
        L_0x0039:
            g.a.a.d$a r0 = r1.f42932m
            int r13 = r0.mo43927d()
            g.a.a.a.e r0 = p346g.p347a.p356a.p357a.C14104e.TYPE_OPT
            if (r12 != r0) goto L_0x0046
            g.a.a.a.d r0 = p346g.p347a.p356a.p357a.C14103d.CLASS_UNKNOWN
            goto L_0x004a
        L_0x0046:
            g.a.a.a.d r0 = p346g.p347a.p356a.p357a.C14103d.m45113a(r13)
        L_0x004a:
            r14 = r0
            g.a.a.a.d r0 = p346g.p347a.p356a.p357a.C14103d.CLASS_UNKNOWN
            if (r14 != r0) goto L_0x007b
            g.a.a.a.e r0 = p346g.p347a.p356a.p357a.C14104e.TYPE_OPT
            if (r12 == r0) goto L_0x007b
            i.c.b r0 = f42927h
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Could not find record class. domain: "
            r4.append(r5)
            r4.append(r11)
            java.lang.String r5 = " type: "
            r4.append(r5)
            r4.append(r12)
            r4.append(r2)
            java.lang.String r2 = r1.mo43916a(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.mo44343b(r2)
        L_0x007b:
            boolean r15 = r14.mo43832b(r13)
            g.a.a.d$a r0 = r1.f42932m
            int r10 = r0.readInt()
            g.a.a.d$a r0 = r1.f42932m
            int r9 = r0.mo43927d()
            r16 = 0
            int[] r0 = p346g.p347a.p356a.C14121c.f42924c
            int r2 = r12.ordinal()
            r0 = r0[r2]
            java.lang.String r2 = ""
            r4 = 0
            r5 = 0
            switch(r0) {
                case 1: goto L_0x05a2;
                case 2: goto L_0x0585;
                case 3: goto L_0x053b;
                case 4: goto L_0x053b;
                case 5: goto L_0x051a;
                case 6: goto L_0x04ce;
                case 7: goto L_0x046f;
                case 8: goto L_0x00d6;
                default: goto L_0x009c;
            }
        L_0x009c:
            r21 = r10
            r27 = r12
            r39 = r13
            r12 = r9
            r0 = 0
            r2 = r0
            r3 = 0
            r4 = r3
            r5 = r3
            r6 = r3
            r7 = r0
            r8 = r0
            r9 = r3
            r10 = r0
            r13 = r0
            i.c.b r17 = f42927h
            boolean r17 = r17.isDebugEnabled()
            if (r17 == 0) goto L_0x05bf
            r17 = r0
            i.c.b r0 = f42927h
            r18 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r19 = r3
            java.lang.String r3 = "DNSIncoming() unknown type:"
            r2.append(r3)
            r3 = r27
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.mo44340a(r2)
            goto L_0x05c7
        L_0x00d6:
            r6 = r4
            r7 = r5
            r8 = r5
            r17 = r5
            r18 = r4
            r19 = r4
            r20 = r5
            r21 = r4
            r22 = r4
            int r0 = r42.mo43936e()
            g.a.a.a.f r4 = p346g.p347a.p356a.p357a.C14105f.m45118a(r0, r10)
            r0 = 16711680(0xff0000, float:2.3418052E-38)
            r0 = r0 & r10
            r24 = 16
            int r3 = r0 >> 16
            if (r3 != 0) goto L_0x0440
            r1.f42933n = r13
            r0 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x0101:
            g.a.a.d$a r5 = r1.f42932m
            int r5 = r5.available()
            if (r5 <= 0) goto L_0x042f
            r5 = 0
            r30 = 0
            r31 = r2
            g.a.a.d$a r2 = r1.f42932m
            int r2 = r2.available()
            r32 = r5
            java.lang.String r5 = "There was a problem reading the OPT record. Ignoring."
            r33 = r6
            r6 = 2
            if (r2 < r6) goto L_0x041b
            g.a.a.d$a r2 = r1.f42932m
            int r2 = r2.mo43927d()
            g.a.a.a.c r6 = p346g.p347a.p356a.p357a.C14102c.m45111a(r2)
            r30 = 0
            r35 = r7
            g.a.a.d$a r7 = r1.f42932m
            int r7 = r7.available()
            r36 = r8
            r8 = 2
            if (r7 < r8) goto L_0x0407
            g.a.a.d$a r5 = r1.f42932m
            int r5 = r5.mo43927d()
            r7 = 0
            byte[] r8 = new byte[r7]
            g.a.a.d$a r7 = r1.f42932m
            int r7 = r7.available()
            if (r7 < r5) goto L_0x014d
            g.a.a.d$a r7 = r1.f42932m
            byte[] r8 = r7.mo43923a(r5)
        L_0x014d:
            int[] r7 = p346g.p347a.p356a.C14121c.f42923b
            int r30 = r6.ordinal()
            r7 = r7[r30]
            r30 = r5
            r5 = 1
            if (r7 == r5) goto L_0x023a
            java.lang.String r5 = " data: "
            r39 = r13
            r13 = 2
            if (r7 == r13) goto L_0x01ed
            r13 = 3
            if (r7 == r13) goto L_0x01ed
            r13 = 4
            if (r7 == r13) goto L_0x01ed
            r13 = 5
            if (r7 == r13) goto L_0x0172
            r13 = r27
            r25 = 1
            r27 = r12
            goto L_0x03f6
        L_0x0172:
            r7 = r23
            r13 = r26
            r23 = r27
            r26 = r28
            r32 = r0
            r0 = 65001(0xfde9, float:9.1086E-41)
            if (r2 < r0) goto L_0x01b8
            r0 = 65534(0xfffe, float:9.1833E-41)
            if (r2 > r0) goto L_0x01b8
            i.c.b r0 = f42927h
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x01b3
            i.c.b r0 = f42927h
            r34 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r37 = r13
            java.lang.String r13 = "There was an OPT answer using an experimental/local option code: "
            r7.append(r13)
            r7.append(r2)
            r7.append(r5)
            java.lang.String r5 = r1.m45226b(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.mo44340a(r5)
            goto L_0x01dd
        L_0x01b3:
            r34 = r7
            r37 = r13
            goto L_0x01dd
        L_0x01b8:
            r34 = r7
            r37 = r13
            i.c.b r0 = f42927h
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r13 = "There was an OPT answer. Not currently handled. Option code: "
            r7.append(r13)
            r7.append(r2)
            r7.append(r5)
            java.lang.String r5 = r1.m45226b(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r0.mo44343b(r5)
        L_0x01dd:
            r27 = r12
            r13 = r23
            r28 = r26
            r0 = r32
            r23 = r34
            r26 = r37
            r25 = 1
            goto L_0x03f6
        L_0x01ed:
            r7 = r23
            r13 = r26
            r23 = r27
            r26 = r28
            i.c.b r27 = f42927h
            boolean r27 = r27.isDebugEnabled()
            if (r27 == 0) goto L_0x0224
            r27 = r0
            i.c.b r0 = f42927h
            r28 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r32 = r7
            java.lang.String r7 = "There was an OPT answer. Option code: "
            r2.append(r7)
            r2.append(r6)
            r2.append(r5)
            java.lang.String r5 = r1.m45226b(r8)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.mo44340a(r2)
            goto L_0x022a
        L_0x0224:
            r27 = r0
            r28 = r2
            r32 = r7
        L_0x022a:
            r28 = r26
            r0 = r27
            r25 = 1
            r27 = r12
            r26 = r13
            r13 = r23
            r23 = r32
            goto L_0x03f6
        L_0x023a:
            r28 = r2
            r39 = r13
            r2 = 0
            r5 = 0
            r7 = 0
            r13 = 0
            r23 = 0
            r26 = 0
            byte r0 = r8[r26]     // Catch:{ Exception -> 0x0346 }
            r2 = r0
            r25 = 1
            byte r0 = r8[r25]     // Catch:{ Exception -> 0x0342 }
            r5 = r0
            r0 = 6
            r26 = r2
            byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x033c }
            r27 = 2
            byte r40 = r8[r27]     // Catch:{ Exception -> 0x033c }
            r27 = 0
            r2[r27] = r40     // Catch:{ Exception -> 0x033c }
            r27 = 3
            byte r40 = r8[r27]     // Catch:{ Exception -> 0x033c }
            r25 = 1
            r2[r25] = r40     // Catch:{ Exception -> 0x033a }
            r27 = 4
            byte r40 = r8[r27]     // Catch:{ Exception -> 0x033c }
            r27 = 2
            r2[r27] = r40     // Catch:{ Exception -> 0x033c }
            r27 = 5
            byte r40 = r8[r27]     // Catch:{ Exception -> 0x033c }
            r27 = 3
            r2[r27] = r40     // Catch:{ Exception -> 0x033c }
            byte r27 = r8[r0]     // Catch:{ Exception -> 0x033c }
            r37 = 4
            r2[r37] = r27     // Catch:{ Exception -> 0x033c }
            r27 = 7
            byte r40 = r8[r27]     // Catch:{ Exception -> 0x033c }
            r32 = 5
            r2[r32] = r40     // Catch:{ Exception -> 0x033c }
            r7 = r2
            r13 = r7
            int r2 = r8.length     // Catch:{ Exception -> 0x033c }
            r0 = 8
            if (r2 <= r0) goto L_0x02c3
            r2 = 6
            byte[] r0 = new byte[r2]     // Catch:{ Exception -> 0x02bc }
            r2 = 8
            byte r41 = r8[r2]     // Catch:{ Exception -> 0x02bc }
            r2 = 0
            r0[r2] = r41     // Catch:{ Exception -> 0x02bc }
            r2 = 9
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x02bc }
            r25 = 1
            r0[r25] = r2     // Catch:{ Exception -> 0x02bc }
            r2 = 10
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x02bc }
            r34 = 2
            r0[r34] = r2     // Catch:{ Exception -> 0x02bc }
            r2 = 11
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x02bc }
            r38 = 3
            r0[r38] = r2     // Catch:{ Exception -> 0x02bc }
            r2 = 12
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x02bc }
            r37 = 4
            r0[r37] = r2     // Catch:{ Exception -> 0x02bc }
            r2 = 13
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x02bc }
            r32 = 5
            r0[r32] = r2     // Catch:{ Exception -> 0x02bc }
            r13 = r0
            goto L_0x02c3
        L_0x02bc:
            r0 = move-exception
            r2 = r26
            r25 = 1
            goto L_0x0349
        L_0x02c3:
            int r0 = r8.length     // Catch:{ Exception -> 0x033c }
            r2 = 18
            if (r0 != r2) goto L_0x02eb
            r0 = 4
            byte[] r2 = new byte[r0]     // Catch:{ Exception -> 0x02bc }
            r0 = 14
            byte r0 = r8[r0]     // Catch:{ Exception -> 0x02bc }
            r29 = 0
            r2[r29] = r0     // Catch:{ Exception -> 0x02bc }
            r0 = 15
            byte r0 = r8[r0]     // Catch:{ Exception -> 0x02bc }
            r25 = 1
            r2[r25] = r0     // Catch:{ Exception -> 0x02bc }
            byte r0 = r8[r24]     // Catch:{ Exception -> 0x02bc }
            r34 = 2
            r2[r34] = r0     // Catch:{ Exception -> 0x02bc }
            r0 = 17
            byte r0 = r8[r0]     // Catch:{ Exception -> 0x02bc }
            r38 = 3
            r2[r38] = r0     // Catch:{ Exception -> 0x02bc }
            r23 = r2
        L_0x02eb:
            int r0 = r8.length     // Catch:{ Exception -> 0x033c }
            r2 = 22
            if (r0 != r2) goto L_0x0333
            r0 = 8
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x033c }
            r2 = 14
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x033c }
            r29 = 0
            r0[r29] = r2     // Catch:{ Exception -> 0x033c }
            r2 = 15
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x033c }
            r25 = 1
            r0[r25] = r2     // Catch:{ Exception -> 0x033a }
            byte r2 = r8[r24]     // Catch:{ Exception -> 0x033a }
            r34 = 2
            r0[r34] = r2     // Catch:{ Exception -> 0x033a }
            r2 = 17
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x033a }
            r34 = 3
            r0[r34] = r2     // Catch:{ Exception -> 0x033a }
            r2 = 18
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x033a }
            r34 = 4
            r0[r34] = r2     // Catch:{ Exception -> 0x033a }
            r2 = 19
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x033a }
            r32 = 5
            r0[r32] = r2     // Catch:{ Exception -> 0x033a }
            r2 = 20
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x033a }
            r32 = 6
            r0[r32] = r2     // Catch:{ Exception -> 0x033a }
            r2 = 21
            byte r2 = r8[r2]     // Catch:{ Exception -> 0x033a }
            r0[r27] = r2     // Catch:{ Exception -> 0x033a }
            r23 = r0
            goto L_0x0335
        L_0x0333:
            r25 = 1
        L_0x0335:
            r2 = r23
            r0 = r26
            goto L_0x036f
        L_0x033a:
            r0 = move-exception
            goto L_0x033f
        L_0x033c:
            r0 = move-exception
            r25 = 1
        L_0x033f:
            r2 = r26
            goto L_0x0349
        L_0x0342:
            r0 = move-exception
            r26 = r2
            goto L_0x0349
        L_0x0346:
            r0 = move-exception
            r25 = 1
        L_0x0349:
            r26 = r0
            i.c.b r0 = f42927h
            r27 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r32 = r5
            java.lang.String r5 = "Malformed OPT answer. Option code: Owner data: "
            r2.append(r5)
            java.lang.String r5 = r1.m45226b(r8)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.mo44343b(r2)
            r2 = r23
            r0 = r27
            r5 = r32
        L_0x036f:
            i.c.b r23 = f42927h
            boolean r23 = r23.isDebugEnabled()
            if (r23 == 0) goto L_0x03e6
            r23 = r6
            i.c.b r6 = f42927h
            r26 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r27 = r12
            java.lang.String r12 = "Unhandled Owner OPT version: "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r12 = " sequence: "
            r8.append(r12)
            r8.append(r5)
            java.lang.String r12 = " MAC address: "
            r8.append(r12)
            java.lang.String r12 = r1.m45226b(r7)
            r8.append(r12)
            if (r13 == r7) goto L_0x03ba
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r32 = r0
            java.lang.String r0 = " wakeup MAC address: "
            r12.append(r0)
            java.lang.String r0 = r1.m45226b(r13)
            r12.append(r0)
            java.lang.String r0 = r12.toString()
            goto L_0x03be
        L_0x03ba:
            r32 = r0
            r0 = r31
        L_0x03be:
            r8.append(r0)
            if (r2 == 0) goto L_0x03d9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r12 = " password: "
            r0.append(r12)
            java.lang.String r12 = r1.m45226b(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            goto L_0x03db
        L_0x03d9:
            r0 = r31
        L_0x03db:
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r6.mo44340a(r0)
            goto L_0x03ee
        L_0x03e6:
            r32 = r0
            r23 = r6
            r26 = r8
            r27 = r12
        L_0x03ee:
            r28 = r2
            r23 = r5
            r26 = r7
            r0 = r32
        L_0x03f6:
            r12 = r27
            r2 = r31
            r6 = r33
            r7 = r35
            r8 = r36
            r5 = 0
            r27 = r13
            r13 = r39
            goto L_0x0101
        L_0x0407:
            r28 = r2
            r23 = r6
            r27 = r12
            r39 = r13
            i.c.b r0 = f42927h
            r0.mo44343b(r5)
            r12 = r9
            r21 = r10
            r3 = r27
            goto L_0x05cd
        L_0x041b:
            r35 = r7
            r36 = r8
            r27 = r12
            r39 = r13
            i.c.b r0 = f42927h
            r0.mo44343b(r5)
            r12 = r9
            r21 = r10
            r3 = r27
            goto L_0x05cd
        L_0x042f:
            r33 = r6
            r35 = r7
            r36 = r8
            r27 = r12
            r39 = r13
            r12 = r9
            r21 = r10
            r3 = r27
            goto L_0x05cd
        L_0x0440:
            r33 = r6
            r35 = r7
            r36 = r8
            r27 = r12
            r39 = r13
            i.c.b r0 = f42927h
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "There was an OPT answer. Wrong version number: "
            r2.append(r5)
            r2.append(r3)
            java.lang.String r5 = " result code: "
            r2.append(r5)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.mo44343b(r2)
            r12 = r9
            r21 = r10
            r3 = r27
            goto L_0x05cd
        L_0x046f:
            r31 = r2
            r27 = r12
            r39 = r13
            r0 = 0
            r12 = r0
            r2 = 0
            r13 = r2
            r17 = r2
            r18 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r8 = r2
            g.a.a.d$a r2 = r1.f42932m
            java.lang.String r2 = r2.mo43925b(r9)
            r8.append(r2)
            java.lang.String r2 = " "
            int r7 = r8.indexOf(r2)
            if (r7 <= 0) goto L_0x049a
            r2 = 0
            java.lang.String r2 = r8.substring(r2, r7)
            goto L_0x049e
        L_0x049a:
            java.lang.String r2 = r8.toString()
        L_0x049e:
            java.lang.String r19 = r2.trim()
            if (r7 <= 0) goto L_0x04ac
            int r2 = r7 + 1
            java.lang.String r2 = r8.substring(r2)
            r31 = r2
        L_0x04ac:
            java.lang.String r20 = r31.trim()
            g.a.a.j$b r21 = new g.a.a.j$b
            r2 = r21
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = r10
            r22 = r7
            r7 = r19
            r23 = r8
            r8 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r16 = r21
            r12 = r9
            r21 = r10
            r0 = r16
            r3 = r27
            goto L_0x05cf
        L_0x04ce:
            r27 = r12
            r39 = r13
            r0 = 0
            g.a.a.d$a r2 = r1.f42932m
            int r12 = r2.mo43927d()
            g.a.a.d$a r2 = r1.f42932m
            int r13 = r2.mo43927d()
            g.a.a.d$a r2 = r1.f42932m
            int r17 = r2.mo43927d()
            java.lang.String r2 = ""
            boolean r3 = f42928i
            if (r3 == 0) goto L_0x04f4
            g.a.a.d$a r3 = r1.f42932m
            java.lang.String r2 = r3.mo43922a()
            r18 = r2
            goto L_0x04fc
        L_0x04f4:
            g.a.a.d$a r3 = r1.f42932m
            java.lang.String r2 = r3.mo43924b()
            r18 = r2
        L_0x04fc:
            g.a.a.j$f r19 = new g.a.a.j$f
            r2 = r19
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = r10
            r7 = r12
            r8 = r13
            r20 = r12
            r12 = r9
            r9 = r17
            r21 = r10
            r10 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r16 = r19
            r0 = r16
            r3 = r27
            goto L_0x05cf
        L_0x051a:
            r21 = r10
            r27 = r12
            r39 = r13
            r12 = r9
            r0 = 0
            g.a.a.j$g r8 = new g.a.a.j$g
            g.a.a.d$a r2 = r1.f42932m
            byte[] r7 = r2.mo43923a(r12)
            r2 = r8
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = r21
            r2.<init>(r3, r4, r5, r6, r7)
            r16 = r8
            r0 = r16
            r3 = r27
            goto L_0x05cf
        L_0x053b:
            r21 = r10
            r27 = r12
            r39 = r13
            r12 = r9
            java.lang.String r0 = ""
            g.a.a.d$a r2 = r1.f42932m
            java.lang.String r0 = r2.mo43922a()
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0564
            g.a.a.j$e r8 = new g.a.a.j$e
            r2 = r8
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = r21
            r7 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r16 = r8
            r0 = r16
            r3 = r27
            goto L_0x05cf
        L_0x0564:
            i.c.b r2 = f42927h
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "PTR record of class: "
            r3.append(r4)
            r3.append(r14)
            java.lang.String r4 = ", there was a problem reading the service name of the answer for domain:"
            r3.append(r4)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r2.mo44343b(r3)
            r3 = r27
            goto L_0x05cd
        L_0x0585:
            r21 = r10
            r27 = r12
            r39 = r13
            r12 = r9
            g.a.a.j$d r0 = new g.a.a.j$d
            g.a.a.d$a r2 = r1.f42932m
            byte[] r7 = r2.mo43923a(r12)
            r2 = r0
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = r21
            r2.<init>(r3, r4, r5, r6, r7)
            r16 = r0
            r3 = r27
            goto L_0x05cf
        L_0x05a2:
            r21 = r10
            r27 = r12
            r39 = r13
            r12 = r9
            g.a.a.j$c r0 = new g.a.a.j$c
            g.a.a.d$a r2 = r1.f42932m
            byte[] r7 = r2.mo43923a(r12)
            r2 = r0
            r3 = r11
            r4 = r14
            r5 = r15
            r6 = r21
            r2.<init>(r3, r4, r5, r6, r7)
            r16 = r0
            r3 = r27
            goto L_0x05cf
        L_0x05bf:
            r17 = r0
            r18 = r2
            r19 = r3
            r3 = r27
        L_0x05c7:
            g.a.a.d$a r0 = r1.f42932m
            long r1 = (long) r12
            r0.skip(r1)
        L_0x05cd:
            r0 = r16
        L_0x05cf:
            if (r0 == 0) goto L_0x05d7
            r1 = r43
            r0.mo43980a(r1)
            goto L_0x05d9
        L_0x05d7:
            r1 = r43
        L_0x05d9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p346g.p347a.p356a.C14123d.m45225a(java.net.InetAddress):g.a.a.j");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo43916a(boolean dump) {
        StringBuilder buf = new StringBuilder();
        buf.append(mo43951t());
        if (dump) {
            byte[] data = new byte[this.f42930k.getLength()];
            System.arraycopy(this.f42930k.getData(), 0, data, 0, data.length);
            buf.append(mo43929a(data));
        }
        return buf.toString();
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(mo43947p() ? "dns[query," : "dns[response,");
        if (this.f42930k.getAddress() != null) {
            buf.append(this.f42930k.getAddress().getHostAddress());
        }
        buf.append(':');
        buf.append(this.f42930k.getPort());
        buf.append(", length=");
        buf.append(this.f42930k.getLength());
        buf.append(", id=0x");
        buf.append(Integer.toHexString(mo43937f()));
        if (mo43936e() != 0) {
            buf.append(", flags=0x");
            buf.append(Integer.toHexString(mo43936e()));
            if ((mo43936e() & Opcodes.ACC_MANDATED) != 0) {
                buf.append(":r");
            }
            if ((mo43936e() & Opcodes.ACC_ABSTRACT) != 0) {
                buf.append(":aa");
            }
            if ((mo43936e() & 512) != 0) {
                buf.append(":tc");
            }
        }
        if (mo43941j() > 0) {
            buf.append(", questions=");
            buf.append(mo43941j());
        }
        if (mo43939h() > 0) {
            buf.append(", answers=");
            buf.append(mo43939h());
        }
        if (mo43940i() > 0) {
            buf.append(", authorities=");
            buf.append(mo43940i());
        }
        if (mo43938g() > 0) {
            buf.append(", additionals=");
            buf.append(mo43938g());
        }
        String str = "\n\t";
        if (mo43941j() > 0) {
            buf.append("\nquestions:");
            for (C14130i question : this.f42939d) {
                buf.append(str);
                buf.append(question);
            }
        }
        if (mo43939h() > 0) {
            buf.append("\nanswers:");
            for (C14138j record : this.f42940e) {
                buf.append(str);
                buf.append(record);
            }
        }
        if (mo43940i() > 0) {
            buf.append("\nauthorities:");
            for (C14138j record2 : this.f42941f) {
                buf.append(str);
                buf.append(record2);
            }
        }
        if (mo43938g() > 0) {
            buf.append("\nadditionals:");
            for (C14138j record3 : this.f42942g) {
                buf.append(str);
                buf.append(record3);
            }
        }
        buf.append("]");
        return buf.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo43917a(C14123d that) {
        if (!mo43947p() || !mo43949r() || !that.mo43947p()) {
            throw new IllegalArgumentException();
        }
        this.f42939d.addAll(that.mo43943l());
        this.f42940e.addAll(that.mo43934c());
        this.f42941f.addAll(that.mo43935d());
        this.f42942g.addAll(that.mo43930a());
    }

    /* renamed from: u */
    public int mo43920u() {
        return (int) (System.currentTimeMillis() - this.f42931l);
    }

    /* renamed from: v */
    public int mo43921v() {
        return this.f42933n;
    }

    /* renamed from: b */
    private String m45226b(byte[] bytes) {
        StringBuilder result = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            int b2 = b & 255;
            result.append(f42929j[b2 / 16]);
            result.append(f42929j[b2 % 16]);
        }
        return result.toString();
    }
}
