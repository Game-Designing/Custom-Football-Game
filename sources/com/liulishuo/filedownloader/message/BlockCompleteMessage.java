package com.liulishuo.filedownloader.message;

import junit.framework.Assert;
import p019d.p307j.p308a.p313e.C13121g;

public interface BlockCompleteMessage {

    public static class BlockCompleteMessageImpl extends MessageSnapshot implements BlockCompleteMessage {

        /* renamed from: c */
        private final MessageSnapshot f33299c;

        public BlockCompleteMessageImpl(MessageSnapshot snapshot) {
            super(snapshot.mo35701e());
            boolean z = false;
            String a = C13121g.m42792a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(snapshot.mo35701e()), Byte.valueOf(snapshot.mo35687k()));
            if (snapshot.mo35687k() == -3) {
                z = true;
            }
            Assert.assertTrue(a, z);
            this.f33299c = snapshot;
        }

        /* renamed from: b */
        public MessageSnapshot mo35686b() {
            return this.f33299c;
        }

        /* renamed from: k */
        public byte mo35687k() {
            return 4;
        }
    }

    /* renamed from: b */
    MessageSnapshot mo35686b();
}
