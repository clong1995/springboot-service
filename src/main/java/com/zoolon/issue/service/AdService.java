package com.zoolon.issue.service;

import com.zoolon.issue.domain.one.Ad;
import com.zoolon.issue.po.one.ad.AdAllPo;
import com.zoolon.issue.vo.param.ad.AddParam;
import com.zoolon.issue.vo.param.ad.ByIdParam;
import com.zoolon.issue.vo.param.ad.UpdateParam;

import java.util.List;

public interface AdService {
    Ad getAdById(ByIdParam byIdParam);

    void addAd(AddParam addParam);

    List<AdAllPo> getAdAll();

    void delAdByIds(String[] idList);

    void updateAdById(UpdateParam updateParam);
}