package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.ConnectedMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.ProgressMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.RetryMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.WarnMessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot.StartedMessageSnapshot;

/* renamed from: com.liulishuo.filedownloader.message.c */
/* compiled from: MessageSnapshot */
class C10903c implements Creator<MessageSnapshot> {
    C10903c() {
    }

    public MessageSnapshot createFromParcel(Parcel source) {
        MessageSnapshot snapshot;
        boolean largeFile = source.readByte() == 1;
        byte status = source.readByte();
        if (status != -4) {
            if (status != -3) {
                if (status != -1) {
                    if (status != 1) {
                        if (status != 2) {
                            if (status != 3) {
                                if (status != 5) {
                                    if (status != 6) {
                                        snapshot = null;
                                    } else {
                                        snapshot = new StartedMessageSnapshot(source);
                                    }
                                } else if (largeFile) {
                                    snapshot = new RetryMessageSnapshot(source);
                                } else {
                                    snapshot = new SmallMessageSnapshot.RetryMessageSnapshot(source);
                                }
                            } else if (largeFile) {
                                snapshot = new ProgressMessageSnapshot(source);
                            } else {
                                snapshot = new SmallMessageSnapshot.ProgressMessageSnapshot(source);
                            }
                        } else if (largeFile) {
                            snapshot = new ConnectedMessageSnapshot(source);
                        } else {
                            snapshot = new SmallMessageSnapshot.ConnectedMessageSnapshot(source);
                        }
                    } else if (largeFile) {
                        snapshot = new PendingMessageSnapshot(source);
                    } else {
                        snapshot = new SmallMessageSnapshot.PendingMessageSnapshot(source);
                    }
                } else if (largeFile) {
                    snapshot = new ErrorMessageSnapshot(source);
                } else {
                    snapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(source);
                }
            } else if (largeFile) {
                snapshot = new CompletedSnapshot(source);
            } else {
                snapshot = new SmallMessageSnapshot.CompletedSnapshot(source);
            }
        } else if (largeFile) {
            snapshot = new WarnMessageSnapshot(source);
        } else {
            snapshot = new SmallMessageSnapshot.WarnMessageSnapshot(source);
        }
        if (snapshot != null) {
            snapshot.f33313b = largeFile;
            return snapshot;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't restore the snapshot because unknow status: ");
        sb.append(status);
        throw new IllegalStateException(sb.toString());
    }

    public MessageSnapshot[] newArray(int size) {
        return new MessageSnapshot[size];
    }
}
