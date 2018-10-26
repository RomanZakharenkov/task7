package game.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Embeddable
public class EquipmentSet {

    @Column(name = "melee")
    private String melee;

    @Column(name = "ranged")
    private String ranged;
}
