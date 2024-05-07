package StudentDetails;

import java.util.*;
import java.util.Scanner;

class StudentDetails {
  String name;
  String email;
  String phone;
  int RollNo;
  String stream;
  String year;

  StudentDetails(String name, String email, String phone, int RollNo, String stream, String year) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.RollNo = RollNo;
    this.stream = stream;
    this.year = year;
  }

  public String toString() {
    return "Name: " + name + ", Email: " + email + ", Phone: " + phone + ", RollNo: " + RollNo + ", Stream: " + stream
        + ", Year: " + year;
  }
}

class Node {
  StudentDetails details;
  Node next;

  Node(StudentDetails details) {
    this.details = details;
    this.next = null;
  }
}

public class StudentDetailsManager {
  private Node head;

  public void addStudentDetails(StudentDetails details) {
    Node newNode = new Node(details);
    newNode.next = head;
    head = newNode;
    System.out.println("StudentDetails added successfully.");
  }

  public void deleteStudentDetails(String name) {
    Node curr = head, prev = null;
    while (curr != null && !curr.details.name.equalsIgnoreCase(name)) {
      prev = curr;
      curr = curr.next;
    }
    if (curr != null) {
      if (prev != null)
        prev.next = curr.next;
      else
        head = curr.next;
      System.out.println("StudentDetails deleted successfully.");
    } else {
      System.out.println("StudentDetails not found.");
    }
  }

  public void searchStudentDetails(String name) {
    Node curr = head;
    boolean found = false;
    while (curr != null) {
      if (curr.details.name.equalsIgnoreCase(name)) {
        System.out.println("StudentDetails found: " + curr.details);
        found = true;
        break;
      }
      curr = curr.next;
    }
    if (!found) {
      System.out.println("StudentDetails not found.");
    }
  }

  public void displayStudentDetails() {
    Node curr = head;
    System.out.println("StudentDetails");
    while (curr != null) {
      System.out.println(curr.details);
      curr = curr.next;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StudentDetailsManager manager = new StudentDetailsManager();
    int choice;
    do {
      System.out.println("\nMenu:");
      System.out.println("1. Add StudentDetails");
      System.out.println("2. Delete StudentDetails");
      System.out.println("3. Search StudentDetails");
      System.out.println("4. Display All StudentDetails");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          System.out.print("Enter name: ");
          String studentName = scanner.nextLine();
          System.out.print("Enter email: ");
          String email = scanner.nextLine();
          System.out.print("Enter phone: ");
          String phone = scanner.nextLine();
          System.out.print("Enter RollNo: ");
          int rollNo = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Enter stream: ");
          String stream = scanner.nextLine();
          System.out.print("Enter year: ");
          String year = scanner.nextLine();
          manager.addStudentDetails(new StudentDetails(studentName, email, phone, rollNo, stream, year));
          break;

        case 2:
          System.out.print("Enter name to delete: ");
          String deleteName = scanner.nextLine();
          manager.deleteStudentDetails(deleteName);
          break;
        case 3:
          System.out.print("Enter name to search: ");
          String searchName = scanner.nextLine();
          manager.searchStudentDetails(searchName);
          break;
        case 4:
          manager.displayStudentDetails();
          break;
        case 5:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 5);
    scanner.close();
  }
}
