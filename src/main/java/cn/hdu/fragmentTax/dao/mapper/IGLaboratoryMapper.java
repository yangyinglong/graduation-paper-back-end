package cn.hdu.fragmentTax.dao.mapper;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IGLaboratoryMapper {
    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr` FROM `g_laboratory`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "intr", column = "intr")
    })
    List<GLaboratoryEntity> queryAll();

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr` FROM `g_laboratory` WHERE `id` = #{id} and `status` <> 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "intr", column = "intr")
    })
    GLaboratoryEntity queryByKey(@Param("id") String id);

    @Insert("INSERT INTO `g_laboratory`(`id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr`) VALUES(#{id}, #{name}, #{adress}, #{adminId}, #{status}, #{createdTime}, #{changedTime}, #{openTim}, #{intr})")
    void insert(GLaboratoryEntity g_laboratoryEntity);

    @Update("UPDATE `g_laboratory` SET id=#{id}, name=#{name}, adress=#{adress}, admin_id=#{adminId}, status=#{status}, created_time=#{createdTime}, changed_time=#{changedTime}, open_tim=#{openTim}, intr=#{intr} WHERE `id` = #{id}")
    void update(GLaboratoryEntity g_laboratoryEntity);

    @Delete("DELETE FROM `g_laboratory` WHERE `id` = #{id}")
    void delete(@Param("id") String id);

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr` FROM `g_laboratory` where `status` <> 0 limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "intr", column = "intr")
    })
    List<GLaboratoryEntity> queryPart(@Param("start") int start);

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr` FROM `g_laboratory`  WHERE `name` like #{name} and `adress` like #{address} and `status` <> 0 limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "intr", column = "intr")
    })
    List<GLaboratoryEntity> queryLikeByCriteria1(@Param("name") String labName, @Param("address") String address, @Param("start") int start);

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr` FROM `g_laboratory`  WHERE `name` like #{name} and `adress` like #{address}  and `admin_id` in (${adminIds}) and `status` <> 0 limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "intr", column = "intr")
    })
    List<GLaboratoryEntity> queryLikeByCriteria2(@Param("name") String labName, @Param("address") String address, @Param("adminIds") String adminIds, @Param("start") int start);

    @Select("SELECT count(*) FROM `g_laboratory` where `name` like #{name} and `adress` like #{labAddress} and `status` <> 0")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryPartNum1(@Param("name") String labName, @Param("labAddress") String labAddress);

    @Select("SELECT count(*) FROM `g_laboratory` where `name` like #{name} and `adress` like #{labAddress} and `admin_id` in (${adminIds}) and `status` <> 0")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryPartNum2(@Param("name") String labName, @Param("labAddress") String  labAddress, @Param("adminIds") String adminIds);

    @Select("SELECT count(*) FROM `g_laboratory` where `status` <> 0")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryAllNum();

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr` FROM `g_laboratory`  WHERE `admin_id` = #{adminId} and `status` <> 0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "intr", column = "intr")
    })
    List<GLaboratoryEntity> queryByAdminId(@Param("adminId") String adminId);

    @Update("UPDATE `g_laboratory` SET status=0 WHERE `id` = #{id}")
    void cancelById(@Param("id") String labId);

    @Select("SELECT `id`, `name`, `adress`, `admin_id`, `status`, `created_time`, `changed_time`, `open_tim`, `intr` FROM `g_laboratory`  WHERE `admin_id` = #{adminId} and `status` in (${status}) order by `created_time` limit #{start}, 5")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "adress", column = "adress"),
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "changedTime", column = "changed_time"),
            @Result(property = "openTim", column = "open_tim"),
            @Result(property = "intr", column = "intr")
    })
    List<GLaboratoryEntity> queryPartByAdminId(@Param("adminId") String adminId, @Param("status") String status, @Param("start") Integer start);

    @Select("SELECT count(*) FROM `g_laboratory` where `admin_id` = #{adminId} and `status` in (${status})")
    @Results({
            @Result(property = "num", column = "count(*)")
    })
    int queryPartNumByAdminId(@Param("adminId") String adminId, @Param("status") String status);

    @Update("UPDATE `g_laboratory` SET name=#{name}, adress=#{address}, admin_id=#{adminId}, open_tim=#{openTime}, intr=#{intr}, status=#{status} WHERE `id`=#{labId}")
    void updateLabById(@Param("labId") String labId, @Param("name") String labName, @Param("address") String labAddress, @Param("adminId") String ladAdminId, @Param("openTime") String openTime, @Param("intr") String intr, @Param("status") int status);
}