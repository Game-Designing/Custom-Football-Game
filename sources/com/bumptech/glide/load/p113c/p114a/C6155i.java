package com.bumptech.glide.load.p113c.p114a;

import android.util.Log;
import com.bumptech.glide.load.C6230e;
import com.bumptech.glide.load.C6230e.C6231a;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.p107h.C6024i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.load.c.a.i */
/* compiled from: DefaultImageHeaderParser */
public final class C6155i implements C6230e {

    /* renamed from: a */
    static final byte[] f10861a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b */
    private static final int[] f10862b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: com.bumptech.glide.load.c.a.i$a */
    /* compiled from: DefaultImageHeaderParser */
    private static final class C6156a implements C6158c {

        /* renamed from: a */
        private final ByteBuffer f10863a;

        C6156a(ByteBuffer byteBuffer) {
            this.f10863a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        /* renamed from: a */
        public int mo18983a() {
            return ((mo18985b() << 8) & 65280) | (mo18985b() & 255);
        }

        /* renamed from: c */
        public short mo18986c() {
            return (short) (mo18985b() & 255);
        }

        public long skip(long total) {
            int toSkip = (int) Math.min((long) this.f10863a.remaining(), total);
            ByteBuffer byteBuffer = this.f10863a;
            byteBuffer.position(byteBuffer.position() + toSkip);
            return (long) toSkip;
        }

        /* renamed from: a */
        public int mo18984a(byte[] buffer, int byteCount) {
            int toRead = Math.min(byteCount, this.f10863a.remaining());
            if (toRead == 0) {
                return -1;
            }
            this.f10863a.get(buffer, 0, toRead);
            return toRead;
        }

        /* renamed from: b */
        public int mo18985b() {
            if (this.f10863a.remaining() < 1) {
                return -1;
            }
            return this.f10863a.get();
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.i$b */
    /* compiled from: DefaultImageHeaderParser */
    private static final class C6157b {

        /* renamed from: a */
        private final ByteBuffer f10864a;

        C6157b(byte[] data, int length) {
            this.f10864a = (ByteBuffer) ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN).limit(length);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo18990a(ByteOrder byteOrder) {
            this.f10864a.order(byteOrder);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo18988a() {
            return this.f10864a.remaining();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo18991b(int offset) {
            if (m11646a(offset, 4)) {
                return this.f10864a.getInt(offset);
            }
            return -1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public short mo18989a(int offset) {
            if (m11646a(offset, 2)) {
                return this.f10864a.getShort(offset);
            }
            return -1;
        }

        /* renamed from: a */
        private boolean m11646a(int offset, int byteSize) {
            return this.f10864a.remaining() - offset >= byteSize;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.i$c */
    /* compiled from: DefaultImageHeaderParser */
    private interface C6158c {
        /* renamed from: a */
        int mo18983a() throws IOException;

        /* renamed from: a */
        int mo18984a(byte[] bArr, int i) throws IOException;

        /* renamed from: b */
        int mo18985b() throws IOException;

        /* renamed from: c */
        short mo18986c() throws IOException;

        long skip(long j) throws IOException;
    }

    /* renamed from: com.bumptech.glide.load.c.a.i$d */
    /* compiled from: DefaultImageHeaderParser */
    private static final class C6159d implements C6158c {

        /* renamed from: a */
        private final InputStream f10865a;

        C6159d(InputStream is) {
            this.f10865a = is;
        }

        /* renamed from: a */
        public int mo18983a() throws IOException {
            return ((this.f10865a.read() << 8) & 65280) | (this.f10865a.read() & 255);
        }

        /* renamed from: c */
        public short mo18986c() throws IOException {
            return (short) (this.f10865a.read() & 255);
        }

        public long skip(long total) throws IOException {
            if (total < 0) {
                return 0;
            }
            long toSkip = total;
            while (toSkip > 0) {
                long skipped = this.f10865a.skip(toSkip);
                if (skipped > 0) {
                    toSkip -= skipped;
                } else if (this.f10865a.read() == -1) {
                    break;
                } else {
                    toSkip--;
                }
            }
            return total - toSkip;
        }

        /* renamed from: a */
        public int mo18984a(byte[] buffer, int byteCount) throws IOException {
            int toRead = byteCount;
            while (toRead > 0) {
                int read = this.f10865a.read(buffer, byteCount - toRead, toRead);
                int read2 = read;
                if (read == -1) {
                    break;
                }
                toRead -= read2;
            }
            return byteCount - toRead;
        }

        /* renamed from: b */
        public int mo18985b() throws IOException {
            return this.f10865a.read();
        }
    }

    /* renamed from: a */
    public C6231a mo18981a(InputStream is) throws IOException {
        C6024i.m11264a(is);
        return m11635a((C6158c) new C6159d(is));
    }

    /* renamed from: a */
    public C6231a mo18982a(ByteBuffer byteBuffer) throws IOException {
        C6024i.m11264a(byteBuffer);
        return m11635a((C6158c) new C6156a(byteBuffer));
    }

    /* renamed from: a */
    public int mo18980a(InputStream is, C6245b byteArrayPool) throws IOException {
        C6024i.m11264a(is);
        C6159d dVar = new C6159d(is);
        C6024i.m11264a(byteArrayPool);
        return m11633a((C6158c) dVar, byteArrayPool);
    }

    /* renamed from: a */
    private C6231a m11635a(C6158c reader) throws IOException {
        int firstTwoBytes = reader.mo18983a();
        if (firstTwoBytes == 65496) {
            return C6231a.JPEG;
        }
        int firstFourBytes = ((firstTwoBytes << 16) & -65536) | (reader.mo18983a() & 65535);
        if (firstFourBytes == -1991225785) {
            reader.skip(21);
            return reader.mo18985b() >= 3 ? C6231a.PNG_A : C6231a.PNG;
        } else if ((firstFourBytes >> 8) == 4671814) {
            return C6231a.GIF;
        } else {
            if (firstFourBytes != 1380533830) {
                return C6231a.UNKNOWN;
            }
            reader.skip(4);
            if ((((reader.mo18983a() << 16) & -65536) | (reader.mo18983a() & 65535)) != 1464156752) {
                return C6231a.UNKNOWN;
            }
            int fourthFourBytes = (-65536 & (reader.mo18983a() << 16)) | (65535 & reader.mo18983a());
            if ((fourthFourBytes & -256) != 1448097792) {
                return C6231a.UNKNOWN;
            }
            if ((fourthFourBytes & 255) == 88) {
                reader.skip(4);
                return (reader.mo18985b() & 16) != 0 ? C6231a.WEBP_A : C6231a.WEBP;
            } else if ((fourthFourBytes & 255) != 76) {
                return C6231a.WEBP;
            } else {
                reader.skip(4);
                return (reader.mo18985b() & 8) != 0 ? C6231a.WEBP_A : C6231a.WEBP;
            }
        }
    }

    /* renamed from: a */
    private int m11633a(C6158c reader, C6245b byteArrayPool) throws IOException {
        int magicNumber = reader.mo18983a();
        String str = "DfltImageHeaderParser";
        if (!m11636a(magicNumber)) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Parser doesn't handle magic number: ");
                sb.append(magicNumber);
                Log.d(str, sb.toString());
            }
            return -1;
        }
        int exifSegmentLength = m11638b(reader);
        if (exifSegmentLength == -1) {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] exifData = (byte[]) byteArrayPool.mo19127a(exifSegmentLength, byte[].class);
        try {
            return m11634a(reader, exifData, exifSegmentLength);
        } finally {
            byteArrayPool.put(exifData);
        }
    }

    /* renamed from: a */
    private int m11634a(C6158c reader, byte[] tempArray, int exifSegmentLength) throws IOException {
        int read = reader.mo18984a(tempArray, exifSegmentLength);
        String str = "DfltImageHeaderParser";
        if (read != exifSegmentLength) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(exifSegmentLength);
                sb.append(", actually read: ");
                sb.append(read);
                Log.d(str, sb.toString());
            }
            return -1;
        } else if (m11637a(tempArray, exifSegmentLength)) {
            return m11632a(new C6157b(tempArray, exifSegmentLength));
        } else {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    /* renamed from: a */
    private boolean m11637a(byte[] exifData, int exifSegmentLength) {
        boolean result = exifData != null && exifSegmentLength > f10861a.length;
        if (!result) {
            return result;
        }
        int i = 0;
        while (true) {
            byte[] bArr = f10861a;
            if (i >= bArr.length) {
                return result;
            }
            if (exifData[i] != bArr[i]) {
                return false;
            }
            i++;
        }
    }

    /* renamed from: b */
    private int m11638b(C6158c reader) throws IOException {
        String str;
        short segmentType;
        int segmentLength;
        long skipped;
        do {
            short segmentId = reader.mo18986c();
            str = "DfltImageHeaderParser";
            if (segmentId != 255) {
                if (Log.isLoggable(str, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append(segmentId);
                    Log.d(str, sb.toString());
                }
                return -1;
            }
            segmentType = reader.mo18986c();
            if (segmentType == 218) {
                return -1;
            }
            if (segmentType == 217) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            segmentLength = reader.mo18983a() - 2;
            if (segmentType == 225) {
                return segmentLength;
            }
            skipped = reader.skip((long) segmentLength);
        } while (skipped == ((long) segmentLength));
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append(segmentType);
            sb2.append(", wanted to skip: ");
            sb2.append(segmentLength);
            sb2.append(", but actually skipped: ");
            sb2.append(skipped);
            Log.d(str, sb2.toString());
        }
        return -1;
    }

    /* renamed from: a */
    private static int m11632a(C6157b segmentData) {
        ByteOrder byteOrder;
        C6157b bVar = segmentData;
        int headerOffsetSize = "Exif\u0000\u0000".length();
        short byteOrderIdentifier = bVar.mo18989a(headerOffsetSize);
        int i = 3;
        String str = "DfltImageHeaderParser";
        if (byteOrderIdentifier == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (byteOrderIdentifier != 19789) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown endianness = ");
                sb.append(byteOrderIdentifier);
                Log.d(str, sb.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.mo18990a(byteOrder);
        int firstIfdOffset = bVar.mo18991b(headerOffsetSize + 4) + headerOffsetSize;
        int tagCount = bVar.mo18989a(firstIfdOffset);
        int i2 = 0;
        while (i2 < tagCount) {
            int tagOffset = m11631a(firstIfdOffset, i2);
            int tagType = bVar.mo18989a(tagOffset);
            if (tagType == 274) {
                int formatCode = bVar.mo18989a(tagOffset + 2);
                if (formatCode >= 1 && formatCode <= 12) {
                    int componentCount = bVar.mo18991b(tagOffset + 4);
                    if (componentCount >= 0) {
                        String str2 = " tagType=";
                        if (Log.isLoggable(str, i)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Got tagIndex=");
                            sb2.append(i2);
                            sb2.append(str2);
                            sb2.append(tagType);
                            sb2.append(" formatCode=");
                            sb2.append(formatCode);
                            sb2.append(" componentCount=");
                            sb2.append(componentCount);
                            Log.d(str, sb2.toString());
                        }
                        int byteCount = f10862b[formatCode] + componentCount;
                        if (byteCount <= 4) {
                            int tagValueOffset = tagOffset + 8;
                            if (tagValueOffset < 0 || tagValueOffset > segmentData.mo18988a()) {
                                if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Illegal tagValueOffset=");
                                    sb3.append(tagValueOffset);
                                    sb3.append(str2);
                                    sb3.append(tagType);
                                    Log.d(str, sb3.toString());
                                }
                            } else if (byteCount >= 0 && tagValueOffset + byteCount <= segmentData.mo18988a()) {
                                return bVar.mo18989a(tagValueOffset);
                            } else {
                                if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append(tagType);
                                    Log.d(str, sb4.toString());
                                }
                            }
                        } else if (Log.isLoggable(str, i)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb5.append(formatCode);
                            Log.d(str, sb5.toString());
                        }
                    } else if (Log.isLoggable(str, i)) {
                        Log.d(str, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(str, 3)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Got invalid format code = ");
                    sb6.append(formatCode);
                    Log.d(str, sb6.toString());
                }
            }
            i2++;
            i = 3;
            bVar = segmentData;
        }
        return -1;
    }

    /* renamed from: a */
    private static int m11631a(int ifdOffset, int tagIndex) {
        return ifdOffset + 2 + (tagIndex * 12);
    }

    /* renamed from: a */
    private static boolean m11636a(int imageMagicNumber) {
        return (imageMagicNumber & 65496) == 65496 || imageMagicNumber == 19789 || imageMagicNumber == 18761;
    }
}
