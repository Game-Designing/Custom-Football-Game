package org.jacoco.agent.p025rt.internal_8ff85ea.core.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.ExecutionDataStore */
public final class ExecutionDataStore implements IExecutionDataVisitor {
    private final Map<Long, ExecutionData> entries = new HashMap();
    private final Set<String> names = new HashSet();

    public void put(ExecutionData data) throws IllegalStateException {
        Long id = Long.valueOf(data.getId());
        ExecutionData entry = (ExecutionData) this.entries.get(id);
        if (entry == null) {
            this.entries.put(id, data);
            this.names.add(data.getName());
            return;
        }
        entry.merge(data);
    }

    public void subtract(ExecutionData data) throws IllegalStateException {
        ExecutionData entry = (ExecutionData) this.entries.get(Long.valueOf(data.getId()));
        if (entry != null) {
            entry.merge(data, false);
        }
    }

    public void subtract(ExecutionDataStore store) {
        for (ExecutionData data : store.getContents()) {
            subtract(data);
        }
    }

    public ExecutionData get(long id) {
        return (ExecutionData) this.entries.get(Long.valueOf(id));
    }

    public boolean contains(String name) {
        return this.names.contains(name);
    }

    public ExecutionData get(Long id, String name, int probecount) {
        ExecutionData entry = (ExecutionData) this.entries.get(id);
        if (entry == null) {
            ExecutionData entry2 = new ExecutionData(id.longValue(), name, probecount);
            this.entries.put(id, entry2);
            this.names.add(name);
            return entry2;
        }
        entry.assertCompatibility(id.longValue(), name, probecount);
        return entry;
    }

    public void reset() {
        for (ExecutionData executionData : this.entries.values()) {
            executionData.reset();
        }
    }

    public Collection<ExecutionData> getContents() {
        return new ArrayList(this.entries.values());
    }

    public void accept(IExecutionDataVisitor visitor) {
        for (ExecutionData data : getContents()) {
            visitor.visitClassExecution(data);
        }
    }

    public void visitClassExecution(ExecutionData data) {
        put(data);
    }
}
