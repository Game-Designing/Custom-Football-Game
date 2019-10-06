package org.jacoco.agent.p025rt.internal_8ff85ea.core.internal.flow;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.internal.flow.Instruction */
public class Instruction {
    private int branches = 0;
    private int coveredBranches = 0;
    private final int line;
    private Instruction predecessor;

    public Instruction(int line2) {
        this.line = line2;
    }

    public void addBranch() {
        this.branches++;
    }

    public void setPredecessor(Instruction predecessor2) {
        this.predecessor = predecessor2;
        predecessor2.addBranch();
    }

    public void setCovered() {
        Instruction i = this;
        while (i != null) {
            int i2 = i.coveredBranches;
            i.coveredBranches = i2 + 1;
            if (i2 == 0) {
                i = i.predecessor;
            } else {
                return;
            }
        }
    }

    public int getLine() {
        return this.line;
    }

    public int getBranches() {
        return this.branches;
    }

    public int getCoveredBranches() {
        return this.coveredBranches;
    }
}
