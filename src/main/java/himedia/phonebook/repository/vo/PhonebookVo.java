package himedia.phonebook.repository.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor		//	기본 생성자
@AllArgsConstructor		//	전체 생성자
@Getter					//	게터
@Setter					//	세터
@ToString				//	ToString
public class PhonebookVo {
	
	private Integer id;
	private String name;
	private String hp;
	private String tel;
}
