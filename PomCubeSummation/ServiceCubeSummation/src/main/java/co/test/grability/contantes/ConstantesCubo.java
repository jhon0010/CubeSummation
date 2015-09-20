package co.test.grability.contantes;

/**
 * Clase que permite tener todas las constantes necesarias 
 * para las validaciones y demas de las acciones del cubo
 * @author jhon
 *
 */
public class ConstantesCubo {
	
	// --------------------------- RUTA ARCHIVO ENTRAD -----------------------
	public static final String RUTA_ARCHIVO = ".//src/main//resources//Informacion.txt";
	
	// ---------------------------- PALABRAS PARA LAS ACCIONES ------------------------
	
	public static final String UPDATE = "UPDATE";
	public static final String QUERY = "QUERY";
	
	//----------------------------- VALORES A VALIDAR -----------------------------------

	public static final int T_MIN_VAL = 1; // valor minimo de T en cube controller
	public static final int T_MAX_VAL = 50; // valor maximo de T en cube controller
	
	public static final int N_MIN_VAL = 1; // valor minimo de N en cube controller
	public static final int N_MAX_VAL = 100; // valor maximo de N en cube controller
	
	public static final int M_MIN_VAL = 1; // valor minimo de M en cube controller
	public static final int M_MAX_VAL = 1000; // valor maximo de M en cube controller
	
	public static final int W_MIN_VAL = -1000000000; // valor minimo de M en cube controller
	public static final int W_MAX_VAL = 1000000000; // valor maximo de M en cube controller
	
	public static final int POS_MIN_VAL = 1; // valor minimo de una posicion del punto (xyz)
	
	// ----------------------------- MENSAJES DE ERROR ------------------
	
	public static final String MSJ_T_VALUE_INVALID = "El valor de la variable t no se encuentra dentro del rango permitido " + T_MIN_VAL + " y " + T_MAX_VAL;
	public static final String MSJ_N_VALUE_INVALID = "El valor de la variable n no se encuentra dentro del rango permitido " + N_MIN_VAL + " y " + N_MAX_VAL;
	public static final String MSJ_M_VALUE_INVALID = "El valor de la variable m no se encuentra dentro del rango permitido " + M_MIN_VAL + " y " + M_MAX_VAL;
	public static final String MSJ_X_VALUE_INVALID = "El valor de la variable x no se encuentra dentro del rango permitido " + POS_MIN_VAL + " y el valor de n";
	public static final String MSJ_Y_VALUE_INVALID = "El valor de la variable y no se encuentra dentro del rango permitido " + POS_MIN_VAL + " y el valor de n";
	public static final String MSJ_Z_VALUE_INVALID = "El valor de la variable z no se encuentra dentro del rango permitido " + POS_MIN_VAL + " y el valor de n";
	public static final String MSJ_W_VALUE_INVALID = "El valor de la variable w no se encuentra dentro del rango permitido " + W_MIN_VAL + " y " + W_MAX_VAL;
	public static final String MSJ_COORDENADAS_NOT_EXIST = "Las coordenadas proporcionadas no existen dentro de los puntos creados";
	
	// ------------------------------- TEST CONSTANTS ---------------------
	
	public final static int T_VALID = 2;
	public final static int N_VALID = 100;
	public final static int M_VALID = 1000;
	
	public final static int T_INVALID = 0;
	public final static int N_INVALID = 101;
	public final static int M_INVALID = 1001;
	
	public final static int POS_VALID = 1;
	public final static int POS_INVALID =0;
}
