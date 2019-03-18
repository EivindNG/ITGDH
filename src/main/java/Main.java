
import crypto.Constants;
import entities.Initiator;
import entities.Responder;
import tgdh.TgdhException;
import tgdh.tree.*;
import util.LeafNodeaddKeys;
import util.Treet;

import java.io.NotSerializableException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws TgdhException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NotSerializableException {

        Initiator test= new Initiator();


        ArrayList<Responder> responderList= new ArrayList<Responder>();

        for(int i=0; i < 5; i++){

            responderList.add(new Responder());
        }
        // build the tree

        Tree tre = test.InitializeTree();
        Treet.setTre(tre);

        test.ShareKey();
        //expected tree
        System.out.println("tre");
        System.out.println(tre);
        System.out.println(Treet.getTre().getOwner());






    }
}
