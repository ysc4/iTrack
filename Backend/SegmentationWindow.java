	panelCustomerSegmentation = new JPanel();
		layeredCustomerSegmentation.add(panelCustomerSegmentation, "name_9606951641900");
		panelCustomerSegmentation.setLayout(null);

		panel_DemographicSegmentation = new JPanel();
		panel_DemographicSegmentation.setBackground(Color.WHITE);
		panel_DemographicSegmentation.setBounds(22, 24, 534, 285);
		panelCustomerSegmentation.add(panel_DemographicSegmentation);
		panel_DemographicSegmentation.setLayout(null);

		JLabel lbl_DemographicSegmentation = new JLabel("DEMOGRAPHIC SEGMENTATION");
		lbl_DemographicSegmentation.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_DemographicSegmentation.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DemographicSegmentation.setFont(new Font("Poppins", Font.BOLD, 20));
		lbl_DemographicSegmentation.setBounds(91, 11, 337, 24);
		panel_DemographicSegmentation.add(lbl_DemographicSegmentation);

		ChartPanel demographicChartPanel = demographicChart();
		demographicChartPanel.setBounds(92, 46, 350, 210); // Center below the label
		panel_DemographicSegmentation.add(demographicChartPanel);

		panel_GeographicSegmentation = new JPanel();
		panel_GeographicSegmentation.setBackground(Color.WHITE);
		panel_GeographicSegmentation.setBounds(570, 24, 534, 285);
		panelCustomerSegmentation.add(panel_GeographicSegmentation);
		panel_GeographicSegmentation.setLayout(null);

		JLabel lbl_GeographicSegmentation = new JLabel("GEOGRAPHIC SEGMENTATION");
		lbl_GeographicSegmentation.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_GeographicSegmentation.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_GeographicSegmentation.setFont(new Font("Poppins", Font.BOLD, 20));
		lbl_GeographicSegmentation.setBounds(125, 11, 295, 24);
		panel_GeographicSegmentation.add(lbl_GeographicSegmentation);

		ChartPanel geographicChartPanel = geographicChart();
		geographicChartPanel.setBounds(92, 46, 350, 210); // Center below the label
		panel_GeographicSegmentation.add(geographicChartPanel);

		panel_TransactionalSegmentation = new JPanel();
		panel_TransactionalSegmentation.setBackground(Color.WHITE);
		panel_TransactionalSegmentation.setBounds(22, 320, 1082, 318);
		panelCustomerSegmentation.add(panel_TransactionalSegmentation);
		panel_TransactionalSegmentation.setLayout(null);

		JLabel lbl_TransactionalSegmentation = new JLabel("TRANSACTIONAL SEGMENTATION");
		lbl_TransactionalSegmentation.setFont(new Font("Poppins", Font.BOLD, 20));
		lbl_TransactionalSegmentation.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_TransactionalSegmentation.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TransactionalSegmentation.setBounds(358, 11, 363, 30);
		panel_TransactionalSegmentation.add(lbl_TransactionalSegmentation);

		ChartPanel transactionalChartPanel = transactionalChart();
		transactionalChartPanel.setBounds(366, 51, 350, 210); // Center below the label
		panel_TransactionalSegmentation.add(transactionalChartPanel);
		public ChartPanel demographicChart() {
	    DefaultCategoryDataset demographicData = new DefaultCategoryDataset();
	    addValue(demographicData, 20, "Female", "<18");
	    addValue(demographicData, 50, "Female", "18-28");
	    addValue(demographicData, 55, "Female", "29-38");
	    addValue(demographicData, 40, "Female", "39-48");
	    addValue(demographicData, 90, "Female", "49-58");
	    addValue(demographicData, 15, "Female", ">59");
	    addValue(demographicData, 35, "Male", "<18");
	    addValue(demographicData, 60, "Male", "18-28");
	    addValue(demographicData, 65, "Male", "29-38");
	    addValue(demographicData, 70, "Male", "39-48");
	    addValue(demographicData, 25, "Male", "49-58");
	    addValue(demographicData, 10, "Male", ">59");

	    JFreeChart chart = createChart(null, "AGE & SEX", "FREQUENCY", demographicData);

	    ChartPanel demographicPanel = new ChartPanel(chart);
	    demographicPanel.setPreferredSize(new Dimension(350, 190));
	    demographicPanel.setBackground(new Color(255, 255, 255));

	    return demographicPanel;
	}

	public ChartPanel geographicChart() {
	    DefaultCategoryDataset geographicData = new DefaultCategoryDataset();
	    addValue(geographicData, 20, "New", "Asia");
	    addValue(geographicData, 50, "New", "Australia");
	    addValue(geographicData, 55, "New", "Europe");
	    addValue(geographicData, 40, "New", "Canada");
	    addValue(geographicData, 90, "New", "USA");
	    addValue(geographicData, 35, "Current", "Asia");
	    addValue(geographicData, 60, "Current", "Australia");
	    addValue(geographicData, 65, "Current", "Europe");
	    addValue(geographicData, 70, "Current", "Canada");
	    addValue(geographicData, 25, "Current", "USA");

	    JFreeChart chart = createChart(null, "COUNTRIES", "FREQUENCY", geographicData);

	    ChartPanel geographicPanel = new ChartPanel(chart);
	    geographicPanel.setPreferredSize(new Dimension(350, 190));
	    geographicPanel.setBackground(new Color(255, 255, 255));

	    return geographicPanel;
	}

	public ChartPanel transactionalChart() {
	    DefaultCategoryDataset transactionalData = new DefaultCategoryDataset();
	    addValue(transactionalData, 20, "Customers", "iPhone");
	    addValue(transactionalData, 50, "Customers", "iPad");
	    addValue(transactionalData, 55, "Customers", "Watch");
	    addValue(transactionalData, 40, "Customers", "Macbook");
	    addValue(transactionalData, 90, "Customers", "TV & Home");
	    addValue(transactionalData, 15, "Customers", "AirPods");
	    addValue(transactionalData, 65, "Customers", "Vision");

	    JFreeChart chart = createChart(null, "PRODUCTS", "PURCHASES", transactionalData);

	    ChartPanel transactionalPanel = new ChartPanel(chart);
	    transactionalPanel.setPreferredSize(new Dimension(350, 190));
	    transactionalPanel.setBackground(new Color(255, 255, 255));

	    return transactionalPanel;
	}

	private void addValue(DefaultCategoryDataset dataset, double value, String categ, String column) {
	    dataset.addValue(value, categ, column);
	}

	private JFreeChart createChart(String title, String Xaxis, String Yaxis, DefaultCategoryDataset dataset) {
	    JFreeChart chart = ChartFactory.createBarChart(title, Xaxis, Yaxis, dataset, PlotOrientation.VERTICAL, true, true, false);
	    chart.setBackgroundPaint(Color.white);
	    if (title != null) {
	        chart.setTitle(new TextTitle(title, new Font("Poppins", Font.BOLD, 16)));
	    }
	    chart.getLegend().setPosition(RectangleEdge.RIGHT);

	    CategoryPlot plot = chart.getCategoryPlot();
	    plot.setBackgroundPaint(Color.lightGray);
	    plot.setDomainGridlinePaint(Color.white);
	    plot.setRangeGridlinePaint(Color.white);
	    plot.setInsets(new RectangleInsets(2, 2, 2, 2));
	    plot.getDomainAxis().setLowerMargin(1);
	    plot.getDomainAxis().setUpperMargin(1);

	    CategoryAxis domainAxis = plot.getDomainAxis();
	    domainAxis.setTickLabelFont(new Font("Poppins", Font.PLAIN, 10));
	    domainAxis.setTickLabelInsets(new RectangleInsets(0.5, 0.5, 0.5, 0.5));
	    domainAxis.setLowerMargin(0.01);
	    domainAxis.setUpperMargin(0.01);
	    domainAxis.setLabelFont(domainAxis.getLabelFont().deriveFont(14f));

	    ValueAxis rangeAxis = plot.getRangeAxis();
	    rangeAxis.setTickLabelFont(new Font("Poppins", Font.BOLD, 12));

	    BarRenderer renderer = (BarRenderer) plot.getRenderer();
	    renderer.setSeriesPaint(0, Color.black);
	    renderer.setSeriesPaint(1, Color.DARK_GRAY);

	    LegendTitle legend = chart.getLegend();
	    legend.setItemFont(new Font("Poppins", Font.ITALIC, 10));

	    CategoryItemRenderer rendererCateg = plot.getRenderer();
	    rendererCateg.setDefaultItemLabelFont(new Font("Poppins", Font.PLAIN, 10));

	    return chart;
	}
}
