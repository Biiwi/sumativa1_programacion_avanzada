package src.cliente;

import java.util.Scanner;
import src.misc.Misc; //Importa la clase Misc para utilizar la contraseña del gerente

//Estructura de clase Cliente
public class Cliente {
    private String rut; //RUT del cliente en formato 12345678-K
    private String nombre; //Nombre completo del cliente
    private boolean vigencia; //Indica si el cliente está vigente (true) o deshabilitado (false)

    //Constructor de clase Cliente Requiere RUT y nombre de cliente
    public Cliente(String rut, String nombre) {
        this.rut = rut.toUpperCase(); //Valida el RUT al momento de crear el cliente
        this.nombre = nombre; //Asigna el nombre del cliente
        this.vigencia = true; //Inicialmente, el cliente está vigente
    }

    //Método publico para validar el formato del RUT
    public boolean ValidarRut() {
        String estructuraRut = "^\\d{8}-[0-9K]$"; //Estructura que debe tener el RUT ingresado
        if (!this.rut.matches(estructuraRut) || this.rut.length() != 10) { //Valida el formato del RUT
            EnviarMensajeDeSistema("RUT inválido. No se puede crear el cliente.");
            return false;
        }
        return true;
    }

    //Método público para deshabilitar al cliente (cambiar vigencia a false) Permitido solo al gerente
    public void DeshabilitarCliente() {
        Scanner scanner = new Scanner(System.in); //Inicializa scanner para leer entrada del usuario
        EnviarMensajeDeSistema("Ingrese la contraseña del gerente para deshabilitar el cliente: ");
        String inputPass = scanner.nextLine(); //Como se requiere solo permisos al gerente, se asignó el uso de contraseña para validación
        Misc misc = new Misc();
        if (!inputPass.equals(misc.getPassGerente())) { //Compara la contraseña ingresada con la del gerente
            EnviarMensajeDeSistema("Contraseña incorrecta. No se puede deshabilitar el cliente.");
            return;
        }
        EnviarMensajeDeSistema("Contraseña correcta. Cliente "+ this.nombre +" deshabilitado.");
        this.vigencia = false; //Cambia la vigencia del cliente a false si el procedimiento fue el correcto
    }

    //Método público para obtener el estado de vigencia del cliente
    public boolean ValorVigencia(){
        return this.vigencia;
    }

    //Método público para obtener el nombre del cliente
    public String ValorNombre(){
        return this.nombre;
    }

    //Método público utilizado para entregar los mensajes en sistema
    public void EnviarMensajeDeSistema(String mensaje){
        System.err.println(mensaje);
    }

    //Método público para mostrar la información del cliente
    public void MostrarInfoCliente(){
        System.out.println("RUT: " + this.rut);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Vigencia: " + (this.vigencia ? "Vigente" : "Deshabilitado"));
    }
}
