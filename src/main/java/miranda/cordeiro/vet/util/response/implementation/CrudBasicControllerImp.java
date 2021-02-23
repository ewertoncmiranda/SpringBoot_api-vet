package miranda.cordeiro.vet.util.response.implementation;

public interface CrudBasicControllerImp<T,K> {

	
	public T getListOf () ;
	
	public T findById(Long id);
	
	public T saveNew (K entity) ;
	
	public T updateAn (K entity) ;
	
	public T deleteAn(Long id) ;
	
	
}
