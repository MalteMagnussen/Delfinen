package Presentation;

import Data.TxtAccess;
import Logic.Controller;
import Logic.Member;
import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mikkel
 */
public class Formand extends javax.swing.JFrame {

    Controller cp = new Controller();
    TxtAccess ta = new TxtAccess();
    JOptionPane op = new JOptionPane();
    

    /**
     * Creates new form Second
     */
    public Formand() {
        initComponents();

        this.buttonGroup1.add(jActive);
        this.buttonGroup1.add(jPassive);

        this.buttonGroup2.add(jActiveChange);
        this.buttonGroup2.add(jPassiveChange);
    }
    
    public void clearFields() {
        jName.setText("");
        jAddress.setText("");
        jBirthday.setText("yyyy-mm-dd");
        jNumber.setText("");
        jEmail.setText("");
        buttonGroup2.clearSelection();
        jStyles.setSelectedIndex(-1);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCreateMember = new javax.swing.JFrame();
        jName = new javax.swing.JTextField();
        jBirthday = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jActive = new javax.swing.JRadioButton();
        jPassive = new javax.swing.JRadioButton();
        jCreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jStyles = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jChangeMember = new javax.swing.JFrame();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jActiveChange = new javax.swing.JRadioButton();
        jPassiveChange = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDeleteMember = new javax.swing.JFrame();
        jDeleteID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jDelete = new javax.swing.JButton();
        jFindMember = new javax.swing.JFrame();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jBackButton = new javax.swing.JButton();
        jFormandLabel = new javax.swing.JLabel();
        jCreateMemberButton = new javax.swing.JButton();
        jChangeMemberButton = new javax.swing.JButton();
        jDeleteMemberButton = new javax.swing.JButton();
        jFindMemberButton = new javax.swing.JButton();

        jCreateMember.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jCreateMember.setTitle("Nyt medlem");

        jName.setText("Mikkel");

        jBirthday.setText("1993-05-12");

        jLabel2.setLabelFor(jName);
        jLabel2.setText("Navn:");

        jLabel3.setLabelFor(jBirthday);
        jLabel3.setText("Fødselsdag:");

        jAddress.setText("Lyngby");

        jLabel4.setLabelFor(jAddress);
        jLabel4.setText("Adresse:");

        jEmail.setText("Example@mail.dk");

        jLabel5.setLabelFor(jEmail);
        jLabel5.setText("Mail:");

        jLabel6.setLabelFor(jNumber);
        jLabel6.setText("Tlf. nummer:");

        jNumber.setText("31675555");

        jLabel8.setLabelFor(jActive);
        jLabel8.setText("Passiv/ Aktiv:");

        jActive.setText("Aktiv");

        jPassive.setText("Passiv");

        jCreate.setText("Opret");
        jCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateActionPerformed(evt);
            }
        });

        jStyles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Crawl", "BackCrawl", "Butterfly", "Breast", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jStyles);

        jLabel9.setLabelFor(jScrollPane1);
        jLabel9.setText("Disciplin:");

        javax.swing.GroupLayout jCreateMemberLayout = new javax.swing.GroupLayout(jCreateMember.getContentPane());
        jCreateMember.getContentPane().setLayout(jCreateMemberLayout);
        jCreateMemberLayout.setHorizontalGroup(
            jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCreateMemberLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jCreateMemberLayout.createSequentialGroup()
                        .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPassive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jName)
                            .addComponent(jNumber)
                            .addComponent(jAddress)
                            .addComponent(jBirthday)
                            .addComponent(jEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jCreateMemberLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );
        jCreateMemberLayout.setVerticalGroup(
            jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCreateMemberLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jCreateMemberLayout.createSequentialGroup()
                        .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(19, 19, 19)
                        .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jCreateMemberLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCreateMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jActive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassive)
                .addGap(46, 46, 46)
                .addComponent(jCreate)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jChangeMember.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jChangeMember.setTitle("Ændre medlem");

        jLabel10.setText("Member ID:");

        jButton6.setText("Ændrer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setText("Status:");

        jActiveChange.setText("Aktiv");

        jPassiveChange.setText("Passiv");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Crawl", "BackCrawl", "Butterfly", "Breast", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel12.setText("Styles:");

        javax.swing.GroupLayout jChangeMemberLayout = new javax.swing.GroupLayout(jChangeMember.getContentPane());
        jChangeMember.getContentPane().setLayout(jChangeMemberLayout);
        jChangeMemberLayout.setHorizontalGroup(
            jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jChangeMemberLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addGroup(jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jChangeMemberLayout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jChangeMemberLayout.createSequentialGroup()
                            .addGroup(jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addGap(35, 35, 35)
                            .addGroup(jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jActiveChange, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jChangeMemberLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton6))
                    .addComponent(jPassiveChange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jChangeMemberLayout.setVerticalGroup(
            jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jChangeMemberLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jChangeMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jActiveChange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPassiveChange)
                .addGap(40, 40, 40)
                .addComponent(jButton6)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jDeleteMember.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDeleteMember.setTitle("Slet medlem");

        jLabel7.setText("Medlems ID:");

        jDelete.setText("Slet!");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDeleteMemberLayout = new javax.swing.GroupLayout(jDeleteMember.getContentPane());
        jDeleteMember.getContentPane().setLayout(jDeleteMemberLayout);
        jDeleteMemberLayout.setHorizontalGroup(
            jDeleteMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDeleteMemberLayout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addGroup(jDeleteMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDeleteMemberLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDeleteID, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(238, 238, 238))
        );
        jDeleteMemberLayout.setVerticalGroup(
            jDeleteMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDeleteMemberLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jDeleteMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDeleteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(106, 106, 106)
                .addComponent(jDelete)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        jButton5.setText("Find");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setText("Medlem ID:");

        jLabel14.setText("Navn");

        jLabel15.setText("Alder");

        jLabel17.setText("Status");

        jLabel18.setText("Disciplin");

        jLabel19.setText("Oprettet");

        javax.swing.GroupLayout jFindMemberLayout = new javax.swing.GroupLayout(jFindMember.getContentPane());
        jFindMember.getContentPane().setLayout(jFindMemberLayout);
        jFindMemberLayout.setHorizontalGroup(
            jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFindMemberLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jTextField6)
                    .addComponent(jTextField5)
                    .addComponent(jTextField4)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jFindMemberLayout.setVerticalGroup(
            jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFindMemberLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton5))
                .addGap(32, 32, 32)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(30, 30, 30)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(30, 30, 30)
                .addGroup(jFindMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formand");
        setBackground(new java.awt.Color(0, 0, 0));

        jBackButton.setText("Tilbage");
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jFormandLabel.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jFormandLabel.setText("Formand");
        jFormandLabel.setAlignmentY(0.0F);

        jCreateMemberButton.setText("Opret nyt medlem");
        jCreateMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateMemberButtonActionPerformed(evt);
            }
        });

        jChangeMemberButton.setText("Ændre medlem");
        jChangeMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeMemberButtonActionPerformed(evt);
            }
        });

        jDeleteMemberButton.setText("Slet medlem");
        jDeleteMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteMemberButtonActionPerformed(evt);
            }
        });

        jFindMemberButton.setText("Find medlem");
        jFindMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFindMemberButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jBackButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFindMemberButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFormandLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCreateMemberButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jChangeMemberButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDeleteMemberButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(328, 328, 328))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jBackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormandLabel)
                .addGap(80, 80, 80)
                .addComponent(jCreateMemberButton)
                .addGap(50, 50, 50)
                .addComponent(jChangeMemberButton)
                .addGap(50, 50, 50)
                .addComponent(jDeleteMemberButton)
                .addGap(50, 50, 50)
                .addComponent(jFindMemberButton)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChangeMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeMemberButtonActionPerformed
        jChangeMember.setVisible(true);
        jChangeMember.setSize(600, 450);
    }//GEN-LAST:event_jChangeMemberButtonActionPerformed

    private void jCreateMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateMemberButtonActionPerformed
        jCreateMember.setVisible(true);
        jCreateMember.setSize(600, 450);
    }//GEN-LAST:event_jCreateMemberButtonActionPerformed
/**
 * Takes the given data from the user, makes a member and assignes a ID value
 * then safes the player in the members.txt.
 * @param evt make member
 */
    private void jCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateActionPerformed
        String name = jName.getText();
        String number = jNumber.getText();
        String mail = jEmail.getText();
        String address = jAddress.getText();
        LocalDate age = LocalDate.parse(jBirthday.getText());
        boolean status = false;
        if (jActive.isSelected()) {
            status = true;
        }
        String style = "";
            if (jStyles.isSelectionEmpty()) {
                style += "Ingen";
            } else {
                style = jStyles.getSelectedValue();
            }
        cp.makeMember(name, age, address, mail, number, status, style);
        //JOptionPane.showConfirmDialog(null, "Are you sure?");
        clearFields();
        jCreateMember.setVisible(false);
    }//GEN-LAST:event_jCreateActionPerformed
/**
 * Findes the requested player from an ID and changes the members swimming stype 
 * and status to the given state.
 * @param evt Change member
 */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String id = this.jTextField3.getText();
        String style = "";
        if (this.jList2.isSelectionEmpty()) {
            style += "No style";
        } else {
            style = this.jList2.getSelectedValue();
        }
        boolean status = false;
        if (jActiveChange.isSelected()) {
            status = true;
        }
        cp.changeMember(id, status, style);
        jChangeMember.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jDeleteMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteMemberButtonActionPerformed
        jDeleteMember.setVisible(true);
        jDeleteMember.setSize(600, 450);
    }//GEN-LAST:event_jDeleteMemberButtonActionPerformed
/**
 * findes a member and delete him
 * @param evt delete member
 */
    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        String id = jDeleteID.getText();
        ta.deleteMember(id);
        jDeleteMember.setVisible(false);
    }//GEN-LAST:event_jDeleteActionPerformed

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        this.setVisible(false);
        new Delfinen().setVisible(true);
    }//GEN-LAST:event_jBackButtonActionPerformed
/**
 * Findes a member from given ID
 * @param evt find member
 */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Member member = ta.getMember(jTextField1.getText());
        jTextField2.setText(member.getName());
        jTextField4.setText(Integer.toString(member.getAge()));
        if (member.isStatus()) {
            jTextField5.setText("Aktiv");
        } else {
            jTextField5.setText("Passiv");
        }
        jTextField6.setText(member.getType());
        jTextField7.setText(Integer.toString(member.getYearJoined()));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jFindMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFindMemberButtonActionPerformed
        jFindMember.setVisible(true);
        jFindMember.setSize(600, 450);
    }//GEN-LAST:event_jFindMemberButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton jActive;
    private javax.swing.JRadioButton jActiveChange;
    private javax.swing.JTextField jAddress;
    private javax.swing.JButton jBackButton;
    private javax.swing.JTextField jBirthday;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jChangeMember;
    private javax.swing.JButton jChangeMemberButton;
    private javax.swing.JButton jCreate;
    private javax.swing.JFrame jCreateMember;
    private javax.swing.JButton jCreateMemberButton;
    private javax.swing.JButton jDelete;
    private javax.swing.JTextField jDeleteID;
    private javax.swing.JFrame jDeleteMember;
    private javax.swing.JButton jDeleteMemberButton;
    private javax.swing.JTextField jEmail;
    private javax.swing.JFrame jFindMember;
    private javax.swing.JButton jFindMemberButton;
    private javax.swing.JLabel jFormandLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JTextField jName;
    private javax.swing.JTextField jNumber;
    private javax.swing.JRadioButton jPassive;
    private javax.swing.JRadioButton jPassiveChange;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jStyles;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
