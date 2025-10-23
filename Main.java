import java.time.LocalDate;
import src.arriendo.Arriendo;
import src.cliente.Cliente;
import src.devolucion.Devolucion;
import src.misc.Misc;
import src.vehiculo.Vehiculo;


//Clase Main para ejecutar el programa principal
public class Main {

    //Método principal para ejecutar el programa
    public static void main(String[] args) {
        Misc misc = new Misc();

        misc.ImprimirSeparador("A)CREAR CLIENTE");

        //Ejemplo creacion cliente con datos asignados directamente
        Cliente nuevoCliente = new Cliente("12345678-9", "Juan Perez");
        if (!nuevoCliente.ValidarRut()){ //Validacion de rut del cliente
            return;
        }
        nuevoCliente.MostrarInfoCliente(); //Muestra la información del cliente creado

        misc.ImprimirSeparador("B)CREAR VEHICULO");
        //Ejemplo creacion vehiculo con datos asignados directamente
        Vehiculo nuevoVehiculo = new Vehiculo("ABCD12-2", "Toyota", "Corolla", 2020);
        if (!nuevoVehiculo.validarPatente() || !nuevoVehiculo.validarAnioFabricacion()){ //Validacion de patente y año de fabricación del vehículo
            return;
        }
        nuevoVehiculo.MostrarInfoVehiculo(); //Muestra la información del vehículo creado

        misc.ImprimirSeparador("C)DESHABILITAR CLIENTE");
        //Ejemplo deshabilitacion de cliente (requiere contraseña de gerente)
        nuevoCliente.DeshabilitarCliente();
        nuevoCliente.MostrarInfoCliente(); //Muestra la información del cliente después de deshabilitarlo

        
        misc.ImprimirSeparador("D)ENVIAR VEHICULO A MANTENCION");

        nuevoVehiculo.VehiculoAMantencion(); //Envio del vehículo a mantención (requiere contraseña de gerente)
        nuevoVehiculo.MostrarInfoVehiculo(); //Muestra la información del vehículo después de enviarlo a mantención

        misc.ImprimirSeparador("E)REALIZAR ARRIENDO CORRECTO Y ARRIENDO FALLIDO");
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
        if(!nuevoArriendo.ValidarDiasArriendo()) { return;} //Valida que los días de arriendo estén dentro del rango permitido
        nuevoArriendo.IngresarArriendo(); //Valida e ingresa arriendo satisfactoriamente, luego genera el ticket
        nuevoVehiculo2.MostrarInfoVehiculo(); //Muestra la información del vehículo después de ser arrendado
        System.out.println("");
        System.out.println("");
        //Arriendo fallido por vehículo ya arrendado
        Arriendo arriendoFallido = new Arriendo(2, nuevoCliente2, nuevoVehiculo2, LocalDate.of(2025,5,10), 3, 15000);
        if(!arriendoFallido.ValidarDiasArriendo()) { return;} //Valida que los días de arriendo estén dentro del rango permitido
        arriendoFallido.IngresarArriendo();  //Al validar si el vehículo está disponible, el arriendo es rechazado

        misc.ImprimirSeparador("F)REALIZAR DEVOLUCION CORRECTA Y DEVOLUCION FALLIDA");
        //Devolución correcta
        Devolucion nuevaDevolucion = new Devolucion(nuevoArriendo, LocalDate.of(2025,7,10));
        nuevaDevolucion.ValidarFechaDevolucion(LocalDate.of(2025,7,10)); //Valida la fecha de devolución
        nuevaDevolucion.IngresarDevolucionVehiculo(nuevoVehiculo2);
        nuevoVehiculo2.MostrarInfoVehiculo(); //Muestra la información del vehículo después de ser devuelto
        
        System.out.println("");
        System.out.println("");
        //Devolución fallida porque el vehículo ya no se encuentra arrendado
        Devolucion devolucionFallida = new Devolucion(nuevoArriendo, LocalDate.of(2025,7,10));
        devolucionFallida.ValidarFechaDevolucion(LocalDate.of(2025,7,10)); //Valida la fecha de devolución
        devolucionFallida.IngresarDevolucionVehiculo(nuevoVehiculo2); //Este vehículo ya se devolvió, por lo que la devolución es rechazada
        nuevoVehiculo2.MostrarInfoVehiculo(); //Muestra la información del vehículo después del intento fallido de devolución
    }

}

