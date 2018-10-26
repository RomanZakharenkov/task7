package game.model;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class HeroDaoTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void checkSaveHero() {
        @Cleanup Session session = FACTORY.openSession();
        Hero hero = Hero.builder()
                .name("Легол")
                .gender(Gender.MALE)
                .firstEquipmentSet(EquipmentSet.of("Меч", "Лук"))
                .secondEquipmentSet(EquipmentSet.of("Нож", "Копье"))
                .build();
        Serializable id = session.save(hero);
        assertNotNull(id);
    }

    @Test
    public void checkById() {
        @Cleanup Session session = FACTORY.openSession();
        Hero hero = Hero.builder()
                .name("Лег")
                .gender(Gender.MALE)
                .firstEquipmentSet(EquipmentSet.of("Меч", "Лук"))
                .secondEquipmentSet(EquipmentSet.of("Нож", "Копье"))
                .build();
        Serializable id = session.save(hero);
        assertNotNull(id);
        Hero hero1 = session.find(Hero.class, id);
        System.out.println(hero1);
        assertNotNull(hero1);
    }
}
