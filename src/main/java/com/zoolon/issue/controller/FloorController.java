package com.zoolon.issue.controller;

import com.zoolon.issue.result.ResultJson;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/floor")
public class FloorController {
    //@Autowired
    //private FloorService floorService;

    /**
     * 获取全部楼层
     */
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    @ApiOperation(
            value = "获取楼层",
            notes = "获取楼层"
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
    private ResultJson getAllBuildingFloor() {
        //List<BuildingFloorStoreVo> buildingFloorStoreVoList = floorService.getAllBuildingFloor();
        //return Result.success(buildingFloorStoreVoList);
        return ResultJson.ok("floor/all");
    }
    /*
     *//**
     * 根据楼获取楼层
     *//*
    @RequestMapping(value = "/byBuildingId", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> getFloorListByBuildingId(@RequestBody @Valid BuildingVo buildingVo) {
        List<Floor> floorList = floorService.getFloorListByBuildingId(buildingVo.getId());
        return Result.success(floorList);
    }*/
}