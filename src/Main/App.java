package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
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
import javax.swing.border.EmptyBorder;

import Observer.SubjectProduct;
import Proxy.ProxyConnection;
import Strategy.PaymentCredit;
import Strategy.PaymentDebit;


public class App {
	
	private static SubjectProduct subject = new SubjectProduct();
	private static List<Vendor>  allVendors;
	private static List<Product>  allProducts;
	
	public static void main(String[] args) throws IOException {
		
		ProxyConnection.getConnection();
		
		VendorDAO vendorDAO = new VendorDAO();
		allVendors = vendorDAO.findAll();
		
		ProductDAO productDAO = new ProductDAO();
		allProducts = productDAO.findAll();
		
		subject = new SubjectProduct();
		allVendors.forEach(e -> subject.attach(e));
			
		Color backgroundBlack = new Color(0, 0, 0, 75);
    	Color backgroundRed   = new Color(255, 0, 0, 150);
        int horizontalSpacing = 10;
        
        // ----------------------------------------------------------------------------- // 
        
        JFrame window = new JFrame("E-Commerce");
        window.setSize(700, 580);
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
        int aux = 0;
        
        for (int i = 0; i < allProducts.size(); i++) {
        	
        	if(i % 3 == 0) {
        		aux++;
        	}
        	
            Product product = allProducts.get(i);
            JPanel productPanel = createProduct(product);
            		
            JButton buyProduct = new JButton("Comprar");
            
            buyProduct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    painelPayment(product);
                }
            });
            
            productPanel.add(buyProduct);
            
            divContent.add(productPanel);
            divContent.add(Box.createVerticalStrut(horizontalSpacing));
            divContent.add(Box.createHorizontalStrut(horizontalSpacing));
        }
        
        int yDiv = aux * 200;
        divContent.setPreferredSize(new Dimension(600, yDiv));
        
        JScrollPane divScrollContent = new JScrollPane(divContent);
        divScrollContent.getVerticalScrollBar().setUnitIncrement(25);
              
        // ----------------------------------------------------------------------------- // 
        
        // ----------------------------------------------------------------------------- // 
        JPanel divButtons = new JPanel();
        divButtons.setPreferredSize(new Dimension(700, 50));
        divButtons.setLayout(new BoxLayout(divButtons, BoxLayout.X_AXIS));
        divButtons.setBackground(backgroundBlack);
        
        JButton btnShowSales = new JButton("Mostrar Vendas");
        btnShowSales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	painelShowSales();
            }
        });
        
        JButton botao4 = new JButton("Botão 4");
        
        JButton btnClose = new JButton("Sair");
        btnClose.setBackground(backgroundRed);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
        
        divButtons.add(Box.createHorizontalGlue()); 
    
        divButtons.add(btnShowSales);
        divButtons.add(Box.createHorizontalStrut(horizontalSpacing));
        
        divButtons.add(botao4);
        divButtons.add(Box.createHorizontalStrut(horizontalSpacing));
        
        divButtons.add(btnClose);
        
        divButtons.add(Box.createHorizontalGlue());
        
        btnShowSales.setAlignmentX(JButton.CENTER_ALIGNMENT);
        botao4.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btnClose.setAlignmentX(JButton.CENTER_ALIGNMENT);


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
				
				subject.selledProduct(sale);

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
	
	private static void painelShowSales() {
		
	     JFrame window = new JFrame("Vendas");
	     window.setSize(500, 350);
	     window.setResizable(false);
	     window.setLocationRelativeTo(null);
	     
    	 JPanel divTitle = new JPanel();
    	 divTitle.setPreferredSize(new Dimension(500, 20));
    	 JLabel title = new JLabel("Vendas Por Vendedor");
    	 divTitle.add(title);
    	 
    	 JPanel divSale = new JPanel();
     	 divSale.setLayout(new BoxLayout(divSale, BoxLayout.Y_AXIS));
     	 divSale.setPreferredSize(new Dimension(500, 310));
    	 
    	 JPanel divFooter = new JPanel();
    	 divFooter.setPreferredSize(new Dimension(500, 20));
    	 
    	 JButton btnOut = new JButton("Sair");
 		
    	 btnOut.addActionListener(new ActionListener() {
 	    	@Override
 	    	public void actionPerformed(ActionEvent e) {

 	    	}
 	     });
    	 
    	 divFooter.add(btnOut);
    	 
	     for (int i = 0; i < allVendors.size(); i++) {
	         Vendor vendor = allVendors.get(i);

	    	 JPanel vendorPanel = new JPanel();
	    	 vendorPanel.setSize(450, 80);
	    	 vendorPanel.setLayout(new GridLayout(0, 1));
	    	 vendorPanel.setBackground(new Color(0,0,0,75));

	    	 JLabel nameVendor = new JLabel(vendor.getName());
	    	 vendorPanel.add(nameVendor);

	    	 for (int x = 0; x < vendor.sales.size(); x++) {
		    	 Sale sale = vendor.sales.get(x);
	    		 JPanel salePanel = createSale(sale);
	    		 salePanel.setBorder(new EmptyBorder(new Insets(10, 10, 20, 10)));
	    		 vendorPanel.add(salePanel);    
	    	 }	 
	    	 
	    	 divSale.add(vendorPanel);
	    	 divSale.add(Box.createVerticalStrut(10));
	     }
	     
	     JScrollPane divScrollSale = new JScrollPane(divSale);
	     
	     window.add(divTitle, BorderLayout.NORTH);
	     window.add(divScrollSale, BorderLayout.CENTER);
	     window.add(divFooter, BorderLayout.SOUTH);

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
        Image.setPreferredSize(new Dimension(80, 80));
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
	
	private static JPanel createSale(Sale sale) {
		
	     	Border border = BorderFactory.createLineBorder(new Color(0, 0, 0, 75), 2);
	     	Color backgroundBlue  = new Color(131, 144, 255, 150);
	 
			JPanel salePanel = new JPanel();
			salePanel.setPreferredSize(new Dimension(150, 85));
			salePanel.setBorder(border);
			salePanel.setBackground(backgroundBlue);
	        
	        ImageIcon productIMG = new ImageIcon("src/img/saleIcon.png");
	        Image imageOBJ = productIMG.getImage();
	        Image xyImage = imageOBJ.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	        ImageIcon Icon = new ImageIcon(xyImage);
	        JLabel Image = new JLabel(Icon);
	        Image.setPreferredSize(new Dimension(70, 70));
	        Image.setBorder(border);

	        JPanel infoSalePanel = new JPanel();
	        infoSalePanel.setLayout(new GridLayout(0, 1));
	        infoSalePanel.setBackground(new Color(0,0,0,0));
	        infoSalePanel.setBorder(new EmptyBorder(new Insets(0, 10, 0, 0)));
	        infoSalePanel.setPreferredSize(null);

	        Dimension labelSize = new Dimension(300, 15);
	        
	        JLabel saleId = new JLabel("Id da Venda: "+ String.valueOf(sale.getSaleId()));
	        saleId.setPreferredSize(labelSize);
	        
	        JLabel nameProduct = new JLabel("Nome do Produto: " + sale.getProduct().getName());
	        nameProduct.setPreferredSize(labelSize);

	        JLabel quantity = new JLabel("Quantidade: " + sale.getQuant() );
	        quantity.setPreferredSize(labelSize);

	        JLabel paymenyType = new JLabel("Método de Pagamento: " + sale.getPaymentType().namePaymentMethod());
	        paymenyType.setPreferredSize(labelSize);

	        DecimalFormat df = new DecimalFormat("#.##");
	        JLabel priceSale = new JLabel("Preço Total: " + df.format(sale.getPriceSale()));
	        priceSale.setPreferredSize(labelSize);
	                   
	        infoSalePanel.add(saleId);
	        infoSalePanel.add(nameProduct);
	        infoSalePanel.add(quantity);
	        infoSalePanel.add(paymenyType);
	        infoSalePanel.add(priceSale);
	        
	        salePanel.add(Image);
	        salePanel.add(infoSalePanel);
	        
	        return salePanel;
	}
}
