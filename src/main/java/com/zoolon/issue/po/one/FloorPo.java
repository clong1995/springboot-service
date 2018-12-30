package com.zoolon.issue.po.one;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;

@Getter
@Setter
public class FloorPo {
    private Integer id;
    private String name;
    private Integer sort;
}