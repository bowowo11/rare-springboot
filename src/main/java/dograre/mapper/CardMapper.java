package dograre.mapper;

import dograre.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CardMapper {
    Card getCardById(int id);
}
