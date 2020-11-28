package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import model.Table.Factura;

public class FacturaFormat {

    public static String setFactura(String nF, String folder, String nombreCliente, String numeroIdentificacion, String fcha, ArrayList<Factura> p) {
        try {

            String nombre = folder + nF + "-" + numeroIdentificacion + ".pdf";
            FileOutputStream archivo = new FileOutputStream(nombre);
            Document document = new Document();

            PdfWriter.getInstance(document, archivo);
            document.open();

            Paragraph numeroFactura = new Paragraph("Factura N." + nF);

            Paragraph fecha = new Paragraph("Fecha: " + Resource.transformFecha(fcha));
            PdfPTable encabezado = new PdfPTable(2);

            encabezado.addCell(numeroFactura);
            encabezado.addCell(fecha);

            PdfPTable datos = new PdfPTable(2);
            Paragraph empresa = new Paragraph("Empresa: MiniMarket.SA");
            Paragraph nit = new Paragraph("NIT: 1005649569");

            datos.addCell(empresa);
            datos.addCell(nit);

            datos.setSpacingBefore(10);

            Paragraph cliente = new Paragraph("Cliente: " + nombreCliente);
            Paragraph identificacion = new Paragraph("Identificacion: " + numeroIdentificacion);

            datos.addCell(cliente);
            datos.addCell(identificacion);

            datos.setSpacingAfter(10);

            PdfPTable detalleProductos = new PdfPTable(4);

            Paragraph cantidad = new Paragraph("Cantidad");
            Paragraph producto = new Paragraph("Producto");
            Paragraph precioUnidad = new Paragraph("Precio unidad");
            Paragraph precioTotal = new Paragraph("Precio total");

            detalleProductos.addCell(cantidad);
            detalleProductos.addCell(producto);
            detalleProductos.addCell(precioUnidad);
            detalleProductos.addCell(precioTotal);

            double t = 0;
            for (int i = 0; i < p.size(); i++) {
                cantidad = new Paragraph(p.get(i).getCantidad());
                producto = new Paragraph(p.get(i).getProducto());
                precioUnidad = new Paragraph(p.get(i).getPrecioUnidad());
                String pt = String.valueOf(Double.parseDouble(p.get(i).getCantidad()) * Double.parseDouble(p.get(i).getPrecioUnidad()));
                precioTotal = new Paragraph(pt);

                detalleProductos.addCell(cantidad);
                detalleProductos.addCell(producto);
                detalleProductos.addCell(precioUnidad);
                detalleProductos.addCell(precioTotal);

                t = Double.parseDouble(pt) + t;

            }

            PdfPTable footer = new PdfPTable(1);

            Paragraph total = new Paragraph("Precio total: " + t);

            total.setAlignment(2);
            footer.addCell(total);

            document.add(encabezado);
            document.add(datos);
            document.add(detalleProductos);
            document.add(footer);

            document.close();

            return nombre;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
