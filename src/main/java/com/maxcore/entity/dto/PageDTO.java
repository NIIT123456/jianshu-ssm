package com.maxcore.entity.dto;

import lombok.Data;

import java.util.List;
@Data
public class PageDTO {
    private Integer total;
    private List list;
}
