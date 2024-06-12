package seoan.backend.Model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "comments_date")
    private String comments_date;

    @Column(name = "qna_id")
    private String qna_id;

    @Column(name = "comments_id")
    private String comments_id;

    @Column(name = "qna_no")
    private int qna_no;

    @Column(name = "views")
    private int views;
}
