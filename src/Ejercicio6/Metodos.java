
package Ejercicio6;

import javax.swing.JOptionPane;

public class Metodos {
    private int n;
    private int opc,i,j;
    private String cad;
    private Alumnoo alum[];
    private Alumnoo alumCopia[];
    private void burbuja(Alumnoo[] vec1){
        String aux;
        int i,j,x=vec1.length;
        for(i=0;i<x;i++){
            for(j=i+1;j<x;j++){
                if(vec1[i].getNombre().charAt(0)>vec1[j].getNombre().charAt(0)){
                    aux=vec1[i].getNombre();
                    vec1[i].setNombre(vec1[j].getNombre());
                    vec1[j].setNombre(aux);
                }
            }
        }
    }
    private void quicksort(Alumnoo[] vec, int izq, int der) {
        int i = izq, j = der, pivot = vec[(i + j) / 2].getCodigo();
        do {
            while (vec[i].getCodigo() < pivot) {
                i++;
            }
            while (vec[j].getCodigo() > pivot) {
                j--;
            }
            if (i <= j) {
                int aux = vec[i].getCodigo();
                vec[i].setCodigo(vec[j].getCodigo());
                vec[j].setCodigo(aux);
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            quicksort(vec, izq, j);
        }
        if (i < der) {
            quicksort(vec, i, der);
        }
    }
    private void pedirCantidad() {
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de estudiantes: "));
        alum=new Alumnoo[n];
        alumCopia=new Alumnoo[n];
    }
    public void ingresoDatos() {
        pedirCantidad();
        String nombre;
        int codigo;
        JOptionPane.showMessageDialog(null, "\tLLENANDO NOMBRES Y CODIGOS DE ESTUDIANTES");
        for (i = 0; i < n; i++) {
            nombre= JOptionPane.showInputDialog("Digite el nombre del estudiante " + (i + 1) + ": ");
            codigo= Integer.parseInt(JOptionPane.showInputDialog("Digite el codigo del estudiante " + (i + 1) + ": "));
            alum[i] = new Alumnoo(nombre, codigo);
            alumCopia[i]= new Alumnoo(nombre,codigo);
        }
    }
    public void ordenarNombres() {
        burbuja(alum);
        cad = " ";
        for (i = 0; i < n; i++) {
            cad += alum[i].getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, "\tORDENANDO LOS NOMBRES POR METODO BURBUJA\n" + cad);
    }
    public void ordenarCodigo() {
        quicksort(alum, 0, alum.length - 1);
        cad = " ";
        for (i = 0; i < n; i++) {
            cad += alum[i].getCodigo() + "\n";
        }
        JOptionPane.showMessageDialog(null, "\tORDENANDO CODIGOS POR METODO QUICK SORT\n" + cad);
    }
    public void reporteAlumnos() {
        cad = " ";
        for (i = 0; i < n; i++) {
            cad += alumCopia[i].getNombre() + "    --> " + alumCopia[i].getCodigo() + "\n";
        }
        JOptionPane.showMessageDialog(null, "\tMOSTRANDO REPORTE\n"
                + "NOMBRE       " + "     CODIGO\n"
                + cad);
    }
    public void buscarNombre() {
        boolean band=true;
        String nomb;
        nomb = JOptionPane.showInputDialog("\tBUSCANDO POR NOMBRE\n" + "Digite un nombre: ");
        for (i = 0; i < n; i++) {
            if (nomb.equals(alum[i].getNombre())) {
                JOptionPane.showMessageDialog(null, "El usuario con el nombre " + nomb + " si se encuentra registrado\n"
                        + "Su codigo es: " + alum[i].getCodigo());
                band=false;
            }
        }
        if(band==true){
            JOptionPane.showMessageDialog(null, "El nombre ingresado no se encuentra registrado");
        }
    }
    public void buscarCodigo() {
        int cod;
        boolean band=true;
        cod = Integer.parseInt(JOptionPane.showInputDialog("\tBUSCANDO POR CODIGO\n" + "Digite un codigo: "));
        for (i = 0; i < n; i++) {
            if (alum[i].getCodigo() == cod) {
                JOptionPane.showMessageDialog(null, "El usuario con el codigo " + cod + " si se encuentra registrado\n"
                        + "Su nombre es: " + alum[i].getNombre());
                band=false;
            }
        }
        if(band==true){
            JOptionPane.showMessageDialog(null, "El codigo ingresado no se encuentra registrado");
        }
    }
    public void finalizar(){
        JOptionPane.showMessageDialog(null,"\tGRACIAS POR USAR EL MENÚ");
      
    }
}
