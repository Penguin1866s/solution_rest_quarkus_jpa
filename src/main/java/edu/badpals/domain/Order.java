package edu.badpals.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_orders")
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private @Getter long id;
    @ManyToOne
    @JoinColumn(name = "ord_wizard")
    private @Getter @Setter Wizard wizard;
    @OneToOne
    @JoinColumn(name = "ord_item")
    private @Getter @Setter MagicalItem item;
}
