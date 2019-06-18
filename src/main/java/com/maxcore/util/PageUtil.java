package com.maxcore.util;

import com.maxcore.entity.dto.PageDTO;

import java.util.List;

public class PageUtil {
    public static List pageDemo(Integer currentPage, Integer pageSize, List list) {
        Integer curr = 1;
        Integer size = 10;
        if (currentPage != null) {
            curr = currentPage;
        }
        if (pageSize!= null) {
            size = pageSize;
        }
        Integer first=(curr-1)*size;
        Integer last=curr*size;
        int listSize = list.size();
        if (last>listSize){
            last=listSize;
        }
        return list.subList(first, last);
    }

}
