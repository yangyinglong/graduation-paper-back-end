package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IGOrderMapper {
    @Select("SELECT `id`, `user_id`, `laboratory_id`, `bespeak_start_time`, `bespeak_end_time`, `status`, `created_time`, `changed_time` FROM `g_order`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "laboratoryId", column = "laboratory_id"),
            @Result(property = "bespeakStartTime", column = "bespeak_start_time"),
            @Result(property = "bespeakEndTime", column = "bespeak_end_time"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GOrderEntity> queryAll();

    @Select("SELECT `id`, `user_id`, `laboratory_id`, `bespeak_start_time`, `bespeak_end_time`, `status`, `created_time`, `changed_time` FROM `g_order` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "laboratoryId", column = "laboratory_id"),
            @Result(property = "bespeakStartTime", column = "bespeak_start_time"),
            @Result(property = "bespeakEndTime", column = "bespeak_end_time"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    GOrderEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `g_order`(`id`, `user_id`, `laboratory_id`, `bespeak_start_time`, `bespeak_end_time`, `status`, `created_time`) VALUES(#{id}, #{userId}, #{laboratoryId}, #{bespeakStartTime}, #{bespeakEndTime}, #{status}, #{createdTime})")
    void insert(GOrderEntity g_orderEntity);

    @Update("UPDATE `g_order` SET id=#{id}, user_id=#{userId}, laboratory_id=#{laboratoryId}, bespeak_start_time=#{bespeakStartTime}, bespeak_end_time=#{bespeakEndTime}, status=#{status}, created_time=#{createdTime} WHERE `id` = #{id}")
    void update(GOrderEntity g_orderEntity);

    @Delete("DELETE FROM `g_order` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

}