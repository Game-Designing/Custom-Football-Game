package org.jacoco.agent.p025rt.internal_8ff85ea.core.data;

import java.util.Arrays;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.ExecutionData */
public final class ExecutionData {

    /* renamed from: id */
    private final long f150id;
    private final String name;
    private final boolean[] probes;

    public ExecutionData(long id, String name2, boolean[] probes2) {
        this.f150id = id;
        this.name = name2;
        this.probes = probes2;
    }

    public ExecutionData(long id, String name2, int probeCount) {
        this.f150id = id;
        this.name = name2;
        this.probes = new boolean[probeCount];
    }

    public long getId() {
        return this.f150id;
    }

    public String getName() {
        return this.name;
    }

    public boolean[] getProbes() {
        return this.probes;
    }

    public void reset() {
        Arrays.fill(this.probes, false);
    }

    public boolean hasHits() {
        for (boolean p : this.probes) {
            if (p) {
                return true;
            }
        }
        return false;
    }

    public void merge(ExecutionData other) {
        merge(other, true);
    }

    public void merge(ExecutionData other, boolean flag) {
        assertCompatibility(other.getId(), other.getName(), other.getProbes().length);
        boolean[] otherData = other.getProbes();
        int i = 0;
        while (true) {
            boolean[] zArr = this.probes;
            if (i < zArr.length) {
                if (otherData[i]) {
                    zArr[i] = flag;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public void assertCompatibility(long id, String name2, int probecount) throws IllegalStateException {
        long j = this.f150id;
        if (j != id) {
            throw new IllegalStateException(String.format("Different ids (%016x and %016x).", new Object[]{Long.valueOf(j), Long.valueOf(id)}));
        } else if (!this.name.equals(name2)) {
            throw new IllegalStateException(String.format("Different class names %s and %s for id %016x.", new Object[]{this.name, name2, Long.valueOf(id)}));
        } else if (this.probes.length != probecount) {
            throw new IllegalStateException(String.format("Incompatible execution data for class %s with id %016x.", new Object[]{name2, Long.valueOf(id)}));
        }
    }

    public String toString() {
        return String.format("ExecutionData[name=%s, id=%016x]", new Object[]{this.name, Long.valueOf(this.f150id)});
    }
}
