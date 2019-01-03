package com.zoolon.issue.controller;

import com.zoolon.issue.domain.one.Advert;
import com.zoolon.issue.po.one.advert.AdvertDataPo;
import com.zoolon.issue.po.one.advert.AdvertDevPo;
import com.zoolon.issue.po.one.advert.AdvertPo;
import com.zoolon.issue.result.ResultJson;
import com.zoolon.issue.service.AdvertService;
import com.zoolon.issue.vo.param.advert.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "设备接口")
@RestController
@RequestMapping("/advert")
public class AdvertController {
    @Autowired
    private AdvertService advertService;

    /**
     * 获取所有的区域信息
     *
     * @return
     */
    @ApiOperation(
            value = "添加设备",
            notes = "添加设备"
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
    private ResultJson addAdvert(@RequestBody @Valid AddParam addParam) {
        Integer integer = advertService.addAdvert(addParam);
        return ResultJson.ok(integer);
    }

    //更新
    @ApiOperation(
            value = "更新设备",
            notes = "更新设备"
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
    private ResultJson updateAdvert(@RequestBody @Valid UpdateParam updateParam) {
        advertService.updateAdvert(updateParam);
        return ResultJson.ok();
    }

    //更新
    @ApiOperation(
            value = "根据id获取设备",
            notes = "根据id获取设备"
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
    @ResponseBody
    private ResultJson getAdvertById(@RequestBody @Valid ByIdParam byIdParam) {
        Advert advert = advertService.getAdvertById(byIdParam);
        return ResultJson.ok(advert);
    }

    @ApiOperation(
            value = "根据id获取设备数据",
            notes = "根据id获取设备数据"
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
    @RequestMapping(value = "/dataById", method = RequestMethod.POST)
    @ResponseBody
    private ResultJson getAdvertDataById(@RequestBody @Valid ByIdParam byIdParam) {
        AdvertDataPo advertDataPo = advertService.getAdvertDataById(byIdParam);
        return ResultJson.ok(advertDataPo);
    }

    @ApiOperation(
            value = "根据楼id获取设备",
            notes = "根据楼id获取设备"
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
    @RequestMapping(value = "/byBuildingId", method = RequestMethod.POST)
    @ResponseBody
    private ResultJson getAdvertListByBuildingId(@RequestBody @Valid ByBuildingIdParam byBuildingIdParam) {
        List<AdvertPo> advertPoList = advertService.getAdvertListByBuildingId(byBuildingIdParam);
        return ResultJson.ok(advertPoList);
    }

    @ApiOperation(
            value = "根据层id获取设备",
            notes = "根据层id获取设备"
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
    @RequestMapping(value = "/byFloorId", method = RequestMethod.POST)
    @ResponseBody
    private ResultJson getAdvertListByFloorId(@RequestBody @Valid ByFloorIdParam byFloorIdParam) {
        List<AdvertPo> advertList = advertService.getAdvertListByFloorId(byFloorIdParam);
        return ResultJson.ok(advertList);
    }

    @ApiOperation(
            value = "获取所有设备",
            notes = "获取所有设备"
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
    @ResponseBody
    private ResultJson getAllAdvertList() {
        List<AdvertPo> advertList = advertService.getAllAdvertList();
        return ResultJson.ok(advertList);
    }

    @ApiOperation(
            value = "发生关系",
            notes = "发生关系"
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
    @RequestMapping(value = "/addRelation", method = RequestMethod.POST)
    @ResponseBody
    private ResultJson addAdvertRelation(@RequestBody @Valid RelationParam relationParam) {
        advertService.addAdvertRelation(relationParam);
        return ResultJson.ok();
    }

    @ApiOperation(
            value = "批量发生关系",
            notes = "批量发生关系"
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
    @Transactional
    @RequestMapping(value = "/addRelationBatch", method = RequestMethod.POST)
    @ResponseBody
    protected ResultJson addAdvertRelationBatch(@RequestBody @Valid RelationBatchParam relationBatchParam) {
        String ids = relationBatchParam.getAdvert();
        String[] idsArr = ids.split(",");
        for (String id : idsArr) {
            RelationParam relationParam = RelationParam.builder()
                    .ad(relationBatchParam.getAd())
                    .danger(relationBatchParam.getDanger())
                    .advert(Integer.valueOf(id)).build();
            advertService.addAdvertRelation(relationParam);
        }
        return ResultJson.ok();
    }


    //打开
    @ApiOperation(
            value = "打开",
            notes = "打开"
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
    @RequestMapping(value = "/open", method = RequestMethod.POST)
    private ResultJson updateAdvertOpen(@RequestBody @Valid OpenParam openParam) {
        advertService.updateAdvertOpen(openParam);
        return ResultJson.ok();
    }

    //批量删除
    @ApiOperation(
            value = "批量删除",
            notes = "批量删除"
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
        advertService.delAdByIds(idList);
        return ResultJson.ok();
    }

    @ApiOperation(
            value = "批量根据id获取设备",
            notes = "批量根据id获取设备"
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
    @RequestMapping(value = "/getDevById", method = RequestMethod.POST)
    @ResponseBody
    private ResultJson getAdvertDevById(@RequestBody @Valid ByIdsParam byIdsParam) {
        String[] idList = byIdsParam.getIds().split(",");
        List<AdvertDevPo> advertDevDtoList = advertService.getAdvertDevById(idList);
        return ResultJson.ok(advertDevDtoList);
    }
}