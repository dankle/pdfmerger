pdfmerger
=========

This application takes 4 pdf-files and merge them into on large concatenated.pdf file.

Standalone:
To run the standalone version, do the following:
1. Run mvn assembly:assembly
2. Goto \target\itextmerger-1.0-SNAPSHOT-standalone
3. Run runlocal.bat

Result: A concatenated.pdf will be created in \target\itextmerger-1.0-SNAPSHOT-standalone based
on the 4 files under \target\itextmerger-1.0-SNAPSHOT-standalone\pdfsToBeMerged

Eclipse project:
To run the eclipse project version, do the following:
1. Start eclipse
2. Import this project with "Existing Projects into Workspace"
3. Then run PdfMerger.java