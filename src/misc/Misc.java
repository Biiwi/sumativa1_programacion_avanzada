package src.misc;

//Clase Misc para manejar configuraciones y utilidades varias
public class Misc {
    private String passGerente = "admin123"; //Contraseña del gerente para operaciones restringidas

    public Misc() {
    
    }
    //Método público para obtener la contraseña del gerente
    public String getPassGerente() {
        return passGerente;
    }

    public void ImprimirSeparador(String titulo){
        System.out.println("");
        System.out.println("----------------"+titulo+"----------------");
        System.out.println("");
    }

    
}
