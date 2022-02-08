package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import android.widget.Button;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;


import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static android.icu.text.DateFormat.YEAR_MONTH;

public class MainActivity extends AppCompatActivity {

    private static Document document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        //合并pdf生成的文件名
        String destinationFileName =new Date().getTime()+".pdf";

        //这是需要合并的PDF文件

        String filePath = "pdf";
        //合并后pdf存放路径
        String bothPath =  "/";
        String viewPath = "/";
        File file3 = new File(bothPath);
        try{
            if(!file3.exists()){
                file3.mkdirs();
            }
        }catch(Exception e){

        }
        mergePdf.addSource(filePath );
        //设置合并生成pdf文件名称
        mergePdf.setDestinationFileName(bothPath + viewPath + File.separator + destinationFileName);
        //合并pdf
        try {
            try {
                mergePdf.mergeDocuments();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
        System.out.println("pdf文件合并成功");
    }

}
