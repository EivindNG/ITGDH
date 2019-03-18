package entities;

import crypto.Constants;
import tgdh.TgdhException;
import tgdh.tree.*;
import util.EntityList;
import util.IdMaker;
import util.LeafNodeaddKeys;
import util.Treet;

import java.io.NotSerializableException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Initiator extends AbstractEntity{



    public Initiator() throws
            InvalidAlgorithmParameterException,
            NoSuchAlgorithmException,
            NotSerializableException,
            TgdhException {

        this.id = IdMaker.getNextId();
        this.leafNode = LeafNodeaddKeys.addKeys(new LeafNode(this.id.toString()),Constants.KEY_PARAMS);
        EntityList.getEntityList().put(this,this.id);
    }

    public Tree InitializeTree() throws
            TgdhException {

        Node[] nodes = new Node[]{this.leafNode};

        TreeInfo tinfo = new TreeInfo(
                nodes, TreeInfo.PREORDER,
                this.id.toString(), Constants.KEY_PARAMS);

        return new Tree(tinfo);
    }

    public void ShareKey() throws TgdhException {
        for (AbstractEntity  entity: EntityList.getEntityList().keySet()) {

            if (entity instanceof Responder) {

                Responder responder = (Responder) entity;
                responder.joinShareTree();
            }
        /*
        ArrayList<Integer> noderPosisjon = new ArrayList<Integer>();
        noderPosisjon.add(Treet.getTre().getRoot().getPosition());

        for (AbstractEntity  entity: EntityList.getEntityList().keySet()){
            int position = noderPosisjon.get(0)+1;
            System.out.println(position);
            if (entity instanceof Responder){

                Responder responder = (Responder) entity;
                LeafNode coordinate = responder.joinShareTree(position);
                noderPosisjon.add(coordinate.getParent().getLeft().getPosition());
                noderPosisjon.add(coordinate.getPosition());
                noderPosisjon.remove(0);
                System.out.println(noderPosisjon);
            }

            else {
                continue;
            }
        }
        */
        }
    }
    public void EncryptFileandKeys(){

    }
}
