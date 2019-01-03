package com.zoolon.issue.service.impl;

import com.zoolon.issue.dao.one.AdDao;
import com.zoolon.issue.domain.one.Ad;
import com.zoolon.issue.po.one.ad.AdAllPo;
import com.zoolon.issue.service.AdService;
import com.zoolon.issue.vo.param.ad.AddParam;
import com.zoolon.issue.vo.param.ad.ByIdParam;
import com.zoolon.issue.vo.param.ad.UpdateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    @Override
    public Ad getAdById(ByIdParam byIdParam) {
        List<Ad> adList = adDao.queryAdById(byIdParam);
        if (adList.size() == 1) {
            return adList.get(0);
        }
        return null;
    }

    @Override
    public void addAd(AddParam addParam) {
        adDao.insertAd(addParam);
    }

    @Override
    public List<AdAllPo> getAdAll() {
        return adDao.queryAdAll();
    }

    @Override
    public void delAdByIds(String[] idList) {
        adDao.delAdByIds(idList);
    }

    @Override
    public void updateAdById(UpdateParam updateParam) {
        adDao.updateAdById(updateParam);
    }
}