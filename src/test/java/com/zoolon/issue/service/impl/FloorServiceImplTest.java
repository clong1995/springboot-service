package com.zoolon.issue.service.impl;

import com.zoolon.issue.vo.res.floor.BuildingFloorStoreVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FloorServiceImplTest {

    @Autowired
    private FloorServiceImpl floorService;

    @Test
    public void getAllBuildingFloor() {
        List<BuildingFloorStoreVo> buildingFloorStoreVoList = floorService.getAllBuildingFloor();
        log.debug(buildingFloorStoreVoList.toString());
    }

    @Test
    public void getFloorListByBuildingId() {
    }

    @Test
    public void getAllBuildingFloor1() {
    }

    @Test
    public void getFloorListByBuildingId1() {
    }
}