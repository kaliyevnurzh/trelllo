package kz.bitlab.test_trello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends BaseModel{
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int status; // 0 - todo, 1 - intest, 2 - done, 3 - failed

    @ManyToOne
    private Folder folder; // Many To One
}
