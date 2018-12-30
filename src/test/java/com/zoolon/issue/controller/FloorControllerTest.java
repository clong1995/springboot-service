package com.zoolon.issue.controller;

import com.zoolon.issue.result.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class FloorControllerTest {

    @Autowired
    private FloorController floorController;
    @Test
    public void getAllBuildingFloor() {
        ResultJson resultJson = floorController.getAllBuildingFloor();
        log.debug(resultJson.toString());
    }
}