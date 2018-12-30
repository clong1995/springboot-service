package com.zoolon.issue.service.impl;


import com.zoolon.issue.dao.one.FloorDao;
import com.zoolon.issue.po.one.BuildingFloorPo;
import com.zoolon.issue.vo.res.floor.BuildingFloorStoreVo;
import com.zoolon.issue.po.one.FloorPo;
import com.zoolon.issue.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorDao floorDao;

    @Override
    public List<BuildingFloorStoreVo> getAllBuildingFloor() {
        List<BuildingFloorStoreVo> buildingFloorStoreVoList = new ArrayList<>();
        List<BuildingFloorPo> buildingFloorDtoList = floorDao.queryAllBuildingFloor();

        for (BuildingFloorPo buildingFloorDto : buildingFloorDtoList) {
            //楼
            if (buildingFloorStoreVoList.isEmpty() || !buildingFloorStoreVoList.get(buildingFloorStoreVoList.size() - 1).getId().equals(buildingFloorDto.getBuildingId())) {
                BuildingFloorStoreVo buildingFloorStoreVo = new BuildingFloorStoreVo();
                buildingFloorStoreVo.setId(buildingFloorDto.getBuildingId());
                buildingFloorStoreVo.setName(buildingFloorDto.getBuildingName());
                buildingFloorStoreVo.setSort(buildingFloorDto.getBuildingSort());
                buildingFloorStoreVoList.add(buildingFloorStoreVo);
            }
            //层
            FloorPo floor = new FloorPo();
            floor.setId(buildingFloorDto.getFloorId());
            floor.setName(buildingFloorDto.getFloorName());
            floor.setSort(buildingFloorDto.getFloorSort());
            //组装
            buildingFloorStoreVoList.get(buildingFloorStoreVoList.size() - 1).getFloorList().add(floor);
        }

        return buildingFloorStoreVoList;
    }

    @Override
    public List<FloorPo> getFloorListByBuildingId(Integer id) {
        return floorDao.queryFloorListByBuildingId(id);
    }
}