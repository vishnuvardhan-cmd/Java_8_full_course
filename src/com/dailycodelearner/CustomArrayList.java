package com.dailycodelearner;

import java.util.ArrayList;

public class CustomArrayList extends ArrayList  {

    @Override
    public boolean add(Object o){
//        if(this.contains(o)){
//            return true;
//        }
//        else{
            return super.add(o);
//        }
    }
    public static void main(String a[]){
        CustomArrayList c=new CustomArrayList();
        c.add(1);
        c.add(1);
        c.add(1);
        c.add(2);
        System.out.println(c);
    }
}
