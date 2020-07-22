package com.example.demo.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class ListResult<T> {

    protected List<T> content;

    protected int totalElements;

    public ListResult(List<T> content) {
        this.content = content;
        this.totalElements = content.size();
    }

}
