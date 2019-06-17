package com.example.demo.common.page;

import lombok.Data;

@Data
public class Page<T> {




    private int pageNum;

    private int pageSize;

    private T t;
}
