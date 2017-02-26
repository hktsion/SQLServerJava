package accesodatos_sqlserver;

import accesodatos_sqlserver.classe_criminale.TablaDatos;
import accesodatos_sqlserver.classe_criminale.CRUD;
import accesodatos_sqlserver.classe_criminale.Ciudad;
import accesodatos_sqlserver.classe_criminale.Excel;
import accesodatos_sqlserver.classe_criminale.JavaUtils;
import accesodatos_sqlserver.classe_criminale.PDF;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * @version 1.1;
 * @author h3kt0r;
 * @see hectorochoa.es
 */
public class Formulario extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private final TablaDatos td;
    private final ArrayList<JButton> buttons;
    private static ArrayList<JTextField> textfields;
    private String IDciudad = "";
    private String IDlugar = "";
    public String pathString = "../img/default.png";

    public Formulario() {
        initComponents();

        td = new TablaDatos();
        txt_updateID.setEnabled(false);

        labelImg.setVisible(false);
        photolabel.setText("");

        buttons = new ArrayList<>();
        buttons.add(this.btn_borrarAreaTexto);
        buttons.add(this.btn_exportarExcel);
        buttons.add(this.btn_exportarPDF);
        buttons.add(this.btn_insertar);
        buttons.add(this.btn_delete);
        buttons.add(this.btn_update);
        buttons.add(this.btn_upload);

        textfields = new ArrayList<>();
        textfields.add(this.txt_newID);
        textfields.add(this.txt_newPAIS);
        textfields.add(this.txt_newCIUDAD);
        textfields.add(this.txt_newLUGARES);
        textfields.add(this.txt_deleteCIUDAD);
        textfields.add(this.txt_updatePAIS);
        textfields.add(this.txt_updateCIUDAD);
        textfields.add(this.txt_updateLUGARES);

        JavaUtils.enabledJButtons(buttons, false);
        JavaUtils.enabledJTextFields(textfields, false);

        ImageIcon image
                = new ImageIcon(getClass().getResource("../img/default.png"));
        photolabel.setIcon(image);
        BufferedImage originalBI;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_mostrarDatos = new javax.swing.JButton();
        btn_exportarExcel = new javax.swing.JButton();
        btn_borrarAreaTexto = new javax.swing.JButton();
        btn_exportarPDF = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_insertar = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txt_deleteCIUDAD = new javax.swing.JTextField();
        txt_newID = new javax.swing.JTextField();
        txt_newPAIS = new javax.swing.JTextField();
        txt_newCIUDAD = new javax.swing.JTextField();
        txt_newLUGARES = new javax.swing.JTextField();
        foto_ciudad = new java.awt.Label();
        label2 = new java.awt.Label();
        jLabel15 = new javax.swing.JLabel();
        labelImg = new javax.swing.JLabel();
        txt_updateID = new javax.swing.JTextField();
        txt_updatePAIS = new javax.swing.JTextField();
        txt_updateCIUDAD = new javax.swing.JTextField();
        txt_updateLUGARES = new javax.swing.JTextField();
        photolabel = new javax.swing.JLabel();
        btn_upload = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DESTINOS TURISTICOS");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 146, 167));

        btn_mostrarDatos.setBackground(new java.awt.Color(253, 152, 39));
        btn_mostrarDatos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_mostrarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btn_mostrarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btn_mostrarDatos.setText("MOSTRAR DESTINOS");
        btn_mostrarDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btn_mostrarDatos.setBorderPainted(false);
        btn_mostrarDatos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_mostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarDatosActionPerformed(evt);
            }
        });

        btn_exportarExcel.setBackground(new java.awt.Color(253, 152, 39));
        btn_exportarExcel.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_exportarExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btn_exportarExcel.setText("EXPORTAR A EXCEL");
        btn_exportarExcel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btn_exportarExcel.setBorderPainted(false);
        btn_exportarExcel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_exportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarExcelActionPerformed(evt);
            }
        });

        btn_borrarAreaTexto.setBackground(new java.awt.Color(253, 152, 39));
        btn_borrarAreaTexto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_borrarAreaTexto.setForeground(new java.awt.Color(255, 255, 255));
        btn_borrarAreaTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btn_borrarAreaTexto.setText(" LIMPIAR DESTINOS");
        btn_borrarAreaTexto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btn_borrarAreaTexto.setBorderPainted(false);
        btn_borrarAreaTexto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_borrarAreaTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarAreaTextoActionPerformed(evt);
            }
        });

        btn_exportarPDF.setBackground(new java.awt.Color(253, 152, 39));
        btn_exportarPDF.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_exportarPDF.setForeground(new java.awt.Color(255, 255, 255));
        btn_exportarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        btn_exportarPDF.setText("   EXPORTAR A PDF");
        btn_exportarPDF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btn_exportarPDF.setBorderPainted(false);
        btn_exportarPDF.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_exportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportarPDFActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINAR DESTINO");

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JAVA TOURS");

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MODIFICAR DESTINO");

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");
        jLabel4.setFocusTraversalPolicyProvider(true);

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PAIS");
        jLabel5.setFocusTraversalPolicyProvider(true);

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CIUDAD");
        jLabel6.setFocusTraversalPolicyProvider(true);

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("IMAGEN");
        jLabel7.setFocusTraversalPolicyProvider(true);

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CIUDAD");
        jLabel8.setFocusTraversalPolicyProvider(true);

        jLabel9.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID");
        jLabel9.setFocusTraversalPolicyProvider(true);

        jLabel10.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PAIS");
        jLabel10.setFocusTraversalPolicyProvider(true);

        jLabel11.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CIUDAD");
        jLabel11.setFocusTraversalPolicyProvider(true);

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LUGAR");
        jLabel12.setFocusTraversalPolicyProvider(true);

        btn_insertar.setBackground(new java.awt.Color(253, 152, 39));
        btn_insertar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_insertar.setForeground(new java.awt.Color(255, 255, 255));
        btn_insertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/insert.png"))); // NOI18N
        btn_insertar.setText("INSERTAR");
        btn_insertar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        btn_insertar.setBorderPainted(false);
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(253, 152, 39));
        btn_delete.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        btn_delete.setText("BORRAR");
        btn_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        btn_delete.setBorderPainted(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(253, 152, 39));
        btn_update.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_update.setText("ACTUALIZAR");
        btn_update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        btn_update.setBorderPainted(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("NUEVO DESTINO");

        btn_salir.setBackground(new java.awt.Color(191, 0, 0));
        btn_salir.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDatos.setSelectionBackground(new java.awt.Color(241, 147, 56));
        tDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDatosMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tDatos);
        if (tDatos.getColumnModel().getColumnCount() > 0) {
            tDatos.getColumnModel().getColumn(0).setResizable(false);
            tDatos.getColumnModel().getColumn(1).setResizable(false);
            tDatos.getColumnModel().getColumn(2).setResizable(false);
            tDatos.getColumnModel().getColumn(3).setResizable(false);
            tDatos.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LUGAR");
        jLabel14.setFocusTraversalPolicyProvider(true);

        foto_ciudad.setAlignment(java.awt.Label.CENTER);
        foto_ciudad.setText("label1");

        label2.setText("label2");

        jLabel15.setText("jLabel15");

        photolabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photolabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/default.png"))); // NOI18N
        photolabel.setText("labelImagen");
        photolabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btn_upload.setBackground(new java.awt.Color(253, 152, 39));
        btn_upload.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_upload.setForeground(new java.awt.Color(255, 255, 255));
        btn_upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/upload-icon.png"))); // NOI18N
        btn_upload.setText("Upload");
        btn_upload.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        btn_upload.setBorderPainted(false);
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelImg)
                        .addGap(813, 813, 813))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_exportarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_mostrarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_borrarAreaTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_exportarPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(photolabel)
                                .addGap(11, 11, 11))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_salir))
                                    .addComponent(jScrollPane11))
                                .addGap(36, 36, 36))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_newID, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_newPAIS, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_newCIUDAD)
                                                .addComponent(txt_newLUGARES, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_upload, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(btn_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txt_deleteCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel9)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(40, 40, 40)
                                                        .addComponent(jLabel3))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txt_updateID, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_updateCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_updatePAIS, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_updateLUGARES, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(66, 66, 66))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_salir)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_mostrarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_borrarAreaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(photolabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txt_newID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txt_deleteCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_newPAIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_newCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_newLUGARES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_upload, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_updateID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_updatePAIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_updateCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_updateLUGARES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_exportarExcel.getAccessibleContext().setAccessibleName("EXPORTAR EXCEL");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatosMouseClicked
        //RECOGE ELEMENTOS DE LA TABLA
        System.out.println("** SELECCIONANDO ELEMENTO **");
        int index = tDatos.getSelectedRow();
        IDciudad = (String) modelo.getValueAt(index, 0).toString();
        String paisString = (String) modelo.getValueAt(index, 1).toString();
        String ciudadString = (String) modelo.getValueAt(index, 2).toString();
        IDlugar = (String) modelo.getValueAt(index, 3).toString();
        String lugar = (String) modelo.getValueAt(index, 4).toString();
        String urlString = (String) modelo.getValueAt(index, 5).toString();

        txt_updateID.setText(IDlugar);
        txt_updatePAIS.setText(paisString);
        txt_updateCIUDAD.setText(ciudadString);
        txt_updateLUGARES.setText(lugar);
        txt_deleteCIUDAD.setText(ciudadString);
        ImageIcon image
                = new ImageIcon(getClass().getResource(urlString));
        photolabel.setIcon(image);

        System.out.println(
                "Datos fila seleccionada: " +
                IDciudad + " \\ " +
                paisString + " \\ " +
                ciudadString + " \\ " +
                urlString + " \\ " +
                IDlugar + " \\ " +
                lugar);
    }//GEN-LAST:event_tDatosMouseClicked
    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // SALIR DEL FORMULARIO
        System.out.println("** FIN DE PROGRAMA **");
        int reply
                = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que quieres salir de la aplicación?",
                        "SALIR",
                        JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(-9);
        }
    }//GEN-LAST:event_btn_salirActionPerformed
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // ACTUALIZAR REGISTRO DE LA BASE DE DATOS
        txt_deleteCIUDAD.setText("");
        System.out.println("** ACTUALIZANDO BASE DE DATOS **");
        Ciudad mycity = new Ciudad();
        boolean flaglugar = true;
        String id_lugar = "";

        mycity.setId(IDciudad.trim());
        mycity.setPais(txt_updatePAIS.getText().trim());
        mycity.setCiudad(txt_updateCIUDAD.getText().trim());
        mycity.setLugares(txt_updateLUGARES.getText().trim());
        flaglugar = (mycity.getLugares().length() != 0) ? flaglugar : false;
        id_lugar = txt_updateID.getText();
        mycity.setAux(id_lugar);

        if (id_lugar.length() == 0) {
            System.out.println("No se ha introducido clave de destino a modificar");
            JOptionPane.showMessageDialog(this,
                    "Debes especificar un destino" +
                    "\nHaz click en un elemento de la tabla para modificarlo.",
                    "DESTINOS TURÍSTICOS - Mensaje de información",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (mycity.getPais().length() == 0 && mycity.getCiudad().length() == 0 && mycity.getLugares().length() == 0) {
            System.out.println("Al menos hay que introducir un campo.");
            JOptionPane.showMessageDialog(this,
                    "Debes especificar al menos un campo" +
                    "\npara poder modificar el destino." +
                    "\nHaz click en un elemento de la tabla para modificarlo.",
                    "DESTINOS TURÍSTICOS - Mensaje de información",
                    JOptionPane.ERROR_MESSAGE);
            txt_updateID.setText("");
            txt_updateID.requestFocus();
        } else {
            //CAMPOS SIN VALORES NUMÉRICOS;
            if (JavaUtils.isNumeric(mycity.getPais()) ||
                    JavaUtils.isNumeric(mycity.getPais()) ||
                    JavaUtils.isNumeric(mycity.getPais())) {

                //CASOS PARTICULARES
                if (JavaUtils.isNumeric(mycity.getPais())) {
                    txt_updatePAIS.setText("");
                    txt_updatePAIS.requestFocus();
                }
                if (JavaUtils.isNumeric(mycity.getCiudad())) {
                    txt_updateCIUDAD.setText(mycity.getCiudad());
                    txt_updateCIUDAD.requestFocus();
                }
                if (JavaUtils.isNumeric(mycity.getLugares())) {
                    txt_updateLUGARES.setText("");
                    txt_updateLUGARES.requestFocus();
                }
                JOptionPane.showMessageDialog(this,
                        "Los campos PAIS, CIUDAD Y LUGAR" +
                        "\nno pueden contener valores numéricos.",
                        "DESTINOS TURÍSTICOS - Mensaje de información",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if (new CRUD().update(mycity, flaglugar)) {
                        System.out.println("Registro actualizado...");
                        JOptionPane.showMessageDialog(rootPane,
                                "Se ha actualizado el registro: " +
                                "\nDestino: " + mycity.getId() +
                                "\nPara ver los cambios pulsa el botón de actualizar",
                                "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                                JOptionPane.INFORMATION_MESSAGE);
                        mycity.setId("");
                        mycity.setPais("");
                        mycity.setCiudad("");
                        mycity.setLugares("");
                        mycity.setAux("");
                        txt_updateID.setText("");
                        JavaUtils.borrarJTextFields(textfields, true);
                    } else {
                        System.out.println("El registro no se ha podido actualizar");
                        JOptionPane.showMessageDialog(this,
                                "Ha ocurrido un error al intentar actualizar el destino _ID: '" + mycity.getId() + "'" +
                                "\nPosibles causas:" +
                                "\n - El _ID introducido no se encuentra entre los destinos." +
                                "\n - Haz click sobre uno de los elementos de la lista para" +
                                "\n   rellenar el campo ID con el destino a modificar." +
                                "\n\nPosible solución:" +
                                "\n - Pulsa 'Mostrar destinos' para verificar el _ID a eliminar." +
                                "\n - Haz click sobre alguno de los elementos de la tabla" +
                                "\n   para modificarlo." +
                                "\n - Si persiste el error contacta con el administrador.",
                                "DESTINOS TURÍSTICOS - Error en la actualización",
                                JOptionPane.ERROR_MESSAGE);
                        txt_updateID.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        //ELIMINAR REGISTROS
        System.out.println("** ELIMINANDO DESTINOS **");
        txt_updateID.setText("");
        txt_updatePAIS.setText("");
        txt_updateCIUDAD.setText("");
        txt_updateLUGARES.setText("");

        if (txt_deleteCIUDAD.getText().trim().length() == 0 || JavaUtils.isNumeric(txt_deleteCIUDAD.getText().trim())) {
            JOptionPane.showMessageDialog(this,
                    "El campo no puede quedar vacío." +
                    "\nEl campo CIUDAD no puede contener valores numéricos." +
                    "\nNo se ha eliminado ningún registro",
                    "DESTINOS TURÍSTICOS - Error",
                    JOptionPane.ERROR_MESSAGE);
            txt_deleteCIUDAD.requestFocus();
            System.out.println("No se ha podido eliminar el registro");
            return;
        } else {
            ArrayList<Ciudad> compareArrayList = new ArrayList<>();
            if (new CRUD().delete(txt_deleteCIUDAD.getText())) {
                JOptionPane.showMessageDialog(rootPane,
                        "Se han borrado el primer destino encontrado." +
                        "\nDestino: " + txt_deleteCIUDAD.getText().trim() +
                        "\nPara ver los cambios pulsa el botón de actualizar",
                        "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Registro borrado");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ha ocurrido un error al intentar borrar el destino: " + txt_deleteCIUDAD.getText() +
                        "\nPosibles causas:" +
                        "\n - La ciudad: " + txt_deleteCIUDAD.getText() + " no se encuentra entre nuestros destinos." +
                        "\n\nPossible solución:" +
                        "\n - Pulsa 'Mostrar destinos' para confirmar la ciudad a eliminar." +
                        "\n - Si persiste el error contacta con el administrador.",
                        "DESTINOS TURÍSTICOS - Error",
                        JOptionPane.ERROR_MESSAGE);
                txt_deleteCIUDAD.requestFocus();
                System.out.println("No se ha podido eliminar el registro");
            }
        }
        txt_deleteCIUDAD.setText("");
    }//GEN-LAST:event_btn_deleteActionPerformed
    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
        // INSERTAR NUEVOS DESTINOS
        System.out.println("** INSERTANDO DESTINOS **");
        CRUD crud = new CRUD();
        Ciudad sinCity = new Ciudad();

        //Creo un nuevo objeto ciudad con los datos de los textFields;
        sinCity.setId(txt_newID.getText().trim());
        sinCity.setPais(txt_newPAIS.getText().trim());
        sinCity.setCiudad(txt_newCIUDAD.getText().trim());
        sinCity.setLugares(txt_newLUGARES.getText().trim());
        sinCity.setRuta_imagen(pathString);
        //sinCity.setRuta_imagen(txt_newIMG.getText().trim());

        if (JavaUtils.camposVacios(sinCity)) {
            JOptionPane.showMessageDialog(rootPane,
                    "No ha sido posible insertar el registro." +
                    "\n Se han encontrado campos vacíos",
                    "DESTINOS TURÍSTICOS - Mensaje de error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        //VALIDACIÓN DEL FORMULARIO (CAMPOS NO VACÍOS Y NO MUMÉRICOS)
        if (JavaUtils.primerCaracterNumerico(sinCity.getId().substring(0, 1)) ||
                JavaUtils.isNumeric(sinCity.getPais()) ||
                JavaUtils.isNumeric(sinCity.getCiudad()) ||
                JavaUtils.isNumeric(sinCity.getLugares())) {
            if (JavaUtils.primerCaracterNumerico(sinCity.getId().substring(0, 1))) {
                System.out.println("ID no comienza por letra");
                txt_newID.setText("");
                txt_newID.requestFocus();
            }
            if (JavaUtils.isNumeric(sinCity.getPais())) {
                System.out.println("Pais con datos numéricos");
                txt_newPAIS.setText("");
                txt_newPAIS.requestFocus();
            }
            if (JavaUtils.isNumeric(sinCity.getCiudad())) {
                System.out.println("Ciudad con datos numéricos");
                txt_newCIUDAD.setText("");
                txt_newCIUDAD.requestFocus();
            }
            if (JavaUtils.isNumeric(sinCity.getLugares())) {
                System.out.println("Lugar con datos numéricos");
                txt_newLUGARES.setText("");
                txt_newLUGARES.requestFocus();
            }
            JOptionPane.showMessageDialog(rootPane,
                    "No ha sido posible insertar el registro." +
                    "\n\nPosibles causas:" +
                    "\n - El _ID no puede comenzar por un número" +
                    "\n - Ninguno de los campos excepto la foto pueden quedar vacíos." +
                    "\n - Se ha encontrado un valor numérico en alguno de los campos." +
                    "\n\nPosible solución:" +
                    "\n - Intenta corregir los errores." +
                    "\n - Introduce un ID que comience por un carácter no numérico" +
                    "\n - Los campos PAIS, CIUDAD Y LUGAR no pueden contener caracteres numéricos." +
                    "\n - Si persiste el error contacta con el administrador.",
                    "DESTINOS TURÍSTICOS - Mensaje de error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            //INTENTO REALIZAR EL INSERT;
            boolean sc = crud.insert(sinCity);
            if (!sc) {
                JOptionPane.showConfirmDialog(rootPane,
                        "Ha ocurrido un error grave." +
                        "\nLos datos no han podido ser insertados" +
                        "\npor motivos internos de sistema." +
                        "\nPosibles causas: " +
                        "\n - Puede que el _ID ya esté en uso." +
                        "\n\nPosible solución:" +
                        "\n - Intenta introducir un _ID distinto." +
                        "\n - Si persiste el error contacta con el administrador.",
                        "DESTINOS TURÍSTICOS - ERROR GRAVE",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane,
                        "Se ha añadido un nuevo destino en la base de datos." +
                        "\nDestino: " + sinCity.getCiudad() + "(" + sinCity.getPais() + ")" +
                        "\nPara ver los cambios pulsa el botón de actualizar",
                        "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            JavaUtils.borrarJTextFields(textfields, sc);
        }
    }//GEN-LAST:event_btn_insertarActionPerformed
    private void btn_exportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarPDFActionPerformed
        // EXPORTAR A PDF
        System.out.println("** EXPORTANDO DOCUMENTO PDF **");
        JFileChooser saver = new JFileChooser();
        int returnVal = saver.showSaveDialog(this);
        File file = saver.getSelectedFile();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            if (PDF.newPDFDoc(file, new CRUD().selectXtodas())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Se ha guardado el documento pdf ",
                        "DESTINOS TURÍSTICOS - Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Documento PDF creado y datos exportados;");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No se ha podido generar el documneto pdf",
                        "DESTINOS TURÍSTICOS - Mensaje de error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_exportarPDFActionPerformed
    private void btn_borrarAreaTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarAreaTextoActionPerformed
        //BORRAR ÁREA DE TEXTO
        System.out.println("** TABLA BORRADA **");
        this.btn_exportarExcel.setEnabled(false);
        this.btn_exportarPDF.setEnabled(false);
        JavaUtils.clearJTable(modelo);
    }//GEN-LAST:event_btn_borrarAreaTextoActionPerformed
    private void btn_exportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportarExcelActionPerformed
        // EXPORTAR A EXCEL
        System.out.println("** EXPORTAR A LIBRO DE EXCEL **");
        try {
            CRUD crud = new CRUD();
            ResultSet rs = crud.selectXtodas();
            String[] data = Excel.creaFichero();
            if (Excel.newExcelBook(rs, data[0])) {
                JOptionPane.showMessageDialog(this,
                        "El archivo excel se ha generado correctamente." +
                        "\nEl fichero se encuentra ubicado en " +
                        "\n" + data[0] +
                        "\ndentro de la carpeta raíz 'C:' en tu máquina " + data[1],
                        "DESTINOS TURÍSTICOS - Excel generado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ha ocurrido un error al generar el Excel." +
                        "\nPosibles causas:" +
                        "\n - El archivo excel se encuentra abierto." +
                        "\n - El usuario no tiene los suficientes permisos para crear este archivo en la ruta:" +
                        "\n    " + data[0] +
                        "\n\n Posible solución:" +
                        "\n  - Cierra el libro de excell que esté abierto." +
                        "\n  - Si persiste el error contacta con el administrador.",
                        "DESTINOS TURÍSTICOS - Error generación de excel",
                        JOptionPane.ERROR_MESSAGE);

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Ha ocurrido un error grave al generar el Excel." +
                    "\nContacta con el administrador.",
                    "DESTINOS TURÍSTICOS - Error GRAVE",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_exportarExcelActionPerformed
    private void btn_mostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarDatosActionPerformed
        //MOSTRAR TODOS LOS DATOS EN EL PANEL
        System.out.println("** MOSTRAR TODOS LOS DATOS **");
        CRUD crud = new CRUD();
        JavaUtils.enabledJButtons(buttons, true);
        JavaUtils.enabledJTextFields(textfields, true);

        try {
            ResultSet rs = crud.selectXtodas();
            modelo = new DefaultTableModel();
            this.tDatos.setModel(modelo);

            //Número de columnas de los METADATOS
            for (int i = 0; i < td.nrw(rs); i++) {
                modelo.addColumn(td.colNm(rs, i + 1));
                System.out.println("Añadido metadato");
            }

            //AÑADE DESTNOS A LA JTABLE;
            Object row[] = null;
            while (rs.next()) {
                row = new Object[td.nrw(rs)];
                for (int k = 0; k < td.nrw(rs); k++) {
                    row[k] = rs.getObject(k + 1);
                }
                modelo.addRow(row);
                System.out.println("Añadida fila de datos");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Ha ocurrido un error al cargar los destinos." +
                    "\nPosibles causas:" +
                    "\n - No hay conexión con la base de datos." +
                    "\n - No existen datos que cargar." +
                    "\n\nPosible solución:" +
                    "\n - Revisa DB, usuario y contraseña en 'Conexion'" +
                    "\n - Revisa que la base de datos contenga datos que mostrar.'" +
                    "\n - Si persiste el error contacta con el administrador",
                    "DESTINOS TURÍSTICOS - Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_mostrarDatosActionPerformed
    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
        // SUBIR UNA IMAGEN
        System.out.println("SUBIR IMAGEN");
        BufferedImage originalBI, newBI;
        JFileChooser openFileChooser = new JFileChooser();
        FileNameExtensionFilter filter
                = new FileNameExtensionFilter("Archivo de imagen", "png", "jpg", "jpeg");
        openFileChooser.setFileFilter(filter);

        int returnValue = openFileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                //Leer la imagen
                originalBI
                        = ImageIO.read(openFileChooser.getSelectedFile());
                System.out.println("Imagen leida correctamente");

                //Guardar la imagen
                BufferedImage imagen = JavaUtils.imagenToArray(originalBI);
                JavaUtils.saveImage(imagen);
                JOptionPane.showMessageDialog(rootPane,
                        "Imagen guardada correctamente",
                        "DESTINOS TURÍSTICOS - Mensaje de inforrmación",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException exception) {
                System.out.println("No se ha elegido imagen");
            }
            String ruta = null;
            ruta = openFileChooser.getSelectedFile().getPath();
            pathString = ruta;
            return;
        }
    }//GEN-LAST:event_btn_uploadActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Formulario().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrarAreaTexto;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exportarExcel;
    private javax.swing.JButton btn_exportarPDF;
    private javax.swing.JButton btn_insertar;
    private javax.swing.JButton btn_mostrarDatos;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_upload;
    private java.awt.Label foto_ciudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane11;
    private java.awt.Label label2;
    private javax.swing.JLabel labelImg;
    private javax.swing.JLabel photolabel;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField txt_deleteCIUDAD;
    private javax.swing.JTextField txt_newCIUDAD;
    private javax.swing.JTextField txt_newID;
    private javax.swing.JTextField txt_newLUGARES;
    private javax.swing.JTextField txt_newPAIS;
    private javax.swing.JTextField txt_updateCIUDAD;
    private javax.swing.JTextField txt_updateID;
    private javax.swing.JTextField txt_updateLUGARES;
    private javax.swing.JTextField txt_updatePAIS;
    // End of variables declaration//GEN-END:variables
}
