package src.devolucion;

import java.time.LocalDate;
import src.arriendo.Arriendo;
import src.vehiculo.Vehiculo;

//Clase Devolucion para manejar el proceso de devolución de vehículos
public class Devolucion {
    private Arriendo arriendo; //Arriendo asociado a la devolución
    private LocalDate fechaDevolucion; //Fecha en que se realiza la devolución

    //Constructor de la clase Devolucion, solicita como parámetros el Arriendo y la fecha de devolución
    public Devolucion(Arriendo arriendo, LocalDate fechaDevolucion) {
        this.arriendo = arriendo;
        this.fechaDevolucion = fechaDevolucion;
    }

    //Método publico para validar la fecha de devolución
    public boolean ValidarFechaDevolucion(LocalDate fechaDevolucion) {
        if (fechaDevolucion.isBefore(this.arriendo.ObtenerFechaArriendo())) { //Verifica si la fecha de devolución es anterior a la fecha de arriendo
            EnviarMensajeDeSistema("La fecha de devolución no puede ser anterior a la fecha de arriendo.");
            return false;
        }
        return true;
    }

    //Método público para ingresar la devolución del vehículo ingresando el objeto Clase vehículo a devolver
    public boolean IngresarDevolucionVehiculo(Vehiculo vehiculoADevolver) {
        Vehiculo vehiculoArrendado = arriendo.ObtenerVehiculo(); //Obtiene el vehículo arrendado desde el arriendo asociado
        if (!vehiculoADevolver.ValorPatente().equals(vehiculoArrendado.ValorPatente())) { //Compara la patente del vehículo a devolver con la del vehículo arrendado
            EnviarMensajeDeSistema("El vehículo a devolver no coincide con el vehículo arrendado.");
            return false;
        }
        if (!vehiculoADevolver.ValorNombre().equals(vehiculoArrendado.ValorNombre())) { //Compara la marca del vehículo a devolver con la del vehículo arrendado
            EnviarMensajeDeSistema("El vehículo a devolver no coincide con el vehículo arrendado.");
            return false;
        }
        if (vehiculoADevolver.ValorAnio() != vehiculoArrendado.ValorAnio()) { //Compara el año del vehículo a devolver con el del vehículo arrendado
            EnviarMensajeDeSistema("El vehículo a devolver no coincide con el vehículo arrendado.");
            return false;
        }
        if (vehiculoADevolver.ValorCondicion() != "A") { //Verifica si el vehículo está en condición de arrendado
            EnviarMensajeDeSistema("El vehículo no está en condición de arrendado. No se puede procesar la devolución.");
            return false;
        }
        vehiculoADevolver.ModificarCondicion("D"); //Cambia la condición del vehículo a "D" (Disponible)
        EnviarMensajeDeSistema("Devolución ingresada exitosamente.");
        return true;
    }

    //Método público para enviar mensajes al sistema
    public void EnviarMensajeDeSistema(String mensaje){
        System.err.println(mensaje);
    }
}
