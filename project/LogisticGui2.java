import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

// Interface
interface Trackable {
    void updateStatus(String newStatus);
    void displayDetails();
}

// Custom Exception
class InvalidTrackingIdException extends Exception {
    public InvalidTrackingIdException(String msg) {
        super(msg);
    }
}

// Shipment Class
class Shipment implements Trackable {
    private final String trackingId;
    private final String sender;
    private final String receiver;
    private String status;
    private final Double weight;
    private final Double cost;

    public Shipment(String sender, String receiver, Double weight) {
        this.trackingId = generateTrackingId();
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.status = "Processing";
        this.cost = weight * 40;
    }

    public Shipment(String trackingId, String sender, String receiver, Double weight, Double cost, String status) {
        this.trackingId = trackingId;
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.cost = cost;
        this.status = status;
    }

    private String generateTrackingId() {
        return "TRK" + (new Random().nextInt(9000) + 1000);
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getStatus() {
        return status;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getCost() {
        return cost;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    @Override
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public void displayDetails() {
        JOptionPane.showMessageDialog(null,
                "Tracking ID: " + trackingId +
                        "\nSender: " + sender +
                        "\nReceiver: " + receiver +
                        "\nWeight: " + weight + "kg" +
                        "\nCost: ₹" + cost +
                        "\nStatus: " + status);
    }
}

// JDBC Handler
class DatabaseManager {
    private final String URL = "jdbc:mysql://localhost:3306/logistics";
    private final String USER = "root"; // ✅ Change this
    private final String PASS = "1246";  

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void insertShipment(Shipment s) {
        String query = "INSERT INTO shipments VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, s.getTrackingId());
            stmt.setString(2, s.getSender());
            stmt.setString(3, s.getReceiver());
            stmt.setDouble(4, s.getWeight());
            stmt.setDouble(5, s.getCost());
            stmt.setString(6, s.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Shipment getShipmentById(String trackingId) {
        String query = "SELECT * FROM shipments WHERE tracking_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, trackingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Shipment(
                        rs.getString("tracking_id"),
                        rs.getString("sender"),
                        rs.getString("receiver"),
                        rs.getDouble("weight"),
                        rs.getDouble("cost"),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateStatus(String trackingId, String newStatus) {
        String query = "UPDATE shipments SET status = ? WHERE tracking_id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newStatus);
            stmt.setString(2, trackingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Shipment> loadAllShipments() {
        HashMap<String, Shipment> map = new HashMap<>();
        String query = "SELECT * FROM shipments";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Shipment s = new Shipment(
                        rs.getString("tracking_id"),
                        rs.getString("sender"),
                        rs.getString("receiver"),
                        rs.getDouble("weight"),
                        rs.getDouble("cost"),
                        rs.getString("status"));
                map.put(s.getTrackingId(), s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}

// Thread to simulate shipment movement
class ShipmentThread extends Thread {
    Shipment shipment;
    LogisticsService service;

    public ShipmentThread(Shipment s, LogisticsService service) {
        this.shipment = s;
        this.service = service;
    }

    public void run() {
        try {
            Thread.sleep(3000);
            shipment.updateStatus("In Transit");
            service.updateStatus(shipment.getTrackingId(), "In Transit");

            Thread.sleep(3000);
            shipment.updateStatus("Delivered");
            service.updateStatus(shipment.getTrackingId(), "Delivered");
        } catch (InterruptedException | InvalidTrackingIdException e) {
            e.printStackTrace();
        }
    }
}

// Service Layer
class LogisticsService {
    private final HashMap<String, Shipment> shipmentMap = new HashMap<>();
    private final DatabaseManager db = new DatabaseManager();

    public LogisticsService() {
        shipmentMap.putAll(db.loadAllShipments());
    }

    public void addShipment(Shipment s) {
        shipmentMap.put(s.getTrackingId(), s);
        db.insertShipment(s);
        new ShipmentThread(s, this).start();
        JOptionPane.showMessageDialog(null, "Shipment Added!\nTracking ID: " + s.getTrackingId());
    }

    public void trackShipment(String trackingId) throws InvalidTrackingIdException {
        Shipment s = shipmentMap.get(trackingId);
        if (s != null) s.displayDetails();
        else throw new InvalidTrackingIdException("Tracking ID not found!");
    }

    public void updateStatus(String trackingId, String newStatus) throws InvalidTrackingIdException {
        Shipment s = shipmentMap.get(trackingId);
        if (s != null) {
            s.updateStatus(newStatus);
            db.updateStatus(trackingId, newStatus);
        } else {
            throw new InvalidTrackingIdException("Tracking ID not found!");
        }
    }
}

// Main GUI
public class LogisticGui2 {
    private static final LogisticsService service = new LogisticsService();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Logistics and Supply Chain Management");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel title = new JLabel("Logistics and Supply Chain Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setBackground(new Color(0, 102, 204));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(title, BorderLayout.NORTH);

        // Center panel with buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));
        buttonPanel.setBackground(new Color(230, 240, 255)); // Light blue

        JButton addBtn = new JButton("Add Shipment");
        JButton trackBtn = new JButton("Track Shipment");
        JButton updateBtn = new JButton("Update Shipment Status");
        JButton exitBtn = new JButton("Exit");

        Font btnFont = new Font("Verdana", Font.PLAIN, 16);
        Color btnColor = new Color(51, 153, 255);
        JButton[] buttons = {addBtn, trackBtn, updateBtn, exitBtn};
        for (JButton btn : buttons) {
            btn.setFont(btnFont);
            btn.setBackground(btnColor);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            buttonPanel.add(btn);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().setBackground(new Color(204, 229, 255)); // Light background

        // Functional Actions
        addBtn.addActionListener(e -> {
            String sender = JOptionPane.showInputDialog("Enter Sender Name:");
            String receiver = JOptionPane.showInputDialog("Enter Receiver Name:");
            try {
                Double weight = Double.valueOf(JOptionPane.showInputDialog("Enter Weight (kg):"));
                Shipment s = new Shipment(sender, receiver, weight);
                service.addShipment(s);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid weight format.");
            }
        });

        trackBtn.addActionListener(e -> {
            String trackingId = JOptionPane.showInputDialog("Enter Tracking ID:");
            try {
                service.trackShipment(trackingId);
            } catch (InvalidTrackingIdException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        updateBtn.addActionListener(e -> {
            String trackingId = JOptionPane.showInputDialog("Enter Tracking ID:");
            String status = JOptionPane.showInputDialog("Enter New Status:");
            try {
                service.updateStatus(trackingId, status);
                JOptionPane.showMessageDialog(null, "Status Updated Successfully!");
            } catch (InvalidTrackingIdException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Thank you for using the system!");
            System.exit(0);
        });

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
