import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;

public class ConexaoDAO {
    EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("Transacao-BC");

    EntityManager entityManager = entityManagerFactory.createEntityManager();


}
