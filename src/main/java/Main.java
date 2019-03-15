
import tgdh.TgdhException;
import tgdh.TgdhGroupIdentifier;
import tgdh.TreeGroupDiffieHellman;
import tgdh.crypto.TgdhKeySpec;
import tgdh.tree.*;

import java.io.NotSerializableException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws TgdhException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NotSerializableException {
        Random random = new Random();

        LeafNode M1 = new LeafNode("M1");
        Node[] nodes = new Node[]{M1};

        TgdhKeySpec keyParams = new TgdhKeySpec(new BigInteger(2048, 99, random),
                new BigInteger(256, 99, random),new BigInteger(128, random));

        TreeInfo tinfo = new TreeInfo(
                nodes, TreeInfo.PREORDER,
                "M1",keyParams);

        // build the tree

        Tree tre = new Tree(tinfo);
        //expected tree
        System.out.println("tre");
        System.out.println(tre);
        tre.genOwnerKeyPair();

        LeafNode M2 = LeafNodeaddKeys.addKeys(new LeafNode("M2"),keyParams);


        TreeInfo info = (TreeInfo) tre.join(M2);
    }
}
