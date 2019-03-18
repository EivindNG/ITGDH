package entities;

import tgdh.tree.LeafNode;

import java.math.BigInteger;
import java.security.PublicKey;

public abstract class AbstractEntity {
    protected BigInteger id;
    protected LeafNode leafNode;

    public BigInteger getId() {
        return id;
    }

    public LeafNode getLeafNode() {
        return leafNode;
    }
}