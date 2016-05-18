/*
 * CIS 36B: Price Checker
 * 
 * @author Jenny Hamer
 */
package pricechecker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PriceCheck2 implements ActionListener {
    // JMenuBar is the container for menus
    // [JMenuBar add(JMenu menu)] - use add() to add menus to JMenuBar
    // each menu will have menu items - JMenuItem - add()
    // add visual separators using addSeparator() or insertSeparator(int i)

    JLabel label;

    PriceCheck2() { // constructor --> create window, menubar, items,...

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

        JMenuItem[] menuItems = {new JMenuItem("Russet potatoes :: $0.50 / lb"),
            new JMenuItem("Mixed greens :: $1.00 / bag"),
            new JMenuItem("Farmer's Selection :: $2.75 / lb"),
            new JMenuItem("Coeur de boeuf tomatoes :: $3.00 / lb"),
            new JMenuItem("Assorted eirlooms :: $3.00 / lb"),
            new JMenuItem("Heirloom tomato salad :: $6.00 / lb "),
            new JMenuItem("Cherry tomatoes :: $3.00"),
            new JMenuItem("Peaches :: $3.50 / lb"),
            new JMenuItem("Whole milk :: $4.00 / gal"),
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
            new JMenuItem("Chocolate chip cookies :: $5.00 / dozen"),
            new JMenuItem("Golden Cake :: $3.00 / slice \n$12.00 / cake"),
            new JMenuItem("Dark chocolate :: $3.25 / bar"),
            new JMenuItem("Milk chocolate almonds :: $8.00 / lb"),
            new JMenuItem("Gummy bears :: $7.00 / lb"),
            new JMenuItem("Peach rings :: $7.50 / lb")};

//        if (menuItems.length == itemImages.length) {
        for (int i = 0; i < itemImages.length; i++) {
            // pairing each item with its image (same index in each array)
            menuItems[i].setIcon(itemImages[i]);
            String menuDescription = menuItems[i].getText();
            menuItems[i].setActionCommand(menuDescription);

            menuItems[i].addActionListener(this);
            //if (i <= 10 || i == 15) {
                // set mnemonic - first letter of the item name
                char letter = menuItems[i].getText().charAt(0);
                menuItems[i].setMnemonic(letter);
                // underline the first letter of the item name
                menuItems[i].setDisplayedMnemonicIndex(0);
            //}
        }

        menuItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                InputEvent.CTRL_DOWN_MASK));
        menuItems[9].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                InputEvent.CTRL_DOWN_MASK));
        menuItems[13].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                InputEvent.CTRL_DOWN_MASK));
        menuItems[15].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
                InputEvent.CTRL_DOWN_MASK));
        menuItems[21].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
                InputEvent.CTRL_DOWN_MASK));
        menuItems[28].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                InputEvent.CTRL_DOWN_MASK));

        // painfully add individual items to their corresponding submenus
        int itemIdNo;
        // add the first 7 items (allItems[0 - 6] to the "Veggies" submenu
        for (itemIdNo = 0; itemIdNo < 7; itemIdNo++) {
            subMenus[0].add(menuItems[itemIdNo]);
        }
        subMenus[1].add(menuItems[7]); // add "Peaches" to submenu "Fruit"
        // add "Veggies" & "Fruit" to "Produce"
        mainMenus[0].add(subMenus[0]);
        mainMenus[0].add(subMenus[1]);

        // add "Milk" to submenu "Breakfast"
        subMenus[2].add(menuItems[8]);
        subMenus[2].add(menuItems[9]);
        // add 3 Cheeses to submenu "Cheese"
        for (itemIdNo = 10; itemIdNo < 13; itemIdNo++) {
            subMenus[3].add(menuItems[itemIdNo]);
        }

        // add "Breakfast" & "Cheese" to "Dairy"
        mainMenus[1].add(subMenus[2]);
        mainMenus[1].add(subMenus[3]);

        // add 3 Meats to "Meat"
        for (itemIdNo = 14; itemIdNo < 17; itemIdNo++) {
            subMenus[4].add(menuItems[itemIdNo]);
        }
        // add "Salmon" & "Mackerel" to "Fish" submenu
        subMenus[5].add(menuItems[17]);
        subMenus[5].add(menuItems[18]);
        // add submenus "Meat" & "Fish" to the "Protein" category, followed by
        // the item "Farm Eggs"
        mainMenus[2].add(subMenus[4]);
        mainMenus[2].add(subMenus[5]);
        mainMenus[2].add(menuItems[13]);

        // add items 1-by-1 to the "Pantry" & "Fridge" submenus, then add those
        // submenus to the "Essential Fats" category
        subMenus[6].add(menuItems[19]);
        subMenus[6].add(menuItems[20]);
        subMenus[7].add(menuItems[21]);
        subMenus[7].add(menuItems[22]);
        mainMenus[3].add(subMenus[6]);
        mainMenus[3].add(subMenus[7]);

        // add items "Butter biscuits" & "Cake to "Sweet Treats", then 
        // add chocolates & gummy items to "Chocolate" & "Gummies" submenus
        // then add "Chocolate" & "Gummies" to the "Sweet Treats" category
        mainMenus[4].add(menuItems[23]);
        mainMenus[4].add(menuItems[24]);
        subMenus[8].add(menuItems[25]);
        subMenus[8].add(menuItems[26]);
        subMenus[9].add(menuItems[27]);
        subMenus[9].add(menuItems[28]);
        mainMenus[4].add(subMenus[8]);
        mainMenus[4].add(subMenus[9]);

        // add the menu "categories" to the menubar
        for (int menuCount = 0; menuCount < mainMenus.length; menuCount++) {
            menubar.add(mainMenus[menuCount]);
        }

        // add label to the frame
        frame.add(label);
        // add menubar to the JFrame
        frame.setJMenuBar(menubar);
        // make the frame visible!
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String which = ae.getActionCommand();
        label.setText("You selected: \n" + which);
// display info for the various items available: name, price
/*        double price = 0.50;
        int item;
        if (which.equals("Farm Eggs") || which.equals("Butter Biscuits")) {
            label.setText("You selected " + which + ". $4.00 / dozen");
        } 
        else if (which.equals("Cake")) {
            label.setText("You selected " + which + ". $3.00 / slice ::or::\n$12.00 / entire cake");
        }
        else if (which.equals("Potatoes")) {
            label.setText("You selected " + which + ". $0.50 / lb");
            } 
                label.setText("You selected " + which + ". $" + (price * item) + " / lb");
            
        }
         */

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PriceCheck2();
            }
        });
    }
}
