import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Aplicacion {

    private JPanel pnlPrincipal;
    private JTextField txtBuscar;
    private JButton btnAñadir;
    private JButton btnBuscar;
    private JComboBox cmbOpcion;
    private JPanel pnlListado;
    private JButton btnRecargar;

    //
    int index = 0;



    //Ventana añadirEstudiante
    private JFrame anadirEstudiante;


    public Aplicacion(){

        /*
        //Componentes de la lista de alumnos
        JTextField txtDni = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtCurso = new JTextField();
        JComboBox cmbAsignaturas = new JComboBox();
        */


        //Declaramos e instaciamos los layouts que utilizaremos
        GridLayout layoutEstudiante = new GridLayout(0,7,10,5);

        //Declaramos e instanciamos las listas de alumnos, profesores y asignaturas
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();

        //Declaramos e instanciamos las listas de los componentes de los objetos alumnos, profesores y asignaturas
        /*
        Alumnos
         */
        //Almacenamos los datos de los alumnos en un arrayList para luego poder manipularlos
        ArrayList<JTextField> txtListaDni = new ArrayList<>();
        ArrayList<JTextField> txtListaNombres = new ArrayList<>();
        ArrayList<JTextField> txtListaCursos = new ArrayList<>();
        ArrayList<JTextField> txtListaNivelesAcademicos = new ArrayList<>();
        ArrayList<JComboBox> cmbListaAsignaturas = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesEditar = new ArrayList<>();
        ArrayList<JButton> btnListaBotonesBorrar = new ArrayList<>();



        /* Ejemplo de listeners para los botones creados en tiempo de ejecución
        btnListaBotonesBorrar.get(contador).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
         */

        //NO ERA NECESARIO INSTANCIAR pnlListado, AL HACERLO SE ¿SOBREESCRIBIA?



        // Añadir componente
        /* Añadir componente
        JTextField textField = new JTextField();
        textField.setText("Texto");
        pnlListado.add(textField, 0, 0);
         */

        txtBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });

        cmbOpcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        }); //Parece finalizado

        btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (cmbOpcion.getSelectedIndex() == 0){
                    //AñadirEstudiante hereda de JDialog
                    //Instanciamos AñadirEstudiante
                    //El parámetro de entrada debe ser un arraylist de alumnos
                    anadirEstudiante = new AnadirEstudiante(listaAlumnos);

                    //Ventana añadirEstudiante
                } else if(cmbOpcion.getSelectedIndex() == 1){

                } else if(cmbOpcion.getSelectedIndex() == 2){
                    //Ventana añadirAsigntura
                }
            }
        });

        /*
        Al pulsar dos veces se volverán a añadir los mismos componentes? No parece
        Bucle que recorra la lista y añada los componentes
         */
        btnRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Si cmbOpcion == 0
                pnlListado.setLayout(layoutEstudiante);

                pnlListado.removeAll(); //Antes de añadir toda la lista vaciamos el panel para evitar duplicados

                pnlListado.add(new JLabel("DNI"));
                pnlListado.add(new JLabel("Nombre"));
                pnlListado.add(new JLabel("Curso"));
                pnlListado.add(new JLabel("Nivel académico"));
                pnlListado.add(new JLabel("Asignaturas"));
                pnlListado.add(new JLabel(""));
                pnlListado.add(new JLabel(""));


                //EL FALLO CON EL DUPLICADO ESTÁ AQUÍ
                /*
                El fallo fue creer que el paremetro suministrado al constructor actuaba igual que un setter.
                 */
                for (Alumno alumno : listaAlumnos){
                    txtListaDni.add(new JTextField());
                    txtListaNombres.add(new JTextField());
                    txtListaCursos.add(new JTextField());
                    txtListaNivelesAcademicos.add(new JTextField());
                    //cmbListaAsignaturas.add(new JComboBox(alumno.getListaAsignaturas()));
                    btnListaBotonesEditar.add(new JButton());
                    btnListaBotonesBorrar.add(new JButton());
                }

                for (int contador = 0; contador < listaAlumnos.size(); contador++){ //Se añade toda la lista
                    //cmbAsignaturas, como añado las asignaturas? Puede que sea bucle con .addItem
                    pnlListado.add(txtListaDni.get(contador));
                    txtListaDni.get(contador).setText(listaAlumnos.get(contador).getDni());

                    pnlListado.add(txtListaNombres.get(contador));
                    txtListaNombres.get(contador).setText(listaAlumnos.get(contador).getDni());

                    pnlListado.add(txtListaCursos.get(contador));
                    txtListaCursos.get(contador).setText(String.valueOf(listaAlumnos.get(contador).getCurso()));

                    pnlListado.add(txtListaNivelesAcademicos.get(contador));
                    txtListaNivelesAcademicos.get(contador).setText(listaAlumnos.get(contador).getNivelAcademico());
                    pnlListado.add(new JComboBox<>());

                    pnlListado.add(btnListaBotonesEditar.get(contador));
                    btnListaBotonesEditar.get(contador).setText("Editar");

                    pnlListado.add(btnListaBotonesBorrar.get(contador));
                    btnListaBotonesBorrar.get(contador).setText("Borrar");

                    //Obtenemos el componente txt y lo configuramos
                    txtListaDni.get(contador).setEnabled(false);
                }
                pnlPrincipal.doLayout();
                pnlListado.doLayout(); //Dibujamos el panel
            }
        });

        //Parece que no funcionan
        for (int contador = 0; contador < btnListaBotonesEditar.size(); contador++){
            btnListaBotonesEditar.get(contador).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
        }
        //Parece que no funciona
        for (int contador = 0; contador < btnListaBotonesBorrar.size(); contador++){
            btnListaBotonesBorrar.get(contador).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnListaBotonesBorrar.get(0).setText("Ha entrado");
                    System.out.println("ha entrado");
                }
            });
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicacion");
        frame.setContentPane(new Aplicacion().pnlPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
