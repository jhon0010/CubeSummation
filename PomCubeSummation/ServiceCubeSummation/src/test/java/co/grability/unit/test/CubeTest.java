/**
 * 
 */
package co.grability.unit.test;

import org.junit.Before;
import org.junit.Test;

import co.test.grability.contantes.ConstantesCubo;
import co.test.grability.controller.CubeController;

/**
 * Clase que nos permite tener pruebas unitarias para verificar 
 * que el comportamiento del controlador de cubo sea el esperado
 * @author jhon
 *
 */
public class CubeTest extends ConstantesCubo {
	
	
	private CubeController controller;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		controller = new CubeController();
	}

	
	/**
	 * Prueba que valida que el valor de t se encuentre dentro de
	 * 1 y 50
	 */
	@Test
	public void validateTValue() {
		
		assert("".equals(controller.validarParametros(T_VALID, N_VALID, M_VALID)));
		assert(MSJ_T_VALUE_INVALID.equals(controller.validarParametros(T_INVALID, N_VALID, M_VALID)));
	}

	
	
	/**
	 * Prueba que valida que el valor de n se encuentre dentro de
	 * 1 y 100
	 */
	@Test
	public void validateNValue() {
		
		assert("".equals(controller.validarParametros(T_VALID, N_VALID, M_VALID)));
		assert(MSJ_T_VALUE_INVALID.equals(controller.validarParametros(T_VALID, N_INVALID, M_VALID)));
	}
	
	/**
	 * Prueba que valida que el valor de m se encuentre dentro de
	 * 1 y 1000
	 */
	@Test
	public void validateMValue() {
		
		assert("".equals(controller.validarParametros(T_VALID, N_VALID, M_VALID)));
		assert(MSJ_T_VALUE_INVALID.equals(controller.validarParametros(T_VALID, N_VALID, M_INVALID)));
	}
	
}
