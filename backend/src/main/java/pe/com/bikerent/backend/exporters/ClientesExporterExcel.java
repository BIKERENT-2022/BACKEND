package pe.com.bikerent.backend.exporters;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pe.com.bikerent.backend.entities.Cliente;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ClientesExporterExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Cliente> clientes;

    public ClientesExporterExcel(List<Cliente> clientes) {
        this.clientes = clientes;
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
        this.createCell(row, 3, "Correo", style);
        this.createCell(row, 4, "Direccion", style);
        this.createCell(row, 5, "Telefono", style);
    }

    public void writeDataLines() {
        int rowCount = 1;
        CellStyle style = this.workbook.createCellStyle();
        XSSFFont font = this.workbook.createFont();
        font.setBold(false);
        font.setFontHeight(12.0);
        style.setFont(font);

        for(Iterator var6 = this.clientes.iterator(); var6.hasNext(); ++rowCount) {
            Cliente cliente = (Cliente) var6.next();
            Row row = this.sheet.createRow(rowCount);
            int colCount = 0;
            this.createCell(row, colCount, cliente.getId().toString(), style);
            this.createCell(row, colCount + 1, cliente.getDni(), style);
            this.createCell(row, colCount + 2, cliente.getNombre(), style);
            this.createCell(row, colCount + 3, cliente.getCorreo(), style);
            this.createCell(row, colCount + 4, cliente.getDireccion(), style);
            this.createCell(row, colCount + 5, cliente.getTelefono(), style);
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
