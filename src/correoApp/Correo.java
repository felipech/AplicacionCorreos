package correoApp;
import java.util.Scanner;

public class Correo {
    private String primerNombre;
    private String apellido;
    private String contrasena;
    private String departamento;
    private String correo;
    private int capacidadCorreo = 100;
    private int largoContrasena = 10;
    private String abreviacionCompania = "empresa.com";
    private String correoAlternativo;

    //constructor para el nombre y el apellido, publico para recivir los parametros
    public Correo(String primerNombre, String apellido ){
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        //System.out.println("Correo Creado: " + this.primerNombre + " " + this.apellido);
        this.departamento = setDepartamento();
        System.out.println("Departamento escogido: " + this.departamento);
        //hay que generar la contrasena
        this.setContrasena(gnerarContrasena(largoContrasena));
        System.out.println("Tu contrasena es: " + this.getContrasena());

        correo = primerNombre.toLowerCase() + "." + apellido.toLowerCase() + "@" + departamento + "." + abreviacionCompania;
        //System.out.println("Tu correo es: " + correo);
    }

    //preguntar por el departamento al que pertenece
    private String setDepartamento(){
        System.out.println("Ingrese el Departamento al que pertenece");
        System.out.println("1 para Ventas");
        System.out.println("2 para Desarrollo ");
        System.out.println("3 para Contabilidad");
        System.out.println("0 para ninguno");

        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();

        if(eleccion == 1)return "Ventas";
        else if(eleccion == 2)return "Desarrollo";
        else if(eleccion == 3)return "Contabilidad";
        else return "";

    }

    //generar una contrasena
    private String gnerarContrasena(int largo){
        //se puede agregar mas caracteres si se quiere
        String contasenaCaracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
        char [] arregloContracena = new char[largo];
        //se buscan letras aleatorias del arreglo de caracteres y se setean en el arreglo de caracteres
        //y finalmente se devuelve ese arreglo como un string que es la contrasena generada
        for (int i = 0; i < largo; i++) {
            int aleatorio = (int) (Math.random() * contasenaCaracteres.length());
            arregloContracena[i] = contasenaCaracteres.charAt(aleatorio);
        }
        return new String(arregloContracena);
    }


    public String mostrarInformacion(){
        String informacion;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nombre: ");
        stringBuilder.append(primerNombre);
        stringBuilder.append(" ");
        stringBuilder.append(apellido);
        stringBuilder.append(" ");
        stringBuilder.append("Correo empresa: ");
        stringBuilder.append(correo);
        stringBuilder.append(" ");
        stringBuilder.append("Capacidad Correo: ");
        stringBuilder.append(capacidadCorreo).append(" mb");
        informacion = stringBuilder.toString();
        return informacion;
    }
    public int getCapacidadCorreo() {
        return capacidadCorreo;
    }
    //asignar la capacidad del correo
    public void setCapacidadCorreo(int capacidadCorreo) {
        this.capacidadCorreo = capacidadCorreo;
    }

    public String getCorreoAlternativo() {
        return correoAlternativo;
    }
    //asignar el correo alternativo
    public void setCorreoAlternativo(String correoAlternativo) {
        this.correoAlternativo = correoAlternativo;
    }

    public String getContrasena() {
        return contrasena;
    }
    //metodo para cambiar la contrasena
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }






}
