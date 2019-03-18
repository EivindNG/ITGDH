package entities;

import crypto.Constants;
import tgdh.TgdhException;
import tgdh.tree.LeafNode;
import util.EntityList;
import util.IdMaker;
import util.LeafNodeaddKeys;
import util.Treet;

import java.io.NotSerializableException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;

public class Responder extends AbstractEntity {

    public Responder() throws
            InvalidAlgorithmParameterException,
            NoSuchAlgorithmException,
            NotSerializableException {

        this.id = IdMaker.getNextId();
        this.leafNode = LeafNodeaddKeys.addKeys(new LeafNode(this.id.toString()), Constants.KEY_PARAMS);
        EntityList.getEntityList().put(this,this.id);
    }

    public void joinShareTree() throws
            TgdhException
    {
            System.out.println(Treet.getTre().getOwner().getPosition());
            Treet.getTre().join(this.leafNode, Treet.getTre().getOwner().getPosition());



    }
}
