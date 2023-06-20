package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@SequenceGenerator(name = "member_seq_generator",sequenceName = "member_seq")
@TableGenerator(name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq_generator")
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    @Column(name="name",nullable = false)
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;
    @Transient
    private int temp;
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;
    public Member() {

    }

    public Member(Long id, String name) {
        this.id = id;
        this.username = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
