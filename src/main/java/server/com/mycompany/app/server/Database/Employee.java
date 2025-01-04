package server.com.mycompany.app.server.Database;

import java.sql.Date;

public class Employee {
    private int EmployeeID;
    private String EmployeeName;
    private String EmployeeLastName;
    private String EmployeeNationality;
    private Date EmployeeBirth;
    private String EmployeePosition;



        private int employeeID;
        private String employeeName;
        private String employeeLastName;
        private String employeeNationality;
        private Date employeeBirth;
        private String employeePosition;

        // Constructor
        public Employee(int employeeID, String employeeName, String employeeLastName, String employeeNationality, Date employeeBirth, String employeePosition) {
            this.employeeID = employeeID;
            this.employeeName = employeeName;
            this.employeeLastName = employeeLastName;
            this.employeeNationality = employeeNationality;
            this.employeeBirth = employeeBirth;
            this.employeePosition = employeePosition;
        }

        // Getter and Setter methods

        public int getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeLastName() {
            return employeeLastName;
        }

        public void setEmployeeLastName(String employeeLastName) {
            this.employeeLastName = employeeLastName;
        }

        public String getEmployeeNationality() {
            return employeeNationality;
        }

        public void setEmployeeNationality(String employeeNationality) {
            this.employeeNationality = employeeNationality;
        }

        public Date getEmployeeBirth() {
            return employeeBirth;
        }

        public void setEmployeeBirth(Date employeeBirth) {
            this.employeeBirth = employeeBirth;
        }

        public String getEmployeePosition() {
            return employeePosition;
        }

        public void setEmployeePosition(String employeePosition) {
            this.employeePosition = employeePosition;
        }
}
