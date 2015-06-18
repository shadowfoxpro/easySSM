package com.treeinjar.base;

public interface BaseMapper<Entity> {
    int deleteByPrimaryKey(Integer id);

    int insert(Entity record);

    int insertSelective(Entity record);

    Entity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Entity record);

    int updateByPrimaryKey(Entity record);
}