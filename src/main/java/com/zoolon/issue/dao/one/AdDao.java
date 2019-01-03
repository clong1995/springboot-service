package com.zoolon.issue.dao.one;

import com.zoolon.issue.domain.one.Ad;
import com.zoolon.issue.po.one.ad.AdAllPo;
import com.zoolon.issue.vo.param.ad.AddParam;
import com.zoolon.issue.vo.param.ad.ByIdParam;
import com.zoolon.issue.vo.param.ad.UpdateParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdDao {
    List<Ad> queryAdById(ByIdParam byIdParam);

    void insertAd(AddParam addParam);

    List<AdAllPo> queryAdAll();

    void delAdByIds(String[] idList);

    void updateAdById(UpdateParam updateParam);
}
