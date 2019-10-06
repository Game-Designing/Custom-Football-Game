package p005cm.aptoide.p006pt.util;

import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p002b.p003c.p053g.p061f.C1259h;
import p005cm.aptoide.p006pt.comments.CommentNode;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Comment.Parent;

/* renamed from: cm.aptoide.pt.util.CommentOperations */
public class CommentOperations {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-16563476092402316L, "cm/aptoide/pt/util/CommentOperations", 34);
        $jacocoData = probes;
        return probes;
    }

    public CommentOperations() {
        $jacocoInit()[0] = true;
    }

    public List<CommentNode> flattenByDepth(List<CommentNode> comments) {
        boolean[] $jacocoInit = $jacocoInit();
        List<CommentNode> sortedByDepthComments = new LinkedList<>();
        $jacocoInit[1] = true;
        Stack<CommentNode> commentStack = new Stack<>();
        $jacocoInit[2] = true;
        commentStack.addAll(comments);
        $jacocoInit[3] = true;
        while (!commentStack.isEmpty()) {
            $jacocoInit[4] = true;
            CommentNode commentNode = (CommentNode) commentStack.pop();
            $jacocoInit[5] = true;
            sortedByDepthComments.add(commentNode);
            $jacocoInit[6] = true;
            if (!commentNode.hasChild()) {
                $jacocoInit[7] = true;
            } else {
                $jacocoInit[8] = true;
                $jacocoInit[9] = true;
                for (CommentNode node : commentNode.getChildComments()) {
                    $jacocoInit[11] = true;
                    node.setLevel(commentNode.getLevel() + 1);
                    $jacocoInit[12] = true;
                    commentStack.push(node);
                    $jacocoInit[13] = true;
                }
                $jacocoInit[10] = true;
            }
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
        return sortedByDepthComments;
    }

    public List<CommentNode> transform(List<Comment> list) {
        boolean[] $jacocoInit = $jacocoInit();
        LongSparseArray<CommentNode> commentMap = new C1259h<>();
        $jacocoInit[16] = true;
        $jacocoInit[17] = true;
        for (Comment comment : list) {
            $jacocoInit[18] = true;
            Parent commentParent = comment.getParent();
            if (commentParent != null) {
                $jacocoInit[19] = true;
                CommentNode commentNode = (CommentNode) commentMap.mo9058b(commentParent.getId());
                if (commentNode != null) {
                    $jacocoInit[20] = true;
                } else {
                    $jacocoInit[21] = true;
                    commentNode = new CommentNode();
                    $jacocoInit[22] = true;
                }
                commentNode.addChild(new CommentNode(comment));
                $jacocoInit[23] = true;
                commentMap.mo9056a(commentParent.getId(), commentNode);
                $jacocoInit[24] = true;
            } else {
                CommentNode commentNode2 = (CommentNode) commentMap.mo9058b(comment.getId());
                if (commentNode2 == null) {
                    $jacocoInit[25] = true;
                    commentMap.mo9056a(comment.getId(), new CommentNode(comment));
                    $jacocoInit[26] = true;
                } else {
                    commentNode2.setComment(comment);
                    $jacocoInit[27] = true;
                }
            }
            $jacocoInit[28] = true;
        }
        ArrayList<CommentNode> commentNodes = new ArrayList<>(commentMap.mo9057b());
        $jacocoInit[29] = true;
        int i = 0;
        $jacocoInit[30] = true;
        while (i < commentMap.mo9057b()) {
            $jacocoInit[31] = true;
            commentNodes.add(commentMap.mo9062c(i));
            i++;
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
        return commentNodes;
    }
}
