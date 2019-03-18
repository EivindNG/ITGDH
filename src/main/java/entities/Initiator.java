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
        int i=1;
        for (AbstractEntity  entity: EntityList.getEntityList().keySet()) {

            if (entity instanceof Responder) {

                Responder responder = (Responder) entity;
                responder.joinShareTree(i);
                i+=1;
            }
        }
    }
    public void EncryptFileandKeys(){

    }
}
