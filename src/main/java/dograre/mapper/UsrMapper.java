package dograre.mapper;

import dograre.entity.Usr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsrMapper {

   String findPswByName(String name);

   String getIdByName(String name);

   Usr getUsrByID(int ID);

}
