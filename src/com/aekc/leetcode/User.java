package com.aekc.leetcode;

import java.util.List;

/**
 * @author Twilight
 * @date 18-9-21 下午4:58
 */
public class User<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
