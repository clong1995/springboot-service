package com.zoolon.issue.dao.one;

import com.zoolon.issue.po.one.BuildingFloorPo;
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
public class FloorDaoTest {
    @Autowired
    private FloorDao floorDao;

    @Test
    public void queryAllBuildingFloor() {
        List<BuildingFloorPo> buildingFloorPoList = floorDao.queryAllBuildingFloor();
        log.info("buildingFloorPoList {}",buildingFloorPoList);
    }
}