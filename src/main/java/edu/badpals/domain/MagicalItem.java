package edu.badpals.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "t_items")
@NoArgsConstructor @EqualsAndHashCode @ToString @RequiredArgsConstructor
public class MagicalItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private @Getter int id;

    @Column(name = "item_name")
    @NotEmpty
    private @NonNull @Getter @Setter String name;

    @Column(name = "item_quality")
    private @Getter @Setter int quality;

    @Column(name = "item_type", insertable = false, updatable = false)
    private @Getter @Setter String type;

}
