import com.company.analytics.sales.SalesReport;
import com.company.analytics.hr.EmployeeReport;

public class CompanyAnalyticsMain {
    public static void main(String[] args) {
        System.out.println("========== COMPANY COMBINED REPORT ==========\n");
        
        SalesReport salesReport = new SalesReport();
        salesReport.printRegionWiseSalesData();
        
        System.out.println();
        
        EmployeeReport employeeReport = new EmployeeReport();
        employeeReport.printEmployeePerformanceData();
        
        System.out.println("\n============================================");
    }
}
