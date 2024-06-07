package iTrack;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon appleIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\apple-dash.png");
	ImageIcon homeWhiteIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\home-white.png");
	ImageIcon homeBlackIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\home-black.png");
	ImageIcon storeWhiteIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\store-white.png");
	ImageIcon storeBlackIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\store-black.png");
	ImageIcon purchaseWhiteIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\purchase-white.png");
	ImageIcon purchaseBlackIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\purchase-black.png");
	ImageIcon segmentWhiteIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\segment-white.png");
	ImageIcon segmentBlackIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\segment-black.png");
	ImageIcon demoWhiteIcom = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\demo-white.png");
	ImageIcon demoBlackIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\demo-black.png");
	ImageIcon geoWhiteIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\geo-white.png");
	ImageIcon geoBlackIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\geo-black.png");
	ImageIcon transactWhiteIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\transaction-white.png");
	ImageIcon transactBlackIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\transaction-black.png");
	ImageIcon accountIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\account.png");
	ImageIcon exitIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\exit.png");
	
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panelHome, panelStores, panelPurchaseHistory, panelSegmentation, panelDemographics, panelGeographics, panelTransactionHistory;
	private JLabel lblSales, lblCustomer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDashboard frame = new MainDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDashboardMenu = new JPanel();
		panelDashboardMenu.setBounds(0, 0, 198, 764);
		panelDashboardMenu.setBackground(new Color(0, 0, 0));
		contentPane.add(panelDashboardMenu);
		panelDashboardMenu.setLayout(null);
		
		JLabel lblAppName = new JLabel("iTrack");
		lblAppName.setForeground(new Color(255, 255, 255));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppName.setFont(new Font("Hardner", Font.PLAIN, 35));
		lblAppName.setBounds(72, 10, 104, 72);
		panelDashboardMenu.add(lblAppName);
		
		JLabel lblAppleLogo = new JLabel("");
		lblAppleLogo.setIcon(appleIcon);
		lblAppleLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppleLogo.setForeground(new Color(255, 255, 255));
		lblAppleLogo.setBounds(15, 10, 68, 72);
		panelDashboardMenu.add(lblAppleLogo);
		
		JPanel panelHomeMenu = new JPanel();
		panelHomeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelHome);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelHomeMenu.setBounds(0, 92, 198, 35);
		panelDashboardMenu.add(panelHomeMenu);
		panelHomeMenu.setLayout(null);
		
		JLabel lblDashHome = new JLabel("Home");
		lblDashHome.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashHome.setBounds(53, 0, 145, 38);
		panelHomeMenu.add(lblDashHome);
		
		JLabel lblHomeLogo = new JLabel("");
		lblHomeLogo.setIcon(homeBlackIcon);
		lblHomeLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeLogo.setBounds(5, 0, 35, 35);
		panelHomeMenu.add(lblHomeLogo);
		
		JPanel panelStoreMenu = new JPanel();
		panelStoreMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelStores);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelStoreMenu.setBackground(new Color(0, 0, 0));
		panelStoreMenu.setLayout(null);
		panelStoreMenu.setBounds(0, 127, 198, 35);
		panelDashboardMenu.add(panelStoreMenu);
		
		JLabel lblDashStore = new JLabel("Stores");
		lblDashStore.setForeground(new Color(255, 255, 255));
		lblDashStore.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashStore.setBounds(53, 0, 145, 38);
		panelStoreMenu.add(lblDashStore);
		
		JLabel lblStoreLogo = new JLabel("");
		lblStoreLogo.setIcon(storeWhiteIcon);
		lblStoreLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreLogo.setBounds(5, 0, 35, 35);
		panelStoreMenu.add(lblStoreLogo);
		
		JPanel panelPurchaseMenu = new JPanel();
		panelPurchaseMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPurchaseHistory);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelPurchaseMenu.setBackground(new Color(0, 0, 0));
		panelPurchaseMenu.setLayout(null);
		panelPurchaseMenu.setBounds(0, 162, 198, 35);
		panelDashboardMenu.add(panelPurchaseMenu);
		
		JLabel lblPurchaseHistory = new JLabel("Purchase History");
		lblPurchaseHistory.setForeground(new Color(255, 255, 255));
		lblPurchaseHistory.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblPurchaseHistory.setBounds(53, 0, 145, 38);
		panelPurchaseMenu.add(lblPurchaseHistory);
		
		JLabel lblPurchaseLogo = new JLabel("");
		lblPurchaseLogo.setIcon(purchaseWhiteIcon);
		lblPurchaseLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseLogo.setBounds(5, 0, 35, 35);
		panelPurchaseMenu.add(lblPurchaseLogo);
		
		JPanel panelSegmentMenu = new JPanel();
		panelSegmentMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelSegmentation);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelSegmentMenu.setBackground(new Color(0, 0, 0));
		panelSegmentMenu.setLayout(null);
		panelSegmentMenu.setBounds(0, 197, 198, 35);
		panelDashboardMenu.add(panelSegmentMenu);
		
		JLabel lblDashSegment = new JLabel("Segmentation");
		lblDashSegment.setForeground(new Color(255, 255, 255));
		lblDashSegment.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashSegment.setBounds(53, 0, 145, 38);
		panelSegmentMenu.add(lblDashSegment);
		
		JLabel lblSegmentLogo = new JLabel("");
		lblSegmentLogo.setIcon(segmentWhiteIcon);
		lblSegmentLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegmentLogo.setBounds(5, 0, 35, 35);
		panelSegmentMenu.add(lblSegmentLogo);
		
		JPanel panelDemographicsMenu = new JPanel();
		panelDemographicsMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelDemographics);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelDemographicsMenu.setBackground(new Color(0, 0, 0));
		panelDemographicsMenu.setLayout(null);
		panelDemographicsMenu.setBounds(0, 232, 198, 35);
		panelDashboardMenu.add(panelDemographicsMenu);
		
		JLabel lblDashDemographics = new JLabel("Demographics");
		lblDashDemographics.setForeground(new Color(255, 255, 255));
		lblDashDemographics.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashDemographics.setBounds(53, 0, 145, 38);
		panelDemographicsMenu.add(lblDashDemographics);
		
		JLabel lblDemographicsLogo = new JLabel("");
		lblDemographicsLogo.setIcon(demoWhiteIcom);
		lblDemographicsLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDemographicsLogo.setBounds(5, 0, 35, 35);
		panelDemographicsMenu.add(lblDemographicsLogo);
		
		JPanel panelGeographicMenu = new JPanel();
		panelGeographicMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelGeographics);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelGeographicMenu.setBackground(new Color(0, 0, 0));
		panelGeographicMenu.setLayout(null);
		panelGeographicMenu.setBounds(0, 267, 198, 35);
		panelDashboardMenu.add(panelGeographicMenu);
		
		JLabel lblDashGeographic = new JLabel("Geographic");
		lblDashGeographic.setForeground(new Color(255, 255, 255));
		lblDashGeographic.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashGeographic.setBounds(53, 0, 145, 38);
		panelGeographicMenu.add(lblDashGeographic);
		
		JLabel lblGeographicLogo = new JLabel("");
		lblGeographicLogo.setIcon(geoWhiteIcon);
		lblGeographicLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeographicLogo.setBounds(5, 0, 35, 35);
		panelGeographicMenu.add(lblGeographicLogo);
		
		JPanel panelTransactionMenu = new JPanel();
		panelTransactionMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelTransactionHistory);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelTransactionMenu.setBackground(new Color(0, 0, 0));
		panelTransactionMenu.setLayout(null);
		panelTransactionMenu.setBounds(0, 302, 198, 35);
		panelDashboardMenu.add(panelTransactionMenu);
		
		JLabel lblDashTransaction = new JLabel("Transaction History");
		lblDashTransaction.setForeground(new Color(255, 255, 255));
		lblDashTransaction.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashTransaction.setBounds(53, 0, 145, 38);
		panelTransactionMenu.add(lblDashTransaction);
		
		JLabel lblTransactionLogo = new JLabel("");
		lblTransactionLogo.setIcon(transactWhiteIcon);
		lblTransactionLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionLogo.setBounds(5, 0, 35, 35);
		panelTransactionMenu.add(lblTransactionLogo);
		
		ImageIcon logOutIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\exit.png");
		JLabel lblLogOut = new JLabel("New label");
		lblLogOut.setIcon(logOutIcon);
		lblLogOut.setBounds(0, 695, 50, 40);
		panelDashboardMenu.add(lblLogOut);
		
		ImageIcon accountIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\account.png");
		JLabel lblAccount = new JLabel("New label");
		lblAccount.setIcon(accountIcon);
		lblAccount.setBounds(130, 690, 50, 40);
		panelDashboardMenu.add(lblAccount);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(198, 0, 1153, 755);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelHome = new JPanel();
		layeredPane.add(panelHome, "name_1237592797291700");
		panelHome.setLayout(null);
		
		JLabel lblDashboardTitle = new JLabel("Dashboard");
		lblDashboardTitle.setFont(new Font("Poppins", Font.BOLD, 40));
		lblDashboardTitle.setBounds(35, 36, 263, 56);
		panelHome.add(lblDashboardTitle);
		
		lblSales = new JLabel("Sales");
		lblSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				underlineBorder(lblSales, lblCustomer);
			}
		});
		lblSales.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblSales.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblSales.setBounds(308, 58, 80, 25);
		panelHome.add(lblSales);
		
		lblCustomer = new JLabel("Customer");
		lblCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				underlineBorder(lblCustomer, lblSales);
			}
		});
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblCustomer.setBounds(398, 58, 100, 25);
		panelHome.add(lblCustomer);
		
		panelStores = new JPanel();
		layeredPane.add(panelStores, "name_1237607726469500");
		panelStores.setLayout(null);
		
		JLabel lblStoreTitle = new JLabel("Stores");
		lblStoreTitle.setFont(new Font("Poppins", Font.BOLD, 40));
		lblStoreTitle.setBounds(35, 36, 263, 56);
		panelStores.add(lblStoreTitle);
		
		panelPurchaseHistory = new JPanel();
		layeredPane.add(panelPurchaseHistory, "name_1237611265977400");
		panelPurchaseHistory.setLayout(null);
		
		JLabel lblStoresTitle = new JLabel("Stores");
		lblStoresTitle.setFont(new Font("Poppins", Font.BOLD, 40));
		lblStoresTitle.setBounds(35, 36, 263, 56);
		panelPurchaseHistory.add(lblStoresTitle);
		
		panelSegmentation = new JPanel();
		layeredPane.add(panelSegmentation, "name_1237637193320800");
		panelSegmentation.setLayout(null);
		
		JLabel lblCustomerSegment1 = new JLabel("Customer Segmentation");
		lblCustomerSegment1.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment1.setBounds(35, 36, 609, 56);
		panelSegmentation.add(lblCustomerSegment1);
		
		panelDemographics = new JPanel();
		layeredPane.add(panelDemographics, "name_1237649696174600");
		panelDemographics.setLayout(null);
		
		JLabel lblCustomerSegment2 = new JLabel("Customer Segmentation");
		lblCustomerSegment2.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment2.setBounds(35, 36, 609, 56);
		panelDemographics.add(lblCustomerSegment2);
		
		panelGeographics = new JPanel();
		layeredPane.add(panelGeographics, "name_1237653177687600");
		panelGeographics.setLayout(null);
		
		JLabel lblCustomerSegment3 = new JLabel("Customer Segmentation");
		lblCustomerSegment3.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment3.setBounds(35, 36, 609, 56);
		panelGeographics.add(lblCustomerSegment3);
		
		panelTransactionHistory = new JPanel();
		layeredPane.add(panelTransactionHistory, "name_1237656709540000");
		panelTransactionHistory.setLayout(null);
		
		JLabel lblCustomerSegment4 = new JLabel("Customer Segmentation");
		lblCustomerSegment4.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment4.setBounds(35, 36, 609, 56);
		panelTransactionHistory.add(lblCustomerSegment4);
	}
	
	public void underlineBorder(JLabel lined, JLabel unlined) {
		lined.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
		unlined.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
	}
	
	public void lightMenuColor() {
		
	}
}
