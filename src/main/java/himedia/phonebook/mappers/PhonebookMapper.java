package himedia.phonebook.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import himedia.phonebook.repository.vo.PhonebookVo;

//	이 매퍼 인터페이스를 mybatis mapper 설정의 namespace로 등록해줘야 한다.
//	MyBatis Mapper
@Mapper
public interface PhonebookMapper {
//	<select id="selectAll" resultType="phonebookVo">
	List<PhonebookVo> selectAll();
	
//	<select id="selectOne" parameterType="int" resultType="phonebookVo">
//	@Select("SELECT * FROM phonebook WHERE id=#{id}")
	PhonebookVo selectOne(Integer id);
	
//	<insert id="insert" parameterType="phonebookVo">
	int insert(PhonebookVo phonebookVo);
	
//	<update id="update" parameterType="phonebookVo">
	int update(PhonebookVo phonebookVo);
	
}
