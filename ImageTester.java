/*
 * CIS 36B: Price Checker
 * 
 * @author Jenny Hamer
 */
package pricechecker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ImageTester implements ActionListener {
    // JMenuBar is the container for menus
    // [JMenuBar add(JMenu menu)] - use add() to add menus to JMenuBar
    // each menu will have menu items - JMenuItem - add()
    // add visual separators using addSeparator() or insertSeparator(int i)

    JLabel label;
    JMenuItem[] menuItems;

    ImageTester() { // constructor --> create window, menubar, items,...

        JFrame frame = new JFrame("Price Checker");
        frame.setLayout(new FlowLayout());

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Select a category to view the items available.");

        // create the menu bar of the window
        JMenuBar menubar = new JMenuBar();
        // create the list of menus`- five main categories as follows
        JMenu[] mainMenus = {new JMenu("Fresh Produce"), new JMenu("Rich Dairy"),
            new JMenu("Healthy protein"), new JMenu("Essential fats"), 
            new JMenu("Sweet treats")};

// two submenus per category
        JMenu[] subMenus = {new JMenu("Veggies"), new JMenu("Fruit"), 
            new JMenu("Breakfast"), new JMenu("Cheese"), new JMenu("Meat"), 
            new JMenu("Fish"), new JMenu("Pantry"), new JMenu("Fridge"), 
            new JMenu("Chocolate"), new JMenu("Gummies")};

        ImageIcon[] itemImages = {new ImageIcon("src/pricechecker/potato.jpg"), 
            new ImageIcon("src/pricechecker/green.jpg"),
            new ImageIcon("src/pricechecker/produce.jpg"), 
            new ImageIcon("src/pricechecker/coeur.jpg"),
            new ImageIcon("src/pricechecker/heirloom.jpg"), 
            new ImageIcon("src/pricechecker/heirloomsalad.jpg"),
            new ImageIcon("src/pricechecker/tomato.jpg"), 
            new ImageIcon("src/pricechecker/peach.jpg"),
            new ImageIcon("src/pricechecker/milk.jpg"), 
            new ImageIcon("src/pricechecker/yoghurt.jpg"), 
            new ImageIcon("src/pricechecker/cheddar.jpg"),
            new ImageIcon("src/pricechecker/brie.jpg"), 
            new ImageIcon("src/pricechecker/roque.jpg"), 
            new ImageIcon("src/pricechecker/eggs.jpg"),
            new ImageIcon("src/pricechecker/roast.jpg"), 
            new ImageIcon("src/pricechecker/lamb.jpg"), 
            new ImageIcon("src/pricechecker/pork.jpg"),
            new ImageIcon("src/pricechecker/salmon.jpg"), 
            new ImageIcon("src/pricechecker/mackerelpg"), 
            new ImageIcon("src/pricechecker/olive.jpg"),
            new ImageIcon("src/pricechecker/coconut.jpg"), 
            new ImageIcon("src/pricechecker/butter.jpg"), 
            new ImageIcon("src/pricechecker/tallow.jpg"),
            new ImageIcon("src/pricechecker/cookies.jpg"), 
            new ImageIcon("src/pricechecker/cake.jpg"), 
            new ImageIcon("src/pricechecker/dark.jpg"),
            new ImageIcon("src/pricechecker/almond.jpg"), 
            new ImageIcon("src/pricechecker/bear.jpg"), 
            new ImageIcon("src/pricechecker/ring.jpg")};

        JMenuItem menuItems[] = {new JMenuItem("Russet potatoes :: $0.50 / lb"),
            new JMenuItem("Mixed greens :: $1.00 / bag"),
            new JMenuItem("Farmer's Selection :: $2.75 / lb"),
            new JMenuItem("Coeur de boeuf tomatoes :: $3.00 / lb"),
            new JMenuItem("Rainbow heirlooms :: $3.00 / lb"),
            new JMenuItem("Heirloom tomato salad :: $6.00 / lb "),
            new JMenuItem("Cherry tomatoes :: $3.00"),
            new JMenuItem("Peaches :: $3.50 / lb"), new JMenuItem("Milk :: $4.00 / gal"),
            new JMenuItem("Yoghurt :: $4.00 / qt"),
            new JMenuItem("Sharp Cheddar :: $6.50 / lb"),
            new JMenuItem("Brie de Meaux :: $9.00 / wedge"),
            new JMenuItem("Roquefort :: $8.00 / wedge"),
            new JMenuItem("Farm Eggs :: $4.00 / dozen"),
            new JMenuItem("Prime rib roast :: $15.00 / lb"),
            new JMenuItem("Lamb kebab :: $3.00 / skewer"),
            new JMenuItem("Porkchops :: $6.75 / lb"),
            new JMenuItem("Wild Salmon :: $10.00 / lb"),
            new JMenuItem("Fresh Mackerel :: $8.00 / lb"),
            new JMenuItem("Italian Olive Oil :: $10.00 / liter"),
            new JMenuItem("Coconut oil :: $6.50 / jar (16oz)"),
            new JMenuItem("Butter :: $4.00 / lb"), new JMenuItem("Tallow :: $6.00 / lb"),
            new JMenuItem("Butter biscuits :: $5.00 / dozen"),
            new JMenuItem("Golden Cake :: $3.00 / slice \n$12.00 / cake"),
            new JMenuItem("Dark chocolate :: $3.25 / bar"),
            new JMenuItem("Milk chocolate almonds :: $8.00 / lb"),
            new JMenuItem("Gummy bears :: $7.00 / lb"), 
            new JMenuItem("Peach rings :: $7.50 / lb")};

//        if (menuItems.length == itemImages.length) {
        for (int i = 0; i < itemImages.length; i++) {
            // pairing each item with its image (same index in each array)
            menuItems[i].setIcon(itemImages[i]);
            String itemName = menuItems[i].toString();
            menuItems[i].setActionCommand(itemName);
            menuItems[i].addActionListener(this);
            // set mnemonic - first letter of the item name
            menuItems[i].setMnemonic(i);
            // underline the first letter of the item name
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageTester();
            }
        });
        ImageTester test = new ImageTester();
        for (int i = 0; i < test.menuItems.length; i++) {
            System.out.println(test.menuItems[i].toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}