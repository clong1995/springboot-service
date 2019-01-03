package com.zoolon.issue.service;

import com.zoolon.issue.domain.one.Danger;
import com.zoolon.issue.po.one.danger.DangerPo;
import com.zoolon.issue.vo.param.danger.AddParam;
import com.zoolon.issue.vo.param.danger.ByIdParam;
import com.zoolon.issue.vo.param.danger.UpdateParam;

import java.util.List;

public interface DangerService {
    Danger getDangerById(ByIdParam byIdParam);

    void addDanger(AddParam addParam);

    List<DangerPo> getDangerAll();

    void delDangerByIds(String[] idList);

    void updateDangerById(UpdateParam updateParam);
}