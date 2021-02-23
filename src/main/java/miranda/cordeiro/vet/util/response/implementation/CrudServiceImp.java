package miranda.cordeiro.vet.util.response.implementation;

import java.util.List;

public interface CrudServiceImp<T> {

	public List<T> findAll () ;
	
	public T searchById(Long id);
	
	public Boolean saveNew (T entity) ;
	
	public T updateAn (T entity) ;
	
	public Boolean deleteAn(Long id) ;
		
}
