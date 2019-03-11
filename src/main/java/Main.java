import tgdh.TreeGroupDiffieHellman;
import tgdh.tree.*;

public class Main {
    public static void main(String[] args){

        LeafNode M1 = new LeafNode("M1");
        LeafNode M2 = new LeafNode("M2");
        LeafNode M3 = new LeafNode("M3");
        LeafNode M4 = new LeafNode("M4");

        Node[] nodes = new Node[]{
                new Node(), new Node(), M1, M2, new Node(), M3, M4};

        TreeInfo tinfo = new TreeInfo(
                nodes, TreeInfo.PREORDER,
                "M1");
        // build the tree
        BasicTree atree = new BasicTree(tinfo);
        Tree tre = new Tree(tinfo);
        //expected tree
        String expectedTree = "Preorder: <0,0>, <1,0>, <2,0>(M1), <2,1>(M2), <1,1>, <2,2>(M3), <2,3>(M4)";
        System.out.println(tre.height());
    }
}
