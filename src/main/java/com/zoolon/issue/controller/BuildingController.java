package com.zoolon.issue.controller;

import com.zoolon.issue.domain.one.Building;
import com.zoolon.issue.result.ResultJson;
import com.zoolon.issue.service.BuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(description = "设备接口")
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    /**
     * 获取所有的楼
     */
    @ApiOperation(
            value = "获取所有的楼",
            notes = "获取所有的楼"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "Authorization token",
                    required = true,
                    dataType = "string",
                    paramType = "header"
            )
    })
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    private ResultJson getAllBuilding() {
        List<Building> buildingList = buildingService.getAllBuilding();
        return ResultJson.ok(buildingList);
    }
}