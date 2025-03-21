
    import java.util.ArrayDeque;
    import java.util.Scanner;
    
    public class OrderLogs {
        private ArrayDeque<String> orderLogs;
    
        public OrderLogs() {
            orderLogs = new ArrayDeque<>();
        }
    
        public void addOrderLog(String log) {
            orderLogs.push(log);
        }
    
        private void mostRecentLogEntry() {
            System.out.println("Most recent log entry: " + orderLogs.peek());
        }
    
        private String getOrderLog() {
            return orderLogs.pop();
        }
    
        private void removeAllLogEntries() {
            orderLogs.clear();
        }
    
        private boolean orderLogsEmpty() {
            return orderLogs.isEmpty();
        }
    
        private void displayOrderLogs() {
            if (orderLogs.isEmpty()) {
                System.out.println("No logs to display.");
                return;
            }
            System.out.println("All logs:");
            for (String log : orderLogs) {
                System.out.println(log);
            }
        }
    
        public void handleLogs() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nChoose what you want to do with order logs:");
                System.out.println("1. Display all the logs");
                System.out.println("2. Display the most recent log entry");
                System.out.println("3. Remove a log entry");
                System.out.println("4. Remove all log entries");
                System.out.println("5. Check if the log is completely empty");
                System.out.print("Enter your choice (1-5): ");
    
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
    
                switch (choice) {
                    case 1:
                        displayOrderLogs();
                        break;
                    case 2:
                        if (orderLogs.isEmpty()) {
                            System.out.println("The log is empty. No recent entry.");
                        } else {
                            mostRecentLogEntry();
                        }
                        break;
                    case 3:
                        if (orderLogs.isEmpty()) {
                            System.out.println("The log is empty. Cannot remove entry.");
                        } else {
                            String removedLog = getOrderLog();
                            System.out.println("Removed log: " + removedLog);
                        }
                        break;
                    case 4:
                        removeAllLogEntries();
                        System.out.println("All log entries have been removed.");
                        break;
                    case 5:
                        boolean isEmpty = orderLogsEmpty();
                        System.out.println(isEmpty ? "The log is completely empty" : "The log is not completely empty");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }
    }

