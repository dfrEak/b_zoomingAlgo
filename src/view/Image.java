/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domain.ImageContainer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.Helper;
import util.Polynomial;
import util.Source;
import zooming.ZoomingAlgorithm;

/**
 *
 * @author d_frEak
 */
public class Image extends javax.swing.JFrame {
    private File mSourceImage;
    private BufferedImage mCompare=null;
    private BufferedImage mResult;
    private ImageContainer mResult2;
    private String mMessage;

    /**
     * Creates new form Image
     */
    public Image() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    // additional functional for view
    private void convert(int index)
    {
        mResult=null;
        // check the source image, ratio
        if(Source.Singleton().getImage()==null || !Helper.tryParseDouble(ratioText.getText()))
        {
            return;
        }
        
        if(index==0)
        {
            System.out.println("\nNearest Neighbor");
            if(Source.Singleton().getImage()!=null)
            {
                mResult=ZoomingAlgorithm.NearestNeighbor(Source.Singleton().getImage(), 
                        Double.valueOf(ratioText.getText()));
            }
            else
            {
                System.out.println("Image still null");
            }
        }
        else if(index==1)
        {
            System.out.println("\nBilinear");
            if(Source.Singleton().getImage()!=null)
            {
                mResult=ZoomingAlgorithm.Bilinear(Source.Singleton().getImage(), 
                        Double.valueOf(ratioText.getText()));
            }
            else
            {
                System.out.println("Image still null");
            }
        }
        else if(index==2)
        {
            System.out.println("\nGradient (Polynomial)");
            if(!Helper.tryParseInt(powerInput.getText()))
            {
                return;
            }
            Polynomial.Singleton().setPower(Integer.parseInt(powerInput.getText()));
            if(Source.Singleton().getImage()!=null)
            {
                mResult=ZoomingAlgorithm.Polynomial(Source.Singleton().getImage(), 
                        Double.valueOf(ratioText.getText()),Polynomial.Singleton().getPower());
            }
            else
            {
                System.out.println("Image still null");
            }
        }
    }
    
    private void convert2(int index)
    {
        mResult2=null;
        if(mResult==null || !Helper.tryParseDouble(ratioText.getText()))
        {
            return;
        }
        
        if(index==0)
        {
            System.out.println("\nZoom in: Nearest Neighbor");
            mResult2=ZoomingAlgorithm.NearestNeighbor(mResult, 
                    1/Double.valueOf(ratioText.getText()), 
                    Source.Singleton().getImage());
        }
        else if(index==1)
        {
            System.out.println("\nZoom in: Bilinear");
            mResult2=ZoomingAlgorithm.Bilinear(mResult, 
                    1/Double.valueOf(ratioText.getText()),
                    Source.Singleton().getImage());
        }
        else if(index==2)
        {
            System.out.println("\nZoom in: Polynomial");
            if(!Helper.tryParseInt(powerInput.getText()))
            {
                return;
            }
            mResult2=ZoomingAlgorithm.Polynomial(mResult, 
                    1/Double.valueOf(ratioText.getText()), Integer.parseInt(powerInput.getText()),
                    Source.Singleton().getImage());
        }
        mMessage="";
        mMessage+="All: \nmse="+mResult2.getMse()+" \npsnr="+mResult2.getPsnr()+" \ncc="+mResult2.getCrosscorrelation();
        mMessage+="\n\nRed: \nmse="+mResult2.getMsered()+" \npsnr="+mResult2.getPsnrred()+" \ncc="+mResult2.getCrosscorrelationred();
        mMessage+="\n\nGreen: \nmse="+mResult2.getMsegreen()+" \npsnr="+mResult2.getPsnrgreen()+" \ncc="+mResult2.getCrosscorrelationgreen();
        mMessage+="\n\nBlue: \nmse="+mResult2.getMseblue()+" \npsnr="+mResult2.getPsnrblue()+" \ncc="+mResult2.getCrosscorrelationblue();
        System.out.println("All: mse="+mResult2.getMse()+", psnr="+mResult2.getPsnr()+", cc="+mResult2.getCrosscorrelation());
        System.out.println("Red: mse="+mResult2.getMsered()+", psnr="+mResult2.getPsnrred()+", cc="+mResult2.getCrosscorrelationred());
        System.out.println("Green: mse="+mResult2.getMsegreen()+", psnr="+mResult2.getPsnrgreen()+", cc="+mResult2.getCrosscorrelationgreen());
        System.out.println("Blue: mse="+mResult2.getMseblue()+", psnr="+mResult2.getPsnrblue()+", cc="+mResult2.getCrosscorrelationblue());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPanel = new javax.swing.JTabbedPane();
        ConvertPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        typeComboBox1 = new javax.swing.JComboBox();
        createButton1 = new javax.swing.JButton();
        saveButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        imageLabel1 = new javax.swing.JLabel();
        showButton1 = new javax.swing.JButton();
        checkPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        typeComboBox21 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        showButton21 = new javax.swing.JButton();
        saveButton2 = new javax.swing.JButton();
        createButton21 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        imageLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        typeComboBox22 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        createButton22 = new javax.swing.JButton();
        Showbutton22 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTestLabel2 = new javax.swing.JTextArea();
        comparePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        typeComboBox31 = new javax.swing.JComboBox();
        createButton31 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        imageLabel31 = new javax.swing.JLabel();
        showButton31 = new javax.swing.JButton();
        saveButton31 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        resultArea31 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        typeComboBox32 = new javax.swing.JComboBox();
        createButton32 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        imageLabel32 = new javax.swing.JLabel();
        showButton32 = new javax.swing.JButton();
        saveButton32 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        resultArea32 = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        typeComboBox33 = new javax.swing.JComboBox();
        createButton33 = new javax.swing.JButton();
        showButton33 = new javax.swing.JButton();
        saveButton33 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        imageLabel33 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        resultArea33 = new javax.swing.JTextArea();
        createAllButton3 = new javax.swing.JButton();
        LoadButton3 = new javax.swing.JButton();
        path3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ratioText = new javax.swing.JTextField();
        LoadButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sourceImageLabel = new javax.swing.JLabel();
        showSourceButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        powerInput = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Resizer");
        setResizable(false);

        TabPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ConvertPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Algorithm :");

        typeComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pixel Replication", "Bilinear", "Gradient (Polynomial)" }));

        createButton1.setText("Create");
        createButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButton1ActionPerformed(evt);
            }
        });

        saveButton1.setText("Save");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(imageLabel1);

        showButton1.setText("Show");
        showButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConvertPanelLayout = new javax.swing.GroupLayout(ConvertPanel);
        ConvertPanel.setLayout(ConvertPanelLayout);
        ConvertPanelLayout.setHorizontalGroup(
            ConvertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConvertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConvertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ConvertPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2))
                    .addGroup(ConvertPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeComboBox1, 0, 533, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton1)))
                .addContainerGap())
        );
        ConvertPanelLayout.setVerticalGroup(
            ConvertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConvertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConvertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(typeComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton1)
                    .addComponent(saveButton1)
                    .addComponent(showButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabPanel.addTab("Convert", ConvertPanel);

        checkPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setPreferredSize(new java.awt.Dimension(375, 475));

        jLabel3.setText("Algorithm :");

        typeComboBox21.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pixel Replication", "Bilinear", "Gradient (Polynomial)" }));

        jLabel4.setText("Zoom out :");

        showButton21.setText("Show");
        showButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButton21ActionPerformed(evt);
            }
        });

        saveButton2.setText("Save");
        saveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton2ActionPerformed(evt);
            }
        });

        createButton21.setText("Create");
        createButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeComboBox21, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createButton21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(typeComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showButton21)
                    .addComponent(saveButton2)
                    .addComponent(createButton21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane4.setViewportView(imageLabel2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setPreferredSize(new java.awt.Dimension(375, 475));

        jLabel5.setText("Algorithm :");

        typeComboBox22.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pixel Replication", "Bilinear", "Gradient (Polynomial)" }));

        jLabel6.setText("Zoom in :");

        createButton22.setText("Create");
        createButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButton22ActionPerformed(evt);
            }
        });

        Showbutton22.setText("Show");
        Showbutton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Showbutton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeComboBox22, 0, 568, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Showbutton22))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(typeComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton22)
                    .addComponent(Showbutton22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Result :");

        resultTestLabel2.setColumns(20);
        resultTestLabel2.setRows(19);
        jScrollPane3.setViewportView(resultTestLabel2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout checkPanelLayout = new javax.swing.GroupLayout(checkPanel);
        checkPanel.setLayout(checkPanelLayout);
        checkPanelLayout.setHorizontalGroup(
            checkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        checkPanelLayout.setVerticalGroup(
            checkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TabPanel.addTab("Check", checkPanel);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Algorithm :");

        typeComboBox31.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pixel Replication", "Bilinear", "Gradient (Polynomial)" }));

        createButton31.setText("Create");
        createButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButton31ActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(imageLabel31);

        showButton31.setText("Show");
        showButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButton31ActionPerformed(evt);
            }
        });

        saveButton31.setText("Save");
        saveButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton31ActionPerformed(evt);
            }
        });

        resultArea31.setColumns(20);
        resultArea31.setRows(19);
        jScrollPane8.setViewportView(resultArea31);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeComboBox31, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(createButton31)
                        .addGap(27, 27, 27)
                        .addComponent(showButton31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(saveButton31)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(typeComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton31)
                    .addComponent(showButton31)
                    .addComponent(saveButton31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Algorithm :");

        typeComboBox32.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pixel Replication", "Bilinear", "Gradient (Polynomial)" }));
        typeComboBox32.setSelectedIndex(1);

        createButton32.setText("Create");
        createButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButton32ActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(imageLabel32);

        showButton32.setText("Show");
        showButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButton32ActionPerformed(evt);
            }
        });

        saveButton32.setText("Save");
        saveButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton32ActionPerformed(evt);
            }
        });

        resultArea32.setColumns(20);
        resultArea32.setRows(19);
        jScrollPane9.setViewportView(resultArea32);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeComboBox32, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(createButton32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(showButton32)
                        .addGap(27, 27, 27)
                        .addComponent(saveButton32))
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(typeComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton32)
                    .addComponent(showButton32)
                    .addComponent(saveButton32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setText("Algorithm :");

        typeComboBox33.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pixel Replication", "Bilinear", "Gradient (Polynomial)" }));
        typeComboBox33.setSelectedIndex(2);

        createButton33.setText("Create");
        createButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButton33ActionPerformed(evt);
            }
        });

        showButton33.setText("Show");
        showButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButton33ActionPerformed(evt);
            }
        });

        saveButton33.setText("Save");
        saveButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton33ActionPerformed(evt);
            }
        });

        jScrollPane7.setViewportView(imageLabel33);

        resultArea33.setColumns(20);
        resultArea33.setRows(19);
        jScrollPane10.setViewportView(resultArea33);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeComboBox33, 0, 181, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(createButton33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showButton33)
                        .addGap(26, 26, 26)
                        .addComponent(saveButton33))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(typeComboBox33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton33)
                    .addComponent(showButton33)
                    .addComponent(saveButton33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        createAllButton3.setText("Create All");
        createAllButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAllButton3ActionPerformed(evt);
            }
        });

        LoadButton3.setText("Load Source Compare");
        LoadButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout comparePanelLayout = new javax.swing.GroupLayout(comparePanel);
        comparePanel.setLayout(comparePanelLayout);
        comparePanelLayout.setHorizontalGroup(
            comparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comparePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(comparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(comparePanelLayout.createSequentialGroup()
                        .addComponent(createAllButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LoadButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(comparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comparePanelLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(path3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        comparePanelLayout.setVerticalGroup(
            comparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comparePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(comparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(comparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createAllButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LoadButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(path3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(comparePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabPanel.addTab("Compare", comparePanel);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Ratio :");

        ratioText.setText("1");

        LoadButton.setText("Load");
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(sourceImageLabel);

        showSourceButton.setText("Show");
        showSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSourceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ratioText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LoadButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showSourceButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ratioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadButton)
                    .addComponent(showSourceButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("The power function :");

        powerInput.setText("2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(powerInput)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(powerInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Image Resizer");

        jLabel12.setText("By : d_frEak");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TabPanel))
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(TabPanel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser tChooser = new JFileChooser();
//        FileNameExtensionFilter tFilter = new FileNameExtensionFilter(
//                "Bitmap Image (*.bmp)", "bmp", "BMP");
//        tChooser.setFileFilter(tFilter);
        tChooser.setDialogTitle("Choose Image");
        int tOption = tChooser.showOpenDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            mSourceImage = tChooser.getSelectedFile();
            ImageIcon sourceImage;
            try {
                BufferedImage image = ImageIO.read(mSourceImage);
                Source.Singleton().setImage(image);
                sourceImage = new ImageIcon(Source.Singleton().getImage());
                System.out.println("size : " + image.getWidth() + " x " + image.getHeight());
                sourceImageLabel.setIcon(sourceImage);
            } catch (IOException ex) {
                Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        Color temp = Source.Singleton().getColor(0, 0);
//        System.out.println("red = "+temp.getRed()+" , green = "+temp.getGreen()+" , blue = "+temp.getBlue());
//        System.out.println("alpha = "+temp.getAlpha()+" , rgb = "+temp.getRGB());
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void createButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButton1ActionPerformed
        // TODO add your handling code here:
        convert(typeComboBox1.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel1.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createButton1ActionPerformed

    private void createButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButton22ActionPerformed
        // TODO add your handling code here:
        convert2(typeComboBox22.getSelectedIndex());
        
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            resultTestLabel2.setText(mMessage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createButton22ActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser tChooser = new JFileChooser();
        FileNameExtensionFilter tFilter = new FileNameExtensionFilter(
                "Bitmap Image (*.bmp)", "bmp", "BMP");
        tChooser.setFileFilter(tFilter);
        tChooser.setDialogTitle("Save Image");
        int tOption = tChooser.showSaveDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            File tFile = tChooser.getSelectedFile();
            String tPathFile = tFile.getAbsolutePath();
            if (!tPathFile.endsWith(".bmp")) {
                tPathFile += ".bmp";
            }
            File tOutputFile = new File(tPathFile);
            try {
                ImageIO.write(Helper.iconToBufferedImage(imageLabel1.getIcon()), "bmp", tOutputFile);
            } catch (IOException ex) {
                Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Image saved to " + tOutputFile.getAbsolutePath(),"Save Success",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void showButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButton1ActionPerformed
        // TODO add your handling code here:
        ImageSingle imageSingle=new ImageSingle(typeComboBox1.getSelectedItem().toString(), imageLabel1.getIcon());
        imageSingle.setVisible(true);
    }//GEN-LAST:event_showButton1ActionPerformed

    private void showSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSourceButtonActionPerformed
        // TODO add your handling code here:
        ImageSingle imageSingle=new ImageSingle("Source", sourceImageLabel.getIcon());
        imageSingle.setVisible(true);
    }//GEN-LAST:event_showSourceButtonActionPerformed

    private void showButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButton21ActionPerformed
        // TODO add your handling code here:
        ImageSingle imageSingle=new ImageSingle(typeComboBox21.getSelectedItem().toString(), imageLabel2.getIcon());
        imageSingle.setVisible(true);
    }//GEN-LAST:event_showButton21ActionPerformed

    private void Showbutton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Showbutton22ActionPerformed
        // TODO add your handling code here:
        ImageSingle imageSingle=new ImageSingle(typeComboBox22.getSelectedItem().toString(), new ImageIcon(mResult2.getImage()));
        imageSingle.setVisible(true);
    }//GEN-LAST:event_Showbutton22ActionPerformed

    private void createButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButton31ActionPerformed
        // TODO add your handling code here:
        convert(typeComboBox31.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel31.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(mCompare!=null)
        {
            String temp;
            temp=Helper.stringImageCompare(mResult, mCompare);
            resultArea31.setText(temp);
        }
    }//GEN-LAST:event_createButton31ActionPerformed

    private void createButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButton32ActionPerformed
        // TODO add your handling code here:
        convert(typeComboBox32.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel32.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(mCompare!=null)
        {
            String temp;
            temp=Helper.stringImageCompare(mResult, mCompare);
            resultArea32.setText(temp);
        }
    }//GEN-LAST:event_createButton32ActionPerformed

    private void showButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButton31ActionPerformed
        // TODO add your handling code here:
        ImageSingle imageSingle=new ImageSingle(typeComboBox31.getSelectedItem().toString(), imageLabel31.getIcon());
        imageSingle.setVisible(true);
    }//GEN-LAST:event_showButton31ActionPerformed

    private void showButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButton32ActionPerformed
        // TODO add your handling code here:
        ImageSingle imageSingle=new ImageSingle(typeComboBox32.getSelectedItem().toString(), imageLabel32.getIcon());
        imageSingle.setVisible(true);
    }//GEN-LAST:event_showButton32ActionPerformed

    private void saveButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser tChooser = new JFileChooser();
        FileNameExtensionFilter tFilter = new FileNameExtensionFilter(
                "Bitmap Image (*.bmp)", "bmp", "BMP");
        tChooser.setFileFilter(tFilter);
        tChooser.setDialogTitle("Save Image");
        int tOption = tChooser.showSaveDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            File tFile = tChooser.getSelectedFile();
            String tPathFile = tFile.getAbsolutePath();
            if (!tPathFile.endsWith(".bmp")) {
                tPathFile += ".bmp";
            }
            File tOutputFile = new File(tPathFile);
            try {
                ImageIO.write(Helper.iconToBufferedImage(imageLabel2.getIcon()), "bmp", tOutputFile);
            } catch (IOException ex) {
                Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Image saved to " + tOutputFile.getAbsolutePath(),"Save Success",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveButton2ActionPerformed

    private void saveButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton31ActionPerformed
        // TODO add your handling code here:
        JFileChooser tChooser = new JFileChooser();
        FileNameExtensionFilter tFilter = new FileNameExtensionFilter(
                "Bitmap Image (*.bmp)", "bmp", "BMP");
        tChooser.setFileFilter(tFilter);
        tChooser.setDialogTitle("Save Image");
        int tOption = tChooser.showSaveDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            File tFile = tChooser.getSelectedFile();
            String tPathFile = tFile.getAbsolutePath();
            if (!tPathFile.endsWith(".bmp")) {
                tPathFile += ".bmp";
            }
            File tOutputFile = new File(tPathFile);
            try {
                ImageIO.write(Helper.iconToBufferedImage(imageLabel31.getIcon()), "bmp", tOutputFile);
            } catch (IOException ex) {
                Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Image saved to " + tOutputFile.getAbsolutePath(),"Save Success",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveButton31ActionPerformed

    private void saveButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton32ActionPerformed
        // TODO add your handling code here:
        JFileChooser tChooser = new JFileChooser();
        FileNameExtensionFilter tFilter = new FileNameExtensionFilter(
                "Bitmap Image (*.bmp)", "bmp", "BMP");
        tChooser.setFileFilter(tFilter);
        tChooser.setDialogTitle("Save Image");
        int tOption = tChooser.showSaveDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            File tFile = tChooser.getSelectedFile();
            String tPathFile = tFile.getAbsolutePath();
            if (!tPathFile.endsWith(".bmp")) {
                tPathFile += ".bmp";
            }
            File tOutputFile = new File(tPathFile);
            try {
                ImageIO.write(Helper.iconToBufferedImage(imageLabel32.getIcon()), "bmp", tOutputFile);
            } catch (IOException ex) {
                Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Image saved to " + tOutputFile.getAbsolutePath(),"Save Success",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveButton32ActionPerformed

    private void createButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButton21ActionPerformed
        // TODO add your handling code here:
        convert(typeComboBox21.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel2.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createButton21ActionPerformed

    private void createButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButton33ActionPerformed
        // TODO add your handling code here:
        convert(typeComboBox33.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel33.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(mCompare!=null)
        {
            String temp;
            temp=Helper.stringImageCompare(mResult, mCompare);
            resultArea33.setText(temp);
        }
    }//GEN-LAST:event_createButton33ActionPerformed

    private void showButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButton33ActionPerformed
        // TODO add your handling code here:
        ImageSingle imageSingle=new ImageSingle(typeComboBox33.getSelectedItem().toString(), imageLabel33.getIcon());
        imageSingle.setVisible(true);
    }//GEN-LAST:event_showButton33ActionPerformed

    private void saveButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton33ActionPerformed
        // TODO add your handling code here:
        JFileChooser tChooser = new JFileChooser();
        FileNameExtensionFilter tFilter = new FileNameExtensionFilter(
                "Bitmap Image (*.bmp)", "bmp", "BMP");
        tChooser.setFileFilter(tFilter);
        tChooser.setDialogTitle("Save Image");
        int tOption = tChooser.showSaveDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            File tFile = tChooser.getSelectedFile();
            String tPathFile = tFile.getAbsolutePath();
            if (!tPathFile.endsWith(".bmp")) {
                tPathFile += ".bmp";
            }
            File tOutputFile = new File(tPathFile);
            try {
                ImageIO.write(Helper.iconToBufferedImage(imageLabel33.getIcon()), "bmp", tOutputFile);
            } catch (IOException ex) {
                Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Image saved to " + tOutputFile.getAbsolutePath(),"Save Success",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveButton33ActionPerformed

    private void createAllButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAllButton3ActionPerformed
        // TODO add your handling code here:
        convert(typeComboBox31.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel31.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
        convert(typeComboBox32.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel32.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
        convert(typeComboBox33.getSelectedIndex());
        if(mResult!=null)
        {
            ImageIcon resultimage=new ImageIcon(mResult);
            imageLabel33.setIcon(resultimage);
            JOptionPane.showMessageDialog(this, "Done in converting", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error in converting", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(mCompare!=null)
        {
            String temp;
            temp=Helper.stringImageCompare(Helper.iconToBufferedImage(imageLabel31.getIcon()), mCompare);
            resultArea31.setText(temp);
            temp=Helper.stringImageCompare(Helper.iconToBufferedImage(imageLabel32.getIcon()), mCompare);
            resultArea32.setText(temp);
            temp=Helper.stringImageCompare(Helper.iconToBufferedImage(imageLabel33.getIcon()), mCompare);
            resultArea33.setText(temp);
        }
    }//GEN-LAST:event_createAllButton3ActionPerformed

    private void LoadButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButton3ActionPerformed
        // TODO add your handling code here:
        
        JFileChooser tChooser = new JFileChooser();
        tChooser.setDialogTitle("Choose Image");
        int tOption = tChooser.showOpenDialog(this);
        if (tOption == JFileChooser.APPROVE_OPTION) {
            mSourceImage = tChooser.getSelectedFile();
            ImageIcon sourceImage;
            try {
                mCompare = ImageIO.read(mSourceImage);
                path3.setText(mSourceImage.getPath());
            } catch (IOException ex) {
                Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_LoadButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Image().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ConvertPanel;
    private javax.swing.JButton LoadButton;
    private javax.swing.JButton LoadButton3;
    private javax.swing.JButton Showbutton22;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JPanel checkPanel;
    private javax.swing.JPanel comparePanel;
    private javax.swing.JButton createAllButton3;
    private javax.swing.JButton createButton1;
    private javax.swing.JButton createButton21;
    private javax.swing.JButton createButton22;
    private javax.swing.JButton createButton31;
    private javax.swing.JButton createButton32;
    private javax.swing.JButton createButton33;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JLabel imageLabel2;
    private javax.swing.JLabel imageLabel31;
    private javax.swing.JLabel imageLabel32;
    private javax.swing.JLabel imageLabel33;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel path3;
    private javax.swing.JTextField powerInput;
    private javax.swing.JTextField ratioText;
    private javax.swing.JTextArea resultArea31;
    private javax.swing.JTextArea resultArea32;
    private javax.swing.JTextArea resultArea33;
    private javax.swing.JTextArea resultTestLabel2;
    private javax.swing.JButton saveButton1;
    private javax.swing.JButton saveButton2;
    private javax.swing.JButton saveButton31;
    private javax.swing.JButton saveButton32;
    private javax.swing.JButton saveButton33;
    private javax.swing.JButton showButton1;
    private javax.swing.JButton showButton21;
    private javax.swing.JButton showButton31;
    private javax.swing.JButton showButton32;
    private javax.swing.JButton showButton33;
    private javax.swing.JButton showSourceButton;
    private javax.swing.JLabel sourceImageLabel;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox typeComboBox1;
    private javax.swing.JComboBox typeComboBox21;
    private javax.swing.JComboBox typeComboBox22;
    private javax.swing.JComboBox typeComboBox31;
    private javax.swing.JComboBox typeComboBox32;
    private javax.swing.JComboBox typeComboBox33;
    // End of variables declaration//GEN-END:variables
}
