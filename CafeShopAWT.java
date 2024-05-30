import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CafeShopAWT extends Frame implements ActionListener {
    // Components
    Label lblHeader, lblItem, lblQuantity, lblTotal;
    TextField txtItem, txtQuantity, txtTotal;
    TextArea txtOrder;
    Button btnAdd, btnUpdate, btnDelete, btnCalculate, btnOrder;
    List menuList;

    // Data
    ArrayList<MenuItem> menu;

    // Constructor
    public CafeShopAWT() {
        // Initialize menu
        menu = new ArrayList<>();

        // Frame properties
        setTitle("Cafe Shop");
        setSize(600, 500);
        setLayout(new GridLayout(9, 2));

        // Components initialization
        lblHeader = new Label("Vive Cafe Shop Ordering System | SAMAYUN");
        lblItem = new Label("Item");
        lblQuantity = new Label("Quantity");
        lblTotal = new Label("Total:");
        
        txtItem = new TextField();
        txtQuantity = new TextField();
        txtTotal = new TextField();
        txtTotal.setEditable(false);
        txtOrder = new TextArea();
        txtOrder.setEditable(false);

        btnAdd = new Button("Add");
        btnUpdate = new Button("Update");
        btnDelete = new Button("Delete");
        btnCalculate = new Button("Calculate");
        btnOrder = new Button("Order");

        menuList = new List();

        // Adding components to the frame
        add(lblHeader);
        add(new Label());  // Placeholder for layout

        add(lblItem);
        add(txtItem);

        add(lblQuantity);
        add(txtQuantity);

        add(btnAdd);
        add(btnUpdate);

        add(btnDelete);
        add(menuList);

        add(lblTotal);
        add(txtTotal);

        add(btnCalculate);
        add(btnOrder);

        add(new Label("Order Details:"));
        add(txtOrder);

        // Adding action listeners
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnCalculate.addActionListener(this);
        btnOrder.addActionListener(this);
        menuList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                int index = menuList.getSelectedIndex();
                if (index != -1) {
                    MenuItem selectedItem = menu.get(index);
                    txtItem.setText(selectedItem.name);
                    txtQuantity.setText(String.valueOf(selectedItem.quantity));
                }
            }
        });

        // Frame close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            addItem();
        } else if (ae.getSource() == btnUpdate) {
            updateItem();
        } else if (ae.getSource() == btnDelete) {
            deleteItem();
        } else if (ae.getSource() == btnCalculate) {
            calculateTotal();
        } else if (ae.getSource() == btnOrder) {
            displayOrder();
        }
    }

    private void addItem() {
        String itemName = txtItem.getText();
        int itemQuantity = Integer.parseInt(txtQuantity.getText());
        MenuItem newItem = new MenuItem(itemName, itemQuantity);
        menu.add(newItem);
        menuList.add(itemName);
        clearFields();
    }

    private void updateItem() {
        int index = menuList.getSelectedIndex();
        if (index != -1) {
            MenuItem updatedItem = menu.get(index);
            updatedItem.name = txtItem.getText();
            updatedItem.quantity = Integer.parseInt(txtQuantity.getText());
            menuList.replaceItem(updatedItem.name, index);
            clearFields();
        }
    }

    private void deleteItem() {
        int index = menuList.getSelectedIndex();
        if (index != -1) {
            menu.remove(index);
            menuList.remove(index);
            clearFields();
        }
    }

    private void calculateTotal() {
        int total = 0;
        for (MenuItem item : menu) {
            total += item.quantity * 5;  // Assume each item costs 5 units
        }
        txtTotal.setText(String.valueOf(total));
    }

    private void displayOrder() {
        StringBuilder orderDetails = new StringBuilder("You ordered:\n");
        for (MenuItem item : menu) {
            orderDetails.append(item.quantity).append(" ").append(item.name).append("\n");
        }
        orderDetails.append("Total: ").append(txtTotal.getText());
        txtOrder.setText(orderDetails.toString());
    }

    private void clearFields() {
        txtItem.setText("");
        txtQuantity.setText("");
    }

    public static void main(String[] args) {
        new CafeShopAWT();
    }

    class MenuItem {
        String name;
        int quantity;

        MenuItem(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }
    }
}
