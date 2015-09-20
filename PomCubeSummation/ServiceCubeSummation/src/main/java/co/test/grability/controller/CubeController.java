package co.test.grability.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import co.test.grability.contantes.ConstantesCubo;
import co.test.grability.contract.ICubeController;
import co.test.grability.modelo.Punto;

/**
 * Clase encargada de tener las operaciones relacionadas al cubo
 * 
 * @author jhon
 *
 */
public class CubeController extends ConstantesCubo implements ICubeController {


	/**
	 * Metodo encargado de ejercutar los metodos solicitados al leer el archivo
	 */
	public void ejecutarAcciones() {

		BufferedReader bRead = null ;
		int t = 0; //  Numero de llamdos a los metodos
		int n = 0; //  Define el tamannio maximo que puede tener el cubo
		int m = 0; // Define el numero de operaciones que se van a realizar
		Punto[] puntos = null;
		
		try {
			
			String cadena;
			File fileData = new File(RUTA_ARCHIVO);
			FileReader fRead = new FileReader(fileData);
			bRead = new BufferedReader(fRead);
			
			while ((cadena = bRead.readLine()) != null) {
				
				String[] tokens = cadena.split(" ");
				
				if (tokens.length == 1 && !"".equals(tokens[0])){
					t = Integer.parseInt(tokens[0]);
				}
				
				if (tokens.length == 2  && !"".equals(tokens[0])){
					n = Integer.parseInt(tokens[0]);
					m = Integer.parseInt(tokens[1]);
					
					String msjError = this.validarParametros(t, n, m);
					if (!"".equals(msjError)) {				
						System.out.println(msjError);
						return;
					} else {
						puntos = new Punto[n];
						for (int i = 0; i < puntos.length; i++) {
							long pos = i +1;
							puntos[i] = new Punto(pos,pos,pos,0);
						}
					}
				}
				
				if (tokens.length == 5  && !"".equals(tokens[0]) && UPDATE.equals(tokens[0])){

					if (puntos != null){
						
						long x = Long.parseLong(tokens[1]);
						long y = Long.parseLong(tokens[2]);
						long z = Long.parseLong(tokens[3]);
						long w = Long.parseLong(tokens[4]);
						
						if (!actualizarValorPunto(x, y, z, w, puntos)){
							System.out.println(MSJ_COORDENADAS_NOT_EXIST + x + "," + y + "," + z);
						}
					}	
				}
				
				if (tokens.length == 7  && !"".equals(tokens[0]) && QUERY.equals(tokens[0])){
					if (puntos != null){
						
						long x1 = Long.parseLong(tokens[1]);
						long y1 = Long.parseLong(tokens[2]);
						long z1 = Long.parseLong(tokens[3]);
						long x2 = Long.parseLong(tokens[4]);
						long y2 = Long.parseLong(tokens[5]);
						long z2 = Long.parseLong(tokens[6]);
						
						long total = consultarValor(x1, y1, z1, x2, y2, z2, puntos);
						System.out.println(total);
					}
				}
				
			}
		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (bRead != null) {
				try {
					bRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @see ICubeController
	 */
	public boolean actualizarValorPunto(long x, long y, long z, long w, Punto[] puntos) {

		for (int i = 0; i < puntos.length; i++) {
			if (puntos[i].getX() == x && puntos[i].getY() == y && puntos[i].getZ() == z){
				
				puntos[i].setW(w);
				return true;
			}
		}

		return false;
	}

	/**
	 * @see ICubeController
	 */
	public long consultarValor(long x1, long y1, long z1, long x2, long y2, long z2, Punto[] puntos) {
		
		long total = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			if (puntos[i].getX() >= x1 && puntos[i].getY() >= y1 && puntos[i].getZ() >= z1){
				if (puntos[i].getX() <= x2 && puntos[i].getY() <= y2 && puntos[i].getZ() <= z2){
					
					total += puntos[i].getW();
				} else {
					return total;
				}
			}
		}
		
		return total;
	}

	/**
	 * Metodo que permite validar los parametros de entrada a la prueba
	 * 
	 * @param t
	 * @param n
	 * @param m
	 * @return cadena vacia si no se encontraron problemas, si la cadena no esta
	 *         vacia devuelve el mensaje del error
	 */
	public String validarParametros(int t, int n, int m) {

		String msjError = "";

		if (t < T_MIN_VAL || t > T_MAX_VAL) {
			return MSJ_T_VALUE_INVALID;
		}

		if (n < N_MIN_VAL || n > N_MAX_VAL) {
			return MSJ_N_VALUE_INVALID;
		}

		if (m < M_MIN_VAL || m > M_MAX_VAL) {
			return MSJ_M_VALUE_INVALID;
		}

		return msjError;
	}

	/**
	 * Metodo que permite validar los parametros de entrada a la prueba
	 * 
	 * @param X
	 * @param Y
	 * @param x
	 * @param z
	 * @param n
	 *            = necesario para hacer la valdiacion
	 * @return cadena vacia si no se encontraron problemas, si la cadena no esta
	 *         vacia devuelve el mensaje del error
	 */
	public String validarValoresXyz(long x, long y, long z, long w, int n) {

		String msjError = "";

		if (x < POS_MIN_VAL || x > n) {
			return MSJ_X_VALUE_INVALID;
		}

		if (y < POS_MIN_VAL || y > n) {
			return MSJ_Y_VALUE_INVALID;
		}

		if (z < POS_MIN_VAL || z >= n) {
			return MSJ_Z_VALUE_INVALID;
		}

		if (w < W_MIN_VAL || w > W_MAX_VAL) {
			return MSJ_W_VALUE_INVALID;
		}

		return msjError;
	}

}
