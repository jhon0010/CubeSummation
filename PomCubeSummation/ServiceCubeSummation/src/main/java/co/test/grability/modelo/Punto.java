package co.test.grability.modelo;

/**
 * Clase que representa un punto dentro de un cubo de 3 dimensiones
 * @author jhon
 *
 */
public class Punto {

	long x = 0; // posicion x
	long y = 0; // posicion y
	long z = 0; // posicion z
	long w = 0; // valor del punto
	
	/**
	 * Constructor por defecto de la clase
	 */
	public Punto() {
		super();
	}

	/**
	 * Constructor que permite instanciar la clase con 
	 * los valores de la posiciones del punto ya establecidas
	 * y el valor que almacenan en esta posicion
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public Punto(long x, long y, long z, long w) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	
// ------------------------------------- GUETTERS AND SETTERS ----------------------	

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public long getZ() {
		return z;
	}

	public void setZ(long z) {
		this.z = z;
	}

	public long getW() {
		return w;
	}

	public void setW(long w) {
		this.w = w;
	}
	
}
