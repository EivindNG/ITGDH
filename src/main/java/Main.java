
import tgdh.TgdhException;
import tgdh.TgdhGroupIdentifier;
import tgdh.TreeGroupDiffieHellman;
import tgdh.crypto.TgdhKeySpec;
import tgdh.tree.*;

public class Main {
    public static void main(String[] args) throws TgdhException {
        TgdhKeySpec specs = new TgdhKeySpec();
        LeafNode M1 = new LeafNode("M1");
        LeafNode M2 = new LeafNode("M2");
        LeafNode M3 = new LeafNode("M3");

        TreeGroupDiffieHellman test = new TreeGroupDiffieHellman();
        test.newGroup();

        Node[] nodes = new Node[]{
                new Node(), new Node(), M1, M2, M3};

        TreeInfo tinfo = new TreeInfo(
                nodes, TreeInfo.PREORDER,
                "M1");

        // build the tree
        BasicTree atree = new BasicTree(tinfo);
        Tree tre = new Tree(tinfo);
        //expected tree
        System.out.println("tre");
        System.out.println(tre);

        TreeInfo sponsor = (TreeInfo) tre.join(new LeafNode("M4"));

        System.out.println(tre);

        System.out.println();
    }
}
