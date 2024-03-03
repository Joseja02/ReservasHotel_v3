package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Doble extends Habitacion {
    private static final int NUM_MAXIMO_PERSONAS = 2;
    public static final int MIN_NUM_CAMAS_INDIVIDUALES = 0;
    protected static final int MAX_NUM_CAMAS_INDIVIDUALES = 2;
    protected static final int MIN_NUM_CAMAS_DOBLES = 0;
    protected static final int MAX_NUM_CAMAS_DOBLES = 1;
    private int numCamasIndividuales;
    private int numCamasDobles;

    public Doble(int planta, int puerta, double precio, int numCamasIndividuales, int numCamasDobles) {
        super(planta, puerta, precio);
        setNumCamasIndividuales(numCamasIndividuales);
        setNumCamasDobles(numCamasDobles);
        validaNumCamas();
    }
    public Doble(Doble habitacionDoble) {
        super(habitacionDoble);
        this.numCamasIndividuales = getNumCamasIndividuales();
        this.numCamasDobles = getNumCamasDobles();
    }
    public int getNumCamasIndividuales() {
        return numCamasIndividuales;
    }
    public void setNumCamasIndividuales(int numCamasIndividuales) {
        if (numCamasIndividuales < 0){
            throw new NullPointerException("ERROR: No pueden haber -1 camas individuales.");
        }
        this.numCamasIndividuales = numCamasIndividuales;
    }
    public int getNumCamasDobles() {
        return numCamasDobles;
    }
    public void setNumCamasDobles(int numCamasDobles) {
        if (numCamasDobles < 0){
            throw new NullPointerException("ERROR: No pueden haber -1 camas dobles.");
        }
        this.numCamasDobles = numCamasDobles;
    }
    private void validaNumCamas(){
        if ((numCamasIndividuales == MAX_NUM_CAMAS_INDIVIDUALES && numCamasDobles == MIN_NUM_CAMAS_DOBLES) || (numCamasIndividuales == MIN_NUM_CAMAS_INDIVIDUALES && numCamasDobles == MAX_NUM_CAMAS_DOBLES)){
            //No se lanza excepcion puesto que o hay 2 camas individuales o hay 1 cama doble.
        } else {
            throw new IllegalArgumentException("ERROR: El número de camas es incorrecto.");
        }
    }
    @Override
    public int getNumeroMaximoPersonas() { return NUM_MAXIMO_PERSONAS; }
    @Override
    public String toString() {
        return "Doble{" +
                "numCamasIndividuales=" + numCamasIndividuales +
                ", numCamasDobles=" + numCamasDobles +
                ", identificador='" + identificador + '\'' +
                ", planta=" + planta +
                ", puerta=" + puerta +
                ", precio=" + precio +
                '}';
    }
}
