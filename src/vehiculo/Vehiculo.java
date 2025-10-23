package src.vehiculo;

import java.util.Scanner;
import src.misc.Misc;

//Clase Vehiculo para manejar la información y estado de los vehículos
public class Vehiculo {
    private String patente; //Patente del vehículo en formato AAAA00-0
    private String marca; //Marca del vehículo
    private String modelo; //Modelo del vehículo
    private int anio; //Año de fabricación del vehículo
    private String condicion; //Condición del vehículo: "D" (Disponible), "A" (Arrendado), "M" (Mantención)

    //Constructor de la clase Vehiculo, solicita como parámetros patente, marca, modelo y año de fabricación
    public Vehiculo(String patente, String marca, String modelo, int anio) {
        this.patente = patente.toUpperCase();
        this.marca = marca.toUpperCase();
        this.modelo = modelo.toUpperCase();
        this.anio = anio;
        this.condicion = "D";
    }

    //Método público para validar el formato de la patente
    public boolean  validarPatente() {
        String estructuraPatente = "^[A-Z]{4}\\d{2}-\\d{1}$";
        if (!this.patente.matches(estructuraPatente) || this.patente.length() != 8) {
            EnviarMensajeDeSistema("Patente no cumple con formato solicitado.");
            return false;
        }
        return true;
    }

    //Método público para validar el año de fabricación
    public boolean  validarAnioFabricacion(){
        if(this.anio >= 2000 && this.anio <= 2025){
            return true;
        } else {
            EnviarMensajeDeSistema("Año de fabricación inválido. Debe estar entre 2000 y 2024.");
            return false;
        }
    }

    //Método público para enviar el vehículo a mantención, solo permitido si no está arrendado
    public void VehiculoAMantencion(){
        if (this.condicion.equals("A")){ //Verifica si el vehículo está arrendado
            EnviarMensajeDeSistema("El vehiculo patente "+ this.patente + " se encuentra arrendado. No es posible enviar a mantención");
            return;
        }
        Scanner scanner = new Scanner(System.in); //Inicializa scanner para leer entrada del usuario
        EnviarMensajeDeSistema("Ingrese la contraseña del gerente para enviar el vehículo a mantención: ");
        String inputPass = scanner.nextLine(); //Ingreso de contraseña para validar permisos de gerente
        Misc misc = new Misc(); //Utiliza la clase Misc para obtener la contraseña del gerente
        if (!inputPass.equals(misc.getPassGerente())) { //Compara la contraseña ingresada con la del gerente
            EnviarMensajeDeSistema("Contraseña incorrecta. No se puede enviar el vehículo a mantención.");
            return;
        }
        EnviarMensajeDeSistema("Contraseña correcta. Vehículo patente "+ this.patente +" enviado a mantención.");
        this.condicion = "M"; //Cambia la condición del vehículo a "M" (Mantención)
    }

    //Método público para obtener condicion actual del vehículo
    public String ValorCondicion(){
        return this.condicion;
    }

    //Método público para obtener patente del vehículo
    public String ValorPatente(){
        return this.patente;
    }

    //Método público para obtener año de fabricación del vehículo
    public int ValorAnio(){
        return this.anio;
    }

    //Método público para obtener nombre completo del vehículo (marca + modelo)
    public String ValorNombre(){
        return this.marca + " " + this.modelo;
    }

    //Método público para modificar la condición del vehículo
    public void ModificarCondicion(String condicion) {
        this.condicion = condicion;
    }

    //Método público para enviar mensajes al sistema
    public void EnviarMensajeDeSistema(String mensaje){
        System.err.println(mensaje);
    }

    //Método público para mostrar la información del vehículo
    public void MostrarInfoVehiculo(){
        System.out.println("Patente: " + this.patente);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año de Fabricación: " + this.anio);
        System.out.println("Condición: " + this.condicion);
    }
}
