/*
 * CIS 36B: Price Checker
 * 
 * @author Jenny Hamer
 */

package pricechecker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PriceChecker implements ActionListener {
    // JMenuBar is the container for menus
    // [JMenuBar add(JMenu menu)] - use add() to add menus to JMenuBar
    // each menu will have menu items - JMenuItem - add()
    // add visual separators using addSeparator() or insertSeparator(int i)
    
    JLabel label;
    JMenuItem[] menuItems;
    
    PriceChecker() { // constructor --> create window, menubar, items,...
        JFrame frame = new JFrame("Price Checker");
        frame.setLayout(new FlowLayout());
        
        frame.setSize(250, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel();
        
        // create the menu bar of the window
        JMenuBar menubar = new JMenuBar();
        JMenu produceMenu = new JMenu("Produce");
        ImageIcon produceImg = new ImageIcon("produce.jpg");
        JMenu fruit = new JMenu("Juicy fruit");
        ImageIcon peachImg = new ImageIcon("peach.jpg");
        JMenuItem peach = new JMenuItem("Ripe peaches", peachImg);
        JMenuItem farmersProduce = new JMenuItem("Farmer's select", produceImg);
        ImageIcon potatoImg = new ImageIcon("potato.img");
        JMenuItem potato = new JMenuItem("Potatoes", potatoImg);
        ImageIcon greenImg = new ImageIcon("green.jpg");
        JMenuItem green = new JMenuItem("Mixed greens", greenImg);
        // creating the icon for the tomato submenu
        ImageIcon tomatoImg = new ImageIcon("tomato.jpg");
        JMenuItem tomato = new JMenuItem("Tomatoes", tomatoImg);
        // submenu of tomato
        JMenu heirlooms = new JMenu("Heirloom tomatoes");
        ImageIcon heirloomImg = new ImageIcon("heirloom.jpg");
        JMenu readyHeir = new JMenu("Ready-to-go");
        JMenuItem tomSalad = new JMenuItem("Heirloom tomato salad", heirloomImg);
        JMenuItem cherryTom = new JMenuItem("Cherry tomatoes");
        JMenuItem beefsteakTom = new JMenuItem("Coeur de boeuf tomatoes");
        
        menubar.add(produceMenu);        // add produce menu to menubar
        fruit.add(peach);
        produceMenu.add(fruit);
        produceMenu.add(farmersProduce); // add items to menu
        produceMenu.add(potato);
        produceMenu.add(green);
        produceMenu.add(tomato);
        readyHeir.add(tomSalad);         // adding items to submenus
        heirlooms.add(cherryTom);
        heirlooms.add(beefsteakTom);
        heirlooms.add(readyHeir);        // adding submenu to heirlooms
        produceMenu.add(heirlooms);      // adding heirlooms as submenu of prod.
        
        
        // action listeners for the submenus and their items
        produceMenu.addActionListener(this);
        farmersProduce.addActionListener(this);
        tomato.addActionListener(this);
        heirlooms.addActionListener(this);
        cherryTom.addActionListener(this);
        beefsteakTom.addActionListener(this);

        
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String which = ae.getActionCommand();
        // display info for the various items available: name, price
        double price = 0.25;
        
        for (int i = 0; i < menuItems.length; i++) {
                label.setText(which + "$" + price);
                price += 0.25;
        }
        
    }
    
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new PriceChecker();
           }
       });
    }
}
