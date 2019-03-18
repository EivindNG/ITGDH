package util;

import entities.AbstractEntity;

import java.math.BigInteger;
import java.security.PublicKey;
import java.util.HashMap;

public class EntityList {

    static HashMap<AbstractEntity, BigInteger> EntityList = new HashMap<>();

    public static HashMap<AbstractEntity, BigInteger> getEntityList() {
        return EntityList;
    }
}