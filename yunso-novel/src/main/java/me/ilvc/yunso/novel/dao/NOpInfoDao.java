package me.ilvc.yunso.novel.dao;

import me.ilvc.yunso.base.dao.BaseDao;
import me.ilvc.yunso.novel.model.NOpInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NOpInfoDao extends BaseDao{
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("state") String state, @Param("type") String type);

    int insert(NOpInfo record);

    int insertSelective(NOpInfo record);

    NOpInfo selectByPrimaryKey(@Param("id") Integer id, @Param("state") String state, @Param("type") String type);

    int updateByPrimaryKeySelective(NOpInfo record);

    int updateByPrimaryKey(NOpInfo record);

    List<NOpInfo> findAll();
}