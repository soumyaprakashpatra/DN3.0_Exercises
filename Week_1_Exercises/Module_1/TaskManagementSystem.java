
class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// Singly Linked List class for managing tasks
public class TaskManagementSystem {
    private Node head;

    public TaskManagementSystem() {
        head = null;
    }

    // Add task to the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete task by ID
    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Task not found.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        TaskManagementSystem taskMgmt = new TaskManagementSystem();

        taskMgmt.addTask(new Task("T001", "Complete report", "Pending"));
        taskMgmt.addTask(new Task("T002", "Attend meeting", "In Progress"));
        taskMgmt.addTask(new Task("T003", "Update website", "Completed"));

        System.out.println("All Tasks:");
        taskMgmt.traverseTasks();

        System.out.println("\nSearching for task T002:");
        Task task = taskMgmt.searchTask("T002");
        System.out.println(task);

        System.out.println("\nDeleting task T001:");
        taskMgmt.deleteTask("T001");

        System.out.println("\nAll Tasks after deletion:");
        taskMgmt.traverseTasks();
    }
}
    // Step 4: Analysis
    // Time Complexity:
    // - Add Task: O(n) - Traverses to the end of the list.
    // - Search Task: O(n) - Linear search through the list.
    // - Traverse Tasks: O(n) - Visits each node once.
    // - Delete Task: O(n) - Linear search to find the task, then adjusts pointers.

    // Advantages of Linked Lists Over Arrays:
    // - Dynamic Size: Easily grows or shrinks with the number of tasks.
    // - Efficient Insertions/Deletions: Insertion and deletion are more efficient compared to arrays, especially when dealing with large datasets
