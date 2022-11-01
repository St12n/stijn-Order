package com.stijn.order.domain.exceptions;

public class NoSuchItemInShop extends IllegalArgumentException{
    public NoSuchItemInShop() {
        super("There is no such item in the shop available.");
    }
}
