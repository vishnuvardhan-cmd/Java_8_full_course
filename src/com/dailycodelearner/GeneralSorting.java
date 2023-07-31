package com.dailycodelearner;

import lombok.NoArgsConstructor;

import java.util.Comparator;
@NoArgsConstructor
public class GeneralSorting implements Comparator<Book> {



    @Override
    public int compare(Book o1, Book o2) {
        return o2.getId()-(o1.getId());
    }
}
