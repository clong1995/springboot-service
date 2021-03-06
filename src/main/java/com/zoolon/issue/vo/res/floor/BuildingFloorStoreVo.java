package com.zoolon.issue.vo.res.floor;

import com.zoolon.issue.po.one.floor.FloorPo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class BuildingFloorStoreVo {
    private Integer id;
    private String name;
    private Integer sort;
    private ArrayList<FloorPo> floorList = new ArrayList<>();
}
