package hack.api.com.modelo.interfaces;
import java.util.List;

public interface MeuCrud<T ,K>  {
	
	List<T> findAll();
	List<T> saveAll(List<K> list);
	T save(K entidade);
	T edit (K id) ;
	void delete(Long id);
	T findById(Long id) ;
	List<T> findAllByName(String nome);
		
	
}
