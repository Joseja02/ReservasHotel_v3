package org.iesalandalus.programacion.reservashotel.modelo.dominio;

import java.util.Objects;

public class Habitacion {
    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;
    public static final double MIN_PRECIO_HABITACION = 40.0;
    public static final double MAX_PRECIO_HABITACION = 150.0;
    public static final int MIN_NUMERO_PUERTA = 0;
    public static final int MAX_NUMERO_PUERTA = 14;
    public static final int MIN_NUMERO_PLANTA = 1;
    public static final int MAX_NUMERO_PLANTA = 3;

    public String getIdentificador() {
        return identificador;
    }
    private void setIdentificador(String identificador) {
        if (identificador == null){
            throw new NullPointerException("ERROR: El identificador no puede ser nulo.");
        }

        identificador = String.valueOf(this.planta) + String.valueOf(this.puerta);
        this.identificador = identificador;
    }
    private void setIdentificador(){
        this.identificador = String.valueOf(this.planta) + String.valueOf(this.puerta);
    }

    public int getPlanta() {
        return planta;
    }

    private void setPlanta(int planta) {

        if (planta < MIN_NUMERO_PLANTA || planta > MAX_NUMERO_PLANTA){
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitaci�n un valor menor que 1 ni mayor que 3.");
        }
        this.planta = planta;
    }

    public int getPuerta() {
        return puerta;
    }

    private void setPuerta(int puerta) {

        if (puerta > MAX_NUMERO_PUERTA || puerta < MIN_NUMERO_PUERTA){
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitaci�n un valor menor que 0 ni mayor que 14.");
        }
        this.puerta = puerta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        if (precio > MAX_PRECIO_HABITACION || precio < MIN_PRECIO_HABITACION){
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitaci�n un valor menor que 40.0 ni mayor que 150.0.");
        }
        this.precio = precio;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {

        if (tipoHabitacion == null){
            throw new NullPointerException("ERROR: No se puede establecer un tipo de habitaci�n nula.");
        }

        this.tipoHabitacion = tipoHabitacion;
    }

    public Habitacion (int planta, int puerta, double precio){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        tipoHabitacion = TipoHabitacion.SIMPLE;
        setIdentificador();
    }

    public Habitacion (int planta, int puerta, double precio, TipoHabitacion tipoHabitacion){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        setIdentificador();
    }

    public Habitacion (Habitacion habitacionCopia){
        if (habitacionCopia == null){
            throw new NullPointerException("ERROR: No es posible copiar una habitaci�n nula.");
        }
        this.identificador = habitacionCopia.getIdentificador();
        this.planta = habitacionCopia.getPlanta();
        this.puerta = habitacionCopia.getPuerta();
        this.precio = habitacionCopia.getPrecio();
        this.tipoHabitacion = habitacionCopia.getTipoHabitacion();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(identificador, that.identificador);
    }
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return "identificador=" + getIdentificador() +
                " (" + planta + "-" + puerta + ")" +
                ", precio habitaci�n=" + getPrecio() +
                ", tipo habitaci�n=" + getTipoHabitacion();
    }
}
