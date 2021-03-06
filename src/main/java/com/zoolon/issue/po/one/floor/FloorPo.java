package com.zoolon.issue.po.one.floor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;

@Getter
@Setter
@ToString
public class FloorPo {
    private Integer id;
    private String name;
    private Integer sort;
}