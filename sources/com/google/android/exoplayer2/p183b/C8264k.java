package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.b.k */
/* compiled from: GaplessInfoHolder */
public final class C8264k {

    /* renamed from: a */
    private static final Pattern f17492a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: b */
    public int f17493b = -1;

    /* renamed from: c */
    public int f17494c = -1;

    /* renamed from: a */
    public boolean mo25355a(int value) {
        int encoderDelay = value >> 12;
        int encoderPadding = value & 4095;
        if (encoderDelay <= 0 && encoderPadding <= 0) {
            return false;
        }
        this.f17493b = encoderDelay;
        this.f17494c = encoderPadding;
        return true;
    }

    /* renamed from: a */
    public boolean mo25356a(Metadata metadata) {
        for (int i = 0; i < metadata.mo25541a(); i++) {
            Entry entry = metadata.mo25542a(i);
            String str = "iTunSMPB";
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (str.equals(commentFrame.f18089c) && m19186a(commentFrame.f18090d)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.f18096b) && str.equals(internalFrame.f18097c) && m19186a(internalFrame.f18098d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m19186a(String data) {
        Matcher matcher = f17492a.matcher(data);
        if (matcher.find()) {
            try {
                int encoderDelay = Integer.parseInt(matcher.group(1), 16);
                int encoderPadding = Integer.parseInt(matcher.group(2), 16);
                if (encoderDelay <= 0) {
                    if (encoderPadding > 0) {
                    }
                }
                this.f17493b = encoderDelay;
                this.f17494c = encoderPadding;
                return true;
            } catch (NumberFormatException e) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo25354a() {
        return (this.f17493b == -1 || this.f17494c == -1) ? false : true;
    }
}
