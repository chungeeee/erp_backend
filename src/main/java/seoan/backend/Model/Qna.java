package seoan.backend.Model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "qna")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "qna_date")
    private String qna_date;

    @Column(name = "id")
    private String id;

    @Column(name = "views")
    private int views;
}
