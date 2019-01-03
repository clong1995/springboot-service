package com.zoolon.issue.service;

import com.zoolon.issue.vo.res.floor.BuildingFloorStoreVo;
import com.zoolon.issue.po.one.floor.FloorPo;

import java.util.List;

public interface FloorService {
    /**
     * 获取建筑楼层列表信息
     *
     * @return
     */
    List<BuildingFloorStoreVo> getAllBuildingFloor();

    List<FloorPo> getFloorListByBuildingId(Integer id);
}