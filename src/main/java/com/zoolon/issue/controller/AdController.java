package com.zoolon.issue.controller;

import com.zoolon.issue.domain.one.Ad;
import com.zoolon.issue.po.one.ad.AdAllPo;
import com.zoolon.issue.result.ResultJson;
import com.zoolon.issue.service.AdService;
import com.zoolon.issue.vo.param.ad.AddParam;
import com.zoolon.issue.vo.param.ad.ByIdParam;
import com.zoolon.issue.vo.param.ad.ByIdsParam;
import com.zoolon.issue.vo.param.ad.UpdateParam;
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

@Api(description = "广告接口")
@RestController
@RequestMapping("/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @ApiOperation(
            value = "根据id获取广告",
            notes = "根据id获取广告"
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
    private ResultJson getAdById(@RequestBody @Valid ByIdParam byIdParam) {
        Ad ad = adService.getAdById(byIdParam);
        return ResultJson.ok(ad);
    }

    @ApiOperation(
            value = "添加广告",
            notes = "添加广告"
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
    private ResultJson addAd(@RequestBody @Valid AddParam addParam) {
        adService.addAd(addParam);
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
    private ResultJson getAdAll() {
        List<AdAllPo> adList = adService.getAdAll();
        return ResultJson.ok(adList);
    }

    @ApiOperation(
            value = "根据id删除",
            notes = "根据id删除"
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
    private ResultJson delAdByIds(@RequestBody @Valid ByIdsParam byIdsParam) {
        String[] idList = byIdsParam.getIds().split(",");
        adService.delAdByIds(idList);
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
    private ResultJson updateAdById(@RequestBody @Valid UpdateParam updateParam) {
        adService.updateAdById(updateParam);
        return ResultJson.ok();
    }
}