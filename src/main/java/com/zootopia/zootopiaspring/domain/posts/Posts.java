package com.zootopia.zootopiaspring.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
/* 테이블과 링크될 클래스임을 나타낸다.
*  기본값으로 클래스의 카말케이스 이름을 언더스코어 네미밍으로 테이블 이름을 매칭한다 (SalesManager -> sales_manager)*/
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* PK 생성규칙 */
    private Long id;

    @Column(length = 500, nullable = false)
    /* Column 어노테이션을 추가를 구지 않해도 테이블의 컬럼이 되지만, 추가로 필요한 옵션이 있으면 사용, */
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)  //
    private String content;

    private String author;

    @Builder   //  해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*
    Setter 메소드가 없는 이유
    - setter를 사용하면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 구분 불가능. 따라서 차후 기능 변경시 복잡해짐
    - 기본적인 구조는 생성자를 통해 값을 채우고, 이벤트에 맞는 public 메소드를 호출하여 변경하는것으로 전제한다.

     빌더를 사용하는 이유
     - 생성자의 경우 지금 채워야할 필드가 무엇인지 명확히 지정할 수 없다.
     ex) Example(String a, String b) {
         this.a = a;
         this.b = b;
         }
         이 코드에서 a,b의 위치를 변경해도 잘돌아간다.
    */
}
