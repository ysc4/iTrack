package iTrack;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

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
	ImageIcon demoWhiteIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\demo-white.png");
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
	private JPanel panelHomeMenu, panelStoreMenu, panelPurchaseMenu, panelSegmentMenu, panelDemographicsMenu, panelGeographicMenu, panelTransactionMenu;
	private JLabel lblDashHome, lblDashStore, lblPurchaseHistory, lblDashSegment, lblDashDemographics, lblDashGeographic, lblDashTransaction;
	private JLabel lblHomeLogo, lblStoreLogo, lblPurchaseLogo, lblSegmentLogo, lblDemographicsLogo, lblGeographicLogo, lblTransactionLogo;
	private JLayeredPane layeredPaneHomePage;
	private JPanel panelSales;
	private JPanel panelCustomer;
	private JPanel panelTotalSales;
	private JPanel panelTotalProfit;
	private JPanel panelProfitMargin;
	private JPanel panelSalesAndProfitTrend;
	private JPanel panelTopTenProducts;
	private JPanel panelSalesVolumePerCountry;
	private JPanel panelTopTenStoresBySales;
	private JLabel lblSalesPercentIncrease;
	private JLabel lblTotalProfit;
	private JLabel lblProfitMargin;
	private JLabel lblTotalSalesAmount_1;
	private JLabel lblTotalSalesAmount_2;
	private JLabel lblSalesPercentIncrease_1;
	private JLabel lblSalesPercentIncrease_2;
	private JLabel lblSalesAndProfitTrend;
	private JLabel lblTopTenProductsBySales;
	private JLabel lblSalesVolumeByCountry;
	private JLabel lblTopTenStoresBySales;
	private JLabel lblExport;
	private JLabel lblRefresh;
	private JPanel panelTotalActiveCustomers;
	private JLabel lblTotalActive;
	private JLabel lblNumberOfCustomers;
	private JLabel lblCustomerGrowthPercentage;
	private JLabel lblActiveCustomers;
	private JPanel panelTotalActiveCustomers_1;
	private JLabel lblTotalNew;
	private JLabel lblNumberOfCustomers_1;
	private JLabel lblCustomerGrowthPercentage_1;
	private JLabel lblActiveCustomers_1;
	private JPanel panelTotalActiveCustomers_2;
	private JLabel lblCustomerGrowth;
	private JLabel lblNumberOfCustomers_2;
	private JLabel lblCustomerGrowthPercentage_2;
	private JLabel lblActiveCustomers_2;
	private JPanel panelCustomerTrend;
	private JLabel lblNewVsCurrent;
	private JPanel panelCustomerSegmentationGraphs;
	private JLabel lblCustomerSegmentation;
	private JPanel panelCustomerVolumeByCountry;
	private JLabel lblCustomerVolumeByCountry;
	private JLayeredPane layeredPaneStores;
	private JPanel panelStoreSummary;
	private JPanel panelStoresSales;
	private JPanel panelStoreInformation;
	private JLabel lblStoreInformation;
	private JPanel panelTopStoresBySales;
	private JLabel lblTopStoresBySales;
	private JLabel lblRefreshSales;
	private JPanel panelPurchaseHistoryTable;
	private JLabel lblPurchaseHistoryTable;
	private JLabel lblStoresBySales;
	private JPanel panelStoresSales_1;
	private JLabel lblPurchaseHistorySummary;
	private JLabel lblRefreshPurchase;
	private JPanel panelCustomerSegmentation;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblRefreshCS;
	private JLabel lblExportCS;
	private JTable tableGeographic;
	private JTable tableDemoSegmentation;
	private JScrollPane scrollPaneDemoSegmentation;
	private JTable table_1;
	private JPanel panel;
	private JPanel panelGeographicSegmentation;
	private JLabel lblGeographicSegmentation;
	private JTable tableGeographicSegmentation;
	private JScrollPane scrollPaneGeographicSegmentation;
	private JLabel lblRefreshDS;
	private JLabel lblRefreshGS;
	private JComboBox cmbAscDesc;
	private JLabel lblRefreshTS;
	private JLayeredPane layeredPaneTransactionalSegmentation;
	private JPanel panelTransactionalSegmentation;
	private JLabel lblTransactionalSegmentation;
	private JTable tableTransactionalSegmentation;
	private JScrollPane scrollPaneTransactionalSegmentation;
	private JComboBox cmbAscDesc_1;
	
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
		
		panelHomeMenu = new JPanel();
		panelHomeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lightMenuColor(panelHomeMenu, lblDashHome, lblHomeLogo, homeBlackIcon);
				darkMenuColor(panelStoreMenu, lblDashStore, lblStoreLogo, storeWhiteIcon);
				darkMenuColor(panelPurchaseMenu, lblPurchaseHistory, lblPurchaseLogo, purchaseWhiteIcon);
				darkMenuColor(panelSegmentMenu, lblDashSegment, lblSegmentLogo, segmentWhiteIcon);
				darkMenuColor(panelDemographicsMenu, lblDashDemographics, lblDemographicsLogo, demoWhiteIcon);
				darkMenuColor(panelGeographicMenu, lblDashGeographic, lblGeographicLogo, geoWhiteIcon);
				darkMenuColor(panelTransactionMenu, lblDashTransaction, lblTransactionLogo, transactWhiteIcon);
				
				layeredPane.removeAll();
				layeredPane.add(panelHome);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelHomeMenu.setBounds(0, 92, 198, 35);
		panelDashboardMenu.add(panelHomeMenu);
		panelHomeMenu.setLayout(null);
	
		lblDashHome = new JLabel("Home");
		lblDashHome.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashHome.setBounds(53, 0, 145, 38);
		panelHomeMenu.add(lblDashHome);
		
		lblHomeLogo = new JLabel("");
		lblHomeLogo.setIcon(homeBlackIcon);
		lblHomeLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeLogo.setBounds(5, 0, 35, 35);
		panelHomeMenu.add(lblHomeLogo);
		
		panelStoreMenu = new JPanel();
		panelStoreMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				darkMenuColor(panelHomeMenu, lblDashHome, lblHomeLogo, homeWhiteIcon);
				lightMenuColor(panelStoreMenu, lblDashStore, lblStoreLogo, storeBlackIcon);
				darkMenuColor(panelPurchaseMenu, lblPurchaseHistory, lblPurchaseLogo, purchaseWhiteIcon);
				darkMenuColor(panelSegmentMenu, lblDashSegment, lblSegmentLogo, segmentWhiteIcon);
				darkMenuColor(panelDemographicsMenu, lblDashDemographics, lblDemographicsLogo, demoWhiteIcon);
				darkMenuColor(panelGeographicMenu, lblDashGeographic, lblGeographicLogo, geoWhiteIcon);
				darkMenuColor(panelTransactionMenu, lblDashTransaction, lblTransactionLogo, transactWhiteIcon);
				
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
		
		lblDashStore = new JLabel("Stores");
		lblDashStore.setForeground(new Color(255, 255, 255));
		lblDashStore.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashStore.setBounds(53, 0, 145, 38);
		panelStoreMenu.add(lblDashStore);
		
		lblStoreLogo = new JLabel("");
		lblStoreLogo.setIcon(storeWhiteIcon);
		lblStoreLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreLogo.setBounds(5, 0, 35, 35);
		panelStoreMenu.add(lblStoreLogo);
		
		panelPurchaseMenu = new JPanel();
		panelPurchaseMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				darkMenuColor(panelHomeMenu, lblDashHome, lblHomeLogo, homeWhiteIcon);
				darkMenuColor(panelStoreMenu, lblDashStore, lblStoreLogo, storeWhiteIcon);
				lightMenuColor(panelPurchaseMenu, lblPurchaseHistory, lblPurchaseLogo, purchaseBlackIcon);
				darkMenuColor(panelSegmentMenu, lblDashSegment, lblSegmentLogo, segmentWhiteIcon);
				darkMenuColor(panelDemographicsMenu, lblDashDemographics, lblDemographicsLogo, demoWhiteIcon);
				darkMenuColor(panelGeographicMenu, lblDashGeographic, lblGeographicLogo, geoWhiteIcon);
				darkMenuColor(panelTransactionMenu, lblDashTransaction, lblTransactionLogo, transactWhiteIcon);
				
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
		
		lblPurchaseHistory = new JLabel("Purchase History");
		lblPurchaseHistory.setForeground(new Color(255, 255, 255));
		lblPurchaseHistory.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblPurchaseHistory.setBounds(53, 0, 145, 38);
		panelPurchaseMenu.add(lblPurchaseHistory);
		
		lblPurchaseLogo = new JLabel("");
		lblPurchaseLogo.setIcon(purchaseWhiteIcon);
		lblPurchaseLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseLogo.setBounds(5, 0, 35, 35);
		panelPurchaseMenu.add(lblPurchaseLogo);
		
		panelSegmentMenu = new JPanel();
		panelSegmentMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				darkMenuColor(panelHomeMenu, lblDashHome, lblHomeLogo, homeWhiteIcon);
				darkMenuColor(panelStoreMenu, lblDashStore, lblStoreLogo, storeWhiteIcon);
				darkMenuColor(panelPurchaseMenu, lblPurchaseHistory, lblPurchaseLogo, purchaseWhiteIcon);
				lightMenuColor(panelSegmentMenu, lblDashSegment, lblSegmentLogo, segmentBlackIcon);
				darkMenuColor(panelDemographicsMenu, lblDashDemographics, lblDemographicsLogo, demoWhiteIcon);
				darkMenuColor(panelGeographicMenu, lblDashGeographic, lblGeographicLogo, geoWhiteIcon);
				darkMenuColor(panelTransactionMenu, lblDashTransaction, lblTransactionLogo, transactWhiteIcon);
				
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
		
		lblDashSegment = new JLabel("Segmentation");
		lblDashSegment.setForeground(new Color(255, 255, 255));
		lblDashSegment.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashSegment.setBounds(53, 0, 145, 38);
		panelSegmentMenu.add(lblDashSegment);
		
		lblSegmentLogo = new JLabel("");
		lblSegmentLogo.setIcon(segmentWhiteIcon);
		lblSegmentLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegmentLogo.setBounds(5, 0, 35, 35);
		panelSegmentMenu.add(lblSegmentLogo);
		
		panelDemographicsMenu = new JPanel();
		panelDemographicsMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				darkMenuColor(panelHomeMenu, lblDashHome, lblHomeLogo, homeWhiteIcon);
				darkMenuColor(panelStoreMenu, lblDashStore, lblStoreLogo, storeWhiteIcon);
				darkMenuColor(panelPurchaseMenu, lblPurchaseHistory, lblPurchaseLogo, purchaseWhiteIcon);
				darkMenuColor(panelSegmentMenu, lblDashSegment, lblSegmentLogo, segmentWhiteIcon);
				lightMenuColor(panelDemographicsMenu, lblDashDemographics, lblDemographicsLogo, demoBlackIcon);
				darkMenuColor(panelGeographicMenu, lblDashGeographic, lblGeographicLogo, geoWhiteIcon);
				darkMenuColor(panelTransactionMenu, lblDashTransaction, lblTransactionLogo, transactWhiteIcon);
				
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
		
		lblDashDemographics = new JLabel("Demographics");
		lblDashDemographics.setForeground(new Color(255, 255, 255));
		lblDashDemographics.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashDemographics.setBounds(53, 0, 145, 38);
		panelDemographicsMenu.add(lblDashDemographics);
		
		lblDemographicsLogo = new JLabel("");
		lblDemographicsLogo.setIcon(demoWhiteIcon);
		lblDemographicsLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDemographicsLogo.setBounds(5, 0, 35, 35);
		panelDemographicsMenu.add(lblDemographicsLogo);
		
		panelGeographicMenu = new JPanel();
		panelGeographicMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				darkMenuColor(panelHomeMenu, lblDashHome, lblHomeLogo, homeWhiteIcon);
				darkMenuColor(panelStoreMenu, lblDashStore, lblStoreLogo, storeWhiteIcon);
				darkMenuColor(panelPurchaseMenu, lblPurchaseHistory, lblPurchaseLogo, purchaseWhiteIcon);
				darkMenuColor(panelSegmentMenu, lblDashSegment, lblSegmentLogo, segmentWhiteIcon);
				darkMenuColor(panelDemographicsMenu, lblDashDemographics, lblDemographicsLogo, demoWhiteIcon);
				lightMenuColor(panelGeographicMenu, lblDashGeographic, lblGeographicLogo, geoBlackIcon);
				darkMenuColor(panelTransactionMenu, lblDashTransaction, lblTransactionLogo, transactWhiteIcon);
				
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
		
		lblDashGeographic = new JLabel("Geographic");
		lblDashGeographic.setForeground(new Color(255, 255, 255));
		lblDashGeographic.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashGeographic.setBounds(53, 0, 145, 38);
		panelGeographicMenu.add(lblDashGeographic);
		
		lblGeographicLogo = new JLabel("");
		lblGeographicLogo.setIcon(geoWhiteIcon);
		lblGeographicLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeographicLogo.setBounds(5, 0, 35, 35);
		panelGeographicMenu.add(lblGeographicLogo);
		
		panelTransactionMenu = new JPanel();
		panelTransactionMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				darkMenuColor(panelHomeMenu, lblDashHome, lblHomeLogo, homeWhiteIcon);
				darkMenuColor(panelStoreMenu, lblDashStore, lblStoreLogo, storeWhiteIcon);
				darkMenuColor(panelPurchaseMenu, lblPurchaseHistory, lblPurchaseLogo, purchaseWhiteIcon);
				darkMenuColor(panelSegmentMenu, lblDashSegment, lblSegmentLogo, segmentWhiteIcon);
				darkMenuColor(panelDemographicsMenu, lblDashDemographics, lblDemographicsLogo, demoWhiteIcon);
				darkMenuColor(panelGeographicMenu, lblDashGeographic, lblGeographicLogo, geoWhiteIcon);
				lightMenuColor(panelTransactionMenu, lblDashTransaction, lblTransactionLogo, transactBlackIcon);
				
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
		
		lblDashTransaction = new JLabel("Transaction History");
		lblDashTransaction.setForeground(new Color(255, 255, 255));
		lblDashTransaction.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashTransaction.setBounds(53, 0, 145, 38);
		panelTransactionMenu.add(lblDashTransaction);
		
		lblTransactionLogo = new JLabel("");
		lblTransactionLogo.setIcon(transactWhiteIcon);
		lblTransactionLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionLogo.setBounds(5, 0, 35, 35);
		panelTransactionMenu.add(lblTransactionLogo);
		
		ImageIcon logOutIcon = new ImageIcon("C:\\Users\\jeric\\eclipse-workspace\\iTrack\\src\\exit.png");
		JLabel lblLogOut = new JLabel("New label");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInPage logOut = new SignInPage();
				logOut.setVisible(true);
				dispose();
			}
		});
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
				
				layeredPaneHomePage.removeAll();
				layeredPaneHomePage.add(panelSales);
				layeredPaneHomePage.repaint();
				layeredPaneHomePage.revalidate();
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
				
				layeredPaneHomePage.removeAll();
				layeredPaneHomePage.add(panelCustomer);
				layeredPaneHomePage.repaint();
				layeredPaneHomePage.revalidate();
			}
		});
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblCustomer.setBounds(398, 58, 100, 25);
		panelHome.add(lblCustomer);
		
		layeredPaneHomePage = new JLayeredPane();
		layeredPaneHomePage.setBounds(35, 116, 1100, 630);
		panelHome.add(layeredPaneHomePage);
		layeredPaneHomePage.setLayout(new CardLayout(0, 0));
		
		panelSales = new JPanel();
		layeredPaneHomePage.add(panelSales, "name_1304946628987100");
		panelSales.setLayout(null);
		
		panelTotalSales = new JPanel();
		panelTotalSales.setBackground(new Color(255, 255, 255));
		panelTotalSales.setBounds(0, 0, 220, 150);
		panelSales.add(panelTotalSales);
		panelTotalSales.setLayout(null);
		
		JLabel lblTotalSales = new JLabel("TOTAL SALES");
		lblTotalSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalSales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTotalSales.setBounds(0, 10, 220, 40);
		panelTotalSales.add(lblTotalSales);
		
		JLabel lblTotalSalesAmount = new JLabel("$" + "240" + "M");
		lblTotalSalesAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalSalesAmount.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblTotalSalesAmount.setBounds(0, 50, 220, 60);
		panelTotalSales.add(lblTotalSalesAmount);
		
		lblSalesPercentIncrease = new JLabel("(+2.31%)");
		lblSalesPercentIncrease.setForeground(new Color(0, 255, 0));
		lblSalesPercentIncrease.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesPercentIncrease.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblSalesPercentIncrease.setBounds(0, 100, 220, 40);
		panelTotalSales.add(lblSalesPercentIncrease);
		
		panelTotalProfit = new JPanel();
		panelTotalProfit.setBackground(Color.WHITE);
		panelTotalProfit.setBounds(230, 0, 220, 150);
		panelSales.add(panelTotalProfit);
		panelTotalProfit.setLayout(null);
		
		lblTotalProfit = new JLabel("TOTAL PROFIT");
		lblTotalProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalProfit.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTotalProfit.setBounds(0, 10, 220, 40);
		panelTotalProfit.add(lblTotalProfit);
		
		lblTotalSalesAmount_1 = new JLabel("$240M");
		lblTotalSalesAmount_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalSalesAmount_1.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblTotalSalesAmount_1.setBounds(0, 50, 220, 60);
		panelTotalProfit.add(lblTotalSalesAmount_1);
		
		lblSalesPercentIncrease_1 = new JLabel("(+2.31%)");
		lblSalesPercentIncrease_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesPercentIncrease_1.setForeground(Color.GREEN);
		lblSalesPercentIncrease_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblSalesPercentIncrease_1.setBounds(0, 100, 220, 40);
		panelTotalProfit.add(lblSalesPercentIncrease_1);
		
		panelProfitMargin = new JPanel();
		panelProfitMargin.setBackground(Color.WHITE);
		panelProfitMargin.setBounds(460, 0, 220, 150);
		panelSales.add(panelProfitMargin);
		panelProfitMargin.setLayout(null);
		
		lblProfitMargin = new JLabel("PROFIT MARGIN");
		lblProfitMargin.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfitMargin.setFont(new Font("Poppins", Font.BOLD, 25));
		lblProfitMargin.setBounds(0, 10, 220, 40);
		panelProfitMargin.add(lblProfitMargin);
		
		lblTotalSalesAmount_2 = new JLabel("$240M");
		lblTotalSalesAmount_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalSalesAmount_2.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblTotalSalesAmount_2.setBounds(0, 50, 220, 60);
		panelProfitMargin.add(lblTotalSalesAmount_2);
		
		lblSalesPercentIncrease_2 = new JLabel("(+2.31%)");
		lblSalesPercentIncrease_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesPercentIncrease_2.setForeground(Color.GREEN);
		lblSalesPercentIncrease_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblSalesPercentIncrease_2.setBounds(0, 100, 220, 40);
		panelProfitMargin.add(lblSalesPercentIncrease_2);
		
		panelSalesAndProfitTrend = new JPanel();
		panelSalesAndProfitTrend.setBackground(Color.WHITE);
		panelSalesAndProfitTrend.setBounds(0, 160, 680, 215);
		panelSales.add(panelSalesAndProfitTrend);
		panelSalesAndProfitTrend.setLayout(null);
		
		lblSalesAndProfitTrend = new JLabel("SALES AND PROFIT TREND");
		lblSalesAndProfitTrend.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesAndProfitTrend.setFont(new Font("Poppins", Font.BOLD, 25));
		lblSalesAndProfitTrend.setBounds(0, 10, 680, 40);
		panelSalesAndProfitTrend.add(lblSalesAndProfitTrend);
		
		panelTopTenProducts = new JPanel();
		panelTopTenProducts.setBackground(Color.WHITE);
		panelTopTenProducts.setBounds(0, 385, 680, 215);
		panelSales.add(panelTopTenProducts);
		panelTopTenProducts.setLayout(null);
		
		lblTopTenProductsBySales = new JLabel("TOP 10 PRODUCTS BY SALES");
		lblTopTenProductsBySales.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopTenProductsBySales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTopTenProductsBySales.setBounds(0, 10, 680, 40);
		panelTopTenProducts.add(lblTopTenProductsBySales);
		
		panelSalesVolumePerCountry = new JPanel();
		panelSalesVolumePerCountry.setBackground(Color.WHITE);
		panelSalesVolumePerCountry.setBounds(690, 0, 400, 295);
		panelSales.add(panelSalesVolumePerCountry);
		panelSalesVolumePerCountry.setLayout(null);
		
		lblSalesVolumeByCountry = new JLabel("SALES VOLUME BY COUNTRY");
		lblSalesVolumeByCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesVolumeByCountry.setFont(new Font("Poppins", Font.BOLD, 25));
		lblSalesVolumeByCountry.setBounds(0, 10, 400, 40);
		panelSalesVolumePerCountry.add(lblSalesVolumeByCountry);
		
		panelTopTenStoresBySales = new JPanel();
		panelTopTenStoresBySales.setBackground(Color.WHITE);
		panelTopTenStoresBySales.setBounds(690, 305, 400, 295);
		panelSales.add(panelTopTenStoresBySales);
		panelTopTenStoresBySales.setLayout(null);
		
		lblTopTenStoresBySales = new JLabel("TOP 10 STORES BY SALES");
		lblTopTenStoresBySales.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopTenStoresBySales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTopTenStoresBySales.setBounds(0, 10, 400, 40);
		panelTopTenStoresBySales.add(lblTopTenStoresBySales);
		
		panelCustomer = new JPanel();
		layeredPaneHomePage.add(panelCustomer, "name_1304958910393200");
		panelCustomer.setLayout(null);
		
		panelTotalActiveCustomers = new JPanel();
		panelTotalActiveCustomers.setLayout(null);
		panelTotalActiveCustomers.setBackground(Color.WHITE);
		panelTotalActiveCustomers.setBounds(0, 0, 220, 150);
		panelCustomer.add(panelTotalActiveCustomers);
		
		lblTotalActive = new JLabel("TOTAL ACTIVE");
		lblTotalActive.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalActive.setFont(new Font("Poppins", Font.BOLD, 20));
		lblTotalActive.setBounds(0, 0, 220, 40);
		panelTotalActiveCustomers.add(lblTotalActive);
		
		lblNumberOfCustomers = new JLabel("240M");
		lblNumberOfCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfCustomers.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblNumberOfCustomers.setBounds(0, 55, 220, 60);
		panelTotalActiveCustomers.add(lblNumberOfCustomers);
		
		lblCustomerGrowthPercentage = new JLabel("(+2.31%)");
		lblCustomerGrowthPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerGrowthPercentage.setForeground(Color.GREEN);
		lblCustomerGrowthPercentage.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCustomerGrowthPercentage.setBounds(0, 105, 220, 40);
		panelTotalActiveCustomers.add(lblCustomerGrowthPercentage);
		
		lblActiveCustomers = new JLabel("CUSTOMERS");
		lblActiveCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveCustomers.setFont(new Font("Poppins", Font.BOLD, 20));
		lblActiveCustomers.setBounds(0, 20, 220, 40);
		panelTotalActiveCustomers.add(lblActiveCustomers);
		
		panelTotalActiveCustomers_1 = new JPanel();
		panelTotalActiveCustomers_1.setLayout(null);
		panelTotalActiveCustomers_1.setBackground(Color.WHITE);
		panelTotalActiveCustomers_1.setBounds(230, 0, 220, 150);
		panelCustomer.add(panelTotalActiveCustomers_1);
		
		lblTotalNew = new JLabel("TOTAL NEW");
		lblTotalNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNew.setFont(new Font("Poppins", Font.BOLD, 20));
		lblTotalNew.setBounds(0, 0, 220, 40);
		panelTotalActiveCustomers_1.add(lblTotalNew);
		
		lblNumberOfCustomers_1 = new JLabel("240M");
		lblNumberOfCustomers_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfCustomers_1.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblNumberOfCustomers_1.setBounds(0, 55, 220, 60);
		panelTotalActiveCustomers_1.add(lblNumberOfCustomers_1);
		
		lblCustomerGrowthPercentage_1 = new JLabel("(+2.31%)");
		lblCustomerGrowthPercentage_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerGrowthPercentage_1.setForeground(Color.GREEN);
		lblCustomerGrowthPercentage_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCustomerGrowthPercentage_1.setBounds(0, 105, 220, 40);
		panelTotalActiveCustomers_1.add(lblCustomerGrowthPercentage_1);
		
		lblActiveCustomers_1 = new JLabel("CUSTOMERS");
		lblActiveCustomers_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveCustomers_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblActiveCustomers_1.setBounds(0, 20, 220, 40);
		panelTotalActiveCustomers_1.add(lblActiveCustomers_1);
		
		panelTotalActiveCustomers_2 = new JPanel();
		panelTotalActiveCustomers_2.setLayout(null);
		panelTotalActiveCustomers_2.setBackground(Color.WHITE);
		panelTotalActiveCustomers_2.setBounds(460, 0, 220, 150);
		panelCustomer.add(panelTotalActiveCustomers_2);
		
		lblCustomerGrowth = new JLabel("TOTAL ACTIVE");
		lblCustomerGrowth.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerGrowth.setFont(new Font("Poppins", Font.BOLD, 20));
		lblCustomerGrowth.setBounds(0, 0, 220, 40);
		panelTotalActiveCustomers_2.add(lblCustomerGrowth);
		
		lblNumberOfCustomers_2 = new JLabel("24%");
		lblNumberOfCustomers_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfCustomers_2.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblNumberOfCustomers_2.setBounds(0, 55, 220, 60);
		panelTotalActiveCustomers_2.add(lblNumberOfCustomers_2);
		
		lblCustomerGrowthPercentage_2 = new JLabel("(+2.31%)");
		lblCustomerGrowthPercentage_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerGrowthPercentage_2.setForeground(Color.GREEN);
		lblCustomerGrowthPercentage_2.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblCustomerGrowthPercentage_2.setBounds(0, 105, 220, 40);
		panelTotalActiveCustomers_2.add(lblCustomerGrowthPercentage_2);
		
		lblActiveCustomers_2 = new JLabel("CUSTOMERS");
		lblActiveCustomers_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveCustomers_2.setFont(new Font("Poppins", Font.BOLD, 20));
		lblActiveCustomers_2.setBounds(0, 20, 220, 40);
		panelTotalActiveCustomers_2.add(lblActiveCustomers_2);
		
		panelCustomerTrend = new JPanel();
		panelCustomerTrend.setLayout(null);
		panelCustomerTrend.setBackground(Color.WHITE);
		panelCustomerTrend.setBounds(0, 160, 680, 215);
		panelCustomer.add(panelCustomerTrend);
		
		lblNewVsCurrent = new JLabel("NEW VS. CURRENT CUSTOMERS TREND");
		lblNewVsCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewVsCurrent.setFont(new Font("Poppins", Font.BOLD, 25));
		lblNewVsCurrent.setBounds(0, 10, 680, 40);
		panelCustomerTrend.add(lblNewVsCurrent);
		
		panelCustomerSegmentationGraphs = new JPanel();
		panelCustomerSegmentationGraphs.setLayout(null);
		panelCustomerSegmentationGraphs.setBackground(Color.WHITE);
		panelCustomerSegmentationGraphs.setBounds(0, 387, 1100, 215);
		panelCustomer.add(panelCustomerSegmentationGraphs);
		
		lblCustomerSegmentation = new JLabel("CUSTOMER SEGMENTATION");
		lblCustomerSegmentation.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerSegmentation.setFont(new Font("Poppins", Font.BOLD, 25));
		lblCustomerSegmentation.setBounds(0, 10, 1100, 40);
		panelCustomerSegmentationGraphs.add(lblCustomerSegmentation);
		
		panelCustomerVolumeByCountry = new JPanel();
		panelCustomerVolumeByCountry.setLayout(null);
		panelCustomerVolumeByCountry.setBackground(Color.WHITE);
		panelCustomerVolumeByCountry.setBounds(700, 0, 400, 374);
		panelCustomer.add(panelCustomerVolumeByCountry);
		
		lblCustomerVolumeByCountry = new JLabel("CUSTOMER VOLUME BY COUNTRY");
		lblCustomerVolumeByCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerVolumeByCountry.setFont(new Font("Poppins", Font.BOLD, 22));
		lblCustomerVolumeByCountry.setBounds(0, 10, 400, 40);
		panelCustomerVolumeByCountry.add(lblCustomerVolumeByCountry);
		
		lblExport = new JLabel("Export");
		lblExport.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblExport.setHorizontalAlignment(SwingConstants.CENTER);
		lblExport.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblExport.setBounds(1045, 58, 80, 20);
		panelHome.add(lblExport);
		
		lblRefresh = new JLabel("Refresh");
		lblRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefresh.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblRefresh.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblRefresh.setBounds(955, 58, 80, 20);
		panelHome.add(lblRefresh);
		
		panelStores = new JPanel();
		layeredPane.add(panelStores, "name_1237607726469500");
		panelStores.setLayout(null);
		
		JLabel lblStoreTitle = new JLabel("Stores");
		lblStoreTitle.setFont(new Font("Poppins", Font.BOLD, 40));
		lblStoreTitle.setBounds(35, 36, 263, 56);
		panelStores.add(lblStoreTitle);
		
		layeredPaneStores = new JLayeredPane();
		layeredPaneStores.setBounds(35, 116, 1100, 630);
		panelStores.add(layeredPaneStores);
		layeredPaneStores.setLayout(new CardLayout(0, 0));
		
		panelStoreSummary = new JPanel();
		layeredPaneStores.add(panelStoreSummary, "name_1311031875153600");
		panelStoreSummary.setLayout(null);
		
		panelStoreInformation = new JPanel();
		panelStoreInformation.setLayout(null);
		panelStoreInformation.setBackground(Color.WHITE);
		panelStoreInformation.setBounds(0, 0, 540, 300);
		panelStoreSummary.add(panelStoreInformation);
		
		lblStoreInformation = new JLabel("STORE INFORMATION");
		lblStoreInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreInformation.setFont(new Font("Poppins", Font.BOLD, 25));
		lblStoreInformation.setBounds(0, 10, 540, 40);
		panelStoreInformation.add(lblStoreInformation);
		
		panelTopStoresBySales = new JPanel();
		panelTopStoresBySales.setLayout(null);
		panelTopStoresBySales.setBackground(Color.WHITE);
		panelTopStoresBySales.setBounds(560, 0, 540, 300);
		panelStoreSummary.add(panelTopStoresBySales);
		
		lblTopStoresBySales = new JLabel("TOP 10 STORES BY SALES");
		lblTopStoresBySales.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopStoresBySales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTopStoresBySales.setBounds(0, 10, 540, 40);
		panelTopStoresBySales.add(lblTopStoresBySales);
		
		panelPurchaseHistoryTable = new JPanel();
		panelPurchaseHistoryTable.setLayout(null);
		panelPurchaseHistoryTable.setBackground(Color.WHITE);
		panelPurchaseHistoryTable.setBounds(0, 310, 1100, 310);
		panelStoreSummary.add(panelPurchaseHistoryTable);
		
		lblPurchaseHistoryTable = new JLabel("PURCHASE HISTORY");
		lblPurchaseHistoryTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseHistoryTable.setFont(new Font("Poppins", Font.BOLD, 25));
		lblPurchaseHistoryTable.setBounds(0, 10, 1100, 40);
		panelPurchaseHistoryTable.add(lblPurchaseHistoryTable);
		
		panelStoresSales = new JPanel();
		panelStoresSales.setBackground(new Color(255, 255, 255));
		layeredPaneStores.add(panelStoresSales, "name_1311043919383900");
		panelStoresSales.setLayout(null);
		
		lblStoresBySales = new JLabel("STORES BY SALES");
		lblStoresBySales.setHorizontalAlignment(SwingConstants.LEFT);
		lblStoresBySales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblStoresBySales.setBounds(10, 10, 540, 40);
		panelStoresSales.add(lblStoresBySales);
		
		lblRefreshSales = new JLabel("Refresh");
		lblRefreshSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefreshSales.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblRefreshSales.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblRefreshSales.setBounds(1045, 58, 80, 20);
		panelStores.add(lblRefreshSales);
		
		panelPurchaseHistory = new JPanel();
		layeredPane.add(panelPurchaseHistory, "name_1237611265977400");
		panelPurchaseHistory.setLayout(null);
		
		JLabel lblStoresTitle = new JLabel("Stores");
		lblStoresTitle.setFont(new Font("Poppins", Font.BOLD, 40));
		lblStoresTitle.setBounds(35, 36, 263, 56);
		panelPurchaseHistory.add(lblStoresTitle);
		
		panelStoresSales_1 = new JPanel();
		panelStoresSales_1.setLayout(null);
		panelStoresSales_1.setBackground(Color.WHITE);
		panelStoresSales_1.setBounds(35, 115, 1100, 630);
		panelPurchaseHistory.add(panelStoresSales_1);
		
		lblPurchaseHistorySummary = new JLabel("PURCHASE HISTORY");
		lblPurchaseHistorySummary.setHorizontalAlignment(SwingConstants.LEFT);
		lblPurchaseHistorySummary.setFont(new Font("Poppins", Font.BOLD, 25));
		lblPurchaseHistorySummary.setBounds(10, 10, 540, 40);
		panelStoresSales_1.add(lblPurchaseHistorySummary);
		
		lblRefreshPurchase = new JLabel("Refresh");
		lblRefreshPurchase.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefreshPurchase.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblRefreshPurchase.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblRefreshPurchase.setBounds(1045, 58, 80, 20);
		panelPurchaseHistory.add(lblRefreshPurchase);
		
		panelSegmentation = new JPanel();
		panelSegmentation.setFont(new Font("Poppins", Font.BOLD, 17));
		layeredPane.add(panelSegmentation, "name_1237637193320800");
		panelSegmentation.setLayout(null);
		
		JLabel lblCustomerSegment1 = new JLabel("Customer Segmentation");
		lblCustomerSegment1.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment1.setBounds(35, 36, 609, 56);
		panelSegmentation.add(lblCustomerSegment1);
		
		JLayeredPane layeredCustomerSegmentation = new JLayeredPane();
		layeredCustomerSegmentation.setBounds(10, 95, 1133, 649);
		panelSegmentation.add(layeredCustomerSegmentation);
		layeredCustomerSegmentation.setLayout(new CardLayout(0, 0));
		
		panelCustomerSegmentation = new JPanel();
		layeredCustomerSegmentation.add(panelCustomerSegmentation, "name_9606951641900");
		panelCustomerSegmentation.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 24, 534, 285);
		panelCustomerSegmentation.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEMOGRAPHIC SEGMENTATION");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 11, 337, 24);
		panel_1.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(570, 24, 534, 285);
		panelCustomerSegmentation.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GEOGRAPHIC SEGMENTATION");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_1.setBounds(125, 11, 295, 24);
		panel_2.add(lblNewLabel_1);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(22, 320, 1082, 318);
		panelCustomerSegmentation.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("TRANSACTIONAL SEGMENTATION");
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(358, 11, 363, 30);
		panel_3.add(lblNewLabel_2);
		
		lblRefreshCS = new JLabel("Refresh");
		lblRefreshCS.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefreshCS.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblRefreshCS.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblRefreshCS.setBounds(945, 73, 80, 20);
		panelSegmentation.add(lblRefreshCS);
		
		lblExportCS = new JLabel("Export");
		lblExportCS.setHorizontalAlignment(SwingConstants.CENTER);
		lblExportCS.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblExportCS.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblExportCS.setBounds(1035, 73, 80, 19);
		panelSegmentation.add(lblExportCS);
		
		panelDemographics = new JPanel();
		layeredPane.add(panelDemographics, "name_1237649696174600");
		panelDemographics.setLayout(null);
		
		JLabel lblCustomerSegment2 = new JLabel("Customer Segmentation");
		lblCustomerSegment2.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment2.setBounds(35, 36, 609, 56);
		panelDemographics.add(lblCustomerSegment2);
		
		JLayeredPane layeredPaneDemographics = new JLayeredPane();
		layeredPaneDemographics.setBounds(35, 103, 1092, 620);
		panelDemographics.add(layeredPaneDemographics);
		layeredPaneDemographics.setLayout(new CardLayout(0, 0));
		
		JPanel panelDemographic = new JPanel();
		panelDemographic.setBackground(Color.WHITE);
		layeredPaneDemographics.add(panelDemographic, "name_12966667586300");
		panelDemographic.setLayout(null);
		
		String[] Demographic = {"Customer ID", "Customer Name", "Birthday", "Gender", "Contact Number"};
	        DefaultTableModel DemographicModel = new DefaultTableModel(Demographic, 0);
	        
		JLabel lblDemoSegmentation = new JLabel("DEMOGRAPHIC SEGMENTATION");
		lblDemoSegmentation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDemoSegmentation.setFont(new Font("Poppins", Font.BOLD, 25));
		lblDemoSegmentation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDemoSegmentation.setBounds(218, 0, 632, 43);
		panelDemographic.add(lblDemoSegmentation);
		
		JComboBox cmbFinder = new JComboBox();
		cmbFinder.setFont(new Font("Poppins", Font.PLAIN, 12));
		cmbFinder.setName("");
		cmbFinder.setBounds(963, 17, 105, 17);
		panelDemographic.add(cmbFinder);
		
		scrollPaneDemoSegmentation = new JScrollPane();
		scrollPaneDemoSegmentation.setAutoscrolls(true);
		scrollPaneDemoSegmentation.setBackground(Color.WHITE);
		scrollPaneDemoSegmentation.setBounds(29, 38, 1023, 552);
		panelDemographic.add(scrollPaneDemoSegmentation);
		scrollPaneDemoSegmentation.setBorder(null);
	
		tableDemoSegmentation = new JTable();
		tableDemoSegmentation.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		tableDemoSegmentation.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Customer Name", "Birthday", "Gender", "Contact Number"
			}
		));
		scrollPaneDemoSegmentation.setViewportView(tableDemoSegmentation);
		
		 JTableHeader tableHeader = tableDemoSegmentation.getTableHeader();
	        tableHeader.setFont(new Font("Poppins", Font.BOLD, 12));
	        tableHeader.setBackground(Color.BLACK);
	        tableHeader.setForeground(Color.WHITE);

	        scrollPaneDemoSegmentation.setViewportView(tableDemoSegmentation);
	        
	        lblRefreshDS = new JLabel("Refresh");
	        lblRefreshDS.setBounds(1047, 72, 80, 20);
	        panelDemographics.add(lblRefreshDS);
	        lblRefreshDS.setHorizontalAlignment(SwingConstants.CENTER);
	        lblRefreshDS.setFont(new Font("Poppins", Font.PLAIN, 12));
	        lblRefreshDS.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));

	        scrollPaneDemoSegmentation.setVisible(true);
		
		panelGeographics = new JPanel();
		layeredPane.add(panelGeographics, "name_1237653177687600");
		panelGeographics.setLayout(null);
		
		JLabel lblCustomerSegment3 = new JLabel("Customer Segmentation");
		lblCustomerSegment3.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment3.setBounds(35, 36, 609, 56);
		panelGeographics.add(lblCustomerSegment3);
		
		lblRefreshGS = new JLabel("Refresh");
		lblRefreshGS.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefreshGS.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblRefreshGS.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblRefreshGS.setBounds(1047, 72, 80, 20);
		panelGeographics.add(lblRefreshGS);
		
		JLayeredPane layeredPaneGeographicSegmentation = new JLayeredPane();
		layeredPaneGeographicSegmentation.setBounds(35, 103, 1092, 620);
		panelGeographics.add(layeredPaneGeographicSegmentation);
		layeredPaneGeographicSegmentation.setLayout(new CardLayout(0, 0));
		
		panelGeographicSegmentation = new JPanel();
		panelGeographicSegmentation.setBackground(Color.WHITE);
		layeredPaneGeographicSegmentation.add(panelGeographicSegmentation, "name_8803048947500");
		panelGeographicSegmentation.setLayout(null);
		
		lblGeographicSegmentation = new JLabel("GEOGRAPHIC SEGMENTATION");
		lblGeographicSegmentation.setFont(new Font("Poppins", Font.BOLD, 25));
		lblGeographicSegmentation.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeographicSegmentation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGeographicSegmentation.setBounds(218, 0, 632, 43);
		panelGeographicSegmentation.add(lblGeographicSegmentation);
		
		cmbAscDesc = new JComboBox();
		cmbAscDesc.setName("");
		cmbAscDesc.setFont(new Font("Poppins", Font.PLAIN, 12));
		cmbAscDesc.setBounds(963, 17, 105, 17);
		panelGeographicSegmentation.add(cmbAscDesc);
		
		scrollPaneGeographicSegmentation = new JScrollPane();
		scrollPaneGeographicSegmentation.setBounds(29, 38, 1023, 552);
		panelGeographicSegmentation.add(scrollPaneGeographicSegmentation);
		
		tableGeographicSegmentation = new JTable();
		scrollPaneGeographicSegmentation.setViewportView(tableGeographicSegmentation);
		tableGeographicSegmentation.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Customer Name","Address", "Country", "Region"
			}
		));
		scrollPaneGeographicSegmentation.setViewportView(tableGeographicSegmentation);
		
		 JTableHeader tableHeadertwo = tableGeographicSegmentation.getTableHeader();
		 	tableHeadertwo.setFont(new Font("Poppins", Font.BOLD, 12));
		 	tableHeadertwo.setBackground(Color.BLACK);
		 	tableHeadertwo.setForeground(Color.WHITE);

	        scrollPaneGeographicSegmentation.setViewportView(tableGeographicSegmentation);

	        scrollPaneGeographicSegmentation.setVisible(true);

		
		
		panelTransactionHistory = new JPanel();
		layeredPane.add(panelTransactionHistory, "name_1237656709540000");
		panelTransactionHistory.setLayout(null);
		
		JLabel lblCustomerSegment4 = new JLabel("Customer Segmentation");
		lblCustomerSegment4.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment4.setBounds(35, 36, 609, 56);
		panelTransactionHistory.add(lblCustomerSegment4);
		
		lblRefreshTS = new JLabel("Refresh");
		lblRefreshTS.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefreshTS.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblRefreshTS.setBorder(new MatteBorder( 1, 1, 1, 1, Color.black));
		lblRefreshTS.setBounds(1047, 72, 80, 20);
		panelTransactionHistory.add(lblRefreshTS);
		
		layeredPaneTransactionalSegmentation = new JLayeredPane();
		layeredPaneTransactionalSegmentation.setBounds(35, 103, 1092, 620);
		panelTransactionHistory.add(layeredPaneTransactionalSegmentation);
		layeredPaneTransactionalSegmentation.setLayout(new CardLayout(0, 0));
		
		panelTransactionalSegmentation = new JPanel();
		panelTransactionalSegmentation.setBackground(Color.WHITE);
		layeredPaneTransactionalSegmentation.add(panelTransactionalSegmentation, "name_11672254942800");
		panelTransactionalSegmentation.setLayout(null);
		
		lblTransactionalSegmentation = new JLabel("TRANSACTIONAL SEGMENTATION");
		lblTransactionalSegmentation.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTransactionalSegmentation.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTransactionalSegmentation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionalSegmentation.setBounds(218, 0, 632, 43);
		panelTransactionalSegmentation.add(lblTransactionalSegmentation);
		
		cmbAscDesc_1 = new JComboBox();
		cmbAscDesc_1.setName("");
		cmbAscDesc_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		cmbAscDesc_1.setBounds(963, 17, 105, 17);
		panelTransactionalSegmentation.add(cmbAscDesc_1);
		
		scrollPaneTransactionalSegmentation = new JScrollPane();
		scrollPaneTransactionalSegmentation.setBounds(29, 38, 1023, 552);
		panelTransactionalSegmentation.add(scrollPaneTransactionalSegmentation);
		
		 JTable tableTransactionalSegmentation = new JTable();
	        tableTransactionalSegmentation.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
	        tableTransactionalSegmentation.setModel(new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Customer ID", "Customer Name", "Total Number of Transactions", "Total Number of Unit Purchased", "Total Amount of Purchases"
	            }
	        ));
	        scrollPaneTransactionalSegmentation.setViewportView(tableTransactionalSegmentation);

	        JTableHeader tableHeaderThree = tableTransactionalSegmentation.getTableHeader();
	        tableHeaderThree.setFont(new Font("Poppins", Font.BOLD, 12));
	        tableHeaderThree.setBackground(Color.BLACK);
	        tableHeaderThree.setForeground(Color.WHITE);

	        scrollPaneTransactionalSegmentation.setViewportView(tableTransactionalSegmentation);
	        scrollPaneTransactionalSegmentation.setVisible(true);
	}
	      


	public void underlineBorder(JLabel lined, JLabel unlined) {
		lined.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
		unlined.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
	}
	
	public void lightMenuColor(JPanel panel1, JLabel menu1, JLabel logo1, ImageIcon icon1) {
		panel1.setBackground(new Color(240, 240, 240));
		menu1.setForeground(Color.black);
		logo1.setIcon(icon1);;
	}
	
	public void darkMenuColor(JPanel panel1, JLabel menu1, JLabel logo1, ImageIcon icon1) {
		panel1.setBackground(Color.black);
		menu1.setForeground(Color.white);
		logo1.setIcon(icon1);
	}
}
