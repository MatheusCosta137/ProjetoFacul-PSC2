import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Usuario;

public class TaskHubTest {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory(
                "PU"
        );
        EntityManager em =emf.createEntityManager();
        try{
            Usuario usuario1 = new Usuario(1,
            "matheus s"
            ,"matheus@gmail.com"
            , "12345678");

            Usuario usuario2 = new Usuario(2,
                    "samuel"
                    ,"samuel@gmail.com"
                    , "12345678");

            em.getTransaction().begin();
            em.persist(usuario1);
            em.persist(usuario2);
            em.getTransaction().commit();

        }finally {
            em.close();
            emf.close();
        }
    }
}
