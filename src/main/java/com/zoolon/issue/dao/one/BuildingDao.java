package com.zoolon.issue.dao.one;

import com.zoolon.issue.domain.one.Building;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuildingDao {
    /**
     * 查询楼层信息
     *
     * @return
     */
    List<Building> queryAllBuilding();
}
