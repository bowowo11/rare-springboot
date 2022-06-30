package dograre.mapper;

import dograre.entity.Usr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsrMapper {
   //通过用户名查询密码
   String findPswByName(String name);
   //通过ID查询用户名
   @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
   String getIdByName(String name);
   //通过ID查询用户名
   Usr getUsrByID(String ID);

   boolean insertUsr(Usr newUsr);




   //通过ID查昵称
   String getNicknameByID(int ID);

   //通过ID查宝石
   int getCrystalByID(int ID);

   //通过ID查
   String getCardlistByID(int ID);


}
