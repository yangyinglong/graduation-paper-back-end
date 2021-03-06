package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IGUserMapper {
    @Select("SELECT `id`, `name`, `phone`, `email`, `password`, `status`, `created_time`, `changed_time` FROM `g_user`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GUserEntity> queryAll();

    @Select("SELECT `id`, `name`, `phone`, `email`, `password`, `status`, `created_time`, `changed_time` FROM `g_user` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    GUserEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `g_user`(`id`, `name`, `phone`, `email`, `password`, `status`, `created_time`) VALUES(#{id}, #{name}, #{phone}, #{email}, #{password}, #{status}, #{createdTime})")
    void insert(GUserEntity g_userEntity);

    @Update("UPDATE `g_user` SET id=#{id}, name=#{name}, phone=#{phone}, email=#{email}, password=#{password}, status=#{status}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(GUserEntity g_userEntity);

    @Delete("DELETE FROM `g_user` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

    @Select("SELECT `id`, `name`, `phone`, `email`, `password`, `status`, `created_time`, `changed_time` FROM `g_user` WHERE `phone` = #{phone}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    GUserEntity queryByPhone(@Param("phone") String phone);

    @Update("UPDATE `g_user` SET password=#{password} WHERE `phone` = #{phone}")
    void updatePasswordByPhone(@Param("phone") String phone, @Param("password") String password);

    @Update("UPDATE `g_user` SET name=#{name}, phone=#{phone}, email=#{email} WHERE `id` = #{id}")
    void updateById(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("email") String eMail);

    @Update("UPDATE `g_user` SET name=#{name}, phone=#{phone}, email=#{email}, password=#{password} WHERE `id` = #{id}")
    void updatePasswordById(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("email") String eMail, @Param("password") String password);

    @Select("SELECT `id`, `name`, `phone`, `email`, `password`, `status`, `created_time`, `changed_time` FROM `g_user` where `name` like #{name}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GUserEntity> queryLikeByName(@Param("name") String name);

    @Update("UPDATE `g_user` SET status=2 WHERE `id` = #{id}")
    void updateToAdmin(@Param("id") String id);
}