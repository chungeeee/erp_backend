package seoan.backend.Model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @Column(name = "number1")
    private int number1;

    @Column(name = "number2")
    private int number2;

}
