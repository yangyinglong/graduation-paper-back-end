package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IGLaboratoryMapper {
    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time` FROM `g_laboratory`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GLaboratoryEntity> queryAll();

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time` FROM `g_laboratory` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    GLaboratoryEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `g_laboratory`(`id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`) VALUES(#{id}, #{name}, #{adress}, #{adminId}, #{status}, #{createdTime}, #{changedTime})")
    void insert(GLaboratoryEntity g_laboratoryEntity);

    @Update("UPDATE `g_laboratory` SET id=#{id}, name=#{name}, adress=#{adress}, admin_id=#{adminId}, status=#{status}, created_time=#{createdTime}, changed_time=#{changedTime} WHERE `id` = #{id}")
    void update(GLaboratoryEntity g_laboratoryEntity);

    @Delete("DELETE FROM `g_laboratory` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}