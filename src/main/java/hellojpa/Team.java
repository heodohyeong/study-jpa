package hellojpa;


import javax.persistence.*;
import java.util.List;

@Entity
public class Team extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long Id;
    private String name;

    //@OneToMany
    @OneToMany(mappedBy = "team")
    //@JoinColumn(name = "MEMBER_ID")
    private List<Member> member;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMember() {
        return member;
    }

    public void setMember(List<Member> member) {
        this.member = member;
    }
}
