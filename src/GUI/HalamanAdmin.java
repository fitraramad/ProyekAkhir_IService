/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Interface.TableDB;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import oop.Akun;
import oop.Register;

/**
 *
 * @author User
 */
public class HalamanAdmin extends javax.swing.JFrame implements TableDB{

    /**
     * Creates new form HalamanMahasiswa
     */
    Akun akun;
    Register register;
    String kodeService;
    private static final File file = new File("src/sound/backsound.wav");
    private AudioInputStream audioInputStream;
    private Clip clip;
    
    public HalamanAdmin() {
        initComponents();
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        layerDataService.setVisible(true);
        layerHistoryLogin.setVisible(false);
        layerAkunCustomer.setVisible(false);
        buttonMusicOn.setVisible(false);
        buttonMusicOff.setVisible(true);
        addPlaceholderStyle(email);
        addPlaceholderStyle(namaLengkap);
        addPlaceholderStyle(password);
        tampilkanDataAkunCustomer();
        kosongkanDataAkunCustomer();
        tampilkanDataHistoryLogin();
        tampilkanDataService();
    }
    
    public void addPlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.BLACK);
    }
    
    public void removePlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }
    
    @Override
    public void tampilkanDataAkunCustomer() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Nama Lengkap");
        modelTable.addColumn("Email");
        modelTable.addColumn("Password");
        try {

            String sql = "SELECT * FROM akuncustomer";
            java.sql.Connection connection = (Connection) Koneksi.konfigDB();
            java.sql.Statement stm = connection.createStatement();
            java.sql.ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                modelTable.addRow(new Object[] {result.getString(1), result.getString(2), result.getString(3)});
            }
            akunCustomer.setModel(modelTable);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void tampilkanDataService() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Kode");
        modelTable.addColumn("Jenis Handpone");
        modelTable.addColumn("Tipe Handpone");
        modelTable.addColumn("Alamat Lengkap");
        modelTable.addColumn("Kerusakan Handpone");
        modelTable.addColumn("Status Service");
        try {

            String sql = "SELECT * FROM dataservice";
            java.sql.Connection connection = (Connection) Koneksi.konfigDB();
            java.sql.Statement stm = connection.createStatement();
            java.sql.ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                modelTable.addRow(new Object[] {result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)});
            }
            dataService.setModel(modelTable);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void kosongkanDataAkunCustomer() {
        tampilkanDataAkunCustomer();
        namaLengkap.setText("Nama Lengkap");
        email.setText("Email");
        password.setText("Password");
    }
    
    @Override
    public void tampilkanDataHistoryLogin() {
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("Nama Lengkap");
        modelTable.addColumn("Email");
        modelTable.addColumn("Password");
        modelTable.addColumn("Tanggal Login");
        try {
            String sql = "SELECT * FROM historylogin";
            java.sql.Connection connection = (Connection) Koneksi.konfigDB();
            java.sql.Statement stm = connection.createStatement();
            java.sql.ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                modelTable.addRow(new Object[] {result.getString(1), result.getString(2), result.getString(3), result.getString(4)});
            }
            historyLogin.setModel(modelTable);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        layerAkunCustomer = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        akunCustomer = new javax.swing.JTable();
        namaLengkap = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        buttonRefresh = new javax.swing.JButton();
        buttonTambah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        buttonMusicOff = new javax.swing.JButton();
        buttonMusicOn = new javax.swing.JButton();
        layerHistoryLogin = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyLogin = new javax.swing.JTable();
        layerDataService = new javax.swing.JLayeredPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dataService = new javax.swing.JTable();
        buttonStatus = new javax.swing.JButton();
        statusComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        labelAkunCustomer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelDataService = new javax.swing.JLabel();
        logoutHalamanAdmin = new javax.swing.JButton();
        labelHistoryLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Halaman Admin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 780, 54));

        jPanel3.setBackground(new java.awt.Color(0, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        akunCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        akunCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                akunCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(akunCustomer);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 24, 730, 181));

        namaLengkap.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        namaLengkap.setText("Nama Lengkap");
        namaLengkap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                namaLengkapFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                namaLengkapFocusLost(evt);
            }
        });
        jPanel3.add(namaLengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 370, 31));

        email.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        email.setText("Email");
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        jPanel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 370, 31));

        buttonRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        jPanel3.add(buttonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 150, 40));

        buttonTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        jPanel3.add(buttonTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 150, 40));

        buttonHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });
        jPanel3.add(buttonHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 150, 40));

        buttonEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });
        jPanel3.add(buttonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 150, 40));

        password.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        password.setText("Password");
        password.setEchoChar('\u0000');
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 370, 30));

        layerAkunCustomer.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerAkunCustomerLayout = new javax.swing.GroupLayout(layerAkunCustomer);
        layerAkunCustomer.setLayout(layerAkunCustomerLayout);
        layerAkunCustomerLayout.setHorizontalGroup(
            layerAkunCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layerAkunCustomerLayout.setVerticalGroup(
            layerAkunCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(layerAkunCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 780, 380));

        buttonMusicOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sound off.png"))); // NOI18N
        buttonMusicOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMusicOffActionPerformed(evt);
            }
        });
        jPanel1.add(buttonMusicOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 60, 50));

        buttonMusicOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sound on.png"))); // NOI18N
        buttonMusicOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMusicOnActionPerformed(evt);
            }
        });
        jPanel1.add(buttonMusicOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 60, 50));

        jPanel4.setBackground(new java.awt.Color(0, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel4.setForeground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        historyLogin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(historyLogin);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 24, 720, 330));

        layerHistoryLogin.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerHistoryLoginLayout = new javax.swing.GroupLayout(layerHistoryLogin);
        layerHistoryLogin.setLayout(layerHistoryLoginLayout);
        layerHistoryLoginLayout.setHorizontalGroup(
            layerHistoryLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layerHistoryLoginLayout.setVerticalGroup(
            layerHistoryLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(layerHistoryLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 780, 380));

        jPanel6.setBackground(new java.awt.Color(0, 255, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel6.setForeground(new java.awt.Color(0, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dataService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dataService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataServiceMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(dataService);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 24, 730, 280));

        buttonStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonStatus.setText("Ubah Status");
        buttonStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStatusActionPerformed(evt);
            }
        });
        jPanel6.add(buttonStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 240, 27));

        statusComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status Service", "Telah Diselesaikan", "Tidak Dapat Diselesaikan", " " }));
        jPanel6.add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 440, 30));

        layerDataService.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerDataServiceLayout = new javax.swing.GroupLayout(layerDataService);
        layerDataService.setLayout(layerDataServiceLayout);
        layerDataServiceLayout.setHorizontalGroup(
            layerDataServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layerDataServiceLayout.setVerticalGroup(
            layerDataServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(layerDataService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 780, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 780, 510));

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAkunCustomer.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelAkunCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelAkunCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        labelAkunCustomer.setText("AKUN CUSTOMER");
        labelAkunCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAkunCustomerMouseClicked(evt);
            }
        });
        jPanel2.add(labelAkunCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 170, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MENU BAR");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 200, 50));

        labelDataService.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelDataService.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDataService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/service.png"))); // NOI18N
        labelDataService.setText("DATA SERVICE");
        labelDataService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDataServiceMouseClicked(evt);
            }
        });
        jPanel2.add(labelDataService, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, 50));

        logoutHalamanAdmin.setBackground(new java.awt.Color(255, 0, 0));
        logoutHalamanAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logoutHalamanAdmin.setForeground(new java.awt.Color(255, 255, 255));
        logoutHalamanAdmin.setText("Logout");
        logoutHalamanAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutHalamanAdminActionPerformed(evt);
            }
        });
        jPanel2.add(logoutHalamanAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 160, -1));

        labelHistoryLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelHistoryLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHistoryLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        labelHistoryLogin.setText("HISTORY LOGIN");
        labelHistoryLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHistoryLoginMouseClicked(evt);
            }
        });
        jPanel2.add(labelHistoryLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 170, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutHalamanAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutHalamanAdminActionPerformed
        // TODO add your handling code here:
        clip.stop();
        this.dispose();
        new HalamanLogin().setVisible(true);
    }//GEN-LAST:event_logoutHalamanAdminActionPerformed

    private void namaLengkapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaLengkapFocusGained
        // TODO add your handling code here:
        if (namaLengkap.getText().equals("Nama Lengkap")) {
            namaLengkap.setText("");
            namaLengkap.requestFocus();
            removePlaceholderStyle(namaLengkap);
        }
    }//GEN-LAST:event_namaLengkapFocusGained

    private void namaLengkapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaLengkapFocusLost
        // TODO add your handling code here:
        if (namaLengkap.getText().length() == 0) {
            addPlaceholderStyle(namaLengkap);
            namaLengkap.setText("Nama Lengkap");
        }
    }//GEN-LAST:event_namaLengkapFocusLost

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        // TODO add your handling code here:
        if (email.getText().equals("Email")) {
            email.setText("");
            email.requestFocus();
            removePlaceholderStyle(email);
        }
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:
        if (email.getText().length() == 0) {
            addPlaceholderStyle(email);
            email.setText("Email");
        }
    }//GEN-LAST:event_emailFocusLost

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
         if (password.getText().equals("Password")) {
            password.setText("");
            password.requestFocus();
            password.setEchoChar('*');
            removePlaceholderStyle(password);
        }
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().length() == 0) {
            addPlaceholderStyle(password);
            password.setText("Password");
            password.setEchoChar((char)0);
        }
    }//GEN-LAST:event_passwordFocusLost

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
         try {
            akun = new Register (email.getText(), password.getText(), namaLengkap.getText());
            if (akun instanceof Register) {
                register = (Register) akun;
            }
            String sql = "INSERT INTO akuncustomer VALUES ('" + register.getNamaLengkap() + "','" + register.getEmail() +  "','" + register.getPassword() + "')";   
            java.sql.Connection connection = (Connection) Koneksi.konfigDB();
            java.sql.PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            kosongkanDataAkunCustomer();
            JOptionPane.showMessageDialog(null, "Akun Customer Berhasil di Tambahkan", "Messagge", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Username ini sudah digunakan", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
         try {
            akun = new Register (email.getText(), password.getText());
            if (akun instanceof Register) {
                register = (Register) akun;
            }
            String sql = "DELETE FROM akuncustomer WHERE email='" + register.getEmail() + "'";
            java.sql.Connection connection = (Connection) Koneksi.konfigDB();
            java.sql.PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            kosongkanDataAkunCustomer();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus","Messagge", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void akunCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_akunCustomerMouseClicked
        // TODO add your handling code here:
        password.setEchoChar('\u0000');
        int row = akunCustomer.rowAtPoint(evt.getPoint());
        String nama = akunCustomer.getValueAt(row, 0).toString();
        namaLengkap.setText(nama);
        String emailSql = akunCustomer.getValueAt(row, 1).toString();
        email.setText(emailSql);
        String passwordSql = akunCustomer.getValueAt(row, 2).toString();
        password.setText(passwordSql);
    }//GEN-LAST:event_akunCustomerMouseClicked

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
        try {
            akun = new Register (email.getText(), password.getText(), namaLengkap.getText());
            if (akun instanceof Register) {
                register = (Register) akun;
            }
            String sql = "UPDATE akuncustomer SET nama='" + register.getNamaLengkap() + "',email='"
                    + register.getEmail() + "',password='" + register.getPassword() + "' WHERE email='" + register.getEmail() + "'";
            java.sql.Connection connection = (Connection) Koneksi.konfigDB();
            java.sql.PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            kosongkanDataAkunCustomer();
            JOptionPane.showMessageDialog(null, "Data Telah Berhasil di Edit", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        kosongkanDataAkunCustomer();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void labelAkunCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAkunCustomerMouseClicked
        // TODO add your handling code here:
        layerAkunCustomer.setVisible(true);
        layerHistoryLogin.setVisible(false);
        layerDataService.setVisible(false);
    }//GEN-LAST:event_labelAkunCustomerMouseClicked

    private void labelHistoryLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHistoryLoginMouseClicked
        // TODO add your handling code here:
        layerAkunCustomer.setVisible(false);
        layerHistoryLogin.setVisible(true);
        layerDataService.setVisible(false);
    }//GEN-LAST:event_labelHistoryLoginMouseClicked

    private void labelDataServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDataServiceMouseClicked
        // TODO add your handling code here:
        layerAkunCustomer.setVisible(false);
        layerHistoryLogin.setVisible(false);
        layerDataService.setVisible(true);
    }//GEN-LAST:event_labelDataServiceMouseClicked

    private void dataServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataServiceMouseClicked
        // TODO add your handling code here:
        int row = dataService.rowAtPoint(evt.getPoint());
        kodeService = dataService.getValueAt(row, 0).toString();
        
    }//GEN-LAST:event_dataServiceMouseClicked

    private void buttonStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStatusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE dataservice SET status='" + statusComboBox.getSelectedItem() +  "' WHERE kodeservice='" + kodeService + "'";
            java.sql.Connection connection = (Connection) Koneksi.konfigDB();
            java.sql.PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            tampilkanDataService();
            JOptionPane.showMessageDialog(null, "Status Berhasil Diubah", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonStatusActionPerformed

    private void buttonMusicOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMusicOffActionPerformed
        // TODO add your handling code here:
        buttonMusicOff.setVisible(false);
        buttonMusicOn.setVisible(true);
        clip.stop();
    }//GEN-LAST:event_buttonMusicOffActionPerformed

    private void buttonMusicOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMusicOnActionPerformed
        // TODO add your handling code here:
        buttonMusicOff.setVisible(true);
        buttonMusicOn.setVisible(false);
        clip.start();
    }//GEN-LAST:event_buttonMusicOnActionPerformed

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
            java.util.logging.Logger.getLogger(HalamanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanAdmin().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable akunCustomer;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonMusicOff;
    private javax.swing.JButton buttonMusicOn;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonStatus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JTable dataService;
    private javax.swing.JTextField email;
    private javax.swing.JTable historyLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelAkunCustomer;
    private javax.swing.JLabel labelDataService;
    private javax.swing.JLabel labelHistoryLogin;
    private javax.swing.JLayeredPane layerAkunCustomer;
    private javax.swing.JLayeredPane layerDataService;
    private javax.swing.JLayeredPane layerHistoryLogin;
    private javax.swing.JButton logoutHalamanAdmin;
    private javax.swing.JTextField namaLengkap;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> statusComboBox;
    // End of variables declaration//GEN-END:variables

}
