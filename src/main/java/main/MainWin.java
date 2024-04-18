package main;


import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;


import Logic.newsTemplate;
import Wins.PersonCard;
import Wins.ProgramCard;
import Wins.SplashWin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Aleks
 */
public class MainWin extends javax.swing.JFrame {

    /**
     * Creates new form MainWin
     */
    private List<newsTemplate> news;
    private PersonCard about;
    private ProgramCard prog;
    private SplashWin splash;
    private SplashWin errorSplash;

    /**
     * It's a main constructor
     */
    public MainWin() {
        initComponents();
        about = new PersonCard();
        prog = new ProgramCard();
        splash = new SplashWin("Mail sent!");
        errorSplash = new SplashWin("There are no recipients to send");
        loadMails();
        news = Update();
        news = newsTemplate.SortByDate(news);
    }
    private void loadMails(){
        DefaultTableModel model = (DefaultTableModel) mailTable.getModel();
         JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("D:\\java Projects\\AleksSh\\src\\main\\java\\com\\mycom\\alekssh\\mails.json"));
            JSONObject jsonObject = (JSONObject) obj;
            model.removeRow(0);
            model.removeRow(0);
            int size = Integer.parseInt(jsonObject.get("count").toString());
            for (int i = 1; i <= size; i++) {
                var mail =jsonObject.get(""+i);
                model.addRow(new Object[]{i,mail});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * frame initialithation method
     */
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        mailTable = new javax.swing.JTable();
        newMailPole = new javax.swing.JTextField();
        javax.swing.JButton addMail = new javax.swing.JButton();
        javax.swing.JButton remooveMail = new javax.swing.JButton();
        javax.swing.JButton sendButton = new javax.swing.JButton();
        javax.swing.JButton exitButton = new javax.swing.JButton();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu3 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem3 = new javax.swing.JMenuItem();
        javax.swing.JMenu jMenu4 = new javax.swing.JMenu();
        javax.swing.JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(410, 282));

        mailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Номер", "Почта"
            }
        ) {
            final Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            final boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mailTable);

        newMailPole.setText("example@mail.com");

        addMail.setText("Добавить");
        addMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFromFile();
            }
        });

        remooveMail.setText("Удалить");
        remooveMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemooveComponent();
            }
        });

        sendButton.setText("Разослать");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendAction();
            }
        });

        exitButton.setText("Выход");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitAction();
            }
        });

        jMenu3.setText("Файл");

        jMenuItem3.setText("Выход");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitAction();
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Инфо");

        jMenuItem1.setText("Об авторе");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenPersonCard();
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("О программе");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenProgramCard();
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newMailPole)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addMail, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(remooveMail, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(newMailPole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMail)
                    .addComponent(remooveMail)
                    .addComponent(sendButton)
                    .addComponent(exitButton))
                .addContainerGap())
        );
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();

        int x = (screenWidth - this.getWidth()) / 2;
        int y = (screenHeight - this.getHeight()) / 2;

        this.setLocation(x, y);

        this.setLocationRelativeTo(null);
        pack();
    }

    private void OpenPersonCard() {
        about.setVisible(true);
    }

    private void OpenProgramCard() {
        prog.setVisible(true);
    }

    /**
     * the method uploads data from a file to a table
     */
    private void AddFromFile() {
        DefaultTableModel model = (DefaultTableModel) mailTable.getModel();
        JSONParser parser = new JSONParser();
        var mail = newMailPole.getText();
        model.addRow(new Object[]{mailTable.getRowCount() + 1,mail});
        try {
            Object obj = parser.parse(new FileReader("src/main/java/Logic/mails.json"));
            JSONObject jsonObject = (JSONObject) obj;
            int size = Integer.parseInt(jsonObject.get("count").toString());
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("count",size+1);
            jsonObj.put(""+(size+1),mail);

            for (int i = 1; i <= size; i++) {
                var mails =jsonObject.get(""+i);
                jsonObj.put(i, mails);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/Logic/mails.json"))) {
                writer.write(jsonObj.toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * method removes mail instance from table and file
     */
    private void RemooveComponent() {
        int selected = mailTable.getSelectedRow();
        if (selected <0) {
            selected = 0;
        }
        DefaultTableModel model = (DefaultTableModel) mailTable.getModel();
        if (model.getRowCount()==0) {
            return;
        }
        model.removeRow(selected);
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i+1, i, 0);
        }
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/main/java/Logic/mails.json"));
            JSONObject jsonObject = (JSONObject) obj;
            int size = Integer.parseInt(jsonObject.get("count").toString());
            if (size <=0){
                return;
            }
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("count",size-1);
            int counter = 1;
            for (int i = 1; i < size+1; i++) {
                var mails =jsonObject.get(""+i);
                if (selected+1==i) {
                    continue;
                }
                jsonObj.put(counter++, mails);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/Logic/mails.json"))) {
                writer.write(jsonObj.toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * The method compiles data to be sent, such as all mail from the table and the latest news received
     */
    private void SendAction() {
        JSONParser parser = new JSONParser();
        ArrayList mails = new ArrayList();
        try {
            Object obj = parser.parse(new FileReader("src/main/java/Logic/mails.json"));
            JSONObject jsonObject = (JSONObject) obj;
            int size = Integer.parseInt(jsonObject.get("count").toString());
            for (int i = 1; i <= size; i++) {
                mails.add(jsonObject.get(""+i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if (mails.size()==0){
            errorSplash.setVisible(true);
            return;
        }
        Send(mails,news.get(news.size()-1).GetName(),news.get(news.size()-1).GetPath());
        splash.setVisible(true);

    }

    /**
     * the method returns a list of objects of the class news template storing data about the latest news for the day
     * @return list newsTemplate
     */
    private List<newsTemplate> Update(){

        ArrayList rezult = new ArrayList();

        // URL страницы
        try{
            URL url = new URL("https://news.google.com/search?q=bntu&hl=ru&gl=RU&ceid=RU%3Aru");
            Document doc = Jsoup.connect(url.toString()).get();
            Elements elements = doc.select("c-wiz");
            Elements parts = new Elements();

            Elements rezultByDate = new Elements();
            for (var element:elements) {
                if (element.attr("class").contains("PO9Zff Ccj79 kUVvS")) {
                    String timeLine = element
                            .select("c-wiz")
                            .select("article")
                            .select("time")
                            .text();
                    String num=timeLine.split(" ")[0];
                    if (num.equals("Вчера")) {
                        continue;
                    }
                    String date=timeLine.split(" ")[1];
                    int rez = Integer.parseInt(num);
                    if ("час".equals(date) || "часа".equals(date)|| "часов".equals(date)) {
                        rezultByDate.add(element);
                    }
                    parts.add(element);
                }
            }
            for(var element:rezultByDate){
                //System.out.println(element.select("c-wiz").select("article").select("a").text());
                //System.out.println();
                //System.out.println(element.select("c-wiz").select("article").select("figure").select("img").attr("src"));
                //System.out.println();
                //System.out.println(element.select("c-wiz").select("article").select("time").attr("datetime"));
                //System.out.println(element.select("c-wiz").select("article").select("a").attr("href"));
                //System.out.println(element
                //    .select("c-wiz")
                //    .select("article")
                //    .select("a")
                //    .attr("abs:href"));
                //System.out.println("-------------------------------------------------------------------------------------------------------------");
                //System.out.println();
                String name = element.select("c-wiz").select("article").select("a").text();
                name = name.substring(0,name.length()-14);
                rezult.add(new newsTemplate(
                        name,
                        element.select("c-wiz").select("article").select("time").attr("datetime"),
                        element.select("c-wiz").select("article").select("a").attr("abs:href"),
                        element.select("c-wiz").select("article").select("figure").select("img").attr("src"))
                );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rezult;
    }

    /**
     * method of sending messages by mail
     *
     *
     * @param mails mailing addresses as a list of strings
     * @param header letter header string
     * @param message message body string
     */
    public static void Send(List<String> mails, String header, String message) {
        int Port = 587;

        String user = "hearthstonee81@gmail.com";
        String password = "tsug wetq azij iqbi";

        Properties props = System.getProperties();
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", ""+Port);
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.user", user);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.starttls.required", true);
        props.put("mail.smtp.startssl.enable", true);
        props.put("mail.smtp.startssl.required", true);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");


        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage letter = new MimeMessage(session);
            for(var mail:mails) {
                letter.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
            }
            letter.setSubject(header);
            letter.setText(message);
            Transport transport = session.getTransport();
            transport.connect(user, password);
            transport.sendMessage(letter, letter.getAllRecipients());


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private void ExitAction() {
        System.exit(0);
    }
    private javax.swing.JTable mailTable;
    private javax.swing.JTextField newMailPole;
}
