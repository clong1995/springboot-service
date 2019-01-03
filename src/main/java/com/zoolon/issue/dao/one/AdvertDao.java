package com.zoolon.issue.dao.one;

import com.zoolon.issue.domain.one.Advert;
import com.zoolon.issue.domain.one.AdvertRelation;
import com.zoolon.issue.po.one.advert.AdvertDataPo;
import com.zoolon.issue.po.one.advert.AdvertDevPo;
import com.zoolon.issue.po.one.advert.AdvertPo;
import com.zoolon.issue.vo.param.advert.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdvertDao {
    void insertAdvert(AddParam addParam);

    List<AdvertPo> queryAdvertListByBuildingId(ByBuildingIdParam byBuildingIdParam);

    List<AdvertPo> queryAdvertListByFloorId(ByFloorIdParam byFloorIdParam);

    List<AdvertPo> getAllAdvertList();

    List<Advert> getAdvertById(ByIdParam byIdParam);

    void updateAdvert(UpdateParam updateParam);

    void insertAdvertRelation(RelationParam relationParam);

    List<AdvertRelation> queryAdvertRelation(ByIdParam advertIdVo);

    void updateAdvertRelation(RelationParam relationParam);

    void updateAdvertOpen(OpenParam openParam);

    void delAdByIds(String[] idList);

    List<AdvertDevPo> queryAdvertDevById(String[] idList);

    List<AdvertDataPo> queryAdvertDataById(ByIdParam byIdParam);
}
