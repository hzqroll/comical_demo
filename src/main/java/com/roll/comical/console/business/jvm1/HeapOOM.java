package com.roll.comical.console.business.jvm1;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject{}
    public static void main(String[] args){
        List<OOMObject> lists = new ArrayList<>();
        while (true){
            lists.add(new OOMObject());
        }
    }
}
