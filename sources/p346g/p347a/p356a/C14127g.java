package p346g.p347a.p356a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: g.a.a.g */
/* compiled from: DNSOutgoing */
public final class C14127g extends C14126f {

    /* renamed from: h */
    public static boolean f42943h = true;

    /* renamed from: i */
    Map<String, Integer> f42944i;

    /* renamed from: j */
    private int f42945j;

    /* renamed from: k */
    private final C14128a f42946k;

    /* renamed from: l */
    private final C14128a f42947l;

    /* renamed from: m */
    private final C14128a f42948m;

    /* renamed from: n */
    private final C14128a f42949n;

    /* renamed from: o */
    private InetSocketAddress f42950o;

    /* renamed from: g.a.a.g$a */
    /* compiled from: DNSOutgoing */
    public static class C14128a extends ByteArrayOutputStream {

        /* renamed from: a */
        private final C14127g f42951a;

        /* renamed from: b */
        private final int f42952b;

        C14128a(int size, C14127g out) {
            this(size, out, 0);
        }

        C14128a(int size, C14127g out, int offset) {
            super(size);
            this.f42951a = out;
            this.f42952b = offset;
        }

        /* access modifiers changed from: 0000 */
        public void writeByte(int value) {
            write(value & 255);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43967a(byte[] data, int off, int len) {
            for (int i = 0; i < len; i++) {
                writeByte(data[off + i]);
            }
        }

        /* access modifiers changed from: 0000 */
        public void writeShort(int value) {
            writeByte(value >> 8);
            writeByte(value);
        }

        /* access modifiers changed from: 0000 */
        public void writeInt(int value) {
            writeShort(value >> 16);
            writeShort(value);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43965a(String str, int off, int len) {
            int utflen = 0;
            for (int i = 0; i < len; i++) {
                int ch = str.charAt(off + i);
                if (ch >= 1 && ch <= 127) {
                    utflen++;
                } else if (ch > 2047) {
                    utflen += 3;
                } else {
                    utflen += 2;
                }
            }
            writeByte(utflen);
            for (int i2 = 0; i2 < len; i2++) {
                int ch2 = str.charAt(off + i2);
                if (ch2 >= 1 && ch2 <= 127) {
                    writeByte(ch2);
                } else if (ch2 > 2047) {
                    writeByte(((ch2 >> 12) & 15) | 224);
                    writeByte(((ch2 >> 6) & 63) | 128);
                    writeByte(((ch2 >> 0) & 63) | 128);
                } else {
                    writeByte(((ch2 >> 6) & 31) | Opcodes.CHECKCAST);
                    writeByte(((ch2 >> 0) & 63) | 128);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43964a(String name) {
            mo43966a(name, true);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43966a(String name, boolean useCompression) {
            String aName = name;
            while (true) {
                int n = aName.indexOf(46);
                if (n < 0) {
                    n = aName.length();
                }
                if (n <= 0) {
                    writeByte(0);
                    return;
                }
                String label = aName.substring(0, n);
                if (!useCompression || !C14127g.f42943h) {
                    mo43965a(label, 0, label.length());
                } else {
                    Integer offset = (Integer) this.f42951a.f42944i.get(aName);
                    if (offset != null) {
                        int val = offset.intValue();
                        writeByte((val >> 8) | Opcodes.CHECKCAST);
                        writeByte(val & 255);
                        return;
                    }
                    this.f42951a.f42944i.put(aName, Integer.valueOf(size() + this.f42952b));
                    mo43965a(label, 0, label.length());
                }
                aName = aName.substring(n);
                if (aName.startsWith(".")) {
                    aName = aName.substring(1);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43962a(C14130i question) {
            mo43964a(question.mo43856b());
            writeShort(question.mo43862e().mo43835e());
            writeShort(question.mo43860d().mo43833e());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo43963a(C14138j rec, long now) {
            mo43964a(rec.mo43856b());
            writeShort(rec.mo43862e().mo43835e());
            writeShort(rec.mo43860d().mo43833e() | ((!rec.mo43871k() || !this.f42951a.mo43946o()) ? 0 : Opcodes.ACC_MANDATED));
            writeInt(now == 0 ? rec.mo43993q() : rec.mo43983b(now));
            C14128a record = new C14128a(512, this.f42951a, this.f42952b + size() + 2);
            rec.mo43978a(record);
            byte[] byteArray = record.toByteArray();
            writeShort(byteArray.length);
            write(byteArray, 0, byteArray.length);
        }
    }

    public C14127g(int flags) {
        this(flags, true, 1460);
    }

    public C14127g(int flags, boolean multicast, int senderUDPPayload) {
        super(flags, 0, multicast);
        this.f42944i = new HashMap();
        this.f42945j = senderUDPPayload > 0 ? senderUDPPayload : 1460;
        this.f42946k = new C14128a(senderUDPPayload, this);
        this.f42947l = new C14128a(senderUDPPayload, this);
        this.f42948m = new C14128a(senderUDPPayload, this);
        this.f42949n = new C14128a(senderUDPPayload, this);
    }

    /* renamed from: w */
    public InetSocketAddress mo43960w() {
        return this.f42950o;
    }

    /* renamed from: a */
    public void mo43956a(InetSocketAddress destination) {
        this.f42950o = destination;
    }

    /* renamed from: u */
    public int mo43958u() {
        return ((((this.f42945j - 12) - this.f42946k.size()) - this.f42947l.size()) - this.f42948m.size()) - this.f42949n.size();
    }

    /* renamed from: a */
    public void mo43953a(C14130i rec) throws IOException {
        C14128a record = new C14128a(512, this);
        record.mo43962a(rec);
        byte[] byteArray = record.toByteArray();
        record.close();
        if (byteArray.length < mo43958u()) {
            this.f42939d.add(rec);
            this.f42946k.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    /* renamed from: a */
    public void mo43952a(C14123d in, C14138j rec) throws IOException {
        if (in == null || !rec.mo43981a(in)) {
            mo43955a(rec, 0);
        }
    }

    /* renamed from: a */
    public void mo43955a(C14138j rec, long now) throws IOException {
        if (rec == null) {
            return;
        }
        if (now == 0 || !rec.mo43853a(now)) {
            C14128a record = new C14128a(512, this);
            record.mo43963a(rec, now);
            byte[] byteArray = record.toByteArray();
            record.close();
            if (byteArray.length < mo43958u()) {
                this.f42940e.add(rec);
                this.f42947l.write(byteArray, 0, byteArray.length);
                return;
            }
            throw new IOException("message full");
        }
    }

    /* renamed from: a */
    public void mo43954a(C14138j rec) throws IOException {
        C14128a record = new C14128a(512, this);
        record.mo43963a(rec, 0);
        byte[] byteArray = record.toByteArray();
        record.close();
        if (byteArray.length < mo43958u()) {
            this.f42941f.add(rec);
            this.f42948m.write(byteArray, 0, byteArray.length);
            return;
        }
        throw new IOException("message full");
    }

    /* renamed from: v */
    public byte[] mo43959v() {
        long now = System.currentTimeMillis();
        this.f42944i.clear();
        C14128a message = new C14128a(this.f42945j, this);
        message.writeShort(this.f42937b ? 0 : mo43937f());
        message.writeShort(mo43936e());
        message.writeShort(mo43941j());
        message.writeShort(mo43939h());
        message.writeShort(mo43940i());
        message.writeShort(mo43938g());
        for (C14130i question : this.f42939d) {
            message.mo43962a(question);
        }
        for (C14138j record : this.f42940e) {
            message.mo43963a(record, now);
        }
        for (C14138j record2 : this.f42941f) {
            message.mo43963a(record2, now);
        }
        for (C14138j record3 : this.f42942g) {
            message.mo43963a(record3, now);
        }
        byte[] result = message.toByteArray();
        try {
            message.close();
        } catch (IOException e) {
        }
        return result;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(mo43947p() ? "dns[query:" : "dns[response:");
        buf.append(" id=0x");
        buf.append(Integer.toHexString(mo43937f()));
        if (mo43936e() != 0) {
            buf.append(", flags=0x");
            buf.append(Integer.toHexString(mo43936e()));
            if (mo43948q()) {
                buf.append(":r");
            }
            if (mo43944m()) {
                buf.append(":aa");
            }
            if (mo43949r()) {
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
        buf.append("\nnames=");
        buf.append(this.f42944i);
        buf.append("]");
        return buf.toString();
    }

    /* renamed from: x */
    public int mo43961x() {
        return this.f42945j;
    }
}
