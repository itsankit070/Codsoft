import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Contact implements Serializable {
    private String Name;
    private String MobNum;
    private String EmailAdd;

    public Contact(String Name, String MobNum, String EmailAdd) {
        this.Name = Name;
        this.MobNum = MobNum;
        this.EmailAdd = EmailAdd;
    }
    public String getName() {
        return Name;
    }
    public String getMobNum() {
        return MobNum;
    }
    public String getEmailAdd() {
        return EmailAdd;
    }

    @Override
    public String toString() {
        return "Name: " + Name + "\nPhone Number: " + MobNum + "\nEmail Address: " + EmailAdd;
    }
}
class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String Name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(Name));
    }

    public List<Contact> searchContact(String query) {
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(query.toLowerCase()) ||
                    contact.getMobNum().contains(query) ||
                    contact.getEmailAdd().toLowerCase().contains(query.toLowerCase())) {
                result.add(contact);
            }
        }
        return result;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

public class task5{
    private AddressBook addressBook;
    private JFrame frame;
    private JList<Contact> contactList;
    private DefaultListModel<Contact> contactListModel;

    public task5() {
        addressBook = new AddressBook();
        frame = new JFrame("Address Book System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        contactListModel = new DefaultListModel<>();
        contactList = new JList<>(contactListModel);

        JScrollPane scrollPane = new JScrollPane(contactList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Contact");
        JButton removeButton = new JButton("Remove Contact");
        JButton searchButton = new JButton("Search Contact");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeContact();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });

        frame.setVisible(true);
    }
    private void addContact() {
        String Name = JOptionPane.showInputDialog(frame, "Enter Name:");
        String MobNum = JOptionPane.showInputDialog(frame, "Enter Phone Number:");
        String EmailAdd = JOptionPane.showInputDialog(frame, "Enter Email Address:");

        if (Name != null && !Name.isEmpty()) {
            Contact contact = new Contact(Name, MobNum, EmailAdd);
            addressBook.addContact(contact);
            contactListModel.addElement(contact);
        }
    }
    private void removeContact() {
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
            Contact selectedContact = contactListModel.getElementAt(selectedIndex);
            String Name = selectedContact.getName();
            addressBook.removeContact(Name);
            contactListModel.remove(selectedIndex);
        }
    }

    private void searchContact() {
        String query = JOptionPane.showInputDialog(frame, "Enter search query:");
        if (query != null) {
            contactListModel.clear();
            List<Contact> searchResults = addressBook.searchContact(query);
            for (Contact contact : searchResults) {
                contactListModel.addElement(contact);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new task5());
    }
}

