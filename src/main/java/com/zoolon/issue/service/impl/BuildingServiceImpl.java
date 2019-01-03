package com.zoolon.issue.service.impl;


import com.zoolon.issue.dao.one.BuildingDao;
import com.zoolon.issue.domain.one.Building;
import com.zoolon.issue.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingDao buildingDao;

    @Override
    public List<Building> getAllBuilding() {
        List<Building> buildingList = buildingDao.queryAllBuilding();
        return buildingList;
    }
}