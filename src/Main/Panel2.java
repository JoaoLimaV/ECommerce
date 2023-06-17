package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Strategy.PaymentCredit;
import Strategy.PaymentDebit;

public class Panel2 {
	
	public static void initInterface(List<Product> listProducts, List<Vendor> listVendors) {
    	
    	Color backgroundBlack = new Color(0, 0, 0, 75);
    	Color backgroundRed   = new Color(255, 0, 0, 150);
        int horizontalSpacing = 10;
        
        JFrame window = new JFrame("E-Commerce");
        window.setSize(700, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        
        // ----------------------------------------------------------------------------- // 
        
        JPanel divLogo = new JPanel();
        divLogo.setPreferredSize(new Dimension(700, 50));
        divLogo.setLayout(new BoxLayout(divLogo, BoxLayout.X_AXIS));
        divLogo.setBackground(backgroundBlack);

        ImageIcon imageIcon = new ImageIcon("src/img/logo.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        
        JLabel nameProject = new JLabel("E-Commerce");
        
        divLogo.add(Box.createHorizontalGlue());

        divLogo.add(imageLabel);
        divLogo.add(Box.createHorizontalStrut(horizontalSpacing));

        divLogo.add(nameProject);
        
        divLogo.add(Box.createHorizontalGlue());

        imageLabel.setAlignmentX(JButton.CENTER_ALIGNMENT);
        nameProject.setAlignmentX(JButton.CENTER_ALIGNMENT);

        // ----------------------------------------------------------------------------- // 
        
        // ----------------------------------------------------------------------------- //     
        
        JPanel divContent = new JPanel();
        divContent.setPreferredSize(new Dimension(600, 610));
               
        for (int i = 0; i < listProducts.size(); i++) {
            Product product = listProducts.get(i);
            
            JPanel productPanel = Panel2.createProduct(product);
            		
            JButton buyProduct = new JButton("Comprar");
            
            buyProduct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Panel2.painelPayment(product);
                }
            });
            
            productPanel.add(buyProduct);
            
            divContent.add(productPanel);
            divContent.add(Box.createVerticalStrut(horizontalSpacing));
            divContent.add(Box.createHorizontalStrut(horizontalSpacing));
        }
        
        JScrollPane divScrollContent = new JScrollPane(divContent);
        divScrollContent.getVerticalScrollBar().setUnitIncrement(25);
              
        // ----------------------------------------------------------------------------- // 
        
        // ----------------------------------------------------------------------------- // 
        JPanel divButtons = new JPanel();
        divButtons.setPreferredSize(new Dimension(700, 50));
        divButtons.setLayout(new BoxLayout(divButtons, BoxLayout.X_AXIS));
        divButtons.setBackground(backgroundBlack);
        
        JButton botao3 = new JButton("Botão 3");
        JButton botao4 = new JButton("Botão 4");
        JButton botao5 = new JButton("Sair");
        botao5.setBackground(backgroundRed);

        
        divButtons.add(Box.createHorizontalGlue()); 
    
        divButtons.add(botao3);
        divButtons.add(Box.createHorizontalStrut(horizontalSpacing));
        
        divButtons.add(botao4);
        divButtons.add(Box.createHorizontalStrut(horizontalSpacing));
        
        divButtons.add(botao5);
        
        divButtons.add(Box.createHorizontalGlue());
        
        botao3.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botao4.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botao5.setAlignmentX(JButton.CENTER_ALIGNMENT);


        // ----------------------------------------------------------------------------- // 
        
        window.add(divButtons, BorderLayout.SOUTH);
        window.add(divScrollContent, BorderLayout.CENTER);
        window.add(divLogo, BorderLayout.NORTH);
        window.setVisible(true);
    }
	
	private static void painelPayment(Product product) {
		JFrame window = new JFrame("Pagamento");
		Sale sale = new Sale();

		window.setSize(600, 280);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
        window.setLocationRelativeTo(null);
        
        JPanel productPanel = createProduct(product);
        
		JLabel lblQuantity = new JLabel("Quantidade:");
		JTextField txtQuantity = new JTextField(10);

		JRadioButton rbtnCredit = new JRadioButton("Crédito");
		JRadioButton rbtnDebit = new JRadioButton("Débito");
		
		JButton btnSubmit = new JButton("Confirmar");
		
	    btnSubmit.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		String quantityStr = txtQuantity.getText();
	    	    int quantityInt = Integer.parseInt(quantityStr);

	    	    String paymentMethod = rbtnCredit.isSelected() ? "Crédito" : "Débito";
	    		
				Vendor vendor = (product.getVendor());
				sale.setPaymentType( ( paymentMethod == "Crédito" ) ? new PaymentCredit() : new PaymentDebit() );
				sale.setProduct(product);
				sale.setVendor(vendor);
				sale.setQuant(quantityInt);
				sale.calculeSale();
//				subject.selledProduct(sale);

		        window.setVisible(false);
				JOptionPane.showMessageDialog(btnSubmit, "Produto Comprado com Sucesso!!!");		
	    	}
	    });
	        
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(rbtnCredit);
        paymentGroup.add(rbtnDebit);
        
        window.add(productPanel);
        window.add(lblQuantity);
        window.add(txtQuantity);
        window.add(rbtnCredit);
        window.add(rbtnDebit);
        window.add(btnSubmit);

        
        window.setVisible(true);
	}
	
	private static JPanel createProduct(Product product) {
		Color backgroundBlue  = new Color(131, 111, 255, 150);
        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0, 75), 2);
        
		JPanel productPanel = new JPanel();

		productPanel.setPreferredSize(new Dimension(170, 195));
		productPanel.setBorder(border);
		productPanel.setBackground(backgroundBlue);
        
        ImageIcon productIMG = new ImageIcon("src/img/product"+ product.getId() + ".png");
        Image imageOBJ = productIMG.getImage();
        Image xyImage = imageOBJ.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(xyImage);
        JLabel Image = new JLabel(Icon);
        Image.setPreferredSize(new Dimension(160, 70));
        Image.setBorder(border);
        
        Dimension labelSize = new Dimension(150, 15);

        JLabel name = new JLabel(product.getName());
        name.setPreferredSize(labelSize);
        
        JLabel price = new JLabel("Preço: "       + product.getPrice());
        price.setPreferredSize(labelSize);

        JLabel stock = new JLabel("Dispobível: "  + product.getStock() );
        stock.setPreferredSize(labelSize);

        JLabel vendor = new JLabel("Fornecedor: " + product.getVendor().getName());
        vendor.setPreferredSize(labelSize);
                   
        productPanel.add(Image);
        productPanel.add(name);
        productPanel.add(price);
        productPanel.add(stock);
        productPanel.add(vendor);
        
        return productPanel;
	}
}
