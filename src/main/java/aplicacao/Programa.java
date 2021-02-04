package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		/*
		 * Pessoa p1 = new Pessoa(null, "Carlos S", "carlos@gmail.com"); Pessoa p2 = new
		 * Pessoa(null, "Alex A", "alex@gmail.com"); Pessoa p3 = new Pessoa(null,
		 * "Gabriel Sousa", "gabriel@gmail.com");
		 * 
		 * em.getTransaction().begin(); em.persist(p1); em.persist(p2); em.persist(p3);
		 * em.getTransaction().commit();
		 * 
		 */		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		/*
		 * //buscar Pessoa p = em.find(Pessoa.class, 2); System.out.println(p);
		 */
		
		//remover
		//Sempre que não for uma consulta, é necessario iniciar e fechar uma transação
		//para remover uma entidade, é necessário que ela esteja monitorada(acabar de ter sido inserida ou ter sido recuperada)
		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class, 2);
		em.remove(p);
		em.getTransaction().commit();
		//ok
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
	}

}
