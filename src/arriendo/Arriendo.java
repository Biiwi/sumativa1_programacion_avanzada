package src.arriendo;

import java.time.LocalDate;
import src.cliente.Cliente;
import src.vehiculo.Vehiculo;

//Clase Arriendo para manejar el proceso de arriendo de vehículos
public class Arriendo {
    private int idArriendo; //Identificador único del arriendo
    private Cliente cliente; //Cliente que realiza el arriendo
    private Vehiculo vehiculo; //Vehículo que se arrienda
    private LocalDate fechaArriendo; //Fecha en que se realiza el arriendo
    private int diasArriendo; //Cantidad de días que se arrienda el vehículo
    private int precioDiario; //Precio diario del arriendo

    //Constructor de la clase Arriendo, solicita como parámetros idArriendo, Cliente, Vehículo, fecha de arriendo, días de arriendo y precio diario
    public Arriendo(int idArriendo, Cliente cliente, Vehiculo vehiculo, LocalDate fechaArriendo, int diasArriendo, int precioDiario) {
        this.idArriendo = idArriendo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaArriendo = fechaArriendo;
        this.diasArriendo = diasArriendo;
        this.precioDiario = precioDiario;
    }

    public boolean ValidarDiasArriendo(){
        if(this.diasArriendo > 1 && this.diasArriendo < 10){
            return true;
        } else {
            EnviarMensajeDeSistema("La cantidad de días para el arriendo debe ser entre 2 y 9 días.");
            return false;
        }
    }
    //Método publico para evaluar si el arriendo puede ser realizado
    public boolean EvaluarArriendo() {
        if (!this.cliente.ValorVigencia()) { //Verifica si el cliente está vigente
            EnviarMensajeDeSistema("El cliente no está vigente. No se puede realizar el arriendo.");
            return false;
        }
        if (this.vehiculo.ValorCondicion() != "D") { //Verifica si el vehículo está disponible para arrendar
            EnviarMensajeDeSistema("El vehículo no está disponible para arrendar.");
            return false;
        }
        EnviarMensajeDeSistema("Arriendo aprobado para el cliente " + this.cliente.ValorNombre() + " y el vehículo " + this.vehiculo.ValorPatente() +".");
        return true;
    }

    //Método público para ingresar el arriendo si es aprobado
    public boolean IngresarArriendo() {
        EnviarMensajeDeSistema("Verificando si el arriendo es válido");
        if (!EvaluarArriendo()) { //Verifica si el arriendo fue aprobado
            return false;
        }
        this.vehiculo.ModificarCondicion("A"); //Cambia la condición del vehículo a "A" (Arrendado)
        EnviarMensajeDeSistema("Arriendo ingresado exitosamente. Entregando ticket...");
        GenerarTicketArriendo(); //Genera el ticket de arriendo
        return true;
    }

    //Metodo público para calcular el precio total del arriendo
    public int PrecioTotal(){
        return this.precioDiario * this.diasArriendo;
    }

    //Metodo público para obtener el objeto vehículo arrendado
    public Vehiculo ObtenerVehiculo(){
        return this.vehiculo;
    }

    //Metodo público para obtener la fecha de arriendo
    public LocalDate ObtenerFechaArriendo(){
        return this.fechaArriendo;
    }

    //Método público para generar el ticket de arriendo
    public void GenerarTicketArriendo() {
        System.out.println("------------- Ticket de Arriendo -------------");
        System.out.println("        Numero Arriendo : " + this.idArriendo);
        System.out.println("        Vehículo        : " + this.vehiculo.ValorPatente() + " " + this.vehiculo.ValorNombre());
        System.out.println("        Precio Diario   : $" + this.precioDiario);
        System.out.println(" ");
        System.out.println("Fecha       Cliente         Días        A Pagar");
        System.out.println("----------------------------------------------");
        System.out.println(this.fechaArriendo+ "       " + this.cliente.ValorNombre() + "     " + this.diasArriendo + "          $" + PrecioTotal());
        System.out.println("----------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                                     _____________");
        System.out.println("                                     Firma Cliente");
    }

    //Método público para enviar mensajes al sistema
    public void EnviarMensajeDeSistema(String mensaje){
        System.err.println(mensaje);
    }
}
