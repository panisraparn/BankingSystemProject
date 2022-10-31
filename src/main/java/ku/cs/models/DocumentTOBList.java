package ku.cs.models;

import java.util.ArrayList;

public class DocumentTOBList {

    private ArrayList<DocumentTOB> documents;
    public DocumentTOBList() { documents = new ArrayList<>();}

    //เพิ่ม document
    public void addDocumentTrans(DocumentTOB document) {
        documents.add(document);
    }

    public String toCsv() {
        String result = "";
        for (DocumentTOB document : this.documents){
            result += document.toCsv() + "\n";
        }
        return result;
    }



}
