package co.test.grability.contract;

import co.test.grability.modelo.Punto;

/**
 * Interface encargada de definir los metodos 
 * que se pueden ejecutar en la aplicacion
 * @author jhon
 *
 */
public interface ICubeController {
	
	/**
	 * Metodo que permite settear un valor "w" a un punto 
	 * 3D en la poscion indicada x,y,z
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @return  true si la actualizacion del valor es exitosa
	 * 			false si la actualizacion presento algun fallo 
	 */
	public boolean actualizarValorPunto(long x, long y, long z, long w, Punto[] puntos);
	
	/**
	 * Metodo que nos permite conocer el total de los valores acumulados 
	 * de los puntos 3D, que se encuentren dentro de las coordenadas x1,y1,z1
	 * hasta los puntos que se encuentren en las coordenas de x2,y2,z2
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param x2
	 * @param y2
	 * @param z2
	 * @return La suma de los valores encontrados en los puntos que esten dentro de las coordenadas dadas
	 */
	public long consultarValor(long x1, long y1, long z1,long x2, long y2, long z2, Punto[] puntos);
}
