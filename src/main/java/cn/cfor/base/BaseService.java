package cn.cfor.base;

public interface BaseService<Entity> {
    int deleteByPrimaryKey(Integer id);

    int insert(Entity record);

    int insertSelective(Entity record);

    Entity selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Entity record);

    int updateByPrimaryKey(Entity record);
}
