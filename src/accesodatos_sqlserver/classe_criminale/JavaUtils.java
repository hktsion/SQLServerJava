package accesodatos_sqlserver.classe_criminale;

/**
 * @version 1.1;
 * @author h3kt0r;
 * @see hectorochoa.es
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public abstract class JavaUtils {

    //Inicializa buttons del formulario
    public static void enabledJButtons(ArrayList<JButton> botones, boolean antiflag) {
        for (JButton btn : botones) {
            btn.setEnabled(antiflag);
        }
    }

    //Inicializa textfields del formulario*/
    public static void enabledJTextFields(ArrayList<JTextField> fields, boolean antiflag) {
        for (JTextField field : fields) {
            field.setEnabled(antiflag);
        }
    }

    //Limpia los textFields
    public static boolean borrarJTextFields(ArrayList<JTextField> fields, boolean limpia) {
        if (limpia) {
            for (int i = 0; i < fields.size(); i++) {
                fields.get(i).setText("");
            }
        }
        return true;
    }

    //Limpia los datos de la tabla
    public static void clearJTable(DefaultTableModel ozzy) {
        for (int i = 0; i < ozzy.getRowCount(); i++) {
            ozzy.removeRow(i);
            i -= 1;
        }
    }

    //Valida que los campos no estén vacíos;
    public static boolean camposVacios(Ciudad city) {
        if (city.getId().length() == 0 || city.getPais().length() == 0 || city.getCiudad().length() == 0 || city.getLugares().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Valida si un string comienza por un número
    public static boolean primerCaracterNumerico(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException nfe) {
            nfe.getMessage();
            return false;
        }
    }

    //Valida si un string comienza por un número
    public static boolean isNumeric(String string) {
        int contador = 0;
        String[] strings = string.split("");
        for (String dato : strings) {
            try {
                Integer.parseInt(dato);
                contador += 1;
            } catch (Exception e) {

            }
        }
        if (contador > 0) {
            System.out.println("El campo tiene valores numéricos");
            return true;
        } else {
            return false;
        }

    }

    //genera primary key para lugares;
    public static String generarPrimaryKey() {
        String key
                = ("lug" + (Math.floor(Math.random() * (1000000 - 1000) + 1000))).replace(".", "");
        System.out.println("Generada primaryKey para lugares: " + key);
        return key;
    }

    /*IMAGENES*/
    public static BufferedImage imagenToArray(BufferedImage originalBI) {
        int pixels[][];
        int width = originalBI.getWidth();
        int height = originalBI.getHeight();
        BufferedImage newBI
                = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        pixels = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = originalBI.getRGB(i, j);
            }
        }
        return newBI;
    }


    public static void saveImage(BufferedImage newBI) {
        JFileChooser saveFileChooser = new JFileChooser();
         int returnValue = saveFileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(newBI, "png", saveFileChooser.getSelectedFile());
                System.out.println("Imagen salvada");
            } catch (IOException exception) {
                System.out.println("No se ha elegido imagen");
            }
        }
    }
}
