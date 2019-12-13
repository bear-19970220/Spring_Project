package com.dfbz.mapper;

import com.dfbz.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    //    @Select("SELECT uid, uname FROM t_user")
    List<User> findAllUser();

    //    @Insert("INSERT INTO t_user(uid, uname) VALUES (#{uid}, #{uname})")
    void addUser(User user);

    User findUserByIdAndName(
            @Param("uuu_id") Integer uid,
            @Param("uuu_name") String uname);

    User findUserById(Integer uiiiiiiiiid);


}
