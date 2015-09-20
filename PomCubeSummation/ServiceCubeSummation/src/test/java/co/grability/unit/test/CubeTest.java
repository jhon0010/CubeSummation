/**
 * 
 */
package co.grability.unit.test;

import org.junit.Before;
import org.junit.Test;

import co.test.grability.contantes.ConstantesCubo;
import co.test.grability.controller.CubeController;
import co.test.grability.modelo.Punto;

/**
 * Clase que nos permite tener pruebas unitarias para verificar que el
 * comportamiento del controlador de cubo sea el esperado
 * 
 * @author jhon
 *
 */
public class CubeTest extends ConstantesCubo {

	private CubeController controller;
	private Punto[] puntos;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		controller = new CubeController();

		// Inicializar una matris de puntos 3d para realizar pruebas

		puntos = new Punto[N_VALID];
		for (int i = 0; i < puntos.length; i++) {
			long pos = i + 1;
			puntos[i] = new Punto(pos, pos, pos, 0);

		}
	}

	/**
	 * Prueba que valida que el valor de t se encuentre dentro de 1 y 50
	 */
	@Test
	public void validateTValue() {

		assert("".equals(controller.validarParametros(T_VALID, N_VALID, M_VALID)));
		assert(MSJ_T_VALUE_INVALID.equals(controller.validarParametros(T_INVALID, N_VALID, M_VALID)));
	}

	/**
	 * Prueba que valida que el valor de n se encuentre dentro de 1 y 100
	 */
	@Test
	public void validateNValue() {

		assert("".equals(controller.validarParametros(T_VALID, N_VALID, M_VALID)));
		assert(MSJ_T_VALUE_INVALID.equals(controller.validarParametros(T_VALID, N_INVALID, M_VALID)));
	}

	/**
	 * Prueba que valida que el valor de m se encuentre dentro de 1 y 1000
	 */
	@Test
	public void validateMValue() {

		assert("".equals(controller.validarParametros(T_VALID, N_VALID, M_VALID)));
		assert(MSJ_T_VALUE_INVALID.equals(controller.validarParametros(T_VALID, N_VALID, M_INVALID)));
	}

	/**
	 * Prueba que valida que el valor de X sea mayor que 1 y que este debajo dle
	 * valor de n
	 */
	@Test
	public void validateXValue() {

		assert("".equals(controller.validarValoresXyz(POS_VALID, POS_VALID, POS_VALID, W_VALID, N_VALID)));
		assert(MSJ_X_VALUE_INVALID
				.equals(controller.validarValoresXyz(POS_INVALID, POS_VALID, POS_VALID, W_VALID, N_VALID)));
	}

	/**
	 * Prueba que valida que el valor de Y sea mayor que 1 y que este debajo dle
	 * valor de n
	 */
	@Test
	public void validateYValue() {

		assert("".equals(controller.validarValoresXyz(POS_VALID, POS_VALID, POS_VALID, W_VALID, N_VALID)));
		assert(MSJ_Y_VALUE_INVALID
				.equals(controller.validarValoresXyz(POS_VALID, POS_INVALID, POS_VALID, W_VALID, N_VALID)));
	}

	/**
	 * Prueba que valida que el valor de Z sea mayor que 1 y que este debajo dle
	 * valor de n
	 */
	@Test
	public void validateZValue() {

		assert("".equals(controller.validarValoresXyz(POS_VALID, POS_VALID, POS_VALID, W_VALID, N_VALID)));
		assert(MSJ_Y_VALUE_INVALID
				.equals(controller.validarValoresXyz(POS_VALID, POS_VALID, POS_INVALID, W_VALID, N_VALID)));
	}

	/**
	 * Prueba que valida que el valor de W se encunetre dentro de 10^9 y -10^9
	 */
	@Test
	public void validateWValue() {

		assert("".equals(controller.validarValoresXyz(POS_VALID, POS_VALID, POS_VALID, W_VALID, N_VALID)));
		assert(MSJ_W_VALUE_INVALID
				.equals(controller.validarValoresXyz(POS_VALID, POS_VALID, POS_VALID, W_INVALID, N_VALID)));
	}
	
	/**
	 * Prueba buscar validar el correcto funcionamiento de el metodo que actualiza los datos
	 * actualizando el valor en la posicion 2
	 */
	@Test
	public void actualizarPosDosExitosa(){

		assert(controller.actualizarValorPunto(POS_DOS, POS_DOS, POS_DOS, W_VALID, puntos));
	}
	
	/**
	 * Prueba buscar validar el correcto funcionamiento de el metodo que actualiza los datos
	 * actualizando el valor en la posicion 2
	 */
	@Test
	public void actualizarPosDosFallida(){

		assert(!controller.actualizarValorPunto(POS_DIEZ, POS_DIEZ, POS_DIEZ, W_VALID, puntos));
	}
	
	/**
	 * Prueba para verificar que las consultas se realizan de manera exitosa
	 * consultando el valor de W que actualizamos en la parte anterior
	 */
	@Test
	public void queryExitoso(){
		
		assert(controller.consultarValor(POS_DOS, POS_DOS, POS_DOS, POS_DOS, POS_DOS, POS_DOS, puntos) == W_VALID);
	}
	
	/**
	 * Prueba para verificar que las consultas se realizan de manera exitosa y 
	 * retorna 0 cuando no se encuentra el valor
	 */
	@Test
	public void queryFallido(){
		
		assert(controller.consultarValor(POS_DIEZ, POS_DIEZ, POS_DIEZ, POS_DIEZ, POS_DIEZ, POS_DIEZ, puntos) != W_VALID);
	}

}
