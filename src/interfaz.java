import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class interfaz extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/**
	 */
	private JPanel contentPane;
	private JTable table;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private JLabel lblX_1;
	private JLabel lblX_2;
	private JLabel lblX_3;
	private JLabel lblX_4;
	private JLabel lblCalcular;
	private JLabel lblResultado;
	private JLabel label_1;
	private JTable table_1;
	private JTable table_2;
	private JLabel lblW_1;
	private JLabel label_5;
	private JLabel lblW_2;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel lblW_3;
	private JLabel label_10;
	private JLabel lblTeta;
	private JPanel panel_3;
	private JLabel lblMixdor;

	/**
	 * Launch the application.
	 */
	
	
	static int compuerta;
	
	
	public static void main(String[] args) {
		
		int entradas=5;
		int combin = (int) Math.pow(2, entradas);
		System.out.println(combin);
		int [][] MatrizCombinaciones= new int [combin][entradas];
		int [][] D = new int [combin][1];
		double [][] w = new double [1][6];
		double n=0.25,o=0;
		double F = 0;
		
		
		llenar(MatrizCombinaciones);
		
		
		//comprobar_pesos(MatrizCombinaciones,combin,entradas,w,Ai,o,n,D,F);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz(MatrizCombinaciones, combin, entradas, w, o, n, D, F);
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
	public interfaz(int MatrizCombinaciones[][],int combin,int entradas,double w[][],double o,double n,int D[][],double F) {
		setResizable(false);
		setTitle("Perceptron compuertas logicas (5 entradas)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Calcular", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(227, 11, 170, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblX = new JLabel("X1");
		lblX.setBounds(10, 56, 46, 14);
		panel.add(lblX);
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setEnabled(false);
		
		lblX_1 = new JLabel("X2");
		lblX_1.setBounds(10, 87, 46, 14);
		panel.add(lblX_1);
		lblX_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX_1.setEnabled(false);
		
		lblX_2 = new JLabel("X3");
		lblX_2.setBounds(10, 118, 46, 14);
		panel.add(lblX_2);
		lblX_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX_2.setEnabled(false);
		
		lblX_3 = new JLabel("X4");
		lblX_3.setBounds(10, 149, 46, 14);
		panel.add(lblX_3);
		lblX_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX_3.setEnabled(false);
		
		lblX_4 = new JLabel("X5");
		lblX_4.setBounds(10, 180, 46, 14);
		panel.add(lblX_4);
		lblX_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX_4.setEnabled(false);
		
		textField_4 = new JTextField();
		textField_4.setBounds(82, 177, 46, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setEnabled(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(82, 146, 46, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(82, 115, 46, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 84, 46, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(82, 53, 46, 20);
		panel.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		lblCalcular = new JLabel("Calcular");
		lblCalcular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcular.setFont(new Font("Candara", Font.BOLD, 18));
		lblCalcular.setBounds(39, 22, 89, 20);
		panel.add(lblCalcular);
		lblCalcular.setEnabled(false);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(20, 205, 62, 14);
		panel.add(lblResultado);
		lblResultado.setEnabled(false);
		
		label_1 = new JLabel("");
		label_1.setBackground(Color.BLACK);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(92, 205, 36, 14);
		panel.add(label_1);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(39, 223, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Combinaciones Posibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 207, 551);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 28, 145, 512);
		panel_1.add(table);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(1)},
				{new Integer(0), new Integer(0), new Integer(0), new Integer(1), new Integer(0)},
				{new Integer(0), new Integer(0), new Integer(0), new Integer(1), new Integer(1)},
				{new Integer(0), new Integer(0), new Integer(1), new Integer(0), new Integer(0)},
				{new Integer(0), new Integer(0), new Integer(1), new Integer(0), new Integer(1)},
				{new Integer(0), new Integer(0), new Integer(1), new Integer(1), new Integer(0)},
				{new Integer(0), new Integer(0), new Integer(1), new Integer(1), new Integer(1)},
				{new Integer(0), new Integer(1), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(0), new Integer(1), new Integer(0), new Integer(0), new Integer(1)},
				{new Integer(0), new Integer(1), new Integer(0), new Integer(1), new Integer(0)},
				{new Integer(0), new Integer(1), new Integer(0), new Integer(1), new Integer(1)},
				{new Integer(0), new Integer(1), new Integer(1), new Integer(0), new Integer(0)},
				{new Integer(0), new Integer(1), new Integer(1), new Integer(0), new Integer(1)},
				{new Integer(0), new Integer(1), new Integer(1), new Integer(1), new Integer(0)},
				{new Integer(0), new Integer(1), new Integer(1), new Integer(1), new Integer(1)},
				{new Integer(1), new Integer(0), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(1), new Integer(0), new Integer(0), new Integer(0), new Integer(1)},
				{new Integer(1), new Integer(0), new Integer(0), new Integer(1), new Integer(0)},
				{new Integer(1), new Integer(0), new Integer(0), new Integer(1), new Integer(1)},
				{new Integer(1), new Integer(0), new Integer(1), new Integer(0), new Integer(0)},
				{new Integer(1), new Integer(0), new Integer(1), new Integer(0), new Integer(1)},
				{new Integer(1), new Integer(0), new Integer(1), new Integer(1), new Integer(0)},
				{new Integer(1), new Integer(0), new Integer(1), new Integer(1), new Integer(1)},
				{new Integer(1), new Integer(1), new Integer(0), new Integer(0), new Integer(0)},
				{new Integer(1), new Integer(1), new Integer(0), new Integer(0), new Integer(1)},
				{new Integer(1), new Integer(1), new Integer(0), new Integer(1), new Integer(0)},
				{new Integer(1), new Integer(1), new Integer(0), new Integer(1), new Integer(1)},
				{new Integer(1), new Integer(1), new Integer(1), new Integer(0), new Integer(0)},
				{new Integer(1), new Integer(1), new Integer(1), new Integer(0), new Integer(1)},
				{new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(0)},
				{new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1)},
			},
			new String[] {
				"x1", "x2", "x3", "x4", "x5"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(22);
		table.getColumnModel().getColumn(1).setPreferredWidth(22);
		table.getColumnModel().getColumn(2).setPreferredWidth(22);
		table.getColumnModel().getColumn(3).setPreferredWidth(22);
		table.getColumnModel().getColumn(4).setPreferredWidth(22);
		
		
		
		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(0)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
				{new Integer(1)},
			},
			new String[] {
				"D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(23);
		table_2.setBounds(170, 28, 23, 512);
		panel_1.add(table_2);
		
		table_1 = new JTable();
		table_1.setBounds(170, 28, 23, 512);
		panel_1.add(table_1);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(0)},
				{new Integer(1)},
			},
			new String[] {
				"D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(23);
		table_1.setVisible(false);
		table_2.setVisible(false);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Entrenamiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(227, 279, 170, 245);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCompuerta_1 = new JLabel("Compuerta");
		lblCompuerta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompuerta_1.setFont(new Font("Candara", Font.BOLD, 18));
		lblCompuerta_1.setBounds(40, 25, 89, 20);
		panel_2.add(lblCompuerta_1);
		
		JButton btnNewButton_1 = new JButton("Entrenar");
		btnNewButton_1.setBounds(40, 89, 89, 23);
		panel_2.add(btnNewButton_1);
		
		
		
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Calcular F
				label_1.setText(String.valueOf(calcular(w,F)));
				
			}
			
		}
		);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AND", "OR"}));
		comboBox.setBounds(50, 56, 62, 20);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("W1");
		lblNewLabel.setBounds(10, 123, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(66, 123, 79, 14);
		panel_2.add(label);
		
		JLabel lblW = new JLabel("W2");
		lblW.setBounds(10, 143, 46, 14);
		panel_2.add(lblW);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(66, 143, 79, 14);
		panel_2.add(label_3);
		
		lblW_1 = new JLabel("W3");
		lblW_1.setBounds(10, 160, 46, 14);
		panel_2.add(lblW_1);
		
		label_5 = new JLabel("");
		label_5.setBounds(66, 160, 79, 14);
		panel_2.add(label_5);
		
		lblW_2 = new JLabel("W4");
		lblW_2.setBounds(10, 180, 46, 14);
		panel_2.add(lblW_2);
		
		label_7 = new JLabel("");
		label_7.setBounds(66, 180, 79, 14);
		panel_2.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setBounds(66, 199, 79, 14);
		panel_2.add(label_8);
		
		lblW_3 = new JLabel("W5");
		lblW_3.setBounds(10, 199, 46, 14);
		panel_2.add(lblW_3);
		
		label_10 = new JLabel("");
		label_10.setBounds(66, 220, 79, 14);
		panel_2.add(label_10);
		
		lblTeta = new JLabel("TETA");
		lblTeta.setBounds(10, 220, 46, 14);
		panel_2.add(lblTeta);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Autor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(227, 535, 170, 27);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblMixdor = new JLabel("Mixdor");
		lblMixdor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMixdor.setBounds(106, 11, 54, 14);
		panel_3.add(lblMixdor);
		
		comboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				//JComboBox comboBox = (JComboBox) evt.getSource();
				
				Object selected = comboBox.getSelectedItem();
				
				if(selected=="AND") {
					
					table_2.setVisible(false);
					table_1.setVisible(true);
					label_1.setText("");
					compuerta = 1;
					
					btnNewButton.setEnabled(false);
					textField.setEnabled(false);textField.setText("");
					textField_1.setEnabled(false);textField_1.setText("");
					textField_2.setEnabled(false);textField_2.setText("");
					textField_3.setEnabled(false);textField_3.setText("");
					textField_4.setEnabled(false);textField_4.setText("");
					lblCalcular.setEnabled(false);
					lblX.setEnabled(false);
					lblX_1.setEnabled(false);
					lblX_2.setEnabled(false);
					lblX_3.setEnabled(false);
					lblX_4.setEnabled(false);
					lblResultado.setEnabled(false);
					
					label.setText("");
					label_3.setText("");
					label_5.setText("");
					label_7.setText("");
					label_8.setText("");
					label_10.setText("");
					
					generar_aleatorios(w,o);
					
				}
				
				if(selected == "OR") {
					table_1.setVisible(false);
					table_2.setVisible(true);
					label_1.setText("");
					compuerta = 2;
					
					btnNewButton.setEnabled(false);
					textField.setEnabled(false);textField.setText("");
					textField_1.setEnabled(false);textField_1.setText("");
					textField_2.setEnabled(false);textField_2.setText("");
					textField_3.setEnabled(false);textField_3.setText("");
					textField_4.setEnabled(false);textField_4.setText("");
					lblCalcular.setEnabled(false);
					lblX.setEnabled(false);
					lblX_1.setEnabled(false);
					lblX_2.setEnabled(false);
					lblX_3.setEnabled(false);
					lblX_4.setEnabled(false);
					lblResultado.setEnabled(false);
					
					label.setText("");
					label_3.setText("");
					label_5.setText("");
					label_7.setText("");
					label_8.setText("");
					label_10.setText("");
					
					generar_aleatorios(w,o);
					
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setEnabled(true);
				textField.setEnabled(true);
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(true);
				textField_4.setEnabled(true);
				lblCalcular.setEnabled(true);
				lblX.setEnabled(true);
				lblX_1.setEnabled(true);
				lblX_2.setEnabled(true);
				lblX_3.setEnabled(true);
				lblX_4.setEnabled(true);
				lblResultado.setEnabled(true);
				
				llenarResultado(D);
				comprobar_pesos(MatrizCombinaciones, combin, entradas, w, o, D, F);
				label.setText(String.valueOf(w[0][0]));
				label_3.setText(String.valueOf(w[0][1]));
				label_5.setText(String.valueOf(w[0][2]));
				label_7.setText(String.valueOf(w[0][3]));
				label_8.setText(String.valueOf(w[0][4]));
				label_10.setText(String.valueOf(w[0][5]));
				
			}	
		});
	}
	
	
	public static void llenar(int MatrizCombinaciones[][]) {
		int a = 16;
		
		for(int i=0; i<5;i++) {
			
			int b = -a;
			int c = 0;
			
			for(int j=0;j<32;j++) {
				
				if(b==0) {
					if(c==0) {
						c=1;
						b=a;
					}
					else {
						c=0;
						b=-a;
					}
				}
				
				if(b<0) {
					b++;
				}
				else {
					b--;
				}
				
				MatrizCombinaciones[j][i] = c;
				//System.out.print(c+",");
			}
			a = a/2;
		}
	}

	public static void llenarResultado(int D[][]) {
	
		if(compuerta == 1) {
			for(int i=0;i<32;i++) {
				if(i==31) {
					D[i][0]=1;
				}
				else {
					D[i][0]=0;
				}
			}
		}
		else if(compuerta == 2) {
			for(int i=0;i<32;i++) {
				if(i==0) {
					D[i][0]=0;
				}
				else {
					D[i][0]=1;
				}
			}
		}
	}
	
	
	public static void generar_aleatorios(double w[][],double o) {
	
		for(int i=0;i<5;i++) {
			w[0][i]=Math.random();
		}
		o = Math.random();
	
		System.out.println("\n---------Pesos-------");
		for(int i=0;i<5;i++) {
			System.out.println(w[0][i]);
		}
		System.out.println("<"+o+">");
		System.out.println("---------------------");
	}

	
	public static double comprobar_pesos(int MatrizCombinaciones[][],int combin,int entradas,double w[][],double o,int D[][],double F) {
		int Control =0;
		int ConError = 0;
		double R,e;
		do {
			ConError=0;
			Control = Control+1;
			System.out.println("-->Intento "+Control);
			//PROBAR PESOS
			for (int X = 0; X < combin; X++) {
				F = 0;
			
				for (int Y = 0; Y < entradas; Y++) {
					//Calcular F
					F = F + (w[0][Y] * MatrizCombinaciones[X][Y]);
				}
				F = F + o;
				if(X==0) {
					System.out.println("F = "+F);
				}
				
				//Funcion de paso
				if (F >= 0){
					R = 1;
					//System.out.println("OK");
				}
				else{
					R = 0;
					//System.out.println("NOPE");
				}
			
				//Verificar el error
				e = D[X][0] - R;
				if(Control==1) {
					//System.out.println("error  "+e);
				}
			
				//COMPARAR CON EL VECTOR RESULTADO
				if (e == 0) {
				
				}
				else{
					ConError = ConError + 1;
					
					for (int Y = 0; Y < entradas; Y++) {
						w[0][Y] = w[0][Y] + (e * X);
					}
					
					//recalcular bias/o
					o = o + e;
					/*
					for(int i=0;i<5;i++) {
						System.out.println(w[0][i]);
					}
					System.out.println("<"+o+">");
					 */
				}
			}
		
			System.out.println("--------");
			
			if(Control>1000) {
				System.out.println("Error, no se encontro");	
			}
			else {
				if(ConError>0) {
					
				}
				else {
				System.out.println("FUNCIONA");
				Control=1000;
				}
			}
	
			//System.out.println("Errores "+ConError);
		
		}while(Control<1000);
	
		w[0][5]=o;
		System.out.println("---------RESULTADOS--------"
				+ "\nTeta : "+o
				+ "\nW1   : "+w[0][0]
				+ "\nW2   : "+w[0][1]
				+ "\nW3   : "+w[0][2]
				+ "\nW4   : "+w[0][3]
				+ "\nW5   : "+w[0][4]
				+ "\n");
		
		return o;
	}

	public static int calcular(double w[][],double F){
		
		int r=0;
		F = (w[0][0] *  Integer.parseInt(textField.getText())) + 
			(w[0][1] *  Integer.parseInt(textField_1.getText())) + 
			(w[0][2] *  Integer.parseInt(textField_2.getText())) +		
			(w[0][3] *  Integer.parseInt(textField_3.getText())) +
			(w[0][4] *  Integer.parseInt(textField_4.getText()));
		F += w[0][5];

		if(F<=0) {
			r=0;
		}
		else {
			r=1;
		}
		return r;
	}
}
