package com.zoolon.issue.po.one.building;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BuildingFloorPo {
    private Integer buildingId;
    private String buildingName;
    private Integer buildingSort;
    private Integer floorId;
    private String floorName;
    private Integer floorSort;
}
