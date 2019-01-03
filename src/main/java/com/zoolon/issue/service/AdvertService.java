package com.zoolon.issue.service;

import com.zoolon.issue.domain.one.Advert;
import com.zoolon.issue.po.one.advert.AdvertDataPo;
import com.zoolon.issue.po.one.advert.AdvertDevPo;
import com.zoolon.issue.po.one.advert.AdvertPo;
import com.zoolon.issue.vo.param.advert.*;

import java.util.List;

public interface AdvertService {
    Integer addAdvert(AddParam addParam);

    List<AdvertPo> getAdvertListByBuildingId(ByBuildingIdParam byBuildingIdParam);

    List<AdvertPo> getAdvertListByFloorId(ByFloorIdParam byFloorIdParam);

    List<AdvertPo> getAllAdvertList();

    Advert getAdvertById(ByIdParam byIdParam);

    void updateAdvert(UpdateParam updateParam);

    void addAdvertRelation(RelationParam relationParam);

    void updateAdvertOpen(OpenParam openParam);

    void delAdByIds(String[] idList);

    List<AdvertDevPo> getAdvertDevById(String[] idList);

    AdvertDataPo getAdvertDataById(ByIdParam byIdParam);
}
