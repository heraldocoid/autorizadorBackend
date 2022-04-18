package co.com.autorizador.web.ms.rest.response;

public class GenericResponse<T> extends CommonResponse{
	
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
	
}
