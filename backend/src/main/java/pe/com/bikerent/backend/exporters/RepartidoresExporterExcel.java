package pe.com.bikerent.backend.exporters;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Delivery;
public class RepartidoresExporterExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Delivery> deliverys;

    public RepartidoresExporterExcel(List<Delivery> deliverys) {
        this.deliverys = deliverys;
        this.workbook = new XSSFWorkbook();
    }
    public void createCell(Row row, int column, Object value, CellStyle style) {
        this.sheet.autoSizeColumn(column);
        Cell cell = row.createCell(column);
        if (value instanceof Integer) {
            cell.setCellValue((double)(Integer)value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double)value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean)value);
        } else if (value instanceof Long) {
            cell.setCellValue((double)(Long)value);
        } else {
            cell.setCellValue((String)value);
        }

        cell.setCellStyle(style);
    }
    public void writeHeaderLine() {
        Row row = this.sheet.createRow(0);
        CellStyle style = this.workbook.createCellStyle();
        XSSFFont font = this.workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14.0);
        style.setFont(font);
        this.createCell(row, 0, "Id", style);
        this.createCell(row, 1, "Dni", style);
        this.createCell(row, 2, "Nombre", style);
        this.createCell(row, 3, "Celular", style);
        this.createCell(row, 4, "Correo", style);
    }
    public void writeDataLines() {
        int rowCount = 1;
        CellStyle style = this.workbook.createCellStyle();
        XSSFFont font = this.workbook.createFont();
        font.setBold(false);
        font.setFontHeight(12.0);
        style.setFont(font);

        for(Iterator var5 = this.deliverys.iterator(); var5.hasNext(); ++rowCount) {
            Delivery delivery = (Delivery) var5.next();
            Row row = this.sheet.createRow(rowCount);
            int colCount = 0;
            this.createCell(row, colCount, delivery.getId().toString(), style);
            this.createCell(row, colCount + 1, delivery.getDni(), style);
            this.createCell(row, colCount + 2, delivery.getNombre(), style);
            this.createCell(row, colCount + 3, delivery.getCelular(), style);
            this.createCell(row, colCount + 4, delivery.getCorreo(), style);
        }
    }
    public void writeFooterLine() {
    }

    public void export(HttpServletResponse response) throws IOException {
        this.sheet = this.workbook.createSheet("Reporte");
        this.writeHeaderLine();
        this.writeDataLines();
        this.writeFooterLine();
        ServletOutputStream servletOutputStream = response.getOutputStream();
        this.workbook.write(servletOutputStream);
        this.workbook.close();
        servletOutputStream.close();
    }
}