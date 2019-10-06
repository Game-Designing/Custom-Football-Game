package org.jacoco.agent.p025rt.internal_8ff85ea.core.data;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.SessionInfo */
public class SessionInfo implements Comparable<SessionInfo> {
    private final long dump;

    /* renamed from: id */
    private final String f152id;
    private final long start;

    public SessionInfo(String id, long start2, long dump2) {
        if (id != null) {
            this.f152id = id;
            this.start = start2;
            this.dump = dump2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getId() {
        return this.f152id;
    }

    public long getStartTimeStamp() {
        return this.start;
    }

    public long getDumpTimeStamp() {
        return this.dump;
    }

    public int compareTo(SessionInfo other) {
        long j = this.dump;
        long j2 = other.dump;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SessionInfo[");
        sb.append(this.f152id);
        sb.append("]");
        return sb.toString();
    }
}
