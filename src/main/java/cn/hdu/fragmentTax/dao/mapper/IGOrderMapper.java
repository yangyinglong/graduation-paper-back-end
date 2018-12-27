package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IGOrderMapper {
    @Select("SELECT `id`, `user_id`, `user_name`, `laboratory_id`, `laboratory_name`, `laboratory_address`, `bespeak_start_time`, `bespeak_end_time`, `used_to`, `remarks`, `status`, `admin_remarks`, `created_time`, `changed_time` FROM `g_order`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "laboratoryId", column = "laboratory_id"),
            @Result(property = "laboratoryName", column = "laboratory_name"),
            @Result(property = "laboratoryAddress", column = "laboratory_address"),
            @Result(property = "bespeakStartTime", column = "bespeak_start_time"),
            @Result(property = "bespeakEndTime", column = "bespeak_end_time"),
            @Result(property = "usedTo", column = "used_to"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "status", column = "status"),
            @Result(property = "adminRemarks", column = "admin_remarks"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GOrderEntity> queryAll();

    @Select("SELECT `id`, `user_id`, `user_name`, `laboratory_id`, `laboratory_name`, `laboratory_address`, `bespeak_start_time`, `bespeak_end_time`, `used_to`, `remarks`, `status`, `admin_remarks`, `created_time`, `changed_time` FROM `g_order` WHERE `id` = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "laboratoryId", column = "laboratory_id"),
            @Result(property = "laboratoryName", column = "laboratory_name"),
            @Result(property = "laboratoryAddress", column = "laboratory_address"),
            @Result(property = "bespeakStartTime", column = "bespeak_start_time"),
            @Result(property = "bespeakEndTime", column = "bespeak_end_time"),
            @Result(property = "usedTo", column = "used_to"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "status", column = "status"),
            @Result(property = "adminRemarks", column = "admin_remarks"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    GOrderEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `g_order`(`id`, `user_id`, `user_name`, `laboratory_id`, `laboratory_name`, `laboratory_address`, `bespeak_start_time`, `bespeak_end_time`, `used_to`, `remarks`, `status`, `admin_remarks`, `created_time`, `changed_time`) VALUES(#{id}, #{userId}, #{userName}, #{laboratoryId}, #{laboratoryName}, #{laboratoryAddress}, #{bespeakStartTime}, #{bespeakEndTime}, #{usedTo}, #{remarks}, #{status}, #{adminRemarks}, #{createdTime}, #{changedTime})")
    void insert(GOrderEntity g_orderEntity);

    @Update("UPDATE `g_order` SET id=#{id}, user_id=#{userId}, user_name=#{userName}, laboratory_id=#{laboratoryId}, laboratory_name=#{laboratoryName}, laboratory_address=#{laboratoryAddress}, bespeak_start_time=#{bespeakStartTime}, bespeak_end_time=#{bespeakEndTime}, used_to=#{usedTo}, remarks=#{remarks}, status=#{status}, admin_remarks=#{adminRemarks}, created_time=#{createdTime}, changed_time=#{changedTime} WHERE `id` = #{id}")
    void update(GOrderEntity g_orderEntity);

    @Delete("DELETE FROM `g_order` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

    @Select("SELECT `id`, `user_id`, `user_name`, `laboratory_id`, `laboratory_name`, `laboratory_address`, `bespeak_start_time`, `bespeak_end_time`, `used_to`, `remarks`, `status`, `admin_remarks`, `created_time`, `changed_time` FROM `g_order` where `user_id`=#{userId} and `status` in (${status}) order by `created_time` limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "laboratoryId", column = "laboratory_id"),
            @Result(property = "laboratoryName", column = "laboratory_name"),
            @Result(property = "laboratoryAddress", column = "laboratory_address"),
            @Result(property = "bespeakStartTime", column = "bespeak_start_time"),
            @Result(property = "bespeakEndTime", column = "bespeak_end_time"),
            @Result(property = "usedTo", column = "used_to"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "status", column = "status"),
            @Result(property = "adminRemarks", column = "admin_remarks"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GOrderEntity> queryPartByUserId(@Param("userId") String userId, @Param("status") String status, @Param("start") Integer start);

    @Select("SELECT count(*) FROM `g_order` where `user_id`=#{userId} and `status` in (${status})")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryNum(@Param("userId") String userId, @Param("status") String status);

    @Update("UPDATE `g_order` SET user_name=#{userName}, bespeak_start_time=#{bespeakStartTime}, bespeak_end_time=#{bespeakEndTime}, used_to=#{usedTo}, remarks=#{remarks}, status= 1 WHERE `id` = #{orderId}")
    void updateOrderById(@Param("orderId") String orderId, @Param("bespeakStartTime") String bespeakStartTime, @Param("bespeakEndTime") String bespeakEndTime, @Param("userName") String userName, @Param("usedTo") String usedTo, @Param("remarks") String remarks);

    @Select("SELECT `id`, `user_id`, `user_name`, `laboratory_id`, `laboratory_name`, `laboratory_address`, `bespeak_start_time`, `bespeak_end_time`, `used_to`, `remarks`, `status`, `admin_remarks`, `created_time`, `changed_time` FROM `g_order` where `bespeak_start_time` between #{bespeakStartTime1} and #{bespeakStartTime2} and `laboratory_id` = #{labId} and `status` <> 0 order by `bespeak_start_time`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "laboratoryId", column = "laboratory_id"),
            @Result(property = "laboratoryName", column = "laboratory_name"),
            @Result(property = "laboratoryAddress", column = "laboratory_address"),
            @Result(property = "bespeakStartTime", column = "bespeak_start_time"),
            @Result(property = "bespeakEndTime", column = "bespeak_end_time"),
            @Result(property = "usedTo", column = "used_to"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "status", column = "status"),
            @Result(property = "adminRemarks", column = "admin_remarks"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GOrderEntity> queryPartByBespeakTime(@Param("labId") String labId, @Param("bespeakStartTime1") String bespeakStartTime1, @Param("bespeakStartTime2") String bespeakStartTime2);

    @Update("UPDATE `g_order` SET status = 0 WHERE `id` = #{orderId}")
    void cancelOrder(@Param("orderId") String orderId);

    @Select("SELECT `id`, `user_id`, `user_name`, `laboratory_id`, `laboratory_name`, `laboratory_address`, `bespeak_start_time`, `bespeak_end_time`, `used_to`, `remarks`, `status`, `admin_remarks`, `created_time`, `changed_time` FROM `g_order` where `laboratory_id` in (${labIds}) and `status` in (${status}) order by `created_time` limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "laboratoryId", column = "laboratory_id"),
            @Result(property = "laboratoryName", column = "laboratory_name"),
            @Result(property = "laboratoryAddress", column = "laboratory_address"),
            @Result(property = "bespeakStartTime", column = "bespeak_start_time"),
            @Result(property = "bespeakEndTime", column = "bespeak_end_time"),
            @Result(property = "usedTo", column = "used_to"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "status", column = "status"),
            @Result(property = "adminRemarks", column = "admin_remarks"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time")
    })
    List<GOrderEntity> queryPartByLabIds(@Param("labIds") String labIds, @Param("status") String status, @Param("start") Integer start);

    @Select("SELECT count(*) FROM `g_order` where `laboratory_id` in (${labIds}) and `status` in (${status})")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryNumByLabIds(@Param("labIds") String labIds, @Param("status") String status);

    @Update("UPDATE `g_order` SET admin_remarks=#{adminRemarks}, status=#{status} WHERE `id` = #{orderId}")
    void adminReviewById(@Param("orderId") String orderId, @Param("adminRemarks") String adminRemarks, @Param("status") int status);
}