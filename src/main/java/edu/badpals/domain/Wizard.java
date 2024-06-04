package edu.badpals.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_wizards")
@NoArgsConstructor @EqualsAndHashCode @ToString @RequiredArgsConstructor
public class Wizard {
    @Id
    @Column(name = "wizard_name")
    private @NonNull @Getter String name;
    @Column(name = "wizard_dexterity")
    private @Getter @Setter int dexterity;
    @Column(name = "wizard_person")
    @Enumerated(EnumType.STRING)
    private @Getter @Setter Person person;

}
