package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Comment;

@Mapper
public interface CommentMapper {

	@Select("""
			SELECT * 
			FROM Comment
			WHERE boardId = #{boardId}
			""")
	List<Comment> selectAllByBoardId(Integer boardId);

	@Insert("""
			INSERT INTO Comment (boardId, content, memberId)
			VALUES (#{boardId}, #{content}, #{memberId})
			""")
	Integer insert(Comment comment);

	@Delete("""
			DELETE FROM Comment
			WHERE id = #{id}
			""")
	int deleteById(Integer id);

	@Select("""
			SELECT *
			FROM Comment 
			WHERE id = #{id}
			""")
	Comment selectById(Integer id);

	@Update("""
			UPDATE Comment
			SET
				content = #{content}
			WHERE 
				id = #{id}
			""")
	Integer update(Comment comment);

	@Delete("""
			DELETE FROM Comment
			WHERE boardId = #{boardId}
			""")
	Integer deleteByBoardId(Integer boardId);

	@Delete("""
			DELETE FROM Comment
			WHERE memberId = #{memberId}
			""")
	Integer deleteByMemberId(String memberid);

	
}
