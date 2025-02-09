/**
 * 
 * I declare that this code was written by me, lucas. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lucas
 * Student ID: 22026220
 * Class: E63C
 * Date created: 2023-10-25, 09:01AM
 * 
 */
package FYPproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/excel")
public class FileController {

    @Autowired
    private excelService excelService;

    @Value("${upload.dir}")
    private String uploadDir;

    private List<String> uploadedFiles = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        // Refresh the file list from the directory every time the page is loaded
        List<String> files = Arrays.asList(new File(uploadDir).list());
        model.addAttribute("files", files); // Add list of files to the model
        return "index"; // Load the combined upload and file list view
    }

    @PostMapping("/files/save")
    public String saveFile(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                // Ensure the upload directory exists
                File uploadDirectory = new File(uploadDir);
                if (!uploadDirectory.exists()) {
                    boolean created = uploadDirectory.mkdirs(); // Create directory if it doesn't exist
                    if (!created) {
                        throw new IOException("Failed to create upload directory.");
                    }
                }

                // Save the uploaded file
                File dest = new File(uploadDir, file.getOriginalFilename());
                file.transferTo(dest);

                // Automatically process the Excel file after upload
                excelService.saveExcelData(dest.getAbsolutePath());

                // Refresh the file list after upload
                List<String> files = Arrays.asList(new File(uploadDir).list());
                model.addAttribute("files", files); // Add the files to the model

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/"; // Redirect back to the homepage
    }

    @PostMapping("/delete")
    public String deleteFile(@RequestParam("fileName") String fileName, Model model) {
        try {
            Path filePath = Paths.get(uploadDir, fileName);
            Files.deleteIfExists(filePath);

            // Refresh the file list after deletion
            List<String> files = Arrays.asList(new File(uploadDir).list());
            model.addAttribute("files", files); // Add the files to the model

            return "index"; // Redirect to the homepage (or reload the same page)
        } catch (IOException e) {
            model.addAttribute("message", "File deletion failed: " + e.getMessage());
            return "index";
        }
    }

    @GetMapping("/files/{fileName}")
    public ResponseEntity<byte[]> serveFile(@PathVariable("fileName") String fileName) {
        try {
            Path filePath = Paths.get(uploadDir, fileName);
            if (Files.exists(filePath)) {
                byte[] fileContent = Files.readAllBytes(filePath);

                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");

                return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
