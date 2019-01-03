package com.zoolon.issue.service.impl;

import com.zoolon.issue.dao.one.DangerDao;
import com.zoolon.issue.domain.one.Danger;
import com.zoolon.issue.po.one.danger.DangerPo;
import com.zoolon.issue.service.DangerService;
import com.zoolon.issue.vo.param.danger.AddParam;
import com.zoolon.issue.vo.param.danger.ByIdParam;
import com.zoolon.issue.vo.param.danger.UpdateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DangerServiceImpl implements DangerService {
    @Autowired
    private DangerDao dangerDao;

    @Override
    public Danger getDangerById(ByIdParam byIdParam) {
        List<Danger> dangerList = dangerDao.queryDangerById(byIdParam);
        if (dangerList.size() == 1) {
            return dangerList.get(0);
        }
        return null;
    }

    @Override
    public void addDanger(AddParam addParam) {
        dangerDao.insertDanger(addParam);
    }

    @Override
    public List<DangerPo> getDangerAll() {
        return dangerDao.queryDangerAll();
    }

    @Override
    public void delDangerByIds(String[] idList) {
        dangerDao.delDangerByIds(idList);
    }

    @Override
    public void updateDangerById(UpdateParam updateParam) {
        dangerDao.updateDangerById(updateParam);
    }
}