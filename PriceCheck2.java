/*
 * CIS 36B: Price Checker
 * 
 * @author Jenny Hamer
 */

package pricechecker;

import java.awt.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.VK_PLUS;
import javax.swing.*;
import static javax.swing.KeyStroke.getKeyStroke;

public class PriceCheck2 implements ActionListener {
    // JMenuBar is the container for menus
    // [JMenuBar add(JMenu menu)] - use add() to add menus to JMenuBar
    // each menu will have menu items - JMenuItem - add()
    // add visual separators using addSeparator() or insertSeparator(int i)
    
    JLabel label;
    JMenuItem[] allItems; // array of items & images
    
    PriceCheck2() { // constructor --> create window, menubar, items,...
        JFrame frame = new JFrame("Price Checker");
        frame.setLayout(new FlowLayout());
        
        frame.setSize(250, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel();
        
        // create the menu bar of the window
        JMenuBar menubar = new JMenuBar();
        // create the list of menus
        String[] listOfMenus = {"Produce", "Juicy fuit", "Tomatoes", 
            "Dairy", "Cheese", "Protein", "Meat", "Fish", "Essential fats", 
            "Pantry", "Fridge", "Sweet treats", "Chocolate", "Gummy"};
        
        String[] menuItems = {"Potatoes", "Mixed Greens", "Farmer's select", 
            "Peaches", "Rainbow assortment", "Heirloom tomato salad", 
            "Cherry", "Coeur de boeuf", "Milk", "Yoghurt", "Roquefort", "Brie", 
            "Cheddar", "Eggs", "Rib roast", "Lamb kebab", "Porkchop", 
            "Salmon", "Mackerel", "Olive Oil", "Coconut oil", "Butter", "Tallow", 
            "Biscuits", "Cake", "Dark chocolate", "Milk chocolate almonds", 
            "Gummy bears", "Peach rings"};
            
        String[] itemImages = {"potato.jpg", "green.jpg", "produce.jpg", "peach.jpg",
            "heirloom.jpg", "heirloomsalad.jpg", "tomato.jpg", "coeur.jpg", "milk.jpg",
            "yoghurt.jpg", "roque.jpg", "brie.jpg", "cheddar.jpg", "eggs.jpg",
            "roast.jpg", "lamb.jpg", "pork.jpg", "salmon.jpg", "mackerelpg",
            "olive.jpg", "coconut.jpg", "butter.jpg", "tallow.jpg", "cookies.jpg",
            "cake.jpg", "dark.jpg", "almond.jpg", "bear.jpg", "ring.jpg"};

        allItems = new JMenuItem[menuItems.length];
        if (menuItems.length == itemImages.length) {
            for (int i = 0; i < menuItems.length; i++) {
                // pairing each item with its image (same index in each array)
                ImageIcon image = new ImageIcon(itemImages[i]);
                JMenuItem foodItem = new JMenuItem(menuItems[i], image);
                foodItem.addActionListener(this);
                // set mnemonic - first letter of the item name
                foodItem.setMnemonic(menuItems[i].charAt(0));
                foodItem.setAccelerator(getKeyStroke(VK_PLUS, 
                        Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
                allItems[i] = foodItem;
            }
        }
        
        menubar.add(produceMenu);
        
        menubar.add(produceMenu);        // add produce menu to menubar
        fruit.add(peach);
        produceMenu.add(fruit);          // add fruit submenu to produce
        produceMenu.add(farmersProduce); // add items to menu
        produceMenu.add(potato);
        produceMenu.add(green);
        produceMenu.add(tomato);
        heirlooms.add(tomSalad);         // adding items to submenus
        heirlooms.add(cherryTom);
        heirlooms.add(beefsteakTom);
        produceMenu.add(heirlooms);      // adding heirlooms as submenu of prod.
        

        
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
