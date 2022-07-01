package dograre.mapper;

import dograre.entity.Usr;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsrMapper {
   //通过用户名查询密码
   String findPswByName(String name);
   //通过ID查询用户名

   String getIdByName(String name);

   String getIdByNickName(String name);
   //通过ID查询用户名
   Usr getUsrByID(String ID);

   boolean insertUsr(Usr newUsr);

   //通过ID查昵称
   String getNicknameByID(int ID);

   //通过ID查宝石
   int getCrystalByID(int ID);

   boolean setCrystal(int ID,int Crystal);

   //通过ID查
   String getCardlistByID(int ID);

   boolean setCard(int ID,String cards);
}
