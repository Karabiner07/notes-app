package com.karabiner.notesapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notesId;

    @NotNull
    @NotBlank(message = "please enter something to save notes")
    @Pattern(regexp = "^[a-zA-Z0-9 @,;&*+-]*$", message = "Invalid note content")
    @Column(length = 500)
    private String userNotes;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "UserId"
    )
    private User user;

}
