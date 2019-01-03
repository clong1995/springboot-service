package com.zoolon.issue.controller;

import com.zoolon.issue.domain.one.Danger;
import com.zoolon.issue.po.one.danger.DangerPo;
import com.zoolon.issue.result.ResultJson;
import com.zoolon.issue.service.DangerService;
import com.zoolon.issue.vo.param.danger.AddParam;
import com.zoolon.issue.vo.param.danger.ByIdParam;
import com.zoolon.issue.vo.param.danger.ByIdsParam;
import com.zoolon.issue.vo.param.danger.UpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(description = "设备接口")
@RestController
@RequestMapping("/danger")
public class DangerController {
    @Autowired
    private DangerService dangerService;

    @ApiOperation(
            value = "根据id获取紧急",
            notes = "根据id获取紧急"
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
    @RequestMapping(value = "/byId", method = RequestMethod.POST)
    private ResultJson getDangerById(@RequestBody @Valid ByIdParam byIdParam) {
        Danger danger = dangerService.getDangerById(byIdParam);
        return ResultJson.ok(danger);
    }

    @ApiOperation(
            value = "添加紧急",
            notes = "添加紧急"
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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private ResultJson addDanger(@RequestBody @Valid AddParam addParam) {
        dangerService.addDanger(addParam);
        return ResultJson.ok();
    }

    @ApiOperation(
            value = "获取所有",
            notes = "获取所有"
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
    private ResultJson getDangerAll() {
        List<DangerPo> dangerList = dangerService.getDangerAll();
        return ResultJson.ok(dangerList);
    }

    @ApiOperation(
            value = "删除",
            notes = "删除"
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
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    private ResultJson delDangerByIds(@RequestBody @Valid ByIdsParam byIdsParam) {
        String[] idList = byIdsParam.getIds().split(",");
        dangerService.delDangerByIds(idList);
        return ResultJson.ok();
    }

    @ApiOperation(
            value = "更新",
            notes = "更新"
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
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private ResultJson updateDangerById(@RequestBody @Valid UpdateParam updateParam) {
        dangerService.updateDangerById(updateParam);
        return ResultJson.ok();
    }


}