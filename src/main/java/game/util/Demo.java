package game.util;

import game.model.EquipmentSet;
import game.model.Gender;
import game.model.Hero;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class Demo {

    public static void main(String[] args) {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable heroId = session.save(Hero.builder()
                .name("Гендальф")
                .gender(Gender.MALE)
                .firstEquipmentSet(EquipmentSet.of("Меч", "Магия"))
                .secondEquipmentSet(EquipmentSet.of("Нож", "Магия"))
                .build());
        Hero hero = session.get(Hero.class, heroId);
        session.getTransaction().commit();
    }
}
