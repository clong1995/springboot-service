package com.zoolon.issue.dao.one;

import com.zoolon.issue.domain.one.Danger;
import com.zoolon.issue.po.one.danger.DangerPo;
import com.zoolon.issue.vo.param.danger.AddParam;
import com.zoolon.issue.vo.param.danger.ByIdParam;
import com.zoolon.issue.vo.param.danger.UpdateParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DangerDao {
    List<Danger> queryDangerById(ByIdParam byIdParam);

    void insertDanger(AddParam addParam);

    List<DangerPo> queryDangerAll();

    void delDangerByIds(String[] idList);

    void updateDangerById(UpdateParam updateParam);
}
