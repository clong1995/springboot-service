package com.zoolon.issue.service.impl;

import com.zoolon.issue.dao.one.AdvertDao;
import com.zoolon.issue.domain.one.Advert;
import com.zoolon.issue.domain.one.AdvertRelation;
import com.zoolon.issue.po.one.advert.AdvertDataPo;
import com.zoolon.issue.po.one.advert.AdvertDevPo;
import com.zoolon.issue.po.one.advert.AdvertPo;
import com.zoolon.issue.service.AdvertService;
import com.zoolon.issue.vo.param.advert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {
    @Autowired
    private AdvertDao advertDao;

    @Transactional
    public Integer addAdvert(AddParam addParam) {
        advertDao.insertAdvert(addParam);
        return addParam.getId();
    }

    @Override
    public List<AdvertPo> getAdvertListByBuildingId(ByBuildingIdParam byBuildingIdParam) {
        return advertDao.queryAdvertListByBuildingId(byBuildingIdParam);
    }

    @Override
    public List<AdvertPo> getAdvertListByFloorId(ByFloorIdParam byFloorIdParam) {
        return advertDao.queryAdvertListByFloorId(byFloorIdParam);
    }

    @Override
    public List<AdvertPo> getAllAdvertList() {
        return advertDao.getAllAdvertList();
    }

    @Override
    public Advert getAdvertById(ByIdParam byIdParam) {
        List<Advert> advertList = advertDao.getAdvertById(byIdParam);
        if (advertList.size() == 1) {
            return advertList.get(0);
        }
        return null;
    }

    @Override
    public void updateAdvert(UpdateParam updateParam) {
        advertDao.updateAdvert(updateParam);
    }

    @Override
    @Transactional
    public void addAdvertRelation(RelationParam relationParam) {
        //是否存在
        ByIdParam advertIdVo = new ByIdParam();
        advertIdVo.setId(relationParam.getAdvert());
        List<AdvertRelation> advertRelationList = advertDao.queryAdvertRelation(advertIdVo);
        if (advertRelationList.size() == 1) {
            //存在更新
            advertDao.updateAdvertRelation(relationParam);
        } else {
            //不存在插入
            advertDao.insertAdvertRelation(relationParam);
        }
    }

    @Override
    public void updateAdvertOpen(OpenParam openParam) {
        advertDao.updateAdvertOpen(openParam);
    }

    @Override
    public void delAdByIds(String[] idList) {
        advertDao.delAdByIds(idList);
    }

    @Override
    public List<AdvertDevPo> getAdvertDevById(String[] idList) {
        return advertDao.queryAdvertDevById(idList);
    }

    @Override
    public AdvertDataPo getAdvertDataById(ByIdParam byIdParam) {
        List<AdvertDataPo> advertDataDtoList = advertDao.queryAdvertDataById(byIdParam);
        if (advertDataDtoList.size() == 1) {
            return advertDataDtoList.get(0);
        }
        return null;
    }
}
