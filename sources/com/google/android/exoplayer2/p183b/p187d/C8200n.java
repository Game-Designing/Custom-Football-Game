package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.b.d.n */
/* compiled from: VorbisUtil */
final class C8200n {

    /* renamed from: com.google.android.exoplayer2.b.d.n$a */
    /* compiled from: VorbisUtil */
    public static final class C8201a {

        /* renamed from: a */
        public final int f17117a;

        /* renamed from: b */
        public final int f17118b;

        /* renamed from: c */
        public final long[] f17119c;

        /* renamed from: d */
        public final int f17120d;

        /* renamed from: e */
        public final boolean f17121e;

        public C8201a(int dimensions, int entries, long[] lengthMap, int lookupType, boolean isOrdered) {
            this.f17117a = dimensions;
            this.f17118b = entries;
            this.f17119c = lengthMap;
            this.f17120d = lookupType;
            this.f17121e = isOrdered;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.d.n$b */
    /* compiled from: VorbisUtil */
    public static final class C8202b {

        /* renamed from: a */
        public final String f17122a;

        /* renamed from: b */
        public final String[] f17123b;

        /* renamed from: c */
        public final int f17124c;

        public C8202b(String vendor, String[] comments, int length) {
            this.f17122a = vendor;
            this.f17123b = comments;
            this.f17124c = length;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.d.n$c */
    /* compiled from: VorbisUtil */
    public static final class C8203c {

        /* renamed from: a */
        public final boolean f17125a;

        /* renamed from: b */
        public final int f17126b;

        /* renamed from: c */
        public final int f17127c;

        /* renamed from: d */
        public final int f17128d;

        public C8203c(boolean blockFlag, int windowType, int transformType, int mapping) {
            this.f17125a = blockFlag;
            this.f17126b = windowType;
            this.f17127c = transformType;
            this.f17128d = mapping;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.d.n$d */
    /* compiled from: VorbisUtil */
    public static final class C8204d {

        /* renamed from: a */
        public final long f17129a;

        /* renamed from: b */
        public final int f17130b;

        /* renamed from: c */
        public final long f17131c;

        /* renamed from: d */
        public final int f17132d;

        /* renamed from: e */
        public final int f17133e;

        /* renamed from: f */
        public final int f17134f;

        /* renamed from: g */
        public final int f17135g;

        /* renamed from: h */
        public final int f17136h;

        /* renamed from: i */
        public final boolean f17137i;

        /* renamed from: j */
        public final byte[] f17138j;

        public C8204d(long version, int channels, long sampleRate, int bitrateMax, int bitrateNominal, int bitrateMin, int blockSize0, int blockSize1, boolean framingFlag, byte[] data) {
            this.f17129a = version;
            this.f17130b = channels;
            this.f17131c = sampleRate;
            this.f17132d = bitrateMax;
            this.f17133e = bitrateNominal;
            this.f17134f = bitrateMin;
            this.f17135g = blockSize0;
            this.f17136h = blockSize1;
            this.f17137i = framingFlag;
            this.f17138j = data;
        }
    }

    /* renamed from: a */
    public static int m18877a(int x) {
        int val = 0;
        while (x > 0) {
            val++;
            x >>>= 1;
        }
        return val;
    }

    /* renamed from: b */
    public static C8204d m18884b(C8535t headerData) throws ParserException {
        C8535t tVar = headerData;
        m18882a(1, tVar, false);
        long version = headerData.mo26124j();
        int channels = headerData.mo26131q();
        long sampleRate = headerData.mo26124j();
        int bitrateMax = headerData.mo26122h();
        int bitrateNominal = headerData.mo26122h();
        int bitrateMin = headerData.mo26122h();
        int blockSize = headerData.mo26131q();
        int blockSize0 = (int) Math.pow(2.0d, (double) (blockSize & 15));
        int i = blockSize0;
        int i2 = blockSize;
        C8204d dVar = new C8204d(version, channels, sampleRate, bitrateMax, bitrateNominal, bitrateMin, blockSize0, (int) Math.pow(2.0d, (double) ((blockSize & 240) >> 4)), (headerData.mo26131q() & 1) > 0, Arrays.copyOf(tVar.f18861a, headerData.mo26115d()));
        return dVar;
    }

    /* renamed from: a */
    public static C8202b m18880a(C8535t headerData) throws ParserException {
        m18882a(3, headerData, false);
        int length = 7 + 4;
        String vendor = headerData.mo26112b((int) headerData.mo26124j());
        int length2 = length + vendor.length();
        long commentListLen = headerData.mo26124j();
        String[] comments = new String[((int) commentListLen)];
        int length3 = length2 + 4;
        for (int i = 0; ((long) i) < commentListLen; i++) {
            int length4 = length3 + 4;
            comments[i] = headerData.mo26112b((int) headerData.mo26124j());
            length3 = length4 + comments[i].length();
        }
        if ((headerData.mo26131q() & 1) != 0) {
            return new C8202b(vendor, comments, length3 + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    /* renamed from: a */
    public static boolean m18882a(int headerType, C8535t header, boolean quiet) throws ParserException {
        if (header.mo26104a() < 7) {
            if (quiet) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("too short header: ");
            sb.append(header.mo26104a());
            throw new ParserException(sb.toString());
        } else if (header.mo26131q() != headerType) {
            if (quiet) {
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("expected header type ");
            sb2.append(Integer.toHexString(headerType));
            throw new ParserException(sb2.toString());
        } else if (header.mo26131q() == 118 && header.mo26131q() == 111 && header.mo26131q() == 114 && header.mo26131q() == 98 && header.mo26131q() == 105 && header.mo26131q() == 115) {
            return true;
        } else {
            if (quiet) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }

    /* renamed from: a */
    public static C8203c[] m18883a(C8535t headerData, int channels) throws ParserException {
        m18882a(5, headerData, false);
        int numberOfBooks = headerData.mo26131q() + 1;
        C8197l bitArray = new C8197l(headerData.f18861a);
        bitArray.mo25282b(headerData.mo26113c() * 8);
        for (int i = 0; i < numberOfBooks; i++) {
            m18879a(bitArray);
        }
        int timeCount = bitArray.mo25281a(6) + 1;
        int i2 = 0;
        while (i2 < timeCount) {
            if (bitArray.mo25281a(16) == 0) {
                i2++;
            } else {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        m18885b(bitArray);
        m18887d(bitArray);
        m18881a(channels, bitArray);
        C8203c[] modes = m18886c(bitArray);
        if (bitArray.mo25283b()) {
            return modes;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    /* renamed from: c */
    private static C8203c[] m18886c(C8197l bitArray) {
        int modeCount = bitArray.mo25281a(6) + 1;
        C8203c[] modes = new C8203c[modeCount];
        for (int i = 0; i < modeCount; i++) {
            modes[i] = new C8203c(bitArray.mo25283b(), bitArray.mo25281a(16), bitArray.mo25281a(16), bitArray.mo25281a(8));
        }
        return modes;
    }

    /* renamed from: a */
    private static void m18881a(int channels, C8197l bitArray) throws ParserException {
        int submaps;
        int mappingsCount = bitArray.mo25281a(6) + 1;
        for (int i = 0; i < mappingsCount; i++) {
            int mappingType = bitArray.mo25281a(16);
            if (mappingType != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("mapping type other than 0 not supported: ");
                sb.append(mappingType);
                C8526n.m20531b("VorbisUtil", sb.toString());
            } else {
                if (bitArray.mo25283b()) {
                    submaps = bitArray.mo25281a(4) + 1;
                } else {
                    submaps = 1;
                }
                if (bitArray.mo25283b()) {
                    int couplingSteps = bitArray.mo25281a(8) + 1;
                    for (int j = 0; j < couplingSteps; j++) {
                        bitArray.mo25282b(m18877a(channels - 1));
                        bitArray.mo25282b(m18877a(channels - 1));
                    }
                }
                if (bitArray.mo25281a(2) == 0) {
                    if (submaps > 1) {
                        for (int j2 = 0; j2 < channels; j2++) {
                            bitArray.mo25282b(4);
                        }
                    }
                    for (int j3 = 0; j3 < submaps; j3++) {
                        bitArray.mo25282b(8);
                        bitArray.mo25282b(8);
                        bitArray.mo25282b(8);
                    }
                } else {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    /* renamed from: d */
    private static void m18887d(C8197l bitArray) throws ParserException {
        int residueCount = bitArray.mo25281a(6) + 1;
        int i = 0;
        while (i < residueCount) {
            if (bitArray.mo25281a(16) <= 2) {
                bitArray.mo25282b(24);
                bitArray.mo25282b(24);
                bitArray.mo25282b(24);
                int classifications = bitArray.mo25281a(6) + 1;
                bitArray.mo25282b(8);
                int[] cascade = new int[classifications];
                for (int j = 0; j < classifications; j++) {
                    int highBits = 0;
                    int lowBits = bitArray.mo25281a(3);
                    if (bitArray.mo25283b()) {
                        highBits = bitArray.mo25281a(5);
                    }
                    cascade[j] = (highBits * 8) + lowBits;
                }
                for (int j2 = 0; j2 < classifications; j2++) {
                    for (int k = 0; k < 8; k++) {
                        if ((cascade[j2] & (1 << k)) != 0) {
                            bitArray.mo25282b(8);
                        }
                    }
                }
                i++;
            } else {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
        }
    }

    /* renamed from: b */
    private static void m18885b(C8197l bitArray) throws ParserException {
        int floorCount = bitArray.mo25281a(6) + 1;
        for (int i = 0; i < floorCount; i++) {
            int floorType = bitArray.mo25281a(16);
            if (floorType == 0) {
                bitArray.mo25282b(8);
                bitArray.mo25282b(16);
                bitArray.mo25282b(16);
                bitArray.mo25282b(6);
                bitArray.mo25282b(8);
                int floorNumberOfBooks = bitArray.mo25281a(4) + 1;
                for (int j = 0; j < floorNumberOfBooks; j++) {
                    bitArray.mo25282b(8);
                }
            } else if (floorType == 1) {
                int partitions = bitArray.mo25281a(5);
                int maximumClass = -1;
                int[] partitionClassList = new int[partitions];
                for (int j2 = 0; j2 < partitions; j2++) {
                    partitionClassList[j2] = bitArray.mo25281a(4);
                    if (partitionClassList[j2] > maximumClass) {
                        maximumClass = partitionClassList[j2];
                    }
                }
                int[] classDimensions = new int[(maximumClass + 1)];
                for (int j3 = 0; j3 < classDimensions.length; j3++) {
                    classDimensions[j3] = bitArray.mo25281a(3) + 1;
                    int classSubclasses = bitArray.mo25281a(2);
                    if (classSubclasses > 0) {
                        bitArray.mo25282b(8);
                    }
                    for (int k = 0; k < (1 << classSubclasses); k++) {
                        bitArray.mo25282b(8);
                    }
                }
                bitArray.mo25282b(2);
                int rangeBits = bitArray.mo25281a(4);
                int count = 0;
                int k2 = 0;
                for (int j4 = 0; j4 < partitions; j4++) {
                    count += classDimensions[partitionClassList[j4]];
                    while (k2 < count) {
                        bitArray.mo25282b(rangeBits);
                        k2++;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("floor type greater than 1 not decodable: ");
                sb.append(floorType);
                throw new ParserException(sb.toString());
            }
        }
    }

    /* renamed from: a */
    private static C8201a m18879a(C8197l bitArray) throws ParserException {
        long lookupValuesCount;
        if (bitArray.mo25281a(24) == 5653314) {
            int dimensions = bitArray.mo25281a(16);
            int entries = bitArray.mo25281a(24);
            long[] lengthMap = new long[entries];
            boolean isOrdered = bitArray.mo25283b();
            if (!isOrdered) {
                boolean isSparse = bitArray.mo25283b();
                for (int i = 0; i < lengthMap.length; i++) {
                    if (!isSparse) {
                        lengthMap[i] = (long) (bitArray.mo25281a(5) + 1);
                    } else if (bitArray.mo25283b()) {
                        lengthMap[i] = (long) (bitArray.mo25281a(5) + 1);
                    } else {
                        lengthMap[i] = 0;
                    }
                }
            } else {
                int length = bitArray.mo25281a(5) + 1;
                int i2 = 0;
                while (i2 < lengthMap.length) {
                    int num = bitArray.mo25281a(m18877a(entries - i2));
                    for (int j = 0; j < num && i2 < lengthMap.length; j++) {
                        lengthMap[i2] = (long) length;
                        i2++;
                    }
                    length++;
                }
            }
            int lookupType = bitArray.mo25281a(4);
            if (lookupType <= 2) {
                if (lookupType == 1 || lookupType == 2) {
                    bitArray.mo25282b(32);
                    bitArray.mo25282b(32);
                    int valueBits = bitArray.mo25281a(4) + 1;
                    bitArray.mo25282b(1);
                    if (lookupType != 1) {
                        lookupValuesCount = ((long) entries) * ((long) dimensions);
                    } else if (dimensions != 0) {
                        lookupValuesCount = m18878a((long) entries, (long) dimensions);
                    } else {
                        lookupValuesCount = 0;
                    }
                    bitArray.mo25282b((int) (((long) valueBits) * lookupValuesCount));
                }
                C8201a aVar = new C8201a(dimensions, entries, lengthMap, lookupType, isOrdered);
                return aVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("lookup type greater than 2 not decodable: ");
            sb.append(lookupType);
            throw new ParserException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected code book to start with [0x56, 0x43, 0x42] at ");
        sb2.append(bitArray.mo25280a());
        throw new ParserException(sb2.toString());
    }

    /* renamed from: a */
    private static long m18878a(long entries, long dimension) {
        double d = (double) entries;
        double d2 = (double) dimension;
        Double.isNaN(d2);
        return (long) Math.floor(Math.pow(d, 1.0d / d2));
    }
}
