package teccr.justdoitcloud.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Descripcion debe tener al menos 3 caracteres")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private LocalDate deadline;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "user_id")
    private Long userId;

    public enum Status {
        PENDING,
        INPROGRESS,
        DONE
    }
}