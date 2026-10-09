package LaboratorioPilas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class CalculadoraPilas extends JFrame {
    private final JTextField expresion = new JTextField();
    private final JLabel resultado = new JLabel("Resultado: ", SwingConstants.RIGHT);
    private final EvaluadorExpresiones evaluador = new EvaluadorExpresiones();
    private final DecimalFormat formato = new DecimalFormat("0.##########");

    public CalculadoraPilas() {
        setTitle("Calculadora con pilas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(390, 430);
        setLocationRelativeTo(null);

        expresion.setFont(new Font("SansSerif", Font.PLAIN, 24));
        expresion.setHorizontalAlignment(SwingConstants.RIGHT);
        expresion.addActionListener(evento -> calcular());

        resultado.setFont(new Font("SansSerif", Font.BOLD, 22));
        resultado.setForeground(new Color(22, 75, 92));
        resultado.setBorder(BorderFactory.createEmptyBorder(12, 8, 12, 8));

        JPanel pantalla = new JPanel(new BorderLayout(0, 6));
        pantalla.setBorder(BorderFactory.createEmptyBorder(18, 18, 10, 18));
        pantalla.add(expresion, BorderLayout.CENTER);
        pantalla.add(resultado, BorderLayout.SOUTH);

        JPanel botones = new JPanel(new GridLayout(4, 4, 8, 8));
        botones.setBorder(BorderFactory.createEmptyBorder(10, 18, 18, 18));
        String[] etiquetas = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "(", "0", ")", "+"};
        for (String etiqueta : etiquetas) {
            JButton boton = new JButton(etiqueta);
            boton.setFont(new Font("SansSerif", Font.BOLD, 18));
            boton.addActionListener(evento -> expresion.setText(expresion.getText() + etiqueta));
            botones.add(boton);
        }

        JButton calcular = new JButton("Calcular");
        calcular.setFont(new Font("SansSerif", Font.BOLD, 18));
        calcular.addActionListener(evento -> calcular());

        JButton limpiar = new JButton("Limpiar");
        limpiar.setFont(new Font("SansSerif", Font.BOLD, 18));
        limpiar.addActionListener(evento -> {
            expresion.setText("");
            resultado.setText("Resultado: ");
        });

        JPanel acciones = new JPanel(new GridLayout(1, 2, 8, 8));
        acciones.setBorder(BorderFactory.createEmptyBorder(0, 18, 18, 18));
        acciones.add(limpiar);
        acciones.add(calcular);

        add(pantalla, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);
        add(acciones, BorderLayout.SOUTH);
    }

    private void calcular() {
        try {
            resultado.setText("Resultado: " + formato.format(evaluador.evaluar(expresion.getText())));
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Expresión inválida", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraPilas().setVisible(true));
    }
}