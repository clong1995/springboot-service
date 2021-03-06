package com.zoolon.issue.controller;

import com.zoolon.issue.result.ResultJson;
import com.zoolon.issue.service.TestService;
import com.zoolon.issue.vo.param.auth.SignParam;
import com.zoolon.issue.vo.res.test.ByIdRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(description = "测试用的")
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/dataNoRole", method = RequestMethod.POST)
    @ApiOperation(
            value = "测试权限不足执行该方法",
            notes = "测试权限"
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
    private ResultJson getDataNoRole() {
        return ResultJson.ok("获取数据成功");
    }

    @ApiOperation(
            value = "测试第二个数据库，根据id获取数据",
            notes = "测试数据庫"
    )
    @RequestMapping(value = "/ByIdRes", method = RequestMethod.POST)
    private ResultJson getTestById(@RequestBody @Valid SignParam signParam) {
        ByIdRes byIdRes = testService.getTestById(signParam);
        return ResultJson.ok(byIdRes);
    }


    @RequestMapping(value = "/hasTestRole", method = RequestMethod.POST)
    @ApiOperation(
            value = "只有test权限可以",
            notes = "测试权限"
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
    private ResultJson hasTestRole() {
        return ResultJson.ok("只有test权限可以");
    }

    /**
     *
     */
    @RequestMapping(value = "/testOneTx", method = RequestMethod.POST)
    @ApiOperation(
            value = "测试单个事务",
            notes = "测试事务"
    )
    private void testOneTx() {
        log.info("测试一个数据库的事务");
        testService.testOneTx();
    }

    /**
     *
     */
    @RequestMapping(value = "/testTow", method = RequestMethod.POST)
    @ApiOperation(
            value = "测试第二个数据库",
            notes = "测试"
    )
    private void testTow() {
        log.info("测试第二个数据库");
        testService.testTow();
    }

    /**
     *
     */
    @RequestMapping(value = "/testTowTx", method = RequestMethod.POST)
    @ApiOperation(
            value = "测试两个数据库的事务",
            notes = "测试事务"
    )
    private void testTowTx() {
        log.info("测试两个数据库的事务");
        testService.testTowTx();
    }
}
