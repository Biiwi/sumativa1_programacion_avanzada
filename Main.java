import java.time.LocalDate;
import src.arriendo.Arriendo;
import src.cliente.Cliente;
import src.devolucion.Devolucion;
import src.vehiculo.Vehiculo;


//Clase Main para ejecutar el programa principal
public class Main {

    //Método principal para ejecutar el programa
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("---------A)CREAR CLIENTE----------------");
        System.out.println("");

        //Ejemplo creacion cliente con datos asignados directamente
        Cliente nuevoCliente = new Cliente("12345678-9", "Juan Perez");
        if (!nuevoCliente.ValidarRut()){ //Validacion de rut del cliente
            return;
        }
        nuevoCliente.MostrarInfoCliente(); //Muestra la información del cliente creado

        System.out.println("");
        System.out.println("---------B)CREAR VEHICULO----------------");
        System.out.println("");
        //Ejemplo creacion vehiculo con datos asignados directamente
        Vehiculo nuevoVehiculo = new Vehiculo("ABCD12-2", "Toyota", "Corolla", 2020);
        if (!nuevoVehiculo.validarPatente() || !nuevoVehiculo.validarAnioFabricacion()){ //Validacion de patente y año de fabricación del vehículo
            return;
        }
        nuevoVehiculo.MostrarInfoVehiculo(); //Muestra la información del vehículo creado
        System.out.println("");
        System.out.println("---------C)DESHABILITAR CLIENTE----------------");
        System.out.println("");
        //Ejemplo deshabilitacion de cliente (requiere contraseña de gerente)
        nuevoCliente.DeshabilitarCliente();
        nuevoCliente.MostrarInfoCliente(); //Muestra la información del cliente después de deshabilitarlo
        
        System.out.println("");
        System.out.println("---------D)ENVIAR VEHICULO A MANTENCION----------------");
        System.out.println("");
        nuevoVehiculo.VehiculoAMantencion(); //Envio del vehículo a mantención (requiere contraseña de gerente)
        nuevoVehiculo.MostrarInfoVehiculo(); //Muestra la información del vehículo después de enviarlo a mantención

        System.out.println("");
        System.out.println("---------E)REALIZAR ARRIENDO CORRECTO Y ARRIENDO FALLIDO----------------");
        System.out.println("");
        //Nuevo cliente y vehículo para realizar arriendo
        Cliente nuevoCliente2 = new Cliente("07654321-K", "Ana Gomez");
        if (!nuevoCliente2.ValidarRut()){ //Validacion de rut del cliente
            return;
        }
        Vehiculo nuevoVehiculo2 = new Vehiculo("WXYZ34-3", "Honda", "Civic", 2021);
        if (!nuevoVehiculo2.validarPatente() || !nuevoVehiculo2.validarAnioFabricacion()){ //Validacion de patente y año de fabricación del vehículo
            return;
        }

        //Arriendo correcto
        Arriendo nuevoArriendo = new Arriendo(1, nuevoCliente2, nuevoVehiculo2, LocalDate.of(2025,5,10), 5, 20000);
        nuevoArriendo.IngresarArriendo(); //Valida e ingresa arriendo satisfactoriamente, luego genera el ticket
        nuevoVehiculo2.MostrarInfoVehiculo(); //Muestra la información del vehículo después de ser arrendado
        System.out.println("");
        System.out.println("");
        //Arriendo fallido por vehículo ya arrendado
        Arriendo arriendoFallido = new Arriendo(2, nuevoCliente2, nuevoVehiculo2, LocalDate.of(2025,5,10), 3, 15000);
        arriendoFallido.IngresarArriendo();  //Al validar si el vehículo está disponible, el arriendo es rechazado

        System.out.println("");
        System.out.println("---------F)REALIZAR DEVOLUCION CORRECTA Y DEVOLUCION FALLIDA----------------");
        System.out.println("");
        //Devolución correcta
        Devolucion nuevaDevolucion = new Devolucion(nuevoArriendo, LocalDate.of(2025,7,10));
        nuevaDevolucion.IngresarDevolucionVehiculo(nuevoVehiculo2);
        nuevoVehiculo2.MostrarInfoVehiculo(); //Muestra la información del vehículo después de ser devuelto
        
        System.out.println("");
        System.out.println("");
        //Devolución fallida porque el vehículo ya no se encuentra arrendado
        Devolucion devolucionFallida = new Devolucion(nuevoArriendo, LocalDate.of(2025,7,10));
        devolucionFallida.IngresarDevolucionVehiculo(nuevoVehiculo2); //Este vehículo ya se devolvió, por lo que la devolución es rechazada
        nuevoVehiculo2.MostrarInfoVehiculo(); //Muestra la información del vehículo después del intento fallido de devolución
    }

}

