package game.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hero", schema = "game")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "melee", column = @Column(name = "first_melee")),
            @AttributeOverride(name = "ranged", column = @Column(name = "first_ranged"))
    })
    private EquipmentSet firstEquipmentSet;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "melee", column = @Column(name = "second_melee")),
            @AttributeOverride(name = "ranged", column = @Column(name = "second_ranged"))
    })
    private EquipmentSet secondEquipmentSet;

    @Transient
    private boolean isMale() {
        return "MALE".equals(gender.name());
    }

    @Transient
    private boolean isFemale() {
        return "FEMALE".equals(gender.name());
    }

}
