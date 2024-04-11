import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsernamePasswordMenu {
    private JFrame welcomeFrame;
    private JFrame loginFrame;
    private JFrame registerFrame;
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JTextField registerUsernameField;
    private JPasswordField registerPasswordField;

    public UsernamePasswordMenu() {
        createWelcomeScreen();
    }

    private void createWelcomeScreen() {
        welcomeFrame = new JFrame("Bem-vindo");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(300, 200);

        JPanel welcomePanel = new JPanel();
        welcomeFrame.add(welcomePanel);

        JLabel welcomeLabel = new JLabel("Bem-vindo! Escolha uma opção:");
        welcomePanel.add(welcomeLabel);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.dispose();
                createLoginScreen();
            }
        });
        welcomePanel.add(loginButton);

        JButton registerButton = new JButton("Cadastro");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.dispose();
                createRegisterScreen();
            }
        });
        welcomePanel.add(registerButton);

        welcomeFrame.setVisible(true);
    }

    private void createLoginScreen() {
        loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 200);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 2));
        loginFrame.add(loginPanel, BorderLayout.CENTER);

        JLabel userLabel = new JLabel("Usuário: ");
        loginPanel.add(userLabel);
        loginUsernameField = new JTextField(15);
        loginPanel.add(loginUsernameField);

        JLabel passwordLabel = new JLabel("Senha: ");
        loginPanel.add(passwordLabel);
        loginPasswordField = new JPasswordField(15);
        loginPanel.add(loginPasswordField);

        JButton submitButton = new JButton("Entrar");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica de login aqui
                JOptionPane.showMessageDialog(loginFrame, "Login realizado com sucesso!");
                loginFrame.dispose();
                // Exibir tela do menu principal ou outras ações após o login
            }
        });
        loginPanel.add(submitButton);

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu(loginFrame);
            }
        });
        loginPanel.add(menuButton);

        loginFrame.setVisible(true);
    }

    private void showMenu(JFrame parentFrame) {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem backItem = new JMenuItem("Voltar para a tela de boas-vindas");
        backItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
                createWelcomeScreen();
            }
        });
        JMenuItem resetPasswordItem = new JMenuItem("Refazer a senha");
        resetPasswordItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica de refazer a senha
                JOptionPane.showMessageDialog(parentFrame, "Opção de refazer a senha selecionada!");
            }
        });
        JMenuItem changeUserItem = new JMenuItem("Trocar usuário");
        changeUserItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica de trocar o usuário
                JOptionPane.showMessageDialog(parentFrame, "Opção de trocar usuário selecionada!");
            }
        });

        menu.add(backItem);
        menu.add(resetPasswordItem);
        menu.add(changeUserItem);

        menu.show(parentFrame, 0, parentFrame.getHeight());
    }

    private void createRegisterScreen() {
        registerFrame = new JFrame("Cadastro");
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setSize(300, 200);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4, 2));
        registerFrame.add(registerPanel, BorderLayout.CENTER);

        JLabel userLabel = new JLabel("Novo Usuário: ");
        registerPanel.add(userLabel);
        registerUsernameField = new JTextField(15);
        registerPanel.add(registerUsernameField);

        JLabel passwordLabel = new JLabel("Nova Senha: ");
        registerPanel.add(passwordLabel);
        registerPasswordField = new JPasswordField(15);
        registerPanel.add(registerPasswordField);

        JButton submitButton = new JButton("Cadastrar");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica de cadastro aqui
                JOptionPane.showMessageDialog(registerFrame, "Cadastro realizado com sucesso!");
                registerFrame.dispose();
                // Pode adicionar ações adicionais após o cadastro, como redirecionar para a tela de login
            }
        });
        registerPanel.add(submitButton);

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu(registerFrame);
            }
        });
        registerPanel.add(menuButton);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame.dispose();
                createWelcomeScreen();
            }
        });
        registerPanel.add(backButton);

        registerFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UsernamePasswordMenu();
            }
        });
    }
}
