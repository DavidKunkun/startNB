package com.web.start.dao;


import com.web.start.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface QuestionDAO {
    String TABLE_NAME = " Question ";
    String INSERT_FIELDS = " title, content, created_date, user_id, comment_count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Question getById(int id);
    @Update({"update ", TABLE_NAME, " set comment_count = #{commentCount} where id=#{id}"})
    int updateCommentCount(@Param("id") int id, @Param("commentCount") int commentCount);
    //@Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where user_id=#{userId} ORDER BY id DESC LIMIT #{offset},#{limit}"})
    List<Question> selectLatestQuestions(@Param("userId") int userId, @Param("offset") int offset,
                                         @Param("limit") int limit);

}
