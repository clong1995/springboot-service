package com.zoolon.issue.domain.one;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Advert {
    private Integer id;
    private String name;
    private String position;
    private Integer building;
    private Integer floor;
    private Integer width;
    private Integer height;
    private String ip;
    private Integer devType;
    private String devName;
    private String remark;
    private String mac;
    private Integer open;
    private Integer ad;
    private Integer danger;
}
