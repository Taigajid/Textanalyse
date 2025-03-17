import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ArrayList;

public class Textanalyse extends JFrame {
    // Anfang Attribute
    // start attributes
  static JTextField jTextField1 = new JTextField(20);
  private JLabel lHaupteingabefeld = new JLabel();
  private static JNumberField jNumberField1 = new JNumberField();
  private JLabel lTextlaenge = new JLabel();
  private static JNumberField jNumberField2 = new JNumberField();
  private JLabel lAnzahlWoerter = new JLabel();
  private static JTextField jTextField2 = new JTextField();
  private static JTextField jTextField3 = new JTextField();
  private JLabel lEingabegesuchteZeichenfolge = new JLabel();
  private JLabel lIstgesuchteZeichenfolgevorhanden1 = new JLabel();
  private static JNumberField jNumberField3 = new JNumberField();
  private static JTextField jTextField4 = new JTextField();
  private JLabel lGesuchteStelledesTexts = new JLabel();
  private JLabel lAngesuchterStelle = new JLabel();
  static JTextField jTextField5 = new JTextField();
  private static JNumberField jNumberField4 = new JNumberField();
  private JLabel lGesuchterBuchstabe = new JLabel();
  private JLabel lAnzahlgesuchterBuchstabe = new JLabel();
  private JButton bAnalysestarten = new JButton();

  private static JTextField jTextField6 = new JTextField();
  private JLabel lUmgedrehterText = new JLabel();
    // end attributes
  private static JNumberField jNumberField5 = new JNumberField();
  private JLabel lAnzahlVokale = new JLabel();
  private static JTextField jTextField7 = new JTextField();
  private static JTextField jTextField8 = new JTextField();
  private static JTextField jTextField9 = new JTextField();
  private static JTextField jTextField10 = new JTextField();
  private static JNumberField jNumberField6 = new JNumberField();
  private static JTextField jTextField11 = new JTextField();
  private static JTextField jTextField12 = new JTextField();
  private JLabel lHervorgehobenerBuchstabe = new JLabel();
  private JLabel lAsciiWerte = new JLabel();
  private JLabel lAuszuschneidendesWort = new JLabel();
  private JLabel lTextabschnittCoords = new JLabel();
  private JLabel lTextausschnitt = new JLabel();
  private JLabel lWortAnStelleEingabe = new JLabel();
  private JLabel lWortAnStelleAusgabe = new JLabel();

  private HighlightWord highlight;




  Color highlightColor = new Color(144, 213, 255);

    // Ende Attribute



  static void textLength(){
    try{
      int length = jTextField1.getText().length();
      jNumberField1.setInt(length);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  static void wordAmount(){
    try{
      String text = jTextField1.getText();
      String[] words = text.split("\\s+");
      int wordcount = words.length;
      jNumberField2.setInt(wordcount);
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  static void zeichenFolge(){
    try{
      String text = jTextField1.getText().toLowerCase();
      String zeichenfolge = jTextField2.getText().toLowerCase();
      boolean containsZahlenfolge;
      if(jTextField2.getText().isEmpty()){
        jTextField3.setText("");
      }
      else if(text.contains(zeichenfolge)){
        containsZahlenfolge = true;
        jTextField3.setText(Boolean.toString(containsZahlenfolge));
      }
      else{
        containsZahlenfolge = false;
        jTextField3.setText(Boolean.toString(containsZahlenfolge));
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    
    
    
  }
  static void textStelle(){
    try{
      int stelle = jNumberField3.getInt();
      jTextField4.setText("" + jTextField1.getText().charAt(stelle - 1));
    }catch(Exception e){
      e.printStackTrace();
    }
  }



  static void checkLetter(){
    try{
      String text = jTextField1.getText().toLowerCase();
      char check = jTextField5.getText().toLowerCase().charAt(0);
      char[] textarray = text.toCharArray();
      int arraysize = text.length();
      int counter = 0;
      for(int i = arraysize - 1; i >= 0; i--){
        if(textarray[i] == check){
          counter++;
        }
      }
      jNumberField4.setInt(counter);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  static void reverseWord(){
    try{
      String text = jTextField1.getText();
      char[] textarray = text.toCharArray();
      int arraysize = text.length();
      String word_reverse = "";
      for(int i = arraysize - 1; i >= 0; i--){
        word_reverse += textarray[i];
      }
      jTextField6.setText(word_reverse);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  static void vokalZahl(){
    try{
      String text = jTextField1.getText().toLowerCase();
      char[] textarray = text.toCharArray();
      int arraysize = text.length();
      int counter = 0;
      for (int i = arraysize - 1;i >= 0; i--){
        if(textarray[i] == 'a' || textarray[i] == 'e' || textarray[i] == 'i' || textarray[i] == 'o' || textarray[i] == 'u'){
          counter++;
        }
      }
      jNumberField5.setInt(counter);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  static void asciiValues(){
    /*try{
      String text = jTextField1.getText();
      String ascii = "";
      for (int i=0;i<text.length() ; i++) {
        
        ascii+=(int)text.charAt(i)+ " ";
      } // end of for
      jTextField7.setText(ascii);
    }
    catch(Exception e){
      e.printStackTrace();
    } */
    
    try{
    String text = jTextField1.getText();
    byte[] ascii = text.getBytes("US-ASCII");
    for(int i = 0; i <= ascii.length - 1; i++){
    jTextField7.setText(jTextField7.getText() + " " + ascii[i]);
    }
    }catch(UnsupportedEncodingException e){
    e.printStackTrace();
    }
    
  }

  static void removeWord(){
    try{
      String text = jTextField1.getText();
      String[] words = text.split("\\s+");
      String searchedWord = jTextField8.getText();
      for(int i = 0; i <= words.length; i++){
        if(words[i].equalsIgnoreCase(searchedWord)){
          String removedWord = text.replace((searchedWord), "");
          removedWord = removedWord.replace("  ", " ");
          jTextField1.setText(removedWord);
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  static void subString(){
    try{
      String text = jTextField1.getText();
      String[] parts = jTextField9.getText().split(",");
      int start = (Integer.parseInt(parts[0])) - 1;
      int end = Integer.parseInt(String.valueOf(parts[1]));
      String substring = text.substring(start, end);
      jTextField10.setText(substring);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  static void wortAnStelle(){
    try{
      String text = jTextField1.getText();
      String[] words = text.split("\\s+");
      int stelle = jNumberField6.getInt();
      jTextField11.setText(words[stelle - 1]);
      
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private void updateHighlightChar(){
    
    char highlightChar = 'e';
    if(jTextField12.getText().length() == 1){
      highlightChar = jTextField12.getText().toLowerCase().charAt(0);
    }
    
    for(Object tag : highlight.getHighlights()){
      jTextField1.getHighlighter().removeHighlight(tag);
    }
    highlight.clearHighlights();
    PlainDocument doc = (PlainDocument) jTextField1.getDocument();
    doc.setDocumentFilter(new HighlightWord(jTextField1, highlightChar, highlightColor));   
  }


















  public Textanalyse() {
    // Frame init
    super();
    
    char highlightChar = 'e';
    if(jTextField12.getText().length() == 1){
      highlightChar = jTextField12.getText().toLowerCase().charAt(0);
    }
    
    highlight = new HighlightWord(jTextField1, 'e', highlightColor);
    PlainDocument doc = (PlainDocument) jTextField1.getDocument();
    doc.setDocumentFilter(highlight);
    
    
    
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1087;
    int frameHeight = 850;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Textanalyse");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    cp.setBackground(Color.CYAN);
    // Anfang Komponenten
    
    jTextField1.setBounds(16, 48, 680, 64);
    jTextField1.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField1);
    lHaupteingabefeld.setBounds(16, 24, 103, 24);
    lHaupteingabefeld.setFont(new Font("Dialog", Font.BOLD, 11));
    lHaupteingabefeld.setText("Haupteingabefeld:");
    cp.add(lHaupteingabefeld);
    jNumberField1.setBounds(16, 152, 328, 48);
    jNumberField1.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jNumberField1);
    lTextlaenge.setBounds(16, 128, 80, 24);
    lTextlaenge.setText("Textlänge:");
    lTextlaenge.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lTextlaenge);
    jNumberField2.setBounds(368, 152, 328, 48);
    jNumberField2.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jNumberField2);
    lAnzahlWoerter.setBounds(368, 128, 85, 24);
    lAnzahlWoerter.setText("Anzahl Wörter:");
    lAnzahlWoerter.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lAnzahlWoerter);
    jTextField2.setBounds(16, 240, 328, 48);
    jTextField2.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField2);
    jTextField3.setBounds(368, 240, 328, 48);
    jTextField3.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField3);
    lEingabegesuchteZeichenfolge.setBounds(16, 216, 180, 24);
    lEingabegesuchteZeichenfolge.setText("Eingabe gesuchte Zeichenfolge:");
    lEingabegesuchteZeichenfolge.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lEingabegesuchteZeichenfolge);
    lIstgesuchteZeichenfolgevorhanden1.setBounds(368, 216, 213, 24);
    lIstgesuchteZeichenfolgevorhanden1.setText("Ist gesuchte Zeichenfolge vorhanden:");
    lIstgesuchteZeichenfolgevorhanden1.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lIstgesuchteZeichenfolgevorhanden1);
    jNumberField3.setBounds(16, 328, 328, 48);
    jNumberField3.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jNumberField3);
    jTextField4.setBounds(368, 328, 328, 48);
    jTextField4.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField4);
    lGesuchteStelledesTexts.setBounds(16, 304, 152, 24);
    lGesuchteStelledesTexts.setText("Gesuchte Stelle des Texts:");
    lGesuchteStelledesTexts.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lGesuchteStelledesTexts);
    jNumberField5.setBounds(720, 152, 328, 48);
    jNumberField5.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jNumberField5);
    lAnzahlVokale.setBounds(720, 128, 85, 24);
    lAnzahlVokale.setText("Anzahl Vokale:");
    lAnzahlVokale.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lAnzahlVokale);
    // Ende Komponenten
    
    lAngesuchterStelle.setBounds(368, 304, 200, 24);
    lAngesuchterStelle.setFont(new Font("Dialog", Font.BOLD, 11));
    lAngesuchterStelle.setText("Buchstabe an gesuchter Stelle:");
    lAngesuchterStelle.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lAngesuchterStelle);
    jTextField5.setBounds(16, 416, 328, 48);
    jTextField5.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField5);
    jNumberField4.setBounds(368, 416, 328, 48);
    jNumberField4.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jNumberField4);
    lGesuchterBuchstabe.setBounds(16, 392, 126, 24);
    lGesuchterBuchstabe.setFont(new Font("Dialog", Font.BOLD, 11));
    lGesuchterBuchstabe.setText("Gesuchter Buchstabe:");
    lGesuchterBuchstabe.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lGesuchterBuchstabe);
    lAnzahlgesuchterBuchstabe.setBounds(368, 392, 165, 24);
    lAnzahlgesuchterBuchstabe.setFont(new Font("Dialog", Font.BOLD, 11));
    lAnzahlgesuchterBuchstabe.setText("Anzahl gesuchter Buchstabe:");
    lAnzahlgesuchterBuchstabe.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lAnzahlgesuchterBuchstabe);
    bAnalysestarten.setBounds(16, 592, 680, 200);
    bAnalysestarten.setFont(new Font("Dialog", Font.BOLD, 11));
    bAnalysestarten.setText("Analyse starten");
    bAnalysestarten.setMargin(new Insets(2, 2, 2, 2));
    bAnalysestarten.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bAnalysestarten_ActionPerformed(evt);
      }
    });
    bAnalysestarten.setForeground(new Color(0xC0C0C0));
    bAnalysestarten.setForeground(Color.BLACK);
    bAnalysestarten.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    bAnalysestarten.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 2));
    bAnalysestarten.setToolTipText("test");
    bAnalysestarten.setToolTipText("Bitte geben sie in alle Felder für die sie eine Ausgabe ein sofern gewünscht!");
    bAnalysestarten.setToolTipText("Bitte geben sie in alle Felder für die sie eine Ausgabe wollen die Parameter ein sofern benötigt!");
    bAnalysestarten.setOpaque(false);
    bAnalysestarten.setOpaque(true);
    
    
    bAnalysestarten.setBorderPainted(false);
    bAnalysestarten.setBorderPainted(true);
    bAnalysestarten.setBackground(Color.LIGHT_GRAY);
    cp.add(bAnalysestarten);
    jTextField6.setBounds(16, 496, 680, 64);
    jTextField6.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField6);
    lUmgedrehterText.setBounds(16, 472, 108, 24);
    lUmgedrehterText.setFont(new Font("Dialog", Font.BOLD, 11));
    lUmgedrehterText.setText("Umgedrehter Text:");
    lUmgedrehterText.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    cp.add(lUmgedrehterText);
    jTextField7.setBounds(720, 240, 328, 48);
    jTextField7.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField7);
    jTextField8.setBounds(720, 328, 328, 48);
    jTextField8.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField8);
    jTextField9.setBounds(720, 416, 328, 48);
    jTextField9.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField9);
    jTextField10.setBounds(720, 496, 328, 64);
    jTextField10.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField10);
    jNumberField6.setBounds(720, 592, 328, 80);
    jNumberField6.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jNumberField6);
    jTextField11.setBounds(720, 712, 328, 80);
    jTextField11.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField11);
    jTextField12.setBounds(720, 48, 328, 64);
    jTextField12.setFont(new Font("Dialog", Font.PLAIN, 11));
    cp.add(jTextField12);
    lHervorgehobenerBuchstabe.setBounds(720, 24, 230,24);
    lHervorgehobenerBuchstabe.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    lHervorgehobenerBuchstabe.setText("Hervorzuhebender Buchstabe (sonst \'e\'):");
    cp.add(lHervorgehobenerBuchstabe);
    lAsciiWerte.setBounds(720, 216, 72, 24);
    lAsciiWerte.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    lAsciiWerte.setText("ASCII-Werte:");
    cp.add(lAsciiWerte);
    lAuszuschneidendesWort.setBounds(720, 304, 169, 24);
    lAuszuschneidendesWort.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    lAuszuschneidendesWort.setText("Auszuschneidendes Wort:");
    cp.add(lAuszuschneidendesWort);
    lTextabschnittCoords.setBounds(720, 392, 216, 24);
    lTextabschnittCoords.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    lTextabschnittCoords.setText("Textausschnitt Format: \"(start),(ende)\"");
    cp.add(lTextabschnittCoords);
    lTextausschnitt.setBounds(720, 472, 169, 24);
    lTextausschnitt.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    lTextausschnitt.setText("Ausgabe Textausschnitt:");
    cp.add(lTextausschnitt);
    lWortAnStelleEingabe.setBounds(720, 568, 169, 24);
    lWortAnStelleEingabe.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    lWortAnStelleEingabe.setText("Gesuchtes Wort (Stelle):");
    cp.add(lWortAnStelleEingabe);
    lWortAnStelleAusgabe.setBounds(720, 688, 169, 24);
    lWortAnStelleAusgabe.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 11));
    lWortAnStelleAusgabe.setText("Ausgabe Wort an Stelle:");
    cp.add(lWortAnStelleAusgabe);
    
    
    
    
    
    // Ende Komponenten
    // end components
    setVisible(true);
  } // end of public Textanalyse

    // Anfang Methoden

    // start methods
  public static void main(String[] args) {
    new Textanalyse();
  } // end of main

    // Ende Methoden
  public void bAnalysestarten_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    try{
      removeWord();
      textLength();
      wordAmount();
      zeichenFolge();
      textStelle();
      checkLetter();
      reverseWord();
      vokalZahl();
      jTextField7.setText("");
      asciiValues();
      subString();
      wortAnStelle();
      updateHighlightChar();
      
      
    }catch (Exception e){
      jTextField6.setText("Error");
      e.printStackTrace();
    }
    
    
    
  } // end of bAnalysestarten_ActionPerformed

    // end methods
}
class HighlightWord extends DocumentFilter {
  private char highlightChar;
  private final Color highlightColor;
  private final JTextField textField;
  private final Highlighter highlighter;
  private List<Object> highlights = new ArrayList<>();

  public HighlightWord(JTextField textField, char highlightChar, Color highlightColor) {
    this.textField = textField;
    this.highlightChar = highlightChar;
    this.highlightColor = highlightColor;
    this.highlighter = textField.getHighlighter();
  }

  public List<Object> getHighlights(){return highlights;}

  public void clearHighlights(){highlights.clear();}


  @Override
  public void insertString(FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
    super.insertString(fb, offset, text, attrs);
    highlightChars();
  }

  @Override
  public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
    super.replace(fb, offset, length, text, attrs);
    highlightChars();
  }

  @Override
  public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
    super.remove(fb, offset, length);
    highlightChars();
  }

  private void highlightChars() {
    for(Object tag : highlights){
      highlighter.removeHighlight(tag);
    }
    highlights.clear();
    
    String text = textField.getText().toLowerCase();
    for(int i = 0; i < text.length(); i++){
      if(text.charAt(i) == highlightChar){
        try{
          Object tag = highlighter.addHighlight(i, i + 1, new DefaultHighlighter.DefaultHighlightPainter(highlightColor));
          highlights.add(tag);
        }catch(BadLocationException e){
          e.printStackTrace();
        }
      }
    }
  }
}

