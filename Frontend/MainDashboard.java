package iTrack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		lblAppName.setBounds(76, 10, 112, 72);
		panelDashboardMenu.add(lblAppName);
		
		JLabel lblAppleLogo = new JLabel("logo");
		lblAppleLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppleLogo.setForeground(new Color(255, 255, 255));
		lblAppleLogo.setBounds(10, 10, 68, 72);
		panelDashboardMenu.add(lblAppleLogo);
		
		JPanel panelHomeMenu = new JPanel();
		panelHomeMenu.setBounds(0, 92, 198, 35);
		panelDashboardMenu.add(panelHomeMenu);
		panelHomeMenu.setLayout(null);
		
		JLabel lblDashHome = new JLabel("Home");
		lblDashHome.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashHome.setBounds(53, 0, 145, 38);
		panelHomeMenu.add(lblDashHome);
		
		JLabel lblHomeLogo = new JLabel("L");
		lblHomeLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeLogo.setBounds(5, 0, 35, 35);
		panelHomeMenu.add(lblHomeLogo);
		
		JPanel panelStoreMenu = new JPanel();
		panelStoreMenu.setBackground(new Color(0, 0, 0));
		panelStoreMenu.setLayout(null);
		panelStoreMenu.setBounds(0, 127, 198, 35);
		panelDashboardMenu.add(panelStoreMenu);
		
		JLabel lblDashStore = new JLabel("Stores");
		lblDashStore.setForeground(new Color(255, 255, 255));
		lblDashStore.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashStore.setBounds(53, 0, 145, 38);
		panelStoreMenu.add(lblDashStore);
		
		JLabel lblStoreLogo = new JLabel("L");
		lblStoreLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreLogo.setBounds(5, 0, 35, 35);
		panelStoreMenu.add(lblStoreLogo);
		
		JPanel panelPurchaseMenu = new JPanel();
		panelPurchaseMenu.setBackground(new Color(0, 0, 0));
		panelPurchaseMenu.setLayout(null);
		panelPurchaseMenu.setBounds(0, 162, 198, 35);
		panelDashboardMenu.add(panelPurchaseMenu);
		
		JLabel lblPurchaseHistory = new JLabel("Purchase History");
		lblPurchaseHistory.setForeground(new Color(255, 255, 255));
		lblPurchaseHistory.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblPurchaseHistory.setBounds(53, 0, 145, 38);
		panelPurchaseMenu.add(lblPurchaseHistory);
		
		JLabel lblPurchaseLogo = new JLabel("L");
		lblPurchaseLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseLogo.setBounds(5, 0, 35, 35);
		panelPurchaseMenu.add(lblPurchaseLogo);
		
		JPanel panelSegmentMenu = new JPanel();
		panelSegmentMenu.setBackground(new Color(0, 0, 0));
		panelSegmentMenu.setLayout(null);
		panelSegmentMenu.setBounds(0, 197, 198, 35);
		panelDashboardMenu.add(panelSegmentMenu);
		
		JLabel lblDashSegment = new JLabel("Segmentation");
		lblDashSegment.setForeground(new Color(255, 255, 255));
		lblDashSegment.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashSegment.setBounds(53, 0, 145, 38);
		panelSegmentMenu.add(lblDashSegment);
		
		JLabel lblSegmentLogo = new JLabel("L");
		lblSegmentLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegmentLogo.setBounds(5, 0, 35, 35);
		panelSegmentMenu.add(lblSegmentLogo);
		
		JPanel panelDemographicsMenu = new JPanel();
		panelDemographicsMenu.setBackground(new Color(0, 0, 0));
		panelDemographicsMenu.setLayout(null);
		panelDemographicsMenu.setBounds(0, 232, 198, 35);
		panelDashboardMenu.add(panelDemographicsMenu);
		
		JLabel lblDashDemographics = new JLabel("Demographics");
		lblDashDemographics.setForeground(new Color(255, 255, 255));
		lblDashDemographics.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashDemographics.setBounds(53, 0, 145, 38);
		panelDemographicsMenu.add(lblDashDemographics);
		
		JLabel lblDemographicsLogo = new JLabel("L");
		lblDemographicsLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDemographicsLogo.setBounds(5, 0, 35, 35);
		panelDemographicsMenu.add(lblDemographicsLogo);
		
		JPanel panelGeographicMenu = new JPanel();
		panelGeographicMenu.setBackground(new Color(0, 0, 0));
		panelGeographicMenu.setLayout(null);
		panelGeographicMenu.setBounds(0, 267, 198, 35);
		panelDashboardMenu.add(panelGeographicMenu);
		
		JLabel lblDashGeographic = new JLabel("Geographic");
		lblDashGeographic.setForeground(new Color(255, 255, 255));
		lblDashGeographic.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashGeographic.setBounds(53, 0, 145, 38);
		panelGeographicMenu.add(lblDashGeographic);
		
		JLabel lblGeographicLogo = new JLabel("L");
		lblGeographicLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeographicLogo.setBounds(5, 0, 35, 35);
		panelGeographicMenu.add(lblGeographicLogo);
		
		JPanel panelTransactionMenu = new JPanel();
		panelTransactionMenu.setBackground(new Color(0, 0, 0));
		panelTransactionMenu.setLayout(null);
		panelTransactionMenu.setBounds(0, 302, 198, 35);
		panelDashboardMenu.add(panelTransactionMenu);
		
		JLabel lblDashTransaction = new JLabel("Transaction History");
		lblDashTransaction.setForeground(new Color(255, 255, 255));
		lblDashTransaction.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblDashTransaction.setBounds(53, 0, 145, 38);
		panelTransactionMenu.add(lblDashTransaction);
		
		JLabel lblTransactionLogo = new JLabel("L");
		lblTransactionLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionLogo.setBounds(5, 0, 35, 35);
		panelTransactionMenu.add(lblTransactionLogo);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(198, 0, 1153, 755);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelDashboard = new JPanel();
		layeredPane.add(panelDashboard, "name_1237592797291700");
		panelDashboard.setLayout(null);
		
		JLabel lblDashboardTitle = new JLabel("Dashboard");
		lblDashboardTitle.setFont(new Font("Poppins", Font.BOLD, 40));
		lblDashboardTitle.setBounds(35, 36, 263, 56);
		panelDashboard.add(lblDashboardTitle);
		
		JPanel panelStores = new JPanel();
		layeredPane.add(panelStores, "name_1237607726469500");
		panelStores.setLayout(null);
		
		JPanel panelPurchaseHistory = new JPanel();
		layeredPane.add(panelPurchaseHistory, "name_1237611265977400");
		panelPurchaseHistory.setLayout(null);
		
		JPanel panelSegmentation = new JPanel();
		layeredPane.add(panelSegmentation, "name_1237637193320800");
		panelSegmentation.setLayout(null);
		
		JPanel panelDemographics = new JPanel();
		layeredPane.add(panelDemographics, "name_1237649696174600");
		panelDemographics.setLayout(null);
		
		JPanel panelGeographics = new JPanel();
		layeredPane.add(panelGeographics, "name_1237653177687600");
		panelGeographics.setLayout(null);
		
		JPanel panelTransactionHistory = new JPanel();
		layeredPane.add(panelTransactionHistory, "name_1237656709540000");
		panelTransactionHistory.setLayout(null);
	}
}
