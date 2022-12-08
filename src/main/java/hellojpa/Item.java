package hellojpa;


import javax.persistence.*;

// Entity annotation만 있을 시 싱글테이블로 생성 (싱글)
/*@Inheritance(strategy = InheritanceType.JOINED) annotation 추가시 상속받은 테이블 각자 생성(조인전략)
    DEFAULT  InheritanceType.SINGLE_TABLE
    single은 DTYPE 컬럼이 자동으로 생성됨

    TEBLE_PER_CLASS : Item 테이블은 존재하지않고 각자 album , book  . movie 테이블로 만들어진다.

 */
/*@DiscriminatorColumn 추가시 각 상속받은 테이블에 부모 멤버변수가 추가되어 생성됨
  DTYPE 컬럼이 생성됨 컬럼 이름 변경 가능
 */




@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
