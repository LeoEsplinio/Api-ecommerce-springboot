package br.org.serratec.ecommerce.exceptions;

public class EntityNotFoundExceptionHandler extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundExceptionHandler(Object id) {
		super("" + id);
	}
	
}
