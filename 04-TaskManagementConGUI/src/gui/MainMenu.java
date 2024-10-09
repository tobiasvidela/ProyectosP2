/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import logica.*;

/**
 *
 * @author La Maquina
 */
public class MainMenu extends javax.swing.JFrame {
    public static String usuarioActual = null;
    public static Tarea tareaSeleccionada = null;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public MainMenu(String username) {
        usuarioActual = username;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("ico_mainmenu.png")).getImage());
        setLocationRelativeTo(null); // Centra la ventana
        
        updateMenuBar();
        
        updateTableTareas();
        
        updateDetallesTarea(null);
        
        btn_ver_detalles.setEnabled(false);
        btn_editar_tarea.setEnabled(false);
        btn_eliminar_tarea.setEnabled(false);
        
        // Evento para detectar el click en una fila de la tabla
        table_tareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    runVerDetallesTarea();
                } else if (e.getClickCount() == 1) {
                    int filaSeleccionada = table_tareas.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        // Obtener la tarea seleccionada desde la tabla
                        int tareaId = (int) table_tareas.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID está en la primera columna
                        tareaSeleccionada = logica.Main.getTaskById(tareaId);  // Método para obtener la tarea por ID

                        updateDetallesTarea(tareaSeleccionada); // Actualizar la vista con los detalles de la tarea

                        btn_ver_detalles.setEnabled(true);
                        btn_editar_tarea.setEnabled(true);
                        btn_eliminar_tarea.setEnabled(true);
                    }
                } else {
                    //play sound
                }
            }
        });
    }
    
    private void updateMenuBar(){
        menu_usuario.setText(usuarioActual);
    }
    
    private void updateTableTareas() {
        // Limpiar la tabla antes de actualizarla
        DefaultTableModel model = (DefaultTableModel) table_tareas.getModel();
        model.setRowCount(0); // Esto elimina todas las filas previas
        //Obtener lista de Tareas
        List<Tarea> listaTareas = logica.Main.getAllTaskFromUsername(usuarioActual);
        // Rellenar la tabla con las tareas
        
        for (Tarea tarea : listaTareas) {
            Object[] rowData = {
                tarea.getId(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getFechaEntrega(),
                tarea.getFechaCreacion()
            };
            // Añadir fila al modelo de la tabla
            model.addRow(rowData);
        }
        //  ESTILO
        table_tareas.setDefaultRenderer(table_tareas.getColumnClass(0), new CustomTableCellRenderer());
        table_tareas.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        //    FILAS
        CustomTableCellRenderer centerRenderer = new CustomTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table_tareas.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); // Fecha de Entrega centrada
        table_tareas.getColumnModel().getColumn(5).setCellRenderer(centerRenderer); // Fecha de Creación centrada
        //      ALTO FILAS
        table_tareas.setRowHeight(23); // Altura de las filas
        //    COLUMNAS
        table_tareas.getColumnModel().getColumn(0).setPreferredWidth(30); // ID (3 digits)
        table_tareas.getColumnModel().getColumn(1).setPreferredWidth(120); // Titulo
        //table_tareas.getColumnModel().getColumn(2).setPreferredWidth(160); // Descripción
        table_tareas.getColumnModel().getColumn(3).setPreferredWidth(70); // Estado
        table_tareas.getColumnModel().getColumn(4).setPreferredWidth(120); // Fecha de entrega
        table_tareas.getColumnModel().getColumn(5).setPreferredWidth(120); // Fecha de creación
        //      BORDES
        table_tareas.setShowGrid(false); // Oculta los bordes de las celdas
        //      HEADER
        table_tareas.getTableHeader().setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14));
        table_tareas.getTableHeader().setBackground(new Color( 157, 190, 222 )); // Color del header
        table_tareas.getTableHeader().setForeground(Color.BLACK); // Color del texto en el header
    }
    
    // Método para formatear fecha con manejo de null
    public static String formatFecha(Date fecha, SimpleDateFormat dateFormat) {
        if (fecha != null) {
            return dateFormat.format(fecha);
        } else {
            return "Sin fecha"; // O "" si prefieres dejar la celda vacía
        }
    }
    
    // Método para actualizar los detalles de la tarea seleccionada
    private void updateDetallesTarea(Tarea tarea) {
        if (tarea != null) {
            lbl_panel_tarea_titulo.setText(tarea.getTitulo());
            txt_tarea_descr.setText(tarea.getDescripcion());
            updateEstadoIcono(tarea.getEstado());
            lbl_panel_tarea_tiempoRestante.setText(calcularTiempoRestante(tarea.getFechaEntrega()));
        } else {
            // Si no hay tarea seleccionada, muestra texto por defecto
            lbl_panel_tarea_titulo.setText("Título");
            txt_tarea_descr.setText("Descripción.");
            updateEstadoIcono("None");
            lbl_panel_tarea_tiempoRestante.setText("Tiempo restante.");
        }
    }
    
    // Método para calcular el tiempo restante hasta la fecha de entrega
    private String calcularTiempoRestante(String fechaEntrega) {
        SimpleDateFormat formato = MainMenu.dateFormat;
        Date fechaEntregaDate;
        
        if (fechaEntrega == null) {
            return "Sin fecha de entrega";
        }
        
        try {
            // Parsear la fecha de entrega
            fechaEntregaDate = formato.parse(fechaEntrega);
        } catch (ParseException e) {
            //return "Formato de fecha inválido. Debe ser dd-MM-yyyy";
            return "---";
        }
        
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Calcular la diferencia en milisegundos
        long tiempoRestante = fechaEntregaDate.getTime() - fechaActual.getTime();

        if (tiempoRestante <= 0) {
            return "Entrega vencida";
        }
        
        if (tareaSeleccionada.getEstado().equalsIgnoreCase("Finalizado")) {
            return "Entrega completada";
        }

        long diasRestantes = tiempoRestante / (1000 * 60 * 60 * 24); // Convertir a días

        if (diasRestantes > 0) {
            return diasRestantes + " días restantes";
        } else {
            long horasRestantes = tiempoRestante / (1000 * 60 * 60); // Convertir a horas
            if (horasRestantes > 0) {
                return horasRestantes + " horas restantes";
            } else {
                long minutosRestantes = tiempoRestante / (1000 * 60); // Convertir a minutos
                return minutosRestantes + " minutos restantes";
            }
        }
    }

    // Método para actualizar el estado de la tarea como ícono en el panel
    private void updateEstadoIcono(String estado) {
        String iconPath = "";
        
        iconPath = switch (estado) {
            case "Finalizado" -> "ico_tarea_finalizado.png";
            case "Pendiente" -> "ico_tarea_pendiente.png";
            case "Nuevo" -> "ico_tarea_nuevo.png";
            default -> "ico_sin_tareas.png";
        };

        // Cargar el ícono
        ImageIcon icono = new ImageIcon(getClass().getResource(iconPath));

        // Actualizar el JLabel del ícono
        lbl_panel_tarea_estado.setIcon(icono);
    }
    
    private void updateTareasMainMenu() {
        updateTableTareas();
        tareaSeleccionada = null;
        updateDetallesTarea(tareaSeleccionada);
        btn_ver_detalles.setEnabled(false);
        btn_editar_tarea.setEnabled(false);
        btn_eliminar_tarea.setEnabled(false);
    }
    
    private void updateTareasMainMenu(Tarea tarea) {
        int selectedRow = table_tareas.getSelectedRow();        
        updateTableTareas();
        table_tareas.changeSelection(selectedRow, 0, true, false);
        updateDetallesTarea(tarea);
    }

    private void runVerDetallesTarea() {
        int filaSeleccionada = table_tareas.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Mostrar los detalles en un JDialog
            DetallesTarea detallesTarea = new DetallesTarea(this, true);
            detallesTarea.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para ver los detalles.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        scroll_table_tareas = new javax.swing.JScrollPane();
        table_tareas = new javax.swing.JTable();
        btn_crear_tarea = new javax.swing.JButton();
        btn_editar_tarea = new javax.swing.JButton();
        btn_eliminar_tarea = new javax.swing.JButton();
        panel_tarea = new javax.swing.JPanel();
        lbl_panel_tarea_titulo = new javax.swing.JLabel();
        lbl_panel_tarea_estado = new javax.swing.JLabel();
        btn_ver_detalles = new javax.swing.JButton();
        lbl_panel_tarea_tiempoRestante = new javax.swing.JLabel();
        scroll_tarea_descr = new javax.swing.JScrollPane();
        txt_tarea_descr = new javax.swing.JTextArea();
        barraMenu = new javax.swing.JMenuBar();
        menu_usuario = new javax.swing.JMenu();
        submenu_cerrarSesion = new javax.swing.JMenuItem();
        submenu_modificarCuenta = new javax.swing.JMenuItem();
        submenu_eliminarCuenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Task Management");

        Escritorio.setBackground(new java.awt.Color(30, 61, 88));
        Escritorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EscritorioMouseClicked(evt);
            }
        });

        scroll_table_tareas.setBackground(new java.awt.Color(242, 242, 242));

        table_tareas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_tareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Descripción", "Estado", "Entrega", "Creación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_tareas.setToolTipText(table_tareas.getName());
        table_tareas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table_tareas.setColumnSelectionAllowed(true);
        table_tareas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_tareas.setGridColor(new java.awt.Color(206, 224, 238));
        table_tareas.setName("Mis Tareas"); // NOI18N
        table_tareas.setUpdateSelectionOnSort(false);
        scroll_table_tareas.setViewportView(table_tareas);
        table_tareas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table_tareas.getColumnModel().getColumnCount() > 0) {
            table_tareas.getColumnModel().getColumn(0).setResizable(false);
            table_tareas.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_tareas.getColumnModel().getColumn(1).setResizable(false);
            table_tareas.getColumnModel().getColumn(1).setPreferredWidth(120);
            table_tareas.getColumnModel().getColumn(2).setResizable(false);
            table_tareas.getColumnModel().getColumn(2).setPreferredWidth(162);
            table_tareas.getColumnModel().getColumn(3).setResizable(false);
            table_tareas.getColumnModel().getColumn(3).setPreferredWidth(70);
            table_tareas.getColumnModel().getColumn(4).setResizable(false);
            table_tareas.getColumnModel().getColumn(4).setPreferredWidth(120);
            table_tareas.getColumnModel().getColumn(5).setResizable(false);
            table_tareas.getColumnModel().getColumn(5).setPreferredWidth(120);
        }

        btn_crear_tarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_crear_tarea.png"))); // NOI18N
        btn_crear_tarea.setToolTipText("Crear tarea");
        btn_crear_tarea.setPreferredSize(new java.awt.Dimension(48, 48));
        btn_crear_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_tareaActionPerformed(evt);
            }
        });

        btn_editar_tarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_editar_tarea.png"))); // NOI18N
        btn_editar_tarea.setToolTipText("Editar tarea");
        btn_editar_tarea.setPreferredSize(new java.awt.Dimension(48, 48));
        btn_editar_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_tareaActionPerformed(evt);
            }
        });

        btn_eliminar_tarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_eliminar_tarea.png"))); // NOI18N
        btn_eliminar_tarea.setToolTipText("Borrar tarea");
        btn_eliminar_tarea.setPreferredSize(new java.awt.Dimension(48, 48));
        btn_eliminar_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_tareaActionPerformed(evt);
            }
        });

        lbl_panel_tarea_titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_panel_tarea_titulo.setText("Título");

        lbl_panel_tarea_estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_panel_tarea_estado.setToolTipText("Estado");
        lbl_panel_tarea_estado.setAlignmentX(0.5F);

        btn_ver_detalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_tarea_detalles.png"))); // NOI18N
        btn_ver_detalles.setToolTipText("Ver más");
        btn_ver_detalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ver_detallesActionPerformed(evt);
            }
        });

        lbl_panel_tarea_tiempoRestante.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_panel_tarea_tiempoRestante.setText("Tiempo restante");
        lbl_panel_tarea_tiempoRestante.setToolTipText("Tiempo para la entrega");

        scroll_tarea_descr.setBackground(new java.awt.Color(242, 242, 242));
        scroll_tarea_descr.setBorder(null);

        txt_tarea_descr.setEditable(false);
        txt_tarea_descr.setColumns(20);
        txt_tarea_descr.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tarea_descr.setLineWrap(true);
        txt_tarea_descr.setRows(5);
        txt_tarea_descr.setText("Descripción");
        txt_tarea_descr.setToolTipText("Descripción de la tarea");
        txt_tarea_descr.setWrapStyleWord(true);
        txt_tarea_descr.setBorder(null);
        txt_tarea_descr.setFocusable(false);
        txt_tarea_descr.setName("Descripción"); // NOI18N
        txt_tarea_descr.setOpaque(false);
        scroll_tarea_descr.setViewportView(txt_tarea_descr);

        javax.swing.GroupLayout panel_tareaLayout = new javax.swing.GroupLayout(panel_tarea);
        panel_tarea.setLayout(panel_tareaLayout);
        panel_tareaLayout.setHorizontalGroup(
            panel_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tareaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_tarea_descr)
                    .addGroup(panel_tareaLayout.createSequentialGroup()
                        .addComponent(lbl_panel_tarea_titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_panel_tarea_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                        .addComponent(lbl_panel_tarea_tiempoRestante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ver_detalles, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_tareaLayout.setVerticalGroup(
            panel_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tareaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_panel_tarea_estado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel_tareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_panel_tarea_titulo)
                            .addComponent(btn_ver_detalles, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_panel_tarea_tiempoRestante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_tarea_descr)
                .addContainerGap())
        );

        Escritorio.setLayer(scroll_table_tareas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(btn_crear_tarea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(btn_editar_tarea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(btn_eliminar_tarea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(panel_tarea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll_table_tareas))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_crear_tarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar_tarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar_tarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll_table_tareas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addComponent(btn_crear_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editar_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_eliminar_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panel_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        scroll_table_tareas.getAccessibleContext().setAccessibleName("scrollPane_table_tareas");
        scroll_table_tareas.getAccessibleContext().setAccessibleDescription("scroll panel for table_tareas");

        barraMenu.setBackground(new java.awt.Color(227, 242, 253));

        menu_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_userMenu.png"))); // NOI18N
        menu_usuario.setToolTipText("Usuario");
        menu_usuario.setBorderPainted(false);

        submenu_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_logout.png"))); // NOI18N
        submenu_cerrarSesion.setText("Cerrar sesión");
        submenu_cerrarSesion.setToolTipText("<html><strong>Anda. ¡Vete!</strong><br>\n<html><i>Sé que volveras arrastrándote...</i>");
        submenu_cerrarSesion.setBorderPainted(false);
        submenu_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_cerrarSesionActionPerformed(evt);
            }
        });
        menu_usuario.add(submenu_cerrarSesion);

        submenu_modificarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_modifyUser.png"))); // NOI18N
        submenu_modificarCuenta.setText("Modificar cuenta");
        submenu_modificarCuenta.setToolTipText("Cambios de identidad...");
        submenu_modificarCuenta.setBorderPainted(false);
        submenu_modificarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_modificarCuentaActionPerformed(evt);
            }
        });
        menu_usuario.add(submenu_modificarCuenta);

        submenu_eliminarCuenta.setBackground(new java.awt.Color(244, 67, 54));
        submenu_eliminarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ico_deleteUser.png"))); // NOI18N
        submenu_eliminarCuenta.setText("Eliminar cuenta");
        submenu_eliminarCuenta.setToolTipText("Cuidado con esto manito");
        submenu_eliminarCuenta.setBorderPainted(false);
        submenu_eliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_eliminarCuentaActionPerformed(evt);
            }
        });
        menu_usuario.add(submenu_eliminarCuenta);

        barraMenu.add(menu_usuario);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenu_modificarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_modificarCuentaActionPerformed
        UpdateUser update_user = new UpdateUser(this);
        update_user.setVisible(true);
        updateMenuBar();
    }//GEN-LAST:event_submenu_modificarCuentaActionPerformed

    private void submenu_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_cerrarSesionActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Estás por cerrar tu sesión.\n ¿Estás seguro?", "Cerrar Sesión", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
            System.out.println("User " + usuarioActual + " out.");
            usuarioActual = null;
            this.dispose();
        }
    }//GEN-LAST:event_submenu_cerrarSesionActionPerformed

    private void submenu_eliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_eliminarCuentaActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Estás a punto de eliminar para siempre tu cuenta.\n ¿Estás seguro?", "Eliminar cuenta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
            if (logica.Main.eliminarUsuario(usuarioActual)) {
                JOptionPane.showMessageDialog(this, "Cuenta eliminada. \nLamentamos despedirte aquí! \nPero no te rogaremos para que vuelvas...", "El fin de " + usuarioActual, JOptionPane.PLAIN_MESSAGE);
            }
            System.out.println("Cuenta de "+ usuarioActual + " Eliminada.");
            usuarioActual = null;
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_submenu_eliminarCuentaActionPerformed

    private void btn_ver_detallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver_detallesActionPerformed
        runVerDetallesTarea();
    }//GEN-LAST:event_btn_ver_detallesActionPerformed

    private void EscritorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EscritorioMouseClicked
        updateTareasMainMenu();
    }//GEN-LAST:event_EscritorioMouseClicked

    private void btn_crear_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_tareaActionPerformed
        CrearTarea crearTarea = new CrearTarea(this, true);

        crearTarea.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                updateTareasMainMenu();
            }
        });
        crearTarea.setVisible(true);
        updateTableTareas();
        int tareaId = (int) table_tareas.getValueAt(table_tareas.getRowCount() - 1, 0);
        tareaSeleccionada = logica.Main.getTaskById(tareaId); //Actualizar tarea seleccionada
        updateTareasMainMenu(tareaSeleccionada);
    }//GEN-LAST:event_btn_crear_tareaActionPerformed

    private void btn_editar_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_tareaActionPerformed
        EditarTarea editarTarea = new EditarTarea(this, true);
        editarTarea.setVisible(true);
        tareaSeleccionada = logica.Main.getTaskById(tareaSeleccionada.getId()); //Actualizar tarea seleccionada
        updateTareasMainMenu(tareaSeleccionada);
    }//GEN-LAST:event_btn_editar_tareaActionPerformed

    private void btn_eliminar_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_tareaActionPerformed
        if(JOptionPane.showConfirmDialog(this,
                "Estás a punto de eliminar para siempre esta tarea. ¿Estás seguro?",
                "Eliminar " + tareaSeleccionada.getTitulo(),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE) == 0){
            logica.Main.eliminarTarea(tareaSeleccionada.getId());
            updateTareasMainMenu();
        }
    }//GEN-LAST:event_btn_eliminar_tareaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu("mind972").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btn_crear_tarea;
    private javax.swing.JButton btn_editar_tarea;
    private javax.swing.JButton btn_eliminar_tarea;
    private javax.swing.JButton btn_ver_detalles;
    private javax.swing.JLabel lbl_panel_tarea_estado;
    private javax.swing.JLabel lbl_panel_tarea_tiempoRestante;
    private javax.swing.JLabel lbl_panel_tarea_titulo;
    private javax.swing.JMenu menu_usuario;
    private javax.swing.JPanel panel_tarea;
    private javax.swing.JScrollPane scroll_table_tareas;
    private javax.swing.JScrollPane scroll_tarea_descr;
    private javax.swing.JMenuItem submenu_cerrarSesion;
    private javax.swing.JMenuItem submenu_eliminarCuenta;
    private javax.swing.JMenuItem submenu_modificarCuenta;
    private javax.swing.JTable table_tareas;
    private javax.swing.JTextArea txt_tarea_descr;
    // End of variables declaration//GEN-END:variables
}
