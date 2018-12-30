package com.zoolon.issue.dao.one;

import com.zoolon.issue.po.one.BuildingFloorPo;
import com.zoolon.issue.po.one.FloorPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FloorDao {
    /**
     * 查询楼层信息
     *
     * @return
     */
    List<BuildingFloorPo> queryAllBuildingFloor();

    /**
     * 根据楼id查询层
     *
     * @return
     */
    List<FloorPo> queryFloorListByBuildingId(Integer id);
}
