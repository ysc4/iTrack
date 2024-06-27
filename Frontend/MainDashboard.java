package iTrack;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


import org.jfree.chart.ChartPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon appleIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/apple-dash.png");
	ImageIcon homeWhiteIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/home-white.png");
	ImageIcon homeBlackIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/home-black.png");
	ImageIcon storeWhiteIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/store-white.png");
	ImageIcon storeBlackIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/store-black.png");
	ImageIcon purchaseWhiteIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/purchase-white.png");
	ImageIcon purchaseBlackIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/purchase-black.png");
	ImageIcon segmentWhiteIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/segment-white.png");
	ImageIcon segmentBlackIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/segment-black.png");
	ImageIcon demoWhiteIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/demo-white.png");
	ImageIcon demoBlackIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/demo-black.png");
	ImageIcon geoWhiteIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/geo-white.png");
	ImageIcon geoBlackIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/geo-black.png");
	ImageIcon transactWhiteIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/transaction-white.png");
	ImageIcon transactBlackIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/transaction-black.png");
	ImageIcon accountIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/account.png");
	ImageIcon exitIcon = new ImageIcon("/Users/yscalify/eclipse-workspace/iTrack/exit.png");
	
	CustomerDashboard customerDash = new CustomerDashboard();
	PurchaseHistory purchaseHistory = new PurchaseHistory();
	TransactionalSegmentation transacSegment = new TransactionalSegmentation();
	
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
	private JPanel panelSalesPerCountry;
	private JPanel panelTopTenStoresBySales;
	private JLabel lblSalesPercentIncrease;
	private JLabel lblTotalOrders;
	private JLabel lblTotalProfit;
	private JLabel lblSumOrders;
	private JLabel lblSumProfit;
	private JLabel lblOrderIncrease;
	private JLabel lblProfitIncrease;
	private JLabel lblSalesAndProfitTrend;
	private JLabel lblTopTenProductsBySales;
	private JLabel lblTopFifteenStoresBySales;
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
	private JPanel panelCustomerSegmentationGraphs;
	private JPanel panelCustomerVolumeByCountry;
	private JLabel lblCustomerVolumeByCountry;
	private JLayeredPane layeredPaneStores;
	private JPanel panelStoreSummary;
	private JPanel panelStoresSales;
	private JPanel panelStoreInformation;
	private JLabel lblStoreInformation;
	private JPanel panelTopSalesOfStore;
	private JPanel panelPurchaseHistoryTable;
	private JLabel lblPurchaseHistoryTable;
	private JLabel lblStoresBySales;
	private JPanel panelStoresSales_1;
	private JLabel lblPurchaseHistorySummary;
	private JPanel panelCustomerSegmentation;
	private JPanel demoPanel;
	private JPanel geoPanel;
	private JPanel transPanel;
	private JTable tableGeographic;
	private JTable tableDemoSegmentation;
	private JScrollPane scrollPaneDemoSegmentation;
	private JTable table_1;
	private JPanel panel;
	private JPanel panelGeographicSegmentation;
	private JLabel lblGeographicSegmentation;
	private JTable tableGeographicSegmentation;
	private JScrollPane scrollPaneGeographicSegmentation;
	private JComboBox cmbAscDesc;
	private JLayeredPane layeredPaneTransactionalSegmentation;
	private JPanel panelTransactionalSegmentation;
	private JLabel lblTransactionalSegmentation;
	private JTable tableTransactionalSegmentation;
	private JScrollPane scrollPaneTransactionalSegmentation;
	private JComboBox cmbAscDesc_1;
	private JTable table;
	private JTable tableT10SBS;
	private JScrollPane scrollPaneT10SBS;
	private JTable tableCVBC;
	private JScrollPane scrollPaneCVBC;
	private JTable tablePurchaseHistory;
	private JScrollPane scrollPanePurchaseHistory;
	private JTable tableOverallSBS;
	private JScrollPane scrollPaneOverallSBS;
	private JTable tablePurchaseHistoryOverall;
	private JScrollPane scrollPaneOverallPurchaseHistory;
	private JLabel lblStoreName;
	private JLabel lblStoreAddress;
	private JLabel lblStoreCountry;
	private JLabel lblStoreContactNumber;
	private JLabel lblStoreType;
	private JLabel lblStoreIDDetail;
	private JLabel lblStoreNameDetail;
	private JLabel lblStoreAddressDetail;
	private JLabel lblStoreCountryDetail;
	private JLabel lblStoreTypeDetail;
	private JLabel lblStoreContactDetail;
	private JLabel lblOverall;
	private JLabel lblNumberOfActiveCustomers;
	private JLabel lblNumberOfNewCustomers;
	private JLabel lblNewPercentage;
	private JLabel lblCustomers;
	private JLabel lblPercentageCustomerGrowth;
	private JPanel panelCustomerGrowth;
	private JPanel panelTotalNew;
	private JLabel lblTopStoresBySales;
	private JPanel panelTopStoresBySales;
	private JScrollPane scrollPaneT10SBS2;
	private JTable tableT10SBS2;
	
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
	 * @throws Exception 
	 */
	public MainDashboard() throws Exception {
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
		
		lblDashTransaction = new JLabel("Transactional");
		lblDashTransaction.setForeground(new Color(255, 255, 255));
		lblDashTransaction.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashTransaction.setBounds(53, 0, 145, 38);
		panelTransactionMenu.add(lblDashTransaction);
		
		lblTransactionLogo = new JLabel("");
		lblTransactionLogo.setIcon(transactWhiteIcon);
		lblTransactionLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionLogo.setBounds(5, 0, 35, 35);
		panelTransactionMenu.add(lblTransactionLogo);
		
		JLabel lblLogOut = new JLabel("");
		lblLogOut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignInPage logOut;
				try {
					logOut = new SignInPage();
					logOut.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		lblLogOut.setIcon(exitIcon);
		lblLogOut.setBounds(0, 695, 50, 40);
		panelDashboardMenu.add(lblLogOut);
		
	
		JLabel lblAccount = new JLabel("");
		lblAccount.setHorizontalAlignment(SwingConstants.RIGHT);
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
		
		lblTotalOrders = new JLabel("TOTAL ORDERS");
		lblTotalOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalOrders.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTotalOrders.setBounds(0, 10, 220, 40);
		panelTotalProfit.add(lblTotalOrders);
		
		lblSumOrders = new JLabel("$240M");
		lblSumOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblSumOrders.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblSumOrders.setBounds(0, 50, 220, 60);
		panelTotalProfit.add(lblSumOrders);
		
		lblOrderIncrease = new JLabel("(+2.31%)");
		lblOrderIncrease.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderIncrease.setForeground(Color.GREEN);
		lblOrderIncrease.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblOrderIncrease.setBounds(0, 100, 220, 40);
		panelTotalProfit.add(lblOrderIncrease);
		
		panelProfitMargin = new JPanel();
		panelProfitMargin.setBackground(Color.WHITE);
		panelProfitMargin.setBounds(460, 0, 220, 150);
		panelSales.add(panelProfitMargin);
		panelProfitMargin.setLayout(null);
		
		lblTotalProfit = new JLabel("TOTAL PROFIT");
		lblTotalProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalProfit.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTotalProfit.setBounds(0, 10, 220, 40);
		panelProfitMargin.add(lblTotalProfit);
		
		lblSumProfit = new JLabel("$240M");
		lblSumProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSumProfit.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblSumProfit.setBounds(0, 50, 220, 60);
		panelProfitMargin.add(lblSumProfit);
		
		lblProfitIncrease = new JLabel("(+2.31%)");
		lblProfitIncrease.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfitIncrease.setForeground(Color.GREEN);
		lblProfitIncrease.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblProfitIncrease.setBounds(0, 100, 220, 40);
		panelProfitMargin.add(lblProfitIncrease);
		
		panelSalesAndProfitTrend = new JPanel();
		panelSalesAndProfitTrend.setBackground(Color.WHITE);
		panelSalesAndProfitTrend.setBounds(0, 160, 680, 215);
		panelSales.add(panelSalesAndProfitTrend);
		panelSalesAndProfitTrend.setLayout(null);
		
		SalesDashboard salesDashboard = new SalesDashboard();
		
		ChartPanel salesProfitTrend = salesDashboard.salesTrend();
		panelSalesAndProfitTrend.add(salesProfitTrend);
		
		panelTopTenProducts = new JPanel();
		panelTopTenProducts.setBackground(Color.WHITE);
		panelTopTenProducts.setBounds(0, 385, 680, 215);
		panelSales.add(panelTopTenProducts);
		panelTopTenProducts.setLayout(null);
		
		ChartPanel productsTrend = salesDashboard.productsTrend();
		panelTopTenProducts.add(productsTrend);
		
		lblTopTenProductsBySales = new JLabel("TOP 10 PRODUCTS BY SALES");
		lblTopTenProductsBySales.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopTenProductsBySales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTopTenProductsBySales.setBounds(0, 10, 680, 40);
		panelTopTenProducts.add(lblTopTenProductsBySales);
		
		panelSalesPerCountry = new JPanel();
		panelSalesPerCountry.setBackground(Color.WHITE);
		panelSalesPerCountry.setBounds(690, 0, 400, 295);
		panelSales.add(panelSalesPerCountry);
		panelSalesPerCountry.setLayout(null);
		
		ChartPanel salesVolume = salesDashboard.salesVolume();
		panelSalesPerCountry.add(salesVolume);
		
		panelTopTenStoresBySales = new JPanel();
		panelTopTenStoresBySales.setBackground(Color.WHITE);
		panelTopTenStoresBySales.setBounds(690, 305, 400, 295);
		panelSales.add(panelTopTenStoresBySales);
		panelTopTenStoresBySales.setLayout(null);
		
		lblTopFifteenStoresBySales = new JLabel("TOP 15 STORES BY SALES");
		lblTopFifteenStoresBySales.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopFifteenStoresBySales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblTopFifteenStoresBySales.setBounds(0, 10, 400, 40);
		panelTopTenStoresBySales.add(lblTopFifteenStoresBySales);
		
		scrollPaneT10SBS = new JScrollPane();
		scrollPaneT10SBS.setBounds(10, 50, 380, 230);
		panelTopTenStoresBySales.add(scrollPaneT10SBS);
			
		tableT10SBS = new JTable();
		scrollPaneT10SBS.setViewportView(tableT10SBS);
		DefaultTableModel tableModelT20SBS = new DefaultTableModel(
	            new Object[][] {},
	            new String[] { "Store", "Region", "Revenue ($)" }  
	        ){
            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make the table uneditable
            }
        };
		tableT10SBS.setModel(tableModelT20SBS);
		tableT10SBS.setFont(new Font("Poppins", Font.PLAIN, 9));
		changeTableHeaderColor(tableT10SBS, 9);
		
		SalesMongoDriver.displayTopTenStores(tableModelT20SBS);
		
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
		lblTotalActive.setBounds(0, 10, 220, 40);
		panelTotalActiveCustomers.add(lblTotalActive);
		
		lblNumberOfActiveCustomers = new JLabel("240M");
		lblNumberOfActiveCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfActiveCustomers.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblNumberOfActiveCustomers.setBounds(0, 70, 220, 60);
		panelTotalActiveCustomers.add(lblNumberOfActiveCustomers);
					
		lblActiveCustomers = new JLabel("CUSTOMERS");
		lblActiveCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveCustomers.setFont(new Font("Poppins", Font.BOLD, 20));
		lblActiveCustomers.setBounds(0, 30, 220, 40);
		panelTotalActiveCustomers.add(lblActiveCustomers);
		
		panelTotalNew = new JPanel();
		panelTotalNew.setLayout(null);
		panelTotalNew.setBackground(Color.WHITE);
		panelTotalNew.setBounds(230, 0, 220, 150);
		panelCustomer.add(panelTotalNew);
		
		lblTotalNew = new JLabel("TOTAL NEW");
		lblTotalNew.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNew.setFont(new Font("Poppins", Font.BOLD, 20));
		lblTotalNew.setBounds(0, 0, 220, 40);
		panelTotalNew.add(lblTotalNew);
		
		lblNumberOfNewCustomers = new JLabel("240M");
		lblNumberOfNewCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfNewCustomers.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblNumberOfNewCustomers.setBounds(0, 55, 220, 60);
		panelTotalNew.add(lblNumberOfNewCustomers);
		
		lblNewPercentage = new JLabel("");
		lblNewPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPercentage.setForeground(Color.GREEN);
		lblNewPercentage.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNewPercentage.setBounds(0, 105, 220, 40);
		panelTotalNew.add(lblNewPercentage);
		
		lblCustomers = new JLabel("CUSTOMERS");
		lblCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers.setFont(new Font("Poppins", Font.BOLD, 20));
		lblCustomers.setBounds(0, 20, 220, 40);
		panelTotalNew.add(lblCustomers);
		
		panelCustomerGrowth = new JPanel();
		panelCustomerGrowth.setLayout(null);
		panelCustomerGrowth.setBackground(Color.WHITE);
		panelCustomerGrowth.setBounds(460, 0, 220, 150);
		panelCustomer.add(panelCustomerGrowth);
		
		lblCustomerGrowth = new JLabel("CUSTOMER");
		lblCustomerGrowth.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerGrowth.setFont(new Font("Poppins", Font.BOLD, 20));
		lblCustomerGrowth.setBounds(0, 10, 220, 40);
		panelCustomerGrowth.add(lblCustomerGrowth);
		
		lblPercentageCustomerGrowth = new JLabel("");
		lblPercentageCustomerGrowth.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentageCustomerGrowth.setFont(new Font("Poppins", Font.PLAIN, 50));
		lblPercentageCustomerGrowth.setBounds(0, 70, 220, 60);
		panelCustomerGrowth.add(lblPercentageCustomerGrowth);
		
		lblActiveCustomers_2 = new JLabel("GROWTH");
		lblActiveCustomers_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveCustomers_2.setFont(new Font("Poppins", Font.BOLD, 20));
		lblActiveCustomers_2.setBounds(0, 30, 220, 40);
		panelCustomerGrowth.add(lblActiveCustomers_2);
		
		panelCustomerTrend = new JPanel();
		panelCustomerTrend.setLayout(null);
		panelCustomerTrend.setBackground(Color.WHITE);
		panelCustomerTrend.setBounds(0, 160, 680, 215);
		panelCustomer.add(panelCustomerTrend);
				
		panelCustomerSegmentationGraphs = new JPanel();
		panelCustomerSegmentationGraphs.setLayout(null);
		panelCustomerSegmentationGraphs.setBackground(Color.WHITE);
		panelCustomerSegmentationGraphs.setBounds(0, 387, 1100, 225);
		panelCustomer.add(panelCustomerSegmentationGraphs);
		
		panelCustomerVolumeByCountry = new JPanel();
		panelCustomerVolumeByCountry.setLayout(null);
		panelCustomerVolumeByCountry.setBackground(Color.WHITE);
		panelCustomerVolumeByCountry.setBounds(700, 0, 400, 374);
		panelCustomer.add(panelCustomerVolumeByCountry);
		
		lblCustomerVolumeByCountry = new JLabel("CUSTOMERS PER COUNTRY");
		lblCustomerVolumeByCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerVolumeByCountry.setFont(new Font("Poppins", Font.BOLD, 22));
		lblCustomerVolumeByCountry.setBounds(0, 10, 400, 40);
		panelCustomerVolumeByCountry.add(lblCustomerVolumeByCountry);
		
		scrollPaneCVBC = new JScrollPane();
		scrollPaneCVBC.setBounds(10, 50, 380, 310);
		panelCustomerVolumeByCountry.add(scrollPaneCVBC);
		
		tableCVBC = new JTable();
		scrollPaneCVBC.setViewportView(tableCVBC);
		tableCVBC.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Country", "All Customers", "New Customers", "Active Customers"
				}
		));
		tableCVBC.setFont(new Font("Poppins", Font.PLAIN, 10));
		tableCVBC.getTableHeader().setPreferredSize(new Dimension(0, 30));
		changeTableHeaderColor(tableCVBC, 9);
		
		DefaultTableModel customerPerRegion = customerDash.customerPerCountryTable();
		tableCVBC.setModel(customerPerRegion);
		
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
		lblStoreInformation.setHorizontalAlignment(SwingConstants.LEFT);
		lblStoreInformation.setFont(new Font("Poppins", Font.BOLD, 25));
		lblStoreInformation.setBounds(40, 15, 270, 40);
		panelStoreInformation.add(lblStoreInformation);
		
		JLabel lblStoreID = new JLabel("STORE ID:");
		lblStoreID.setFont(new Font("Poppins", Font.BOLD, 18));
		lblStoreID.setBounds(40, 70, 100, 30);
		panelStoreInformation.add(lblStoreID);
		
		lblStoreName = new JLabel("STORE:");
		lblStoreName.setFont(new Font("Poppins", Font.BOLD, 18));
		lblStoreName.setBounds(40, 100, 100, 30);
		panelStoreInformation.add(lblStoreName);
		
		lblStoreAddress = new JLabel("ADDRESS:");
		lblStoreAddress.setFont(new Font("Poppins", Font.BOLD, 18));
		lblStoreAddress.setBounds(40, 130, 100, 30);
		panelStoreInformation.add(lblStoreAddress);
		
		lblStoreCountry = new JLabel("COUNTRY:");
		lblStoreCountry.setFont(new Font("Poppins", Font.BOLD, 18));
		lblStoreCountry.setBounds(40, 160, 100, 30);
		panelStoreInformation.add(lblStoreCountry);
		
		lblStoreContactNumber = new JLabel("CONTACT NUMBER:");
		lblStoreContactNumber.setFont(new Font("Poppins", Font.BOLD, 18));
		lblStoreContactNumber.setBounds(40, 190, 180, 30);
		panelStoreInformation.add(lblStoreContactNumber);
		
		lblStoreType = new JLabel("TYPE:");
		lblStoreType.setFont(new Font("Poppins", Font.BOLD, 18));
		lblStoreType.setBounds(40, 220, 100, 30);
		panelStoreInformation.add(lblStoreType);
		
		lblStoreIDDetail = new JLabel("");
		lblStoreIDDetail.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblStoreIDDetail.setBounds(134, 70, 370, 30);
		panelStoreInformation.add(lblStoreIDDetail);
		
		lblStoreNameDetail = new JLabel("");
		lblStoreNameDetail.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblStoreNameDetail.setBounds(113, 100, 370, 30);
		panelStoreInformation.add(lblStoreNameDetail);
		
		lblStoreAddressDetail = new JLabel("");
		lblStoreAddressDetail.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblStoreAddressDetail.setBounds(134, 130, 370, 30);
		panelStoreInformation.add(lblStoreAddressDetail);
		
		lblStoreCountryDetail = new JLabel("");
		lblStoreCountryDetail.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblStoreCountryDetail.setBounds(140, 160, 370, 30);
		panelStoreInformation.add(lblStoreCountryDetail);
		
		lblStoreTypeDetail = new JLabel("");
		lblStoreTypeDetail.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblStoreTypeDetail.setBounds(93, 220, 370, 30);
		panelStoreInformation.add(lblStoreTypeDetail);
		
		lblStoreContactDetail = new JLabel("");
		lblStoreContactDetail.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblStoreContactDetail.setBounds(219, 190, 300, 30);
		panelStoreInformation.add(lblStoreContactDetail);
		
		JComboBox<String> comboBoxStores = new JComboBox<String>();
		comboBoxStores.addItem("");
		comboBoxStores.setSelectedIndex(0);
		SalesMongoDriver.populateStoreNames(comboBoxStores);
		comboBoxStores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBoxStores.getSelectedItem();
                if (selectedItem != null) {
                	SalesMongoDriver.retrieveAndDisplayStoreInfo(selectedItem, lblStoreIDDetail, lblStoreNameDetail, lblStoreAddressDetail, lblStoreCountryDetail, lblStoreContactDetail, lblStoreTypeDetail);
                	
                	ChartPanel salesProfitTrend2;
					try {
						salesProfitTrend2 = salesDashboard.StoreTopProducts(lblStoreIDDetail.getText().toString());
						panelTopSalesOfStore.add(salesProfitTrend2);
						panelTopSalesOfStore.removeAll(); // Clear existing chart panel contents
			            panelTopSalesOfStore.add(salesProfitTrend2);
			            panelTopSalesOfStore.revalidate(); // Refresh the panel
			            panelTopSalesOfStore.repaint(); // Repaint the panel
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	
                	DefaultTableModel tableModelTPH = new DefaultTableModel(
            	            new Object[][] {},
            	            new String[] { "Purchase ID", "Customer ID", "Date and Time", "Total Spent"
            }  
            	        ){
                        /**
            				 * 
            				 */
            				private static final long serialVersionUID = 1L;

            			@Override
                        public boolean isCellEditable(int row, int column) {
                            return false; // Make the table uneditable
                        }
                    };
                    tablePurchaseHistory.setModel(tableModelTPH);
                    SalesMongoDriver.retrieveAndDisplayStorepurchases(selectedItem, tableModelTPH);
                }
			}
		});
		comboBoxStores.setBounds(320, 20, 190, 25);
		panelStoreInformation.add(comboBoxStores);
		
		panelTopSalesOfStore = new JPanel();
		panelTopSalesOfStore.setLayout(null);
		panelTopSalesOfStore.setBackground(Color.WHITE);
		panelTopSalesOfStore.setBounds(560, 0, 540, 300);
		panelStoreSummary.add(panelTopSalesOfStore);
		
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
		
		scrollPanePurchaseHistory = new JScrollPane();
		scrollPanePurchaseHistory.setBounds(10, 50, 1080, 250);
		panelPurchaseHistoryTable.add(scrollPanePurchaseHistory);
		
		tablePurchaseHistory = new JTable();
		scrollPanePurchaseHistory.setViewportView(tablePurchaseHistory);
		tablePurchaseHistory.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Purchase ID", "Store ID", "Customer ID", "Date", "Time", "Total Spent"
			}
		));
		tablePurchaseHistory.setFont(new Font("Poppins", Font.PLAIN, 9));
		changeTableHeaderColor(tablePurchaseHistory, 9);
		
		panelStoresSales = new JPanel();
		panelStoresSales.setBackground(new Color(255, 255, 255));
		layeredPaneStores.add(panelStoresSales, "name_1311043919383900");
		panelStoresSales.setLayout(null);
		
		lblStoresBySales = new JLabel("STORES BY SALES");
		lblStoresBySales.setHorizontalAlignment(SwingConstants.LEFT);
		lblStoresBySales.setFont(new Font("Poppins", Font.BOLD, 25));
		lblStoresBySales.setBounds(10, 10, 540, 40);
		panelStoresSales.add(lblStoresBySales);
		
		scrollPaneOverallSBS = new JScrollPane();
		scrollPaneOverallSBS.setBounds(10, 50, 1080, 565);
		panelStoresSales.add(scrollPaneOverallSBS);
		
		tableOverallSBS = new JTable();
		scrollPaneOverallSBS.setViewportView(tableOverallSBS);
		tableOverallSBS.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Store", "Sales Volume", "Revenue", "Profit", "Profit Margin"
			}
		));
		tableOverallSBS.setFont(new Font("Poppins", Font.PLAIN, 12));
		changeTableHeaderColor(tableOverallSBS, 12);
		
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
		
		scrollPaneOverallPurchaseHistory = new JScrollPane();
		scrollPaneOverallPurchaseHistory.setBounds(10, 50, 1080, 565);
		panelStoresSales_1.add(scrollPaneOverallPurchaseHistory);
		
		tablePurchaseHistoryOverall = new JTable();
		scrollPaneOverallPurchaseHistory.setViewportView(tablePurchaseHistoryOverall);
		tablePurchaseHistoryOverall.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Purchase ID", "Store ID", "Customer ID", "Date and Time", "Total Spent"
			}
		));
		tablePurchaseHistoryOverall.setFont(new Font("Poppins", Font.PLAIN, 12));
		changeTableHeaderColor(tablePurchaseHistoryOverall, 12);
		
		DefaultTableModel purchase = purchaseHistory.purchaseHistory();
		tablePurchaseHistoryOverall.setModel(purchase);
		
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
		
		demoPanel = new JPanel();
		demoPanel.setBackground(Color.WHITE);
		demoPanel.setBounds(22, 24, 534, 285);
		panelCustomerSegmentation.add(demoPanel);
		demoPanel.setLayout(null);
		
		geoPanel = new JPanel();
		geoPanel.setBackground(Color.WHITE);
		geoPanel.setBounds(570, 24, 534, 285);
		panelCustomerSegmentation.add(geoPanel);
		geoPanel.setLayout(null);
		
		transPanel = new JPanel();
		transPanel.setBackground(Color.WHITE);
		transPanel.setBounds(22, 320, 1082, 318);
		panelCustomerSegmentation.add(transPanel);
		transPanel.setLayout(null);
		
		CustomerSegmentation customerSegment = new CustomerSegmentation();
		
		ChartPanel DemographicPanel2 = customerSegment.demographicChart();
		demoPanel.add(DemographicPanel2);
		
		ChartPanel GeographicPanel2 = customerSegment.geographicChart();
		geoPanel.add(GeographicPanel2);
		
		ChartPanel TransactionalPanel2 = customerSegment.transactionalChart();
		transPanel.add(TransactionalPanel2);
		
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
		
		DemographicSegmentation demog = new DemographicSegmentation();
		
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
		changeTableHeaderColor(tableDemoSegmentation, 12);

		JComboBox cmbFinder = new JComboBox();
		cmbFinder.addItem("");
		cmbFinder.addItem("A-Z");
		cmbFinder.addItem("Z-A");
		cmbFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) cmbFinder.getSelectedItem();
				if (selectedItem != null) {
					 if (selectedItem.equals("A-Z")) {
						 try {
							tableDemoSegmentation.setModel(demog.fetchData(true));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 }
					 else {
						 try {
							tableDemoSegmentation.setModel(demog.fetchData(false));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 }
				}
			}
		});
		cmbFinder.setFont(new Font("Poppins", Font.PLAIN, 12));
		cmbFinder.setName("");
		cmbFinder.setBounds(963, 17, 105, 17);
		panelDemographic.add(cmbFinder);
		
		panelGeographics = new JPanel();
		layeredPane.add(panelGeographics, "name_1237653177687600");
		panelGeographics.setLayout(null);
		
		JLabel lblCustomerSegment3 = new JLabel("Customer Segmentation");
		lblCustomerSegment3.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment3.setBounds(35, 36, 609, 56);
		panelGeographics.add(lblCustomerSegment3);
		
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
		
		GeographicSegmentation geoSegment = new GeographicSegmentation();
		
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
			
		changeTableHeaderColor(tableGeographicSegmentation, 12);

	    scrollPaneGeographicSegmentation.setVisible(true);
		
		JComboBox cmbAscDesc = new JComboBox();
		cmbAscDesc.addItem("");
		cmbAscDesc.addItem("A-Z");
		cmbAscDesc.addItem("Z-A");
		cmbAscDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) cmbAscDesc.getSelectedItem();
				if (selectedItem != null) {
					 if (selectedItem.equals("A-Z")) {
						 try {
							tableGeographicSegmentation.setModel(geoSegment.fetchData(true));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 }
					 else {
						 try {
							tableGeographicSegmentation.setModel(geoSegment.fetchData(false));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 }
				}
			}
		});
		cmbAscDesc.setFont(new Font("Poppins", Font.PLAIN, 12));
		cmbAscDesc.setBounds(963, 17, 105, 17);
		panelGeographicSegmentation.add(cmbAscDesc);
		
		panelTransactionHistory = new JPanel();
		layeredPane.add(panelTransactionHistory, "name_1237656709540000");
		panelTransactionHistory.setLayout(null);
		
		JLabel lblCustomerSegment4 = new JLabel("Customer Segmentation");
		lblCustomerSegment4.setFont(new Font("Poppins", Font.BOLD, 40));
		lblCustomerSegment4.setBounds(35, 36, 609, 56);
		panelTransactionHistory.add(lblCustomerSegment4);
		
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
		
		JComboBox cmbAscDesc_1 = new JComboBox();
		cmbAscDesc_1.addItem("");
		cmbAscDesc_1.addItem("ascending");
		cmbAscDesc_1.addItem("descending");
		cmbAscDesc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) cmbAscDesc_1.getSelectedItem();
				if (selectedItem != null) {
					 if (selectedItem.equals("ascending")) {
						 tableTransactionalSegmentation.setModel(transacSegment.transactional(true));
					 }
					 else {
						 tableTransactionalSegmentation.setModel(transacSegment.transactional(false));
					 }
				}
			}
		});
		cmbAscDesc_1.setName("");
		cmbAscDesc_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		cmbAscDesc_1.setBounds(963, 17, 105, 17);
		panelTransactionalSegmentation.add(cmbAscDesc_1);
		
		
		scrollPaneTransactionalSegmentation = new JScrollPane();
		scrollPaneTransactionalSegmentation.setBounds(29, 38, 1023, 552);
		panelTransactionalSegmentation.add(scrollPaneTransactionalSegmentation);
		
		 tableTransactionalSegmentation = new JTable();
	     tableTransactionalSegmentation.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
	     tableTransactionalSegmentation.setModel(new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Customer ID", "Customer Name", "Total Number of Transactions", "Total Number of Unit Purchased", "Total Amount of Purchases"
	            }
	        ));
	     scrollPaneTransactionalSegmentation.setViewportView(tableTransactionalSegmentation);

	     changeTableHeaderColor(tableTransactionalSegmentation, 12);

	     scrollPaneTransactionalSegmentation.setViewportView(tableTransactionalSegmentation);
	     scrollPaneTransactionalSegmentation.setVisible(true);
	         
	     
	     // All methods for Customer Dashboard and Customer Segmentation
	     
			int totalActive = customerDash.totalActive();
			lblNumberOfActiveCustomers.setText(Integer.toString(totalActive));	
			
			int totalNew = customerDash.totalNew2024();
			lblNumberOfNewCustomers.setText(Integer.toString(totalNew));
			
			double newPercentage = CustomerDashboard.computeIncrease(customerDash.totalNew2024(), customerDash.totalNew2023());
			lblNewPercentage.setText("(" + String.format("%.2f", newPercentage) + "%)");
			if (newPercentage < 0) {
				lblNewPercentage.setForeground(Color.RED);
			} else {
				lblNewPercentage.setForeground(Color.GREEN);
			}
			
			double customerGrowth = CustomerDashboard.customerGrowth();
			lblPercentageCustomerGrowth.setText(String.format("%.2f", customerGrowth) + "%");
			
			if (customerGrowth < 0) {
				lblPercentageCustomerGrowth.setForeground(Color.RED);
			} else {
				lblPercentageCustomerGrowth.setForeground(Color.BLACK);
			}
			
			ChartPanel NewCurrentTrend = customerDash.customerTrend();
			panelCustomerTrend.add(NewCurrentTrend);
			
			ChartPanel DemographicPanel = customerDash.demographicChart();
			panelCustomerSegmentationGraphs.add(DemographicPanel);
			
			ChartPanel GeographicPanel = customerDash.geographicChart();
			panelCustomerSegmentationGraphs.add(GeographicPanel);
			
			ChartPanel TransactionalPanel = customerDash.transactionalChart();
			panelCustomerSegmentationGraphs.add(TransactionalPanel);
			
			SalesMainBackend.TotalSalesDisplay(lblTotalSalesAmount, lblSalesPercentIncrease);
			SalesMainBackend.TotalOrdersDisplay(lblSumOrders, lblOrderIncrease);
			SalesMainBackend.TotalSalesDisplay(lblSumProfit, lblProfitIncrease);
			SalesMongoDriver.displayTopTenStores(tableModelT20SBS);

	}
	      
	public void changeTableHeaderColor (JTable table, int fontSize) {
		JTableHeader tableHeaderThree = table.getTableHeader();
        tableHeaderThree.setFont(new Font("Poppins", Font.BOLD, fontSize));
        tableHeaderThree.setBackground(Color.BLACK);
        tableHeaderThree.setForeground(Color.WHITE);
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
