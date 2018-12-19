package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IGLaboratoryMapper {
    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `desc` FROM `g_laboratory`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "desc", column = "desc")
    })
    List<GLaboratoryEntity> queryAll();

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `desc` FROM `g_laboratory` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "desc", column = "desc")
    })
    GLaboratoryEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `g_laboratory`(`id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `desc`) VALUES(#{id}, #{name}, #{adress}, #{adminId}, #{status}, #{createdTime}, #{changedTime}, #{openTim}, #{desc})")
    void insert(GLaboratoryEntity g_laboratoryEntity);

    @Update("UPDATE `g_laboratory` SET id=#{id}, name=#{name}, adress=#{adress}, admin_id=#{adminId}, status=#{status}, created_time=#{createdTime}, changed_time=#{changedTime}, open_tim=#{openTim}, desc=#{desc} WHERE `id` = #{id}")
    void update(GLaboratoryEntity g_laboratoryEntity);

    @Delete("DELETE FROM `g_laboratory` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `desc` FROM `g_laboratory` limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "desc", column = "desc")
    })
    List<GLaboratoryEntity> queryPart(@Param("start") int start);

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `desc` FROM `g_laboratory`  WHERE `name` like #{name} limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "desc", column = "desc")
    })
    List<GLaboratoryEntity> queryLikeByName(@Param("name") String labName, @Param("start") int start);

    @Select("SELECT count(*) FROM `g_laboratory` where `name` like #{name}")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryPartNum(@Param("name") String  labName);

    @Select("SELECT count(*) FROM `g_laboratory`")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryAllNum();
}