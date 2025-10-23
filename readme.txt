Sumativa 1: Guía de Aprendizaje 1 - Sistema Car-REnt
Asignatura APTC101 - Programación Avanzada
Grupo x(no me acuerdo)
Fecha de entrega : 26 de octubre de 2025

IDE utilizado : Visual Studio Code. Con complementos Java y Debugger for Java para la compilación

Estructura del proyecto: Cuenta con 6 clases 
    - Cliente: Clase encargada de la administración de los registros, validaciones y modificaciones de Cliente
    - Vehiculo: Clase encargada de la administración de los registros, validacion y modificaciones de Vehículo
    - Arriendo: Clase encargada de la administración de los registros, validaciones y modificaciones en referencia al Arriendo
    - Devolución: Clase encargada de la administración de los registros, validaciones y modificaciones en referencia a la devolución de un Arriendo
    - Misc: Clase encargada de entregar herramientas transversales, como contraseñas, impresiones de pantalla.
    - Main: Clase principal requerida para la compilación.

Ejecución del código: 
- Para modificar cualquier asignación solo se requiere modificar en Main.java

1. En el IDE, ejecutar la clase Main.java.
2. Automáticamente se ejecutará de forma secuencial la creación de un cliente, luego un vehículo.
3. En este momento, en consola se está solicitando el ingreso de una contraseña para acreditar que es el gerente quien va a deshabilitar al Cliente.
   La contraseña se encuentra en Misc.java y es admin123 . Si la contraseña se ingresa correctamente, el cliente será deshabilitado.
4. Luego, en consola se solicitará nuevamente ingreso de contraseña. Esto para generar el envío a mantención del vehículo. Si la contraseña es correcta.
   se mostrará en consola el estado del vehículo y se procederá con el código.
5. Desde este punto, el código ejecutará sin intervenciones del usuario, realizando los ejercicios de crear arriendo correcto y fallido, luego la devolución
   correcta y fallida.


