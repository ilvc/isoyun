package me.ilvc.yunso.base.dao;

import java.util.List;

/**
 * @Author: iLvc
 * @Date：Create in 14:45 2017/7/23
 * @Description:
 * @Modified By:
 */
public interface BaseDao {

   /** 通过 id 查询
    * @param id
    * @param <T>
    * @return
    */
   <T> T findById(Integer id);

   /**  插入一条数据
    * @param t
    * @param <T>
    * @return
    */
   <T> int insert(T t);

   /** 更新一条数据
    * @param t
    * @param <T>
    * @return
    */
   <T> int update(T t);

   /** 删除一条数据
    * @param t
    * @param <T>
    * @return
    */
   <T> int delete(T t);


   /** 通过 model 来查询单条数据
    * @param t
    * @param <T>
    * @return
    */
   <T> T select(T t);

   /** 查询所有的数据
    * @param <T>
    * @return
    */
   <T> List<T> findAll();

   /** 数据总数
    * @return
    */
   int size();

   /** 按不同类别查询
    * @param t
    * @param <T>
    * @return
    */
   <T> int sizeByType(T t);



}
