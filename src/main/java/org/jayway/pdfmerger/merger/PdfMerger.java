package org.jayway.pdfmerger.merger;
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
 
public class PdfMerger {
 
    /** The resulting PDF file. */
    public static final String RESULT = "./concatenated.pdf";
    
    public static final String PDF_21x40 = "PAGE1_21x40.pdf";
    public static final String PDF_21x55 = "PAGE2_21x55.pdf";
    public static final String PDF_21x10 = "PAGE3_21x10.pdf";
    public static final String PDF_21x20 = "PAGE4_21x20.pdf";
    
    
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     * @throws SQLException
     */
    public static void main(String[] args)
        throws IOException, DocumentException, SQLException {
        // using previous examples to create PDFs
    	
    	String[] files = { PDF_21x40, PDF_21x55, PDF_21x10, PDF_21x20 };
        // step 1
        Document document = new Document();
        // step 2
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        PdfReader reader;
        int n;
        // loop over the documents you want to concatenate
        for (int i = 0; i < files.length; i++) {
            reader = new PdfReader(files[i]);
            // loop over the pages in that document
            n = reader.getNumberOfPages();
            for (int page = 0; page < n; ) {
                copy.addPage(copy.getImportedPage(reader, ++page));
            }
            copy.freeReader(reader);
            reader.close();
        }
        // step 5
        document.close();
    }
}